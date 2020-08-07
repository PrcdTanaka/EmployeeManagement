package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class Personal_informationAction extends Action {

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	/**
	 * <p>
	 * メイン画面アクションの初期設定を行う。
	 * </p>
	 *
	 * 1.初期設定を行う。<br>
	 * 　1-1.DB接続クラスのインスタンスを生成する。<br>
	 * 　1-2.遷移先<br>
	 * 　　遷移先：""<br>
	 * 2.例外発生時の処理。<br>
	 * 　2-1.IOExceptionをthrowする。<br>
	 * <br>
	 *
	 * @throws IOException
	 *             -
	 */
	public Personal_informationAction() throws IOException {

	}

	/**
	 * <p>
	 * クリックされたボタンを判定し、遷移先情報を返却する。
	 * </p>
	 *
	 * 1.個人情報入力画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。<br>
	 * <br>
	 * 2.クリックされたボタンの名称をアクションフォームから取得する。<br>
	 * 　2-1.ボタン名称取得処理をコール。<br>
	 * 　　クラス　：Personal_informationForm<br>
	 * 　　メソッド：getButton()<br>
	 * <br>
	 * 3.押下されたボタンを判定してそれぞれの処理をコール。<br>
	 * 　3-1.登録ボタンが押された場合。<br>
	 * 　　3-1-1.登録ボタン押下処理をコール。<br>
	 * 　　　クラス　：Personal_informationAction<br>
	 * 　　　メソッド：clickBtnEntry()<br>
	 * 　　　　引数１：個人情報入力画面アクションフォーム<br>
	 * 　3-2.確認ボタンが押された場合。<br>
	 * 　　3-2-1.確認ボタン押下処理をコール。<br>
	 * 　　　クラス　：Personal_informationAction<br>
	 * 　　　メソッド：clickBtnConf()<br>
	 * 　　　　引数１：個人情報入力画面アクションフォーム<br>
	 * 　3-3.戻るボタンが押された場合。<br>
	 * 　　3-3-1.戻るボタン押下処理をコール。<br>
	 * 　　　クラス　：Personal_informationAction<br>
	 * 　　　メソッド：clickBtnBack()<br>
	 * 　　　　引数１：個人情報入力画面アクションフォーム<br>
	 * <br>
	 * 4.遷移先を設定する。<br>
	 * 　　遷移先：各ボタン押下処理の戻り値<br>
	 * <br>
	 * 5.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
	 * 　6-1.リクエスト情報登録処理をコール。<br>
	 * 　　クラス　：HttpServletRequest<br>
	 * 　　メソッド：setAttribute()<br>
	 * 　　　引数１："pForm"<br>
	 * 　　　引数２：個人情報入力画面アクションフォーム<br>
	 * <br>
	 * 7.戻り値を返却する。<br>
	 * 　7-1.遷移先情報取得処理をコール。<br>
	 * 　　クラス　：ActionMapping<br>
	 * 　　メソッド：findForward(遷移先)<br>
	 * <br>
	 *
	 * @param map
	 *            map アクションマッピング<br>
	 *            frm アクションフォーム<br>
	 *            request リクエスト情報<br>
	 *            response レスポンス情報<br>
	 * @return 遷移先情報
	 *
	 */
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		String Button;

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// ログインセッションの呼び出し
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");

		// フォーム情報の呼び出し
		Personal_informationForm pForm = (Personal_informationForm) frm;
		//マネージャーでの呼び出し時のみ呼ばれます。
		try{
			Personal_informationForm rForm = (Personal_informationForm)session.getAttribute("rForm");
			pForm.setEmployee_no(rForm.getEmployee_no());
		}catch(Exception e)
		{
			// ログインユーザの社員番号取得
			pForm.setEmployee_no(lForm.getEmployee_no());
		}



		try{
			Button = pForm.getButton();
			if(Button == null)
				Button = "";
		} catch(NullPointerException e){
			Button = "";
			e.printStackTrace();
		}

		switch (Button) {
		case "登録":
			forward = clickBtnEntry(pForm,lForm);
			session.removeAttribute("sForm");
			break;
		case "戻る":
			forward = clickBtnBack(pForm);
			session.removeAttribute("rForm");
			session.removeAttribute("sForm");
			break;
		case "":
			forward = "password";
			break;
		}

		return map.findForward(forward);
	}






	/**
	 * <p>
	 * 登録ボタン押下メソッド
	 * </p>
	 * 1.氏名空白チェック<br>
	 * 　1-1.空白の場合<br>
	 * 　　1-1-1.エラーメッセージを設定する。<br>
	 * 2.空白でない場合<br>
	 * 　2-1.DB登録<br>
	 * 3.遷移先の設定<br>
	 * 　遷移先：同じページ<br>
	 * 4.遷移先返却<br>
	 *
	 *
	 * @param form
	 *            メイン画面アクションフォーム
	 * @return 遷移先
	 */
	private String clickBtnEntry(Personal_informationForm form, LoginForm login) {

		if(form.getEmployee_name() == null){
			form.setMessage("氏名を入力して下さい。");
		} else {
			int no;
			//入社年月日登録
			dba.setHire_date(form);
			for(no = 1; no <= 5; no++) {
				// 緊急連絡先テーブルに社員番号とNoの組み合わせが存在しているかの確認。
				if(dba.getEmployee_no(form, "EMERGENCY_CONTACT_TBL", no)) {
					// 社員番号が存在している場合
					dba.setEmergencyContactU(form, no);
				} else {
					// 社員番号が存在しない場合
					dba.setEmergencyContactI(form, no);
				}

				// 家族構成テーブルに社員番号とNoの組み合わせが存在しているかの確認。
				if(dba.getEmployee_no(form, "FAMILY_STRUCTURE_TBL", no)) {
					// 社員番号が存在している場合
					dba.setFamilyStructureU(form, no);
				} else {
					// 社員番号が存在しない場合
					dba.setFamilyStructureI(form, no);
				}

			}
			//管理者の場合、確認書類を登録する。
			if(login.getManager().equals(1))
				dba.setConfirm(form);
			dba.setPersonalData(form);
		}

		if(login.getEmployee_no()==form.getEmployee_no())
			forward = "pInfo";
		else
			forward = "search";

		return forward;
	}
	private String clickBtnBack(Personal_informationForm form) {
		System.out.println("clickBtnBackメソッドが呼ばれました");
		forward = "main";
		return forward;
	}
}

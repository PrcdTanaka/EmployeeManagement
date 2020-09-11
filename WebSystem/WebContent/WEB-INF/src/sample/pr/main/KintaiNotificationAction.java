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

public final class KintaiNotificationAction extends Action {

	// DB接続用オブジェクト
	//private DbAction dba = new DbAction();

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
	public KintaiNotificationAction() throws IOException {

	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// 1.ログイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。
		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		KintaiNotificationForm KNForm = (KintaiNotificationForm) frm;



		/*
		 * 3.社員Noの入力チェック<br>
		 * 　3-1.社員No取得処理をコール。<br>
		 * 　　　クラス：LoginForm<br>
		 * 　　メソッド：getEmployee_no<br>
		 * 　3-2.社員Noが空白の場合。<br>
		 * 　　3-2-1.メッセージの設定。<br>
		 * 　　　メッセージ：「社員番号が空白になっています。」<br>
		 * 　　3-2-2.遷移先設定_ログイン画面<br>
		 * 　　　遷移先："login"<br>
		 */

		//チェック要の項目を変数に格納する。
		String employee_no = KNForm.getEmployee_no();
		String petition_ymd = KNForm.getPetition_ymd();
		String b=KNForm.getButton();
		if (employee_no.equals("")) {
			KNForm.setMessage("社員番号が空白になっています。");
			forward = "login";
		}
		else if(petition_ymd.equals("")){
			KNForm.setMessage("申請日が空白になっています。");
		}

		/* 8.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
		 * 　8-1.リクエスト情報登録処理をコール。<br>
		 * 　　　クラス：HttpServletRequest<br>
		 * 　　メソッド：setAttribute()<br>
		 * 　　　引数１："form"<br>
		 * 　　　引数２：メイン画面アクションフォーム<br>
		 */
		request.setAttribute("form", KNForm);


		HttpSession session = request.getSession();

		session.setAttribute("form", KNForm);

		if(forward.equals("login")){
//			JOptionPane.showMessageDialog(null,KNForm.getMessage());
		}
		/* 9.戻り値を返却する。<br>
		 * 　9-1.遷移先情報取得処理をコール。<br>
		 * 　　クラス　：ActionMapping<br>
		 * 　　メソッド：findForward(遷移先)<br>
		 */
		return map.findForward(forward);
	}
}

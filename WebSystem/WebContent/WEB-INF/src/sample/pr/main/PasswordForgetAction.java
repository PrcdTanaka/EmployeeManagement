package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class PasswordForgetAction extends Action {


	/**
	 * <p>
	 * パスワード変更画面アクションの初期設定を行う。
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
	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public PasswordForgetAction() throws IOException {
	}

	/**
	 * <p>
	 * クリックされたボタンを判定し、遷移先情報を返却する。
	 * </p>
	 *
	 * 1.メイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。<br>
	 * <br>
	 * 2.クリックされたボタンの名称をアクションフォームから取得する。<br>
	 * 　2-1.ボタン名称取得処理をコール。<br>
	 * 　　クラス　：MainForm<br>
	 * 　　メソッド：getButton()<br>
	 * <br>
	 * 3.社員名を取得する。<br>
	 * 　3-1.社員名取得処理をコール。<br>
	 * 　　クラス　：DbAction<br>
	 * 　　メソッド：getSyainName()<br>
	 * 　　　引数１：メイン画面アクションフォーム<br>
	 * <br>
	 * 　　4-1.戻るボタン押下処理をコール。<br>
	 * 　　　クラス　：MainAction<br>
	 * 　　　メソッド：clickBtnOut()<br>
	 * 　　　　引数１：メイン画面アクションフォーム<br>
	 * 　　4-1-2変更ボタン押下処理をコール。
	 * 　　　クラス　：Chennge<br>
	 * 　　　メソッド：clickBtnOut()
	 * 　　　　引数：メイン画面アクションフォーム
	 * 　4-2.遷移先を設定する。<br>
	 * 　　遷移先：各ボタン押下処理の戻り値<br>
	 * <br>
	 * 6.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
	 * 　6-1.リクエスト情報登録処理をコール。<br>
	 * 　　クラス　：HttpServletRequest<br>
	 * 　　メソッド：setAttribute()<br>
	 * 　　　引数１："form"<br>
	 * 　　　引数２：メイン画面アクションフォーム<br>
	 * <br>
	 * 7.戻り値を返却する。<br>
	 * 　7-1.遷移先情報取得処理をコール。<br>
	 * 　　クラス　：ActionMapping<br>
	 * 　　メソッド：findForward(遷移先)<br>
	 * <br>
	 *
	 * @param map
	 *            アクションマッピング<br>
	 *            frm アクションフォーム<br>
	 *            request リクエスト情報<br>
	 *            response レスポンス情報<br>
	 * @return 遷移先情報
	 *
	 */
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		Personal_informationForm piForm =new Personal_informationForm();
		PasswordForm pForm = (PasswordForm) frm;
		LoginForm lForm=(LoginForm) session.getAttribute("form");
		piForm.setEmployee_no(lForm.getEmployee_no());
		try {
			dba.getPersonalData(piForm);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		pForm.setEmployee_no(lForm.getEmployee_no());

		String button = pForm.getButton();
		if(button.equals("戻る")) {
			forward = "login";
		}if(button.equals("次へ")){
				//入力された回答の空白判定
			if(pForm.getMyanswer()==null){
				piForm.setMessage("回答を入力してください。");
				forward ="change";
			}else{
				// DBに格納された質問と入力された質問取得処理
				dba.getQuestion(pForm);

			//DB回答＝自分の回答　　　　DB質問＝自分の質問
			//DBに格納された質問と入力された回答比較処理
				if(pForm.getAnswer().equals(pForm.getMyanswer())&&pForm.getQuestion().equals(pForm.getMyquestion())){
					forward="change";
				}else{
					pForm.setMessage("入力された回答が不正です。");
					forward="change";
				}
			}
		}
		return map.findForward(forward);
	}

	/***
	 * <p>
	 * 入力された情報からパスワードの変更を行う。
	 * </p>
	 * 1.社員番号の取得<br>
	 * 　1-1.社員番号のチェック<br>
	 * 　　クラス　：RegisterAction<br>
	 * 　　メソッド：checkPattern()<br>
	 * 　　引数１　：アクションフォーム.getEmployee_no()<br>
	 * 　　引数２　："Employee_no"<br>
	 * 　　1-1-1.チェックで不正と判定された場合<br>
	 * 　　　1-1-1-1.エラーメッセージの設定。<br>
	 * 　　　　クラス　：RegisterForm<br>
	 * 　　　　メソッド：setMessage()<br>
	 * 　　　　引数　　："パスワードが不正です。"<br>
	 * 　1-2.社員番号の検索<br>
	 * 　　クラス　：DbAction<br>
	 * 　　メソッド：confirmationNo()<br>
	 * 　　引数　　：ユーザ登録画面アクションフォーム<br>
	 * 2.社員番号が既に存在している場合。<br>
	 * 　2-1.エラーメッセージの設定。<br>
	 * 　　クラス　：RegisterForm<br>
	 * 　　メソッド：setMessage()<br>
	 * 　　引数　　："社員番号が既に存在しています。"<br>
	 * 3.社員番号が存在しない場合。
	 * 　3-1パスワードの強度チェック処理をコール。<br>
	 * 　　クラス　：RegisterAction<br>
	 * 　　メソッド：checkPattern()<br>
	 * 　　引数１　：アクションフォーム.getPassword()<br>
	 * 　　引数２　："password"<br>
	 * 　3-2.パスワードの強度が十分な場合。<br>
	 * 　　3-2-1.ユーザ登録処理をコール。<br>
	 * 　　　クラス　：DbAction<br>
	 * 　　　メソッド：userRegister()<br>
	 * 　　　引数　　：ユーザ登録画面アクションフォーム<br>
	 * 　3-3.パスワードの強度が不十分な場合。<br>
	 * 　　3-3-1.エラーメッセージの設定。<br>
	 * 　　　クラス　：RegisterForm<br>
	 * 　　　メソッド：setMessage()<br>
	 * 　　　引数　　："パスワードが複雑さの要件を満たしていません。"<br>
	 * 4.戻り値を返却する。<br>
	 * 　4-1.遷移先情報を設定。<br>
	 * 　　forward："register"<br>
	 * <br>
	 * @param form Actionform
	 * @return 遷移先
	 */

}

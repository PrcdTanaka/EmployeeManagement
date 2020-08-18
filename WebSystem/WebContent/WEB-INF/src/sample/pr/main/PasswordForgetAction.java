package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Personal_informationForm piForm = (Personal_informationForm) frm;
		PasswordForm pForm = (PasswordForm) frm;

		forward = "password";

		String button = pForm.getButton();
		if(button.equals("戻る")) {
			forward = "main";
		}if(button.equals("変更")){
				//入力された社員番号の空白判定
			if(piForm.getEmployee_no().equals("")){
				piForm.setMessage("社員番号を入力してください。");
			}else{
				// DBに格納された社員番号と入力された社員番号取得処理
				dba.getDbpassword(pForm);
				String employee_no = pForm.getEmployee_no();
				String dbemployee_no = dba.getEmoloyee_No();

				//DBに格納された社員番号と入力された社員番号比較処理
				if(employee_no.equals(dbemployee_no)){
				}else{
					pForm.setMessage("入力された社員番号が不正です。");
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
	public String password(PasswordForm form){
		if(checkPattern(form.getNewpassword1(),"password")) {
			dba.setPassword(form);
		}
		return "password";
	}

	/***
	 * <p>
	 * パスワードの複雑さ要件をチェックする。
	 * </p>
	 *
	 * @param word 対象文字列
	 * @param pattern チェックパターン
	 * @return 問題ナシ：true, 問題アリ：false
	 */
	public boolean checkPattern(String word, String pattern){

		boolean result = false;

		if(word.length() > 7){
			Pattern p1 = Pattern.compile("^$|^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~])[!-~]*{8,16}$"); // 正規表現パターンの読み込み
			Matcher m1 = p1.matcher(word); // パターンと検査対象文字列の照合
			result = m1.matches(); // 照合結果をtrueかfalseで取得
		}
		return result;
	}
}

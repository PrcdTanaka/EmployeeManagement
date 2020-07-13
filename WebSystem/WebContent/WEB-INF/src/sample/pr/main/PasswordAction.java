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

public final class PasswordAction extends Action {


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
	public PasswordAction() throws IOException {

	}

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

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
	 * 　2-2.社員番号を整形する。<br>
	 * 　　形式：4桁の文字列<br>
	 * 　　※桁数が4桁未満の場合は先頭から"0"埋め)<br>
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
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		PasswordForm pForm = (PasswordForm) frm;
		String button = pForm.getButton();
		if(button.equals("戻る")) {
			forward = "main";
		}if(button.equals("変更")){
			if(pForm.getOldpassword().equals("")){
				pForm.setMessage("パスワードを入力してください。");
			}else{
				 // DBに格納されたパスワード取得処理
				dba.getPassword(pForm);
				pForm.getOldpassword();
				if(pForm.getOldpassword().equals(dba.getDbpassword(pForm))){
					if(pForm.getNewpassword().equals(pForm.getNewpassword2())){
						if(!checkPattern(pForm.getNewpassword(), "password")){
							pForm.setMessage("パスワードが複雑さの要件を満たしていません。");
						}else{
							dba.setPassword(pForm);
							forward = "password";
							pForm.setMessage("パスワードを変更しました。");
						}
					}else{
						pForm.setMessage("入力されたパスワードが不正です。");
					}
				}else{
					pForm.setMessage("入力されたパスワードが不正です。");
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
		if(checkPattern(form.getNewpassword(),"password")) {
			dba.setPassword(form);
			form.setMessage("パスワードが複雑さの要件を満たしていません。");
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

		boolean result = true;

		if( word == null || word.isEmpty() ) return false ;
		switch(pattern){
		case "employee_no":
			Pattern p1 = Pattern.compile("^[0-9]+$"); // 正規表現パターンの読み込み
			Matcher m1 = p1.matcher(word); // パターンと検査対象文字列の照合
			result = m1.matches(); // 照合結果をtrueかfalseで取得
			if(word.length() != 4)
				result = false;
			break;
		case "password":
			Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$"); // 正規表現パターンの読み込み
			Matcher m2 = p2.matcher(word); // パターンと検査対象文字列の照合
			result = m2.matches(); // 照合結果をtrueかfalseで取得
			if(!(word.length() >= 8 && word.length() <= 16))
				result = false;
			break;
		}
		return result;
	}

}

package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class RegisterAction extends Action {

	/**
	 * <p>
	 * ユーザー情報登録画面-アクションの初期設定を行う。
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

	public RegisterAction() throws IOException {
	}

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;


	/****
	 * <p>
	 * クリックされたボタンを判定し、遷移先情報を返却する。
	 * </p>
	 * 1.文字コードを設定（文字化け対策）<br>
	 * 　1-1.「UTF-8」で設定<br>
	 * 　　クラス　：HttpServletRequest<br>
	 * 　　メソッド：setCharacterEncoding()<br>
	 * 　　引数　　："utf-8"<br>
	 * 　1-2.UnsupportedEncodingException（文字のエンコーディングがサポートされていません。）が発生した場合。<br>
	 * 　　1-2-1.スタックトレースの出力<br>
	 * 　　　クラス　：e<br>
	 * 　　　メソッド：printStackTrace()<br>
	 * <br>
	 * 2.登録画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。<br>
	 * 　2-1.フォーム情報のキャスト<br>
	 * <br>
	 * 3.クリックされたボタン名称をアクションフォームから取得し、判別する。<br>
	 * 　3-1.ボタン名称取得処理をコール。<br>
	 * 　　クラス　：RegisterForm
	 * 　　メソッド：getButton()
	 * 　3-2.登録ボタンの場合。<br>
	 * 　　3-2-1.ユーザ登録処理をコール<br>
	 * 　　　クラス　：RegisterAction<br>
	 * 　　　メソッド：register()<br>
	 * 　　　引数　　：ユーザー登録画面アクションフォーム<br>
	 * 　　　戻り値　：遷移先設定<br>
	 * 　3-3.戻るボタンの場合。<br>
	 * 　　3-3-1.遷移先設定<br>
	 * 　　　遷移先："main"<br>
	 * <br>
	 * 4.戻り値を返却する。<br>
	 * 　4-1.遷移先情報取得処理をコール。<br>
	 * 　　クラス　：ActionMapping<br>
	 * 　　メソッド：findForward(遷移先)<br>
	 * <br>
	 * @param map
	 *            アクションマッピング<br>
	 *            frm アクションフォーム<br>
	 *            request リクエスト情報<br>
	 *            response レスポンス情報<br>
	 * @return 遷移先情報
	 */
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		RegisterForm rForm = (RegisterForm) frm;
		String button = rForm.getButton();
		if(button.equals("登録")) {
			forward = register(rForm);
		}
		else if(button.equals("戻る")) {
			forward = "main";
			session.removeAttribute("rForm");
		}
		session.setAttribute("rForm", rForm);

		return map.findForward(forward);
	}

	/***
	 * <p>
	 * 入力された情報から新規ユーザの登録を行う。
	 * </p>
	 * 1.社員情報の取得<br>
	 * 　1-1.社員番号のチェック<br>
	 * 　　クラス　：RegisterAction<br>
	 * 　　メソッド：checkPattern()<br>
	 * 　　引数１　：アクションフォーム.getEmployee_no()<br>
	 * 　　引数２　："Employee_no"<br>
	 * 　　1-1-1.チェックで不正と判定された場合<br>
	 * 　　　1-1-1-1.エラーメッセージの設定。<br>
	 * 　　　　クラス　：RegisterForm<br>
	 * 　　　　メソッド：setMessage()<br>
	 * 　　　　引数　　："社員番号が不正です。"<br>
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
	public String register(RegisterForm form){

		if(!checkPattern(form.getEmployee_no(),"employee_no")) {
			form.setMessage("社員番号が不正です。");
			return "register";
		}

		if(!dba.confirmationNo(form)) {
			form.setMessage("社員番号が既に存在しています。");

		}else {

			if(checkPattern(form.getPassword(),"password")) {
				if(dba.userRegister(form))
					dba.userRegister2(form);
					form.setMessage("ユーザー登録に成功しました。");
			}else {
				form.setMessage("パスワードが複雑さの要件を満たしていません。");
			}
		}


		return "register";
	}

	/***
	 * <p>
	 * パスワードの複雑さ要件をチェックする。
	 * </p>
	 *
	 * @param word 対処文字列
	 * @param pattern チェックパターン
	 * @return 問題ナシ：true, 問題アリ：false
	 */
	public boolean checkPattern(String word, String pattern){

		boolean result = true;

		if(word.length() > 7){
			Pattern p = Pattern.compile("^$|^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~])[!-~]*{8,16}$"); // 正規表現パターンの読み込み
			Matcher m = p.matcher(word); // パターンと検査対象文字列の照合
			result = m.matches(); // 照合結果をtrueかfalseで取得
		}
		return result;
	}

}

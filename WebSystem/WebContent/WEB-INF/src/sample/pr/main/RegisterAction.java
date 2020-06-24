package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * 　　スタックトレースの出力<br>
	 * 　　クラス　：e<br>
	 * 　　メソッド：printStackTrace()<br>
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
	 * 　　　メソッド：entry()<br>
	 * 　　　引数　　：RegisterForm.getEmployee_no()<br>
	 * 　　　戻り値　：forward<br>
	 * 　　
	 * 
		HttpSession session = request.getSession();
		Object s = session.getAttribute("form");
	 * <br>
	 * 
	 * @param map
	 *            アクションマッピング<br>
	 *            frm アクションフォーム<br>
	 *            request リクエスト情報<br>
	 *            response レスポンス情報<br>
	 * @return 遷移先情報
	 */ 
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		LoginForm rForm = (LoginForm) frm;

		// フォームへ入力された情報をとりだす。
		String e_noemploye = rForm.getEmployee_no();
		// クリックされたボタンの名称をアクションフォームから取得
		String button = rForm.getButton();

		DbAction dAction;

		try {
			dAction = new DbAction();

			if(dAction.getEmployeeName(rForm)) {

			} else {

			}

			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

		}
		return null;
	}

	private String clickBtnIn(LoginForm form) {

		forward = "message";

		return forward;
	}

}

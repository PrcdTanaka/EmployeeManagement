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

public final class LoginAction extends Action {

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
	public LoginAction() throws IOException {

	}

	/**
	 * <p>
	 * 入力された社員Ｎｏとパスワードを判定し、遷移先情報を返却する。
	 * </p>
	 *
	 * 1.ログイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。<br>
	 * <br>
	 * 2.クリックされたボタンの名称をアクションフォームから取得する。<br>
	 * 　2-1.ボタン名称取得処理をコール。<br>
	 * 　　　クラス：LoginForm<br>
	 * 　　メソッド：getButton()<br>
	 * <br>
	 * 3.社員Noの入力チェック<br>
	 * 　3-1.社員No取得処理をコール。<br>
	 * 　　　クラス：LoginForm<br>
	 * 　　メソッド：getEmployee_no<br>
	 * 　3-2.社員Noが空白の場合。<br>
	 * 　　3-2-1.メッセージの設定。<br>
	 * 　　　メッセージ：「社員番号が空白になっています。」<br>
	 * 　　3-2-2.遷移先設定_ログイン画面<br>
	 * 　　　遷移先："login"<br>
	 * <br>
	 * 4.入力パスワードの確保。<br>
	 * 　4-1.パスワード取得処理をコール。<br>
	 * 　　　クラス：LoginForm<br>
	 * 　　メソッド：getPassword<br>
	 * 　4-2.fpasswordに取得したパスワードを格納する。<br>
	 * <br>
	 * 5.社員情報を取得する。<br>
	 * 　5-1.社員名取得処理をコール。<br>
	 * 　　　クラス：DbAction<br>
	 * 　　メソッド：getEmployeeName()<br>
	 * 　　　引数１：ログイン画面アクションフォーム<br>
	 * 　5-2.登録パスワードの取得処理をコール。<br>
	 * 　　　クラス：DbAction<br>
	 * 　　メソッド：getPassword()<br>
	 * 　　　　引数：ログイン画面アクションフォーム<br>
	 * 　5-3.管理者フラグ取得処理をコール。<br>
	 * 　　　クラス：DbAction<br>
	 * 　　メソッド：getManager()<br>
	 * 　　　　引数：ログイン画面アクションフォーム<br>
	 * <br>
	 * 6.社員名が取得できた場合の処理。<br>
	 * 　6-1.パスワードの確認。<br>
	 * 　　6-1-1.フォームのパスワードとfpasswordを比較する。<br>
	 * 　6-2.比較結果が同じだった場合。<br>
	 * 　　6-2-1.遷移先設定_メイン画面<br>
	 * 　　　遷移先："main"<br>
	 * 　6-3.比較結果が異なっていた場合。<br>
	 * 　　6-3-1.メッセージの設定。<br>
	 * 　　　メッセージ：「社員番号、あるいはパスワードが間違えています。」<br>
	 * 　　6-3-2.遷移先設定_ログイン画面<br>
	 * 　　　遷移先："login"<br>
	 * <br>
	 * 7.社員名が取得できなかった場合の処理。<br>
	 * 　7-1.メッセージを設定する。<br>
	 * 　　メッセージ：「社員番号、あるいはパスワードが間違えています。」<br>
	 * 　7-2.遷移先を設定する。_ログイン画面<br>
	 * 　　遷移先："login"<br>
	 * <br>
	 * 8.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
	 * 　8-1.リクエスト情報登録処理をコール。<br>
	 * 　　　クラス：HttpServletRequest<br>
	 * 　　メソッド：setAttribute()<br>
	 * 　　　引数１："form"<br>
	 * 　　　引数２：メイン画面アクションフォーム<br>
	 * <br>
	 * 9.戻り値を返却する。<br>
	 * 　9-1.遷移先情報取得処理をコール。<br>
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
		LoginForm lForm = (LoginForm) frm;



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
		String employee_no = lForm.getEmployee_no();
		String b=lForm.getButton();
		if (employee_no.equals("")) {
			lForm.setMessage("社員番号が空白になっています。");
			forward = "login";
		}else if(b.equals("パスワードを忘れた場合は")){
			forward="password";
		}
		else {

			/* 4.入力パスワードの確保。<br>
			 * 　4-1.パスワード取得処理をコール。<br>
			 * 　　　クラス：LoginForm<br>
			 * 　　メソッド：getPassword<br>
			 * 　4-2.fpasswordに取得したパスワードを格納する。<br>
			 */
			String fpassword = lForm.getPassword();

				/*
				 * 　5-2.登録パスワードの取得処理をコール。<br>
				 * 　　　クラス：DbAction<br>
				 * 　　メソッド：getPassword()<br>
				 * 　　　　引数：ログイン画面アクションフォーム<br>
				 */
				dba.getPassword(lForm);
				/*
				 * 　5-3.管理者フラグ取得処理をコール。<br>
				 * 　　　クラス：DbAction<br>
				 * 　　メソッド：getManager()<br>
				 * 　　　　引数：ログイン画面アクションフォーム<br>
				 */
				dba.getManager(lForm);

				/* 6.社員名が取得できた場合の処理。<br>
				 * 　6-1.パスワードの確認。<br>
				 * 　　6-1-1.フォームのパスワードとfpasswordを比較する。<br>
				 */
				if(fpassword.equals(lForm.getPassword())){
					dba.getEmployeeName(lForm);
					/* 　6-2.比較結果が同じだった場合。<br>
					 * 　　6-2-1.遷移先設定_メイン画面<br>
					 * 　　　遷移先："main"<br>
					 */
					forward = "main";
				}else{
					/* 　6-3.比較結果が異なっていた場合。<br>
					 * 　　6-3-1.メッセージの設定。<br>
					 * 　　　メッセージ：「社員番号、あるいはパスワードが間違えています。」<br>
					 * 　　6-3-2.遷移先設定_ログイン画面<br>
					 * 　　　遷移先："login"<br>
					 */
					lForm.setMessage("社員番号、あるいはパスワードが間違えています。");
					forward = "login";
				}
		}

		/* 8.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
		 * 　8-1.リクエスト情報登録処理をコール。<br>
		 * 　　　クラス：HttpServletRequest<br>
		 * 　　メソッド：setAttribute()<br>
		 * 　　　引数１："form"<br>
		 * 　　　引数２：メイン画面アクションフォーム<br>
		 */
		request.setAttribute("form", lForm);


		HttpSession session = request.getSession();

		session.setAttribute("form", lForm);

		if(forward.equals("login")){
//			JOptionPane.showMessageDialog(null,lForm.getMessage());
		}
		/* 9.戻り値を返却する。<br>
		 * 　9-1.遷移先情報取得処理をコール。<br>
		 * 　　クラス　：ActionMapping<br>
		 * 　　メソッド：findForward(遷移先)<br>
		 */
		return map.findForward(forward);
	}
}

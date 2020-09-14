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

public final class MainAction extends Action {


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
	public MainAction() throws IOException {
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
	 * 3.ログアウトボタンの場合。<br>
	 * 　3-1.遷移先を設定する。<br>
	 * 　　遷移先："logout"<br>
	 * <br>
	 * 4.ボタンがnullの場合。（リンク先設定）<br>
	 * 　4-1.リンク先の判別<br>
	 * 　　4-1-1.ユーザ情報編集画面の場合<br>
	 * 　　　遷移先："edit"<br>
	 * 　　4-1-2.ユーザ情報登録画面の場合<br>
	 * 　　　遷移先："register"<br>
	 * 　　4-1-3.ユーザ検索画面の場合<br>
	 * 　　　遷移先："search"<br>
	 * 　　4-1-4.パスワード変更画面の場合<br>
	 * 　　　遷移先："password"<br>
	 * 　　4-1-5.参照情報画面の場合<br>
	 * 　　　遷移先："reference"<br>
	 * <br>
	 * 5.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
	 * 　5-1.リクエスト情報登録処理をコール。<br>
	 * 　　　クラス：HttpServletRequest<br>
	 * 　　メソッド：setAttribute()<br>
	 * 　　　引数１："form"<br>
	 * 　　　引数２：メイン画面アクションフォーム<br>
	 *<br>
	 * 6.戻り値を返却する。<br>
	 * 　6-1.遷移先情報取得処理をコール。<br>
	 * 　　クラス　：ActionMapping<br>
	 * 　　メソッド：findForward(遷移先)<br>
	 * <br>
	 *
	 * セッションの削除
	 * lForm.initialize();
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
		String Button;
		MainForm mForm = (MainForm) frm;
		try{
			Button = mForm.getButton();
			if(Button == null)
				Button = "";
		} catch(NullPointerException e){
			Button = "";
			e.printStackTrace();
		}

		if(Button.equals("ログアウト")){
			// ログアウトボタン押下時、
			// 遷移先を"logout"に設定。
			forward = "logout";
		} else if (Button.equals("")) {
			switch (mForm.getLink()) {
			case "edit":
				forward = "edit";
				break;
			case "register":
				forward = "register";
				break;
			case "search":
				forward = "search";
				break;
			case "password":
				forward = "password";
				break;
			case "attendance":
				forward="attendance";
				break;
			case "KintaiList":
				forward="kintailist";
				break;
			case "reservation":
				forward="reservation";
				break;
			case"1F":
				forward="Enter";
				HttpSession session = request.getSession();
				LoginForm lform=(LoginForm) session.getAttribute("form");
				lform.setLink("1F");
				break;
			case"3F":
				forward="Enter";
				session = request.getSession();
				lform=(LoginForm) session.getAttribute("form");
				lform.setLink("3F");
				break;
			case"4F":
				forward="Enter";
				session = request.getSession();
				lform=(LoginForm) session.getAttribute("form");
				lform.setLink("4F");
				break;
			case"2F":
				forward="Enter";
				session = request.getSession();
				lform=(LoginForm) session.getAttribute("form");
				lform.setLink("2F");
				session.setAttribute("form", lform);
				break;
			case"kinmurecord":
				forward="kinmurecord";
				break;
			case"Access_Select1F":
				forward="Access_Select";
				EnterForm eform=new EnterForm();
				session = request.getSession();
				eform.setFloor("1");
				session.setAttribute("eform", eform);
				break;
			case"Access_Select2F":
				forward="Access_Select";
				eform=new EnterForm();
				session = request.getSession();
				eform.setFloor("2");
				session.setAttribute("eform", eform);
				break;
			case"Access_Select3F":
				forward="Access_Select";
				eform=new EnterForm();
				session = request.getSession();
				eform.setFloor("3");
				session.setAttribute("eform", eform);
				break;
			case"Access_Select4F":
				forward="Access_Select";
				eform=new EnterForm();
				session = request.getSession();
				eform.setFloor("4");
				session.setAttribute("eform", eform);
				break;
			case"kintaiNotification":
				forward="kintaiNotification";
				break;
			}
		}

		request.setAttribute("form", mForm);

		return map.findForward(forward);

	}
}

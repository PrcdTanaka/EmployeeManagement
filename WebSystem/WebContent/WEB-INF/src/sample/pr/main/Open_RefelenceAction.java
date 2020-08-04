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

public final class Open_RefelenceAction extends Action {

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

	public Open_RefelenceAction() throws IOException {

	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
		}


		Open_RefelenceForm rForm = (Open_RefelenceForm) frm;
		String button=rForm.getButton();
		HttpSession session=request.getSession();
		if(button.equals("戻る")){
			forward="back";
			session.removeAttribute("rForm");
		}
		else if(button.equals("検索")){
			forward="search";
			session.setAttribute("rForm", rForm);
		}

		return map.findForward(forward);
	}


}

package a01.room.reservation;

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
import sample.pr.main.LoginForm;

public final class RoomReservationMain extends Action {

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public RoomReservationMain() throws IOException {
	}

	String button;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		RoomReservationMainForm rForm = (RoomReservationMainForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		forward = "reservation";
		String button = rForm.getButton();


		try {
			if (button.equals("選択")) {
				forward = "calendar";
			} else if (button.equals("会議室新規登録画面へ")) {
				forward = "room";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("rForm");

		return map.findForward(forward);
	}
}

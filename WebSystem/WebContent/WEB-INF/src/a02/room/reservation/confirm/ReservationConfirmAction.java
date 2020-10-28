package a02.room.reservation.confirm;

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

public final class ReservationConfirmAction extends Action{

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public ReservationConfirmAction() throws IOException {
	}
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ReservationConfirmForm rcForm = (ReservationConfirmForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		forward="confirm";
		String button=rcForm.getButton();
		try{

			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("rcForm");
			}else if(button.equals("登録")){
				forward ="confirm";
				dba.InsReservation(rcForm);
				rcForm.setMessage("登録しました");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("rcForm");
		return map.findForward(forward);

	}
}

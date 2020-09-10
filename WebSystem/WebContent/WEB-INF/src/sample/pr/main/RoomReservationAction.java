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

public final class RoomReservationAction extends Action{

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public RoomReservationAction() throws IOException {
	}
	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ReservationForm rForm = (ReservationForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		rForm.setEmployee_no(lForm.getEmployee_no());
		forward="reservation";
		String button=rForm.getButton();
		try{
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("rForm");
			}else if(button.equals("登録")){
				forward ="room";
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("rForm");
		return map.findForward(forward);
	}
}

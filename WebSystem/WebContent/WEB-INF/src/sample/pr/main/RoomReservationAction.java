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
		RoomReservationForm roForm = (RoomReservationForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		forward="reservation";
		String button=roForm.getButton();
		try{
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("rForm");
			}else if(button.equals("登録")){
				//空白判定
				if(roForm.getRoom_name() == null){
					roForm.setMessage("会議室名を入力してください。");
					if(roForm.getSeat()==null){
						roForm.setMessage("席数を入力してください");
					}else{
						forward ="room";
						dba.InsRoomReservation(roForm);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("roForm");
		return map.findForward(forward);
	}
}

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

public class AttendanceAction extends Action{

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public AttendanceAction() throws IOException {
	}
	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		AttendanceForm aForm = (AttendanceForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		aForm.setEmployee_no(lForm.getEmployee_no());
		forward="attendance";
		String button=aForm.getButton();
		try{
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("aForm");
			}
			else if(button.equals("登録")){
				forward="attendance";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("aForm");
		return map.findForward(forward);
	}
}

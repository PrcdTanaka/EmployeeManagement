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

public class KinmuRecordAction extends Action{

//	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KinmuRecordAction() throws IOException {
	}
	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		KintaiMainForm kForm = (KintaiMainForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		lForm.setEmployee_no(lForm.getEmployee_no());
		forward = "KintaiMain";
		String button=kForm.getButton();
		try{
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("kForm");
			}
			else if(button.equals("勤怠連絡入力")){
				forward="kintaimail";
				session.setAttribute("kform", kForm);
			}
			else if(button.equals("勤怠一覧画面へ")){
				forward="kintailist";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("kForm");
		return map.findForward(forward);





	}

}

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

public class KintaiListAction extends Action {

	private DbAction dba = new DbAction();
	// 遷移先
	private String forward;

	public KintaiListAction() throws IOException
	{
	}

	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		KintaiListForm kForm = (KintaiListForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		lForm.setEmployee_no(lForm.getEmployee_no());
		forward = "KintaiList";
		String button=kForm.getButton();
		try{
			// 勤怠一覧画面から選択されたのが「戻る」の場合
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("kform");
			}
			// 勤怠一覧画面から選択されたのが「勤怠月報画面へ」の場合
			else if(button.equals("勤怠月報画面へ")){
				forward="MonthlyReport";
				session.setAttribute("kform", kForm);
			}
			// 勤怠一覧画面から選択されたのが「勤怠連絡入力」の場合
			else if(button.equals("勤怠連絡入力")){
				forward="kintaimail";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("kForm");
		return map.findForward(forward);
	}

}

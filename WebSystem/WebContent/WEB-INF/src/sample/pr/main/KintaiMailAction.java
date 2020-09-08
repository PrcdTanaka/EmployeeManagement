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

public class KintaiMailAction extends Action{
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KintaiMailAction() throws IOException {
	}
	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		KintaiMailForm form=new KintaiMailForm();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		KintaiMailForm Form = (KintaiMailForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		Form.setEmployee_no(lForm.getEmployee_no());
		forward="kintaimail";
		String button=Form.getButton();
		try{
			if(button.equals("戻る")){
				forward="KintaiMain";
				session.removeAttribute("Form");
			}
			else if(button.equals("送信")){
				if(form.getCC()!=null&&form.getSpotcode()!=null&&form.getDivision()!=null&&form.getSpan()!=null
						&&form.getPtime()!=null&&form.getRemark()!=null&&form.getDepart()!=null)
				{
					forward="kintaimail";
					dba.setKintaiInfo(Form);
					session.setAttribute("form", Form);
					form.setMessage("送信しました");
				}
				else
					form.setMessage("必須項目を入力してください");
					forward="kintaimail";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("Form");
		return map.findForward(forward);
	}
}


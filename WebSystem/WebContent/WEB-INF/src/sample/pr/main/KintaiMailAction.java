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

public class KintaiMailAction extends Action {
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KintaiMailAction() throws IOException {
	}

	String button;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		KintaiMailForm form = (KintaiMailForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		form.setEmployee_no(lForm.getEmployee_no());
		form.setEmployee_name(lForm.getEmployee_name());
		forward = "kintaimail";
		String button = form.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "KintaiMain";
				session.removeAttribute("form");
			}
			if (button.equals("送信")) {
				if ((((form.getCC().equals("") || form.getSpotcode().equals("")
						|| form.getDivision().equals("")
						|| form.getSpan().equals("")
						|| form.getPtime().equals("")
						|| form.getRemark().equals("")
						|| form.getDepart().equals("")
						|| form.getSpan2().equals(""))))
						|| !(form.getSpan().equals(form.getSpan()))
						|| !(form.getSpan2().equals(form.getSpan2()))){
					session.setAttribute("form", form);
					forward = "kintaimail";
				}else{
					session.setAttribute("form", form);
					dba.setKintaiInfo(form, lForm);
					response.sendRedirect("http://localhost:8080/WebSystem/jsp/login.jsp");
					session.removeAttribute("form");
					// JOptionPane.showMessageDialog(null,"送信しました");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		session.removeAttribute("form");
		return map.findForward(forward);

	}
}

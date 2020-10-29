package b03.attendance.monthlyreport;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.pr.main.LoginForm;

public class MonthlyReportAction extends Action {

	//private DbAction dba = new DbAction();

	// 遷移先
	private String forward;
	public static boolean OutputFlg = false;

	public MonthlyReportAction() throws IOException {
	}

	String button;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Output_excel excel =new Output_excel();
		MonthlyReportForm MForm = (MonthlyReportForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		MForm.setEmployee_no(lForm.getEmployee_no());
		forward = "MonthlyReport";
		String button = MForm.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "kintailist";
				// session.removeAttribute("kForm");
			} else if (button.equals("保存")) {
				forward = "MonthlyReport";
				session.setAttribute("kform", MForm);
				excel.Output_Excel(MForm, lForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// session.removeAttribute("kForm");
		return map.findForward(forward);
	}
}

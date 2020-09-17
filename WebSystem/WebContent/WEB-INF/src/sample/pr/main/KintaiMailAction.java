package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
				/*Span1とSpan2と被っていないか確認*/
				MonthlyReportForm FORM=new MonthlyReportForm();
				FORM.setEmployee_no(lForm.getEmployee_no());
				dba.getMonthly_report(FORM);
				List<String> FSpan1 = FORM.getSpan();
				List<String> FSpan2 = FORM.getSpan2();
				int lSpan1 = 0;
				int lSpan2 = 0;
				String[] Kintai_lst_Span1 = new String[30];
				String[] Kintai_lst_Span2 = new String[30];
				for(int Target_span1_day = 0; Target_span1_day < FSpan1.size(); Target_span1_day++)
				{
					Kintai_lst_Span1[lSpan1] = FSpan1.get(Target_span1_day);
					lSpan1++;
				}
				for(int Target_span2_day = 0; Target_span2_day < FSpan2.size(); Target_span2_day++)
				{
					Kintai_lst_Span2[lSpan2] = FSpan2.get(Target_span2_day);
					lSpan2++;
				}
				boolean chk_bukking_flg = false;
				for(int spans_culm = 0; spans_culm < FSpan1.size(); spans_culm++)
				{
					int int_Span1_List = Integer.parseInt(Kintai_lst_Span1[spans_culm]);
					int int_Span2_List = Integer.parseInt(Kintai_lst_Span2[spans_culm]);
					int int_date = Integer.parseInt(form.getSpan());

					if(int_date >= int_Span1_List && int_Span2_List >= int_date)
					{
						chk_bukking_flg = true;
					}
				}

				if ((((form.getCC().equals("") || form.getSpotcode().equals("")
						|| form.getDivision().equals("")
						|| form.getSpan().equals("")
						|| form.getRemark().equals("")
						|| form.getDepart().equals("")
						|| form.getSpan2().equals(""))))
						|| !(form.getSpan().equals(form.getSpan()))
						|| !(form.getSpan2().equals(form.getSpan2()))){
					session.setAttribute("form", form);
					forward = "kintaimail";
				//	request.setAttribute("errowMsg", "必須項目を入力してください");
				//	String errorMsg=(String)request.getAttribute("errorMsg");
				//	JOptionPane.showMessageDialog(null, errorMsg);
				}
				else{
					if(chk_bukking_flg == false)
					{
						session.setAttribute("form", form);
						dba.setKintaiInfo(form, lForm);
						response.sendRedirect("http://localhost:8080/WebSystem/jsp/login.jsp");
						session.removeAttribute("form");
						// JOptionPane.showMessageDialog(null,"送信しました");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		session.removeAttribute("form");
		return map.findForward(forward);

	}
}

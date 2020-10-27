package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;
import sample.pr.main.LoginForm;

public final class ReservationAction extends Action{

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public ReservationAction() throws IOException {
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
		dba.getEmployeeName(lForm);
		forward="reservation";
		String button=rForm.getButton();			

		try{
			if(button.equals("戻る")){
				forward="main";
				session.removeAttribute("rForm");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("rForm");
		return map.findForward(forward);
	}

	//1か月先の月を取得
	public int lastmonth(ReservationForm rForm){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH+1);
		month -= 1;
		if(month == 0){
			year -= 1;
			month =12;
		}
		dba.getMMDD(rForm);
		return month;
	}

	//1週間前の日付を取得する
	public static int lastweek(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH+1);
		day -= 7;
		if(day <= 7){
			month -= 1;
			if(month == -1){
			month = 12;
			}
		}
		return day;
	}

	//1か月先の月を取得する
	public static int nextmonth(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH+1);
		month += 1;
		if(month == 13){
			year += 1;
			month =1;
		}
		return month;
	}

	//1週間先の日付を取得する
	public static int nextweek(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		int max = cal.getActualMaximum(Calendar.DATE);
		day += 7;
		if(day >= max){
			month += 1;
			if(month == 13){
				month = 1;
				year += 1;
			}
		}
		return month;
	}
}

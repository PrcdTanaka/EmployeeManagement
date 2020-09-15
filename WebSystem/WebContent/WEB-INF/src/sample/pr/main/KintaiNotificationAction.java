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

public final class KintaiNotificationAction extends Action {

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KintaiNotificationAction() throws IOException {

	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// フォーム情報をキャスト
		KintaiNotificationForm KNForm = (KintaiNotificationForm) frm;

		//セッションインスタンスをまず取得()
		HttpSession session = request.getSession();

		//ログインユーザーの社員番号と名前をセッションスコープから取得
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		lForm.setEmployee_no(lForm.getEmployee_no());

		//チェック要の項目を変数に格納する。
		String check_employee_no = request.getParameter("employee_no");
		KNForm.setEmployee_no(check_employee_no);
		String check_at_Startday = KNForm.getAttendance_startday();
		String check_at_Endday = KNForm.getAttendance_endday();
		String check_NotificationReason = KNForm.getNotification_reason();
		String b=KNForm.getButton();
		if(b.equals("戻る")){
			forward ="main";
		}
		else if (check_employee_no.equals("")) {
			KNForm.setMessage("社員番号が空白になっています。");
			forward = "kintaiNotification";
		}
		else if(check_at_Startday.equals("")){
			KNForm.setMessage("対象日(開始)が空白になっています。");
			forward = "kintaiNotification";
		}else if(check_at_Endday.equals("")){
			KNForm.setMessage("対象日(終了)が空白になっています。");
			forward = "kintaiNotification";
		}else if(check_NotificationReason.equals("")){
			KNForm.setMessage("届出事由が空白になっています。");
			forward = "kintaiNotification";
		}
		else{
			KNForm.setMessage("エクセル出力しました。");
			forward="kintaiNotification";

			/* ここからは構想上のプログラム
			 *
			 * 社員番号と対象開始日と対象終了日と届出事由をDBから取得して、画面入力値と比較し
			 * 完全一致ならUPDATE文、それ以外であればINSERT文でDBに登録する。
			 */

			//リクエストパラメーターを取得
			String employee_no = request.getParameter("employee_no");
			String syain_name = request.getParameter("syain_name");
			String depart = request.getParameter("depart");
			String petition_ymd = request.getParameter("petition_ymd");
			String attendance_startday = request.getParameter("attendance_startday");
			String attendance_endday = request.getParameter("attendance_endday");
			String attendance_starttime = request.getParameter("attendance_starttime");
			String attendance_endtime = request.getParameter("attendance_endtime");
			String notification_reason = request.getParameter("notification_reason");
			String vacation_division = request.getParameter("vacation_division");
			String transfer_day = request.getParameter("transfer_day");
			String sp_holiday_reason = request.getParameter("sp_holiday_reason");
			String absenteeism_reason = request.getParameter("absenteeism_reason");
			String reason = request.getParameter("reason");

			/*確認するカラムをSELECTで確認する。
			 * 確認カラム
			 * 社員番号、対象開始日、対象終了日、届出事由
			 *
			 * StringBuffer sb = new StringBuffer();
			 * sb.append(employee_no + attendance_startday + attendance_endday + notification_reason);
			 *
			 */
			//セッターでインスタンスのフィールド変数を更新
			KNForm.setEmployee_no(employee_no);
			KNForm.setSyain_name(syain_name);
			KNForm.setDepart(depart);
			KNForm.setPetition_ymd(petition_ymd);
			KNForm.setAttendance_startday(attendance_startday);
			KNForm.setAttendance_endday(attendance_endday);
			KNForm.setAttendance_starttime(attendance_starttime);
			KNForm.setAttendance_endtime(attendance_endtime);
			KNForm.setNotification_reason(notification_reason);
			KNForm.setVacation_division(vacation_division);
			KNForm.setReason(reason);

			//休暇区分によって、入力不要なデータを消す。
			switch(vacation_division){
			//休暇区分が1(年次有給休暇/リフ休)の場合
			case "1":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;

			//休暇区分が3(振替休暇)の場合
			case "3":
				KNForm.setTransfer_day(transfer_day);
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;

			//休暇区分が4(特別休暇)の場合
			case "4":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason(sp_holiday_reason);
				KNForm.setAbsenteeism_reason("");
				break;
			case "5":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason(absenteeism_reason);
			case "null":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;
			}

			forward = saveInsert(KNForm);

		}
		return map.findForward(forward);
	}

	public String saveInsert(KintaiNotificationForm form){
		dba.KintaiNotification_INSERT(form);
		return "kintaiNotification";
	}
}

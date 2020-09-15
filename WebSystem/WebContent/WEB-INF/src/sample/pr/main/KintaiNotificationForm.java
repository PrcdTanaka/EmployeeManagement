package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class KintaiNotificationForm extends ActionForm {

	// コンストラクタ
	public KintaiNotificationForm(){

	}
	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String employee_no;
	/** 社員氏名 */
	private String syain_name;
	/** 所属部門 */
	private String depart;
	/** 申請日 */
	private String petition_ymd;
	/** 対象日(開始) */
	private String attendance_startday;
	/** 対象日(終了) */
	private String attendance_endday;
	/** 対象時間(開始) */
	private String attendance_starttime;
	/** 対象時間(終了) */
	private String attendance_endtime;
	/** 届出事由 */
	private String notification_reason;
	/** 休暇区分 */
	private String vacation_division;
	/** 振替対象日 */
	private String transfer_day;
	/** 特休理由 */
	private String sp_holiday_reason;
	/** 欠勤理由 */
	private String absenteeism_reason;
	/** 事由 */
	private String reason;
	/** メッセージ */
	private String message;
	/** ボタン名 */
	private String button;
	/**

	/**
	 *
	 * 初期化処理。
	 * <p>
	 * 勤怠届作成画面のアクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		employee_no="";
		syain_name="";
		depart="";
		petition_ymd="";
		attendance_startday="";
		attendance_endday="";
		attendance_starttime="";
		attendance_endtime="";
		notification_reason="";
		vacation_division="";
		transfer_day="";;
		sp_holiday_reason="";
		absenteeism_reason="";
		reason="";
		message="";
		button="";
	}

/* 社員番号(employee_no) getter */
	public String getEmployee_no() {
		return employee_no;
	}

/* 社員番号(employee_no) setter*/
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

/* 社員氏名(syain_name) getter */
	public String getSyain_name(){
		return syain_name;
	}

/* 社員氏名(syain_name) setter */
	public void setSyain_name(String syain_name){
		this.syain_name = syain_name;
	}

/* 所属部門(depart) getter */
	public String getDepart() {
	return depart;
	}

/* 所属部門(depart) setter */
	public void setDepart(String depart) {
		this.depart=depart;
	}

/* 申請日(petition_ymd) getter */
	public String getPetition_ymd() {
		return petition_ymd;
	}

/* 申請日(petition_ymd) setter */
	public void setPetition_ymd(String petition_ymd) {
		this.petition_ymd = petition_ymd;
	}

/* 対象日(開始)(attendance_startday) getter */
	public String getAttendance_startday() {
		return attendance_startday;
	}

/* 対象日(開始)(attendance_startday) setter */
	public void setAttendance_startday(String attendance_startday) {
		this.attendance_startday = attendance_startday;
	}

/* 対象日(終了)(attendance_endday) getter */
	public String getAttendance_endday() {
		return attendance_endday;
	}

/* 対象日(終了)(attendance_endday) setter */
	public void setAttendance_endday(String attendance_endday) {
		this.attendance_endday = attendance_endday;
	}


/* 対象時間(開始)(attendance_starttime) getter */
	public String getAttendance_starttime() {
		return attendance_starttime;
	}

/* 対象時間(開始)(attendance_starttime) setter */
	public void setAttendance_starttime(String attendance_starttime) {
		this.attendance_starttime = attendance_starttime;
	}

/* 対象時間(終了)(attendance_endtime) getter */
	public String getAttendance_endtime() {
		return attendance_endtime;
	}

/* 対象時間(終了)(attendance_endtime) setter */
	public void setAttendance_endtime(String attendance_endtime) {
		this.attendance_endtime = attendance_endtime;
	}

/* 届出事由(notification_reason) getter */
	public String getNotification_reason() {
		return notification_reason;
	}

/* 届出事由(notification_reason) setter */
	public void setNotification_reason(String notification_reason) {
		this.notification_reason = notification_reason;
	}

/* 休暇区分(vacation_division) getter */
	public String getVacation_division() {
		return vacation_division;
	}

/* 休暇区分(vacation_division) setter */
	public void setVacation_division(String vacation_division) {
		this.vacation_division = vacation_division;
	}

/* 振替対象日(transfer_day) getter */
	public String getTransfer_day() {
		return transfer_day;
	}

/* 振替対象日(transfer_day) setter */
	public void setTransfer_day(String transfer_day) {
		this.transfer_day = transfer_day;
	}

/* 特休理由(sp_holiday_reason) getter */
	public String getSp_holiday_reason() {
		return sp_holiday_reason;
	}

/* 特休理由(sp_holiday_reason) setter */
	public void setSp_holiday_reason(String sp_holiday_reason) {
		this.sp_holiday_reason = sp_holiday_reason;
	}

/* 欠勤理由(absenteeism_reason) getter */
	public String getAbsenteeism_reason() {
		return absenteeism_reason;
	}

/* 欠勤理由(absenteeism_reason) setter */
	public void setAbsenteeism_reason(String absenteeism_reason) {
		this.absenteeism_reason = absenteeism_reason;
	}

/* 事由(reason) getter */
	public String getReason() {
		return reason;
	}

/* 事由(reason) setter */
	public void setReason(String reason) {
		this.reason = reason;
	}

/* メッセージ(message) getter */
	public String getMessage() {
		return message;
	}

/* メッセージ(message) setter */
	public void setMessage(String message) {
		this.message = message;
	}

/* ボタン名(button) getter */
	public String getButton() {
		return button;
	}

/* ボタン名(button) setter */
	public void setButton(String button) {
		this.button = button;
	}


}

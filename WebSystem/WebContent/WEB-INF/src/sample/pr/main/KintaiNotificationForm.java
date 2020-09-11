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
		setDepart("");
		setPetition_ymd("");
		setAttendance_startday("");
		setAttendance_endday("");
		setAttendance_starttime("");
		setAttendance_endtime("");
		setNotification_reason("");
		setVacation_division("");
		setSp_holiday_reason("");
		setAbsenteeism_reason("");
		setReason("");
	}

	/**
	 * 社員番号取得処理。
	 * <p>
	 * 勤怠届作成画面アクションフォームから社員番号を取得する。
	 * </p>
	 *
	 * @return 社員番号
	 */
	public String getEmployee_no() {
		return employee_no;
	}

	/**
	 * 社員番号設定処理。
	 * <p>
	 * ログイン画面アクションフォームに社員番号を設定する。
	 * </p>
	 *
	 * @param employee_no 社員番号
	 */
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	/**
	 * 社員氏名取得処理。
	 * <p>
	 * ログイン画面アクションフォームから社員氏名を取得する。
	 * </p>
	 *
	 * @return 社員氏名
	 */
	public String getSyain_name() {
		return syain_name;
	}

	/**
	 * 社員氏名設定処理。
	 *
	 * 勤怠届作成画面アクションフォームに社員氏名を設定する。
	 *
	 *
	 * @param syain_name 社員氏名
	 */
	public void setEmployee_name(String syain_name) {
		this.syain_name = syain_name;
	}

	/**
	 * @return depart
	 */
	public String getDepart() {
		return depart;
	}

	/**
	 * @param depart セットする depart
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}

	/**
	 * @return petition_ymd
	 */
	public String getPetition_ymd() {
		return petition_ymd;
	}

	/**
	 * @param petition_ymd セットする petition_ymd
	 */
	public void setPetition_ymd(String petition_ymd) {
		this.petition_ymd = petition_ymd;
	}

	/**
	 * @return attendance_startday
	 */
	public String getAttendance_startday() {
		return attendance_startday;
	}

	/**
	 * @param attendance_startday セットする attendance_startday
	 */
	public void setAttendance_startday(String attendance_startday) {
		this.attendance_startday = attendance_startday;
	}

	/**
	 * @return attendance_endday
	 */
	public String getAttendance_endday() {
		return attendance_endday;
	}

	/**
	 * @param attendance_endday セットする attendance_endday
	 */
	public void setAttendance_endday(String attendance_endday) {
		this.attendance_endday = attendance_endday;
	}

	/**
	 * @return attendance_starttime
	 */
	public String getAttendance_starttime() {
		return attendance_starttime;
	}

	/**
	 * @param attendance_starttime セットする attendance_starttime
	 */
	public void setAttendance_starttime(String attendance_starttime) {
		this.attendance_starttime = attendance_starttime;
	}

	/**
	 * @return attendance_endtime
	 */
	public String getAttendance_endtime() {
		return attendance_endtime;
	}

	/**
	 * @param attendance_endtime セットする attendance_endtime
	 */
	public void setAttendance_endtime(String attendance_endtime) {
		this.attendance_endtime = attendance_endtime;
	}

	/**
	 * @return notification_reason
	 */
	public String getNotification_reason() {
		return notification_reason;
	}

	/**
	 * @param notification_reason セットする notification_reason
	 */
	public void setNotification_reason(String notification_reason) {
		this.notification_reason = notification_reason;
	}

	/**
	 * @return vacation_division
	 */
	public String getVacation_division() {
		return vacation_division;
	}

	/**
	 * @param vacation_division セットする vacation_division
	 */
	public void setVacation_division(String vacation_division) {
		this.vacation_division = vacation_division;
	}

	/**
	 * @return sp_holiday_reason
	 */
	public String getSp_holiday_reason() {
		return sp_holiday_reason;
	}

	/**
	 * @param sp_holiday_reason セットする sp_holiday_reason
	 */
	public void setSp_holiday_reason(String sp_holiday_reason) {
		this.sp_holiday_reason = sp_holiday_reason;
	}

	/**
	 * @return absenteeism_reason
	 */
	public String getAbsenteeism_reason() {
		return absenteeism_reason;
	}

	/**
	 * @param absenteeism_reason セットする absenteeism_reason
	 */
	public void setAbsenteeism_reason(String absenteeism_reason) {
		this.absenteeism_reason = absenteeism_reason;
	}

	/**
	 * @return reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason セットする reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * メッセージ取得処理。
	 * <p>
	 * 勤怠届作成画面アクションフォームからメッセージを取得する。
	 * </p>
	 *
	 * @return メッセージ
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * メッセージ設定処理。
	 * <p>
	 * 勤怠届作成画面アクションフォームにメッセージを設定する。
	 * </p>
	 *
	 * @param message メッセージ
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * ボタン名取得処理。
	 * <p>
	 * 勤怠届作成画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getButton() {

		if(button.equals("ã­ã°ã¤ã³")){
			button = "login";
		}

		return button;
	}

	/**
	 * ボタン名設定処理。
	 *
	 * 勤怠届作成画面アクションフォームにボタン名を設定する。
	 *
	 * @param button ボタン名
	 */
	public void setButton(String button) {
		this.button = button;
	}


}

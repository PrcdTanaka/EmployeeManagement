package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class ReservConForm extends ActionForm {

	/** 社員番号 */
	private String employee_no;
	/** 社員名 */
	private String name;
	/**会議室名 */
	private String room_name;
	/** ボタン */
	private String button;
	/** 時間 */
	private String res_time;
	/** 日付 */
	private String mmdd;
	/** 用途 */
	private String use;
	/**メンバー */
	private String member;
	/** メッセージ */
	private String message;


	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		employee_no = "";
		name = "";
		room_name = "";
		button = "";
		res_time ="";
		mmdd = "";
		use = "";
		message = "";
	}
	/**
	 * 社員番号取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員番号を取得する。
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
	 * メイン画面アクションフォームに社員番号を設定する。
	 * </p>
	 * @param employee_no 社員番号
	 */
	public void setEmployee_no(String Employee_no) {
		this.employee_no = Employee_no;
	}

	/**
	 * 社員名取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員名を取得する。
	 * </p>
	 *
	 * @return 社員名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 社員番号設定処理。
	 * <p>
	 * 会議室予約確認画面アクションフォームに社員番号を設定する。
	 * </p>
	 * @param employee_no 社員番号
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 会議室名取得処理。
	 * <p>
	 * 会議室予約確認画面アクションフォームから会議室名を取得する。
	 * </p>
	 *
	 * @return 社員名
	 */
	public String getRoom_name() {
		return room_name;
	}

	/**
	 * 会議室名設定処理。
	 * <p>
	 * 会議室名を設定する。
	 * </p>
	 *
	 * @param oldpassword 会議室名
	 */
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}



	/**
	 * ボタン名取得処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getButton() {
		return button;
	}

	/**
	 * ボタン名設定処理。
	 * <p>
	 * メイン画面アクションフォームにボタン名を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setButton(String button) {
		this.button = button;
	}

	/**
	 * ボタン名取得処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getRes_time() {
		return res_time;
	}

	/**
	 * ボタン名設定処理。
	 * <p>
	 * メイン画面アクションフォームにボタン名を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	/**
	 * 日付取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから日付を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getMmdd() {
		return mmdd;
	}

	/**
	 * 日付設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに日付を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setMmdd(String mmdd) {
		this.mmdd = mmdd;
	}
	/**
	 * 日付取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから日付を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getUse() {
		return use;
	}

	/**
	 * 日付設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに日付を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setUse(String use) {
		this.use = use;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

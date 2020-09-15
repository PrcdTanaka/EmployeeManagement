package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class RoomReservationForm extends ActionForm {

	/** 会議室 */
	private String room_name;
	/** 所在地 */
	private String place;
	/** 席数 */
	private String seat;
	/** モニター */
	private String monitor;
	/** カメラ */
	private String camera;
	/** ボタン */
	private String button;
	/** メッセージ */
	private String message;
	/** メンバー */
	private String member;
	/** 用途 */
	private String use;
	/** 時間 */
	private String res_time;
	/** 日付 */
	private String mmdd;
	/** 社員番号 */
	private String emp_no;



	/**
	 * 初期化処理。
	 * <p>
	 * 会議室予約画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		room_name = "";
		place = "";
		seat = "";
		monitor = "";
		camera = "";
		button = "";
		message = "";
		member = "";
		use = "";
		res_time = "";
		mmdd = "";
		emp_no = "";

	}

	/**
	 * 会議室名取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから会議室名を取得する。
	 * </p>
	 *
	 * @return 会議室名
	 */
	public String getRoom_name() {
		return room_name;
	}

	/**
	 * 会議室名設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに会議室名を設定する。
	 * </p>
	 *
	 * @param room_name 会議室名
	 */
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	/**
	 * 所在地取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから所在地を取得する。
	 * </p>
	 *
	 * @return 所在地名
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * 所在地設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに所在地を設定する。
	 * </p>
	 *
	 * @param place 所在地
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * 席数設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに席数を設定する。
	 * </p>
	 *
	 * @param seat 席
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}
	/**
	 * 席数取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから席数を取得する。
	 * </p>
	 *
	 * @return 席数
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * モニター取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからモニターを取得する。
	 * </p>
	 *
	 * @return モニター
	 */
	public String getMonitor() {
		return monitor;
	}

	/**
	 * モニター設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにモニターを設定する。
	 * </p>
	 *
	 * @param monitor モニター
	 */
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getCamera() {
		return camera;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setCamera(String camera) {
		this.camera = camera;
	}

	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getButton() {
		return button;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setButton(String button) {
		this.button = button;
	}
	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * メンバー取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからメンバーを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getMember() {
		return member;
	}

	/**
	 * メンバー設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにメンバーを設定する。
	 * </p>
	 *
	 * @param camera メンバー
	 */
	public void setMember(String member) {
		this.member = member;
	}
	/**
	 * 用途取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから用途を取得する。
	 * </p>
	 *
	 * @return 用途
	 */
	public String getUse() {
		return use;
	}

	/**
	 * 用途設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに用途を設定する。
	 * </p>
	 *
	 * @param camera 用途
	 */
	public void setUse(String use) {
		this.use = use;
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
	public String getEmp_no() {
		return emp_no;
	}

	/**
	 * 日付設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームに日付を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

}
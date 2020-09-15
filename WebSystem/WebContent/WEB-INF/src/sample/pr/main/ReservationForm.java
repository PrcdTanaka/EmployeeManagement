package sample.pr.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public final class ReservationForm extends ActionForm {

	/** 社員番号 */
	private String employee_no;
	/** 社員名 */
	private String name;
	/**会議室名 */
	private String room_name;
	/** 席数 */
	private String seat_number;
	/** モニター */
	private String monitor;
	/** カメラ */
	private String camera;
	/** ボタン */
	private String button;
	/** 時間 */
	private List<String> res_time;
	/** 日付 */
	private List<String> mmdd;
	/** 用途 */
	private String use;


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
		seat_number = "";
		monitor = "";
		camera = "";
		button = "";
		res_time =new ArrayList<String>();
		mmdd = new ArrayList<String>();
		use = "";
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
	 * 社員番号取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員番号を取得する。
	 * </p>
	 *
	 * @return 社員番号
	 */
	public String getName() {
		return name;
	}

	/**
	 * 社員番号設定処理。
	 * <p>
	 * メイン画面アクションフォームに社員番号を設定する。
	 * </p>
	 * @param employee_no 社員番号
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 会議室名取得処理。
	 * <p>
	 * メイン画面アクションフォームから会議室名を取得する。
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
	 * 会議室名を設定する。
	 * </p>
	 *
	 * @param oldpassword 会議室名
	 */
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	/**
	 * 席数取得処理。
	 * <p>
	 * メイン画面アクションフォームから席数を取得する。
	 * </p>
	 *
	 * @return 席数
	 */
	public String getSeat_number() {
		return seat_number;
	}

	/**
	 * 新しいパスワード1設定処理。
	 * <p>
	 * パスワードフォーム新しいパスワード1を設定する。
	 * </p>
	 *
	 * @param newpassword 新しいパスワード1
	 */
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	/**
	 * 新しいパスワード2取得処理。
	 * <p>
	 * メイン画面アクションフォームから新しいパスワード2を取得する。
	 * </p>
	 *
	 * @return 新しいパスワード2
	 */
	public String getMonitor() {
		return monitor;
	}

	/**
	 * 新しいパスワード2設定処理。
	 * <p>
	 * パスワードフォーム新しいパスワード2を設定する。
	 * </p>
	 *
	 * @param newpassword 新しいパスワード2
	 */
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	/**
	 * ボタン名取得処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getCamera() {
		return camera;
	}

	/**
	 * ボタン名設定処理。
	 * <p>
	 * メイン画面アクションフォームにボタン名を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setCamera(String camera) {
		this.camera = camera;
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
	public List<String> getRes_time() {
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
		this.res_time.add(res_time);
	}

	/**
	 * 日付取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから日付を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public List<String> getMmdd() {
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
		this.mmdd.add(mmdd);
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

}

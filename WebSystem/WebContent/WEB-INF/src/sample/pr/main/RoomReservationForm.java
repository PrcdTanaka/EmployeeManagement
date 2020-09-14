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

}
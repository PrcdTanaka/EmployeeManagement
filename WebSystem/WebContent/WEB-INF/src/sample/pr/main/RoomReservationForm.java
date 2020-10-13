package sample.pr.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public final class RoomReservationForm extends ActionForm {

	/** 会議室 */
	private List<String> room_name;
	/** 所在地 */
	private String place;
	/** 席数 */
	private List<String> seat;
	/** モニター */
	private List<String> monitor;
	/** カメラ */
	private List<String> camera;
	/** ボタン */
	private String button;
	/** メッセージ */
	private String message;
	/** 社員番号 */
	private String emp_no;
	/** 社員名 */
	private String name;
	/** 日付 */
	private String mmdd;
	/** 用途 */
	private String use;
	/** 時間 */
	private String res_time;
	/** メンバー */
	private String member;


	/**
	 * 初期化処理。
	 * <p>
	 * 会議室予約画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		room_name = new ArrayList<String>();
		place = "";
		seat = new ArrayList<String>();
		monitor = new ArrayList<String>();
		camera = new ArrayList<String>();
		button = "";
		message = "";
		emp_no = "";
		name = "";
		mmdd = "";
		use = "";
		res_time = "";
		member = "";
	}

	/**
	 * 会議室名取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから会議室名を取得する。
	 * </p>
	 *
	 * @return 会議室名
	 */
	public List<String> getRoom_name(){
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
	public void setRoom_name(String room_name){
		this.room_name.add(room_name);
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
	public List<String> getSeat(){
		return seat;
	}
	/**
	 * 席数取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームから席数を取得する。
	 * </p>
	 *
	 * @return 席数
	 */
	public void setSeat(String seat){
		this.seat.add(seat);
	}

	/**
	 * モニター取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからモニターを取得する。
	 * </p>
	 *
	 * @return モニター
	 */
	public List<String> getMonitor(){
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
	public void setMonitor(String monitor){
		this.monitor.add(monitor);
	}

	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public List<String> getCamera(){
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
	public void setCamera(String camera){
		this.camera.add(camera);
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
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getEmp_no() {
		return emp_no;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getName() {
		return name;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getMmdd() {
		return mmdd;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setMmdd(String mmdd) {
		this.mmdd = mmdd;
	}
	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getUse() {
		return use;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setUse(String use) {
		this.use = use;
	}
	/**
	 * カメラ取得処理。
	 * <p>
	 * 会議室予約画面アクションフォームからカメラを取得する。
	 * </p>
	 *
	 * @return カメラ
	 */
	public String getRes_time() {
		return res_time;
	}

	/**
	 * カメラ設定処理。
	 * <p>
	 * 会議室予約画面アクションフォームにカメラを設定する。
	 * </p>
	 *
	 * @param camera カメラ
	 */
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	/**
	 * メンバー
	 * @return
	 */
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}

}
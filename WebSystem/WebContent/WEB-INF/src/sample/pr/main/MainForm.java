package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class MainForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String syain_no;
	/** パスワード */
	private String password;
	/** 社員氏名 */
	private String syain_name;
	/** 出社時間 */
	private String time_from;
	/** 退社時間 */
	private String time_to;

	/** ボタン名 */
	private String button;
	/** メッセージ */
	private String message;
	/** 日時 */
	private String dtime;

	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		syain_no = "";
		syain_name = "";
		time_from = "";
		time_to = "";
		button = "";
		message = "";
		dtime = "";
	}

	/**
	 * 社員番号取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員番号を取得する。
	 * </p>
	 *
	 * @return 社員番号
	 */
	public String getSyain_no() {
		return syain_no;
	}

	/**
	 * 社員番号設定処理。
	 * <p>
	 * メイン画面アクションフォームに社員番号を設定する。
	 * </p>
	 *
	 * @param syain_no 社員番号
	 */
	public void setSyain_no(String syain_no) {
		this.syain_no = syain_no;
	}

	/**
	 * 社員氏名取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員氏名を取得する。
	 * </p>
	 *
	 * @return 社員氏名
	 */
	public String getSyain_name() {
		return syain_name;
	}

	/**
	 * 社員氏名設定処理。
	 * <p>
	 * メイン画面アクションフォームに社員氏名を設定する。
	 * </p>
	 *
	 * @param syain_name 社員氏名
	 */
	public void setSyain_name(String syain_name) {
		this.syain_name = syain_name;
	}

	/**
	 * 出社時間取得処理。
	 * <p>
	 * メイン画面アクションフォームから出社時間を取得する。
	 * </p>
	 *
	 * @return 出社時間
	 */
	public String getTime_from() {
		
		return time_from;
	}

	/**
	 * 出社時間設定処理。
	 * <p>
	 * メイン画面アクションフォームに出社時間を設定する。
	 * </p>
	 *
	 * @param time_from 出社時間
	 */
	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	/**
	 * 退社時間取得処理。
	 * <p>
	 * メイン画面アクションフォームから退社時間を取得する。
	 * </p>
	 *
	 * @return 退社時間
	 */
	public String getTime_to() {
		return time_to;
	}

	/**
	 * 退社時間設定処理。
	 * <p>
	 * メイン画面アクションフォームに退社時間を設定する。
	 * </p>
	 *
	 * @param time_to 退社時間
	 */
	public void setTime_to(String time_to) {
		this.time_to = time_to;
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
		
		if(button.equals("åºç¤¾")){
			button = "syussya";
		}
		
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
	 * メッセージ取得処理。
	 * <p>
	 * メイン画面アクションフォームからメッセージを取得する。
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
	 * メイン画面アクションフォームにメッセージを設定する。
	 * </p>
	 *
	 * @param message メッセージ
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String password) {
		this.dtime = dtime;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

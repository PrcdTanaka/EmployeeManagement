package sample.pr.main;

import java.util.Map;

import org.apache.struts.action.ActionForm;

public final class LoginForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String employee_no;
	/** パスワード */
	private String password;
	/** 社員氏名 */
	private String employee_name;
	/** ボタン名 */
	private String button;
	/** メッセージ */
	private String message;
	/** 管理者フラグ */
	private String manager;
	
	private Map<String, String> user;

	/**
	 * 初期化処理。
	 * <p>
	 * ログイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		employee_no = "";
		employee_name = "";
		button = "";
		message = "";
		password = "";
		manager = "";
	}

	/**
	 * 社員番号取得処理。
	 * <p>
	 * ログイン画面アクションフォームから社員番号を取得する。
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
	public String getEmployee_name() {
		return employee_name;
	}

	/**
	 * 社員氏名設定処理。
	 * <p>
	 * ログイン画面アクションフォームに社員氏名を設定する。
	 * </p>
	 *
	 * @param employee_name 社員氏名
	 */
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	/**
	 * ボタン名取得処理。
	 * <p>
	 * ログイン画面アクションフォームからボタン名を取得する。
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
	 * <p>
	 * ログイン画面アクションフォームにボタン名を設定する。
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
	 * ログイン画面アクションフォームからメッセージを取得する。
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
	 * ログイン画面アクションフォームにメッセージを設定する。
	 * </p>
	 *
	 * @param message メッセージ
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * パスワード取得処理。
	 * <p>
	 * ログイン画面アクションフォームからパスワードを取得する。
	 * </p>
	 *
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワード設定処理。
	 * <p>
	 * ログイン画面アクションフォームにパスワードを設定する。
	 * </p>
	 *
	 * @param message パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 管理者フラグ取得処理。
	 * <p>
	 * ログイン画面アクションフォームから管理者フラグを取得する。
	 * </p>
	 *
	 * @return 管理者フラグ
	 */
	public String getManager() {
		return manager;
	}
	
	/**
	 * 管理者フラグ設定処理。
	 * <p>
	 * ログイン画面アクションフォームに管理者フラグを設定する。
	 * </p>
	 *
	 * @param message 管理者フラグ
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	
}

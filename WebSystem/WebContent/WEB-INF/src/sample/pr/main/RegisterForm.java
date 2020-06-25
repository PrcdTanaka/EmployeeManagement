package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class RegisterForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String employee_no;
	/** パスワード */
	private String password;
	/** ボタン名 */
	private String button;

	private String message;

	/**
	 * 初期化処理。
	 * <p>
	 * 社員登録画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		employee_no = "";
		button = "";
		password = "";
		message = "";
	}

	/**
	 * 社員番号取得処理。
	 * <p>
	 * 社員登録画面アクションフォームから社員番号を取得する。
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
	 * 社員登録画面アクションフォームに社員番号を設定する。
	 * </p>
	 *
	 * @param employee_no 社員番号
	 */
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	/**
	 * ボタン名取得処理。
	 * <p>
	 * 社員登録画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getButton() {

		if(button.equals("ã­ã°ã¤ã³")){
			button = "register";
		}

		return button;
	}

	/**
	 * ボタン名設定処理。
	 * <p>
	 * 社員登録画面アクションフォームにボタン名を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setButton(String button) {
		this.button = button;
	}

	/**
	 * パスワード取得処理。
	 * <p>
	 * 社員登録画面アクションフォームからパスワードを取得する。
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
	 * 社員登録画面アクションフォームにパスワードを設定する。
	 * </p>
	 *
	 * @param message パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * メッセージ取得処理。
	 * <p>
	 * 社員登録画面アクションフォームからメッセージを取得する。
	 * </p>
	 *
	 * @return メッセージ
	 */
	public String getMassage() {
		return message;
	}

	/**
	 * メッセージ設定処理。
	 * <p>
	 * 社員登録画面アクションフォームにメッセージを設定する。
	 * </p>
	 *
	 * @param message メッセージ
	 */
	public void setMassage(String Massage) {
		this.message = Massage;
	}
}

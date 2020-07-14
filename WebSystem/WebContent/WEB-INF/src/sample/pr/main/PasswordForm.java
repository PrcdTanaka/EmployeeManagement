package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class PasswordForm extends ActionForm {

	/** 社員番号 */
	private String employee_no;
	/** 古いパスワード */
	private String oldpassword;
	/** 新しいパスワード1 */
	private String newpassword1;
	/** 新しいパスワード2 */
	private String newpassword2;
	/** ボタン名 */
	private String button;
	/** メッセージ */
	private String message;
	private String dbpassword;

	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		employee_no = "";
		oldpassword = "";
		newpassword1 = "";
		newpassword2 = "";
		button = "";
		message = "";
		dbpassword = "";
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
	 * 古いパスワード取得処理。
	 * <p>
	 * メイン画面アクションフォームから古いパスワードを取得する。
	 * </p>
	 *
	 * @return 古いパスワード
	 */
	public String getOldpassword() {
		return oldpassword;
	}

	/**
	 * 古いパスワード設定処理。
	 * <p>
	 * パスワードフォームに古いパスワードを設定する。
	 * </p>
	 *
	 * @param oldpassword 古いパスワード
	 */
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	/**
	 * 新しいパスワード1取得処理。
	 * <p>
	 * メイン画面アクションフォームから新しいパスワード1を取得する。
	 * </p>
	 *
	 * @return 新しいパスワード1
	 */
	public String getNewpassword() {
		return newpassword1;
	}

	/**
	 * 新しいパスワード1設定処理。
	 * <p>
	 * パスワードフォーム新しいパスワード1を設定する。
	 * </p>
	 *
	 * @param newpassword 新しいパスワード1
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword1 = newpassword;
	}

	/**
	 * 新しいパスワード2取得処理。
	 * <p>
	 * メイン画面アクションフォームから新しいパスワード2を取得する。
	 * </p>
	 *
	 * @return 新しいパスワード2
	 */
	public String getNewpassword2() {
		return newpassword2;
	}

	/**
	 * 新しいパスワード2設定処理。
	 * <p>
	 * パスワードフォーム新しいパスワード2を設定する。
	 * </p>
	 *
	 * @param newpassword 新しいパスワード2
	 */
	public void setNewpassword2(String newpassword) {
		this.newpassword2 = newpassword;
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

	/**
	 * ログインしているユーザーのパス取得処理。
	 * <p>
	 * パスワード変更画面アクションフォームからログインしているユーザーのパスを取得する。
	 * </p>
	 *
	 * @return DBパスワード
	 */
	public String getDbpassword() {
		return dbpassword;
	}
	/**
	 * ログインしているユーザーのパス設定処理。
	 * <p>
	 * パスワードフォームにDBパスワードを設定する。
	 * </p>
	 *
	 * @param DBパスワード
	 */
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

}

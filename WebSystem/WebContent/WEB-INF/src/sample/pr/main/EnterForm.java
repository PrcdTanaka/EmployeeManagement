package sample.pr.main;

import java.util.List;

import org.apache.struts.action.ActionForm;

public final class EnterForm extends ActionForm {

	// コンストラクタ
	public EnterForm(){

	}
	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String employee_no;
	/** 社員氏名 */
	private String employee_name;
	/** ボタン名 */
	private String button;
	/** リンク先 */
	private String link;
	/**チェックリスト**/
	private String checklist;

	private List<String> Entry_emp;
	private List<String> Day;
	private List<String> Entry_time;
	private List<String> Leaving_time;
	private List<String> Leaving_emp;

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
		checklist = "";
		link = "";
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
	 * <p>
	 * チェックリストを取得する
	 * </p>
	 *
	 * @return チェックリスト
	 */
	public String getChecklist() {
		return checklist;
	}

	/**
	 * 管理者フラグ設定処理。
	 * <p>
	 * ログイン画面アクションフォームに管理者フラグを設定する。
	 * </p>
	 *
	 * @param checklist チェック状況
	 */
	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
	/**
	 * リンク先取得処理。
	 * <p>
	 * メイン画面アクションフォームからリンク先を取得する。
	 * </p>
	 *
	 * @return リンク先
	 */
	public String getLink() {
		return link;
	}

	/**
	 * リンク先設定処理。
	 * <p>
	 * メイン画面アクションフォームにリンク先を設定する。
	 * </p>
	 *
	 * @param message リンク先
	 */
	public void setLink(String link) {
		this.link = link;
	}

	public void setENTRY_EMP(String ENTRY_EMP){
		this.Entry_emp.add(ENTRY_EMP);
	}

	public void setDAY(String DAY){
		this.Day.add(DAY);
	}
	public void setENTRY_TIME(String ENTRY_TIME){
		this.Entry_time.add(ENTRY_TIME);
	}
	public void setLEAVING_TIME(String LEAVING_TIME){
		this.Leaving_time.add(LEAVING_TIME);
	}
	public void setLEAVING_EMP(String LEAVING_EMP){
		this.Leaving_emp.add(LEAVING_EMP);
	}

	public List<String> getENTRY_EMP() {
		return Entry_emp;
	}
	public List<String> getDAY() {
		return Day;
	}
	public List<String> getENTRY_TIME() {
		return Entry_time;
	}
	public List<String>getLEAVING_TIME () {
		return Leaving_time;
	}
	public List<String> getLEAING_EMP() {
		return Leaving_emp;
	}


}
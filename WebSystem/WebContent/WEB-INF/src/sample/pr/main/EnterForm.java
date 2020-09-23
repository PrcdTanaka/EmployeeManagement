package sample.pr.main;

import java.util.ArrayList;
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
	private int checklist;

	private String floor;

	private List<String> Employee_name;
	private List<String> Day;
	private List<String> Entry_time;
	private List<String> Leaving_time;
	private List<String> Leaving_name;
	private List<String> Check_list;

	/**
	 * 初期化処理。
	 * <p>
	 * ログイン画面アクションフォームを初期化する。
	 * </p>
	 */
	{
		Employee_name=new ArrayList<String>();
		Day=new ArrayList<String>();
		Entry_time=new ArrayList<String>();
		Leaving_name=new ArrayList<String>();
		Leaving_time=new ArrayList<String>();
		Check_list=new ArrayList<String>();

		employee_no = "";
		employee_name = "";
		button = "";
		checklist = 0;
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
	public int getChecklist() {
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
	public void setChecklist(String[] checklist) {
		for(String check:checklist)
		{
		this.checklist += Integer.parseInt(check);
		}
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

	public void setEMPLOYEE_NAME(String EMPLOYEE_NAME){
		this.Employee_name.add(EMPLOYEE_NAME);
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
	public void setLEAVING_NAME(String LEAVING_NAME){
		this.Leaving_name.add(LEAVING_NAME);
	}
	public void setCHECK_LIST(String CHECK_LIST){
		this.Check_list.add(CHECK_LIST);
	}


	public List<String> getEMPLOYEE_NAME() {
		return Employee_name;
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
	public List<String> getLEAVING_NANE() {
		return Leaving_name;
	}
	public List<String> getCHECK_LIST() {
		return Check_list;
	}

	public String getFloor() {
		return floor;
	}

	/**
	 * リンク先設定処理。
	 * <p>
	 * メイン画面アクションフォームにリンク先を設定する。
	 * </p>
	 *
	 * @param message リンク先
	 */
	public void setFloor(String floor) {
		if(floor.length()<1)
			this.floor = floor;
		else
			this.floor= floor.substring(0,1);
	}

	public void clearList(){
		Employee_name.clear();
		Day.clear();
		Entry_time.clear();
		Leaving_time.clear();
		Leaving_name.clear();
		Leaving_time.clear();
		Check_list.clear();

	}

	public void setEMPLOYEE_NO(String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public String getLeaving_name() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
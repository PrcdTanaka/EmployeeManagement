package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KinmuRecordForm extends ActionForm{
	//DBのテーブルにあるもの
	private String employeeNum;
	private String kintaiYMD;
	private String holidayDiv;
	private String startTime;
	private String endTime;
	private String expectation;
	private String breakTimeA;
	private String breakTimeB;
	private String vacationDiv;
	private String remark;

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	//DBのテーブルにないもの
	private String button;
	private String employeeName;
	private String message;

	public void initialize(){
		button="";
		employeeNum = "";
		message = "";
	}

	//社員番号
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	//年月日
	public String getKintaiYMD() {
		return kintaiYMD;
	}
	public void setKintaiYMD(String kintaiYMD) {
		this.kintaiYMD = kintaiYMD;
	}
	//休日/祝日の区分
	public String getHolidayDiv() {
		return holidayDiv;
	}
	public void setHolidayDiv(String holidayDiv) {
		switch(holidayDiv){
			case "1":
				this.holidayDiv = "休";
				break;
			case "2":
				this.holidayDiv = "祝日";
				break;
		}
	}
	//出勤時間
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	//退勤時間
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	//予定勤務時間
	public String getExpectation() {
		return expectation;
	}
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	//休憩A
	public String getBreakTimeA() {
		return breakTimeA;
	}
	public void setBreakTimeA(String breakTimeA) {
		this.breakTimeA = breakTimeA;
	}
	//休憩B
	public String getBreakTimeB() {
		return breakTimeB;
	}
	public void setBreakTimeB(String breakTimeB) {
		this.breakTimeB = breakTimeB;
	}
	//休暇区分
	public String getVacationDiv() {
		return vacationDiv;
	}
	public void setVacationDiv(String vacationDiv) {
		this.vacationDiv = vacationDiv;
	}
	//備考
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//ボタン
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	//社員名
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	//メッセージ
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}




}

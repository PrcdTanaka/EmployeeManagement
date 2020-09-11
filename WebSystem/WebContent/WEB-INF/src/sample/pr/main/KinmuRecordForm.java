package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KinmuRecordForm extends ActionForm{
	//DBのテーブルにあるもの
	private String employeeNum;
	private String kintaiYMD;

	private String holidayDiv1;
	private String holidayDiv2;
	private String holidayDiv3;



	private String startTime;
	private String endTime;
	private String breakTimeA;
	private String breakTimeB;
	private String vacationDiv;
	private String remark;

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
	public void setHolidayDiv1(String holidayDiv1) {
		switch(holidayDiv1){
		case "1":
			this.holidayDiv1 = "休";
			break;
		case"2":
			this.holidayDiv1 = "祝日";
			break;
		}
	}

	public String getHolidayDiv2() {
		return holidayDiv2;
	}

	public void setHolidayDiv2(String holidayDiv2) {
		switch(holidayDiv2){
		case "1":
			this.holidayDiv2 = "休";
			break;
		case"2":
			this.holidayDiv2 = "祝日";
			break;
		}
	}

	public String getHolidayDiv3() {
		return holidayDiv3;
	}

	public void setHolidayDiv3(String holidayDiv3) {
		switch(holidayDiv3){
		case "1":
			this.holidayDiv3 = "休";
			break;
		case"2":
			this.holidayDiv3 = "祝日";
			break;
		}
	}

//	public String getHolidayDiv() {
//		return holidayDiv;
//	}
//	public void setHolidayDiv(String holidayDiv) {
//		for(int i=1; i<=31; i++){
//			switch(holidayDiv){
//			case "1":
//				this.holidayDiv = "休";
//				break;
//			case"2":
//				this.holidayDiv = "祝日";
//				break;
//			}
//		}
//	}
	//出勤時間
	public String getStartTime() {
		return startTime;
	}
	public String getHolidayDiv1() {
		return holidayDiv1;
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

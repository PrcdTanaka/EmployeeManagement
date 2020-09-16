package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KinmuRecordForm extends ActionForm{
	//DBのテーブルにあるもの
	private String employeeNum;

	private String kintaiYMD1;
	private String kintaiYMD2;

	private String holidayDiv1;
	private String holidayDiv2;
	private String startTime1;
	private String startTime2;
	private String endTime1;
	private String endTime2;
	private String expectation1;
	private String expectation2;
	private String breakTimeA1;
	private String breakTimeA2;
	private String breakTimeB1;
	private String breakTimeB2;
	private String vacationDiv1;
	private String vacationDiv2;
	private String remark1;
	private String remark2;




	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	//DBのテーブルにないもの
	private String button;
	private String employeeName;
	private String message;

	{
		button="";
		employeeNum = "4321";
		message = "";

		kintaiYMD1="20200801";
		kintaiYMD2="20200802";
		holidayDiv1="";
		holidayDiv2="";
		startTime1="";
		startTime2="";
		endTime1="";
		endTime2="";
		expectation1="";
		expectation2="";
		breakTimeA1="";
		breakTimeA2="";
		breakTimeB1="";
		breakTimeB2="";
		vacationDiv1="";
		vacationDiv2="";
		remark1="";
		remark2="";
	}
	//社員番号
	public String getEmployeeNum() {return employeeNum;}
	public void setEmployeeNum(String employeeNum) {this.employeeNum = employeeNum;}
	//年月日
	public String getKintaiYMD1() {return kintaiYMD1;}
	public String getKintaiYMD2() {return kintaiYMD2;}
	public void setKintaiYMD1(String kintaiYMD1) {this.kintaiYMD1 = kintaiYMD1;}
	public void setKintaiYMD2(String kintaiYMD2) {this.kintaiYMD2 = kintaiYMD2;}
	//休日/祝日
	public String getHolidayDiv1() {return holidayDiv1;}
	public String getHolidayDiv2() {return holidayDiv2;}
	public void setHolidayDiv1(String holidayDiv1) {
		switch(holidayDiv1){case "1":this.holidayDiv1 = "休";
							break;
							case "2":this.holidayDiv1 = "祝日";
							break;}
	}
	public void setHolidayDiv2(String holidayDiv2) {
		switch(holidayDiv2){case "1":
							this.holidayDiv2 = "休";
							break;
							case "2":
								this.holidayDiv2 = "祝日";
								break;}
	}
	//出社時間
	public String getStartTime1() {return startTime1;}
	public String getStartTime2() {return startTime2;}
	public void setStartTime1(String startTime1) {this.startTime1 = startTime1;}
	public void setStartTime2(String startTime2) {this.startTime2 = startTime2;}
	//退社時間
	public String getEndTime1() {return endTime1;}
	public String getEndTime2() {return endTime2;}
	public void setEndTime1(String endTime1) {this.endTime1 = endTime1;}
	public void setEndTime2(String endTime2) {this.endTime2 = endTime2;}
	//予定勤務時間
	public String getExpectation1() {return expectation1;}
	public String getExpectation2() {return expectation2;}
	public void setExpectation1(String expectation1) {this.expectation1 = expectation1;}
	public void setExpectation2(String expectation2) {this.expectation2 = expectation2;}
	//休憩時間A
	public String getBreakTimeA1() {return breakTimeA1;}
	public String getBreakTimeA2() {return breakTimeA2;}
	public void setBreakTimeA1(String breakTimeA1) {this.breakTimeA1 = breakTimeA1;}
	public void setBreakTimeA2(String breakTimeA2) {this.breakTimeA2 = breakTimeA2;}
	//休憩時間B
	public String getBreakTimeB1() {return breakTimeB1;}
	public String getBreakTimeB2() {return breakTimeB2;}
	public void setBreakTimeB1(String breakTimeB1) {this.breakTimeB1 = breakTimeB1;}
	public void setBreakTimeB2(String breakTimeB2) {this.breakTimeB2 = breakTimeB2;}
	//休暇区分
	public String getVacationDiv1() {return vacationDiv1;}
	public String getVacationDiv2() {return vacationDiv2;}
	public void setVacationDiv1(String vacationDiv1) {this.vacationDiv1 = vacationDiv1;}
	public void setVacationDiv2(String vacationDiv2) {this.vacationDiv2 = vacationDiv2;}
	//備考
	public String getRemark1() {return remark1;}
	public String getRemark2() {return remark2;}
	public void setRemark1(String remark1) {this.remark1 = remark1;}
	public void setRemark2(String remark2) {this.remark2 = remark2;}
	//ボタン
	public String getButton() {return button;}
	public void setButton(String button) {this.button = button;}
	//社員名
	public String getEmployeeName() {return employeeName;}
	public void setEmployeeName(String employeeName) {this.employeeName = employeeName;}
	//メッセージ
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
}

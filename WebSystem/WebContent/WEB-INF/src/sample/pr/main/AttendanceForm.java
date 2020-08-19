package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class AttendanceForm extends ActionForm {
	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String employee_no;

	/** 出勤時間 */
	private String start_time;

	/** 退勤時間 */
	private String end_time;

	/** 休憩時間 */
	private String rest_time;

	/** ボタン */
	private String Button;

	/** 初期化処理。*/
	public void initialize() {
		employee_no="";
		start_time="";
		end_time="";
		rest_time="";
		Button="";
	}
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setStart_time(String start_time){
		this.start_time=start_time;
	}

	public String getStart_time(){
		return start_time;
	}

	public void setEnd_time(String end_time){
		this.end_time=end_time;
	}
	public String getEnd_time(){
			return end_time;
	}
	public void setRest_time(String rest_time){
		switch(rest_time){
		case"0":
			this.rest_time="0000";
			break;
		case"1":
			this.rest_time="0015";
			break;
		case"2":
			this.rest_time="0030";
			break;
		case"3":
			this.rest_time="0045";
			break;
		case"4":
			this.rest_time="0100";
			break;
		case"5":
			this.rest_time="0115";
			break;
		case"6":
			this.rest_time="0130";
			break;
		case"7":
			this.rest_time="0145";
			break;
		case"8":
			this.rest_time="0200";
			break;
		}
	}

	public String getRest_time(){
		return rest_time;
	}

	public void setButton(String button){
		Button=button;
	}

	public String getButton() {
		return Button;
	}
}

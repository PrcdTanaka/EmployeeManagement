package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class AttendanceForm extends ActionForm {
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

	public String getEmployee_No() {
		return employee_no;
	}

	public void setStart_Time(String start_time){
		this.start_time=start_time;
	}

	public String getStart_Time(){
		return start_time;
	}

	public void setEnd_Time(String end_time){
		this.end_time=end_time;
	}
	public String getEnd_Time(){
			return end_time;
	}

	public void setRest_Time(String rest_time){
		this.rest_time=rest_time;
	}

	public String getRest_Time(){
		return rest_time;
	}

	public void setButton(String button){
		Button=button;
	}

	public String getButton() {
		return Button;
	}
}

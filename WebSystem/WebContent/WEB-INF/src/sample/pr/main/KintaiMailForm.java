package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KintaiMailForm extends ActionForm{
	private String Button;
	private String Employee_no;
	private String employee_name;

	public void initialize(){
		Button="";
		Employee_no="";
	}
	public void setButton(String button){
		Button=button;
	}
	public String getButton(){
		return Button;
	}
	public void setEmployee_no(String employee_no){
		this.Employee_no=employee_no;
	}
	public String getEmployee_no(){
		return Employee_no;
	}

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


}

package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class MonthlyReportForm extends ActionForm{
	private String Button;
	private String Employee_no;

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


}

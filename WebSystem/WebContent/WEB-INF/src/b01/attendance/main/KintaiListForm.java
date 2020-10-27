package b01.attendance.main;

import org.apache.struts.action.ActionForm;

public class KintaiListForm extends ActionForm
{
	private String Button;
	private String Employee_no;
	{
		Button = "";
		Employee_no="";

	}

	public String getButton()
	{
		return Button;
	}

	/*
	 *  日付ボタン選択処理
	 */
	public void setButton(String button)
	{
		this.Button=button;
	}

	public String getEmployee_no()
	{
		return  Employee_no;
	}

	/*
	 *  日付ボタン選択処理
	 */
	public void setEmployee_no(String  Employee_no)
	{
		this.Employee_no= Employee_no;
	}

}

package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KintaiListForm extends ActionForm
{
	private String Button;
	private String Employee_no;

	public void initalize()
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
		this.Button= Employee_no;
	}
}

package b01.attendance.main;

import org.apache.struts.action.ActionForm;

public class KintaiListForm extends ActionForm
{
	private String Button;
	{
		Button = "";
	}

	public String getButton()
	{
		return Button;
	}


	public void setButton(String button)
	{
		this.Button=button;
	}

}

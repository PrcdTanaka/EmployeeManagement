package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KintaiListForm extends ActionForm
{
	private String Button;

	public void initalize()
	{
		Button = "";
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
		switch(button)
		{
			case "1":

				break;
		}
	}
}

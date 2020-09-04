package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class KintaiMailForm extends ActionForm{
	private String Button;
	private String Employee_no;
	private String employee_name;
	private String CC;
	private String depart;
	private String division;
	private String bcc;
	private String spotcode;
	private String span;
	private String ptime;
	private String remark;
	private String perm;

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

	public void setCC(String CC){
		switch(CC){
		case "1":
			this.CC="1group_admin.ml@procd-k.co.jp";
			break;
		case "2":
			this.CC="2group_admin.ml@procd-k.co.jp";
			break;
		case "3":
			this.CC="3group_admin.ml@procd-k.co.jp";
			break;
		case "4":
			this.CC="4group_admin.ml@procd-k.co.jp";
			break;
		case "5":
			this.CC="5group_admin.ml@procd-k.co.jp";
			break;
		case "6":
			this.CC="solution_admin@procd-k.co.jp";
			break;
		}
	}

	public String getCC(){
		return CC;
	}

	public void setDepart(String depart){
		switch(depart){
		case "1":
			this.depart="第一技術部";
			break;
		case "2":
			this.depart="第二技術部";
			break;
		case "3":
			this.depart="第三技術部";
			break;
		case "4":
			this.depart="第四技術部";
			break;
		case "5":
			this.depart="第五技術部";
			break;
		case "6":
			this.depart="ソリューション技術部";
			break;
		}
	}

	public String getDepart(){
		return depart;
	}

	public void setDivision(String division){
		switch(division){
		case "1":
			this.division="1,遅刻";
			break;
		case "2":
			this.division="2,有給休暇";
			break;
		case "3":
			this.division="4,振替休暇";
			break;
		case "4":
			this.division="5,特別休暇";
			break;
		case "5":
			this.division="6,シフト勤務";
			break;
		case "6":
			this.division="7,早退、その他";
			break;
		case "7":
			this.division="8,交通遅延";
			break;
		case "8":
			this.division="9,欠席";
			break;
		case "9":
			this.division="A,深夜作業";
			break;
		case "10":
			this.division="B,休日出勤(振)";
			break;
		}
	}

	public String getDivision(){
		return division;
	}




	public void setBcc(String bcc){
		this.bcc=bcc;
	}

	public String getBcc(){
		return bcc;
	}

	public void setSpotcode(String spotcode){
		this.spotcode=spotcode;
	}

	public String getSpotcode(){
		return spotcode;
	}

	public void setSpan(String span){
		this.span=span;
	}

	public String getSpan(){
		return span;
	}
	public void setPtime(String ptime){
		this.ptime=ptime;
	}

	public String getPtime(){
		return ptime;
	}
	public void setRmark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}
	public void setPerm(String perm){
		this.perm=perm;
	}

	public String getPerm(){
		return perm;
	}

}

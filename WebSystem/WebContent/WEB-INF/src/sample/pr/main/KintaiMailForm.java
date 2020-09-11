package sample.pr.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class KintaiMailForm extends ActionForm{
	private String Button;
	private String Employee_no;
	private String employee_name;
	private String CC;
	private String depart;
	private List<String> division;
	private String bcc;
	private String spotcode;
	private List<String> span;
	private List<String> span2;
	private String ptime;
	private List<String> remark;
	private List<String> perm;
	private String message;
	private List<String> Mmdd;
	private List<String> Send_Time;

	{
		Button="";
		Employee_no="";
		message="";
		span=new ArrayList<String>();
		span2=new ArrayList<String>();
		division=new ArrayList<String>();
		remark=new ArrayList<String>();
		perm=new ArrayList<String>();
		Mmdd=new  ArrayList<String>();
		Send_Time=new ArrayList<String>();
	}
	public void setButton(String button){
		this.Button=button;
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
			this.division.add(division);
	}

	public List<String> getDivision(){
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
		this.span.add(span);
	}
	public List<String> getSpan(){
		return span;
	}
	public List<String> getSpan2(){
		return span2;
	}
	public void setSpan2(String span2){
		this.span2.add(span2);
	}

	public void setPtime(String ptime){
		this.ptime=ptime;
	}

	public String getPtime(){
		return ptime;
	}
	public void setRemark(String remark){
		this.remark.add(remark);
	}

	public List<String> getRemark(){
		return remark;
	}
	public void setPerm(String perm){
		this.perm.add(perm);
	}

	public List<String> getPerm(){
		return perm;
	}
	public void setMessage(String message){
		this.message=message;
	}

	public String getMessage(){
		return message;
	}
	public void setMmdd(String Mmdd){
		this.Mmdd.add(Mmdd);
	}

	public List<String> getMmdd(){
		return Mmdd;
	}
	public void setSend_Time(String Send_Time){
		this.Send_Time.add(Send_Time);
	}

	public List<String> getSend_Time(){
		return Send_Time;
	}

}

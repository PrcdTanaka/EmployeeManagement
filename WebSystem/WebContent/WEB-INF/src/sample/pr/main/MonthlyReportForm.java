package sample.pr.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class MonthlyReportForm extends ActionForm{
	private String Button;
	private List<String> spotcode;
	private String Employee_no;
	private List<String> CC;
	private List<String> BCC;
	private List<String> division;
	private List<String> span;
	private List<String> span2;
	private List<String> remark;
	private List<String> perm;
	private List<String> Mmdd;
	private List<String> Send_Time;

	{
		Button="";
		Employee_no="";
		CC = new ArrayList<String>();
		BCC = new ArrayList<String>();
		span=new ArrayList<String>();
		span2=new ArrayList<String>();
		division=new ArrayList<String>();
		remark=new ArrayList<String>();
		perm=new ArrayList<String>();
		Mmdd=new  ArrayList<String>();
		Send_Time=new ArrayList<String>();
		spotcode=new ArrayList<String>();
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

	public void setCc(String CC){
		this.CC.add(CC);
	}
	public List<String> getCc(){
		return CC;
	}

	public void setBcc(String BCC){
		this.BCC.add(BCC);
	}
	public List<String> getBcc(){
		return BCC;
	}

	public void setDivision(String division){
			this.division.add(division);
	}

	public List<String> getDivision(){
		return division;
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
	public void setSpotcode(String spotcode){
		this.spotcode.add(spotcode);
	}

	public List<String> getSpotcode(){
		return spotcode;
	}
}

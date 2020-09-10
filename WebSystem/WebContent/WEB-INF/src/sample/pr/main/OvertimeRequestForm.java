package sample.pr.main;

import org.apache.struts.action.ActionForm;

public class OvertimeRequestForm extends ActionForm{
	private String Button;
	private String depart;
	private String Employee_no;
	private String employee_name;
	private String workNum;
	private String workName;
	private String startYmd;
	private String endYmd;
	private String workMember;
	private String workContent1;
	private String workStartPeriod1;
	private String workEndPeriod1;
	private String workContent2;
	private String workStartPeriod2;
	private String workEndPeriod2;
	private String workContent3;
	private String workStartPeriod3;
	private String workEndPeriod3;
	private String overtimeReason;
	private String message;

	private String CC;
	private String division;
	private String bcc;
	private String spotcode;
	private String span;
	private String span2;
	private String ptime;
	private String remark;
	private String perm;

	//ボタン、所属部署、社員番号、表示するメッセージは空文字で初期化
	public void initialize(){
		Button="";
		depart="";
		Employee_no="";
		message="";
	}

	//ボタンに値をセット&ゲット
	public void setButton(String button){
		this.Button=button;
	}
	public String getButton(){
		return Button;
	}

	//社員番号をDBから取得しセット
	public void setEmployee_no(String employee_no){
		this.Employee_no=employee_no;
	}
	public String getEmployee_no(){
		return Employee_no;
	}

	//社員名をDBから取得しセット
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_name() {
		return employee_name;
	}

	//画面上で手入力された工番をセット&ゲット
	public void setWorkNum(String workNum){
		this.workNum = workNum;
	}
	public String getWorkNum(){
		return workNum;
	}

	//画面上で手入力された作業名称をセット&ゲット
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getWorkName() {
		return workName;
	}

	//画面上で手入力された開始年月日をセット&ゲット
	public void setStartYmd(String startYmd) {
		this.startYmd = startYmd;
	}
	public String getStartYmd() {
		return startYmd;
	}

	//画面上で手入力された終了年月日をセット&ゲット
	public void setEndYmd(String endYmd) {
		this.endYmd = endYmd;
	}
	public String getEndYmd() {
		return endYmd;
	}



	public String getWorkMember() {
		return workMember;
	}

	public void setWorkMember(String workMember) {
		this.workMember = workMember;
	}

	public String getWorkContent1() {
		return workContent1;
	}

	public void setWorkContent1(String workContent1) {
		this.workContent1 = workContent1;
	}

	public String getWorkStartPeriod1() {
		return workStartPeriod1;
	}

	public void setWorkStartPeriod1(String workStartPeriod1) {
		this.workStartPeriod1 = workStartPeriod1;
	}

	public String getWorkEndPeriod1() {
		return workEndPeriod1;
	}

	public void setWorkEndPeriod1(String workEndPeriod1) {
		this.workEndPeriod1 = workEndPeriod1;
	}

	public String getWorkContent2() {
		return workContent2;
	}

	public void setWorkContent2(String workContent2) {
		this.workContent2 = workContent2;
	}

	public String getWorkStartPeriod2() {
		return workStartPeriod2;
	}

	public void setWorkStartPeriod2(String workStartPeriod2) {
		this.workStartPeriod2 = workStartPeriod2;
	}

	public String getWorkEndPeriod2() {
		return workEndPeriod2;
	}

	public void setWorkEndPeriod2(String workEndPeriod2) {
		this.workEndPeriod2 = workEndPeriod2;
	}

	public String getWorkContent3() {
		return workContent3;
	}

	public void setWorkContent3(String workContent3) {
		this.workContent3 = workContent3;
	}

	public String getWorkStartPeriod3() {
		return workStartPeriod3;
	}

	public void setWorkStartPeriod3(String workStartPeriod3) {
		this.workStartPeriod3 = workStartPeriod3;
	}

	public String getWorkEndPeriod3() {
		return workEndPeriod3;
	}

	public void setWorkEndPeriod3(String workEndPeriod3) {
		this.workEndPeriod3 = workEndPeriod3;
	}

	public String getOvertimeReason() {
		return overtimeReason;
	}

	public void setOvertimeReason(String overtimeReason) {
		this.overtimeReason = overtimeReason;
	}

	//以下は必要なければ削除
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
	public String getSpan2(){
		return span2;
	}
	public void setSpan2(String span2){
		this.span2=span2;
	}

	public void setPtime(String ptime){
		this.ptime=ptime;
	}

	public String getPtime(){
		return ptime;
	}
	public void setRemark(String remark){
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
	public void setMessage(String message){
		this.message=message;
	}

	public String getMessage(){
		return message;
	}

}

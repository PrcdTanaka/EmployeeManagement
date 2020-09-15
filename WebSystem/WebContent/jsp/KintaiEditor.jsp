<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.KintaiMailForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.pr.main.MonthlyReportForm"%>
<%@ page import="sample.pr.main.MonthlyReportAction"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.String" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<html:html>
<head>
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/KintaiMail.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<style>
.btn1{
	font-weight: bold;
    text-decoration: none;
    text-align: center;
    padding: 8px;
    color: #fff;
    background-color: #49a9d4;
    border-radius: 10px;
    font-weight: bold;
    color:white;
  }

</style>
<body>

	<html:form action="/KintaiMailAction">
		<%
			String Email = "kintai@procd-k.co.jp";
					String Employee_no = "";
					String name = "";
					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					KintaiMailForm Form = new KintaiMailForm();
					String CC = Form.getCC();
					String depart = Form.getDepart();
					String division = Form.getDivision();
					String bcc = Form.getBcc();
					String spotcode = Form.getSpotcode();
					String span = Form.getSpan();
					String span2 = Form.getSpan2();
					String ptime = Form.getPtime();
					String remark = Form.getRemark();
					String perm = Form.getPerm();
					try {
						Employee_no = s.getEmployee_no();
						name = s.getEmployee_name();
					} catch (Exception e) {
					}
		%>
		<%
			boolean flg = false;

			Calendar cale = Calendar.getInstance();
			MonthlyReportForm form=new MonthlyReportForm();
			int monthlastDay = cale.getActualMaximum(Calendar.DATE);
			LoginForm lForm=(LoginForm)session.getAttribute("form");
			form.setEmployee_no(lForm.getEmployee_no());

			dba.getMonthly_report(form);
			List<String> Span = form.getSpan();
			List<String>Span2=form.getSpan2();
			List<String>Mmdd=form.getMmdd();
			int listnumber=0;
		%>
		<%
			// 現在のURLを取得して、年月日を切り抜く
			String Year = "";
			String Month = "";
			String Day = "";
			StringBuffer url = request.getRequestURL();
			url.append("?").append(request.getQueryString());
			String MyUrl = url.substring(53);
			String[] fMyUrl = MyUrl.split("year=", 0);
			String[] fMyUrl2 = fMyUrl[1].split("&month=", 0);
			Year = fMyUrl2[0];
			String[] fMyUrl3 = fMyUrl2[1].split("&day=", 0);
			Month = fMyUrl3[0];
			Day = fMyUrl3[1];

			int Max_Days = 30;
			String Zero = "0";
			boolean val_flg = false;
			int int_span1_lst = 0;
		%>
		<%
			if(Month.length() == 1)
			{
				Month = Zero + Month;
			}
			if(Day.length() == 1)
			{
				Day = Zero + Day;
			}
			String str_Date = Year + Month + Day;
		%>
		<%
			// DBのspan1のデータを配列の要素に格納
			int kintai_span = 0;
			String[] kintai_span_lst = new String[Max_Days];

			for(int Target_day = 0; Target_day < Span.size(); Target_day++)
			{
				kintai_span_lst[kintai_span] = Span.get(Target_day);
				kintai_span++;
			}
		%>
		<div>
		<center>
			<%
				if(flg == false){
			%>
				<h1>勤怠画面</h1>
			<%
				}else{
			%>
				<h1>勤怠編集画面</h1>
			<%
				}
			%>
		</center>
		</div>
		<%
			// 配列の要素に対象期間のspanがあるか確認
			// 対象期間があれば、DBの情報表示
			for(int span1_calm = 0; span1_calm < Span.size(); span1_calm++)
			{
				// 2回目以降の実施を防ぐガード
				if(val_flg == true)
				{
					break;
				}
		%>
			<%
				//int int_span1_lst = Integer.parseInt(kintai_span_lst[span1_calm]);
				if(kintai_span_lst[span1_calm].equals(str_Date))
				{
					val_flg = true;
					int_span1_lst = Integer.parseInt(kintai_span_lst[span1_calm]);
			%>
		<p style="margin-left: -44%;">
		<p align="center" style="margin-left: -45%">
			宛先:<%=Email%></p>

		<div align="center" class="depert">
			CC:
			<%
				if(flg == true){
			%>
				<html:select property="CC" styleId="CC" name="KintaiMailForm"
				style="font-size:15px;width:60%">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
			</html:select>
			<%
				}
				else{
			%>
				<html:select disabled="true" property="CC" styleId="CC" name="KintaiMailForm"
				style="font-size:15px;width:60%">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
			</html:select>
			<%
				}
			%>
		</div>
		<p align="center" class="BCC">
				BCC:

				<%
					if(flg == true){
				%>
					<html:text property="bcc" size="20" maxlength="40" style="font-size: 15px; width: 60%" value="<%=bcc%>" />
				<%
					}
					else{
				%>
					<html:text disabled="true" property="bcc" size="20" maxlength="40" style="font-size: 15px; width: 60%" value="<%=bcc%>" />
				<%
					}
				%>
				<p style="color:red;margin-left: 17%">※ 任意で入力
		</p>

		<div align="center" class="depert2"
			style="margin-top: 50px; width: 40%; margin-left: 10%;">
			所属部署:
			<%
				if(flg == true){
			%>
			<html:select property="depart" styleId="depart" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
			</html:select>
			<%
				}
				else{
			%>
			<html:select disabled="true" property="depart" styleId="depart" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
			</html:select>
			<%
				}
			%>
		</div>

		<p align="center" style="margin-left: -60%;">
			社員番号：<%=Employee_no%>
		</p>
		<p align="center" class="BCC" style="margin-left: -55%;">
			氏名：<%=name%>
		</p>
		<p align="center" class="code" style="margin-left: -42%">
			現場コード：
			<%
				if(flg == true){
			%>
			<html:text property="spotcode" size="20" maxlength="6" style="width: 17%" value="<%=spotcode%>" />
			<%
				}
				else{
			%>
			<html:text disabled="true" property="spotcode" size="20" maxlength="6" style="width: 17%" value="<%=spotcode%>" />
			<%
				}
			%>
			<p style="color:red;margin-left: 13%">例) 1-2345
		</p>
		<div align="center" class="depert2"
			style="width: 40%; margin-left: 10%">
			届出区分:
			<%
				if(flg == true){
			%>
			<html:select property="division" styleId="division" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">1,遅刻</html:option>
				<html:option value="2">2,有給休暇</html:option>
				<html:option value="3">4,振替休暇</html:option>
				<html:option value="4">5,特別休暇</html:option>
				<html:option value="5">6,シフト勤務</html:option>
				<html:option value="6">7,早退,その他</html:option>
				<html:option value="7">8,交通遅延</html:option>
				<html:option value="8">9,欠席</html:option>
				<html:option value="9">A,深夜作業</html:option>
				<html:option value="10">B,休日出勤(振)</html:option>
			</html:select>
			<%
				}
				else{
			%>
			<html:select disabled="true" property="division" styleId="division" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">1,遅刻</html:option>
				<html:option value="2">2,有給休暇</html:option>
				<html:option value="3">4,振替休暇</html:option>
				<html:option value="4">5,特別休暇</html:option>
				<html:option value="5">6,シフト勤務</html:option>
				<html:option value="6">7,早退,その他</html:option>
				<html:option value="7">8,交通遅延</html:option>
				<html:option value="8">9,欠席</html:option>
				<html:option value="9">A,深夜作業</html:option>
				<html:option value="10">B,休日出勤(振)</html:option>
			</html:select>
			<%
				}
			%>
		</div>
		<p align="center" class="code" style="margin-left: -6%">
			対象日付/期間(開始)：


						<html:text disabled="true" property="span" size="20" maxlength="8" style="width: 17%" value="<%=kintai_span_lst[span1_calm]%>" />




			<%-- <%
				if(flg == true){
			%>
				<html:text property="span" size="20" maxlength="8" style="width: 17%" value="<%=span%>" />
			<%
				}
				else{
			%>
				<html:text disabled="true" property="span" size="20" maxlength="8" style="width: 17%" value="<%=span%>" />
			<%
				}
			%> --%>
			～対象日付/期間(終了)：
			<%
				if(flg == true){
			%>
				<html:text property="span2" size="20" maxlength="8" style="width: 17%" value="<%=span2%>" />
			<%
				}
				else{
			%>
				<html:text disabled="true" property="span2" size="20" maxlength="8" style="width: 17%" value="<%=span2%>" />
			<%
				}
			%>
			<p style="color:red;margin-left: 12%">例) 2020年9月1日～2020年9月3日 → 20200901～20200903
		</p>
		<p align="center" class="code" style="margin-left: -43%">
			出勤予定時刻:
			<%
				if(flg == true){
			%>
				<html:text property="ptime" size="43" maxlength="5" style="width: 17%" value="<%=ptime%>" />
			<%
				}
				else{
			%>
			<html:text disabled="true" property="ptime" size="43" maxlength="5" style="width: 17%" value="<%=ptime%>" />
			<%
				}
			%>
			<p style="color:red;margin-left: 12%">例) 12:00

		</p>
		<p style="margin-left: 17.5%;">備考:</p>
		<div style="margin-left: 21%;">
			<%
				if(flg == true){
			%>
			<html:textarea property="remark" rows="10" cols="100" value="<%=remark%>"></html:textarea>
			<%
				}
				else{
			%>
			<html:textarea disabled="true" property="remark" rows="10" cols="100" value="<%=remark%>"></html:textarea>
			<%
				}
			%>
		</div>

		<p align="center" class="code" style="margin-left: -39%">
			許可:
			<%
				if(flg == true){
			%>
			<html:text property="perm" size="43" maxlength="4" style="width: 17%" value="<%=perm%>" />
			<%
				}
				else{
			%>
			<html:text disabled="true" property="perm" size="43" maxlength="4" style="width: 17%" value="<%=perm%>" />
			<%
				}
			%>
			<p style="color:red;margin-left: 17%">※ 届出区分がA,Bの場合、姓のみ記載
		</p>
			<%
				}
			%>
		<%
			}
		%>
<%--
		<div>
			<html:submit property="button" styleClass="btn" value="送信"
				styleId="kintaimail" style="margin-top:10;" />
		</div>
--%>
		<div>
		<ul style="list-style:none;text-align:center;margin-top:14px;">
			<li><a class="btn1" href="javascript:history.back()" >戻る</a></li>
		</ul>
		</div>
	</html:form>
</body>
</html:html>

</html>
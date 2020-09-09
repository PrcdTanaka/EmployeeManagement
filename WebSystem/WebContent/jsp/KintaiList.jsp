<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.KintaiListForm"%>

<%@ page import="java.util.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.sql.*" %>

<%!
	public void jspInit()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
%>
<html lang="ja">
<html:html>

<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<link rel="stylesheet" type="text/css" href="../css/main.css"/>

<style type="text/css">
<!--
	*{padding:5px; margin:0px;}
	body{text-align:center;}
	table{witdth:800px; background:white; border:2px black solid; border-radius:10px; margin-left:auto; margin-right:auto;}
	th{border:1px black solid; background:#00FFFF; padding-left: 10px; padding-right: 10px;}
	td{border:1px black solid; text-align:center; padding:1px 1px 1px 1px;}
	br{line-height:1em;}
-->
</style>
<META HTTP-EQUIV="Content-Type" CONTENT="text/http;charset=Windows-31J">
</head>

<body>
	<html:form action="/KintaiListAction">
		<div>
			<center>
				<h1>勤怠一覧</h1>
			</center>
		</div>
		<br/>
		<br/>

		<%--
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:@" + gHost + ":1521:" + gSid,gUser,gPass);
				stmt = con.createStatement();
				rs = stmt.executeQuery("select * from kintaiMail");
			}
		--%>
		<%
		Calendar cale = Calendar.getInstance();

		String strYear=request.getParameter("year");
		String strMonth=request.getParameter("month");

		int intYear;
		int intMonth;

		if(strYear != null && strMonth != null)
		{
			int intMonthTemp=Integer.parseInt(strMonth);

			intMonth = intMonthTemp%12;
			intYear = Integer.parseInt(strYear)+intMonthTemp/12;
			if(intMonth==0)
			{
				intMonth=12;
				intYear--;
			}
			cale.set(Calendar.YEAR, intYear);
			cale.set(Calendar.MONTH, intMonth-1);
		}
		intYear=cale.get(Calendar.YEAR);
		intMonth=cale.get(Calendar.MONTH) +1;
		cale.set(Calendar.DATE, 1);

		int k = cale.get(Calendar.DAY_OF_WEEK) -1;
		%>
		<div class="head">
		<a href="http://localhost:8080/WebSystem/jsp/KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth-1 %>">前月</a>
		<span class="title"><%= intYear%>年<%=intMonth %>月</span>
		<a href="http://localhost:8080/WebSystem/jsp/KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth+1 %>">翌月</a>
		</div>

		<span class="validity"></span>
		<div class="fallbackDatePicker">
		<span>
			<%-- カレンダーのプルダウンメニュー作成(月のほう) --%>
			<select id="Years" name="Years">
			<%
				int num1 = 0;
				int num2 = 0;
				int Years_Data = cale.get(Calendar.YEAR);
				int Month_Data = cale.get(Calendar.MONTH)+1;
				for(int i = Years_Data-1; i <= Years_Data+1; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == Years_Data){
			%>
			selected
			<%
				}
			%>
			><%=i %>年
			</option>
			<%num1 = i; %>
			<%
				}
			%>
			</select>
			<%-- カレンダーのプルダウンメニュー作成(日のほう) --%>
			<select id="Months" name="Months">
			<%
				for(int i = 1; i<= 12; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == Month_Data){
			%>
			selected
			<%
				}
			%>
			><%=i %>月
			</option>
			<%num2=i; %>
			<%
				}
			%>
			</select>
		</span>

		<a href="http://localhost:8080/WebSystem/jsp/KintaiList.jsp?year=<%=Years_Data %>&month=<%=Month_Data %>">移動</a>
		<input type="submit" id="btn" name="submit" value="移動"/>
		</div>

		<br/>
		<table>
			<tr>
				<!--TH:Table Header-->
				<th class="holiday">日</th>
				<th class="weekday">月</th>
				<th class="weekday">火</th>
				<th class="weekday">水</th>
				<th class="weekday">木</th>
				<th class="weekday">金</th>
				<th class="saturday">土</th>
			</tr>
			<%
				int d=1;
				while(cale.get(Calendar.MONTH)==intMonth-1){
			%>
			<tr>
				<!--  -->
				<%
					for(int j=0; j<7; j++){
				%>
				<%
					if(j==0){
				%>
					<td class="holiday">
					<%
					}else if(j==6){
					%>
					<td class="saturday">
					<%}else{%>
					<td class="weekday">
					<%}%>
					<%
					if(k!=0){
						k--;
					}else if(cale.get(Calendar.MONTH)==intMonth-1){
					%>
				<%-- 	<%=d++%> --%>
					<form action="http://localhost:8080/WebSystem/jsp/KintaiMail.jsp" style="padding: 0em;">
					<input type="submit" id="Button" name="KintaiListForm" style="background-color:transparent; width:30px;" value="<%=d++ %>"/>
					</form>
					<%
					cale.add(Calendar.DATE, 1);
					%>
				<%-- <input type="submit" id="" name="" value="<%=d %>"/> --%>
					<%}%>
					</td>
				<%}%>
				</tr>
				<%}%>
		</table>

		<div style="position: relative; margin-top: 5%; align: center;" >
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="勤怠連絡入力"
				styleId="kintaimail"/>
		</div>
		<div  style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="勤怠月報画面へ"
				styleId="catalog"/>
		</div>
		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="戻る"
				styleId="main"/>
		</div>
	</html:form>
</body>
</html:html>
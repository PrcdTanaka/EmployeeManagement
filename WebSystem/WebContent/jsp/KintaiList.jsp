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

<html lang="ja">
<html:html>

<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<link rel="stylesheet" type="text/css" href="../css/main.css"/>

<style type="text/css">
<!--
	*{padding:5px; margin:0px;}
	body{text-align:center;}
	table{witdth:800px; backgroound:white; border:2px black solid; border-collapse:callapse;}
	th{border:1px black solid; background:#CCFFFF;}
	td{border:1px black solid; text-align:right; padding:5px 20px 5px 20px;}
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
		<b>カレンダーの変更</b>
		<br/>
		<div style="text-align:center;">
		<form action="CalenderAccess">

		<br/>
		<br/>
		<input type="submit" id="ok" name="ok" value="送信"/>
		</form>
		</div>

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
		<a href="KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth-1 %>">前月</a>
		<span class="title"><%= intYear%>年<%=intMonth %>月</span>
		<a href="KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth+1 %>">翌月</a>
		</div>

		<span class="validity"></span>
		<div class="fallbackDatePicker">
		<span>
			<%-- カレンダーのプルダウンメニュー作成(月のほう) --%>
			<select id="Years" name="Years">
			<%
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
			><%=i %>月</option>
			<%
				}
			%>
			</select>
		</span>

		<a href="KintaiList.jsp?year=<%=intYear %>&month=<%=intMonth %>">移動</a>
		<input type="submit" id="" name="" value="移動"/>
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
					<%=d++%>
					<%
					cale.add(Calendar.DATE, 1);
					%>
					<%}%>
					</td>
				<%}%>
				</tr>
				<%}%>
		</table>
		<div>
			<html:submit property="button" styleClass="btn" value="戻る" styleId="main" />
		</div>
	</html:form>
</body>
</html:html>
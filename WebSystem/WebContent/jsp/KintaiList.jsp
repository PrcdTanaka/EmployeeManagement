<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
</head>

<body>
	<html:form action="/KintaiListAction">
		<%
			String string_variable = " ";
		%>
		<div>
			<center>
				<h1>勤怠一覧</h1>
			</center>
		</div>

		<b><%=request.getAttribute("year") %>年<%=request.getAttribute("month") %>月のカレンダー</b>
		<br/>
		<br/>
		<%=request.getAttribute("calender") %>
		<br/>
		<b>カレンダーの変更</b>
		<br/>
		<div style="text-align:center;">
		<form action="KintaiListAction" method="get">
			<select id="year" name="year">
			<%
				int year = Integer.parseInt(request.getAttribute("year").toString());
				int month = Integer.parseInt(request.getAttribute("month").toString());
				for(int i = year-10; i <= year+10; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == year){
			%>
			selected
			<%
				}
			%>
			><%=i %>年</option>
			<%
				}
			%>
			</select>

			<select id="moneth" name="month">
			<%
				for(int i = 1; i<= 12; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == month){
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
			<br/>
			<br/>
			<input type="submit" id="ok" name="ok" value="送信"/>
			</form>
		</div>

		<div>
			<html:submit property="button" styleClass="btn" value="戻る" styleId="" />
		</div>
	</html:form>
</body>
</html:html>
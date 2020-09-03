
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="ja">
<html:html>
<head>
<link rel="stylesheet" type="text/css" href="../css/KintaiMail.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<body>
	<html:form action="/KintaiMailAction">
		<%
			String depertment = " ";
		%>
		<div>
			<center>
				<h1>勤怠連絡画面</h1>
			</center>
		</div>

		<p align="center">
			宛先：<input type="text" name="namae" size="40" maxlength="20">
		</p>
		<div align="center">cc:</div>
		<div align="center"  >
			<select name="DEPERT" style="width:35%">
				<option value="1">第一技術部</option>
				<option value="2">第二技術部</option>
				<option value="3">第三技術部</option>
				<option value="4">第四技術部</option>
				<option value="5">第五技術部</option>
				<option value="6">第六技術部</option>
				<option value="7">ソリューション技術部</option>
			</select>
		</div>
		<p align="center">
			BCC：<input type="text" name="namae" size="40" maxlength="20">
		</p>











	</html:form>
</body>
</html:html>
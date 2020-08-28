<%@page import="sample.pr.main.LoginForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.PasswordForm"%>

<html:html>
<head>
<html:base />
<title><bean:message key="password.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html lang="ja">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<table>
	<center>
		<h1>社員番号認証画面</h1>
	</center>
</table>
<%
 		String message;
 		try{
 			LoginForm lform=(LoginForm) session.getAttribute("form");
 			PasswordForm pForm = (PasswordForm) session.getAttribute("pForm");
 			message =  pForm.getMessage();
 			pForm.setEmployee_no(lform.getEmployee_no());
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 	%>
<body>
	<html:form action="/PasswordChangeAction">
		<div class="block">

		<br>
		<br>
			<center><%= message %></center>
		<br>
		<div>
			<center>社員番号：<html:text property="employee_no" value= "" maxlength="4" /></center>
		</div>
		<br>
		<!-- 変更ボタン -->
		<html:submit property="button" styleClass="btn" value="次へ" styleId="change" />
    	<!-- 戻るボタン -->
		<html:submit property="button" styleClass="btn" value="戻る" styleId="main" />

 			 </div>
	</html:form>
</body>
</html:html>
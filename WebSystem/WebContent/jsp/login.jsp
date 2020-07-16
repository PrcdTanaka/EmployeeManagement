<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.LoginForm" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="login.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<table>
		<center><h1>ログイン画面</h1></center>
	</table>
	
	<body>
	 	<%
 		String message;
 		try{
 			LoginForm s = (LoginForm) session.getAttribute("form");
 			message =  s.getMessage();
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 	%>
		<html:form action="/LoginAction" >
			<div class="block">

				<div class="space"></div>
				
				<center><%= message %></center>
				
				<!-- 社員番号入力欄 -->
				<div>
					<center>　　社員No：
						<html:text property="employee_no" maxlength="4" />
					</center>
				</div>
				<div>
					<center>パスワード：
						<html:password property="password" value= "" />
					</center>
				</div>

				<div class="space"></div>
				<br>
				<!-- ログインボタン -->
				<span><html:submit property="button" styleClass="btn" value="ログイン" styleId="login" /></span>

			</div>
		</html:form>
	</body>
</html:html>

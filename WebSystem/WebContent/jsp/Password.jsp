<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.PasswordForm" %>

<html:html>
	<head>
		<html:base/>
		<title><bean:message key="password.title"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<html lang="ja">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>

  	<table>
  		<center><h1>パスワード変更画面</h1></center>
  	</table>

  	 	<%
 		String message;
 		try{
 			PasswordForm pForm = (PasswordForm) session.getAttribute("pForm");
 			message =  pForm.getMessage();
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 	%>
 	<body>
  		<html:form action="/PasswordAction" >
			<div class="block">

				<div class="space"></div>
				<br>
				<br>
					<center><%= message %></center>
				<br>
				<div>
				    <center>  古いパスワード：<html:text property="oldpassword" value= ""/></center>
				</div>
				<div>
				    <center>新しいパスワード：<html:text property="newpassword1" value= ""/></center>
				</div>
				<div>
				    <center>新しいパスワード：<html:text property="newpassword2" value= ""/></center>
				</div>
				<div class="space"></div>
				<br>
				<!-- 変更ボタン -->
				<html:submit property="button" styleClass="btn" value="変更" styleId="change" />
    			<!-- 戻るボタン -->
				<html:submit property="button" styleClass="btn" value="戻る" styleId="main" />

				<div align="right">
		</div>
 			 </div>
   		 </html:form>
	 </body>
</html:html>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.RegisterForm" %>

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

 	<body>
  		<html:form action="/PasswordAction" >
			<div class="block">

				<div class="space"></div>
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
				<!-- 登録ボタン -->
				<span><html:submit property="button" styleClass="btn" style="margin-top:3px;font-size:25px;" value="変更"/></span>

    			<!-- 戻るボタン -->
    			<span><html:submit property="button" styleClass="btn" style="margin-top:3px;font-size:25px;" value="戻る"/></span>

 			 </div>
   		 </html:form>
	 </body>
</html:html>
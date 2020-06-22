<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.MainForm" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet"type="text/css"href="sample.css"/>
		<html lang="ja">
		<link rel="stylesheet" type="text/css" href="../css/main.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>

  	<table>
  		<center><h1>パスワード変更画面</h1></center>
  	</table>

 	<body>
  		<html:form action="/PasswordAction" >
			<html:hidden property="employee_name" name="PasswordForm"/>
			<div class="block">

				<div class="space"></div>
				<br>
				<br>
				<br>
				<div>
				    <center>  古いパスワード：<html:password property="password" value= ""/></center>
				</div>
				<br>
				<div>
				    <center>新しいパスワード：<html:password property="password" value= ""/></center>
				</div>
				<br>
				<div>
				    <center>新しいパスワード：<html:password property="password" value= ""/></center>
				</div>
				<div class="space"></div>
				<br>
				<!-- 変更ボタン -->
				<input type="button" class="btn" style="margin-top:3px;" value="変更" onclick =""style="font-size:25px;"></input>

    			<!-- 戻るボタン -->
    			<input type="button" class="btn" style="margin-top:3px;" value="戻る" onclick = "location.href='main.jsp'" style="font-size:25px;"></input>

 			 </div>
   		 </html:form>
	 </body>
</html:html>
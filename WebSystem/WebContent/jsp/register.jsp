<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.RegisterForm" %>

<html:html>
	<head>
		<html:base/>
		<title><bean:message key="register.title"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<html lang="ja">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>

  	<table>
  		<center><h1>社員登録画面</h1></center>
  	</table>

 	<body>
 	<%
 		String message;
 		try{
			RegisterForm rForm = (RegisterForm) session.getAttribute("rForm");
 			message =  rForm.getMessage();
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 	%>
  		<html:form action="/RegisterAction" >
			<div class="block">

				<div class="space"></div>
				<br>
				<br>
					<center><%= message %></center>
				<br>
				<div>
				    <center>　　社員No：<html:text property="employee_no" value= ""/></center>
				</div>
				<br>
				<div>
				    <center>パスワード：<html:text property="password" value= ""/></center>
				</div>
				<div style="position: relative; margin-top: 5%; text-align: center">
					<p class="REST">秘密の質問</p>
				<select class="REST" name="秘密の質問">
					<option value="">選択してください</option>
					<option value="">母親の旧姓</option>
					<option value="">飼っているペットの名前</option>
					<option value="">好きな食べ物</option>
					<option value="">好きな国</option>
					<option value="">初めて観た映画</option>
					<option value="">学生時代の部活</option>
					<option value="">子供の頃のあだ名</option>
					<option value="">座右の銘</option>
					<option value="">初めて行った海外</option>
					<option value="">おふくろの味</option>
				</select>
				</div>
				<div>
				    <center><html:text property="password" value= ""/></center>
				</div>
				<div style="position: relative; margin-top: 5%; text-align: center">
					<p class="REST">秘密の質問</p>
				<select class="REST" name="秘密の質問">
					<option value="">選択してください</option>
					<option value="">母親の旧姓</option>
					<option value="">飼っているペットの名前</option>
					<option value="">好きな食べ物</option>
					<option value="">好きな国</option>
					<option value="">初めて観た映画</option>
					<option value="">学生時代の部活</option>
					<option value="">子供の頃のあだ名</option>
					<option value="">座右の銘</option>
					<option value="">初めて行った海外</option>
					<option value="">おふくろの味</option>
				</select>
				</div>
				<div>
				    <center><html:text property="password" value= ""/></center>
				</div>
				<div class="space"></div>
				<br>
				<!-- 登録ボタン -->
				<span><html:submit property="button" styleClass="btn" style="margin-top:3px;font-size:25px;" value="登録"/></span>

    			<!-- 戻るボタン -->
    			<span><html:submit property="button" styleClass="btn" style="margin-top:3px;font-size:25px;" value="戻る"/></span>

 			 </div>
   		 </html:form>
	 </body>
</html:html>
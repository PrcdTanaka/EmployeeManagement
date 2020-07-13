<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.Open_informationForm" %>

<html:html>

	<head>
		<link rel="stylesheet" href="../css/open.css">

	</head>
	<body>

		<div class='header'>
			<input type="submit" value="戻る">

		</div>
		<html:form action="/LoginAction" >
		<div class='main1'>
			<div class='pic'>
				<img src="C:\Users\gakuto_yamagishi\Desktop\susi.jpg" height="200" width="200">
			</div>
				<div class='pro'>
				<div class='pro2'>
					<div class='name'>名前　　　:</div>
					<html:text property="name" />
					<div class='pos'>役職　　　:</div>
					<html:text property="pos" />
				</div>
				<div class='pro2'>
					<div class='day'>入社年月日:　</div>
					<html:text property="djc" />
				</div>
				<div class='pro2'>
					<div class='teku'>技術部　　:　</div>
					<html:text property="tec" />
				</div>
			</div>
		</div>

		<div class='main2'>
			<div class='pro3'>
				<div class='hobyy'>趣味:　</div>
				<html:text property="hobby" />
			</div>
			<div class='pro3'>
				<div class='ss'>特技:　</div>
				<html:text property="ss" />
			</div>
		</div>

		<div class='bottom'>
			<div  class='int'>紹介文</div>
			<html:textarea property="intr"></html:textarea>
 <!-- styleClass='int2'name='int2' cols='100' rows='10' -->
		</div>
</html:form>
	</body>
</html:html>

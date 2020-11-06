<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="d01.access.control.AccessSelectForm"%>
<%
	AccessSelectForm aSForm = (AccessSelectForm) session
			.getAttribute("aSForm");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/D01AccessControl/AccessControlEntry.css">
<title>再入室画面</title>
</head>
<body>
	<div class="wrapper">
		<div class="head">
			<div class="title"><%=aSForm.getFloor()%>階　再入室画面</div>
			<div class="empInfo">社員名：<%=aSForm.getEmpName()%>　　社員番号：<%=aSForm.getEmpNo()%></div>
		</div>
		<div class="info">
			<div class="sentence">お疲れ様です。再入室される場合は再退室処理をお忘れなく！</div>
		</div>
		<div class="main">
			<div class="mainTitle">再入室ボタン</div>
			<div class="mainButton">
				<html:form action="/InsertAccess">
					<html:submit styleClass="send" property="button" value="再入室" />
				</html:form>
			</div>
		</div>
		<div class="back">
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</div>
</body>
</html>
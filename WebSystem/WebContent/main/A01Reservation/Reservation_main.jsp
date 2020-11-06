<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>会議室予約メイン画面</title>
</head>

<body>

	<h1>会議室予約メイン画面</h1>

	<div>
		会議室予約
		<html:form action="/RoomReservationMain">
			<html:select property="floor">
				<html:option value="2">2F</html:option>
				<html:option value="3">3F</html:option>
				<html:option value="4">4F</html:option>
			</html:select>
			<html:submit styleClass="send" property="button" value="選択" styleId = "calendar"/>
		</html:form>
	</div>

	<html:link href="/WebSystem/jsp/Main.jsp">メインへ戻る</html:link>
</body>
</html>
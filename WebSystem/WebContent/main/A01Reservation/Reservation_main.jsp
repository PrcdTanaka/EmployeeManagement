<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			<html:submit styleClass="send" property="button" value="選択" />
		</html:form>
	</div>

	<div>
		履歴処理
		<html:form action="/AccessLogSelectAction">
			<html:select property="floor">
				<html:option value="1">1F</html:option>
				<html:option value="2">2F</html:option>
				<html:option value="3">3F</html:option>
				<html:option value="4">4F</html:option>
			</html:select>
			<html:select property="year">
				<html:option value="2020">2020</html:option>
				<html:option value="2019">2019</html:option>
			</html:select>
			<html:select property="month">
				<html:option value="01">1月</html:option>
				<html:option value="02">2月</html:option>
				<html:option value="03">3月</html:option>
				<html:option value="04">4月</html:option>
				<html:option value="05">5月</html:option>
				<html:option value="06">6月</html:option>
				<html:option value="07">7月</html:option>
				<html:option value="08">8月</html:option>
				<html:option value="09">9月</html:option>
				<html:option value="10">10月</html:option>
				<html:option value="11">11月</html:option>
				<html:option value="12">12月</html:option>
			</html:select>
			<html:submit styleClass="send" property="button" value="GO" />
		</html:form>
	</div>

	<html:link href="/WebSystem/jsp/Main.jsp">メインへ戻る</html:link>

</body>
</html>
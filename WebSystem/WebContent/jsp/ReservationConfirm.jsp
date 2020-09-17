<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.RoomReservationForm"%>
<%@ page import="sample.pr.main.LoginForm"%>
<html:html>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Reservation.css">
<div align= "center">
	<h1>予約確認画面</h1>
</div>
<body>
	<html:form action="/ReservationConfirmAction">
	<%
		String message;
		try{
			RoomReservationForm roForm = (RoomReservationForm) session.getAttribute("pForm");
			message =  roForm.getMessage();
			if(message == null)
				message = "";

		}catch(NullPointerException e){
			message = "";
		}

		String res_time = request.getParameter("res_time");
		String mmdd = request.getParameter("mmdd");
		String room_name = request.getParameter("room_name");
	%>
		<div class="block">
			<div class="space"></div>
			<br>
			<div align= "center" property="room_name">会議室名：<%= room_name %></div>
			<div align= "center">予約日　：<%= mmdd %></div>
			<div align= "center">予約時間：<%= res_time %></div>
			<div align= "center">
					用途　　：
					<!--  input type ="text" property="room_name" value="" />-->
					<html:text property="use" value="" />
			</div>
			<div align= "center">
					メンバー：
					<html:text property="member" value="" />
			</div>
			<!--div align="center"-->
			<center>
			<!-- 登録ボタン -->
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="confirm"/>
			</center>
			<!--  /div>-->
			<center>
			<div align="center">
			<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />
			</center>
			<!--/div>-->
		</div>
	</html:form>
</body>
</html:html>
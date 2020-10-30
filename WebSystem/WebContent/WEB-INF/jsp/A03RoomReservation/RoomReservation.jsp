<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="a03.room.register.RoomReservationForm"%>
<%@ page import="sample.pr.main.LoginForm"%>

<html:html>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Reservation.css">
<div align= "center">
	<h1>会議室新規登録画面</h1>
</div>
<body>
	<html:form action="/RoomReservationAction">
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
	%>
	<%= message %>
<style>
.btn{
text-align:center;
}
</style>
		<div class="block">
			<div class="space"></div>
			<br>
			<div align= "center">
					会議室名：
					<html:text property="room_name" value="" />
			</div>
			<div align= "center">
					所在地　：
					<html:text property="place" value="" />
			</div>
			<div align= "center">
					席数　　：
					<html:text property="seat" value="" />
			</div>
			<div align= "center">
				<p>
				モニター：
					<input type="radio" name="monitor" value="0">あり
					<input type="radio" name="monitor" value="1">なし
				</p>
			</div>
			<div align= "center">
					<p>
				カメラ：
					<input type="radio" name="camera" value="0">あり
					<input type="radio" name="camera" value="1">なし
				</p>
			</div>
			<br>
			<div align="center">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="room"/>
			</div>
			<div align="center">
			<html:submit property="button" styleClass="btn" value="戻る"
			styleId="reservation" />
			</div>
		</div>
	</html:form>
</body>
</html:html>
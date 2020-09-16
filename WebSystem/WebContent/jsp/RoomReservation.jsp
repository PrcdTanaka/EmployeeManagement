<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.ReservationForm"%>
<%@ page import="sample.pr.main.RoomReservationForm"%>
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
					<!--  input type ="text" property="room_name" value="" />-->
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
					モニター：
					<html:text property="monitor" value="" />
			</div>
			<div align= "center">
					カメラ　：
					<html:text property="camera" value="" />
			</div>
			<br>
			<div align="center">
			<!-- 登録ボタン -->
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
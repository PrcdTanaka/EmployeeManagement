<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.RoomReservationForm"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.ap.DbAction"%>

<html:html>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Reservation.css">
<div align= "center">
	<h1>予約確認画面</h1>
</div>
<body>
	<html:form action="/ReservationConfirmAction">
	<%
	DbAction dba = new DbAction();
	RoomReservationForm rForm = new RoomReservationForm();
	LoginForm s = (LoginForm) session.getAttribute("form");

		String message = null;
		try{
			RoomReservationForm roForm = (RoomReservationForm) session.getAttribute("roForm");
			message =  roForm.getMessage();
			if(message == null)
				message = "";

		}catch(NullPointerException e){
			message = "";
		}

		//String dd = "";
		String res_time = request.getParameter("res_time");
		String mm = request.getParameter("mm");
		String dd = request.getParameter("dd");
		//if(dd.length()==1){
			//dd = "0" + dd;
		//}
		String room_name = request.getParameter("room_name");
		String emp_name = request.getParameter("emp_name");


		emp_name = s.getEmployee_name();
	%>
		<div class="block">
			<div class="space"></div>
			<br>
			<div align= "center">会議室名：<input type="text" name="room_name" value="<%=room_name %>" readonly></div>
			<div align= "center">予約日　：<input type="text" name="mmdd" value="<%=mm + dd %>" readonly></div>
			<div align= "center">予約時間：<input type="text" name="res_time" value="<%=res_time %>" readonly></div>
			<div align= "center">代表者　：<input type="text" name="name" value="<%=emp_name %>" readonly></div>
			<div align= "center">用途　　：<html:text property="use" value="" />
			</div>
			<div align= "center">メンバー：<html:text property="member" value="" />
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
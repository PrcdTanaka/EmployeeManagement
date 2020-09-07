<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.ReservationForm"%>

<html:html>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<center>
	<h1>会議室新規登録画面</h1>
</center>
<body>
	<html:form action="/RoomReservationAction">
		<div class="block">
			<div class="space"></div>
			<br>
			<div>
				<center>
					会議室名：
					<input type ="text" property="room_name" value="" />
				</center>
			</div>
			<div>
				<center>
					建物名　：
					<input type ="text" property="roo_place" value="" />
				</center>
			</div>
			<div>
				<center>
					席数　　：
					<input type ="text" property="seat_number" value="" />
				</center>
			</div>
			<div>
				<center>
					モニター：
					<input type ="text" property="monitor" value="" />
				</center>
			</div>
			<div>
				<center>
					カメラ　：
					<input type ="text" property="camera" value="" />
				</center>
			</div>
			<div class="space"></div>
			<br>
			<center>
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />
			</center>
		</div>

	</html:form>
</body>
</html:html>
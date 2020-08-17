
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="ja">
<!DOCTYPE html>
<html:html>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<style>
.REST {
	font-size: 20px;
}

.btn {
	font-size: 20px;
}
</style>

<body>
	<html:form action="/AttendanceAction">
		<div>
			<center>
				<h1>出退勤画面</h1>
			</center>
		</div>
		<div style="top: 15%; position: relative;">
			<html:submit property="button" styleClass="btn" value="出勤"
				styleId="attendance" />
		</div>

		<div style="position: relative; margin-top: 5%;">
			<html:submit property="button" styleClass="btn" value="退勤"
				styleId="attendance" />
		</div>
		<div style="position: relative; margin-top: 5%; text-align: center">
			<p class="REST">休憩時間</p>
			<select class="REST" name="休憩時間">
				<option value="">選択してください</option>
				<option value="">00:00</option>
				<option value="">00:15</option>
				<option value="">00:30</option>
				<option value="">00:45</option>
				<option value="">01:00</option>
				<option value="">01:15</option>
				<option value="">01:30</option>
				<option value="">01:45</option>
				<option value="">02:00</option>
			</select>
		</div>

		<div style="position: relative; margin-top: 2%; align: center;">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="attendance" />
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />
		</div>
	</html:form>
</body>
</html:html>
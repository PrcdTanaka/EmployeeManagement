
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<html lang="ja">
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
		<%
			try {
						AttendanceForm aForm = (AttendanceForm) session
								.getAttribute("aForm");
					} catch (NullPointerException e) {

					}

					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					AttendanceForm aForm = new AttendanceForm();
					aForm.setEmployee_no(s.getEmployee_no());
					String rest_time = aForm.getRest_time();
		%>
		<div>
			<center>
				<h1>出退勤画面</h1>
			</center>
		</div>
		<div style="top: 15%; position: relative;">
			<html:submit property="button" styleClass="btn" value="出勤"
				styleId="attendance"  onclick="return confirm('出勤しますか？');"/>
		</div>

		<div style="position: relative; margin-top: 5%;">
			<html:submit property="button" styleClass="btn" value="退勤"
				styleId="attendance"  onclick="return confirm('退勤しますか？');"/>
		</div>
		<div style="position: relative; margin-top: 5%; text-align: center">
			<p class="REST">休憩時間</p>
			<html:select property="rest_time" styleId="REST">
				<html:option value="">-</html:option>
				<html:option value="0">00:00</html:option>
				<html:option value="1">00:15</html:option>
				<html:option value="2">00:30</html:option>
				<html:option value="3">00:45</html:option>
				<html:option value="4">01:00</html:option>
				<html:option value="5">01:15</html:option>
				<html:option value="6">01:30</html:option>
				<html:option value="7">01:45</html:option>
				<html:option value="8">02:00</html:option>
			</html:select>
		</div>
		<div style="position: relative; margin-top: 2%; align: center;">
			<html:submit property="button" styleClass="btn" value="登録(休憩時間)"
				styleId="attendance" onclick="return confirm('休憩時間を登録しますか？');" />
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />
		</div>
	</html:form>
</body>
</html:html>
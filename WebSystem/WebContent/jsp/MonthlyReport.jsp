<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.KintaiMailForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/MonthlyReportAction">
	<body>
		<center>
			<h1>会議室予約画面</h1>
		</center>


		<tr>
			<td>/</td>
			<td>/</td>
			<td>届出日</td>
			<td>時刻</td>
			<td>Limit</td>
			<td>連絡遅延</td>
			<td>届出区分</td>
			<td>作業場所</td>
			<td>許可</td>
			<td>備考</td>
		</tr>

		<%
		Calendar cal = Calendar.getInstance();
		int monthlastDay = cal.getActualMaximum(Calendar.DATE);
		for (int day = 1; day <= monthlastDay; day++) {
		%>
		<tr>
			<td><%=day%>日</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
			<td>""</td>
		</tr>
		<%
			}
		%>


























	</body>
</html:form>
</html:html>
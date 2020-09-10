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
<% //<html:form action="/MonthlyReportAction">%>
	<body>
	<%
		Calendar cal = Calendar.getInstance();
		int monthlastDay = cal.getActualMaximum(Calendar.DATE);

		%>
		<center>
			<h1>勤怠月報画面</h1>
		</center>

<center>
 <table border="3" bordercolor="#0000ff">
    <tr bgcolor="#87cefa">
    <tr>
    	<td><% String month=(cal.get(cal.MONTH)+1)+""; %>月</td>
    </tr>
		<tr>
			<td colspan="2">/</td>
			<td>届出日</td>
			<td>時刻</td>
			<td>Limit</td>
			<td>連絡遅延</td>
			<td colspan="2">届出区分</td>
			<td>作業場所</td>
			<td>許可</td>
			<td>備考</td>
		</tr>


		<tr>
		 <%for (int day = 1; day <= monthlastDay; day++) { %>
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

























</table>
</center>
<div  style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="保存"
				styleId="MonthlyReport"/>
		</div>
		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="kintailist"/>
		</div>
	</body>
<% //</html:form>%>
</html:html>
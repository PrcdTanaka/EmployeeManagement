<%@page import="sample.pr.main.MonthlyReportForm"%>
<%@page import="sample.pr.main.MonthlyReportAction"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.MonthlyReportForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/MonthlyReportAction">
	<body>
	<%
		MonthlyReportForm form=new MonthlyReportForm();
		Calendar cal = Calendar.getInstance();
		String month=(cal.get(cal.MONTH)+1)+"";
		int monthlastDay = cal.getActualMaximum(Calendar.DATE);
		DbAction dba = new DbAction();
		LoginForm lForm=(LoginForm)session.getAttribute("form");
		form.setEmployee_no(lForm.getEmployee_no());

		dba.getMonthly_report(form);
	    List<String> division = form.getDivision();
		List<String> span = form.getSpan();
		List<String>span2=form.getSpan2();
		List<String>remark=form.getRemark();
		List<String>perm=form.getPerm();
		List<String>Mmdd=form.getMmdd();
		List<String>Send_Time=form.getSend_Time();
		int listnumber=0;

		%>
		<center>
			<h1>勤怠月報画面</h1>
		</center>

 <table border="3" bordercolor="#0000ff">
    <tr bgcolor="#87cefa">
    <tr>
    	<td><%=month %>月</td>
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
		 <%
		 	String dada= "";
		 for (int day = 1; day <= monthlastDay; day++) {
		 if(month.length()==1)
			month="0"+month;
		 if(String.valueOf(day).length()==1)
			 dada="0"+day;
		 else
			 dada=""+day;
		 if(listnumber>Mmdd.size()-1){%>
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

		 <%}
		 else if(Mmdd.get(listnumber).equals(month+dada+"")){%>
				<td><%=day%>日</td>
				<td><%=span.get(listnumber)%></td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
				<td><%=division.get(listnumber)%></td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
			</tr>
		 <%
		 listnumber++;

		 }
		 else{%>
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

	 <%}
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
</html:form>
</html:html>
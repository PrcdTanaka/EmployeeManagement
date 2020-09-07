<%@page import="sample.pr.main.ReservationForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.ReservationForm"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/ReservationAction">
<%
					ReservationForm rForm = new ReservationForm();
					String Employee_no = "";
					String name = rForm.getName();
					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					try {
						Employee_no = s.getEmployee_no();
						name = s.getEmployee_name();
					} catch (Exception e) {
					}
		%>
<body>
<center>
			<h1>会議室予約画面</h1>
		</center>

		<div align="right">
			<a href="RoomReservation.jsp">会議室新規登録画面へ</a>
		</div>
	<div align="left">
		<table border="1">
			<tr>
				<th></th>
				<th>キャパ</th>
				<th>モニター</th>
				<th>カメラ</th>
			</tr>
			<tr>
				<td>2F</td>
				<td>〇〇人</td>
				<td>〇</td>
				<td>×</td>
			</tr>
			<tr>
				<td>3F</td>
				<td>〇〇人</td>
				<td>×</td>
				<td>〇</td>
			</tr>
			<tr>
				<td>4F</td>
				<td>〇〇人</td>
				<td>×</td>
				<td>〇</td>
			</tr>
		</table>
	</div>
		<br>
		<div align="center">
		<table border="2" cellpadding="0" cellspacing="0">
			<tr>
				<th></th>
				<td>2F</td>
				<td>3F</td>
				<td>4F</td>
				<td width="360" height="40" colspan="5"></td>
			</tr>
			<tr>
				<td rowspan="2">前の週へ</td>
				<td width ="360" colspan ="7" style="text-align: center;">2020年09月</td>
				<td rowspan="2">次の週へ</td>
			</tr>
			<tr>
				<td>1日(月)</td>
				<td>2日(火)</td>
				<td>3日(水)</td>
				<td>4日(木)</td>
				<td>5日(金)</td>
				<td>6日(土)</td>
				<td>7日(日)</td>
			</tr>
			<tr>
				<td >8:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >8:00</td>
			</tr>
			<tr>
				<td >8:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >8:30</td>
			</tr>
			<tr>
				<td >9:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >9:00</td>
			</tr>
			<tr>
				<td >9:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >9:30</td>
			</tr>
			<tr>
				<td >10:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >10:00</td>
			</tr>
			<tr>
				<td >10:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >10:30</td>
			</tr>
			<tr>
				<td >11:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >11:00</td>
			</tr>
			<tr>
				<td >11:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >11:30</td>
			</tr>
			<tr>
				<td >12:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >12:00</td>
			</tr>
			<tr>
				<td >12:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >12:30</td>
			</tr>
			<tr>
				<td >13:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >13:00</td>
			</tr>
			<tr>
				<td >13:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >13:30</td>
			</tr>
			<tr>
				<td >14:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >14:00</td>
			</tr>
			<tr>
				<td >14:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >14:30</td>
			</tr>
			<tr>
				<td >15:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >15:00</td>
			</tr>
			<tr>
				<td >15:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >15:30</td>
			</tr>
			<tr>
				<td >16:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >16:00</td>
			</tr>
			<tr>
				<td >16:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >16:30</td>
			</tr>
			<tr>
				<td >17:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >17:00</td>
			</tr>
			<tr>
				<td >17:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >17:30</td>
			</tr>
			<tr>
				<td >18:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >18:00</td>
			</tr>
			<tr>
				<td >18:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >18:30</td>
			</tr>
			<tr>
				<td >19:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >19:00</td>
			</tr>
			<tr>
				<td >19:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >19:30</td>
			</tr>
			<tr>
				<td >20:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >20:00</td>
			</tr>
			<tr>
				<td >20:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >20:30</td>
			</tr>
			<tr>
				<td >21:00</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >21:00</td>
			</tr>
			<tr>
				<td >21:30</td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td ><%= name %></td>
				<td >21:30</td>
			</tr>
		</table>
	</div>
	<p>
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />
	</p>
</body>
</html:form>
</html:html>
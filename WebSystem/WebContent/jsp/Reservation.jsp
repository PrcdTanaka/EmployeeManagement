<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.ReservationForm"%>
<%@ page import="java.util.Calendar"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Res_tab.css">
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

					    Calendar cal = Calendar.getInstance();

					    int year = cal.get(Calendar.YEAR);
					    int month = cal.get(Calendar.MONTH) + 1;
					    int day = cal.get(Calendar.DATE);
					    int day2 = cal.get(Calendar.DATE);
					    int day3 = cal.get(Calendar.DATE);
					    int hour = cal.get(Calendar.HOUR_OF_DAY);
					    int minute = cal.get(Calendar.MINUTE);
					    int second = cal.get(Calendar.SECOND);
					    int week = cal.get(Calendar.DAY_OF_WEEK) - 1;

					    int day_of_year = cal.get(Calendar.DAY_OF_YEAR);

					    int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
					    String weekname = "";
					    String capacity = "";
					    String monitor = "";
					    String camera = "";

	%>
	<body>
		<div align = "center">
			<h1>会議室予約画面</h1>
		</div>

		<div align="right">
			<a href="jsp/RoomReservation.jsp">会議室新規登録画面へ</a>
		</div>
		<div align="left">
			<table border="1">
				<tr>
					<th></th>
					<th>席数</th>
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
		<span id="view_today"></span>
		<div align="center">
		<!DOCTYPE html>
<html lang="ja">

<div class="tabs">
  <input id="all" type="radio" name="tab_item" checked>
  <label class="tab_item" for="all">2F</label>
  <input id="programming" type="radio" name="tab_item">
  <label class="tab_item" for="programming">3F</label>
  <input id="design" type="radio" name="tab_item">
  <label class="tab_item" for="design">4F</label>
  <div class="tab_content" id="all_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td height="40" colspan="5"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">前の週へ</a></td>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>

					<%for(int i=0 ;i<7;i++){
						if(day>max){%>
					<td></td>
					<% }
						else
						{
							switch(week){
							case 0:
								weekname = "(日)";
								break;
							case 1:
								weekname = "(月)";
								break;
							case 2:
								weekname = "(火)";
								break;
							case 3:
								weekname = "(水)";
								break;
							case 4:
								weekname = "(木)";
								break;
							case 5:
								weekname = "(金)";
								break;
							case 6:
								weekname = "(土)";
								break;
							}
						%>
					<td><%= day + "日" + weekname %></td>
					<%week++;
					if(week == 7){
						week = 0;
					}
					day++;
						}
					 }%>


				</tr>
				<tr>
					<td>8:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:00</td>
				</tr>
				<tr>
					<td>8:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:30</td>
				</tr>
				<tr>
					<td>9:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:00</td>
				</tr>
				<tr>
					<td>9:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:30</td>
				</tr>
				<tr>
					<td>10:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:00</td>
				</tr>
				<tr>
					<td>10:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:30</td>
				</tr>
				<tr>
					<td>11:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:00</td>
				</tr>
				<tr>
					<td>11:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:30</td>
				</tr>
				<tr>
					<td>12:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:00</td>
				</tr>
				<tr>
					<td>12:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:30</td>
				</tr>
				<tr>
					<td>13:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:00</td>
				</tr>
				<tr>
					<td>13:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:30</td>
				</tr>
				<tr>
					<td>14:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:00</td>
				</tr>
				<tr>
					<td>14:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:30</td>
				</tr>
				<tr>
					<td>15:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:00</td>
				</tr>
				<tr>
					<td>15:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:30</td>
				</tr>
				<tr>
					<td>16:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:00</td>
				</tr>
				<tr>
					<td>16:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:30</td>
				</tr>
				<tr>
					<td>17:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:00</td>
				</tr>
				<tr>
					<td>17:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:30</td>
				</tr>
				<tr>
					<td>18:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:00</td>
				</tr>
				<tr>
					<td>18:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:30</td>
				</tr>
				<tr>
					<td>19:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:00</td>
				</tr>
				<tr>
					<td>19:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:30</td>
				</tr>
				<tr>
					<td>20:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:00</td>
				</tr>
				<tr>
					<td>20:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:30</td>
				</tr>
				<tr>
					<td>21:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:00</td>
				</tr>
				<tr>
					<td>21:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:30</td>
				</tr>
			</table>
      </p>
    </div>
  </div>
  <div class="tab_content" id="programming_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td height="40" colspan="5"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">前の週へ</a></td>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>

					<%for(int i=0 ;i<7;i++){
						if(day2>max){%>
					<td></td>
					<% }
						else
						{
							switch(week){
							case 0:
								weekname = "(日)";
								break;
							case 1:
								weekname = "(月)";
								break;
							case 2:
								weekname = "(火)";
								break;
							case 3:
								weekname = "(水)";
								break;
							case 4:
								weekname = "(木)";
								break;
							case 5:
								weekname = "(金)";
								break;
							case 6:
								weekname = "(土)";
								break;
							}
						%>
					<td><%= day2 + "日" + weekname %></td>
					<%week++;
					if(week == 7){
						week = 0;
					}
					day2++;
						}
					 }%>


				</tr>
				<tr>
					<td>8:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:00</td>
				</tr>
				<tr>
					<td>8:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:30</td>
				</tr>
				<tr>
					<td>9:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:00</td>
				</tr>
				<tr>
					<td>9:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:30</td>
				</tr>
				<tr>
					<td>10:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:00</td>
				</tr>
				<tr>
					<td>10:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:30</td>
				</tr>
				<tr>
					<td>11:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:00</td>
				</tr>
				<tr>
					<td>11:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:30</td>
				</tr>
				<tr>
					<td>12:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:00</td>
				</tr>
				<tr>
					<td>12:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:30</td>
				</tr>
				<tr>
					<td>13:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:00</td>
				</tr>
				<tr>
					<td>13:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:30</td>
				</tr>
				<tr>
					<td>14:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:00</td>
				</tr>
				<tr>
					<td>14:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:30</td>
				</tr>
				<tr>
					<td>15:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:00</td>
				</tr>
				<tr>
					<td>15:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:30</td>
				</tr>
				<tr>
					<td>16:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:00</td>
				</tr>
				<tr>
					<td>16:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:30</td>
				</tr>
				<tr>
					<td>17:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:00</td>
				</tr>
				<tr>
					<td>17:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:30</td>
				</tr>
				<tr>
					<td>18:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:00</td>
				</tr>
				<tr>
					<td>18:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:30</td>
				</tr>
				<tr>
					<td>19:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:00</td>
				</tr>
				<tr>
					<td>19:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:30</td>
				</tr>
				<tr>
					<td>20:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:00</td>
				</tr>
				<tr>
					<td>20:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:30</td>
				</tr>
				<tr>
					<td>21:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:00</td>
				</tr>
				<tr>
					<td>21:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:30</td>
				</tr>
			</table>
      </p>
    </div>
  </div>
  <div class="tab_content" id="design_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td height="40" colspan="5"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">前の週へ</a></td>
					<td rowspan = "2"><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>

					<%for(int i=0 ;i<7;i++){
						if(day3>max){%>
					<td></td>
					<% }
						else
						{
							switch(week){
							case 0:
								weekname = "(日)";
								break;
							case 1:
								weekname = "(月)";
								break;
							case 2:
								weekname = "(火)";
								break;
							case 3:
								weekname = "(水)";
								break;
							case 4:
								weekname = "(木)";
								break;
							case 5:
								weekname = "(金)";
								break;
							case 6:
								weekname = "(土)";
								break;
							}
						%>
					<td><%= day3 + "日" + weekname %></td>
					<%week++;
					if(week == 7){
						week = 0;
					}
					day3++;
						}
					 }%>


				</tr>
				<tr>
					<td>8:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:00</td>
				</tr>
				<tr>
					<td>8:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>8:30</td>
				</tr>
				<tr>
					<td>9:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:00</td>
				</tr>
				<tr>
					<td>9:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>9:30</td>
				</tr>
				<tr>
					<td>10:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:00</td>
				</tr>
				<tr>
					<td>10:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>10:30</td>
				</tr>
				<tr>
					<td>11:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:00</td>
				</tr>
				<tr>
					<td>11:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>11:30</td>
				</tr>
				<tr>
					<td>12:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:00</td>
				</tr>
				<tr>
					<td>12:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>12:30</td>
				</tr>
				<tr>
					<td>13:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:00</td>
				</tr>
				<tr>
					<td>13:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>13:30</td>
				</tr>
				<tr>
					<td>14:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:00</td>
				</tr>
				<tr>
					<td>14:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>14:30</td>
				</tr>
				<tr>
					<td>15:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:00</td>
				</tr>
				<tr>
					<td>15:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>15:30</td>
				</tr>
				<tr>
					<td>16:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:00</td>
				</tr>
				<tr>
					<td>16:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>16:30</td>
				</tr>
				<tr>
					<td>17:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:00</td>
				</tr>
				<tr>
					<td>17:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>17:30</td>
				</tr>
				<tr>
					<td>18:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:00</td>
				</tr>
				<tr>
					<td>18:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>18:30</td>
				</tr>
				<tr>
					<td>19:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:00</td>
				</tr>
				<tr>
					<td>19:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>19:30</td>
				</tr>
				<tr>
					<td>20:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:00</td>
				</tr>
				<tr>
					<td>20:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>20:30</td>
				</tr>
				<tr>
					<td>21:00</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:00</td>
				</tr>
				<tr>
					<td>21:30</td>
					<%
					for(int i= 0;i<7;i++){
						if(rForm.getMmdd()==null){%>
							<td><a href="jsp/ReservationConfirm.jsp" onclick="return confirm('予約しますか？');">○</a></td>
						<%}else{ %>
							<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
						<%}
					}%>
					<td>21:30</td>
				</tr>
			</table>
      </p>
    </div>
  </div>
</div>



		</div>
		<p>
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />
		</p>
	</body>
</html:form>
</html:html>
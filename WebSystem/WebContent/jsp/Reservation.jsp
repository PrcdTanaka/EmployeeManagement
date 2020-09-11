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
					    String[] week_name = {"(日)", "(月)", "(火)", "(水)",
					                          "(木)", "(金)", "(土)"};

					    Calendar cal = Calendar.getInstance();

					    int year = cal.get(Calendar.YEAR);
					    int month = cal.get(Calendar.MONTH) + 1;
					    int day = cal.get(Calendar.DATE);
					    int hour = cal.get(Calendar.HOUR_OF_DAY);
					    int minute = cal.get(Calendar.MINUTE);
					    int second = cal.get(Calendar.SECOND);
					    int week = cal.get(Calendar.DAY_OF_WEEK) - 1;

					    int day_of_year = cal.get(Calendar.DAY_OF_YEAR);

					    System.out.println(week_name[week]);

					    int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
					    String weekname = "";

	%>
	<body>
		<center>
			<h1>会議室予約画面</h1>
		</center>

		<div align="right">
			<a href="jsp/RoomReservation.jsp">会議室新規登録画面へ</a>
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
		<span id="view_today"></span>
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
					<td width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td rowspan="2">次の週へ</td>
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
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>8:00</td>
				</tr>
				<tr>
					<td>8:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>8:30</td>
				</tr>
				<tr>
					<td>9:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>9:00</td>
				</tr>
				<tr>
					<td>9:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>9:30</td>
				</tr>
				<tr>
					<td>10:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>10:00</td>
				</tr>
				<tr>
					<td>10:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>10:30</td>
				</tr>
				<tr>
					<td>11:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>11:00</td>
				</tr>
				<tr>
					<td>11:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>11:30</td>
				</tr>
				<tr>
					<td>12:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>12:00</td>
				</tr>
				<tr>
					<td>12:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>12:30</td>
				</tr>
				<tr>
					<td>13:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>13:00</td>
				</tr>
				<tr>
					<td>13:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>13:30</td>
				</tr>
				<tr>
					<td>14:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>14:00</td>
				</tr>
				<tr>
					<td>14:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>14:30</td>
				</tr>
				<tr>
					<td>15:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>15:00</td>
				</tr>
				<tr>
					<td>15:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>15:30</td>
				</tr>
				<tr>
					<td>16:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>16:00</td>
				</tr>
				<tr>
					<td>16:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>16:30</td>
				</tr>
				<tr>
					<td>17:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>17:00</td>
				</tr>
				<tr>
					<td>17:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>17:30</td>
				</tr>
				<tr>
					<td>18:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>18:00</td>
				</tr>
				<tr>
					<td>18:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>18:30</td>
				</tr>
				<tr>
					<td>19:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>19:00</td>
				</tr>
				<tr>
					<td>19:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>19:30</td>
				</tr>
				<tr>
					<td>20:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>20:00</td>
				</tr>
				<tr>
					<td>20:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>20:30</td>
				</tr>
				<tr>
					<td>21:00</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>21:00</td>
				</tr>
				<tr>
					<td>21:30</td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td><%=name%></td>
					<td>21:30</td>
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
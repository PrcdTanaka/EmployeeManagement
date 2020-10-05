<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.ReservationForm"%>
<%@ page import="sample.pr.main.RoomReservationForm"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Reservation.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Res_tab.css">
</head>
<html:form action="/ReservationAction">
	<%
		ReservationForm rForm = new ReservationForm();
		RoomReservationForm roForm = new RoomReservationForm();
		LoginForm lForm = new LoginForm();
				String Employee_no = "";
				List<String> name = rForm.getName();
				String sname = "";
				DbAction dba = new DbAction();
				LoginForm s = (LoginForm) session.getAttribute("form");
				try {
					Employee_no = s.getEmployee_no();
					sname = s.getEmployee_name();
				} catch (Exception e) {

				}

					    Calendar cal = Calendar.getInstance();

					    dba.getRoomstatus(roForm);
					    int year = cal.get(Calendar.YEAR);			//年取得
					    int month = cal.get(Calendar.MONTH) + 1;	//月取得
					    int day = cal.get(Calendar.DATE);			//日付取得
					    int day2 = cal.get(Calendar.DATE);
					    int day3 = cal.get(Calendar.DATE);
					    int dayalert = cal.get(Calendar.DATE);
					    int hour = cal.get(Calendar.HOUR_OF_DAY);	//時間取得
					    int minute = cal.get(Calendar.MINUTE);		//分取得
					    int week = cal.get(Calendar.DAY_OF_WEEK) - 1;	//曜日取得
					    LoginForm ss = (LoginForm) session.getAttribute("form");
					    String emp_name = ss.getEmployee_name();		//社員名取得


					    int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//末尾取得
					    String weekname = "";
					    String capacity = "";

						dba.getMMDD(rForm);
						dba.getRoomstatus(roForm);
						dba.getRoom_name(rForm);
					    String res_name = roForm.getName();
					    String res_time = roForm.getRes_time();
					    List<String> mmdd = rForm.getMmdd();
					    String member = roForm.getMember();
					    String use = roForm.getUse();
						String status =roForm.getRes_time();
						List<String> room_name = roForm.getRoom_name();
						List<String> monitor = roForm.getMonitor();
						List<String> seat = roForm.getSeat();
						List<String> camera = roForm.getCamera();
						String room_number = rForm.getRoom_number();
	%>
	<body>
		<div align = "center">
			<h1>会議室予約画面</h1>
		</div>

		<div align="right">
			<a href="jsp/RoomReservation.jsp">会議室新規登録画面へ</a>
		</div>
		<div class = "details">
			<div align="left">
			<table border="1" width="20">

				<tr>
				<%//for(int i=0 ;room_number<7;i++){
						//}%>
					<th></th>
					<th>席数</th>
					<th>モニター</th>
					<th>カメラ</th>
				</tr>
				<tr>
					<td>
					<%//try{
						//System.out.println(room_name.get(0));
					//}catch( NullPointerException e ){
						//System.out.println("null");
					//} %></td>
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
		</div>
		<br>
		<span id="view_today"></span>
		<div align="center">
		<!DOCTYPE html>
<html lang="ja">

<div class="tabs">
  <input id="all" type="radio" name="tab_item" checked>
  <label class="tab_item" for="all" style = "margin-left: 15%">2F</label>
  <input id="programming" type="radio" name="tab_item">
  <label class="tab_item" for="programming">3F</label>
  <input id="design" type="radio" name="tab_item">
  <label class="tab_item" for="design">4F</label>
  <div class="tab_content" id="all_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td width=90px><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td height="40" colspan="5"width=90px><a href="jsp/Reservation.jsp">次の月へ</a></td>
				</tr>
				<tr>
					<td rowspan = "2" width=90px><a href="jsp/Reservation.jsp">前の週へ</a></td>
					<td rowspan = "2" width=90px><a href="jsp/Reservation.jsp">次の週へ</a></td>
				</tr>
				<tr>

					<%for(int i=0 ;i<7;i++){
						if(day>max){%>
					<td width=90px></td>
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
					<td width=90px><%= day + "日" + weekname %></td>
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
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:00</td>
				</tr>
				<tr>
				<td>8:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:30</td>
				</tr>
				<tr>
				<td>9:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:00</td>
				</tr>
				<tr>
				<td>9:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:30</td>
				</tr>
				<tr>
				<td>10:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:00</td>
				</tr>
				<tr>
				<td>10:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:30</td>
				</tr>
				<tr>
				<td>11:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:00</td>
				</tr>
				<tr>
				<td>11:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:30</td>
				</tr>
				<tr>
				<td>12:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:00</td>
				</tr>
				<tr>
				<td>12:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:30</td>
				</tr>
				<tr>
				<td>13:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:00</td>
				</tr>
				<tr>
				<td>13:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:30</td>
				</tr>
				<tr>
				<td>14:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:00</td>
				</tr>
				<tr>
				<td>14:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:30</td>
				</tr>
				<tr>
				<td>15:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:00</td>
				</tr>
				<tr>
				<td>15:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:30</td>
				</tr>
				<tr>
				<td>16:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:00</td>
				</tr>
				<tr>
				<td>16:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:30</td>
				</tr>
				<tr>
				<td>17:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:00</td>
				</tr>
				<tr>
				<td>17:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:30</td>
				</tr>
				<tr>
				<td>18:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:00</td>
				</tr>
				<tr>
				<td>18:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:30</td>
				</tr>
				<tr>
				<td>19:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:00</td>
				</tr>
				<tr>
				<td>19:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:30</td>
				</tr>
				<tr>
				<td>20:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:00</td>
				</tr>
				<tr>
				<td>20:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:30</td>
				<tr>
				<td>21:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:00&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:00</td>
				</tr>
				<tr>
				<td>21:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:30&mmdd=<%=month%><%=dayalert + i%>&room_name=2F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:30</td>
				</tr>
			</table>
    </div>
  </div>
  <div class="tab_content" id="programming_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月" %></td>
					<td height="40" colspan="5"><a href="jsp/Reservation.jsp">次の月へ</a></td>
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


				<tr>
				<td>8:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:00</td>
				</tr>
				<tr>
				<td>8:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:30</td>
				</tr>
				<tr>
				<td>9:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:00</td>
				</tr>
				<tr>
				<td>9:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:30</td>
				</tr>
				<tr>
				<td>10:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:00</td>
				</tr>
				<tr>
				<td>10:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:30</td>
				</tr>
				<tr>
				<td>11:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:00</td>
				</tr>
				<tr>
				<td>11:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:30</td>
				</tr>
				<tr>
				<td>12:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:00</td>
				</tr>
				<tr>
				<td>12:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:30</td>
				</tr>
				<tr>
				<td>13:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:00</td>
				</tr>
				<tr>
				<td>13:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:30</td>
				</tr>
				<tr>
				<td>14:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:00</td>
				</tr>
				<tr>
				<td>14:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:30</td>
				</tr>
				<tr>
				<td>15:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:00</td>
				</tr>
				<tr>
				<td>15:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:30</td>
				</tr>
				<tr>
				<td>16:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:00</td>
				</tr>
				<tr>
				<td>16:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:30</td>
				</tr>
				<tr>
				<td>17:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:00</td>
				</tr>
				<tr>
				<td>17:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:30</td>
				</tr>
				<tr>
				<td>18:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:00</td>
				</tr>
				<tr>
				<td>18:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:30</td>
				</tr>
				<tr>
				<td>19:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:00</td>
				</tr>
				<tr>
				<td>19:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:30</td>
				</tr>
				<tr>
				<td>20:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:00</td>
				</tr>
				<tr>
				<td>20:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:30</td>
				<tr>
				<td>21:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:00&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:00</td>
				</tr>
				<tr>
				<td>21:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:30&mmdd=<%=month%><%=dayalert + i%>&room_name=3F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:30</td>
				</tr>
			</table>
    </div>
  </div>
  <div class="tab_content" id="design_content">
    <div class="tab_content_description">
      <p class="c-txtsp">
      <table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="jsp/Reservation.jsp">前の月へ</a></td>
					<td rowspan = "2" width="360" colspan="7" style="text-align: center;"><%=year+ "年" + month + "月"  %></td>
					<td height="40" colspan="5"><a href="jsp/Reservation.jsp">次の月へ</a></td>
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
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:00</td>
				</tr>
				<tr>
				<td>8:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=08:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日08:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>8:30</td>
				</tr>
				<tr>
				<td>9:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:00</td>
				</tr>
				<tr>
				<td>9:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=09:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日09:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>9:30</td>
				</tr>
				<tr>
				<td>10:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:00</td>
				</tr>
				<tr>
				<td>10:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=10:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日10:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>10:30</td>
				</tr>
				<tr>
				<td>11:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:00</td>
				</tr>
				<tr>
				<td>11:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=11:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日11:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>11:30</td>
				</tr>
				<tr>
				<td>12:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:00</td>
				</tr>
				<tr>
				<td>12:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=12:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日12:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>12:30</td>
				</tr>
				<tr>
				<td>13:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:00</td>
				</tr>
				<tr>
				<td>13:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=13:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日13:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>13:30</td>
				</tr>
				<tr>
				<td>14:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:00</td>
				</tr>
				<tr>
				<td>14:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=14:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日14:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>14:30</td>
				</tr>
				<tr>
				<td>15:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:00</td>
				</tr>
				<tr>
				<td>15:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=15:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日15:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>15:30</td>
				</tr>
				<tr>
				<td>16:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:00</td>
				</tr>
				<tr>
				<td>16:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=16:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日16:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>16:30</td>
				</tr>
				<tr>
				<td>17:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:00</td>
				</tr>
				<tr>
				<td>17:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=17:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日17:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>17:30</td>
				</tr>
				<tr>
				<td>18:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:00</td>
				</tr>
				<tr>
				<td>18:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=18:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日18:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>18:30</td>
				</tr>
				<tr>
				<td>19:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:00</td>
				</tr>
				<tr>
				<td>19:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=19:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日19:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>19:30</td>
				</tr>
				<tr>
				<td>20:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:00</td>
				</tr>
				<tr>
				<td>20:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=20:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日20:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>20:30</td>
				<tr>
				<td>21:00</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:00&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:00に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:00</td>
				</tr>
				<tr>
				<td>21:30</td>
				<%for(int i= 0;i<7;i++){
						for(int j=0 ;i<7;i++){
							if(rForm.getMmdd()==null){%>
								<td><a href="jsp/ReservationConfirm.jsp?res_time=21:30&mmdd=<%=month%><%=dayalert + i%>&room_name=4F&emp_name=<%=emp_name %>" onclick="return confirm('<%= dayalert + i %>日21:30に予約しますか？');">○</a></td>
							<% }else{%>
								<td><a href="jsp/ReservationConfirm.jsp">-</a></td>
							<%}
							dayalert = cal.get(Calendar.DATE);
						}
					}%>
				<td>21:30</td>
				</tr>
			</table>
    </div>
  </div>
</div>



		</div>
		<p align = "center">
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />
		</p>
	</body>
</html:form>
</html:html>

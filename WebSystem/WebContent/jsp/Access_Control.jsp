<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.ap.DbAction"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.EnterForm" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/MainAction">
<body>

<%

EnterForm a=new EnterForm();
a = (EnterForm) session.getAttribute("eform");
	DbAction dba=new DbAction();
	dba.getAccessControl(a);

%>
<h1><%=a.getFloor() %>F</h1>
<center></center><h1>入退室者一覧</h1></center>

		<%
		Calendar cale = Calendar.getInstance();

		String strYear=request.getParameter("year");
		String strMonth=request.getParameter("month");

		int intYear;
		int intMonth;

		if(strYear != null && strMonth != null)
		{
			int intMonthTemp=Integer.parseInt(strMonth);

			intMonth = intMonthTemp%12;
			intYear = Integer.parseInt(strYear)+intMonthTemp/12;
			if(intMonth==0)
			{
				intMonth=12;
				intYear--;
			}
			cale.set(Calendar.YEAR, intYear);
			cale.set(Calendar.MONTH, intMonth-1);
		}
		intYear=cale.get(Calendar.YEAR);
		intMonth=cale.get(Calendar.MONTH) +1;
		cale.set(Calendar.DATE, 1);

		int k = cale.get(Calendar.DAY_OF_WEEK) -1;
		%>
		<div class="head">
		<a href="http://localhost:8080/WebSystem/jsp/Access_Control.jsp?year=<%=intYear%>&month=<%=intMonth-1 %>">前月</a>
		<span class="title"><%= intYear%>年<%=intMonth %>月</span>
		<a href="http://localhost:8080/WebSystem/jsp/Access_Control.jsp?year=<%=intYear%>&month=<%=intMonth+1 %>">翌月</a>
		</div>

		<span class="validity"></span>
		<div class="fallbackDatePicker">
		<span>
			<%-- カレンダーのプルダウンメニュー作成(月のほう) --%>
			<select id="Years" name="Years">
			<%
				int num1 = 0;
				int num2 = 0;
				int Years_Data = cale.get(Calendar.YEAR);
				int Month_Data = cale.get(Calendar.MONTH)+1;
				for(int i = Years_Data-1; i <= Years_Data+1; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == Years_Data){
			%>
			selected
			<%
				}
			%>
			><%=i %>年
			</option>
			<%num1 = i; %>
			<%
				}
			%>
			</select>
			<%-- カレンダーのプルダウンメニュー作成(日のほう) --%>
			<select id="Months" name="Months">
			<%
				for(int i = 1; i<= 12; i++){
			%>
			<option value="<%=i %>"
			<%
				if(i == Month_Data){
			%>
			selected
			<%
				}
			%>
			><%=i %>月
			</option>
			<%num2=i; %>
			<%
				}
			%>
			</select>
		</span>

		<a href="http://localhost:8080/WebSystem/jsp/Access_Control.jsp?year=<%=Years_Data %>&month=<%=Month_Data %>">移動</a>
		</div>

<center></center>
 <table border="3" bordercolor="#0000ff">
    <tr bgcolor="#87cefa">
      <th>日付</th>
      <th>曜日</th>
      <th>入室者</th>
      <th>入室時間</th>
      <th>退出者</th>
      <th>退出時間</th>
      <th>電気</th>
      <th>戸締り</th>
      <th>避難経路</th>
      <th>防火扉等</th>
      <th>配線</th>
      <th>タバコ</th>
      <th>トイレ</th>
    </tr>

    <tr>

<%


LoginForm lform = (LoginForm) session.getAttribute("form");

  int year=0;
  int month=Integer.valueOf(lform.getLink()); //getlinkでとる

  int startDay;

  int lastDate;

  String week[] = {"日","月","火","水","木","金","土"};

Calendar calendar = Calendar.getInstance();
year=calendar.get(calendar.YEAR);
// 月の初めの曜日を求めます。
calendar.set(year, month - 1, 1); // 引数: 1月: 0, 2月: 1, ...
startDay = calendar.get(Calendar.DAY_OF_WEEK);
// 月末の日付を求めます。
calendar.add(Calendar.MONTH, 1);
calendar.add(Calendar.DATE, -1);
lastDate = calendar.get(Calendar.DATE);
// カレンダー表を作成します。
int row = 0;
int column = startDay - 1; // startDay: 日曜日 = 1, 月曜日 = 2, ...
List<String> calendarlist = new ArrayList();
for (int date = 1; date <= lastDate; date++) {
 if(startDay>7){
	 startDay=1;
 }
 	String aa=week[startDay-1];
 	%>
 	<tr>
    <td><%=month+"月"+date %>日</td> <td><%=aa %>曜日</td>
    <td>visitors</td><td>Entry time</td><td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <%
 	startDay++;

}
%>

    </tr>

        </center>
  </table>
</body>

</html:form>
</html:html>

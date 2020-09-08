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
	DbAction dba=new DbAction();

%>
<h1>floor</h1>
<center></center><h1>入退室者一覧</h1></center>
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

  int year=2020;

  int month=9;

  int startDay;

  int lastDate;

  String week[] = {"日","月","火","水","木","金","土"};

Calendar calendar = Calendar.getInstance();
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
 	String a=week[startDay-1];
 	%>
 	<tr>
    <td><%=month+"月"+date %>日</td> <td><%=a %>曜日</td>
    </tr>
    <%
 	startDay++;


}
%>



      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
	<tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
     <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
     <tr>
      <td>date</td> <td>week</td>
      <td>entry_name</td> <td>entry_time</td>
      <td>exit_name</td> <td>exit_time</td>
      <td>electricity</td> <td>door</td>
      <td>escape_route</td> <td>fire_door</td>
      <td>wiring</td> <td>cigarette</td> <td>wc</td>
    </tr>
    </tr>
        </center>
  </table>
</body>

</html:form>
</html:html>
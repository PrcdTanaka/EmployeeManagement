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
<link rel="stylesheet" type="text/css" href="/WebSystem/css/Access_Control.css">
</head>
<html:form action="/MainAction">
<body>

<%

EnterForm a=new EnterForm();
a = (EnterForm) session.getAttribute("eform");
	DbAction dba=new DbAction();
	a.clearList();
	dba.getAccessControl(a);

%>
<h1><%=a.getFloor() %>F</h1>
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


List<String> checklist=a.getCHECK_LIST();
String check="";
//String SmallMonth;
//String Smallday;
String DateAndTime;

int autherColmn=-1;
//String paddingMonth;
//String paddingDate;

List<String> Judgment=a.getDAY();
List<String> EMPLOYEE_NAME=a.getEMPLOYEE_NAME();
List<String> ENTRY_TIME=a.getENTRY_TIME();
List<String> LEAVING_TIME=a.getLEAVING_TIME();
List<String> LEAVING_NAME=a.getLEAVING_NANE();
List<String> calendarlist = new ArrayList();



boolean m=false;

//Date date = new Date();
//曜日と日付を取得
for (int date = 1; date <= lastDate; date++) {
 if(startDay>7){
	 startDay=1;
 }
 	String aa=week[startDay-1];
 	int Column=0;
 	boolean exists = false;
 	//月日を4桁に変換・格納
 	//String PaddingMonth= String.format("%02d",month);
 	//String PaddingDate= String.format("%03d",date);




 	//抽出した月が10未満の場合0付ける
 	/*if(month<10){
 		SmallMonth = "0"+month;
 	}
 	else{
 		SmallMonth = ""+month;
 	}

 	if(date<10){
		Smallday="0"+date;
 	}
 	else{
 		Smallday=""+date;
 	}*/

 	//実行日の日付の出力
	DateAndTime = ""+year+String.format("%02d",month)+String.format("%02d",date);
 	Column = Judgment.indexOf(DateAndTime);
 	exists = Judgment.contains(DateAndTime);
 	check="-";
 	%>
 	<tr>
    <td><%=month+"月"+date %>日</td> <td><%=aa %>曜日</td>
    <%

  //㏈月日とカレンダーの月日が同じもの抽出
   //if(Judgment.get(Column).equals(DateAndTime)){
	   if(exists){
 	%>
 		<td><%=EMPLOYEE_NAME.get(Column)%></td><td><%=ENTRY_TIME.get(Column)%></td><td><%=LEAVING_NAME.get(Column)%></td>
 		<td><%=LEAVING_TIME.get(Column)%></td>
 	<%

 		if(checklist.get(Column).equals("1")){
 	 		check = "○";
 	 	}
 	//if(Column<Judgment.size()-1)
 		//Column++;
 	}
   else{%>
   <td></td><td></td><td></td><td></td>

 <%}
    %>
      <td><%=check%></td> <td><%=check%></td>
      <td><%=check %></td> <td><%=check %></td>
      <td><%=check %></td> <td><%=check %></td> <td><%=check %></td>
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

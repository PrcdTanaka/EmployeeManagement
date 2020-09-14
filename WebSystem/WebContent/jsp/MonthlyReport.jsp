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
        List<String> spotcode =form.getSpotcode();
        int listnumber=0;
        String a="";
        String limit="";
        String send="";

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
            <td >/</td>
            <td>届出日</td>
            <td>時刻</td>
            <td>Limit</td>
            <td>連絡遅延</td>
            <td >届出区分</td>
            <td>作業場所</td>
            <td>許可</td>
            <td>備考</td>
        </tr>


        <tr>
         <%
        String dada="";
         for (int day = 1; day <= monthlastDay; day++) {
             if(month.length()==1)
                    month="0"+month;
                 if(String.valueOf(day).length()==1)
                     dada="0"+day;
                 else
                     dada=""+day;

         if(span.get(listnumber).substring(6,8).equals(dada)){

        //if文を使用して企業コードから作業場所とlimitを表示
         if(spotcode.get(listnumber).equals("9-0001")){
         a="本社";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("9-0002")){
         a="大阪事業所";
         limit="0840";}
         else if(spotcode.get(listnumber).equals("1-0001")){
         a="アルカウェスト(AIU)";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0002")){
         a="サンシャイン(そんぽ24)";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0003")){
         a="上野フジタエステート(えきねっと)";
         limit="0930";}
         else if(spotcode.get(listnumber).equals("1-0004")){
         a="日生三田ビル";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0005")){
         a="三鷹高木ビル(システムテスト)";
         limit="0900";}
         else if(spotcode.get(listnumber).equals("1-0006")){
         a="宝印刷";
         limit="0900";}
         else if(spotcode.get(listnumber).equals("1-0007")){
         a="紀尾井町パークビル(福利厚生)";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0008")){
         a="コムシス新横浜";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0009")){
         a="虎ノ門ヒルズ";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0010")){
         a="JA川崎(普及)";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0011")){
         a="武蔵小杉タワープレイス";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0012")){
         a="ニッセイアロマスクウェア";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0013")){
         a="三菱電機製作所";
         limit="0900";}
         else if(spotcode.get(listnumber).equals("1-0014")){
         a="日本ユニシス";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0015")){
         a="虎ノ門ヒルズ";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0016")){
         a="鎌田INAビル";
         limit="0930";}
         else if(spotcode.get(listnumber).equals("1-0017")){
         a="三田NNビル";
         limit="0810";}
         else if(spotcode.get(listnumber).equals("1-0018")){
         a="府中Jタワー";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0019")){
         a="三田NNビル";
         limit="0810";}
         else if(spotcode.get(listnumber).equals("1-0020")){
         a="鎌田アロマスクエア";
         limit="0930";}
         else if(spotcode.get(listnumber).equals("1-0021")){
         a="日生三田ビル";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0022")){
         a="東京ダイヤビルディング";
         limit="0830";}
         else if(spotcode.get(listnumber).equals("1-0023")){
         a="高崎ルネサス";
         limit="0800";}



        //無届かどうかをif文で記述
         if(Integer.parseInt(Send_Time.get(listnumber))>Integer.parseInt(limit)){
         send="無届";}else{
             send="";
         }%>
                <td><%=dada%>日</td>
                <td><%=Mmdd.get(listnumber)%></td>
                <td><%=Send_Time.get(listnumber)%></td>
                <td><%=limit %></td>
                <td><%=send %></td>
                <td><%=division.get(listnumber)%></td>
                <td><%=a%></td>
                <td><%=perm.get(listnumber)%></td>
                <td><%=remark.get(listnumber)%></td>
            </tr>
         <%
         listnumber++;

         }
         else{%>
            <td><%=dada%>日</td>
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
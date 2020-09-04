<%@page import="javax.swing.text.Document"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.util.Iterator"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.SearchForm" %>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.KintaiMainForm" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.chrono.JapaneseDate" %>
<html lang="ja">

<style>

body{

	text-align: center;
	background-color:e9e9e9;
	}
a{
text-decoration:none;
color:black;
	}
h1{
	margin-top: 8%;
    font-size: 50px;
}

table{
	 border: 1px solid;
   	align-items: center;
    line-height: 2;
	 border-collapse:collapse;
	 width:40%;

}

/*勤務管理表の年度と月度、及び社員の基本情報*/
.info{
	margin: 20px 0 20px 0;
	text-align: center;
}

/*上に表示する所属部、社員番号、名前*/
.basicInfo{
	text-align: center;
}

/*合計を表示するテーブル*/
.total{
	 border: 1px solid;
   	align-items: center;
    line-height: 2;
	 border-collapse:collapse;
	 width:80%;
	 margin: 20px 0 20px 0;
}

/*実際の勤務管理表のテーブル*/
.KinmuRecord{
	 border: 1px solid;
   	align-items: center;
    line-height: 2;
	 border-collapse:collapse;
	 width:95%;
	 margin: 20px 0 20px 0;
}

/*合計を表示するテーブルの見出し*/
.totalHead{
	font-size:12px;
}

/*勤務管理業テーブルの見出し*/
.KinmuHead{
	font-size:12px;
}

td{
	text-align: center;
	font-size:12px;
}


h2{

}
.back{
margin-top: 4%;
position:relative;

}
.send{
	background-color: #49a9d4;
	border-radius:8px;
	font-weight: bold;
	padding:8px;
	color:#fff;
}

.center {
	text-align:center;
}


.search {
	position:relative;

	display: inline-block;
}
.sarch btn-open{
	display: none;
}
</style>



<html:html>
	<head>
	<link rel="stylesheet"  type="text/css" href="../css/search.css">
	<center><h1>勤務管理表作成</h1></center>
	</head>

<html:form action="/KinmuRecordAction">
	<body>
		<div class="info">
			<p class="yearMonth">2020年 8月度</p>
			<p class="basicInfo">第5技術部</p>
			<p class="basicInfo">0329</p>
			<p class="basicInfo">川越康太郎</p>
		</div>


		<!-- 上のほうに合計時間を表示するテーブル -->
		<table class="total" border="1" align = "center" style="border-collapse: collapse">
			<tr bgcolor="#b0c4de">
				<th class="totalHead">総予定時間(h)</th>
				<th class="totalHead">総稼働時間(h)</th>
				<th class="totalHead">総残業時間(h)</th>
				<th class="totalHead">振休発生日数(日)</th>
				<th class="totalHead">有休/リ休(日)</th>
				<th class="totalHead">振替休(日)</th>
				<th class="totalHead">特別休(日)</th>
				<th class="totalHead">欠勤(日)</th>
			</tr>
			<tr>
				<td>168.00</td>
				<td>144.00</td>
				<td>0.00</td>
				<td>0</td>
				<td>3</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
		</table>


		<!-- 実際に勤務管理表を入力するテーブル -->
		<table class="KinmuRecord" border="1" align = "center" style="border-collapse: collapse">
			<tr  bgcolor="#b0c4de">
				<th class="kinmuHead"></th>
				<th class="kinmuHead"></th>
				<th class="kinmuHead">休/祝</th>
				<th class="kinmuHead">出社</th>
				<th class="kinmuHead">退社</th>
				<th class="kinmuHead">予定</th>
				<th class="kinmuHead">休A</th>
				<th class="kinmuHead">休B</th>
				<th class="kinmuHead">休暇区分</th>
				<th class="kinmuHead">実働時間</th>
				<th class="kinmuHead">備考</th>
			</tr>

			<%
			for(int i=1; i<=31; i++){
				LocalDate date = LocalDate.of(2020, 8, i);
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eee");

				out.println("<tr>");
				out.println("<td>" + i + "</td>");  //日付
				out.println("<td>" + JapaneseDate.from(date).format(fmt) + "</td>");  //曜日
				out.println("<td>" + "</td>");   //休/祝
				out.println("<td>" + "</td>");   //出社
				out.println("<td>" + "</td>");   //退社
				out.println("<td>" + "</td>");   //予定
				out.println("<td>" + "</td>");   //休A
				out.println("<td>" + "</td>");   //休B
				out.println("<td>" + "</td>");   //休暇区分
				out.println("<td>" + "</td>");   //実働時間
				out.println("<td>" + "</td></tr>");   //備考
			}
			%>
		</table>

		<div class="back">
			<html:submit styleClass="send" styleId="main" property="button" value="戻る"></html:submit>
		</div>

	</body>
</html:form>
</html:html>

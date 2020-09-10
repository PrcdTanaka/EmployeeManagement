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
<%@ page import="sample.pr.main.KinmuRecordForm" %>
<%@ page import="sample.pr.main.KintaiMainForm" %>
<%@ page import="sample.pr.main.KinmuRecordAction" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.chrono.JapaneseDate" %>
<%@ page import="sample.ap.DbAction" %>
<%@ page import="sample.pr.main.Open_informationForm"%>


<html lang="ja">
<html:html>
<head>
	<link rel="stylesheet" type="text/css" href="/WebSystem/css/KinmuRecord.css">
</head>

<body>
	<html:form action="/KinmuRecordAction" method="post">
		<%
			//インスタンス関連
			DbAction dba = new DbAction();
			LoginForm s1 = (LoginForm) session.getAttribute("form");
			Open_informationForm s2 = (Open_informationForm) session.getAttribute("oForm");
			KinmuRecordForm kinmuRF = new KinmuRecordForm();
			//ログインユーザーの情報
			String employeeNum = "";
			String employeeName = "";
			String employeeDivNum = "";
			//フォームクラスからゲッターで取得するもの
			String kintaiYMD = kinmuRF.getKintaiYMD();
			String holidayDiv = kinmuRF.getHolidayDiv();
			String startTime = kinmuRF.getStartTime();
			String endTime = kinmuRF.getEndTime();
			String breakTimeA = kinmuRF.getBreakTimeA();
			String breakTimeB = kinmuRF.getBreakTimeB();
			String vacationDiv = kinmuRF.getVacationDiv();
			String remark = kinmuRF.getRemark();
			String button = kinmuRF.getButton();
			String message = kinmuRF.getMessage();

			//ログインユーザーの社員番号と名前を取得して変数に代入
			try{
				employeeNum = s1.getEmployee_no();
				employeeName = s1.getEmployee_name();
				employeeDivNum = s2.getTec();

			} catch (Exception e) {

			}

			//ログインユーザーの所属部署を文字にして表示
			String employeeDivName = "";
			switch(employeeDivNum){
				case "00" :
					employeeDivName = "総務・経理部";
					break;
				case "01" :
					employeeDivName = "第１技術部";
					break;
				case "02" :
					employeeDivName = "第２技術部";
					break;
				case "03" :
					employeeDivName = "第３技術部";
					break;
				case "04" :
					employeeDivName = "第４技術部";
					break;
				case "05" :
					employeeDivName = "第５技術部";
					break;
				case "06" :
					employeeDivName = "ソリューション技術部";
					break;
				case "07" :
					employeeDivName = "システム営業部";
					break;
				case "08" :
					employeeDivName = "人事部";
					break;
				case "09" :
					employeeDivName = "採用マーケティング部";
					break;
				default:
					employeeDivName = "";
					break;
			}

		%>

		<center><h1>勤務管理表作成画面</h1></center>

		<div class="info">
			<p class="yearMonth">2020年 8月度</p>
			<p class="basicInfo"><%= employeeDivName %></p>
			<p class="basicInfo"><%= employeeNum %></p>
			<p class="basicInfo"><%= employeeName %></p>
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
				<th class="kinmuHead" colspan="2">日付</th>  <!-- 日にち -->
				<th class="kinmuHead" style="table-layout: auto;">休/祝</th>
				<th class="kinmuHead">出社</th>
				<th class="kinmuHead">退社</th>
				<th class="kinmuHead">予定</th>
				<th class="kinmuHead">休A</th>
				<th class="kinmuHead">休B</th>
				<th class="kinmuHead">休暇区分</th>
				<th class="kinmuHead">実働</th>
				<th class="kinmuHead">備考</th>
			</tr>

			<%-- 修正後の勤務管理表 --%>

				<% for(int i=1; i<=31; i++) {

					LocalDate date = LocalDate.of(2020, 8, i);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eee");%>
				<tr>
					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>

					<td></td>
				</tr>
				<% }%>
			</table>


			<div class="back">
				<html:submit styleClass="send" styleId="main" property="button" value="入力内容を保存"></html:submit><br>
				<html:submit styleClass="send" styleId="main" property="button" value="エクセルファイル出力"></html:submit><br>
				<html:submit styleClass="send" styleId="main" property="button" value="戻る"></html:submit>
			</div>

	</html:form>
</body>
</html:html>



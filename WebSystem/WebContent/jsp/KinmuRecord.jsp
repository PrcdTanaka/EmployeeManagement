<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.KinmuRecordForm" %>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.KinmuRecordAction" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.chrono.JapaneseDate" %>
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
			String kintaiYMD1 = kinmuRF.getKintaiYMD1();
			String kintaiYMD2 = kinmuRF.getKintaiYMD2();
			String kintaiYMD3 = kinmuRF.getKintaiYMD3();
			String kintaiYMD4 = kinmuRF.getKintaiYMD4();
			String kintaiYMD5 = kinmuRF.getKintaiYMD5();
			String kintaiYMD6 = kinmuRF.getKintaiYMD6();
			String kintaiYMD7 = kinmuRF.getKintaiYMD7();
			String kintaiYMD8 = kinmuRF.getKintaiYMD8();
			String kintaiYMD9 = kinmuRF.getKintaiYMD9();
			String kintaiYMD10 = kinmuRF.getKintaiYMD10();
			String kintaiYMD11 = kinmuRF.getKintaiYMD11();
			String kintaiYMD12 = kinmuRF.getKintaiYMD12();
			String kintaiYMD13 = kinmuRF.getKintaiYMD13();
			String kintaiYMD14 = kinmuRF.getKintaiYMD14();
			String kintaiYMD15 = kinmuRF.getKintaiYMD15();
			String kintaiYMD16 = kinmuRF.getKintaiYMD16();
			String kintaiYMD17 = kinmuRF.getKintaiYMD17();
			String kintaiYMD18 = kinmuRF.getKintaiYMD18();
			String kintaiYMD19 = kinmuRF.getKintaiYMD19();
			String kintaiYMD20 = kinmuRF.getKintaiYMD20();
			String kintaiYMD21 = kinmuRF.getKintaiYMD21();
			String kintaiYMD22 = kinmuRF.getKintaiYMD22();
			String kintaiYMD23 = kinmuRF.getKintaiYMD23();
			String kintaiYMD24 = kinmuRF.getKintaiYMD24();
			String kintaiYMD25 = kinmuRF.getKintaiYMD25();
			String kintaiYMD26 = kinmuRF.getKintaiYMD26();
			String kintaiYMD27 = kinmuRF.getKintaiYMD27();
			String kintaiYMD28 = kinmuRF.getKintaiYMD28();
			String kintaiYMD29 = kinmuRF.getKintaiYMD29();
			String kintaiYMD30 = kinmuRF.getKintaiYMD30();
			String kintaiYMD31 = kinmuRF.getKintaiYMD31();

			String holidayDiv1 = kinmuRF.getHolidayDiv1();
			String holidayDiv2 = kinmuRF.getHolidayDiv2();
			String holidayDiv3 = kinmuRF.getHolidayDiv3();
			String holidayDiv4 = kinmuRF.getHolidayDiv4();
			String holidayDiv5 = kinmuRF.getHolidayDiv5();
			String holidayDiv6 = kinmuRF.getHolidayDiv6();
			String holidayDiv7 = kinmuRF.getHolidayDiv7();
			String holidayDiv8 = kinmuRF.getHolidayDiv8();
			String holidayDiv9 = kinmuRF.getHolidayDiv9();
			String holidayDiv10 = kinmuRF.getHolidayDiv10();
			String holidayDiv11 = kinmuRF.getHolidayDiv11();
			String holidayDiv12 = kinmuRF.getHolidayDiv12();
			String holidayDiv13 = kinmuRF.getHolidayDiv13();
			String holidayDiv14 = kinmuRF.getHolidayDiv14();
			String holidayDiv15 = kinmuRF.getHolidayDiv15();
			String holidayDiv16 = kinmuRF.getHolidayDiv16();
			String holidayDiv17 = kinmuRF.getHolidayDiv17();
			String holidayDiv18 = kinmuRF.getHolidayDiv18();
			String holidayDiv19 = kinmuRF.getHolidayDiv19();
			String holidayDiv20 = kinmuRF.getHolidayDiv20();
			String holidayDiv21 = kinmuRF.getHolidayDiv21();
			String holidayDiv22 = kinmuRF.getHolidayDiv22();
			String holidayDiv23 = kinmuRF.getHolidayDiv23();
			String holidayDiv24 = kinmuRF.getHolidayDiv24();
			String holidayDiv25 = kinmuRF.getHolidayDiv25();
			String holidayDiv26 = kinmuRF.getHolidayDiv26();
			String holidayDiv27 = kinmuRF.getHolidayDiv27();
			String holidayDiv28 = kinmuRF.getHolidayDiv28();
			String holidayDiv29 = kinmuRF.getHolidayDiv29();
			String holidayDiv30 = kinmuRF.getHolidayDiv30();
			String holidayDiv31 = kinmuRF.getHolidayDiv31();

			String startTime1 = kinmuRF.getStartTime1();
			String startTime2 = kinmuRF.getStartTime2();
			String startTime3 = kinmuRF.getStartTime3();
			String startTime4 = kinmuRF.getStartTime4();
			String startTime5 = kinmuRF.getStartTime5();
			String startTime6 = kinmuRF.getStartTime6();
			String startTime7 = kinmuRF.getStartTime7();
			String startTime8 = kinmuRF.getStartTime8();
			String startTime9 = kinmuRF.getStartTime9();
			String startTime10 = kinmuRF.getStartTime10();
			String startTime11 = kinmuRF.getStartTime11();
			String startTime12 = kinmuRF.getStartTime12();
			String startTime13 = kinmuRF.getStartTime13();
			String startTime14 = kinmuRF.getStartTime14();
			String startTime15 = kinmuRF.getStartTime15();
			String startTime16 = kinmuRF.getStartTime16();
			String startTime17 = kinmuRF.getStartTime17();
			String startTime18 = kinmuRF.getStartTime18();
			String startTime19 = kinmuRF.getStartTime19();
			String startTime20 = kinmuRF.getStartTime20();
			String startTime21 = kinmuRF.getStartTime21();
			String startTime22 = kinmuRF.getStartTime22();
			String startTime23 = kinmuRF.getStartTime23();
			String startTime24 = kinmuRF.getStartTime24();
			String startTime25 = kinmuRF.getStartTime25();
			String startTime26 = kinmuRF.getStartTime26();
			String startTime27 = kinmuRF.getStartTime27();
			String startTime28 = kinmuRF.getStartTime28();
			String startTime29 = kinmuRF.getStartTime29();
			String startTime30 = kinmuRF.getStartTime30();
			String startTime31 = kinmuRF.getStartTime31();

			String endTime1 = kinmuRF.getEndTime1();
			String endTime2 = kinmuRF.getEndTime2();
			String endTime3 = kinmuRF.getEndTime3();
			String endTime4 = kinmuRF.getEndTime4();
			String endTime5 = kinmuRF.getEndTime5();
			String endTime6 = kinmuRF.getEndTime6();
			String endTime7 = kinmuRF.getEndTime7();
			String endTime8 = kinmuRF.getEndTime8();
			String endTime9 = kinmuRF.getEndTime9();
			String endTime10 = kinmuRF.getEndTime10();
			String endTime11 = kinmuRF.getEndTime11();
			String endTime12 = kinmuRF.getEndTime12();
			String endTime13 = kinmuRF.getEndTime13();
			String endTime14 = kinmuRF.getEndTime14();
			String endTime15 = kinmuRF.getEndTime15();
			String endTime16 = kinmuRF.getEndTime16();
			String endTime17 = kinmuRF.getEndTime17();
			String endTime18 = kinmuRF.getEndTime18();
			String endTime19 = kinmuRF.getEndTime19();
			String endTime20 = kinmuRF.getEndTime20();
			String endTime21 = kinmuRF.getEndTime21();
			String endTime22 = kinmuRF.getEndTime22();
			String endTime23 = kinmuRF.getEndTime23();
			String endTime24 = kinmuRF.getEndTime24();
			String endTime25 = kinmuRF.getEndTime25();
			String endTime26 = kinmuRF.getEndTime26();
			String endTime27 = kinmuRF.getEndTime27();
			String endTime28 = kinmuRF.getEndTime28();
			String endTime29 = kinmuRF.getEndTime29();
			String endTime30 = kinmuRF.getEndTime30();
			String endTime31 = kinmuRF.getEndTime31();

			String breakTimeA1 = kinmuRF.getBreakTimeA1();
			String breakTimeA2 = kinmuRF.getBreakTimeA2();
			String breakTimeA3 = kinmuRF.getBreakTimeA3();
			String breakTimeA4 = kinmuRF.getBreakTimeA4();
			String breakTimeA5 = kinmuRF.getBreakTimeA5();
			String breakTimeA6 = kinmuRF.getBreakTimeA6();
			String breakTimeA7 = kinmuRF.getBreakTimeA7();
			String breakTimeA8 = kinmuRF.getBreakTimeA8();
			String breakTimeA9 = kinmuRF.getBreakTimeA9();
			String breakTimeA10 = kinmuRF.getBreakTimeA10();
			String breakTimeA11 = kinmuRF.getBreakTimeA11();
			String breakTimeA12 = kinmuRF.getBreakTimeA12();
			String breakTimeA13 = kinmuRF.getBreakTimeA13();
			String breakTimeA14 = kinmuRF.getBreakTimeA14();
			String breakTimeA15 = kinmuRF.getBreakTimeA15();
			String breakTimeA16 = kinmuRF.getBreakTimeA16();
			String breakTimeA17 = kinmuRF.getBreakTimeA17();
			String breakTimeA18 = kinmuRF.getBreakTimeA18();
			String breakTimeA19 = kinmuRF.getBreakTimeA19();
			String breakTimeA20 = kinmuRF.getBreakTimeA20();
			String breakTimeA21 = kinmuRF.getBreakTimeA21();
			String breakTimeA22 = kinmuRF.getBreakTimeA22();
			String breakTimeA23 = kinmuRF.getBreakTimeA23();
			String breakTimeA24 = kinmuRF.getBreakTimeA24();
			String breakTimeA25 = kinmuRF.getBreakTimeA25();
			String breakTimeA26 = kinmuRF.getBreakTimeA26();
			String breakTimeA27 = kinmuRF.getBreakTimeA27();
			String breakTimeA28 = kinmuRF.getBreakTimeA28();
			String breakTimeA29 = kinmuRF.getBreakTimeA29();
			String breakTimeA30 = kinmuRF.getBreakTimeA30();
			String breakTimeA31 = kinmuRF.getBreakTimeA31();

			String breakTimeB1 = kinmuRF.getBreakTimeB1();
			String breakTimeB2 = kinmuRF.getBreakTimeB2();
			String breakTimeB3 = kinmuRF.getBreakTimeB3();
			String breakTimeB4 = kinmuRF.getBreakTimeB4();
			String breakTimeB5 = kinmuRF.getBreakTimeB5();
			String breakTimeB6 = kinmuRF.getBreakTimeB6();
			String breakTimeB7 = kinmuRF.getBreakTimeB7();
			String breakTimeB8 = kinmuRF.getBreakTimeB8();
			String breakTimeB9 = kinmuRF.getBreakTimeB9();
			String breakTimeB10 = kinmuRF.getBreakTimeB10();
			String breakTimeB11 = kinmuRF.getBreakTimeB11();
			String breakTimeB12 = kinmuRF.getBreakTimeB12();
			String breakTimeB13 = kinmuRF.getBreakTimeB13();
			String breakTimeB14 = kinmuRF.getBreakTimeB14();
			String breakTimeB15 = kinmuRF.getBreakTimeB15();
			String breakTimeB16 = kinmuRF.getBreakTimeB16();
			String breakTimeB17 = kinmuRF.getBreakTimeB17();
			String breakTimeB18 = kinmuRF.getBreakTimeB18();
			String breakTimeB19 = kinmuRF.getBreakTimeB19();
			String breakTimeB20 = kinmuRF.getBreakTimeB20();
			String breakTimeB21 = kinmuRF.getBreakTimeB21();
			String breakTimeB22 = kinmuRF.getBreakTimeB22();
			String breakTimeB23 = kinmuRF.getBreakTimeB23();
			String breakTimeB24 = kinmuRF.getBreakTimeB24();
			String breakTimeB25 = kinmuRF.getBreakTimeB25();
			String breakTimeB26 = kinmuRF.getBreakTimeB26();
			String breakTimeB27 = kinmuRF.getBreakTimeB27();
			String breakTimeB28 = kinmuRF.getBreakTimeB28();
			String breakTimeB29 = kinmuRF.getBreakTimeB29();
			String breakTimeB30 = kinmuRF.getBreakTimeB30();
			String breakTimeB31 = kinmuRF.getBreakTimeB31();

			String vacationDiv1 = kinmuRF.getVacationDiv1();
			String vacationDiv2 = kinmuRF.getVacationDiv2();
			String vacationDiv3 = kinmuRF.getVacationDiv3();
			String vacationDiv4 = kinmuRF.getVacationDiv4();
			String vacationDiv5 = kinmuRF.getVacationDiv5();
			String vacationDiv6 = kinmuRF.getVacationDiv6();
			String vacationDiv7 = kinmuRF.getVacationDiv7();
			String vacationDiv8 = kinmuRF.getVacationDiv8();
			String vacationDiv9 = kinmuRF.getVacationDiv9();
			String vacationDiv10 = kinmuRF.getVacationDiv10();
			String vacationDiv11 = kinmuRF.getVacationDiv11();
			String vacationDiv12 = kinmuRF.getVacationDiv12();
			String vacationDiv13 = kinmuRF.getVacationDiv13();
			String vacationDiv14 = kinmuRF.getVacationDiv14();
			String vacationDiv15 = kinmuRF.getVacationDiv15();
			String vacationDiv16 = kinmuRF.getVacationDiv16();
			String vacationDiv17 = kinmuRF.getVacationDiv17();
			String vacationDiv18 = kinmuRF.getVacationDiv18();
			String vacationDiv19 = kinmuRF.getVacationDiv19();
			String vacationDiv20 = kinmuRF.getVacationDiv20();
			String vacationDiv21 = kinmuRF.getVacationDiv21();
			String vacationDiv22 = kinmuRF.getVacationDiv22();
			String vacationDiv23 = kinmuRF.getVacationDiv23();
			String vacationDiv24 = kinmuRF.getVacationDiv24();
			String vacationDiv25 = kinmuRF.getVacationDiv25();
			String vacationDiv26 = kinmuRF.getVacationDiv26();
			String vacationDiv27 = kinmuRF.getVacationDiv27();
			String vacationDiv28 = kinmuRF.getVacationDiv28();
			String vacationDiv29 = kinmuRF.getVacationDiv29();
			String vacationDiv30 = kinmuRF.getVacationDiv30();
			String vacationDiv31 = kinmuRF.getVacationDiv31();

			String remark1 = kinmuRF.getRemark1();
			String remark2 = kinmuRF.getRemark2();
			String remark3 = kinmuRF.getRemark3();
			String remark4 = kinmuRF.getRemark4();
			String remark5 = kinmuRF.getRemark5();
			String remark6 = kinmuRF.getRemark6();
			String remark7 = kinmuRF.getRemark7();
			String remark8 = kinmuRF.getRemark8();
			String remark9 = kinmuRF.getRemark9();
			String remark10 = kinmuRF.getRemark10();
			String remark11 = kinmuRF.getRemark11();
			String remark12 = kinmuRF.getRemark12();
			String remark13 = kinmuRF.getRemark13();
			String remark14 = kinmuRF.getRemark14();
			String remark15 = kinmuRF.getRemark15();
			String remark16 = kinmuRF.getRemark16();
			String remark17 = kinmuRF.getRemark17();
			String remark18 = kinmuRF.getRemark18();
			String remark19 = kinmuRF.getRemark19();
			String remark20 = kinmuRF.getRemark20();
			String remark21 = kinmuRF.getRemark21();
			String remark22 = kinmuRF.getRemark22();
			String remark23 = kinmuRF.getRemark23();
			String remark24 = kinmuRF.getRemark24();
			String remark25 = kinmuRF.getRemark25();
			String remark26 = kinmuRF.getRemark26();
			String remark27 = kinmuRF.getRemark27();
			String remark28 = kinmuRF.getRemark28();
			String remark29 = kinmuRF.getRemark29();
			String remark30 = kinmuRF.getRemark30();
			String remark31 = kinmuRF.getRemark31();

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
					//指定した年月日が何曜日なのかを表示する用
					LocalDate date = LocalDate.of(2020, 8, i);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eee");
					//各入力フォームのstyleIdは以下を指定する
					String holidayDivPro = "holidayDiv" + String.valueOf(i);
					String startTimePro = "startTime" + String.valueOf(i);
					String endTimePro = "endTime" + String.valueOf(i);
					String expectationPro = "expectation" + String.valueOf(i);
					String breakTimeAPro = "breakTimeA" + String.valueOf(i);
					String breakTimeBPro = "breakTimeB" + String.valueOf(i);
					String vacationDivPro = "vacationDiv" + String.valueOf(i);
					String remarkPro = "remark" + String.valueOf(i);
				%>
				<tr>
					<%-- 日にち --%>
					<td width="7px"><%= i %></td>

					<%-- 曜日 --%>
					<td width="7px"><%= JapaneseDate.from(date).format(fmt) %></td>

					<%-- 休/祝 --%>
					<td width="5%">
						<html:select property="<%= holidayDivPro %>" styleId="<%= holidayDivPro %>" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="1">休</html:option>
							<html:option value="2">祝</html:option>
						</html:select>
					</td>

					<%-- 出社時間 --%>
					<td width="5%">
						<html:select property="<%= startTimePro %>" styleId="<%= startTimePro %>" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="0000">0:00</html:option>
							<html:option value="0015">0:15</html:option>
							<html:option value="0030">0:30</html:option>
							<html:option value="0045">0:45</html:option>
							<html:option value="0100">1:00</html:option>
							<html:option value="0115">1:15</html:option>
							<html:option value="0130">1:30</html:option>
							<html:option value="0145">1:45</html:option>
							<html:option value="0200">2:00</html:option>
							<html:option value="0215">2:15</html:option>
							<html:option value="0230">2:30</html:option>
							<html:option value="0245">2:45</html:option>
							<html:option value="0300">3:00</html:option>
							<html:option value="0315">3:15</html:option>
							<html:option value="0330">3:30</html:option>
							<html:option value="0345">3:45</html:option>
							<html:option value="0400">4:00</html:option>
							<html:option value="0415">4:15</html:option>
							<html:option value="0430">4:30</html:option>
							<html:option value="0445">4:45</html:option>
							<html:option value="0500">5:00</html:option>
							<html:option value="0515">5:15</html:option>
							<html:option value="0530">5:30</html:option>
							<html:option value="0545">5:45</html:option>
							<html:option value="0600">6:00</html:option>
							<html:option value="0615">6:15</html:option>
							<html:option value="0630">6:30</html:option>
							<html:option value="0645">6:45</html:option>
							<html:option value="0700">7:00</html:option>
							<html:option value="0715">7:15</html:option>
							<html:option value="0730">7:30</html:option>
							<html:option value="0745">7:45</html:option>
							<html:option value="0800">8:00</html:option>
							<html:option value="0815">8:15</html:option>
							<html:option value="0830">8:30</html:option>
							<html:option value="0845">8:45</html:option>
							<html:option value="0900">9:00</html:option>
							<html:option value="0915">9:15</html:option>
							<html:option value="0930">9:30</html:option>
							<html:option value="0945">9:45</html:option>
							<html:option value="1000">10:00</html:option>
							<html:option value="1015">10:15</html:option>
							<html:option value="1030">10:30</html:option>
							<html:option value="1045">10:45</html:option>
							<html:option value="1100">11:00</html:option>
							<html:option value="1115">11:15</html:option>
							<html:option value="1130">11:30</html:option>
							<html:option value="1145">11:45</html:option>
							<html:option value="1200">12:00</html:option>
							<html:option value="1215">12:15</html:option>
							<html:option value="1230">12:30</html:option>
							<html:option value="1245">12:45</html:option>
							<html:option value="1300">13:00</html:option>
							<html:option value="1315">13:15</html:option>
							<html:option value="1330">13:30</html:option>
							<html:option value="1345">13:45</html:option>
							<html:option value="1400">14:00</html:option>
							<html:option value="1415">14:15</html:option>
							<html:option value="1430">14:30</html:option>
							<html:option value="1445">14:45</html:option>
							<html:option value="1500">15:00</html:option>
							<html:option value="1515">15:15</html:option>
							<html:option value="1530">15:30</html:option>
							<html:option value="1545">15:45</html:option>
							<html:option value="1600">16:00</html:option>
							<html:option value="1615">16:15</html:option>
							<html:option value="1630">16:30</html:option>
							<html:option value="1645">16:45</html:option>
							<html:option value="1700">17:00</html:option>
							<html:option value="1715">17:15</html:option>
							<html:option value="1730">17:30</html:option>
							<html:option value="1745">17:45</html:option>
							<html:option value="1800">18:00</html:option>
							<html:option value="1815">18:15</html:option>
							<html:option value="1830">18:30</html:option>
							<html:option value="1845">18:45</html:option>
							<html:option value="1900">19:00</html:option>
							<html:option value="1915">19:15</html:option>
							<html:option value="1930">19:30</html:option>
							<html:option value="1945">19:45</html:option>
							<html:option value="2000">20:00</html:option>
							<html:option value="2015">20:15</html:option>
							<html:option value="2030">20:30</html:option>
							<html:option value="2045">20:45</html:option>
							<html:option value="2100">21:00</html:option>
							<html:option value="2115">21:15</html:option>
							<html:option value="2130">21:30</html:option>
							<html:option value="2145">21:45</html:option>
							<html:option value="2200">22:00</html:option>
							<html:option value="2215">22:15</html:option>
							<html:option value="2230">22:30</html:option>
							<html:option value="2245">22:45</html:option>
							<html:option value="2300">23:00</html:option>
							<html:option value="2315">23:15</html:option>
							<html:option value="2330">23:30</html:option>
							<html:option value="2345">23:45</html:option>
						</html:select>
					</td>

					<%-- 退社時間 --%>
					<td width="5%">
						<html:select property="<%= endTimePro %>" styleId="<%= startTimePro %>" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="0000">0:00</html:option>
							<html:option value="0015">0:15</html:option>
							<html:option value="0030">0:30</html:option>
							<html:option value="0045">0:45</html:option>
							<html:option value="0100">1:00</html:option>
							<html:option value="0115">1:15</html:option>
							<html:option value="0130">1:30</html:option>
							<html:option value="0145">1:45</html:option>
							<html:option value="0200">2:00</html:option>
							<html:option value="0215">2:15</html:option>
							<html:option value="0230">2:30</html:option>
							<html:option value="0245">2:45</html:option>
							<html:option value="0300">3:00</html:option>
							<html:option value="0315">3:15</html:option>
							<html:option value="0330">3:30</html:option>
							<html:option value="0345">3:45</html:option>
							<html:option value="0400">4:00</html:option>
							<html:option value="0415">4:15</html:option>
							<html:option value="0430">4:30</html:option>
							<html:option value="0445">4:45</html:option>
							<html:option value="0500">5:00</html:option>
							<html:option value="0515">5:15</html:option>
							<html:option value="0530">5:30</html:option>
							<html:option value="0545">5:45</html:option>
							<html:option value="0600">6:00</html:option>
							<html:option value="0615">6:15</html:option>
							<html:option value="0630">6:30</html:option>
							<html:option value="0645">6:45</html:option>
							<html:option value="0700">7:00</html:option>
							<html:option value="0715">7:15</html:option>
							<html:option value="0730">7:30</html:option>
							<html:option value="0745">7:45</html:option>
							<html:option value="0800">8:00</html:option>
							<html:option value="0815">8:15</html:option>
							<html:option value="0830">8:30</html:option>
							<html:option value="0845">8:45</html:option>
							<html:option value="0900">9:00</html:option>
							<html:option value="0915">9:15</html:option>
							<html:option value="0930">9:30</html:option>
							<html:option value="0945">9:45</html:option>
							<html:option value="1000">10:00</html:option>
							<html:option value="1015">10:15</html:option>
							<html:option value="1030">10:30</html:option>
							<html:option value="1045">10:45</html:option>
							<html:option value="1100">11:00</html:option>
							<html:option value="1115">11:15</html:option>
							<html:option value="1130">11:30</html:option>
							<html:option value="1145">11:45</html:option>
							<html:option value="1200">12:00</html:option>
							<html:option value="1215">12:15</html:option>
							<html:option value="1230">12:30</html:option>
							<html:option value="1245">12:45</html:option>
							<html:option value="1300">13:00</html:option>
							<html:option value="1315">13:15</html:option>
							<html:option value="1330">13:30</html:option>
							<html:option value="1345">13:45</html:option>
							<html:option value="1400">14:00</html:option>
							<html:option value="1415">14:15</html:option>
							<html:option value="1430">14:30</html:option>
							<html:option value="1445">14:45</html:option>
							<html:option value="1500">15:00</html:option>
							<html:option value="1515">15:15</html:option>
							<html:option value="1530">15:30</html:option>
							<html:option value="1545">15:45</html:option>
							<html:option value="1600">16:00</html:option>
							<html:option value="1615">16:15</html:option>
							<html:option value="1630">16:30</html:option>
							<html:option value="1645">16:45</html:option>
							<html:option value="1700">17:00</html:option>
							<html:option value="1715">17:15</html:option>
							<html:option value="1730">17:30</html:option>
							<html:option value="1745">17:45</html:option>
							<html:option value="1800">18:00</html:option>
							<html:option value="1815">18:15</html:option>
							<html:option value="1830">18:30</html:option>
							<html:option value="1845">18:45</html:option>
							<html:option value="1900">19:00</html:option>
							<html:option value="1915">19:15</html:option>
							<html:option value="1930">19:30</html:option>
							<html:option value="1945">19:45</html:option>
							<html:option value="2000">20:00</html:option>
							<html:option value="2015">20:15</html:option>
							<html:option value="2030">20:30</html:option>
							<html:option value="2045">20:45</html:option>
							<html:option value="2100">21:00</html:option>
							<html:option value="2115">21:15</html:option>
							<html:option value="2130">21:30</html:option>
							<html:option value="2145">21:45</html:option>
							<html:option value="2200">22:00</html:option>
							<html:option value="2215">22:15</html:option>
							<html:option value="2230">22:30</html:option>
							<html:option value="2245">22:45</html:option>
							<html:option value="2300">23:00</html:option>
							<html:option value="2315">23:15</html:option>
							<html:option value="2330">23:30</html:option>
							<html:option value="2345">23:45</html:option>
						</html:select>
					</td>

					<%-- 予定 --%>
					<td width="4%">
					<% if(!(JapaneseDate.from(date).format(fmt).equals("土")) && !(JapaneseDate.from(date).format(fmt).equals("日"))) { %>
						8:00
					<% } %>
					</td>

					<%-- 休A --%>
					<td width="5%">
						<html:select property="<%= breakTimeAPro %>" styleId="<%= breakTimeAPro %>" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="0000">0:00</html:option>
							<html:option value="0015">0:15</html:option>
							<html:option value="0030">0:30</html:option>
							<html:option value="0045">0:45</html:option>
							<html:option value="0100">1:00</html:option>
							<html:option value="0115">1:15</html:option>
							<html:option value="0130">1:30</html:option>
							<html:option value="0145">1:45</html:option>
							<html:option value="0200">2:00</html:option>
							<html:option value="0215">2:15</html:option>
							<html:option value="0230">2:30</html:option>
							<html:option value="0245">2:45</html:option>
							<html:option value="0300">3:00</html:option>
							<html:option value="0315">3:15</html:option>
							<html:option value="0330">3:30</html:option>
							<html:option value="0345">3:45</html:option>
							<html:option value="0400">4:00</html:option>
						</html:select>
					</td>

					<%-- 休B --%>
					<td width="5%">
						<html:select property="<%= breakTimeBPro %>" styleId="<%= breakTimeBPro %>" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="0000">0:00</html:option>
							<html:option value="0015">0:15</html:option>
							<html:option value="0030">0:30</html:option>
							<html:option value="0045">0:45</html:option>
							<html:option value="0100">1:00</html:option>
							<html:option value="0115">1:15</html:option>
							<html:option value="0130">1:30</html:option>
							<html:option value="0145">1:45</html:option>
							<html:option value="0200">2:00</html:option>
							<html:option value="0215">2:15</html:option>
							<html:option value="0230">2:30</html:option>
							<html:option value="0245">2:45</html:option>
							<html:option value="0300">3:00</html:option>
							<html:option value="0315">3:15</html:option>
							<html:option value="0330">3:30</html:option>
							<html:option value="0345">3:45</html:option>
							<html:option value="0400">4:00</html:option>
						</html:select>
					</td>

					<%-- 休暇区分 --%>
					<td width="22%">
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value=""/>該当なし
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value="1" />有休/リフ休
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value="2" />遅/早
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value="3" />振休
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value="4" />特休
						<html:radio property="<%= vacationDivPro %>" styleId="<%= vacationDivPro %>" value="5" />欠勤
					</td>

					<%-- 実働 --%>
					<td width="4%">
					<% if(!(JapaneseDate.from(date).format(fmt).equals("土")) && !(JapaneseDate.from(date).format(fmt).equals("日"))) { %>
						8.00
					<% } %>
					</td>

					<%-- 備考 --%>
					<td width="20%"><html:text property="<%= remarkPro %>" styleId="<%= remarkPro %>" size="30" maxlength="50" /></td>
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



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
			String kintaiYMD = kinmuRF.getKintaiYMD();
			String holidayDiv1 = kinmuRF.getHolidayDiv();
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
					//指定した年月日が何曜日なのかを表示する用
					LocalDate date = LocalDate.of(2020, 8, i);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eee");%>
				<tr>
					<%-- 日にち --%>
					<td width="7px"><%= i %></td>

					<%-- 曜日 --%>
					<td width="7px"><%= JapaneseDate.from(date).format(fmt) %></td>

					<%-- 休/祝 --%>
					<td width="7px">
						<html:select property="holidayDiv" styleId="holidayDiv" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="1">休</html:option>
							<html:option value="2">祝</html:option>
						</html:select>
					</td>

					<%-- 出社時間 --%>
					<td width="7px">
						<html:select property="startTime" styleId="startTime" name="KinmuRecordForm">
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
					<td width="7px">
						<html:select property="endTime" styleId="endTime" name="KinmuRecordForm">
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
					<td width="7px">
						<html:select property="expectation" styleId="expectation" name="KinmuRecordForm">
							<html:option value="" style="text-align:center;">-</html:option>
							<html:option value="0800">8:00</html:option>
						</html:select>
					</td>

					<%-- 休A --%>
					<td width="7px">
						<html:select property="breakTimeA" styleId="breakTimeA" name="KinmuRecordForm">
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
					<td width="7px">
						<html:select property="breakTimeB" styleId="breakTimeB" name="KinmuRecordForm">
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
						<html:radio property="vacationDiv" value=""/>該当なし
						<html:radio property="vacationDiv" value="1" />有休/リフ休
						<html:radio property="vacationDiv" value="2" />遅/早
						<html:radio property="vacationDiv" value="3" />振休
						<html:radio property="vacationDiv" value="4" />特休
						<html:radio property="vacationDiv" value="5" />欠勤
					</td>

					<%-- 実働 --%>
					<td width="4%">
					<% if(!(JapaneseDate.from(date).format(fmt).equals("土")) && !(JapaneseDate.from(date).format(fmt).equals("日"))) { %>
						8.00
					<% } %>
					</td>

					<%-- 備考 --%>
					<td width="20%"><html:text property="remark" size="30" maxlength="50" /></td>
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



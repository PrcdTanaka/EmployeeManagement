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


<html lang="ja">
<html:html>
<head>
	<link rel="stylesheet" type="text/css" href="/WebSystem/css/KinmuRecord.css">
</head>

<body>
	<center><h1>勤務管理表作成画面</h1></center>
	<html:form action="/KinmuRecordAction" method="post">
		<%
		String Employee_no="";
		String name = "";
		DbAction dba = new DbAction();
		LoginForm s = (LoginForm) session.getAttribute("form");
		KinmuRecordForm kinmuRF = new KinmuRecordForm();


		%>

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
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eee");
				%>
				<tr>
					<td width="7px"><%= i %></td>   <%-- 日付 --%>
					<td width="7px"><%= JapaneseDate.from(date).format(fmt) %></td>   <%-- 曜日 --%>
					<td width="10px">  <%-- 休/祝 --%>
						<select>
							<option value="0">-</option>
							<option value="1">休</option>
							<option value="2">祝</option>
						</select>
					</td>
					<td><%-- 出社 --%>
						<select>
						<% //プルダウンの表示
						int hour1=0, min1=0;
						for(int j=0; j<96; j++){ %>
							<% if(min1==0) { %>
								<option>
									<%= hour1 %>:0<%= min1 %>
								</option>
							<% } else { %>
								<option>
									<%= hour1 %>:<%= min1 %>
								</option>
							<% } %>

							<%  //時間の更新
							min1 += 15;
							if(min1%60==0){
								hour1++;
								min1=0;
							}
							%>
						<%}%>
						</select>
					</td>
					<td>  <%-- 退社 --%>
						<select>
						<% //プルダウンの表示
						int hour2=0, min2=0;
						for(int j=0; j<96; j++){ %>
							<% if(min2==0) { %>
								<option>
									<%= hour2 %>:0<%= min2 %>
								</option>
							<% } else { %>
								<option>
									<%= hour2 %>:<%= min2 %>
								</option>
							<% } %>

							<%  //時間の更新
							min2 += 15;
							if(min2%60==0){
								hour2++;
								min2=0;
							}
							%>
						<%}%>
						</select>
					</td>

					<td><%-- 予定 --%>
					<% if(!(JapaneseDate.from(date).format(fmt).equals("土")) && !(JapaneseDate.from(date).format(fmt).equals("日"))) { %>
						8.00
					<% } %>
					</td>

					<td>  <%-- 休A --%>
					<select>
					<% double restTimeA = 0.00;
					   for(int k=0; k<17; k++){ %>
							<option><%= restTimeA %></option>
							<% restTimeA += 0.25; %>
					<% }%>
					</select>
					</td>

					<td><%-- 休B --%>
					<select>
					<% double restTimeB = 0.00;
					   for(int l=0; l<17; l++){ %>
							<option><%= restTimeB %></option>
							<% restTimeB += 0.25; %>
					<% }%>
					</select>
					</td>


					<td width="40%">  <%-- 休暇区分 --%>
						<input type="radio" name="kubun" value="0">0.出勤
						<input type="radio" name="kubun" value="1">1.有休/リ休
						<input type="radio" name="kubun" value="2">2.遅/早
						<input type="radio" name="kubun" value="3">3.振休
						<input type="radio" name="kubun" value="4">4.特休
						<input type="radio" name="kubun" value="5">5.欠勤
					</td>

					<td width="6%"><%-- 実働時間 --%>
					<% if(!(JapaneseDate.from(date).format(fmt).equals("土")) && !(JapaneseDate.from(date).format(fmt).equals("日"))) { %>
						8.00
					<% } %>
					</td>

					<td width="20%">  <%-- 備考 --%>
						<input type="text" name="bikou">
					</td>
				</tr>
				<% } %>
			</table>


			<div class="back">
				<html:submit styleClass="send" styleId="main" property="button" value="入力内容を保存"></html:submit><br>
				<html:submit styleClass="send" styleId="main" property="button" value="エクセルファイル出力"></html:submit><br>
				<html:submit styleClass="send" styleId="main" property="button" value="戻る"></html:submit>
			</div>

	</html:form>
</body>
</html:html>



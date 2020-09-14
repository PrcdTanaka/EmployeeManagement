<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.pr.main.KintaiNotificationForm"%>
<%@ page import="sample.pr.main.KintaiNotificationAction"%>
<%@ page import="sample.pr.main.LoginForm"%>

<style>
.back {
	margin-top: 4%;
	position: relative;
}

.block {
	margin: 16px auto;
	text-align: center;
	display: block;
}

.block .centers {
	text-align: left;
	display: inline-block;
	padding-bottom: 10px;
}

textarea {
	resize: none;
}
</style>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>勤怠届作成画面</title>
<html:base />
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<table>
	<center>
		<h1>勤怠届作成</h1>
	</center>
</table>

<body>
	<%
 		String message;
		LoginForm s1 = (LoginForm) session.getAttribute("form");

		String employee_no="";
 		try{
 			KintaiNotificationForm KNform = new KintaiNotificationForm();
 			message =  KNform.getMessage();
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 		try{
 			employee_no = s1.getEmployee_no();

		} catch (Exception e) {

		}

 		%>


	<html:form action="/KintaiNotificationAction">
		<div class="block">

			<div class="space"></div>

			<div class="centers"><%= message %></div>


			<!-- 社員番号入力欄 -->
			<div class="centers">
				<p class="list">
					社員番号 ：
					<html:text property="employee_no" size="5" maxlength="4" />
					氏名 ：
					<html:text property="syain_name" size="12" maxlength="12" />
				</p>

				<p>
					所属部門 ：
					<html:select property="depart" name="KintaiNotificationForm">
						<html:option value="">選択してください</html:option>
						<html:option value="1">第1技術部</html:option>
						<html:option value="2">第2技術部</html:option>
						<html:option value="3">第3技術部</html:option>
						<html:option value="4">第4技術部</html:option>
						<html:option value="5">第5技術部</html:option>
						<html:option value="6">ソリューション技術部</html:option>
					</html:select>
				</p>

				<p>
					申請日 ：
					<html:text property="petition_ymd" size="10" maxlength="8" />

				</p>
				<p>
					対象日 ：
					<html:text property="attendance_startday" size="10" maxlength="8" />
					～
					<html:text property="attendance_endday" size="10" maxlength="8" />
				</p>
				<p>
					対象時間 ： <input type="text" name="attendance_starttime" size="10"
						maxlength="4"> ～ <input type="text"
						name="attendance_endtime" size="10" maxlength="4">
				</p>

				<p>
					届出事由 ：
					<html:select property="notification_reason"
						name="KintaiNotificationForm">
						<html:option value="">選択してください</html:option>
						<html:option value="1">1：遅刻</html:option>
						<html:option value="2">2：早退</html:option>
						<html:option value="3">3：私用外出</html:option>
						<html:option value="4">4：休暇</html:option>
						<html:option value="5">5：休職</html:option>
						<html:option value="6">6：育児休業</html:option>
						<html:option value="7">7：無断欠勤</html:option>
					</html:select>
				</p>
				<p>
					休暇区分 ：
					<html:select property="vacation_division"
						name="KintaiNotificationForm">
						<html:option value="">選択してください</html:option>
						<html:option value="1">1.年次有給休暇/リフ休</html:option>
						<html:option value="3">3.振替休暇</html:option>
						<html:option value="4">4.特別休暇</html:option>
						<html:option value="5">5.欠勤</html:option>
					</html:select>

				</p>

				<p>
					振替対象日：
					<html:text property="transfer_day" size="10" maxlength="8" />
				</p>

				<p>
					特休理由 ：
					<html:select property="sp_holiday_reason"
						name="KintaiNotificationForm">
						<html:option value="">選択してください</html:option>
						<html:option value="1">1:結婚</html:option>
						<html:option value="2">2:産前産後休業</html:option>
						<html:option value="3">3:忌引き</html:option>
						<html:option value="4">4:生理休暇</html:option>
						<html:option value="5">5:天災地変</html:option>
						<html:option value="6">6:伝染病予防</html:option>
						<html:option value="7">7:そのた</html:option>
					</html:select>
				</p>

				<p>
					欠勤理由 ：
					<html:radio property="absenteeism_reason" value="1" />
					病気
					<html:radio property="absenteeism_reason" value="2" />
					自己都合
					<html:radio property="absenteeism_reason" value="3" />
					事故
				</p>

			</div>
			<!-- brock.centers End -->
			<br>
			<p>事由</p>
			<p>
				<html:textarea property="reason" rows="6" cols="40" />
		</div>

		<!-- エクセル出力ボタン -->
		<div class="back">
			<html:submit property="button" styleClass="btn" value="エクセル作成"
				styleId="kintaiNotification" />
			<!-- 戻るボタン -->
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />
		</div>
	</html:form>
</body>
</html:html>

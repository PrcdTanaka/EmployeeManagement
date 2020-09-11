<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.KintaiNotificationForm"%>
<%@ page import="sample.pr.main.LoginForm"%>
<style>
.link-style-btn {
	cursor: pointer;
	border: none;
	background: none;
	color: #0033cc;
}

.link-style-btn:hover {
	text-decoration: underline;
	color: #002080;
}

.back {
	margin-top: 4%;
	position: relative;
}

p.centers {
	text-align: center;
	margin: 10px;
}

textarea {
	resize: none;
}

p.jyutexts {resize none;
	text-align: center;
	margin: 10px;
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
		<h1>勤怠届</h1>
	</center>
</table>

<body>

	<html:form action="/LoginAction">
		<div class="block">

			<div class="space"></div>

			<!-- 社員番号入力欄 -->
			<div>
				<p class="centers">
					社員番号：
					<html:text property="employee_no" size="5" maxlength="4" />
					氏名： <input type="text" name="syain_name" size="12" maxlength="20" />
				</p>
				<p class="centers">
					所属部門： <select name="depart">
						<option value="1">第1技術部</option>
						<option value="2">第2技術部</option>
						<option value="3">第3技術部</option>
						<option value="4">第4技術部</option>
						<option value="5">第5技術部</option>
						<option value="6">ソリューション技術部</option>
					</select>
				</p>
				<p class="centers">
					申請日： <input type="date" name="petition_ymd" size="12" maxlength="8">
				</p>
				<p class="centers">
					対象日： <input type="date" name="attendance_startday" size="12">
					～ <input type="date" name="attendance_endday" size="12">
				</p>
				<p class="centers">
					対象時間： <input type="text" name="attendance_starttime" size="8">
					～ <input type="text" name="attendance_endtime" size="8">
				</p>

				<p class="centers">
					届出事由： <select name="notification_reason">
						<option value="not1">1：遅刻</option>
						<option value="not2">3：私用外出</option>
						<option value="not3">2：早退</option>
						<option value="not4">4：休暇</option>
						<option value="not5">5：休職</option>
						<option value="not6">6：育児休業</option>
						<option value="not7">7：無断欠勤</option>
					</select>
				</p>
				<p class="centers">
					休暇区分： <select name="vacation_division">
						<option value="vac1">1.年次有給休暇/リフ休</option>
						<option value="vac3">3.振替休暇</option>
						<option value="vac4">4.特別休暇</option>
						<option value="vac5">5.欠勤</option>
					</select>
				</p>

				<p class="centers">
					振替対象日： <input type="date" name="Transfer_Day" size="12" disabled>
				</p>

				<p class="centers">
					特休理由： <select name="sp_holiday_reason" disabled>
						<option value="sph1">1:結婚</option>
						<option value="sph2">2:産前産後休業</option>
						<option value="sph3">3:忌引き</option>
						<option value="sph4">4:生理休暇</option>
						<option value="sph5">5:天災地変</option>
						<option value="sph6">6:伝染病予防</option>
						<option value="sph7">7:そのた</option>
					</select>
				</p>
			</div>
			<p class="centers" disabled>
				欠勤理由: <input type="radio" value="1" name="absenteeism_reason">
				病気 <input type="radio" value="2" name="absenteeism_reason">
				自己都合 <input type="radio" value="3" name="absenteeism_reason">
				事故
			</p>
			<br>
			<p class="centers">事由</p>
			<p class="centers">
				<textarea name="reason" rows="5" cols="40"></textarea>
			</p>

			<div class="space"></div>
			<br>
			<!-- エクセル出力ボタン -->
			<span><html:submit property="button" styleClass="btn"
					value="エクセル作成" styleId="excelOutput" /></span>
			<!-- 戻るボタン -->
			<span><html:submit property="button" styleClass="btn"
					value="戻る" styleId="back" /></span>
		</div>
	</html:form>
</body>
</html:html>

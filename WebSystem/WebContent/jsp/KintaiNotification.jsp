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

.brock {
	margin: 16px auto;
	text-align: center;
	display: block;
	border: 1px solid #000;
}
.brock .centers {
	text-align: left;
	display: inline-block;
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
		<h1>勤怠届作成</h1>
	</center>
</table>

<body>

	<html:form action="/KintaiNotificationAction">
		<div class="block">

			<div class="space"></div>

			<!-- 社員番号入力欄 -->
			<div class="centers">
				<p class="list">
					社員番号：
					<html:text property="employee_no" size="5" maxlength="4" />
					氏名：
					<html:text property="syain_name" size="12" maxlength="20" />
				</p>
				<p>
					所属部門： <select name="depart">
						<option value="1">第1技術部</option>
						<option value="2">第2技術部</option>
						<option value="3">第3技術部</option>
						<option value="4">第4技術部</option>
						<option value="5">第5技術部</option>
						<option value="6">ソリューション技術部</option>
					</select>
				</p>
				<p>
					申請日： <input type="date" name="petition_ymd" size="12" maxlength="8">
				</p>
				<p>
					対象日： <input type="date" name="attendance_startday" size="12">
					～ <input type="date" name="attendance_endday" size="12">
				</p>
				<p>
					対象時間： <input type="text" name="attendance_starttime" size="8">
					～ <input type="text" name="attendance_endtime" size="8">
				</p>

				<p>
					届出事由： <select name="notification_reason">
						<option value="1">1：遅刻</option>
						<option value="2">3：私用外出</option>
						<option value="3">2：早退</option>
						<option value="4">4：休暇</option>
						<option value="5">5：休職</option>
						<option value="6">6：育児休業</option>
						<option value="7">7：無断欠勤</option>
					</select>
				</p>
				<p>
					休暇区分： <select name="vacation_division">
						<option value="1">1.年次有給休暇/リフ休</option>
						<option value="3">3.振替休暇</option>
						<option value="4">4.特別休暇</option>
						<option value="5">5.欠勤</option>
					</select>
				</p>

				<p>
					振替対象日： <input type="date" name="Transfer_Day" size="12" disabled>
				</p>

				<p>
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

			<p disabled>
				欠勤理由: <input type="radio" value="1" name="absenteeism_reason">
				病気 <input type="radio" value="2" name="absenteeism_reason">
				自己都合 <input type="radio" value="3" name="absenteeism_reason">
				事故
			</p>

			</div><!-- brock.centers End -->>
			<br>
			<p>事由</p>
			<p>
				<textarea name="reason" rows="5" cols="40"></textarea>
			</p>

			<div class="space"></div>
			<br>
			<!-- エクセル出力ボタン -->
			<div class="back"><html:submit property="button" styleClass="btn"
					value="エクセル作成" styleId="excelOutput" />
			<!-- 戻るボタン -->
			<html:submit property="button" styleClass="btn"
					value="戻る" styleId="login" />
			</div>
		</div>
	</html:form>
</body>
</html:html>

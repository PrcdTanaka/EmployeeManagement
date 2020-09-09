<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.LoginForm" %>
<style>
.link-style-btn{
  cursor: pointer;
  border: none;
  background: none;
  color: #0033cc;
}
.link-style-btn:hover{
  text-decoration: underline;
  color: #002080;
}

.back{
margin-top: 4%;
position:relative;

}

p.centers {
	text-align:center;
	background:#C8FFA6;
	margin:10px;
}

</style>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>勤怠届作成画面</title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<table>
		<center><h1>勤怠届作成</h1></center>
	</table>

	<body>
	 	<%
 		String message;
 		try{
 			LoginForm s = (LoginForm) session.getAttribute("form");
 			message =  s.getMessage();
 			if(message == null)
 				message = "";

 		}catch(NullPointerException e){
 			message = "";
 		}

 	%>


		<html:form action="/LoginAction" >
			<div class="block">

				<div class="space"></div>

				<center><%= message %></center>

				<td id="sidebar">
				</td>

				<!-- 社員番号入力欄 -->
				<div>
					<p class="centers">　　社員番号：
						<html:text property="employee_no" size="5" maxlength="4" />
						　　氏名：
						<input type="text" name="syain_name" maxlength="20" />
					</p>
					<p class="centers">　　所属部門：
						<select name="Depart">
							<option value="dai1">第1技術部</option>
							<option value="dai2">第2技術部</option>
							<option value="dai3">第3技術部</option>
							<option value="dai4">第4技術部</option>
							<option value="dai5">第5技術部</option>
							<option value="dai6">ソリューション技術部</option>
						</select>
					</p>
					<p class="centers">　　申請日：
						<input type="date" name="Petition_Ymd" maxlength="8">
					</p>
					<p class="centers">　　対象日：
						<input type="date" name="Attendance_Startday">
						　～　
						<input type="date" name="Attendance_Endday">
					</p>
					<p class="centers">　　対象時間：
						<input type="text" name="Attendance_Starttime">
						　～　
						<input type="text" name="Attendance_Endtime">
					</p>

					<p class="centers">　　届出事由：
						<select name="Notification_Reason">
							<option value="not1">1：遅刻</option>
							<option value="not2">3：私用外出</option>
							<option value="not3">2：早退</option>
							<option value="not4">4：休暇</option>
							<option value="not5">5：休職</option>
							<option value="not6">6：育児休業</option>
							<option value="not7">7：無断欠勤</option>
						</select>
					</p>
					<p class="centers">　　休暇区分：
						<select name="Vacation_Division">
							<option value="vac1">1.年次有給休暇/リフ休</option>
							<option value="vac3">3.振替休暇</option>
							<option value="vac4">4.特別休暇</option>
							<option value="vac5">5.欠勤</option>
						</select>
					</p>

					<p class="centers">　　振替対象日：
						<input type="date" name="Transfer_Day">
					</p>

					<p class="centers">　　特休理由：
						<select name="Sp_Holiday_Reason">
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
				<p class="centers">　　欠勤理由:
					<input type="radio" value="1" name="Absenteeism_Reason"> 病気
					<input type="radio" value="2" name="Absenteeism_Reason"> 自己都合
					<input type="radio" value="3" name="Absenteeism_Reason"> 事故
				</p>

				<p class="centers">　　事由：
					<textarea name="Reason" rows="5" cols="40"></textarea>
				</p>

				<div class="space"></div>
				<br>
				<div class="back">
				<html:submit styleClass="send" styleId="main" property="button" value="エクセルファイル出力"></html:submit><br>
				<html:submit styleClass="send" styleId="main" property="button" value="戻る"></html:submit>
				</div>
				<!-- ログインボタン -->
				<span><html:submit property="button" styleClass="btn" value="ログイン" styleId="login" /></span>
			</div>
		</html:form>
	</body>
</html:html>

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
</style>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="login.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style2.css">
	</head>

	<center><h1>勤務管理表作成</h1></center>

	<body>
		<html:form action="/LoginAction" >



			<div class="block">

				<div class="space"></div>
				<!-- 各種合計値の表 -->
				<table>
					<tr>
						<th class="kawagoe">総予定時間(h)</th>
						<th>総稼働時間(h)</th>
						<th>総残業時間(h)</th>
						<th>振休発生日数(日)</th>
						<th>有休/リ休(日)</th>
						<th>振替休(日)</th>
						<th>特別休(日)</th>
						<th>欠勤(日)</th>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>

				<!-- 勤怠管理表 -->



				<!-- 社員番号入力欄 -->
				<div>
					<center>　　社員No：
						<html:text property="employee_no" maxlength="4" />
					</center>
				</div>
				<div>
					<center>パスワード：
						<html:password property="password" value= "" />
					</center>
				</div>

				<div class="space"></div>
				<br>
				<!-- ログインボタン -->
				<span><html:submit property="button" styleClass="btn" value="ログイン" styleId="login" /></span>
			</div>
			<html:submit  styleClass="link-style-btn"  property="button" styleId="pass" value="パスワードを忘れた場合は"/>
		</html:form>
	</body>
</html:html>

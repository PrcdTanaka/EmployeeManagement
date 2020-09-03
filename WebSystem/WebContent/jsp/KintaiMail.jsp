
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="ja">
<html:html>
<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/KintaiMail.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<body>
	<html:form action="/KintaiMailAction">
		<%
			String depertment = " ";
		%>
		<div>
			<center>
				<h1>勤怠連絡画面</h1>
			</center>
		</div>

		<p align="center">
			宛先：<input type="text" name="namae" size="43" maxlength="20">
		</p>

		<div align="center" class="depert" >
		CC:
			<select name="DEPERT" style="width:338px">
				<option value="1">第一技術部</option>
				<option value="2">第二技術部</option>
				<option value="3">第三技術部</option>
				<option value="4">第四技術部</option>
				<option value="5">第五技術部</option>
				<option value="6">第六技術部</option>
				<option value="7">ソリューション技術部</option>
			</select>
		</div>
		<p align="center"class="BCC">
			BCC：<input type="text" name="namae" size="43" maxlength="20">
		</p>

		<div align="center" class="depert2" >
		所属部署:
			<select name="DEPERT" style="width:338px;margin-top:40;">
				<option value="1">第一技術部</option>
				<option value="2">第二技術部</option>
				<option value="3">第三技術部</option>
				<option value="4">第四技術部</option>
				<option value="5">第五技術部()</option>
				<option value="6">第六技術部</option>
				<option value="7">ソリューション技術部</option>
			</select>
		</div>

		<p align="center"class="number">
			社員番号：<input type="text" name="namae" size="43" maxlength="20">
		</p>
		<p align="center"class="BCC">
			氏名：<input type="text" name="namae" size="43" maxlength="20">
		</p>
		<p align="center"class="code">
			現場コード：<input type="text" name="namae" size="43" maxlength="20">
		</p>
		<div align="center" class="depert2" >
		届出区分:
			<select name="DEPERT" style="width:338px">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">A</option>
				<option value="11">B</option>
			</select>
		</div>
		<p align="center"class="date">
			対象日付/期間：<input type="text" name="namae" size="43" maxlength="20">
		</p>
		<p align="center"class="time">
			出勤予定時刻：<input type="text" name="namae" size="43" maxlength="20">
		</p>
				<p style="margin-left:32%;">備考:</p>
					<div style="margin-left:36%;"><html:textarea property="time" rows="10" cols="40" value=""></html:textarea></div>

		<p align="center"class="BCC">
			許可：<input type="text" name="namae" size="43" maxlength="20">
		</p>

		<div>
			<html:submit property="button" styleClass="btn" value="送信"
				styleId="kintaimail" style="margin-top:10;"/>
		</div>
		<div>
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="KintaiMain" style="margin-top:10;"/>
		</div>





	</html:form>
</body>
</html:html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.MainForm" %>

<html:html>

<link rel="stylesheet" type="text/css" href="../main.css">
<link rel="stylesheet" type="text/css" href="../reference.css">
	<body>
		<%
		LoginForm lfs = (LoginForm) session.getAttribute("searchForm");
		String name = lfs.getEmployee_name();
		
		%>
		<div class="SS">
			<p>名前　　　：<%= name %>　　　役職：なし</p>
			<p>入社年月日：自動入力<p>
			<p>技術部　　：第2技術部</p>
		</div>

		<div class="IMG">
			<img src="C:\Users\mizuki_komaki\Pictures\Screenshots\a.png"  height="170px">
		</div>

		<div class="free">
			<p>趣味：聞き耳</p>
			<p>特技：秒間18連打</p>
		<div class="syokai">
			<p style="position:relative;right:80px;">紹介文</p>
			<p style="font-size:20px;position:relative;right:50px;">てやんでぇ</p>
		</div>
		<div>
		      <p><input type="button" class="btn" value="戻る" onclick="location.href='main.html'"></input></p>
		</div>
	</body>
</html:html>


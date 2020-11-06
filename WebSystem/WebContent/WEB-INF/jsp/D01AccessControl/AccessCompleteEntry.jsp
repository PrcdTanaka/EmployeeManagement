<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/D01AccessControl/AccessComplete.css">
<title>入室完了画面</title>
</head>
<body>
	<div class="wrapper">
		<div class="head">
			<div class="title">入室完了画面</div>
		</div>
		<div class="main">
			<div class="sentence">入室完了しました。</div>
			<div class="button">
				<html:link action="/MainAction">入退室管理システムメイン画面に戻る
		<html:param name="link">accessControl</html:param>
				</html:link>
			</div>
		</div>
	</div>
</body>
</html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="main.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body>
		<html:form action="/MainAction" >
			<div class="block">

<!-- 				<div>社員管理システムaa</div>	 -->

				<div class="space"></div>

				<!-- 社員番号入力欄 -->
				<div><html:text property="syain_no" maxlength="4" /></div>

				<div class="space"></div>

				<!-- 出社ボタン -->
				<span><html:submit property="button" value="出社" /></span>

				<!-- 退社ボタン -->
				<span><html:submit property="button" value="退社"  /></span>

				<!-- 参照ボタン -->
				<span><html:submit property="button" value="参照" /></span>

			</div>
		</html:form>
	</body>
</html:html>

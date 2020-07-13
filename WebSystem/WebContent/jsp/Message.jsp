<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="password" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="message.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body>
		<div class="block">
			<bean:write name="MainForm" property="message"
				scope="request" ignore="true" />
				<br>
			<bean:write name="MainForm" property="dtime"
				scope="request" ignore="true" />
			<%/*
				【bean:write】
				name属性    ：スコープに登録されたBean名
				property属性：Bean内のプロパティ
			*/%>

		</div>
				<!-- 戻るボタン -->
				<input type="button" value="戻る" onclick="history.back()" />

	</body>
</html:html>

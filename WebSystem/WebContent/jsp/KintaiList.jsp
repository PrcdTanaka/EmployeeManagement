<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<%@ page contentType="text/html;charset=Windows-31J" pageEncoding="UTF-8" %>
		<title><bean:message key="itiran.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body>
		<div class="block">
			<span>勤怠情報</span>
			<%/*
				【bean:write】
				name属性    ：スコープに登録されたBean名
				property属性：Bean内のプロパティ
			*/%>
			<span><bean:write name="MainForm" property="syain_no" /></span>
			<span><bean:write name="MainForm" property="syain_name" /></span>
			<div><bean:write name="MainForm" property="message" /></div>
			<div class="space"></div>
			<table>
				<tr>
					<th>年月日</th>
					<th>出社時刻</th>
					<th>退社時刻</th>
				</tr>
				<%/*
					【logic:iterate】
					name属性    ：スコープに登録されたBean名
					property属性：Bean内のプロパティ
					id属性      ：ループで使用する変数名
				*/%>
				<logic:iterate name="MainForm" property="syainInfo" id="bean" scope="request">
				</logic:iterate>
			</table>
		</div>
	</body>
</html:html>

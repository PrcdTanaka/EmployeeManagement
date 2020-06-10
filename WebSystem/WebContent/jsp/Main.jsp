<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="login.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<table>
		<center><h1>ログイン画面</h1></center>
	</table>
	
	<body>
		<html:form action="/MainAction" >
			<div class="block">

				

				<div class="space"></div>

				<!-- 社員番号入力欄 -->
				<div>
					<center>　　社員No：
						<html:text property="syain_no" maxlength="4" />
					</center>
				</div>
				<div>
					<center>パスワード：
						<html:text property="password"/>
					</center>
				</div>

				<div class="space"></div>
				</br>
				<!-- 出社ボタン -->
				<span><html:submit property="button" styleClass="btn" value="ログイン" styleId="login" /></span>

			</div>
		</html:form>
	</body>
</html:html>

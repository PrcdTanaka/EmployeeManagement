<%@page import="sample.pr.main.LoginForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.PasswordForm"%>

<html:html>
<head>
<html:base />
<title><bean:message key="password.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html lang="ja">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<table>
	<center>
		<h1>秘密の質問入力画面</h1>
	</center>
</table>
<%
	String message;
		try {
			LoginForm lform = (LoginForm) session.getAttribute("form");
			PasswordForm pForm = (PasswordForm) session
					.getAttribute("pForm");
			message = pForm.getMessage();
			pForm.setEmployee_no(lform.getEmployee_no());
			if (message == null)
				message = "";

		} catch (NullPointerException e) {
			message = "";
		}
%>
<body>
	<html:form action="/PasswordForgetAction">
		<div class="block">

			<br> <br>
			<center><%=message%></center>
			<br>
			<div>
				<center>
			<div class="question">
				<label for="question">秘密の質問：</label>
				<html:select property="Myquestion" name="Personal_informationForm"
					styleId="question" value="">
					<html:option value="">選択してください</html:option>
					<html:option value="1">母親の旧姓</html:option>
					<html:option value="2">飼っているペットの名前</html:option>
					<html:option value="3">好きな食べ物</html:option>
					<html:option value="4">好きな国</html:option>
					<html:option value="5">初めて観た映画</html:option>
					<html:option value="6">学生時代の部活</html:option>
					<html:option value="7">子供の頃のあだ名</html:option>
					<html:option value="8">座右の銘</html:option>
					<html:option value="9">初めて行った海外</html:option>
					<html:option value="0">おふくろの味</html:option>
				</html:select>
				<html:text property="Myanswer" name="Personal_informationForm"
						styleId="answer" value="" size="40" maxlength="50" />
			</div>
				</center>
			</div>
			<br>
			<!-- 変更ボタン -->
			<html:submit property="button" styleClass="btn" value="次へ"
				styleId="change" />
			<!-- 戻るボタン -->
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main" />

		</div>
	</html:form>
</body>
</html:html>
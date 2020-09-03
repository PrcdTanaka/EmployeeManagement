
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.KintaiMainForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="ja">
<html:html>
<body>
<html:form action="/KintaiMainAction">
	<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
	</head>


	<%
			try {
						KintaiMainForm kForm = (KintaiMainForm) session
								.getAttribute("kForm");
					} catch (NullPointerException e) {

					}

					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					KintaiMainForm kForm = new KintaiMainForm();
					kForm.setEmployee_no(s.getEmployee_no());
		%>
	<div>
			<center>
				<h1>勤怠連絡管理画面</h1>
			</center>
		</div>
		<div>
			<html:submit property="button" styleClass="btn" value="勤怠連絡入力"
				styleId="kintaimail"/>
		</div>
		<div>
			<html:submit property="button" styleClass="btn" value="勤怠一覧画面へ"
				styleId="catalog"/>
		</div>
		<div>
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="main"/>
		</div>
	</html:form>
	</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>エクセル出力完了</title>
</head>
<body>

	<h2>エクセル出力完了しました</h2>

	<html:form action="/MonthlyReportAction">
        <div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="kintailist" />
		</div>

	</html:form>
</body>
</html:html>
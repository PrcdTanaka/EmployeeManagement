<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="d02.access.log.AccessLogSelectForm"%>
<%
	AccessLogSelectForm aLSForm = (AccessLogSelectForm) request
			.getAttribute("aLSForm");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>履歴閲覧画面</title>
</head>
<body>

	<h2>履歴閲覧画面</h2>

	<html:link action="/MainAction">入退室管理システムメイン画面へ戻る
		<html:param name="link">accessControl</html:param>
	</html:link>

	<table border=3>
		<tr>
			<th>日付</th>
			<th>入室者社員名</th>
			<th>入室者社員番号</th>
			<th>入室時間</th>
			<th>退室者社員名</th>
			<th>退室者社員番号</th>
			<th>退出時間</th>
			<th>チェックリスト</th>
			<th>ステータス</th>
		</tr>

		<%
			for (int i = 0; i < aLSForm.getAccessDate().size(); i++) {
		%>
		<tr>
			<td><%=aLSForm.getAccessDate().get(i)%></td>
			<td><%=aLSForm.getEntryEmpName().get(i)%></td>
			<td><%=aLSForm.getEntryEmpNo().get(i)%></td>
			<td><%=aLSForm.getEntryTime().get(i)%></td>
			<td><%=aLSForm.getExitEmpName().get(i)%></td>
			<td><%=aLSForm.getExitEmpNo().get(i)%></td>
			<td><%=aLSForm.getExitTime().get(i)%></td>
			<td><%=aLSForm.getCheckList().get(i)%></td>
			<td><%=aLSForm.getStatus().get(i)%></td>
		</tr>
		<%
			}
		%>

	</table>


</body>
</html>
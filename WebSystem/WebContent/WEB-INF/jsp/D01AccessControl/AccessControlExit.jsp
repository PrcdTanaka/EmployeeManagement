<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="d01.access.control.AccessSelectForm" %>
<%
AccessSelectForm aSForm = (AccessSelectForm) session.getAttribute("aSForm");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退室画面</title>
</head>
<body>

	<div>
		退室処理
		<html:form action="/UpdateAccess">

			<h3>1.電気</h3>
			<p>
				・エアコン
				<html:multibox property="checklist" value="1" />
			</p>
			<p>
				・照明
				<html:multibox property="checklist" value="1" />
			</p>
			<%
					if (aSForm.getFloor() == 2) {
			%>
			<p>
				・ポット
				<html:multibox property="checklist" value="1" />
			</p>
			<%
				}
			%>
			<h3>2.戸締り</h3>
			<p>
				・窓
				<html:multibox property="checklist" value="1" />
			</p>
			<p>
				・オートロックの施錠確認
				<html:multibox property="checklist" value="1" />
			</p>
			<h3>3.避難経路の物品放置の有無</h3>
			<p>
				・避難口
				<html:multibox property="checklist" value="1" />
			</p>
			<p>
				・廊下
				<html:multibox property="checklist" value="1" />
			</p>
			<p>
				・避難経路
				<html:multibox property="checklist" value="1" />
			</p>
			<p>
				・防火扉
				<html:multibox property="checklist" value="1" />
			</p>
			<br>
			<h3>
				4.配線確認
				<html:multibox property="checklist" value="1" />
			</h3>
			<h3>
				5.煙草の吸い殻確認
				<html:multibox property="checklist" value="1" />
			</h3>
			<h3>
				6.トイレに可燃物のゴミがないか確認
				<html:multibox property="checklist" value="1" />
			</h3>
			<br>
			<html:submit styleClass="send" property="button" value="退室" />
		</html:form>
	</div>

	<button type="button" onclick="history.back()">戻る</button>



</body>
</html>
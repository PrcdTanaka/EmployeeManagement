<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="d01.access.control.AccessSelectForm"%>
<%
	AccessSelectForm aSForm = (AccessSelectForm) session
			.getAttribute("aSForm");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/WebSystem/JavaScript/D01AccessControl/AccessControlExit.js"></script>
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/D01AccessControl/AccessControlExit.css">
<title>退室画面</title>
</head>
<body>
	<div class="wrapper">
		<div class="head">
			<div class="title"><%=aSForm.getFloor()%>階 退室画面
			</div>
			<div class="empInfo">
				社員名：<%=aSForm.getEmpName()%>
				社員番号：<%=aSForm.getEmpNo()%></div>
		</div>
		<div class="info">
			<div class="sentence">お疲れさまでした。チェック項目を確認してください。</div>
		</div>
		<div class="main">
			<div class="mainTitle">退室チェック項目</div>
			<div class="mainContainer">
				<html:form action="/UpdateAccess">
					<div class="mainCheckBox">
						<div class="checkContainer">
							<div class="checkTitle">1.電気</div>
							<div class="checkSubTitle">
								・エアコン
								<html:multibox property="checklist" value="1" />
							</div>
							<div>
								・照明
								<html:multibox property="checklist" value="1" />
							</div>
							<%
								if (aSForm.getFloor() == 2) {
							%>
							<div>
								・ポット
								<html:multibox property="checklist" value="1" />
							</div>
							<%
								}
							%>
						</div>

						<div class="checkContainer">

							<div class="checkTitle">2.戸締り</div>
							<div>
								・窓
								<html:multibox property="checklist" value="1" />
							</div>
							<div>
								・オートロックの施錠確認
								<html:multibox property="checklist" value="1" />
							</div>
						</div>
						<div class="checkContainer">
							<div class="checkTitle">3.避難経路の物品放置の有無</div>
							<div>
								・避難口
								<html:multibox property="checklist" value="1" />
							</div>
							<div>
								・廊下
								<html:multibox property="checklist" value="1" />
							</div>
							<div>
								・避難経路
								<html:multibox property="checklist" value="1" />
							</div>
							<div>
								・防火扉
								<html:multibox property="checklist" value="1" />
							</div>
						</div>
						<div class="checkContainer">
							<div class="checkTitle">
								4.配線確認
								<html:multibox property="checklist" value="1" />
							</div>
						</div>
						<div class="checkContainer">
							<div class="checkTitle">
								5.煙草の吸い殻確認
								<html:multibox property="checklist" value="1" />
							</div>
						</div>
						<div class="checkContainer">
							<div class="checkTitle">
								6.トイレの可燃物ゴミの確認
								<html:multibox property="checklist" value="1" />
							</div>
						</div>
					</div>
					<div class="mainButton">
					退室ボタン

					<html:submit styleClass="submit" property="button" value="退室"
						disabled="true" />
					</div>
				</html:form>
			</div>
		</div>
		<div class="back">
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</div>


</body>
</html>
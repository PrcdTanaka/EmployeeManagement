<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.Open_informationForm"%>
<%@ page import="java.util.function.*"%>

<html:html>


<head>
<link rel="stylesheet" type="text/css" href="../css/open.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">


</head>
<body>
	<html:form action="/Open_informationAction">
		<%
		String name = "";
		String pos ="";
	%>
		<div class='main1'>
			<div class='pic'>
				<img src="C:\Users\gakuto_yamagishi\Desktop\susi.jpg" height="200"
					width="200">
			</div>
			<div class='pro'>
				<div class='pro2'>
					<p style="margin-top: 5px;">
						名前：<%= name %>
					</p>
					<p style="margin-top: 5px; margin-left: 50px">
						役職：<%= pos %>
					</p>
				</div>
				<div class='pro2'>
					<div class='day'>入社年月日:</div>
					<html:text property="djc" />
				</div>
				<div class='pro2'>
					<div class='tec'>技術部 :</div>
					<html:select property="tec" name="Open_informationForm"
						styleId="tec">
						<html:option value="">-</html:option>
						<html:option value="0">第1技術部</html:option>
						<html:option value="1">第2技術部</html:option>
						<html:option value="2">第3技術部</html:option>
						<html:option value="3">第4技術部</html:option>
						<html:option value="4">第5技術部</html:option>
					</html:select>
				</div>
			</div>
		</div>

		<div class='main2'>
			<div class='pro3'>
				<div class='hobyy'>趣味:</div>
				<html:text property="hobby" />
			</div>
			<div class='pro3'>
				<div class='ss'>特技:</div>
				<html:text property="ss" />
			</div>
		</div>

		<div class='bottom'>
			<div class='int'>紹介文</div>
			<html:textarea property="intr"></html:textarea>
			<!-- styleClass='int2'name='int2' cols='100' rows='10' -->
		</div>
		<!-- 登録/編集ボタン  -->
		<p id="Bentry">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="entry" />
		</p>

		<p id="Bedit">
			<input type="button" value="編集" id="edit" onclick="clickBtnEdit()"
				class="btn" />
		</p>
		<!-- 戻るボタン -->
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />
		<%
		//function clickBtnEdit() {
			//			document.getElementById("Bentry").style.display = "block";
				//		document.getElementById("Bedit").style.display = "none";
		//}
						%>

	</html:form>
</body>
</html:html>

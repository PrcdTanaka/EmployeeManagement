<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.Open_RefelenceForm"%>
<%@ page import="java.util.function.*"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.SearchForm"%>

<html:html>


<head>
<link rel="stylesheet" type="text/css" href="../css/open.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">


</head>
<body>
	<html:form action="/Open_informationAction">
		<%
			DbAction dba = new DbAction();
					Open_RefelenceForm oForm = new Open_RefelenceForm();

					String name = "";
					String pos = "";
					String djc = "";
					String tec = "";
					String hobby = "";
					String ss = "";
					String intr = "";

					// 社員名を探すために社員番号が必要
					// 社員番号を取得するために...
					// 欲しい社員番号：ユーザ検索画面で押された社員番号

					// 名前がDBに登録されているかの確認
					if (dba.getName(oForm)) {
						// 名前が存在する場合
						// DBから個人情報を取得する
						dba.getPos(oForm);
						dba.getDjc(oForm);
						dba.getTec(oForm);
						dba.getHobby(oForm);
						dba.getSs(oForm);
						dba.getIntr(oForm);

						// 各パラメーターを設定する
						//name = oForm.getName();
						//pos = oForm.getPos();
						//djc = oForm.getDjc();
						//tec = oForm.getTec();
						//hobby = oForm.getHobby();
						//ss = oForm.getSs();
						//intr = oForm.getIntr();
					}
		%>
		<div class='main1'>
			<div class='pic'>
				<img src="C:\Users\gakuto_yamagishi\Desktop\susi.jpg" height="200"
					width="200">
			</div>
			<div class='pro'>
				<div class='pro2'>
					<p style="margin-top: 5px;">
						名前：
						<html:text property="name" styleId="name"></html:text>

					</p>
					<p style="margin-top: 5px; margin-left: 50px">
						役職：
						<html:text property="pos" styleId="pos"></html:text>
					</p>
				</div>
				<div class='pro2'>
					<div class='day'>入社年月日:</div>

					<html:text property="djc" styleId="djc"></html:text>
				</div>
				<div class='pro2'>
					<div class='tec'>技術部 :</div>
					<html:text property="tec" name="Open_informationForm" styleId="tec"></html:text>
				</div>
			</div>
		</div>

		<div class='main2'>
			<div class='pro3'>
				<div class='hobyy'>趣味:</div>
				<html:text property="hobby" styleId="hobby"></html:text>
			</div>
			<div class='pro3'>
				<div class='ss'>特技:</div>
				<html:text property="ss" styleId="ss"></html:text>
			</div>
		</div>

		<div class='bottom'>
			<div class='int'>紹介文</div>
			<html:textarea property="intr" styleId="intr"></html:textarea>
			<!-- styleClass='int2'name='int2' cols='100' rows='10' -->
		</div>

		<!-- 戻るボタン -->
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />

		<script type="text/javascript">
			document.getElementById('name').readOnly = true;
			document.getElementById('pos').readOnly = true;
			document.getElementById('djc').readOnly = true;
			document.getElementById('tec').readOnly = true;
			document.getElementById('hobby').readOnly = true;
			document.getElementById('ss').readOnly = true;
			document.getElementById('intr').readOnly = true;
		</script>



	</html:form>
</body>
</html:html>

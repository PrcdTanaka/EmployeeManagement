<%@page import="sample.pr.main.Personal_informationForm"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.Open_informationForm"%>
<%@ page import="java.util.function.*"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.Open_informationForm"%>
<%@ page import="sample.ap.DbAction"%>

<html:html>


<head>
<link rel="stylesheet" type="text/css" href="../css/open.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">


</head>
<body>
	<html:form action="/Open_informationAction">
		<%
			String message;
					try {
						Open_informationForm oForm = (Open_informationForm) session
								.getAttribute("oForm");
						message = oForm.getMessage();
						if (message == null)
							message = "";

					} catch (NullPointerException e) {
						message = "";
					}

					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					Open_informationForm oForm = new Open_informationForm();
					oForm.setEmployee_no(s.getEmployee_no());
					dba.getMizuki(oForm);
					dba.getHire_date(oForm);
					String djc = "";
					String sunaga = "";
					String Employee_no = "";
					String intr = oForm.getIntr();
					String hobby = oForm.getHobby();
					String sp = oForm.getSs();
					try {
						Employee_no = s.getEmployee_no();
						djc = oForm.getDjc();
						sunaga = s.getEmployee_name();
					} catch (Exception e) {
						if (djc.equals(null)) {

						}
					}
					String name = s.getEmployee_name();
					String pos = "";
		%>
		<div align="right">
			<a href="Personal_information.jsp">ユーザー情報編集画面へ</a>
		</div>
		<div class='main1'>
			<div class='pic'>
				 <div id="dragDropArea">
        <div class="drag-drop-inside">
            <p class="drag-drop-info">ここにファイルをドロップ</p>
            <p>または</p>
            <p class="drag-drop-buttons">
                <input id="fileInput" type="file" accept="image/*" value="ファイルを選択" name="photo" onChange="photoPreview(event)">
            </p>
            <div id="previewArea"></div>
        </div>
    </div>

				<img id="preview"> <img id="preview">
				<script type="text/javascript" src="../js/personal_information.js">
				var target = document.getElementById('target');
				target.addEventListener('dragover', function (e) {
					e.preventDefault();
					e.stopPropagation();
					e.dataTransfer.dropEffect = 'copy';
				});
				target.addEventListener('drop', function (e) {
					e.stopPropagation();
					e.preventDefault();
					const reader = new FileReader();
					reader.onload = function (e) {
						document.getElementById('preview').src = e.target.result;
					}
					reader.readAsDataURL(e.dataTransfer.files[0]);
				});</script>
				<!--imgsrc="\\db366ybx\Proc-Server\Pro-Top\新人研修\2020年度\03.講義\04_成果\08_Webシステム\システム製作\img\test.jpg"
				height="190" width="190"-->
			</div>
			<div class='pro'>
				<div class='pro2'>
					<p style="margin-top: 5px;">
						名前：<%=sunaga%>
					</p>
				</div>
				<div class='pro2'>
					<p class='pos' style="margin-left: 5px">役職:</p>
					<html:text property="pos" />
				</div>
				<p style="margin-top: 5px;">
					入社年月日：<%=djc%>
				</p>
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
				<html:text property="hobby" value="<%=hobby%>"></html:text>
			</div>
			<div class='pro3'>
				<div class='ss'>特技:</div>
				<html:text property="ss" size="20" value="<%=sp%>" />
			</div>
		</div>

		<div class='bottom'>
			<div class='int'>紹介文</div>
			<html:textarea property="intr" rows="10" cols="100" value="<%=intr%>"></html:textarea>
			<!-- styleClass='int2'name='int2' cols='90' rows='10' -->
		</div>
		<!-- 登録/編集ボタン  -->
		<p id="Bentry">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="entry" />
		</p>

		<p id="Bedit">
			<input type="button" value="編集" id="edit" onclick="clickBtnEdit()"
				class="btn" style="display: none" />
		</p>
		<!-- 戻るボタン -->
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />

	</html:form>
</body>
</html:html>

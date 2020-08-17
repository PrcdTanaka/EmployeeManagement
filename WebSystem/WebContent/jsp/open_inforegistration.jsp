<%@page import="sample.pr.main.Personal_informationForm"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.Open_informationForm"%>
<%@ page import="java.util.function.*"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.ap.DbAction"%>

<html:html>


<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/open.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">


</head>
<body>
	<html:form action="/Open_informationAction">
		<%
			String message;
					try {
						Open_informationForm oForm = (Open_informationForm) session.getAttribute("oForm");
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
					String name = "";
					String Employee_no = "";
					String intr = oForm.getIntr();
					String hobby = oForm.getHobby();
					String sp = oForm.getSs();
					String tec = oForm.getTec();
					String pos = oForm.getPos();
					try {
						Employee_no = s.getEmployee_no();
						djc = oForm.getDjc();
						name = s.getEmployee_name();
					} catch (Exception e) {
						if (djc.equals(null)) {

						}
					}
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
							<input id="fileInput" type="file" accept="image/*"
								value="ファイルを選択" name="photo" onChange="photoPreview(event)">
						</p>
						<div id="previewArea"></div>
					</div>
				</div>

				<img id="preview">
				<script type="text/javascript" src="../jsp/open_information.jsp">
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
				<!-- src="\\db366ybx\Proc-Server\Pro-Top\新人研修\2020年度\03.講義\04_成果\08_Webシステム\システム製作\img\test.jpg"
				height="190" width="190" -->
			</div>
			<div class='pro'>
				<div class='pro2'>
					<p style="margin-top: 5px; margin-bottom: 20px">
						名前：<%=name%>
					</p>
					<p style="margin-top: 5px; margin-left: 50px; margin-bottom: 20px">
						役職：
						<html:select property="pos" name="Open_informationForm"
							styleId="pos" value="<%=pos %>">
							<html:option value="">-</html:option>
							<html:option value="0">役職なし</html:option>
							<html:option value="1">主任</html:option>
							<html:option value="2">係長</html:option>
							<html:option value="3">課長</html:option>
							<html:option value="4">次長</html:option>
							<html:option value="5">部長</html:option>
						</html:select>
					</p>
				</div>
				<div class='pro2'>
					入社年月日：<%=djc%>
				</div>
				<div class='pro2'>
					<p class='tec'>技術部:</p>
					<html:select property="tec" name="Open_informationForm"
						styleId="tec" value="<%=tec%>">
						<html:option value="">-</html:option>
						<html:option value="00">総務・経理部</html:option>
						<html:option value="01">第1技術部</html:option>
						<html:option value="02">第2技術部</html:option>
						<html:option value="03">第3技術部</html:option>
						<html:option value="04">第4技術部</html:option>
						<html:option value="05">第5技術部</html:option>
						<html:option value="06">ソリューション技術部</html:option>
						<html:option value="07">システム営業部</html:option>
						<html:option value="08">人事部</html:option>
						<html:option value="09">採用マーケティング部</html:option>
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
		<!-- 登録ボタン  -->
		<p id="Bentry">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="open" />
		</p>
		<!-- 戻るボタン -->
		<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />

	</html:form>
</body>
</html:html>

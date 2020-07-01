<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.MainForm" %>

<html:html>

<link rel="stylesheet" type="text/css" href="../main.css">
<link rel="stylesheet" type="text/css" href="../reference.css">
	<body>
		<!--%
		SearchForm sForm = (SearchForm) session.getAttribute("searchForm");
		String name = sForm.getEmployee_name();			// 名前
		String post = sForm.getPost();					// 役職
		String hire_date = sForm.getHire_date();		// 入社日
		String dep = sForm.getDepertment();				// 所属部
		String hobbies = sForm.getHobbies();			// 趣味
		String specialty = sForm.getSpecialty();		// 特技
		String introduction = sForm.getIntroduction();	// 紹介文
		
		%-->
		<div class="SS">
			<p>名前　　　：<!-- %= name % --><!-- bean:write name="SearchForm" -->　　　役職：<!-- %= post % --></p>
			<p>入社年月日：<!-- %= hire_date % --><p>
			<p>技術部　　：<!-- %= dep % --></p>
		</div>

		<div class="IMG">
			<html:img src="${pageContext.request.contextPath}/img/genba_noko.png"  height="170px" alt="現場猫" />
		</div>

		<div class="free">
			<p>趣味：<!-- %= hobbies % --></p>
			<p>特技：<!-- %= specialty % --></p>
		<div class="syokai">
			<p style="position:relative;right:80px;">紹介文</p>
			<p style="font-size:20px;position:relative;right:50px;">てやんでぇ<!-- %= introduction % --></p>
			<html:textarea name="SearchForm" property="introduction" />
		</div>
		<div>
				<!-- 戻るボタン -->
				<span><html:submit property="button" styleClass="btn" value="戻る" styleId="back" /></span>
		</div>
	</body>
</html:html>


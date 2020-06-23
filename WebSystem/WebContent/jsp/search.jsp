<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.SearchForm;" %>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="stylesheet" type="text/css" href="botton_controler.css">
<!DOCTYPE html>
<style>
body{

}
td{
	text-align: middle;
	padding:2px 20px;
}

h2{
	position: relative;
	right: 170px;
}


.center {
	text-align:center;
}

.search {
	position:relative;

	display: inline-block;
}
.sarch btn-open{
	display: none;
}
</style>




<html:html>
	<head>
	<center><h1>ユーザ検索</h1></center>
	</head>
	<body>
	<html:form action="/SearchAction">
		<span class="center">
				<center><html:text property="text" maxlength="12" />
				<html:submit property="button" value="検索" /><></center>
				<p>
				<html:radio property="radio" value="EMPROYEE_NUMBER" />社員No
				<html:radio property="radio" value="EMPROYEE_NAME" />氏名
				<html:radio property="radio" value="DEPARTMANT"/>技術部
					<h2>検索結果</h2>
					<table border="1" align = "center" style="border-collapse: collapse" >

					</table>
		</span>
	</html:form>

		<div>
			<input type="button" class="btn" value="�߂�"onclick ="history.back()"></input>
		</div>
	</body>
</html:html>
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
				<html:submit property="button" value="検索" /></center>
				<p>
				<html:radio property="radio" value="number" />社員No
				<html:radio property="radio" value="name" />氏名
				<html:radio property="radio" value="department"/>技術部
					<h2>検索結果</h2>
					<table border="1" align = "center" style="border-collapse: collapse" >
						<tr bgcolor="#b0c4de">
							<td>�Ј��ԍ�</td>
							<td text-align:center>���O</td>
							<td text-align:center>�Z�p��</td>
						</tr>
						<tr>
							 <td align="right">0666</td>
							 <td><a href="�Q�Ə����.html">�㓡���C</a></td>
							 <td>��2�Z�p��</td>
						</tr>
						<tr>
							<td align="right">0777</td><td><a href="�Q�Ə����.html">�㓡�E��</a></td>
							<td>��3�Z�p��</td>
						</tr>
						<tr>
							<td align="right">0888</td>
							<td><a href="�Q�Ə����.html">�㓡��</a></td>
							<td>��4�Z�p��</td>
						</tr>
					</table>
		</span>
	</html:form>

		<div>
			<input type="button" class="btn" value="�߂�"onclick ="history.back()"></input>
		</div>
	</body>
</html:html>
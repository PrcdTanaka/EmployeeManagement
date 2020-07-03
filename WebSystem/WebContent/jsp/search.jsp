<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.util.Iterator"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.util.List"%>
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
				<html:radio property="radio" value="EMPLOYEE_MST.EMPLOYEE_NO" />社員No
				<html:radio property="radio" value="NAME" />氏名
				<html:radio property="radio" value="DEPARTMENT"/>技術部
				<h2>検索結果</h2>
				<table id ="listtable" border="1" align = "center" style="border-collapse: collapse" >
					<%
					try
					{
						SearchForm s=(SearchForm)session.getAttribute("sform");
						List<String> name=s.getEmployee_name();
						String no="";
						String de="";
						for(Iterator it =name.iterator(); it.hasNext();)
						{
							System.out.println(it.next());
						}
					}
					catch(NullPointerException e)
					{

					}

					%>
				</table>
		</span>
			<!--  -script type="text/javascript">
					// 管理者フラグが無いなら（0）
					// 「ユーザ情報登録画面」を非表示
				 	if(<!%= a %>==false){
				 		document.getElementById("listtable").textContent = "";
					}else{

					}
				</script-->

		<div>
			<html:submit property="button" value="戻る" /></input>
		</div>
		</html:form>
	</body>
</html:html>
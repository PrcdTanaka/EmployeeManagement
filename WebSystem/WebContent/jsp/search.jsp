<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.util.Iterator"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.SearchForm" %>
<%@ page import="sample.pr.main.LoginForm" %>
<html lang="ja">

<!DOCTYPE html>
<style>

body{

	text-align: center;
	}
a{
text-decoration:none;
color:black;
	}
h1{
	margin-top: 8%;
    font-size: 390%;
}

table{
	 border: 1px solid;
   	align-items: center;
    line-height: 2;
	 border-collapse:collapse;
	 width:40%;

}


td{

}


h2{

}
.back{
margin-top: 4%;
position:relative;
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
	<link rel="stylesheet"  type="text/css" href="../css/search.css">
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


					<%
					try
					{

						SearchForm s=(SearchForm)session.getAttribute("form");
						List<String> name=s.getEmployee_name();
						List<String> no=s.getEmployee_no();
						List<String> depart=s.getDepertment();

						out.println("<table border=\"1\" align = \"center\" style=\"border-collapse: collapse\"  >");
						for(int i=-1;i<no.size();i++)
						{
							if(i<0)
							{
								out.println("<tr bgcolor=\"#b0c4de\">");
								out.println(" <td>名前</td><td text-align:center>社員番号</td><td text-align:center>技術部</td></tr>");
							}
							else
							{
								out.println("<tr><td>");      //名前にリンクがついてます。
								out.println("<a href=\"#\">");
						        out.println(name.get(i));
						        out.println("</td>");
						        out.println("</a>");

						        out.println("<td>");
						        out.println(no.get(i));
						        out.println("</td>");

						        out.println("<td>");
						        out.println(depart.get(i));
						        out.println("</td></tr>");
							}


						}
						out.println("</table>");
					}
					catch(NullPointerException e)
					{

					}
					catch(Exception e)
					{

					}

					%>
		</span>

		<div class="back">
		<html:submit property="button" value="戻る"></html:submit>

		</div>

		</html:form>
	</body>
</html:html>
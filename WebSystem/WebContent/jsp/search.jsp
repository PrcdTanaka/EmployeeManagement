<%@page import="javax.swing.text.Document"%>
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
	background-color:e9e9e9;
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
.send{
	background-color: #49a9d4;
	border-radius:8px;
	font-weight: bold;
	padding:8px;
	color:#fff;
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
				<input type="radio"value="" checked="checked" style="display:none;" />
				<html:radio property="radio" value="EMPLOYEE_MST.EMPLOYEE_NO"  />社員No
				<html:radio property="radio" value="NAME" />氏名
				<html:radio property="radio" value="DEPARTMENT"/>技術部
				<h2>検索結果</h2>

					<%
					try
					{

						SearchForm s=(SearchForm)session.getAttribute("sForm");
						List<String> name=s.getEmployee_name();
						List<String> no=s.getEmployee_no();
						List<String> depart=s.getDepertment();
						LoginForm l=(LoginForm)session.getAttribute("form");
						String manager=l.getManager();
						out.println("<script>function js_alert() {alert(\"未登録のため参照できません!!FUCKYOU!!!\");}</script>");
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

								if(name.get(i)==null&&manager.equals("1"))
								{
									out.println("<a href=\"/WebSystem/jsp/Personal_information.jsp?employee_no=");
									out.println(no.get(i));
									out.println("\" style=\"color:red\" >");
									name.set(i, "未登録");
								}
								else if(name.get(i)==null){
									out.println("<a href=\"#\" style=\"color:red\"onclick=\"js_alert()\">");
									name.set(i, "未登録");
								}
								else if(manager.equals("0")){
									out.println("<a href=\"/WebSystem/jsp/reference.jsp?employee_no=");
									out.println(no.get(i));
									out.println("\" >");
								}
								else if(manager.equals("1")){
									out.println("<a href=\"/WebSystem/jsp/Personal_information.jsp?employee_no=");
									out.println(no.get(i));
									out.println("\" >");
								}

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
		<html:submit styleClass="send" property="button" value="戻る"></html:submit>

		</div>

		</html:form>
	</body>
</html:html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.MainForm" %>


<html:html>
	<head>
		<%
		LoginForm s = (LoginForm) session.getAttribute("form");
		String no = s.getEmployee_no();
		String name = s.getEmployee_name();
		String manager = s.getManager();
		
		if(name == null){
			name = "";
		}
		%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><bean:message key="main.title"/></title>
		<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/main.css"/> 
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<tr>
			<html:form action="/MainAction" styleId="mform">
				<p style="margin-top:5px;">ログインユーザ：<%= name %>
					<td align="left">
						<html:submit property="button" styleClass="btn"
							 style="margin-left:3px;" value="ログアウト" styleId="logout" />
					</td>
				</p>
			</html:form>
		</tr>
	</head>
		<body>
			<form id="frm1" name="frm1a" action="/jsp/Main.jsp">
			
			</form>
			<br>
			
			<html:form action="/MainAction">
			<div class="accbox">
			<!--ラベル1-->
			<label for="label1">社員管理</label>
			<input type="checkbox" id="label1" class="cssacc" />
			<div class="accshow">
				<!--ここに隠す中身-->
				<p class="link">
					<li>
						<html:link action="/MainAction">ユーザ情報編集画面
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">edit</html:param>
						</html:link>
					</li>
					
					<span id="entry">
						<li>
							<html:link action="/MainAction">ユーザ情報登録画面
								<html:param name="employee_no"><%= no %></html:param>
								<html:param name="link">register</html:param>
							</html:link>
						</li>
					</span>
					<li>
						<html:link action="/MainAction">ユーザ検索画面
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">search</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">パスワード変更画面
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">password</html:param>
						</html:link>
					</li>
				</p>
				
				<!-- bean:define id="manager" name="LoginForm" property="manager" type="String" /-->
				<script type="text/javascript">
					// 管理者フラグが無いなら（0）
					// 「ユーザ情報登録画面」を非表示
				 	if(<%= manager %>=="0"){
				 		document.getElementById("entry").textContent = "";
					}else{

					}
				</script>
				</div>
			</div>
			<!--//ラベル1-->
			</html:form>
			
		</body>
</html:html>

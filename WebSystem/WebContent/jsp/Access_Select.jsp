<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.MainForm" %>


<html:html>
		<body>

		<%
		LoginForm s = (LoginForm) session.getAttribute("form");
		
		String no = s.getEmployee_no();
		%>

			<form id="frm1" name="frm1a" action="/jsp/Main.jsp">

			</form>
			<br>

		<html:form action="/Access_ControlAction">
			<div class="accbox">
			<!--ラベル1-->
			<label for="label1">入退室履歴　月選択</label>
			<div class="accshow">
				<!--ここに隠す中身-->
				<p class="link">
					<li>
						<html:link action="/Access_ControlAction">1月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_1month</html:param>
						</html:link>
					</li>

						<li>
						<html:link action="/Access_ControlAction">2月
						<html:param name="employee_no"><%= no %></html:param>
						<html:param name="link">Access_Select_2month</html:param>
 						</html:link>
						</li>

					<li>
						<html:link action="/Access_ControlAction">3月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_3month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">4月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_4month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">5月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_5month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">6月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_6month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">7月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_7month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">8月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_8month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">9月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_9month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">10月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_10month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">11月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_11month</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/Access_ControlAction">12月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Select_12month</html:param>
						</html:link>
					</li>
				</p>

							<!--//ラベル1-->
			</html:form>

		</body>
</html:html>

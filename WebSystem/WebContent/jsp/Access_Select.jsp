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

		<html:form action="/Access_SelectAction">
			<div class="accbox">
			<!--ラベル1-->
			<label for="label1">入退室履歴　月選択</label>
			<input type="checkbox" id="label1" class="cssacc" />
			<div class="accshow">
				<!--ここに隠す中身-->
				<p class="link">
					<li>
						<html:link action="/MainAction">1月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>

						<li>
							<html:link action="/MainAction">2月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
						</li>

					<li>
						<html:link action="/MainAction">3月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">4月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">5月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">6月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">7月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">8月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">9月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">10月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">11月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
					<li>
						<html:link action="/MainAction">12月
							<html:param name="employee_no"><%= no %></html:param>
							<html:param name="link">Access_Control</html:param>
						</html:link>
					</li>
				</p>

							<!--//ラベル1-->
			</html:form>

		</body>
</html:html>

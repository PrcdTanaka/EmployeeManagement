<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html:html>
	<body>
		<%// ログイン画面へ遷移 %>
		<logic:redirect page="/jsp/login.jsp" />
	</body>
</html:html>

<%@page import="javax.swing.text.Document"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.util.Iterator"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page import="sample.pr.main.EnterForm" %>
<style>
.link-style-btn{
  cursor: pointer;
  border: none;
  background: none;
  color: #0033cc;
}
.link-style-btn:hover{
  text-decoration: underline;
  color: #002080;
}
</style>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>

	<body>
	 	<%
 			LoginForm s = (LoginForm) session.getAttribute("form");
 			String no=s.getEmployee_no();
 			String link=s.getLink();
 			String name =s.getEmployee_name();
 			EnterForm eForm=new EnterForm();
 			String checklist=eForm.getChecklist();

 	%>
 		<html:form action="/Eneter_leavingAction">
			<h1>入退室確認画面</h1>

		<h2>1.電気</h2>
		・<html:multibox property="checklist" value="0" />エアコン
		・<html:multibox property="checklist" value="1" />照明
		<% if(link=="2"){ %>
		・<html:multibox property="checklist" value="2" />ポット
		<% }%>
		<h2>2.戸締り</h2>
		 <html:multibox property="checklist" value="3"/>窓
		 <html:multibox property="checklist" value="4"/>オートロックの施錠確認
		<h2>3.避難経路の物品放置の有無</h2>
		 <html:multibox property="checklist" value="5"/>避難口
		 <html:multibox property="checklist" value="6"/>廊下
		 <html:multibox property="checklist" value="7"/>避難経路
		 <html:multibox property="checklist" value="8"/>防火扉
		4.<html:multibox property="checklist" value="9"/>配線確認
		5.<html:multibox property="checklist" value="10"/>煙草の吸い殻確認
		6.<html:multibox property="checklist" value="11"/>トイレに可燃物のゴミがないか確認

		<html:submit styleClass="send" property="button" value="退出"/>

 		</html:form>
	</body>
</html:html>

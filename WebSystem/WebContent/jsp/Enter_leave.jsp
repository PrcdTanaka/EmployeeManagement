<%@page import="oracle.net.aso.e"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="sample.pr.main.Personal_informationForm"%>
<%@page import="sample.ap.DbAction"%>
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
body
{
	margin-left:30%;

}
</style>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html:base/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>
	<h1>入退室確認画面</h1>
	<body>



 		<html:form action="/EnterAction">

	 	<%
	 		Boolean Midnight=false;
	 		Boolean Entry=false;
 			EnterForm eForm=new EnterForm();
 			LoginForm s = (LoginForm) session.getAttribute("form");
 			String no   = s.getEmployee_no();
 			String name = s.getEmployee_name();
 			String link =s.getLink();
 			eForm.setFloor(link);
			DbAction dba=new DbAction();

			//入室処理 ROOM_ACCESS_TBLにEMPLOYEE_NAMEが存在するか判定
			if(dba.getEntry_Empl(eForm))
			{
				Entry=true;
			}
			//深夜作業判定 ROOM_ACCESS_TBLのCHECK_LISTが1かどうかの判定
			if(dba.getAccessControl(eForm)){
				List<String> Check_list = eForm.getCHECK_LIST();
				//0番目が1だったら
				if(Check_list.get(0).equals("1")){
					Midnight=true;
				}
			}
 			session.setAttribute("eform", eForm);

 		%>
 		<%

 		//深夜作業 Midnightがtrueの場合表示
 		if(Midnight==true) {%>
		<html:submit styleClass="send" property="button" value="深夜作業"/>
		<% }

 		//退室 ROOM_ACCESS_TBLに既に値が入っている場合表示
 		else if(Entry==true){%>
		<br>
		<h2>1.電気</h2>
		<p>　　・エアコン<html:multibox property="checklist" value="1" /></p>
		<p>　　・照明<html:multibox property="checklist" value="1" /></p>
		 <%

		 //2階のみここに遷移
		 if(link=="2F"){ %>
			<p>　　・ポット<html:multibox property="checklist" value="1" /></p>
		<% }%>
		<h2>2.戸締り</h2>
		 <p>　　・窓<html:multibox property="checklist" value="1"/></p>
		 <p>　　・オートロックの施錠確認<html:multibox property="checklist" value="1"/></p>
		<h2>3.避難経路の物品放置の有無</h2>
		 <p>　　・避難口<html:multibox property="checklist" value="1"/></p>
		 <p>　　・廊下	 <html:multibox property="checklist" value="1"/></p>
		 <p>　　・避難経路<html:multibox property="checklist" value="1"/></p>
		 <p>　　・防火扉<html:multibox property="checklist" value="1"/></p>
		 <br>
		<h2>4.配線確認<html:multibox property="checklist" value="1"/></h2>
		<br>
		<h2>5.煙草の吸い殻確認<html:multibox property="checklist" value="1"/></h2>
		<br>
		<h2>6.トイレに可燃物のゴミがないか確認<html:multibox property="checklist" value="1"/></h2>
		<br>
		<html:submit styleClass="send" property="button" value="退室"/>
		<%}

 		//入室 ROOM_ACCESS_TBLに値が入っていない場合表示
 		else{%>
			<html:submit styleClass="send" property="button" value="入室"/>
		<% }%>

 		</html:form>
	</body>
</html:html>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet"type="text/css"href="sample.css"/>
		<html lang="ja">
		<link rel="stylesheet" type="text/css" href="main.css">
    </head>

  	<table>
  		<center><h1>パスワード変更画面</h1></center>
  	</table>

 	<body>
  		<html:form action="/PasswordAction" >
			<div class="block">

				<div class="space"></div>


				<div>
				   <center>古いパスワード</center>
				  			<html:password property="password" value= ""/>
				</div>

				<div>
				    <center>新しいパスワード</center>
				  			<html:password property="password" value= ""/>
				</div>

				<div>
				    <center>新しいパスワード</center>
				  			<html:password property="password" value= ""/>
				</div>
				<div class="space"></div>
				<br>
				<!-- 変更ボタン -->>
				<Center>
					<input type="button" class="btn" value="変更" onclick =""style="font-size:25px;">
					</input>
				</Center>

    			<!-- 戻るボタン -->>
    			<Center>
    				<input type="button" class="btn" value="戻る" onclick = "location.href='main.jsp'" style="font-size:25px;">
    				</input>
    			</Center>

 			 </div>
   		 </html:form>
	 </body>
</html:html>

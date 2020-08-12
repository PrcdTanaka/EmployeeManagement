<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="sample.pr.main.LoginForm" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<html lang="ja">
<!DOCTYPE html>
<style>
.START{
		font-size:40px;
}

.FINISH{
		font-size:40px;
}
.REST{
	  font-size:20px;
}
.btn{
		font-size:20px;
}

</style>

<html lang="ja">
	<body>
		<div>
		 <center><h1>出退勤画面</h1></center>
		</div>
		<div style="top:15%; position:relative; align-center">
			<input type="button" class="btn" value="出勤"></input>
		</div>

		<div style="position:relative; margin-top:5%;">
			<input type="button" class="btn" value="退勤"></input>
		</div>
		<div style=" position:relative; margin-top:5%;text-align:center">
			<p class="REST">休憩時間</p>
				<select class="REST" name="休憩時間">
					<option value="">選択してください</option>
					<option value="">00:00</option>
					<option value="">00:15</option>
					<option value="">00:30</option>
					<option value="">00:45</option>
					<option value="">01:00</option>
					<option value="">01:15</option>
					<option value="">01:30</option>
					<option value="">01:45</option>
					<option value="">02:00</option>
				</select>
		</div>

		<div style="position:relative; margin-top:2%; align:center;">
			<input class="btn" type="button"  value="登録" styleId="attendance"></input>
			<input  class="btn" type="button"  value="戻る" styleId="main"></input>
		</div>

	</body>
</html>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<html:html>
<head>
</head>
<body>
	<html:form action="/ReservationAction">
		<html lang="ja">
<link rel="stylesheet" type="text/css" href="main.css">
<table>

	<center>
		<h1>会議室予約画面</h1>
	</center>

	<div align="right">
		<a href="open_inforegistration.html">会議室新規登録画面へ</a>
	</div>

	<table border="1">
		<tr>
			<th></th>
			<th>キャパ</th>
			<th>モニター</th>
			<th>カメラ</th>
		</tr>
		<tr>
			<td>2F</td>
			<td>〇〇人</td>
			<td>〇</td>
			<td>×</td>
		</tr>
		<tr>
			<td>3F</td>
			<td>〇〇人</td>
			<td>×</td>
			<td>〇</td>
		</tr>
		<tr>
			<td>4F</td>
			<td>〇〇人</td>
			<td>×</td>
			<td>〇</td>
		</tr>
	</table>
	<br>
	<table border="2" cellpadding="0" cellspacing="0">
		<tr>
			<th></th>
			<td>2F</td>
			<td>3F</td>
			<td>4F</td>
			<td width="360" height="40" colspan="5"></td>
		</tr>
		<tr>
			<td width="120" height="40" rowspan="2">前の週へ</td>
			<td width="360" height="40" colspan="7" style="text-align: center;">2020年09月</td>
			<td width="120" height="40" rowspan="2">次の週へ</td>
		</tr>
		<tr>
			<td width="120" height="40">1日(月)</td>
			<td width="120" height="40">2日(火)</td>
			<td width="120" height="40">3日(水)</td>
			<td width="120" height="40">4日(木)</td>
			<td width="120" height="40">5日(金)</td>
			<td width="120" height="40">6日(土)</td>
			<td width="120" height="40">7日(日)</td>
		</tr>
		<tr>
			<td width="120" height="80">8:00</td>
			<td width="120" height="80">小牧</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">須永</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">後藤</td>
			<td width="120" height="80">8:00</td>
		</tr>
		<tr>
			<td width="120" height="80">8:30</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">8:30</td>
		</tr>
		<tr>
			<td width="120" height="80">9:00</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">〇</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">9:00</td>
		</tr>
		<tr>
			<td width="120" height="80">9:30</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">9:30</td>
		</tr>
		<tr>
			<td width="120" height="80">10:00</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">10:00</td>
		</tr>
		<tr>
			<td width="120" height="80">10:30</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">10:30</td>
		</tr>
		<tr>
			<td width="120" height="80">11:00</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">11:00</td>
		</tr>
		<tr>
			<td width="120" height="80">11:30</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">11:30</td>
		</tr>
		<tr>
			<td width="120" height="80">12:00</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">12:00</td>
		</tr>
		<tr>
			<td width="120" height="80">12:30</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">12:30</td>
		</tr>
		<tr>
			<td width="120" height="80">13:00</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">13:00</td>
		</tr>
		<tr>
			<td width="120" height="80">13:30</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">13:30</td>
		</tr>
		<tr>
			<td width="120" height="80">14:00</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">14:00</td>
		</tr>
		<tr>
			<td width="120" height="80">14:30</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">14:30</td>
		</tr>
		<tr>
			<td width="120" height="80">15:00</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">15:00</td>
		</tr>
		<tr>
			<td width="120" height="80">15:30</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">15:30</td>
		</tr>
		<tr>
			<td width="120" height="80">16:00</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">16:00</td>
		</tr>
		<tr>
			<td width="120" height="80">16:30</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">16:30</td>
		</tr>
		<tr>
			<td width="120" height="80">17:00</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">17:00</td>
		</tr>
		<tr>
			<td width="120" height="80">17:30</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">17:30</td>
		</tr>
		<tr>
			<td width="120" height="80">18:00</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">18:00</td>
		</tr>
		<tr>
			<td width="120" height="80">18:30</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">18:30</td>
		</tr>
		<tr>
			<td width="120" height="80">19:00</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">19:00</td>
		</tr>
		<tr>
			<td width="120" height="80">19:30</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">19:30/td>
		</tr>
		<tr>
			<td width="120" height="80">20:00</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">20:00</td>
		</tr>
		<tr>
			<td width="120" height="80">20:30</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">20:30</td>
		</tr>
		<tr>
			<td width="120" height="80">21:00</td>
			<td width="120" height="80">3-3</td>
			<td width="120" height="80">3-4</td>
			<td width="120" height="80">3-5</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">21:00</td>
		</tr>
		<tr>
			<td width="120" height="80">21:30</td>
			<td width="120" height="80">4-2</td>
			<td width="120" height="80">4-3</td>
			<td width="120" height="80">4-4</td>
			<td width="120" height="80">2-3</td>
			<td width="120" height="80">2-4</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">2-5</td>
			<td width="120" height="80">21:30</td>
		</tr>
	</table>

</table>



</table>
<body>
	<p>
		<input type="button" class="btn" value="戻る"
			onclick="location.href='main.html'"></input> </input>
	</p>
</body>
	</html:form>
</body>
</html:html>
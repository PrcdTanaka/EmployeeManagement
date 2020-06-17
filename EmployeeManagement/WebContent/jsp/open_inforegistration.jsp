<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="main.css">
<style>
.SS{
	position:relative;
	text-align:left;
	left: 55%;
	margin-top : 3%;
	font-size:20px;
	line-height: 240%;
	width:45%;
}
.IMG{
	position:absolute;
	top : 5%;
	left:30%;
}
.free{
	position:relative;
	left:38%;
	width:62%;
	font-size:20px;
	line-height:200%;
	margin-top:5%;
}
.syokai{
	line-height:100%
}

body{
	width:100%;
	margin:0;

}
</style>

<html lang="ja">
<body>
<div class="seni">
	<a style="position:absolute;top : 0%;left:80%; font-size:20px; "href='personal_information.html'">個人情報編集画面へ</a>
<div class="SS">
	<p>名前　　　：自動入力　　　役職：<input type="text" name="ouie" style="font-size:100%;"size="10" maxlength="3"></p>
	<p>入社年月日：自動入力<p>
	<p>技術部　　：<input type="text" name="aiueo" style="font-size:100%;"size="10" maxlength="5"></p>
</div>

<div class="IMG">
	<img src="a.png"  height="170px">
</div>

<div class="free">
	<p>趣味：<input type="text" name="aiueo" style="font-size:20px;"size="30" maxlength="15"></p>
	<p>特技：<input type="text" name="name" style="font-size:20px;"size="30" maxlength="15"></p>
<div class="syokai">
	<p style="position:relative;right:80px;">紹介文</p>
	<textarea rows="4" cols="50" style="font-size:20px;position:relative;right:8%;" maxlength="100">自己紹介や趣味、特技の詳細などを書こう！</textarea>
</div>
</div>
<div>
	  <p><input type="button" class="btn" value="登録" onclick =""style="font-size:25px;"></input></p>
      <p><input type="button" class="btn" value="戻る" onclick = "location.href='メイン画面.html'" style="font-size:25px;"></input></p>
</div>

</body>
</html>


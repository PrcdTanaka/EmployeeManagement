<html lang="ja">
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="stylesheet" type="text/css" href="botton_controler.css">
<!DOCTYPE html>
<style>
body{

}
td{
	text-align: middle;
	padding:2px 20px;
}

h2{
	position: relative;
	right: 170px;
}


.center {
	text-align:center;
}

.search {
	position:relative;
	
	display: inline-block;
}
.sarch btn-open{
	display: none;
}
</style>




<html lang="ja">
	<body>
		<h1>���[�U�[����</h1>
		<span class="center">
			<div class="botton_control">
				<input type="text" name="search" class="search"style="font-size:20px;width:300px; height:30px;">
				<input type="radio" class="radios" id="open" name="sarch"/><label class="sarch btn-open" for="open"style="position:absolute;left:63%;top:15.1%;">����</label>
				<input type="radio" class="radios" id="close" name="sarch" checked="checked" /><label class="sarch btn-close" for="close"style="position:absolute;left:63%;top:15.1%;">����</label>
				<p>
				<input type="radio" name="q1" value="�Ј��ԍ�"> �Ј��ԍ�
				<input type="radio" name="q1" value="���O"> ���O
				<input type="radio" name="q1" value="�Z�p��"> �Z�p��
				</p>
				<div class="sarch_ans">
					<h2>��������</h2>
					<table border="1" align = "center" style="border-collapse: collapse" >
						<tr bgcolor="#b0c4de">
							<td>�Ј��ԍ�</td>
							<td text-align:center>���O</td>
							<td text-align:center>�Z�p��</td>
						</tr>
						<tr>
							 <td align="right">0666</td>
							 <td><a href="�Q�Ə����.html">�㓡���C</a></td>
							 <td>��2�Z�p��</td>
						</tr>
						<tr>
							<td align="right">0777</td><td><a href="�Q�Ə����.html">�㓡�E��</a></td>
							<td>��3�Z�p��</td>
						</tr>
						<tr>
							<td align="right">0888</td>
							<td><a href="�Q�Ə����.html">�㓡��</a></td>
							<td>��4�Z�p��</td>
						</tr>
					</table>
				</div>
				
			</div>
			
			
		</span>
		
		<div>
			<input type="button" class="btn" value="�߂�"onclick ="history.back()"></input>
		</div>
	</body>
</html>
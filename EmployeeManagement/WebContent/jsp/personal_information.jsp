<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="main.css">
<div class="form-wrapper">
	<h1>�l�����͉��</h1>
	<body>
		<div align="right">
			<a href="���J���ҏW���.html">���J���ҏW��</a>
		</div>
		<form action="���J���ҏW���.html" method="post">
			<div class="hire_date">
				<label for="hire_date">���Г��@�F</label>
				<input type="text" id="hire_date1" name="joining_year" size="3">�N</input>
				<input type="text" id="hire_date2" name="joining_month" size="1">��</input>
				<input type="text" id="hire_date3" name="joining_day" size="1">��</input>
			</div>
			<div class="name">
				<label for="name">�����@�@�F</label>
				<input type="text" id="name" class="name"/>
			</div>
			<div>
				<label for="furigana">�t���K�i�F</label>
				<input type="text" id="furigana" class="furigana"/>
			</div>
			<div class="birth">
				<label for="birth">���N�����F</label>
				<input type="text" id="birth" name="birth" size="3">�N</input>
				<input type="text" id="birth" name="birth" size="1">��</input>
				<input type="text" id="birth" name="birth" size="1">��</input>
			</div>
			<div class="sex">
				<label for="sex">���ʁF</label>
				<select name="sex" id="sex">
					<option value="">-</option>
					<option value="true">�j</option>
					<option value="false">��</option>
				</select>
			</div>
			<div class="tel">
				<label for="tel_home">�d�b�ԍ�</label>
				<div class="tel_home">
					<label for="tel_home">����@�@�F</label>
					<input id="tel_home" type="tel" />
				</div>
				<div class="tel_phone">
					<label for="tel_phone">�g�ѓd�b�F</label>
					<input id="tel_phone" type="tel" />
				</div>
			</div>
			<div class="postal_code">
				<label for="postal_code">�X�֔ԍ��F</label>
				<input type="text" id="postal_code" size="2" name="postal_code">-</input>
				<input type="text" id="postal_code" size="2" name="postal_code"></input>
			</div>
			<div class="address">
				<label for="address">�Z���@�@�F</label>
				<input type="text" id="address" class="address"/>
			</div>
			<div class="division">
				<label for="division">�Z���敪�F</label>
				<select name="division" id="division" >
					<option value="">-</option>
					<option value="1">����</option>
					<option value="2">����</option>
					<option value="3">�Ј���</option>
					<option value="4">�e��</option>
					<option value="5">���̑��i���L�Ȃǁj</option>
				</select>
			</div>
			<p>
			<div class="emergency_contact" id="emergency_contact">
				<label for="emergency_contact">�ً}�A����</label>
				<div class=="emergency_postal_code">
					<label for="emergency_postal_code">�X�֔ԍ��F</label>
					<input type="text" id="emergency_postal_code" size="4" name="emergency_postal_code">-</input>
					<input type="text" id="emergency_postal_code" size="4" name="emergency_postal_code"></input>
				</div>
				<div class="emergency_address">
					<label for="emergency_address">�Z���@�@�F</label>
					<input type="text" id="emergency_address" size="50" />
				</div>
				<p class="emergency_contact" id="emergency_contact1">
					<div>
						<label for="emergency_name1" name="emergency1">��\�F</label>
						<input type="text" class="emergency_name" id="emergency_name1" name="emergency1" />
					</div>
					<div>
						<label for="relationship1" name="emergency1">�{�l�Ƃ̊֌W�F</label>
						<input type="text" class="relationship" id="relationship1" name="emergency1" size="4" />
					</div>
					<div>
						<label for="emergency_tel1" name="emergency1">TEL�@�F</label>
						<input type="tel" class="emergency_tel" id="emergency_tel1" name="emergency1" />
					</div>
				</p>

				<p class="emergency_contact" id="emergency_contact2">
					<div>
						<label for="emergency_name2" id="a1" name="emergency2">�����F</label>
						<input type="text" class="emergency_name" id="emergency_name2" name="emergency2" />
					</div>
					<div>
						<label for="relationship2" name="emergency2">�{�l�Ƃ̊֌W�F</label>
						<input type="text" class="relationship" id="relationship2" name="emergency2" size="4" />
					</div>
					<div>
						<label for="emergency_tel2" name="emergency2">TEL�@�F</label>
						<input type="tel" class="emergency_tel" id="emergency_tel2" name="emergency2" />
					</div>
				</p>
				<p class="emergency_contact" id="emergency_contact3">
					<div>
						<label for="emergency_name3" name="emergency3">�����F</label>
						<input type="text" class="emergency_name" id="emergency_name3" name="emergency3" />
					</div>
					<div>
						<label for="relationship3" name="emergency3">�{�l�Ƃ̊֌W�F</label>
						<input type="text" class="relationship" id="relationship3" name="emergency3" size="4" />
					</div>
					<div>
						<label for="emergency_tel3" name="emergency3">TEL�@�F</label>
						<input type="tel" class="emergency_tel" id="emergency_tel3" name="emergency3" />
					</div>
				</p>
				<p class="emergency_contact" id="emergency_contact4">
					<div>
						<label for="emergency_name4" name="emergency4">�����F</label>
						<input type="text" class="emergency_name" id="emergency_name4" name="emergency4" />
					</div>
					<div>
						<label for="relationship4" name="emergency4">�{�l�Ƃ̊֌W�F</label>
						<input type="text" class="relationship" id="relationship4" name="emergency4" size="4" />
					</div>
					<div>
						<label for="emergency_tel4" name="emergency4">TEL�@�F</label>
						<input type="tel" class="emergency_tel" id="emergency_tel4" name="emergency4" />
					</div>
				</p>
				<p class="emergency_contact" id="emergency_contact5">
					<div>
						<label for="emergency_name5" name="emergency5">�����F</label>
						<input type="text" class="emergency_name" id="emergency_name5" name="emergency5" />
					</div>
					<div>
						<label for="relationship5" name="emergency5">�{�l�Ƃ̊֌W�F</label>
						<input type="text" class="relationship" id="relationship5" name="emergency5" size="4" />
					</div>
					<div>
						<label for="emergency_tel5" name="emergency5">TEL�@�F</label>
						<input type="tel" class="emergency_tel" id="emergency_tel5" name="emergency5" />
					</div>
				</p>
			</br>
			</p>
			<div class="family_structure" id="family_structure" >
				<label for="family_structure">�Ƒ��\��</label>
				<div>
					<label for="family_structure_name1" name="family_structure1">�����@�@�F</label>
					<input type="text" class="family_structure_name" id="family_structure_name1" name="family_structure1" />
				</div>
				<div>
					<label for="family_structure_furigana1" name="family_structure1">�t���K�i�F</label>
					<input type="text" class="family_structure_furigana" id="family_structure_furigana1" name="family_structure1" />
				</div>
				<div>
					<label for="family_structure_birth1" name="family_structure1">���N�����F</label>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth1" name="family_structure1" size="4">�N</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth1" name="family_structure1" size="2">��</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth1" name="family_structure1" size="2">��</input>
				</div>
				<div>
					<label for="family_structure_sex1" name="family_structure1">���ʁF</label>
					<select id="family_structure_sex1" class="family_structure_sex" name="family_structure1">
							<option value="">-</option>
						<option value="true">�j</option>
						<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship1" name="family_structure1">�����F</label>
					<input type="text" id="family_structure_relationship1" class="family_structure_relationship" name="family_structure1" size="4" />
				</div>
				<div>
					<label for="family_structure_support1" name="family_structure1">�}�{�̗L���F</label>
					<select name="family_structure_support" id="family_structure_support1" name="family_structure1" class="family_structure_support">
							<option value="">-</option>
							<option value="true">�L</option>
							<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_job1" name="family_structure1">�E�ƁF</label>
					<input type="text" id="family_structure_job1" class="family_structure_job" name="family_structure1" />
				</div>
				
				<div>
					<label for="family_structure_name2" name="family_structure2">�����@�@�F</label>
					<input type="text" class="family_structure_name" id="family_structure_name2" name="family_structure2" />
				</div>
				<div>
					<label for="family_structure_furigana2" name="family_structure2">�t���K�i�F</label>
					<input type="text" class="family_structure_furigana" id="family_structure_furigana2" name="family_structure2" />
				</div>
				<div>
					<label for="family_structure_birth2" name="family_structure2">���N�����F</label>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth2" name="family_structure2" size="4">
						<label for="family_structure_birth2" name="family_structure2">�N</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth2" name="family_structure2" size="2">
						<label for="family_structure_birth2" name="family_structure2">��</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth2" name="family_structure2" size="2">
						<label for="family_structure_birth2" name="family_structure2">��</label>
					</input>
				</div>
				<div>
					<label for="family_structure_sex2" name="family_structure2">���ʁF</label>
					<select id="family_structure_sex2" class="family_structure_sex" name="family_structure2">
						<option value="">-</option>
						<option value="true">�j</option>
						<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship2" name="family_structure2">�����F</label>
					<input type="text" id="family_structure_relationship2" name="family_structure2" class="family_structure_relationship" size="4" />
				</div>
				<div>
					<label for="family_structure_support2" name="family_structure2">�}�{�̗L���F</label>
					<select name="family_structure2" id="family_structure_support2" class="family_structure_support">
							<option value="">-</option>
							<option value="true">�L</option>
							<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_job2" name="family_structure2">�E�ƁF</label>
					<input type="text" id="family_structure_job2" name="family_structure2" class="family_structure_job" />
				</div>
				
				</br>
				</br>
				
				<div>
					<label for="family_structure_name3" name="family_structure3">�����@�@�F</label>
					<input type="text" class="family_structure_name" name="family_structure3" id="family_structure_name3" />
				</div>
				<div>
					<label for="family_structure_furigana3" name="family_structure3">�t���K�i�F</label>
					<input type="text" class="family_structure_furigana" name="family_structure3" id="family_structure_furigana3" />
				</div>
				<div>
					<label for="family_structure_birth3" name="family_structure3">���N�����F</label>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth3" name="family_structure3" size="4">
						<label for="family_structure_birth2" name="family_structure3">�N</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth3" name="family_structure3" size="2">
						<label for="family_structure_birth2" name="family_structure3">��</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth3" name="family_structure3" size="2">
						<label for="family_structure_birth2" name="family_structure3">��</label>
					</input>
				</div>
				<div>
					<label for="family_structure_sex3" name="family_structure3">���ʁF</label>
					<select id="family_structure_sex3" class="family_structure_sex" name="family_structure3">
						<option value="">-</option>
						<option value="true">�j</option>
						<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship3" name="family_structure3">�����F</label>
					<input type="text" id="family_structure_relationship3" name="family_structure3" class="family_structure_relationship" size="4" />
				</div>
				<div>
					<label for="family_structure_support3" name="family_structure3">�}�{�̗L���F</label>
					<select name="family_structure3" id="family_structure_support3" class="family_structure_support">
							<option value="">-</option>
							<option value="true">�L</option>
							<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_job3" name="family_structure3">�E�ƁF</label>
					<input type="text" id="family_structure_job3" name="family_structure3" class="family_structure_job" />
				</div>
				
				
				<div>
					<label for="family_structure_name4" name="family_structure4">�����@�@�F</label>
					<input type="text" class="family_structure_name" name="family_structure4" id="family_structure_name4" />
				</div>
				<div>
					<label for="family_structure_furigana4" name="family_structure4">�t���K�i�F</label>
					<input type="text" class="family_structure_furigana" name="family_structure4" id="family_structure_furigana4" />
				</div>
				<div>
					<label for="family_structure_birth4" name="family_structure4">���N�����F</label>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth4" name="family_structure4" size="4">
						<label for="family_structure_birth2" name="family_structure4">�N</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth4" name="family_structure4" size="2">
						<label for="family_structure_birth2" name="family_structure4">��</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth4" name="family_structure4" size="2">
						<label for="family_structure_birth2" name="family_structure4">��</label>
					</input>
				</div>
				<div>
					<label for="family_structure_sex4" name="family_structure4">���ʁF</label>
					<select id="family_structure_sex4" class="family_structure_sex" name="family_structure4">
						<option value="">-</option>
						<option value="true">�j</option>
						<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship4" name="family_structure4">�����F</label>
					<input type="text" id="family_structure_relationship4" name="family_structure4" class="family_structure_relationship" size="4" />
				</div>
				<div>
					<label for="family_structure_support4" name="family_structure4">�}�{�̗L���F</label>
					<select name="family_structure4" id="family_structure_support4" name="family_structure4" class="family_structure_support">
							<option value="a">-</option>
							<option value="true">�L</option>
							<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_job4" name="family_structure4">�E�ƁF</label>
					<input type="text" id="family_structure_job4" name="family_structure4" class="family_structure_job" />
				</div>
				
				
				<div>
					<label for="family_structure_name5" name="family_structure5">�����@�@�F</label>
					<input type="text" class="family_structure_name" name="family_structure5" id="family_structure_name5" />
				</div>
				<div>
					<label for="family_structure_furigana5" name="family_structure5">�t���K�i�F</label>
					<input type="text" class="family_structure_furigana" name="family_structure5" id="family_structure_furigana5" />
				</div>
				<div>
					<label for="family_structure_birth5" name="family_structure5">���N�����F</label>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth5" name="family_structure5" size="4">
						<label for="family_structure_birth2" name="family_structure5">�N</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth5" name="family_structure5" size="2">
						<label for="family_structure_birth2" name="family_structure5">��</label>
					</input>
					<input type="text"  class="family_structure_birth"  id="family_structure_birth5" name="family_structure5" size="2">
						<label for="family_structure_birth2" name="family_structure5">��</label>
					</input>
				</div>
				<div>
					<label for="family_structure_sex5" name="family_structure5">���ʁF</label>
					<select id="family_structure_sex5" class="family_structure_sex" name="family_structure5">
						<option value="">-</option>
						<option value="true">�j</option>
						<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship5" name="family_structure5">�����F</label>
					<input type="text" id="family_structure_relationship5" name="family_structure5" class="family_structure_relationship" size="4" />
				</div>
				<div>
					<label for="family_structure_support5" name="family_structure5">�}�{�̗L���F</label>
					<select name="family_structure5" id="family_structure_support5" name="family_structure5" class="family_structure_support">
							<option value="">-</option>
							<option value="true">�L</option>
							<option value="false">��</option>
					</select>
				</div>
				<div>
					<label for="family_structure_job5" name="family_structure5">�E�ƁF</label>
					<input type="text" id="family_structure_job5" name="family_structure5" class="family_structure_job" />
				</div>

			</div>
			<div class="modoru">
				<input type="submit" class="btn" id="button" value="�ҏW/�o�^">
			</div>
				<p>	�m�F����</p>
				<div id="document">
					<input type="checkbox" class="document" id="resident_card" name="document" value="1"><label for="resident_card">�Z���[</label>
					<input type="checkbox" class="document" id="rental_agreement" name="document" value="2"><label for="rental_agreement">���݌_��</label>
					<input type="checkbox" class="document" id="family_register" name="document" value="3"><label for="family_register">�ːГ��{</label>
					<input type="checkbox" class="document" id="tax_exemption_certificate" name="document" value="4"><label for="tax_exemption_certificate">��ېŏؖ���</label>
					<input type="checkbox" class="document" id="other" name="document" value="5"><label for="other">���̑�</label>
				</div>
				<div class="nb">���l</div>
					<textarea id="nb" name="nb" value="test"></textarea>
			
			

		</br>
		</form>
		
		<script type="text/javascript" src="./personal_information.js"></script>
		</body>
		<input type="button" class="btn" value="�߂�" onclick="location.href='���C�����.html'"></input>
</div>
</html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.Personal_informationForm"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css"
	href="../css/personal_information.css">
<link rel="stylesheet" type="text/css" href="main.css">
<html lang="ja">
</head>
<div class="form-wrapper" style="background: #e9e9e9">

	<table>
		<h1>個人情報入力画面</h1>
	</table>

	<body>
		<html:form action="/Personal_informationAction">
			<div class="block">

				<div align="right">
					<a href="open_inforegistration.jsp">公開情報編集画面へ</a>
				</div>
				<form action="open_inforegistration.jsp" method="post">
					<div class="hire_date">
						<label for="hire_date">入社日</label>
						<html:text property="hire_date" name="Personal_informationForm"
							styleId="hire_date" value="" size="8" maxlength="8" />
						(半角数字8ケタ)

					</div>
					<div class="name">
						<label for="name">氏名 ：</label>
						<html:text property="employee_name"
							name="Personal_informationForm" styleId="name" value=""></html:text>
					</div>
					<div>
						<label for="furigana">フリガナ：</label>
						<html:text property="furigana_name"
							name="Personal_informationForm" styleId="furigana" value=""></html:text>
					</div>
					<div class="birth">
						<label for="birth">生年月日：</label>
						<html:text property="birth" name="Personal_informationForm"
							styleId="birth" value="" size="8" maxlength="8" />
					</div>
					<div class="sex">
						<label for="sex">性別：</label>
						<html:select property="sex" name="Personal_informationForm"
							styleId="sex">
							<html:option value="">-</html:option>
							<html:option value="0">男</html:option>
							<html:option value="1">女</html:option>
						</html:select>
					</div>
					<div class="tel">
						<label for="tel_home">電話番号</label>
						<div class="tel_home">
							<label for="tel_home"> 自宅 ：</label>
							<html:text property="tel_home" name="Personal_informationForm"
								styleId="tel_home" />
						</div>
						<div class="tel_phone">
							<label for="tel_phone"> 携帯電話：</label>
							<html:text property="tel_phone" name="Personal_informationForm"
								styleId="tel_phone" />
						</div>
					</div>
					<div class="postal_code">
						<label for="postal_code">郵便番号：</label>
						<html:text property="postal_code" name="Personal_informationForm"
							styleId="postal_code" maxlength="7" />
					</div>
					<div class="address">
						<label for="address">住所 ：</label>
						<html:text property="address" name="Personal_informationForm"
							styleId="address" />
					</div>
					<div class="division">
						<label for="division">住所区分：</label>
						<html:select property="division" name="Personal_informationForm"
							styleId="division">
							<html:option value="">-</html:option>
							<html:option value="1">持家</html:option>
							<html:option value="2">賃貸</html:option>
							<html:option value="3">社員寮</html:option>
							<html:option value="4">親元</html:option>
							<html:option value="5">その他（共有など）</html:option>
						</html:select>
					</div>
					<p>
						<div class="emergency_contact" id="emergency_contact">
							<label for="emergency_contact">緊急連絡先</label>
							<div class=="emergency_postal_code">
								<label for="emergency_postal_code">郵便番号：</label>
								<html:text property="emergency_postal_code"
									name="emergency_postal_code" styleId="emergency_postal_code"
									size="4" maxlength="7" />
							</div>
							<div class="emergency_address">
								<label for="emergency_address">住所 ：</label>
								<html:text property="emergency_address"
									name="Personal_informationForm" styleId="emergency_address"
									size="50" />
							</div>
							<p class="emergency_contact" id="emergency_contact1">
							<div>
								<label for="emergency_name1" name="emergency1">代表：</label>
								<html:text property="emergency_name"
									name="Personal_informationForm" styleId="emergency_name1" />
							</div>
							<div>
								<label for="relationship1" name="emergency1">本人との関係：</label>
								<html:text property="relationship1"
									name="Personal_informationForm" styleId="relationship1"
									styleClass="relationship" />
							</div>
							<div>
								<label for="emergency_tel1" name="emergency1">TEL ：</label>
								<html:text property="emergency_tel1"
									name="Personal_informationForm" styleId="emergency_tel1"
									styleClass="emergency_tel" />
							</div>
						</div>
					</p>

					<span id="entry">
						<p class="emergency_contact" id="emergency_contact2">
							<div>
								<label for="emergency_name2" id="a1" name="emergency2">氏名：</label>
								<html:text property="emergency_name2"
								name="Personal_informationForm" styleId="emergency_name2" 
								styleClass="emergency_name" />
							</div>
							<div>
								<label for="relationship2" name="emergency2">本人との関係：</label>
								<html:text property="relationship2"
								name="Personal_informationForm" styleId="relationship2" 
								styleClass="relationship" />
							</div>
							<div>
								<label for="emergency_tel2" name="emergency2">TEL ：</label>
								<html:text property="emergency_tel2"
								name="Personal_informationForm" styleId="emergency_tel2" 
								styleClass="emergency_tel" />
								<input
									type="tel" class="emergency_tel" id="emergency_tel2"
									name="emergency2" />
							</div>
						</p>
					</span>

					<p class="emergency_contact" id="emergency_contact3">
						<div>
							<label for="emergency_name3" id="a1" name="emergency3">氏名：</label>
							<html:text property="emergency_name3"
								name="Personal_informationForm" styleId="emergency_name3" 
								styleClass="emergency_name"></html:text>
						</div>
						<div>
							<label for="relationship3" name="emergency3">本人との関係：</label>
							<html:text property="relationship3"
								name="Personal_informationForm" styleId="relationship3" 
								styleClass="relationship" />
						</div>
						<div>
							<label for="emergency_tel3" name="emergency3">TEL ：</label>
							<html:text property="emergency_tel3"
								name="Personal_informationForm" styleId="emergency_tel3" 
								styleClass="emergency_tel" />
							<input
								type="tel" class="emergency_tel" id="emergency_tel3"
								name="emergency3" />
						</div>
						</p>
						<p class="emergency_contact" id="emergency_contact4">
							<div>
								<label for="emergency_name4" id="a1" name="emergency4">氏名：</label>
								<html:text property="emergency_name4"
									name="Personal_informationForm" styleId="emergency_name4" 
									styleClass="emergency_name"></html:text>
							</div>
							<div>
								<label for="relationship4" name="emergency4">本人との関係：</label>
								<html:text property="relationship4"
									name="Personal_informationForm" styleId="relationship4" 
									styleClass="relationship" />
							</div>
							<div>
								<label for="emergency_tel4" name="emergency4">TEL ：</label>
								<html:text property="emergency_tel4"
									name="Personal_informationForm" styleId="emergency_tel4" 
									styleClass="emergency_tel" />
								<input
									type="tel" class="emergency_tel" id="emergency_tel4"
									name="emergency4" />
							</div>
						</p>
						<p class="emergency_contact" id="emergency_contact5">
							<div>
								<label for="emergency_name5" id="a1" name="emergency5">氏名：</label>
								<html:text property="emergency_name5"
									name="Personal_informationForm" styleId="emergency_name5" 
									styleClass="emergency_name"></html:text>
							</div>
							<div>
								<label for="relationship5" name="emergency5">本人との関係：</label>
								<html:text property="relationship5"
									name="Personal_informationForm" styleId="relationship5" 
									styleClass="relationship" />
							</div>
							<div>
								<label for="emergency_tel5" name="emergency5">TEL ：</label>
								<html:text property="emergency_tel5"
								name="Personal_informationForm" styleId="emergency_tel5" 
								styleClass="emergency_tel" />
								<input
									type="tel" class="emergency_tel" id="emergency_tel5"
									name="emergency5" />
							</div>
						</p>
						</br>
					</p>
						<div class="family_structure" id="family_structure">
							<label for="family_structure">家族構成</label>
							<div>
								<label for="family_structure_name1" name="family_structure1">氏名：</label>
								<html:text property="family_structure_name1" 
									name="Personal_informationForm" styleId="Personal_informationForm1" />
							</div>
							<div>
								<label for="family_structure_furigana1" name="family_structure1">フリガナ：</label>
								<html:text property="family_structure_furigana1" 
									name="Personal_informationForm" styleId="family_structure_furigana1" />
							</div>
							<div>
								<label for="family_structure_birth1" name="family_structure1">生年月日：</label>
								<html:text property="family_structure_birth1" 
									name="Personal_informationForm" styleId="family_structure_birth1" />
							</div>
							<div>
								<label for="family_structure_sex1" name="family_structure1">性別：</label>
								<html:select property="family_structure_sex1" name="Personal_informationForm"
									styleId="family_structure_sex1">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_relationship1"
									name="family_structure1">続柄：</label>
								<html:text property="family_structure_relationship1" 
									name="Personal_informationForm" styleId="family_structure_relationship1" />
							</div>
							<div>
								<label for="family_structure_support1" name="family_structure1">扶養の有無：</label>
								<html:select property="family_structure_support1" name="Personal_informationForm"
									styleId="family_structure_support1">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job1" name="family_structure1">職業：</label>
								<html:text property="family_structure_job1" 
									name="Personal_informationForm" styleId="family_structure_job1" />
							</div>

							<div>
								<label for="family_structure_name2" name="family_structure2">氏名：</label>
								<html:text property="family_structure_name2" 
									name="Personal_informationForm" styleId="family_structure_name2" />
							</div>
							<div>
								<label for="family_structure_furigana2" name="family_structure2">フリガナ：</label>
								<html:text property="family_structure_furigana2" 
									name="Personal_informationForm" styleId="family_structure_furigana2" />
							</div>
							<div>
								<label for="family_structure_birth2" name="family_structure2">生年月日：</label>
								<html:text property="family_structure_birth2" 
									name="Personal_informationForm" styleId="family_structure_birth2" />
							</div>
							<div>
								<label for="family_structure_sex2" name="family_structure2">性別：</label>
								<html:select property="family_structure_sex2" name="Personal_informationForm"
									styleId="family_structure_sex2">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship2" name="family_structure2">続柄：</label> 
								<html:text property="family_structure_relationship2" 
									name="Personal_informationForm" styleId="family_structure_relationship2" />
							</div>
							<div>
								<label for="family_structure_support2" name="family_structure2">扶養の有無：</label>
								<html:select property="family_structure_support2" name="Personal_informationForm"
									styleId="family_structure_support2">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job2" name="family_structure2">職業：</label>
								<html:text property="family_structure_job2" 
									name="Personal_informationForm" styleId="family_structure_job2" />
							</div>

							</br>

							<div>
								<label for="family_structure_name3" name="family_structure3">氏名：</label>
								<html:text property="family_structure_name3" 
									name="Personal_informationForm" styleId="family_structure_name3" />
							</div>
							<div>
								<label for="family_structure_furigana3" name="family_structure3">フリガナ：</label>
								<html:text property="family_structure_furigana3" 
									name="Personal_informationForm" styleId="family_structure_furigana3" />
							</div>
							<div>
								<label for="family_structure_birth3" name="family_structure3">生年月日：</label>
								<html:text property="family_structure_birth3" 
									name="Personal_informationForm" styleId="family_structure_birth3" />
							</div>
							<div>
								<label for="family_structure_sex3" name="family_structure3">性別：</label>
								<html:select property="family_structure_sex3" name="Personal_informationForm"
									styleId="family_structure_sex3">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship3" name="family_structure3">続柄：</label> 
								<html:text property="family_structure_relationship3" 
									name="Personal_informationForm" styleId="family_structure_relationship3" />
							</div>
							<div>
								<label for="family_structure_support3" name="family_structure3">扶養の有無：</label>
								<html:select property="family_structure_support3" name="Personal_informationForm"
									styleId="family_structure_support3">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job3" name="family_structure3">職業：</label>
								<html:text property="family_structure_job3" 
									name="Personal_informationForm" styleId="family_structure_job3" />
							</div>


							<div>
								<label for="family_structure_name4" name="family_structure4">氏名：</label>
								<html:text property="family_structure_name4" 
									name="Personal_informationForm" styleId="family_structure_name4" />
							</div>
							<div>
								<label for="family_structure_furigana4" name="family_structure4">フリガナ：</label>
								<html:text property="family_structure_furigana4" 
									name="Personal_informationForm" styleId="family_structure_furigana4" />
							</div>
							<div>
								<label for="family_structure_birth4" name="family_structure4">生年月日：</label>
								<html:text property="family_structure_birth4" 
									name="Personal_informationForm" styleId="family_structure_birth4" />
							</div>
							<div>
								<label for="family_structure_sex4" name="family_structure4">性別：</label>
								<html:select property="family_structure_sex4" name="Personal_informationForm"
									styleId="family_structure_sex4">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship4" name="family_structure4">続柄：</label> 
								<html:text property="family_structure_relationship4" 
									name="Personal_informationForm" styleId="family_structure_relationship4" />
							</div>
							<div>
								<label for="family_structure_support4" name="family_structure4">扶養の有無：</label>
								<html:select property="family_structure_support4" name="Personal_informationForm"
									styleId="family_structure_support4">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job4" name="family_structure4">職業：</label>
								<html:text property="family_structure_job4" 
									name="Personal_informationForm" styleId="family_structure_job4" />
							</div>


							<div>
								<label for="family_structure_name5" name="family_structure5">氏名：</label>
								<html:text property="family_structure_name5" 
									name="Personal_informationForm" styleId="family_structure_name5" />
							</div>
							<div>
								<label for="family_structure_furigana5" name="family_structure5">フリガナ：</label>
								<html:text property="family_structure_furigana5" 
									name="Personal_informationForm" styleId="family_structure_furigana5" />
							</div>
							<div>
								<label for="family_structure_birth5" name="family_structure5">生年月日：</label>
								<html:text property="family_structure_birth5" 
									name="Personal_informationForm" styleId="family_structure_birth5" />
							</div>
							<div>
								<label for="family_structure_sex5" name="family_structure5">性別：</label>
								<html:select property="family_structure_sex5" name="Personal_informationForm"
									styleId="family_structure_sex5">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship5" name="family_structure5">続柄：</label> 
								<html:text property="family_structure_relationship5" 
									name="Personal_informationForm" styleId="family_structure_relationship5" />
							</div>
							<div>
								<label for="family_structure_support5" name="family_structure5">扶養の有無：</label>
								<html:select property="family_structure_support5" name="Personal_informationForm"
									styleId="family_structure_support5">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job5" name="family_structure5">職業：</label>
								<html:text property="family_structure_job5" 
									name="Personal_informationForm" styleId="family_structure_job5" />
							</div>
						</div>
						
						<!-- 登録/編集ボタン  -->
						<div class="sample3Area" id="makeImg">
							<input type="checkbox" id="sample3check" checked=""> <label
								for="sample3check"> <span></span>
							</label>
						</div>

						<p>確認書類</p>
						<div id="document">
							<input type="checkbox" class="document" id="resident_card"
								name="document" value="1"><label for="resident_card">住民票[</label>
							<input type="checkbox" class="document" id="rental_agreement"
								name="document" value="2"><label for="rental_agreement">賃貸契約書</label>
							<input type="checkbox" class="document" id="family_register"
								name="document" value="3"><label for="family_register">戸籍謄本</label>
							<input type="checkbox" class="document"
								id="tax_exemption_certificate" name="document" value="4"><label
								for="tax_exemption_certificate">非課税証明書</label> <input
								type="checkbox" class="document" id="other" name="document"
								value="5"><label for="other">その他</label>
						</div>
						<div class="nb">備考l</div>
						<textarea id="nb" name="nb" value="test"></textarea>



						</br>
				</form>

				<script type="text/javascript" src="./personal_information.js"></script>
			</div>
		</html:form>
	</body>

	<FORM>
		<INPUT type="button" class="btn" style="margin-top: 3px;" value="戻る"
			onClick="history.back()">
	</FORM>
</div>
</html:html>
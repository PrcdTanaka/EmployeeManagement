<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.Personal_informationForm"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><bean:message key="personal.title" /></title>
<html:base />
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<html lang="ja">
</head>
<div class="form-wrapper" style="background: #e9e9e9">

	<table>
		<h1>個人情報入力画面</h1>
	</table>

	<body>

		<%
			DbAction dba = new DbAction();
				Personal_informationForm pForm = new Personal_informationForm();

				LoginForm lForm = (LoginForm) session.getAttribute("form");

				String employee_no = "";
				String hire_date = "";
				String employee_name = "";
				String furigana_name = "";
				String birth = "";
				String sex = "";
				String tel_home = "";
				String tel_phone = "";
				String postal_code = "";
				String address = "";
				String division = "";
				String Emergency_tel = "";
				String emergency_address = "";
				String emergency_name1 = "";
				String emergency_name2 = "";
				String emergency_name3 = "";
				String emergency_name4 = "";
				String emergency_name5 = "";
				String relationship1 = "";
				String relationship2 = "";
				String relationship3 = "";
				String relationship4 = "";
				String relationship5 = "";
				String emergency_tel1 = "";
				String emergency_tel2 = "";
				String emergency_tel3 = "";
				String emergency_tel4 = "";
				String emergency_tel5 = "";
				String family_structure_name1 = "";
				String family_structure_name2 = "";
				String family_structure_name3 = "";
				String family_structure_name4 = "";
				String family_structure_name5 = "";
				String family_structure_furigana1 = "";
				String family_structure_furigana2 = "";
				String family_structure_furigana3 = "";
				String family_structure_furigana4 = "";
				String family_structure_furigana5 = "";
				String family_structure_sex1 = "";
				String family_structure_sex2 = "";
				String family_structure_sex3 = "";
				String family_structure_sex4 = "";
				String family_structure_sex5 = "";
				String family_structure_birth1 = "";
				String family_structure_birth2 = "";
				String family_structure_birth3 = "";
				String family_structure_birth4 = "";
				String family_structure_birth5 = "";
				String family_structure_relationship1 = "";
				String family_structure_relationship2 = "";
				String family_structure_relationship3 = "";
				String family_structure_relationship4 = "";
				String family_structure_relationship5 = "";
				String family_structure_residence1 = "";
				String family_structure_residence2 = "";
				String family_structure_residence3 = "";
				String family_structure_residence4 = "";
				String family_structure_residence5 = "";
				String family_structure_support1 = "";
				String family_structure_support2 = "";
				String family_structure_support3 = "";
				String family_structure_support4 = "";
				String family_structure_support5 = "";
				String family_structure_job1 = "";
				String family_structure_job2 = "";
				String family_structure_job3 = "";
				String family_structure_job4 = "";
				String family_structure_job5 = "";
				String document = "";
				String nb = "";
				String confirmer_no = "";
				String button = "";
				String status = "0";
				String question = "";
				String question2 = "";
				String answer = "";
				String answer2 = "";

				// 社員番号を個人情報入力画面アクションフォームに格納
				pForm.setEmployee_no(lForm.getEmployee_no());

				// 社員名がDBに登録されているかの確認
				if (dba.getEmoloyee_Name(pForm)) {
					// 社員名が存在する場合
					// DBから個人情報を取得する。
					dba.getPersonalData(pForm);
					// DBから緊急連絡先を取得する。
					dba.getEmergencyContact(pForm);
					// DBから家族構成を取得する。
					dba.getFamily(pForm);

					// 各パラメータを設定する。
					employee_no = pForm.getEmployee_no();
					hire_date = pForm.getHire_date();
					employee_name = pForm.getEmployee_name();
					furigana_name = pForm.getFurigana_name();
					birth = pForm.getBirth();
					sex = pForm.getSex();
					tel_home = pForm.getTel_home();
					tel_phone = pForm.getTel_phone();
					postal_code = pForm.getPostal_code();
					address = pForm.getAddress();
					division = pForm.getDivision();
					Emergency_tel = pForm.getEmergency_tel();
					emergency_address = pForm.getEmergency_address();
					emergency_name1 = pForm.getEmergency_name1();
					emergency_name2 = pForm.getEmergency_name2();
					emergency_name3 = pForm.getEmergency_name3();
					emergency_name4 = pForm.getEmergency_name4();
					emergency_name5 = pForm.getEmergency_name5();
					relationship1 = pForm.getRelationship1();
					relationship2 = pForm.getRelationship2();
					relationship3 = pForm.getRelationship3();
					relationship4 = pForm.getRelationship4();
					relationship5 = pForm.getRelationship5();
					emergency_tel1 = pForm.getEmergency_tel1();
					emergency_tel2 = pForm.getEmergency_tel2();
					emergency_tel3 = pForm.getEmergency_tel3();
					emergency_tel4 = pForm.getEmergency_tel4();
					emergency_tel5 = pForm.getEmergency_tel5();
					family_structure_name1 = pForm.getFamily_structure_name1();
					family_structure_name2 = pForm.getFamily_structure_name2();
					family_structure_name3 = pForm.getFamily_structure_name3();
					family_structure_name4 = pForm.getFamily_structure_name4();
					family_structure_name5 = pForm.getFamily_structure_name5();
					family_structure_furigana1 = pForm.getFamily_structure_furigana1();
					family_structure_furigana2 = pForm.getFamily_structure_furigana2();
					family_structure_furigana3 = pForm.getFamily_structure_furigana3();
					family_structure_furigana4 = pForm.getFamily_structure_furigana4();
					family_structure_furigana5 = pForm.getFamily_structure_furigana5();
					family_structure_sex1 = pForm.getFamily_structure_sex1();
					family_structure_sex2 = pForm.getFamily_structure_sex2();
					family_structure_sex3 = pForm.getFamily_structure_sex3();
					family_structure_sex4 = pForm.getFamily_structure_sex4();
					family_structure_sex5 = pForm.getFamily_structure_sex5();
					family_structure_birth1 = pForm.getFamily_structure_birth1();
					family_structure_birth2 = pForm.getFamily_structure_birth2();
					family_structure_birth3 = pForm.getFamily_structure_birth3();
					family_structure_birth4 = pForm.getFamily_structure_birth4();
					family_structure_birth5 = pForm.getFamily_structure_birth5();
					family_structure_relationship1 = pForm.getFamily_structure_relationship1();
					family_structure_relationship2 = pForm.getFamily_structure_relationship2();
					family_structure_relationship3 = pForm.getFamily_structure_relationship3();
					family_structure_relationship4 = pForm.getFamily_structure_relationship4();
					family_structure_relationship5 = pForm.getFamily_structure_relationship5();
					family_structure_residence1 = pForm.getFamily_structure_residence1();
					family_structure_residence2 = pForm.getFamily_structure_residence2();
					family_structure_residence3 = pForm.getFamily_structure_residence3();
					family_structure_residence4 = pForm.getFamily_structure_residence4();
					family_structure_residence5 = pForm.getFamily_structure_residence5();
					family_structure_support1 = pForm.getFamily_structure_support1();
					family_structure_support2 = pForm.getFamily_structure_support2();
					family_structure_support3 = pForm.getFamily_structure_support3();
					family_structure_support4 = pForm.getFamily_structure_support4();
					family_structure_support5 = pForm.getFamily_structure_support5();
					family_structure_job1 = pForm.getFamily_structure_job1();
					family_structure_job2 = pForm.getFamily_structure_job2();
					family_structure_job3 = pForm.getFamily_structure_job3();
					family_structure_job4 = pForm.getFamily_structure_job4();
					family_structure_job5 = pForm.getFamily_structure_job5();
					button = pForm.getButton();

					status = "1";
				}
		%>
		<div class="block">

			<div align="right">
				<a href="open_inforegistration.jsp">公開情報編集画面へ</a>
			</div>
			<html:form action="/Personal_informationAction">
				<!-- form action="open_inforegistration.jsp" method="post"> -->
				<div class="hire_date">
					<label for="hire_date">入社日</label>
					<html:text property="hire_date" name="Personal_informationForm"
						styleId="hire_date" value="<%=hire_date%>" size="8" maxlength="10" />
					<p style="color:red">例) 2020年4月10日 → 2020/04/10
				</div>
				<div class="name">
					<label for="name">氏名 ：</label>
					<html:text property="employee_name" name="Personal_informationForm"
						styleId="name" value="<%=employee_name%>" size="18" maxlength="16"></html:text>
					※必須
				</div>
				<div>
					<label for="furigana">フリガナ：</label>
					<html:text property="furigana_name" name="Personal_informationForm"
						styleId="furigana" value="<%=furigana_name%>" size="18"
						maxlength="16"></html:text>
				</div>
				<div class="sex">
					<label for="sex">性別：</label>
					<html:select property="sex" name="Personal_informationForm"
						styleId="sex" value="<%=sex%>">
						<html:option value="">-</html:option>
						<html:option value="0">男</html:option>
						<html:option value="1">女</html:option>
					</html:select>
				</div>
				<div class="birth">
					<label for="birth">生年月日：</label>
					<html:text property="birth" name="Personal_informationForm"
						styleId="birth" value="<%=birth%>" size="7" maxlength="10" />
					<p style="color:red">例) 1999年12月31日 → 1999/12/31
				</div>
				<div class="tel">
					<label for="tel_home">電話番号(ハイフンなし)</label>
					<div class="tel_home">
						<label for="tel_home"> 自宅 ：</label>
						<html:text property="tel_home" name="Personal_informationForm"
							styleId="tel_home" value="<%=tel_home%>" size="15" maxlength="15" />
					</div>
					<div class="tel_phone">
						<label for="tel_phone"> 携帯電話：</label>
						<html:text property="tel_phone" name="Personal_informationForm"
							styleId="tel_phone" value="<%=tel_phone%>" size="19"
							maxlength="15" />
					</div>
				</div>
				<div class="postal_code">
					<label for="postal_code">郵便番号(ハイフンなし)：</label>
					<html:text property="postal_code" name="Personal_informationForm"
						styleId="postal_code" value="<%=postal_code%>" size="7"
						maxlength="7" />
				</div>
				<div class="address">
					<label for="address">住所 ：</label>
					<html:text property="address" name="Personal_informationForm"
						styleId="address" value="<%=address%>" size="40" maxlength="32" />
				</div>
				<div class="question">
					<label for="question">秘密の質問：</label>
					<html:select property="password" name="Personal_informationForm"
						styleId="question" value="<%=question%>">
					<html:option value="">選択してください</html:option>
					<html:option value="1">母親の旧姓</html:option>
					<html:option value="2">飼っているペットの名前</html:option>
					<html:option value="3">好きな食べ物</html:option>
					<html:option value="4">好きな国</html:option>
					<html:option value="5">初めて観た映画</html:option>
					<html:option value="6">学生時代の部活</html:option>
					<html:option value="7">子供の頃のあだ名</html:option>
					<html:option value="8">座右の銘</html:option>
					<html:option value="9">初めて行った海外</html:option>
					<html:option value="0">おふくろの味</html:option>
					</html:select>
					<html:text property="answer" name="Personal_informationForm"
						styleId="answer" value="" size="40" maxlength="50" />
				</div>
				<div>
				<label for="question2">秘密の質問：</label>
					<html:select property="password" name="Personal_informationForm"
						styleId="question2" value="<%=division%>">
					<html:option value="">選択してください</html:option>
					<html:option value="1">母親の旧姓</html:option>
					<html:option value="2">飼っているペットの名前</html:option>
					<html:option value="3">好きな食べ物</html:option>
					<html:option value="4">好きな国</html:option>
					<html:option value="5">初めて観た映画</html:option>
					<html:option value="6">学生時代の部活</html:option>
					<html:option value="7">子供の頃のあだ名</html:option>
					<html:option value="8">座右の銘</html:option>
					<html:option value="9">初めて行った海外</html:option>
					<html:option value="0">おふくろの味</html:option>
					</html:select>
					<html:text property="answer2" name="Personal_informationForm"
						styleId="answer2" value="" size="40" maxlength="50" />
				</div>
				<p>
				<div class="emergency_contact" id="emergency_contact">
					<br>
					<h2>
						<label for="emergency_contact">緊急連絡先</label>
					</h2>
					<br>
					<div>
						<label for="Emergency_tel">電話番号：</label>
						<html:text property="Emergency_tel"
							name="Personal_informationForm" styleId="Emergency_tel" size="4"
							maxlength="7" value="<%=Emergency_tel%>" />
					</div>
					<div class="emergency_address">
						<label for="emergency_address">住所 ：</label>
						<html:text property="emergency_address"
							name="Personal_informationForm" styleId="emergency_address"
							value="<%=emergency_address%>" size="40" maxlength="32" />
					</div>
					<p class="emergency_contact" id="emergency_contact1">
					<div>
						<label for="emergency_name1" name="emergency1">代表：</label>
						<html:text property="emergency_name1"
							name="Personal_informationForm" styleId="emergency_name1"
							value="<%=emergency_name1%>" size="18" maxlength="16" />
					</div>
					<div>
						<label for="relationship1" name="emergency1">本人との関係：</label>
						<html:text property="relationship1"
							name="Personal_informationForm" styleId="relationship1"
							styleClass="relationship" value="<%=relationship1%>" size="3"
							maxlength="3" />
					</div>
					<div>
						<label for="emergency_tel1" name="emergency1">TEL ：</label>
						<html:text property="emergency_tel1"
							name="Personal_informationForm" styleId="emergency_tel1"
							styleClass="emergency_tel" value="<%=emergency_tel1%>" size="19"
							maxlength="15" />
					</div>
				</div>

				<br>
				<p class="emergency_contact" id="emergency_contact2">
				<div>
					<label for="emergency_name2" id="a1" name="emergency2">氏名：</label>
					<html:text property="emergency_name2"
						name="Personal_informationForm" styleId="emergency_name2"
						styleClass="emergency_name" value="<%=emergency_name2%>" size="18"
						maxlength="16" />
				</div>
				<div>
					<label for="relationship2" name="emergency2">本人との関係：</label>
					<html:text property="relationship2" name="Personal_informationForm"
						styleId="relationship2" styleClass="relationship"
						value="<%=relationship2%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="emergency_tel2" name="emergency2">TEL ：</label>
					<html:text property="emergency_tel2"
						name="Personal_informationForm" styleId="emergency_tel2"
						styleClass="emergency_tel" value="<%=emergency_tel2%>" size="19"
						maxlength="15" />
				</div>

				<br>
				<p class="emergency_contact" id="emergency_contact3">
				<div>
					<label for="emergency_name3" id="a1" name="emergency3">氏名：</label>
					<html:text property="emergency_name3"
						name="Personal_informationForm" styleId="emergency_name3"
						styleClass="emergency_name" value="<%=emergency_name3%>" size="18"
						maxlength="16"></html:text>
				</div>
				<div>
					<label for="relationship3" name="emergency3">本人との関係：</label>
					<html:text property="relationship3" name="Personal_informationForm"
						styleId="relationship3" styleClass="relationship"
						value="<%=relationship3%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="emergency_tel3" name="emergency3">TEL ：</label>
					<html:text property="emergency_tel3"
						name="Personal_informationForm" styleId="emergency_tel3"
						styleClass="emergency_tel" value="<%=emergency_tel3%>" size="19"
						maxlength="15" />
				</div>

				<br>
				<p class="emergency_contact" id="emergency_contact4">
				<div>
					<label for="emergency_name4" id="a1" name="emergency4">氏名：</label>
					<html:text property="emergency_name4"
						name="Personal_informationForm" styleId="emergency_name4"
						styleClass="emergency_name" value="<%=emergency_name4%>" size="18"
						maxlength="16"></html:text>
				</div>
				<div>
					<label for="relationship4" name="emergency4">本人との関係：</label>
					<html:text property="relationship4" name="Personal_informationForm"
						styleId="relationship4" styleClass="relationship"
						value="<%=relationship4%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="emergency_tel4" name="emergency4">TEL ：</label>
					<html:text property="emergency_tel4"
						name="Personal_informationForm" styleId="emergency_tel4"
						styleClass="emergency_tel" value="<%=emergency_tel4%>" size="19"
						maxlength="15" />
				</div>

				<br>
				<p class="emergency_contact" id="emergency_contact5">
				<div>
					<label for="emergency_name5" id="a1" name="emergency5">氏名：</label>
					<html:text property="emergency_name5"
						name="Personal_informationForm" styleId="emergency_name5"
						styleClass="emergency_name" value="<%=emergency_name5%>" size="18"
						maxlength="16"></html:text>
				</div>
				<div>
					<label for="relationship5" name="emergency5">本人との関係：</label>
					<html:text property="relationship5" name="Personal_informationForm"
						styleId="relationship5" styleClass="relationship"
						value="<%=relationship5%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="emergency_tel5" name="emergency5">TEL ：</label>
					<html:text property="emergency_tel5"
						name="Personal_informationForm" styleId="emergency_tel5"
						styleClass="emergency_tel" value="<%=emergency_tel5%>" size="19"
						maxlength="15" />
				</div>
				<br>
				<div class="family_structure" id="family_structure">
					<h2>
						<label for="family_structure">家族構成</label>
					</h2>
					<br>
					<div>
						<label for="family_structure_name1" name="family_structure1">氏名：</label>
						<html:text property="family_structure_name1"
							name="Personal_informationForm" styleId="family_structure_name1"
							value="<%=family_structure_name1%>" size="18" maxlength="16" />
					</div>
					<div>
						<label for="family_structure_furigana1" name="family_structure1">フリガナ：</label>
						<html:text property="family_structure_furigana1"
							name="Personal_informationForm"
							styleId="family_structure_furigana1"
							value="<%=family_structure_furigana1%>" size="18" maxlength="16" />
					</div>
					<div>
						<label for="family_structure_birth1" name="family_structure1">生年月日：</label>
						<html:text property="family_structure_birth1"
							name="Personal_informationForm" styleId="family_structure_birth1"
							value="<%=family_structure_birth1%>" size="7" maxlength="8" />
					</div>
					<div>
						<label for="family_structure_sex1" name="family_structure1">性別：</label>
						<html:select property="family_structure_sex1"
							name="Personal_informationForm" styleId="family_structure_sex1"
							value="<%=family_structure_sex1%>">
							<html:option value="">-</html:option>
							<html:option value="0">男</html:option>
							<html:option value="1">女</html:option>
						</html:select>
					</div>
					<div>
						<label for="family_structure_relationship1"
							name="family_structure1">続柄：</label>
						<html:text property="family_structure_relationship1"
							name="Personal_informationForm"
							styleId="family_structure_relationship1"
							value="<%=family_structure_relationship1%>" size="3"
							maxlength="3" />
					</div>
					<div>
						<label for="family_structure_residence" name="family_structure1">同居・別居</label>
						<html:select property="family_structure_residence1"
							name="Personal_informationForm"
							styleId="family_structure_residence1"
							value="<%=family_structure_residence1%>">
							<html:option value="">-</html:option>
							<html:option value="0">同居</html:option>
							<html:option value="1">別居</html:option>
						</html:select>
					</div>
					<div>
						<label for="family_structure_support1" name="family_structure1">扶養の有無：</label>
						<html:select property="family_structure_support1"
							name="Personal_informationForm"
							styleId="family_structure_support1"
							value="<%=family_structure_support1%>">
							<html:option value="">-</html:option>
							<html:option value="0">有</html:option>
							<html:option value="1">無</html:option>
						</html:select>
					</div>
					<div>
						<label for="family_structure_job1" name="family_structure1">職業：</label>
						<html:text property="family_structure_job1"
							name="Personal_informationForm" styleId="family_structure_job1"
							value="<%=family_structure_job1%>" size="18" maxlength="16" />
					</div>


					<br>
					<label for="family_structure_name2" name="family_structure2">氏名：</label>
					<html:text property="family_structure_name2"
						name="Personal_informationForm" styleId="family_structure_name2"
						value="<%=family_structure_name2%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_furigana2" name="family_structure2">フリガナ：</label>
					<html:text property="family_structure_furigana2"
						name="Personal_informationForm"
						styleId="family_structure_furigana2"
						value="<%=family_structure_furigana2%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_birth2" name="family_structure2">生年月日：</label>
					<html:text property="family_structure_birth2"
						name="Personal_informationForm" styleId="family_structure_birth2"
						value="<%=family_structure_birth2%>" size="7" maxlength="8" />
				</div>
				<div>
					<label for="family_structure_sex2" name="family_structure2">性別：</label>
					<html:select property="family_structure_sex2"
						name="Personal_informationForm" styleId="family_structure_sex2"
						value="<%=family_structure_sex2%>">
						<html:option value="">-</html:option>
						<html:option value="0">男</html:option>
						<html:option value="1">女</html:option>
					</html:select>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship2"
						name="family_structure2-2">続柄：</label>
					<html:text property="family_structure_relationship2"
						name="Personal_informationForm"
						styleId="family_structure_relationship2"
						value="<%=family_structure_relationship2%>" />
				</div>
				<div>
					<label for="family_structure_residence" name="family_structure2">同居・別居</label>
					<html:select property="family_structure_residence2"
						name="Personal_informationForm"
						styleId="family_structure_residence2"
						value="<%=family_structure_residence2%>">
						<html:option value="">-</html:option>
						<html:option value="0">同居</html:option>
						<html:option value="1">別居</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_support2" name="family_structure2">扶養の有無：</label>
					<html:select property="family_structure_support2"
						name="Personal_informationForm"
						styleId="family_structure_support2"
						value="<%=family_structure_support2%>">
						<html:option value="">-</html:option>
						<html:option value="0">有</html:option>
						<html:option value="1">無</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_job2" name="family_structure2">職業：</label>
					<html:text property="family_structure_job2"
						name="Personal_informationForm" styleId="family_structure_job2"
						value="<%=family_structure_job2%>" size="18" maxlength="16" />
				</div>

				<br>
				<div>
					<label for="family_structure_name3" name="family_structure3">氏名：</label>
					<html:text property="family_structure_name3"
						name="Personal_informationForm" styleId="family_structure_name3"
						value="<%=family_structure_name3%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_furigana3" name="family_structure3">フリガナ：</label>
					<html:text property="family_structure_furigana3"
						name="Personal_informationForm"
						styleId="family_structure_furigana3"
						value="<%=family_structure_furigana3%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_birth3" name="family_structure3">生年月日：</label>
					<html:text property="family_structure_birth3"
						name="Personal_informationForm" styleId="family_structure_birth3"
						value="<%=family_structure_birth3%>" size="7" maxlength="8" />
				</div>
				<div>
					<label for="family_structure_sex3" name="family_structure3">性別：</label>
					<html:select property="family_structure_sex3"
						name="Personal_informationForm" styleId="family_structure_sex3"
						value="<%=family_structure_sex3%>">
						<html:option value="">-</html:option>
						<html:option value="0">男</html:option>
						<html:option value="1">女</html:option>
					</html:select>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship3"
						name="family_structure3">続柄：</label>
					<html:text property="family_structure_relationship3"
						name="Personal_informationForm"
						styleId="family_structure_relationship3"
						value="<%=family_structure_relationship3%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="family_structure_residence" name="family_structure3">同居・別居</label>
					<html:select property="family_structure_residence3"
						name="Personal_informationForm"
						styleId="family_structure_residence3"
						value="<%=family_structure_residence3%>">
						<html:option value="">-</html:option>
						<html:option value="0">同居</html:option>
						<html:option value="1">別居</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_support3" name="family_structure3">扶養の有無：</label>
					<html:select property="family_structure_support3"
						name="Personal_informationForm"
						styleId="family_structure_support3"
						value="<%=family_structure_support3%>">
						<html:option value="">-</html:option>
						<html:option value="0">有</html:option>
						<html:option value="1">無</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_job3" name="family_structure3">職業：</label>
					<html:text property="family_structure_job3"
						name="Personal_informationForm" styleId="family_structure_job3"
						value="<%=family_structure_job3%>" size="18" maxlength="16" />
				</div>

				<br>
				<div>
					<label for="family_structure_name4" name="family_structure4">氏名：</label>
					<html:text property="family_structure_name4"
						name="Personal_informationForm" styleId="family_structure_name4"
						value="<%=family_structure_name4%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_furigana4" name="family_structure4">フリガナ：</label>
					<html:text property="family_structure_furigana4"
						name="Personal_informationForm"
						styleId="family_structure_furigana4"
						value="<%=family_structure_furigana4%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_birth4" name="family_structure4">生年月日：</label>
					<html:text property="family_structure_birth4"
						name="Personal_informationForm" styleId="family_structure_birth4"
						value="<%=family_structure_birth4%>" size="7" maxlength="8" />
				</div>
				<div>
					<label for="family_structure_sex4" name="family_structure4">性別：</label>
					<html:select property="family_structure_sex4"
						name="Personal_informationForm" styleId="family_structure_sex4"
						value="<%=family_structure_sex4%>">
						<html:option value="">-</html:option>
						<html:option value="0">男</html:option>
						<html:option value="1">女</html:option>
					</html:select>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship4"
						name="family_structure4">続柄：</label>
					<html:text property="family_structure_relationship4"
						name="Personal_informationForm"
						styleId="family_structure_relationship4"
						value="<%=family_structure_relationship4%>" />
				</div>
				<div>
					<label for="family_structure_residence" name="family_structure4">同居・別居</label>
					<html:select property="family_structure_residence4"
						name="Personal_informationForm"
						styleId="family_structure_residence4"
						value="<%=family_structure_residence4%>">
						<html:option value="">-</html:option>
						<html:option value="0">同居</html:option>
						<html:option value="1">別居</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_support4" name="family_structure4">扶養の有無：</label>
					<html:select property="family_structure_support4"
						name="Personal_informationForm"
						styleId="family_structure_support4"
						value="<%=family_structure_support4%>">
						<html:option value="">-</html:option>
						<html:option value="0">有</html:option>
						<html:option value="1">無</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_job4" name="family_structure4">職業：</label>
					<html:text property="family_structure_job4"
						name="Personal_informationForm" styleId="family_structure_job4"
						value="<%=family_structure_job4%>" size="18" maxlength="16" />
				</div>

				<br>
				<div>
					<label for="family_structure_name5" name="family_structure5">氏名：</label>
					<html:text property="family_structure_name5"
						name="Personal_informationForm" styleId="family_structure_name5"
						value="<%=family_structure_name5%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_furigana5" name="family_structure5">フリガナ：</label>
					<html:text property="family_structure_furigana5"
						name="Personal_informationForm"
						styleId="family_structure_furigana5"
						value="<%=family_structure_furigana5%>" size="18" maxlength="16" />
				</div>
				<div>
					<label for="family_structure_birth5" name="family_structure5">生年月日：</label>
					<html:text property="family_structure_birth5"
						name="Personal_informationForm" styleId="family_structure_birth5"
						value="<%=family_structure_birth5%>" size="7" maxlength="8" />
				</div>
				<div>
					<label for="family_structure_sex5" name="family_structure5">性別：</label>
					<html:select property="family_structure_sex5"
						name="Personal_informationForm" styleId="family_structure_sex5"
						value="<%=family_structure_sex5%>">
						<html:option value="">-</html:option>
						<html:option value="0">男</html:option>
						<html:option value="1">女</html:option>
					</html:select>
					</select>
				</div>
				<div>
					<label for="family_structure_relationship5"
						name="family_structure5">続柄：</label>
					<html:text property="family_structure_relationship5"
						name="Personal_informationForm"
						styleId="family_structure_relationship5"
						value="<%=family_structure_relationship5%>" size="3" maxlength="3" />
				</div>
				<div>
					<label for="family_structure_residence" name="family_structure5">同居・別居</label>
					<html:select property="family_structure_residence5"
						name="Personal_informationForm"
						styleId="family_structure_residence5"
						value="<%=family_structure_residence5%>">
						<html:option value="">-</html:option>
						<html:option value="0">同居</html:option>
						<html:option value="1">別居</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_support5" name="family_structure5">扶養の有無：</label>
					<html:select property="family_structure_support5"
						name="Personal_informationForm"
						styleId="family_structure_support5"
						value="<%=family_structure_support5%>">
						<html:option value="">-</html:option>
						<html:option value="0">有</html:option>
						<html:option value="1">無</html:option>
					</html:select>
				</div>
				<div>
					<label for="family_structure_job5" name="family_structure5">職業：</label>
					<html:text property="family_structure_job5"
						name="Personal_informationForm" styleId="family_structure_job5"
						value="<%=family_structure_job5%>" size="18" maxlength="16" />
				</div>

		</div>

		<!-- 登録/編集ボタン  -->
		<p id="Bentry">
			<html:submit property="button" styleClass="btn" value="登録"
				styleId="entry" />
		</p>

		<p id="Bedit">
			<input type="button" value="編集" id="edit" onclick="clickBtnEdit()"
				class="btn" />
		</p>
		<script type="text/javascript">
			document.getElementById("Bentry").style.display = "none";
			document.getElementById("Bedit").style.display = "none";
			// 名前が未入力の場合
			if (
		<%=status%>
			== '0') {
				document.getElementById("Bentry").style.display = "block";
			}
			// 名前が入力済みの場合
			else if (
		<%=status%>
			== '1') {
				document.getElementById("Bedit").style.display = "block";

				document.getElementById('hire_date').readOnly = true;
				document.getElementById('name').readOnly = true;
				document.getElementById('furigana').readOnly = true;
				document.getElementById('birth').readOnly = true;
				document.getElementById('sex').readOnly = true;
				document.getElementById('tel_home').readOnly = true;
				document.getElementById('tel_phone').readOnly = true;
				document.getElementById('postal_code').readOnly = true;
				document.getElementById('address').readOnly = true;
				document.getElementById('division').readOnly = true;
				document.getElementById('Emergency_tel').readOnly = true;
				document.getElementById('emergency_address').readOnly = true;
				document.getElementById('emergency_name1').readOnly = true;
				document.getElementById('emergency_name2').readOnly = true;
				document.getElementById('emergency_name3').readOnly = true;
				document.getElementById('emergency_name4').readOnly = true;
				document.getElementById('emergency_name5').readOnly = true;
				document.getElementById('relationship1').readOnly = true;
				document.getElementById('relationship2').readOnly = true;
				document.getElementById('relationship3').readOnly = true;
				document.getElementById('relationship4').readOnly = true;
				document.getElementById('relationship5').readOnly = true;
				document.getElementById('emergency_tel1').readOnly = true;
				document.getElementById('emergency_tel2').readOnly = true;
				document.getElementById('emergency_tel3').readOnly = true;
				document.getElementById('emergency_tel4').readOnly = true;
				document.getElementById('emergency_tel5').readOnly = true;
				document.getElementById('family_structure_name1').readOnly = true;
				document.getElementById('family_structure_name2').readOnly = true;
				document.getElementById('family_structure_name3').readOnly = true;
				document.getElementById('family_structure_name4').readOnly = true;
				document.getElementById('family_structure_name5').readOnly = true;
				document.getElementById('family_structure_furigana1').readOnly = true;
				document.getElementById('family_structure_furigana2').readOnly = true;
				document.getElementById('family_structure_furigana3').readOnly = true;
				document.getElementById('family_structure_furigana4').readOnly = true;
				document.getElementById('family_structure_furigana5').readOnly = true;
				document.getElementById('family_structure_sex1').readOnly = true;
				document.getElementById('family_structure_sex2').readOnly = true;
				document.getElementById('family_structure_sex3').readOnly = true;
				document.getElementById('family_structure_sex4').readOnly = true;
				document.getElementById('family_structure_sex5').readOnly = true;
				document.getElementById('family_structure_birth1').readOnly = true;
				document.getElementById('family_structure_birth2').readOnly = true;
				document.getElementById('family_structure_birth3').readOnly = true;
				document.getElementById('family_structure_birth4').readOnly = true;
				document.getElementById('family_structure_birth5').readOnly = true;
				document.getElementById('family_structure_relationship1').readOnly = true;
				document.getElementById('family_structure_relationship2').readOnly = true;
				document.getElementById('family_structure_relationship3').readOnly = true;
				document.getElementById('family_structure_relationship4').readOnly = true;
				document.getElementById('family_structure_relationship5').readOnly = true;
				document.getElementById('family_structure_support1').readOnly = true;
				document.getElementById('family_structure_support2').readOnly = true;
				document.getElementById('family_structure_support3').readOnly = true;
				document.getElementById('family_structure_support4').readOnly = true;
				document.getElementById('family_structure_support5').readOnly = true;
				document.getElementById('family_structure_job1').readOnly = true;
				document.getElementById('family_structure_job2').readOnly = true;
				document.getElementById('family_structure_job3').readOnly = true;
				document.getElementById('family_structure_job4').readOnly = true;
				document.getElementById('family_structure_job5').readOnly = true;
			}

			function clickBtnEdit() {
				document.getElementById("Bentry").style.display = "block";
				document.getElementById("Bedit").style.display = "none";

				document.getElementById('hire_date').readOnly = false;
				document.getElementById('name').readOnly = false;
				document.getElementById('furigana').readOnly = false;
				document.getElementById('birth').readOnly = false;
				document.getElementById('sex').readOnly = false;
				document.getElementById('tel_home').readOnly = false;
				document.getElementById('tel_phone').readOnly = false;
				document.getElementById('postal_code').readOnly = false;
				document.getElementById('address').readOnly = false;
				document.getElementById('division').readOnly = false;
				document.getElementById('Emergency_tel').readOnly = false;
				document.getElementById('emergency_address').readOnly = false;
				document.getElementById('emergency_name1').readOnly = false;
				document.getElementById('emergency_name2').readOnly = false;
				document.getElementById('emergency_name3').readOnly = false;
				document.getElementById('emergency_name4').readOnly = false;
				document.getElementById('emergency_name5').readOnly = false;
				document.getElementById('relationship1').readOnly = false;
				document.getElementById('relationship2').readOnly = false;
				document.getElementById('relationship3').readOnly = false;
				document.getElementById('relationship4').readOnly = false;
				document.getElementById('relationship5').readOnly = false;
				document.getElementById('emergency_tel1').readOnly = false;
				document.getElementById('emergency_tel2').readOnly = false;
				document.getElementById('emergency_tel3').readOnly = false;
				document.getElementById('emergency_tel4').readOnly = false;
				document.getElementById('emergency_tel5').readOnly = false;
				document.getElementById('family_structure_name1').readOnly = false;
				document.getElementById('family_structure_name2').readOnly = false;
				document.getElementById('family_structure_name3').readOnly = false;
				document.getElementById('family_structure_name4').readOnly = false;
				document.getElementById('family_structure_name5').readOnly = false;
				document.getElementById('family_structure_furigana1').readOnly = false;
				document.getElementById('family_structure_furigana2').readOnly = false;
				document.getElementById('family_structure_furigana3').readOnly = false;
				document.getElementById('family_structure_furigana4').readOnly = false;
				document.getElementById('family_structure_furigana5').readOnly = false;
				document.getElementById('family_structure_sex1').readOnly = false;
				document.getElementById('family_structure_sex2').readOnly = false;
				document.getElementById('family_structure_sex3').readOnly = false;
				document.getElementById('family_structure_sex4').readOnly = false;
				document.getElementById('family_structure_sex5').readOnly = false;
				document.getElementById('family_structure_birth1').readOnly = false;
				document.getElementById('family_structure_birth2').readOnly = false;
				document.getElementById('family_structure_birth3').readOnly = false;
				document.getElementById('family_structure_birth4').readOnly = false;
				document.getElementById('family_structure_birth5').readOnly = false;
				document.getElementById('family_structure_relationship1').readOnly = false;
				document.getElementById('family_structure_relationship2').readOnly = false;
				document.getElementById('family_structure_relationship3').readOnly = false;
				document.getElementById('family_structure_relationship4').readOnly = false;
				document.getElementById('family_structure_relationship5').readOnly = false;
				document.getElementById('family_structure_support1').readOnly = false;
				document.getElementById('family_structure_support2').readOnly = false;
				document.getElementById('family_structure_support3').readOnly = false;
				document.getElementById('family_structure_support4').readOnly = false;
				document.getElementById('family_structure_support5').readOnly = false;
				document.getElementById('family_structure_job1').readOnly = false;
				document.getElementById('family_structure_job2').readOnly = false;
				document.getElementById('family_structure_job3').readOnly = false;
				document.getElementById('family_structure_job4').readOnly = false;
				document.getElementById('family_structure_job5').readOnly = false;

			}
		</script>


		<!-- /form> -->
		<div>
			<html:submit property="button" styleClass="btn" value="戻る"
			styleId="main" />
		</div>


		<!-- <script type="text/javascript" src="../js/personal_information.js"></script> -->
		<script type="text/javascript">
			document.write("最終更新日" + document.lastModified);
		</script>
</div>
</html:form>
</body>
</html:html>

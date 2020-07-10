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
	<title><bean:message key="personal.title"/></title>
	<html:base/>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
		/*
 		try{
			Personal_informationForm pForm = (Personal_informationForm) session.getAttribute("pForm");
			hire_date =  pForm.getHire_date();
 		}catch(NullPointerException e){
 			hire_date = null;
 		}
		*/
		
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
		String emergency_postal_code = "";
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
		
		// 社員番号を個人情報入力画面アクションフォームに格納
		pForm.setEmployee_no(lForm.getEmployee_no());
		
		// 社員名がDBに登録されているかの確認
		if(dba.getEmoloyee_Name(pForm)){
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
			emergency_postal_code = pForm.getEmergency_postal_code();
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
			document = pForm.getDocument();
			nb = pForm.getNb();
			confirmer_no = pForm.getConfirmer_no();
			button = pForm.getButton();
			
			status = "1";
			
			// 各フィールドを入直不可にする。
			// readonly
			
			
			
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
							styleId="hire_date" value="<%= hire_date %>" size="8" />
						(半角数字8ケタ)

					</div>
					<div class="name">
						<label for="name">氏名 ：</label>
						<html:text property="employee_name"
							name="Personal_informationForm" styleId="name" value="<%= employee_name %>"></html:text>※必須
					</div>
					<div>
						<label for="furigana">フリガナ：</label>
						<html:text property="furigana_name"
							name="Personal_informationForm" styleId="furigana" value="<%= furigana_name %>"></html:text>
					</div>
					<div class="sex">
						<label for="sex">性別：</label>
						<html:select property="sex" name="Personal_informationForm"
							styleId="sex" value="<%= sex %>">
							<html:option value="">-</html:option>
							<html:option value="0">男</html:option>
							<html:option value="1">女</html:option>
						</html:select>
					</div>
					<div class="birth">
						<label for="birth">生年月日：</label>
						<html:text property="birth" name="Personal_informationForm"
							styleId="birth" value="<%= birth %>" size="8" />
					</div>
					<div class="tel">
						<label for="tel_home">電話番号</label>
						<div class="tel_home">
							<label for="tel_home"> 自宅 ：</label>
							<html:text property="tel_home" name="Personal_informationForm"
								styleId="tel_home" value="<%= tel_home %>" />
						</div>
						<div class="tel_phone">
							<label for="tel_phone"> 携帯電話：</label>
							<html:text property="tel_phone" name="Personal_informationForm"
								styleId="tel_phone" value="<%= tel_phone %>" />
						</div>
					</div>
					<div class="postal_code">
						<label for="postal_code">郵便番号：</label>
						<html:text property="postal_code" name="Personal_informationForm"
							styleId="postal_code" maxlength="7" value="<%= postal_code %>" />
					</div>
					<div class="address">
						<label for="address">住所 ：</label>
						<html:text property="address" name="Personal_informationForm"
							styleId="address" value="<%= address %>" />
					</div>
					<div class="division">
						<label for="division">住所区分：</label>
						<html:select property="division" name="Personal_informationForm"
							styleId="division" value="<%= division %>">
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
							<div>
								<label for="emergency_postal_code">郵便番号：</label>
								<html:text property="emergency_postal_code"
									name="Personal_informationForm" styleId="emergency_postal_code"
									size="4" maxlength="7" value="<%= emergency_postal_code %>" />
							</div>
							<div class="emergency_address">
								<label for="emergency_address">住所 ：</label>
								<html:text property="emergency_address"
									name="Personal_informationForm" styleId="emergency_address"
									size="50" value="<%= emergency_address %>" />
							</div>
							<p class="emergency_contact" id="emergency_contact1">
							<div>
								<label for="emergency_name1" name="emergency1">代表：</label>
								<html:text property="emergency_name1"
									name="Personal_informationForm" styleId="emergency_name1"
									value="<%= emergency_name1 %>" />
							</div>
							<div>
								<label for="relationship1" name="emergency1">本人との関係：</label>
								<html:text property="relationship1"
									name="Personal_informationForm" styleId="relationship1"
									styleClass="relationship" value="<%= relationship1 %>" />
							</div>
							<div>
								<label for="emergency_tel1" name="emergency1">TEL ：</label>
								<html:text property="emergency_tel1"
									name="Personal_informationForm" styleId="emergency_tel1"
									styleClass="emergency_tel" value="<%= emergency_tel1 %>" />
							</div>
						</div>
					</p>

				<p class="emergency_contact" id="emergency_contact2">
				
				<div>
					<label for="emergency_name2" id="a1" name="emergency2">氏名：</label>
					<html:text property="emergency_name2"
						name="Personal_informationForm" styleId="emergency_name2"
						styleClass="emergency_name" value="<%=emergency_name2%>" />
				</div>
				<div>
					<label for="relationship2" name="emergency2">本人との関係：</label>
					<html:text property="relationship2" name="Personal_informationForm"
						styleId="relationship2" styleClass="relationship"
						value="<%=relationship2%>" />
				</div>
				<div>
					<label for="emergency_tel2" name="emergency2">TEL ：</label>
					<html:text property="emergency_tel2"
						name="Personal_informationForm" styleId="emergency_tel2"
						styleClass="emergency_tel" value="<%=emergency_tel2%>" />
				</div>
				</p>

				<p class="emergency_contact" id="emergency_contact3">
						<div>
							<label for="emergency_name3" id="a1" name="emergency3">氏名：</label>
							<html:text property="emergency_name3"
								name="Personal_informationForm" styleId="emergency_name3" 
								styleClass="emergency_name" value="<%= emergency_name3 %>"></html:text>
						</div>
						<div>
							<label for="relationship3" name="emergency3">本人との関係：</label>
							<html:text property="relationship3"
								name="Personal_informationForm" styleId="relationship3" 
								styleClass="relationship" value="<%= relationship3 %>" />
						</div>
						<div>
							<label for="emergency_tel3" name="emergency3">TEL ：</label>
							<html:text property="emergency_tel3"
								name="Personal_informationForm" styleId="emergency_tel3" 
								styleClass="emergency_tel" value="<%= emergency_tel3 %>" />
						</div>
						</p>
						<p class="emergency_contact" id="emergency_contact4">
							<div>
								<label for="emergency_name4" id="a1" name="emergency4">氏名：</label>
								<html:text property="emergency_name4"
									name="Personal_informationForm" styleId="emergency_name4" 
									styleClass="emergency_name" value="<%= emergency_name4 %>"></html:text>
							</div>
							<div>
								<label for="relationship4" name="emergency4">本人との関係：</label>
								<html:text property="relationship4"
									name="Personal_informationForm" styleId="relationship4" 
									styleClass="relationship" value="<%= relationship4 %>" />
							</div>
							<div>
								<label for="emergency_tel4" name="emergency4">TEL ：</label>
								<html:text property="emergency_tel4"
									name="Personal_informationForm" styleId="emergency_tel4" 
									styleClass="emergency_tel" value="<%= emergency_tel4 %>" />
							</div>
						</p>
						<p class="emergency_contact" id="emergency_contact5">
							<div>
								<label for="emergency_name5" id="a1" name="emergency5">氏名：</label>
								<html:text property="emergency_name5"
									name="Personal_informationForm" styleId="emergency_name5" 
									styleClass="emergency_name" value="<%= emergency_name5 %>"></html:text>
							</div>
							<div>
								<label for="relationship5" name="emergency5">本人との関係：</label>
								<html:text property="relationship5"
									name="Personal_informationForm" styleId="relationship5" 
									styleClass="relationship" value="<%= relationship5 %>" />
							</div>
							<div>
								<label for="emergency_tel5" name="emergency5">TEL ：</label>
								<html:text property="emergency_tel5"
								name="Personal_informationForm" styleId="emergency_tel5" 
								styleClass="emergency_tel" value="<%= emergency_tel5 %>" />
							</div>
						</p>
						</br>
					</p>
						<div class="family_structure" id="family_structure">
							<label for="family_structure">家族構成</label>
							<div>
								<label for="family_structure_name1" name="family_structure1">氏名：</label>
								<html:text property="family_structure_name1" 
									name="Personal_informationForm" styleId="Personal_informationForm1"
									 value="<%= family_structure_name1 %>" />
							</div>
							<div>
								<label for="family_structure_furigana1" name="family_structure1">フリガナ：</label>
								<html:text property="family_structure_furigana1" 
									name="Personal_informationForm" styleId="family_structure_furigana1"
									 value="<%= family_structure_furigana1 %>" />
							</div>
							<div>
								<label for="family_structure_birth1" name="family_structure1">生年月日：</label>
								<html:text property="family_structure_birth1" 
									name="Personal_informationForm" styleId="family_structure_birth1"
									 value="<%= family_structure_birth1 %>" />
							</div>
							<div>
								<label for="family_structure_sex1" name="family_structure1">性別：</label>
								<html:select property="family_structure_sex1" name="Personal_informationForm"
									styleId="family_structure_sex1" value="<%= family_structure_sex1 %>">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_relationship1"
									name="family_structure1">続柄：</label>
								<html:text property="family_structure_relationship1" 
									name="Personal_informationForm" styleId="family_structure_relationship1"
									 value="<%= family_structure_relationship1 %>" />
							</div>
							<div>
								<label for="family_structure_support1" name="family_structure1">扶養の有無：</label>
								<html:select property="family_structure_support1" name="Personal_informationForm"
									styleId="family_structure_support1" value="<%= family_structure_support1 %>">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job1" name="family_structure1">職業：</label>
								<html:text property="family_structure_job1" 
									name="Personal_informationForm" styleId="family_structure_job1"
									 value="<%= family_structure_job1 %>" />
							</div>

							<div>
								<label for="family_structure_name2" name="family_structure2">氏名：</label>
								<html:text property="family_structure_name2" 
									name="Personal_informationForm" styleId="family_structure_name2"
									 value="<%= family_structure_name2 %>" />
							</div>
							<div>
								<label for="family_structure_furigana2" name="family_structure2">フリガナ：</label>
								<html:text property="family_structure_furigana2" 
									name="Personal_informationForm" styleId="family_structure_furigana2"
									 value="<%= family_structure_furigana2 %>" />
							</div>
							<div>
								<label for="family_structure_birth2" name="family_structure2">生年月日：</label>
								<html:text property="family_structure_birth2" 
									name="Personal_informationForm" styleId="family_structure_birth2"
									 value="<%= family_structure_birth2 %>" />
							</div>
							<div>
								<label for="family_structure_sex2" name="family_structure2">性別：</label>
								<html:select property="family_structure_sex2" name="Personal_informationForm"
									styleId="family_structure_sex2" value="<%= family_structure_sex2 %>">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship2" name="family_structure2">続柄：</label> 
								<html:text property="family_structure_relationship2" 
									name="Personal_informationForm" styleId="family_structure_relationship2"
									 value="<%= family_structure_relationship2 %>" />
							</div>
							<div>
								<label for="family_structure_support2" name="family_structure2">扶養の有無：</label>
								<html:select property="family_structure_support2" name="Personal_informationForm"
									styleId="family_structure_support2" value="<%= family_structure_support2 %>">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job2" name="family_structure2">職業：</label>
								<html:text property="family_structure_job2" 
									name="Personal_informationForm" styleId="family_structure_job2"
									 value="<%= family_structure_job2 %>" />
							</div>

							</br>

							<div>
								<label for="family_structure_name3" name="family_structure3">氏名：</label>
								<html:text property="family_structure_name3" 
									name="Personal_informationForm" styleId="family_structure_name3"
									 value="<%= family_structure_name3 %>" />
							</div>
							<div>
								<label for="family_structure_furigana3" name="family_structure3">フリガナ：</label>
								<html:text property="family_structure_furigana3" 
									name="Personal_informationForm" styleId="family_structure_furigana3"
									 value="<%= family_structure_furigana3 %>" />
							</div>
							<div>
								<label for="family_structure_birth3" name="family_structure3">生年月日：</label>
								<html:text property="family_structure_birth3" 
									name="Personal_informationForm" styleId="family_structure_birth3"
									 value="<%= family_structure_birth3 %>" />
							</div>
							<div>
								<label for="family_structure_sex3" name="family_structure3">性別：</label>
								<html:select property="family_structure_sex3" name="Personal_informationForm"
									styleId="family_structure_sex3" value="<%= family_structure_sex3 %>">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship3" name="family_structure3">続柄：</label> 
								<html:text property="family_structure_relationship3" 
									name="Personal_informationForm" styleId="family_structure_relationship3"
									 value="<%= family_structure_relationship3 %>" />
							</div>
							<div>
								<label for="family_structure_support3" name="family_structure3">扶養の有無：</label>
								<html:select property="family_structure_support3" name="Personal_informationForm"
									styleId="family_structure_support3" value="<%= family_structure_support3 %>">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job3" name="family_structure3">職業：</label>
								<html:text property="family_structure_job3" 
									name="Personal_informationForm" styleId="family_structure_job3"
									 value="<%= family_structure_job3 %>" />
							</div>


							<div>
								<label for="family_structure_name4" name="family_structure4">氏名：</label>
								<html:text property="family_structure_name4" 
									name="Personal_informationForm" styleId="family_structure_name4"
									 value="<%= family_structure_name4 %>" />
							</div>
							<div>
								<label for="family_structure_furigana4" name="family_structure4">フリガナ：</label>
								<html:text property="family_structure_furigana4" 
									name="Personal_informationForm" styleId="family_structure_furigana4"
									 value="<%= family_structure_furigana4 %>" />
							</div>
							<div>
								<label for="family_structure_birth4" name="family_structure4">生年月日：</label>
								<html:text property="family_structure_birth4" 
									name="Personal_informationForm" styleId="family_structure_birth4"
									 value="<%= family_structure_birth4 %>" />
							</div>
							<div>
								<label for="family_structure_sex4" name="family_structure4">性別：</label>
								<html:select property="family_structure_sex4" name="Personal_informationForm"
									styleId="family_structure_sex4" value="<%= family_structure_sex4 %>">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship4" name="family_structure4">続柄：</label> 
								<html:text property="family_structure_relationship4" 
									name="Personal_informationForm" styleId="family_structure_relationship4"
									 value="<%= family_structure_relationship4 %>" />
							</div>
							<div>
								<label for="family_structure_support4" name="family_structure4">扶養の有無：</label>
								<html:select property="family_structure_support4" name="Personal_informationForm"
									styleId="family_structure_support4" value="<%= family_structure_support4 %>">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job4" name="family_structure4">職業：</label>
								<html:text property="family_structure_job4" 
									name="Personal_informationForm" styleId="family_structure_job4"
									 value="<%= family_structure_job4 %>" />
							</div>


							<div>
								<label for="family_structure_name5" name="family_structure5">氏名：</label>
								<html:text property="family_structure_name5" 
									name="Personal_informationForm" styleId="family_structure_name5"
									 value="<%= family_structure_name5 %>" />
							</div>
							<div>
								<label for="family_structure_furigana5" name="family_structure5">フリガナ：</label>
								<html:text property="family_structure_furigana5" 
									name="Personal_informationForm" styleId="family_structure_furigana5"
									 value="<%= family_structure_furigana5 %>" />
							</div>
							<div>
								<label for="family_structure_birth5" name="family_structure5">生年月日：</label>
								<html:text property="family_structure_birth5" 
									name="Personal_informationForm" styleId="family_structure_birth5"
									 value="<%= family_structure_birth5 %>" />
							</div>
							<div>
								<label for="family_structure_sex5" name="family_structure5">性別：</label>
								<html:select property="family_structure_sex5" name="Personal_informationForm"
									styleId="family_structure_sex5" value="<%= family_structure_sex5 %>">
									<html:option value="">-</html:option>
									<html:option value="true">男</html:option>
									<html:option value="false">女</html:option>
								</html:select>
								</select>
							</div>
							<div>
  								<label for="family_structure_relationship5" name="family_structure5">続柄：</label> 
								<html:text property="family_structure_relationship5" 
									name="Personal_informationForm" styleId="family_structure_relationship5"
									 value="<%= family_structure_relationship5 %>" />
							</div>
							<div>
								<label for="family_structure_support5" name="family_structure5">扶養の有無：</label>
								<html:select property="family_structure_support5" name="Personal_informationForm"
									styleId="family_structure_support5" value="<%= family_structure_support5 %>">
									<html:option value="">-</html:option>
									<html:option value="true">有</html:option>
									<html:option value="false">無</html:option>
								</html:select>
							</div>
							<div>
								<label for="family_structure_job5" name="family_structure5">職業：</label>
								<html:text property="family_structure_job5" 
									name="Personal_informationForm" styleId="family_structure_job5"
									 value="<%= family_structure_job5 %>" />
							</div>
						</div>
						
						<!-- 登録/編集ボタン  -->
						<p id="Bentry">
							<html:submit property="button" styleClass="btn" value="登録" styleId="entry" />
						</p>
						
						<p id="Bedit">
							<input type="button" value="編集" id="edit" onclick="clickbtn1()" class="btn" />
						</p>
						<script type="text/javascript">
						
						    document.getElementById("Bentry").style.display ="none";
						    document.getElementById("Bedit").style.display ="none";
						    
						    if(<%= status %>=='0'){
							    document.getElementById("Bentry").style.display  = "block";
						    }else if(<%= status %>=='1'){
								document.getElementById("Bedit").style.display  = "block";
						    }
						    
							function clickbtn1(){
							    document.getElementById("Bentry").style.display  = "block";
							    document.getElementById("Bedit").style.display  = "none";
							}
							
						</script>

						<p>確認書類</p>
						<div id="document">
							<input type="checkbox" class="document" id="resident_card"
								name="document" value="1"><label for="resident_card">住民票</label>
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
						<div class="nb">備考<br>
							<textarea id="nb" name="nb" value="test"></textarea>
						</div>
						<div id="confirmer">
							確認者：<%= confirmer_no %>
							
							<html:hidden property="confirmer_no"
							name="Personal_informationForm" styleId="confirmer_no" value=""></html:hidden>
						</div>
						<div>
							<html:submit property="button" styleClass="btn" value="確認" styleId="edit" />
						</div>
							
						</br>
				<!-- /form> -->
				<div>
					<html:submit property="button" styleClass="btn" value="戻る" styleId="back" />
				</div>
				
		</html:form>

				<script type="text/javascript" src="./personal_information.js"></script>
			</div>
	</body>

	<!-- FORM>
		<INPUT type="button" class="btn" style="margin-top: 3px;" value="戻る"
			onClick="history.back()">
	</FORM> -->
</div>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/D01AccessControl/AccessControlMain.css">
<title>入退室管理システムメイン画面</title>
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="head">
				<div class="headTitle">入退室管理システムメイン画面</div>
			</div>
			<div class="main">
				<div class="accessControl">
					<div class="accessControlHead">
						<div class="accessControlHeadTitle">入退室はこちら</div>
					</div>
					<div class="accessControlMain">
						<html:form action="/AccessSelectAction">
							<div class="accessControlSelect">
								<html:select property="floor"
									styleClass="accessControlSelectFloor">
									<html:option value="1">1F</html:option>
									<html:option value="2">2F</html:option>
									<html:option value="3">3F</html:option>
									<html:option value="4">4F</html:option>
								</html:select>
							</div>
							<div class="submitBox">
								<html:submit property="button" styleClass="submit"
									value="GO" />
							</div>
						</html:form>
					</div>
				</div>
				<div class="accessLog">
					<div class="accessLogHead">
						<div class="accessLogHeadTitle">履歴閲覧はこちら</div>
					</div>
					<div class="accessLogMain">
						<html:form action="/AccessLogSelectAction"
							styleClass="accessLogSelectFloor">
							<div class="accessControlLogSelect">
								<div class="selectBox">
									<html:select property="floor"
										styleClass="accessControlLogSelectFloor">
										<html:option value="1">1F</html:option>
										<html:option value="2">2F</html:option>
										<html:option value="3">3F</html:option>
										<html:option value="4">4F</html:option>
									</html:select>
								</div>
								<div class="selectBox">
									<html:select property="year"
										styleClass="accessControlLogSelectYear">
										<html:option value="2020">2020年</html:option>
										<html:option value="2019">2019年</html:option>
									</html:select>
								</div>
								<div class="selectBox">
									<html:select property="month"
										styleClass="accessControlLogSelectYear">
										<html:option value="01">1月</html:option>
										<html:option value="02">2月</html:option>
										<html:option value="03">3月</html:option>
										<html:option value="04">4月</html:option>
										<html:option value="05">5月</html:option>
										<html:option value="06">6月</html:option>
										<html:option value="07">7月</html:option>
										<html:option value="08">8月</html:option>
										<html:option value="09">9月</html:option>
										<html:option value="10">10月</html:option>
										<html:option value="11">11月</html:option>
										<html:option value="12">12月</html:option>
									</html:select>
								</div>
							</div>
							<div class="submitBox">
								<html:submit property="button" value="GO"
									styleClass="submit" />
							</div>
						</html:form>
					</div>
				</div>
			</div>
			<div class="back">
				<html:link href="/WebSystem/jsp/Main.jsp">メインへ戻る</html:link>
			</div>
		</div>
	</div>
</body>
</html>
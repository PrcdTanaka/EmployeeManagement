
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.KintaiMailForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html lang="ja">
<html:html>
<head>
<link rel="stylesheet" type="text/css"
	href="/WebSystem/css/KintaiMail.css">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<style>
.btn1{
	font-weight: bold;
    text-decoration: none;
    text-align: center;
    padding: 8px;
    color: #fff;
    background-color: #49a9d4;
    border-radius: 10px;
    font-weight: bold;
    color:white;
  }

</style>
<body>
	<%
		boolean Url_Flg = false;	// 遷移元確認フラグ false:カレンダー true:ボタン
		boolean flg = false;
	%>
	<%
			// 現在のURLを取得して、年月日を切り抜く
			String Year = "";
			String Month = "";
			String Day = "";
			String str_Date = "";
			String Zero = "0";
			StringBuffer url = request.getRequestURL();
			url.append("?").append(request.getQueryString());
			String MyUrl = url.substring(51);
			if(MyUrl.equals("null"))
			{
				Url_Flg = true;
			}
			else if(MyUrl.substring(0, 5).equals("year="))
			{
				// カレンダーから呼ばれたときに表示する年月日を作成
				if(Url_Flg == false || flg == false)
				{
					String[] lMyUrl1 = new String[1];
					lMyUrl1 = MyUrl.split("year=", 0);
					String[] lMyUrl2 = new String[1];
					lMyUrl2 = lMyUrl1[1].split("&month=", 0);
					Year = lMyUrl2[0];
					String[] lMyUrl3 = new String[1];
					lMyUrl3 = lMyUrl2[1].split("&day=", 0);
					Month = lMyUrl3[0];
					Day = lMyUrl3[1];
					if(Month.length() == 1)
					{
						Month = Zero + Month;
					}
					if(Day.length() == 1)
					{
						Day = Zero + Day;
					}
					str_Date = Year + Month + Day;
				}
				else
				{
					Url_Flg = true;
				}
			}

		%>

	<html:form action="/KintaiMailAction">
		<%
			String Email = "kintai@procd-k.co.jp";
					String Employee_no = "";
					String name = "";
					DbAction dba = new DbAction();
					LoginForm s = (LoginForm) session.getAttribute("form");
					KintaiMailForm Form = new KintaiMailForm();
					String CC = Form.getCC();
					String depart = Form.getDepart();
					String division = Form.getDivision();
					String bcc = Form.getBcc();
					String spotcode = Form.getSpotcode();
				    String span = Form.getSpan();
					String span2 = Form.getSpan2();
					String ptime = Form.getPtime();
					String remark = Form.getRemark();
					String perm = Form.getPerm();
					try {
						Employee_no = s.getEmployee_no();
						name = s.getEmployee_name();
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>

		<div>
			<center>
				<h1>勤怠連絡画面</h1>
			</center>
		</div>

		<p style="margin-left: -44%;">
		<p align="center" style="margin-left: -45%">
			宛先:<%=Email%></p>

		<div align="center" class="depert">
			CC:
			<html:select property="CC" styleId="CC" name="KintaiMailForm"
				style="font-size:15px;width:60%">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
				<html:option value="7">システム営業部</html:option>
				<html:option value="8">総務部</html:option>
			</html:select>
		</div>
		<p align="center" class="BCC">
				BCC:<html:text property="bcc" size="20" maxlength="40" style="font-size: 15px; width: 60%" value="<%=bcc%>" />
				<p style="color:red;margin-left: 17%">※ 任意で入力
		</p>

		<div align="center" class="depert2"
			style="margin-top: 50px; width: 40%; margin-left: 10%;">
			所属部署:
			<html:select property="depart" styleId="depart" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">第一技術部</html:option>
				<html:option value="2">第二技術部</html:option>
				<html:option value="3">第三技術部</html:option>
				<html:option value="4">第四技術部</html:option>
				<html:option value="5">第五技術部</html:option>
				<html:option value="6">ソリューション技術部</html:option>
				<html:option value="7">システム営業部</html:option>
				<html:option value="8">総務部</html:option>
			</html:select>
		</div>

		<p align="center" style="margin-left: -60%;">
			社員番号：<%=Employee_no%>
		</p>
		<p align="center" class="BCC" style="margin-left: -55%;">
			氏名：<%=name%>
		</p>
		<p align="center" class="code" style="margin-left: -42%">
			現場コード：<html:text property="spotcode" size="20" maxlength="6" style="width: 17%" value="<%=spotcode%>" />
			<p style="color:red;margin-left: 13%">例) 1-2345
		</p>
		<div align="center" class="depert2"
			style="width: 40%; margin-left: 10%">
			届出区分:
			<html:select property="division" styleId="division" name="KintaiMailForm"
				style="font-size:15px; width:60%;">
				<html:option value="" style="text-align:center;">選択</html:option>
				<html:option value="1">1,遅刻</html:option>
				<html:option value="2">2,有給休暇</html:option>
				<html:option value="3">4,振替休暇</html:option>
				<html:option value="4">5,特別休暇</html:option>
				<html:option value="5">6,シフト勤務</html:option>
				<html:option value="6">7,早退,その他</html:option>
				<html:option value="7">8,交通遅延</html:option>
				<html:option value="8">9,欠勤</html:option>
				<html:option value="9">A,深夜作業</html:option>
				<html:option value="10">B,休日出勤(振)</html:option>
			</html:select>
		</div>
		<p align="center" class="code" style="margin-left: -6%">
			対象日付/期間(開始)：
			<%
				// カレンダーから呼ばれた時は対象日付(開始)に、カレンダーの値を入れる
				if(Url_Flg == false){
					flg = true;
			%>
				<html:text property="span" size="20" maxlength="8" style="width: 17%" value="<%=str_Date%>" />
			<%
				}
				else if(Url_Flg == true){
			%>
				<html:text property="span" size="20" maxlength="8" style="width: 17%" value="<%=span%>" />
			<%
				}
			%>
			～対象日付/期間(終了)：<html:text property="span2" size="20" maxlength="8" style="width: 17%" value="<%=span2%>" />
			<p style="color:red;margin-left: 12%">例) 2020年9月1日～2020年9月3日 → 20200901～20200903
		</p>
		<p align="center" class="code" style="margin-left: -43%">
			出勤予定時刻:<html:text property="ptime" size="43" maxlength="5" style="width: 17%" value="<%=ptime%>" />
			<p style="color:red;margin-left: 12%">例) 12:00

		</p>
		<p style="margin-left: 17.5%;">備考:</p>
		<div style="margin-left: 21%;">
			<html:textarea property="remark" rows="10" cols="100" value="<%=remark%>"></html:textarea>
		</div>

		<p align="center" class="code" style="margin-left: -39%">
			許可:<html:text property="perm" size="43" maxlength="4" style="width: 17%" value="<%=perm%>" />
			<p style="color:red;margin-left: 17%">※ 届出区分がA,Bの場合、姓のみ記載
		</p>

		<div>
			<html:submit property="button" styleClass="btn" value="送信"
				styleId="kintaimail" style="margin-top:10;" />
		</div>
        <div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="kintailist" />
		</div>
	</html:form>
</body>
</html:html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page import="sample.pr.main.KintaiListForm"%>

<%@ page import="sample.pr.main.MonthlyReportForm"%>
<%@ page import="sample.pr.main.MonthlyReportAction"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="java.util.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ja">
<html:html>

<head>
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
<link rel="stylesheet" type="text/css" href="../css/main.css"/>

<style type="text/css">
<!--
	*{padding:5px; margin:0px;}
	body{text-align:center;}
	table{witdth:800px; background:white; border:2px black solid; border-radius:10px; margin-left:auto; margin-right:auto;}
	th{border:1px black solid; background:#00FFFF; padding-left: 10px; padding-right: 10px;}
	td{border:1px black solid; text-align:center; padding:1px 1px 1px 1px;}
	br{line-height:1em;}
-->
</style>
<META HTTP-EQUIV="Content-Type" CONTENT="text/http;charset=Windows-31J">
</head>

<body>
	<html:form action="/KintaiListAction">
	<%
		Calendar cale = Calendar.getInstance();

		MonthlyReportForm form=new MonthlyReportForm();
		int monthlastDay = cale.getActualMaximum(Calendar.DATE);
		DbAction dba = new DbAction();
		LoginForm lForm=(LoginForm)session.getAttribute("form");
		form.setEmployee_no(lForm.getEmployee_no());

		dba.getMonthly_report(form);
		List<String> span = form.getSpan();
		List<String>span2=form.getSpan2();
		List<String>Mmdd=form.getMmdd();
		int listnumber=0;
		int Max_Days = 30;

		String str_Y = "";
		String str_M = "";
		String str_D = "";
		String zero = "0";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int now_days = Integer.parseInt(sdf.format(cale.getTime()));
	%>

		<div>
			<center>
				<h1>勤怠一覧</h1>
			</center>
		</div>
		<br/>
		<br/>
		<%
		String strYear=request.getParameter("year");
		String strMonth=request.getParameter("month");

		int intYear;
		int intMonth;

		if(strYear != null && strMonth != null)
		{
			int intMonthTemp=Integer.parseInt(strMonth);

			intMonth = intMonthTemp%12;
			intYear = Integer.parseInt(strYear)+intMonthTemp/12;
			if(intMonth==0)
			{
				intMonth=12;
				intYear--;
			}
			cale.set(Calendar.YEAR, intYear);
			cale.set(Calendar.MONTH, intMonth-1);
		}
		intYear=cale.get(Calendar.YEAR);
		intMonth=cale.get(Calendar.MONTH) +1;
		cale.set(Calendar.DATE, 1);

		int k = cale.get(Calendar.DAY_OF_WEEK) -1;
		%>
		<div class="head">
		<a href="http://localhost:8080/WebSystem/jsp/KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth-1 %>">前月</a>
		<span class="title"><%= intYear%>年<%=intMonth %>月</span>
		<a href="http://localhost:8080/WebSystem/jsp/KintaiList.jsp?year=<%=intYear%>&month=<%=intMonth+1 %>">翌月</a>
		</div>

		<span class="validity"></span>
		<div class="fallbackDatePicker">
		<span>
			<%-- カレンダーのプルダウンメニュー作成(月のほう) --%>
			<%--<select id="Years" name="Years">  --%>
			<%
				int Years_Data = cale.get(Calendar.YEAR);
				int Month_Data = cale.get(Calendar.MONTH)+1;
			%>
		</span>
		</div>

		<br/>
		<table>
			<tr>
				<!--TH:Table Header-->
				<th class="holiday">日</th>
				<th class="weekday">月</th>
				<th class="weekday">火</th>
				<th class="weekday">水</th>
				<th class="weekday">木</th>
				<th class="weekday">金</th>
				<th class="saturday">土</th>
			</tr>
			<%-- while文とint=d以外、実験物 --%>
			<%
				int NowDay = cale.get(Calendar.DATE);
				String link1 = "http://localhost:8080/WebSystem/jsp/KintaiMail.jsp";
				String link2 = "http://localhost:8080/WebSystem/jsp/KintaiEditor.jsp";
				int flg= 0;
				int kari_data=1; //対象日
				int days_val = 0;

				int d=0; //日付(最大31までになる)
				while(cale.get(Calendar.MONTH)==intMonth-1){
			%>
			<tr>
				<%-- spanのサイズ分for分を回し、配列に要素を格納 --%>
				<%
					int between_day = 0;
				%>
				<%
					int kintai_span = 0;
					String[] kintai_span_lst = new String[Max_Days];

					for(int Target_day = 0; Target_day < span.size(); Target_day++)
					{
						kintai_span_lst[kintai_span] = span.get(Target_day);
						kintai_span++;
					}
				%>
				<%
					int kintai_span2 = 0;
					String[] kintai_span2_lst = new String[Max_Days];
					for(int Target_span2_day = 0; Target_span2_day < span2.size(); Target_span2_day++)
					{
						kintai_span2_lst[kintai_span2] = span2.get(Target_span2_day);
						kintai_span2++;
					}
				%>
				<%
					for(int j=0; j<7; j++){
				%>
				<%-- 以下のif文は実験
					DBから対象期間の取得し、dが7日以内または、8日以上か確認
					判定条件は、対象期間 > 今日の日付
				--%>
				<%
					boolean Span2_flg = false;
					boolean val_flg = true;
					int int_Span1_Lst = 0;
					int int_Span2_Lst = 0;
					int int_Chk_Span2 = 0;

					str_Y = String.valueOf(intYear);
					str_M = String.valueOf(intMonth);
					str_D = String.valueOf(d+1);
					String str_Lmt = String.valueOf(d+8);
					if(str_M.length() == 1)
					{
						str_M = zero + str_M;
					}
					if(str_D.length() == 1)
					{
						str_D = zero + str_D;
					}
					if(str_Lmt.length() == 1)
					{
						str_Lmt = zero + str_Lmt;
					}
					String str_A = str_Y + str_M + str_D;
					String str_B = str_Y + str_M + str_Lmt;

					int int_str_A = Integer.parseInt(str_A);

					// ガード処理
					// 現ユーザの勤怠連絡がなければDBからの取得処理を行わない。
					// 配列要素を毎日for文で回し、対象期間の日付があればフラグを立てる
					if(span.isEmpty() || k!=0)
					{
						val_flg = false;
					}
					if(val_flg == true)
					{
						for(int t = 0; t < span.size(); t++)
						{
							int str_b_lst = Integer.parseInt(str_B);

							// 対象期間が本日より7日より前なら黄色表示 (flg = 1)
							// 対象期間が本日より8日より後なら赤色表示 (flg = 2)
							if(kintai_span_lst[t].equals(str_A) || between_day >= 1)
							{
								int_Span1_Lst = Integer.parseInt(kintai_span_lst[t]);
								for(int span2_calm = 0; span2_calm < span2.size(); span2_calm++)
								{
									if(Span2_flg == true)
									{
										break;
									}
									int_Span2_Lst = Integer.parseInt(kintai_span2_lst[span2_calm]);

									if(int_Span2_Lst == int_Span1_Lst)
									{
										Span2_flg = false;
									}
									else if(int_Span2_Lst > int_Span1_Lst)
									{
										between_day = (int_Span2_Lst - int_Span1_Lst);

										// 勤怠連絡は土日を挟めないので、最大5日をガード
										if(between_day >= 5)
										{
											Span2_flg = false;
											between_day = 0;
										}
										else
										{
											Span2_flg = true;
										}
									}
								}
								flg = 1;
								if(now_days > str_b_lst)
								{
									flg = 2;
								}
							}

							if(kintai_span2_lst[t].equals(str_A))
							{
								flg = 1;
								if(now_days > str_b_lst)
								{
									flg = 2;
								}
							//	int_Chk_Span2 = Integer.parseInt(kintai_span2_lst[t]);
								between_day = 0;
							}
						}
						if(between_day > 0)
						{
							between_day--;
						}
					}
				%>
				<%
					if(j==0){
				%>
					<td class="holiday">
					<%
					}else if(j==6){
					%>
					<td class="saturday">
					<%}else{%>
						<%--
							flg == 1なら枠は黄色表示
							flg == 2なら枠はピンク表示
						--%>
						<%
							if(flg == 1){
						%>
							<td class="weekday" style="background-color:#FFFF00;">
						<%
							}
							else if(flg == 2) {
						%>
							<td class="weekday" style="background-color:#FFAABE;">
						<%
							}
							else{
						%>
							<td class="weekday">
						<%
							}
						%>

					<%}%>
					<%
					if(k!=0){
						k--;
					}else if(cale.get(Calendar.MONTH)==intMonth-1){
					%>
					<%
						d++;
					%>
					<%-- ボタン式の名残(なんかミスしてる)
					<form action="http://localhost:8080/WebSystem/jsp/KintaiMail.jsp?button=<%=d %>" style="padding: 0em;">
					<input type="submit" id="" name="" style="background-color:transparent; width:30px;" value="<%=d++ %>"/>
					</form>
				 --%>
				 	<%--
				 		flg == 1またはflg == 2なら、勤怠画面のリンク表示
				 		flg == 0なら勤怠連絡画面のリンク表示
				 	--%>
					<%
						if(flg == 1 || flg == 2){
					%>
					<a href="<%=link2 %>?year=<%=Years_Data %>&month=<%=Month_Data %>&day=<%=d %>" ><%=d %></a>
					<%
						}
						else{
					%>
					<a href="<%=link1 %>?year=<%=Years_Data %>&month=<%=Month_Data %>&day=<%=d %>" ><%=d %></a>
					<%
						}
					%>
				 	<%
				 		// flgの初期化
						 flg = 0;
					%>
					<%
					cale.add(Calendar.DATE, 1);
					%>
				<%-- <input type="submit" id="" name="" value="<%=d %>"/> --%>
					<%}%>
					</td>
				<%}%>
				</tr>
				<%}%>
		</table>

		<div style="position: relative; margin-top: 5%; align: center;" >
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="勤怠連絡入力"
				styleId="kintaimail"/>
		</div>
		<div  style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="勤怠月報画面へ"
				styleId="MonthlyReport"/>
		</div>
		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="戻る"
				styleId="main"/>
		</div>

		<%--
		<td><%=span.get(listnumber)%></td>
		 --%>
	</html:form>
</body>
</html:html>
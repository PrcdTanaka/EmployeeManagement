<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.AttendanceForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="b05.attendance.dbaction.MonthlyReportDb"%>
<%@ page import="b01.attendance.main.KintaiListForm"%>
<%@ page import="b02.attendance.inform.KintaiMailForm"%>

<%@ page import="b03.attendance.monthlyreport.MonthlyReportForm"%>
<%@ page import="b03.attendance.monthlyreport.MonthlyReportAction"%>
<%@ page import="b04.attendance.calendar.KintaiManagement"%>

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


		MonthlyReportForm form=new MonthlyReportForm();		//MonthlyReportFormを使用するために宣言
		MonthlyReportDb dba = new MonthlyReportDb();						// DbActionを使用するために宣言
		LoginForm lForm=(LoginForm)session.getAttribute("form");	// LoginForm型の変数lFormにsessionのformを取得
		form.setEmployee_no(lForm.getEmployee_no());				// formにlFormのログイン中の社員番号を取得

		dba.getMonthly_report(form, "", "");
		List<String> span = form.getSpan();		// List型にMonthlyReportFormのSpanを格納
		List<String>span2=form.getSpan2();		// List型にMonthlyReportFormのSpa2nを格納
		List<String>Mmdd=form.getMmdd();		// List型にMonthlyReportFormのMmddを格納
		int Max_Days = 31;						// 配列の要素数

		String str_Y = "";						// カレンダーで表示するYearを代入する変数
		String str_M = "";						// カレンダーで表示するMonthを代入する変数
		String str_D = "";						// カレンダーで表示するDayを代入する変数
		String zero = "0";						// MonthとDyaが1～9の場合に、01～09にするための文字列"0"

		// カレンダーの表示方式を設定(yyyyMMddの方式にする)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// 本日の日付を取得(形式はyyyyMMdd)
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
		String strYear=request.getParameter("year");		// 変数request内のyearを取得
		String strMonth=request.getParameter("month");		// 変数request内のmonthを取得

		int intYear;
		int intMonth;

		// yearがnullかつ、monthがnullか判定
		if(strYear != null && strMonth != null)
		{
			int intMonthTemp=Integer.parseInt(strMonth);	// strMonthをint型にキャスト

			intMonth = intMonthTemp%12;		// intMonthTemp/12の余りを代入
			// strYaerをint型にキャストして、intMonthTemp/12の値を代入
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
		<!-- 前月・来月移動のリンク表示と、今の月を表示 -->
		<div class="head">
		<a href="http://localhost:8080/WebSystem/main/B01AttendanceMain/KintaiList.jsp?year=
		<%
			int LinkYear = 0;		// リンク用の年
			int LinkMonth = 0;		// リンク用の月
			LinkYear = intYear;		// リンク用の年にintYearを格納
			LinkMonth = intMonth;	// リンク用の月にintMonthを格納
			// intMonth -1が0の時
			if(intMonth -1 == 0)
			{
				LinkYear = intYear -1;	// リンク用の年を現在-1にする。
				LinkMonth = 13;			// リンク時に12を表示するために、リンク用の月に13を格納
			}
		%>
		<%=LinkYear%>&month=<%=LinkMonth-1 %>">前月</a>
		<span class="title"><%= intYear%>年<%=intMonth %>月</span>
		<a href="http://localhost:8080/WebSystem/main/B01AttendanceMain/KintaiList.jsp?year=
		<%
			// intMonth +1が13の場合
			if(intMonth +1 == 13)
			{
				LinkYear = intYear + 1;			// リンク用の年を現在+1にする。
				LinkMonth = 0;					// リンク時に1を表示するために、リンク用の月に0を格納
			}
		%>
		<%=LinkYear%>
		&month=<%=LinkMonth+1 %>">翌月</a>
		<%
			KintaiManagement.Cale_Date_Year = intYear;
			KintaiManagement.Cale_Date_Month = intMonth;
		%>
		</div>

		<span class="validity"></span>
		<div class="fallbackDatePicker">
		<span>
			<%-- カレンダーのプルダウンメニュー作成(月のほう) --%>
			<%
				int Years_Data = cale.get(Calendar.YEAR);		// int型変数にカレンダー関数の年を取得
				int Month_Data = cale.get(Calendar.MONTH)+1;	// int型変数にカレンダー関数の月を取得し+1する
			%>
		</span>
		</div>

		<br/>
		<table>
			<tr>
				<!-- カレンダーの曜日を表示 -->
				<!--TH:Table Header-->
				<th class="holiday">日</th>
				<th class="weekday">月</th>
				<th class="weekday">火</th>
				<th class="weekday">水</th>
				<th class="weekday">木</th>
				<th class="weekday">金</th>
				<th class="saturday">土</th>
			</tr>
			<%
				// KintaiMail.jspに遷移するリンクを設定
				String link1 = "http://localhost:8080/WebSystem/jsp/KintaiMail.jsp";
				// KintaiEditor.jspに遷移するリンクを設定
				String link2 = "http://localhost:8080/WebSystem/jsp/KintaiEditor.jsp";
				int flg= 0;		// 編集可能・不可判定フラグ。初期値:0
				int d=0; 		// 日付(最大31までになる)

				// カレンダー関数の月と、変数intMonth-1が同じならwhile文実施
				while(cale.get(Calendar.MONTH)==intMonth-1){
			%>
			<tr>
				<%-- spanのサイズ分for分を回し、配列に要素を格納 --%>
				<%
					int between_day = 0;		// span1とspan2の差分数を格納する変数
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
				<%-- span2のサイズ分for分を回し、配列に要素を格納 --%>
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
					boolean Span2_flg = false;		// 複数回実行確認フラグ(Span2が被るので、何度も実行するのを抑止)
					boolean val_flg = true;			// 対象期間/日付の空チェックフラグ 初期値:true
					int int_Span1_Lst = 0;			// 対象期間/日付(開始)のキャスト用変数
					int int_Span2_Lst = 0;			// 対象期間/日付(終了)のキャスト用変数

					str_Y = String.valueOf(intYear);		// intYearをString型にキャスト
					str_M = String.valueOf(intMonth);		// intMonthをString型にキャスト
					str_D = String.valueOf(d+1);			// d+1をString型にキャスト
					String str_Lmt = String.valueOf(d+8);	// intYearをString型にキャスト(編集不可確認で使用)
					// str_Mが1月～9月の場合、01月～09月と設定(MMに合わせるため)
					if(str_M.length() == 1)
					{
						str_M = zero + str_M;
					}
					// str_Mが1日～9日の場合、01日～09日と設定(ddに合わせるため)
					if(str_D.length() == 1)
					{
						str_D = zero + str_D;
					}
					// str_Mが1日～9日の場合、01日～09日と設定(ddに合わせるため)
					if(str_Lmt.length() == 1)
					{
						str_Lmt = zero + str_Lmt;
					}
					String str_A = str_Y + str_M + str_D;		// yyyyMMddで年月日を結合(例:20200101)
					String str_B = str_Y + str_M + str_Lmt;		// yyyyMMddで年月日を結合(例:20200101)

					int int_str_A = Integer.parseInt(str_A);	// 変数str_Aをint型にキャスト

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
							int str_b_lst = Integer.parseInt(str_B);	// 変数str_Bをint型にキャスト

							// 対象期間が本日より7日より前なら黄色表示 (flg = 1)
							// 対象期間が本日より8日より後なら赤色表示 (flg = 2)

							// Span1とカレンダー表示日付が同一または、span1とspan2の差分数が1以上か判定
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
								flg = 1;	// 編集可能・不可確認フラグを1にする
								// カレンダー表示日+8日が現在の日付より8日以上であるか判定
								if(now_days > str_b_lst)
								{
									flg = 2;	// 編集可能・不可確認フラグを2にする
								}
							}
							// Span2とカレンダー表示日付が同一か判定
							if(kintai_span2_lst[t].equals(str_A))
							{
								flg = 1;	// 編集可能・不可確認フラグを1にする
								// カレンダー表示日+8日が現在の日付より8日以上であるか判定
								if(now_days > str_b_lst)
								{
									flg = 2;	// 編集可能・不可確認フラグを2にする
								}
								between_day = 0;	// span1とspan2の差分数を0にする(複数回実施の防止)
							}
						}
						if(between_day > 0)
						{
							between_day--;	// span1とspan2の差分数が0になるまでspan1とspan2の間の日もマスを色づける
						}
					}
				%>
				<%
					// j==0なら、日曜日とする
					if(j==0){
				%>
					<td class="holiday">
					<%
					// j==6なら、土曜日とする
					}else if(j==6){
					%>
					<td class="saturday">
					<%}else{%>
						<%--
							flg == 1ならマスは黄色表示
							flg == 2ならマスはピンク表示
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
		<div  style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="勤怠月報画面へ"
				styleId="MonthlyReport"/>
		</div>
		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" style="color:#fff; background-color:#49a9d4; width: 20%;  border-radius: 20px;" value="戻る"
				styleId="main"/>
		</div>

	</html:form>
</body>
</html:html>
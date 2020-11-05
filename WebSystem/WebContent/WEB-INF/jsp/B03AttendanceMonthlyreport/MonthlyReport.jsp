<%@page import="b03.attendance.monthlyreport.MonthlyReportAction"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="b03.attendance.monthlyreport.MonthlyReportForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="b05.attendance.dbaction.MonthlyReportDb"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String" %>
<%@ page import="java.lang.StringBuffer" %>
<%@ page import="b04.attendance.calendar.KintaiManagement"%>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/MonthlyReportAction">
	<%!
		boolean Chk_flg = false;
		String Year_Data = "";
	%>
	<body>
		<%
        MonthlyReportForm form=new MonthlyReportForm();

        Calendar cal = Calendar.getInstance();
        String year = (cal.get(cal.YEAR))+"";
        String month=(cal.get(cal.MONTH)+1)+"";
        int monthlastDay = cal.getActualMaximum(Calendar.DATE);
        MonthlyReportDb dba = new MonthlyReportDb();
        LoginForm lForm=(LoginForm)session.getAttribute("form");
        form.setEmployee_no(lForm.getEmployee_no());

        dba.getMonthly_report(form, String.valueOf(KintaiManagement.Cale_Date_Year), String.valueOf(KintaiManagement.Cale_Date_Month));
        List<String> division = form.getDivision();
        List<String> span = form.getSpan();
        List<String>span2=form.getSpan2();
        List<String>remark=form.getRemark();
        List<String>perm=form.getPerm();
        List<String>Mmdd=form.getMmdd();
        List<String>Send_Time=form.getSend_Time();
        List<String> spotcode =form.getSpotcode();

        //spanを配列へ入れる
        int listspan=0;
        String []kintai_s=new String[30];
        for(int Target_day = 0; Target_day < span.size(); Target_day++)
       {
            kintai_s[listspan] = span.get(Target_day);
            listspan++;
       }
        //span2を配列へ入れる
         int listspan2=0;
        String []kintai_s2=new String[30];
        for(int Target_day = 0; Target_day < span2.size(); Target_day++)
       {
            kintai_s2[listspan2] = span2.get(Target_day);
            listspan2++;
       }

        String spotname="";
        String limit="";
        String send="";
        String str_Date = "";

        %>
		<center>
			<h1>勤怠月報画面</h1>
		</center>
		<center>
		<table border="3" bordercolor="#0000ff">
			<tr bgcolor="#87cefa">
			<tr>
				<%-- メンバ変数の月を表示 --%>
				<td><%=KintaiManagement.Cale_Date_Month %>月</td>
				<%
					Chk_flg = true;
					month = String.valueOf(KintaiManagement.Cale_Date_Month) +"";
					year = String.valueOf(KintaiManagement.Cale_Date_Year);
				%>
			</tr>
			<tr>
				<td>/</td>
				<td>届出日</td>
				<td>時刻</td>
				<td>Limit</td>
				<td>連絡遅延</td>
				<td>届出区分</td>
				<td>作業場所</td>
				<td>許可</td>
				<td>備考</td>
			</tr>


			<tr>
				<%
        String dada="";
		cal.set(Integer.parseInt(year), Integer.parseInt(month), 0);
		monthlastDay = cal.getActualMaximum(Calendar.DATE);
         for (int day = 1; day <= monthlastDay; day++) {
             if(month.length()==1)
             {
            	 month="0"+month;
             }
             if(String.valueOf(day).length()==1)
             {
            	 dada="0"+day;
             }
             else
             {
            	 dada=""+day;
             }

                // Chk_flg == trueの場合は現在月を連続表示か確認
				if(Chk_flg == true)
				{
					Year_Data = String.valueOf(KintaiManagement.Cale_Date_Year);
					str_Date = Year_Data + month;
				}
				else if(Chk_flg == false)
				{
					str_Date = year + month;
				}

       int flg=0;
         for(int listnumber=0;listnumber<span.size();listnumber++){

        	 boolean Chk_Selected_Flg = false;
        	 if(kintai_s[listnumber].substring(0,6).equals(str_Date))
        	 {
        		 Chk_Selected_Flg = true;
        	 }
         if(kintai_s[listnumber].substring(6,8).equals(dada)&&flg==0 && Chk_Selected_Flg == true){

        //switch文を使用して企業コードから作業場所とlimitを表示
        switch(spotcode.get(listnumber)){
            case "9-0001":
        	spotname="本社";
        	limit="0830";
        	break;
        	case "9-0002":
        	spotname="大阪事業所";
        	limit="0830";
        	break;
        	case "1-0001":
        	spotname="アルカウェスト（AIU）";
        	limit="0830";
        	break;
        	case "1-0002":
        	spotname="サンシャイン（そんぽ２４）";
        	limit="0830";
        	break;
        	case "1-0003":
        	spotname="上野フジタエステート（えきねっと）";
        	limit="0930";
        	break;
        	case "1-0004":
        	spotname="日生三田ビル";
        	limit="0830";
        	break;
        	case "1-0005":
        	spotname="三鷹高木ビル(システムテスト)";
        	limit="0900";
        	break;
        	case "1-0006":
        	spotname="宝印刷";
        	limit="0900";
        	break;
        	case "1-0007":
        	spotname="紀尾井町パークビル（福利厚生）";
        	limit="0830";
        	break;
        	case "1-0008":
        	spotname="コムシス新横浜";
        	limit="0830";
        	break;
        	case "1-0009":
        	spotname="虎ノ門ヒルズ";
        	limit="0830";
        	break;
        	case "1-0010":
        	spotname="JA川崎(普及)";
        	limit="0830";
        	break;
        	case "1-0011":
        	spotname="武蔵小杉タワープレイス";
        	limit="0830";
        	break;
        	case "1-0012":
        	spotname="ニッセイアロマスクウェア";
        	limit="0830";
        	break;
        	case "1-0013":
        	spotname="三菱電機製作所";
        	limit="0900";
        	break;
        	case "1-0014":
        	spotname="日本ユニシス";
        	limit="0830";
        	break;
        	case "1-0015":
        	spotname="虎ノ門ヒルズ";
        	limit="0930";
        	break;
        	case "1-0016":
        	spotname="蒲田INAビル";
        	limit="0930";
        	break;
        	case "1-0017":
        	spotname="三田NNビル";
        	limit="0830";
        	break;
        	case "1-0018":
        	spotname="府中Jタワー";
        	limit="0830";
        	break;
        	case "1-0019":
        	spotname="三田NNビル";
        	limit="0810";
        	break;
        	case "1-0020":
        	spotname="蒲田アロマスクエア";
        	limit="0930";
        	break;
        	case "1-0021":
        	spotname="リバーサイド読売ビル";
        	limit="0830";
        	break;
        	case "1-0022":
        	spotname="東京ダイヤビルディング";
        	limit="0830";
        	break;
        	case "1-0023":
        	spotname="高崎ルネサス";
        	limit="0800";
        	break;
        	case "1-0024":
        	spotname="イヌイビル";
        	limit="0830";
        	break;
        	case "1-0025":
        	spotname="グラスシティ晴海";
        	limit="0830";
        	break;
        	case "1-0026":
        	spotname="中野セントラルパークサウス";
        	limit="0830";
        	break;
        	case "1-0027":
        	spotname="新光ビルディング日本橋";
        	limit="0810";
        	break;
        	case "1-0028":
        	spotname="ランディック第2新橋ビル";
        	limit="0830";
        	break;
        	case "1-0029":
        	spotname="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "1-0030":
        	spotname="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "1-0031":
        	spotname="オリナスタワー";
        	limit="0830";
        	break;
        	case "1-0032":
        	spotname="日立愛宕別館";
        	limit="0830";
        	break;
        	case "1-0033":
        	spotname="アークヒルズビル";
        	limit="0830";
        	break;
        	case "1-0034":
        	spotname="パナソニック佐江戸事業所";
        	limit="0830";
        	break;
        	case "1-0035":
        	spotname="蒲田アロマスクエア";
        	limit="0900";
        	break;
        	case "1-0036":
        	spotname="蒲田アロマスクエア";
        	limit="0900";
        	break;
        	case "1-0037":
        	spotname="SGシステム";
        	limit="0830";
        	break;
        	case "1-0038":
        	spotname="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0830";
        	break;
        	case "1-0039":
        	spotname="浜松町ビルディング";
        	limit="0900";
        	break;
        	case "1-0040":
        	spotname="アプラス　東京ダイヤビル5号館";
        	limit="0845";
        	break;
        	case "1-0041":
        	spotname="一番町東急ビル";
        	limit="0830";
        	break;
        	case "1-0042":
        	spotname="新宿グリーンタワービル";
        	limit="0930";
        	break;
        	case "1-0043":
        	spotname="浜松町ビルディング";
        	limit="0830";
        	break;
        	case "1-0044":
        	spotname="目白台ビル";
        	limit="0830";
        	break;
        	case "1-0045":
        	spotname="トレードピアお台場";
        	limit="0930";
        	break;
        	case "1-0046":
        	spotname="NRIタワー";
        	limit="0930";
        	break;
        	case "1-0047":
        	spotname="目白台ビル";
        	limit="0810";
        	break;
        	case "2-0001":
        	spotname="日立　戸塚";
        	limit="0815";
        	break;
        	case "2-0002":
        	spotname="横浜西ビル（NSKJひまわり）";
        	limit="0900";
        	break;
        	case "2-0003":
        	spotname="NTTS横浜(IC標準)";
        	limit="0930";
        	break;
        	case "2-0004":
        	spotname="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0005":
        	spotname="ドコモR＆Dセンタ（Cカテゴリ）";
        	limit="0930";
        	break;
        	case "2-0006":
        	spotname="明治安田生命ビル(基盤)";
        	limit="0830";
        	break;
        	case "2-0007":
        	spotname="明治安田生命ビル(アプリ営業)";
        	limit="0830";
        	break;
        	case "2-0008":
        	spotname="明治安田生命ビル(活動基盤)";
        	limit="0830";
        	break;
        	case "2-0009":
        	spotname="JA川崎(普及)";
        	limit="0830";
        	break;
        	case "2-0010":
        	spotname="JA川崎(再構築)";
        	limit="0830";
        	break;
        	case "2-0011":
        	spotname="東京情報センター";
        	limit="0830";
        	break;
        	case "2-0012":
        	spotname="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0013":
        	spotname="NTTS横浜(IC標準)";
        	limit="0930";
        	break;
        	case "2-0014":
        	spotname="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0015":
        	spotname="穴守稲荷(ID)";
        	limit="0900";
        	break;
        	case "2-0016":
        	spotname="FBS（CEQ)";
        	limit="0810";
        	break;
        	case "2-0017":
        	spotname="日新火災";
        	limit="0830";
        	break;
        	case "2-0018":
        	spotname="ｱｸｾｽPF―光ｺﾗﾎﾞ対応/#P#FUTURE_F27-1";
        	limit="0900";
        	break;
        	case "2-0019":
        	spotname="移動機試験";
        	limit="0830";
        	break;
        	case "2-0020":
        	spotname="HiICS戸塚";
        	limit="0815";
        	break;
        	case "2-0021":
        	spotname="コンカード横浜";
        	limit="0830";
        	break;
        	case "2-0022":
        	spotname="三菱電機(湘セン)";
        	limit="0900";
        	break;
        	case "2-0023":
        	spotname="丸の内中央ビル(JR)";
        	limit="0830";
        	break;
        	case "2-0024":
        	spotname="情報総研（大船）";
        	limit="0800";
        	break;
        	case "2-0025":
        	spotname="ワテラスタワー";
        	limit="0830";
        	break;
        	case "2-0026":
        	spotname="コンカード横浜";
        	limit="0815";
        	break;
        	case "2-0027":
        	spotname="神谷町MTビル";
        	limit="0830";
        	break;
        	case "2-0028":
        	spotname="NEC別館ビル";
        	limit="0900";
        	break;
        	case "2-0029":
        	spotname="ソフトバンクテレコム東京イーストセンター";
        	limit="0930";
        	break;
        	case "2-0030":
        	spotname="HIENG戸塚";
        	limit="0815";
        	break;
        	case "2-0031":
        	spotname="コープ共済プラザ";
        	limit="0830";
        	break;
        	case "2-0032":
        	spotname="楽天クリムゾンハウス";
        	limit="0900";
        	break;
        	case "2-0033":
        	spotname="三菱電機鎌倉製作所";
        	limit="0815";
        	break;
        	case "3-0001":
        	spotname="GA多摩ビル（TNK）";
        	limit="0830";
        	break;
        	case "3-0002":
        	spotname="GA多摩ビル（情報H）";
        	limit="0830";
        	break;
        	case "3-0003":
        	spotname="明治安田生命ビル(業務管理)";
        	limit="0845";
        	break;
        	case "3-0004":
        	spotname="明治安田生命ビル(ネットワーク基盤Ｇ)";
        	limit="0830";
        	break;
        	case "3-0005":
        	spotname="明治安田生命ビル(ＢＩ開発営業)";
        	limit="0830";
        	break;
        	case "3-0006":
        	spotname="KSP（富士通）";
        	limit="0820";
        	break;
        	case "3-0007":
        	spotname="三菱電機(鎌電)";
        	limit="0815";
        	break;
        	case "3-0008":
        	spotname="ZENITAKAANNEXビル(三菱電機)";
        	limit="0830";
        	break;
        	case "3-0009":
        	spotname="勝どき（運用）";
        	limit="0930";
        	break;
        	case "3-0010":
        	spotname="マイテクノ新人研修";
        	limit="0830";
        	break;
        	case "3-0011":
        	spotname="イーストネットビル(コープ共済)";
        	limit="0830";
        	break;
        	case "3-0012":
        	spotname="クラフト";
        	limit="0930";
        	break;
        	case "3-0013":
        	spotname="新東京ビル";
        	limit="0830";
        	break;
        	case "3-0014":
        	spotname="東京ファッションタウンビル(みずほ総研)";
        	limit="0810";
        	break;
        	case "3-0015":
        	spotname="芝浦ルネサイトタワー";
        	limit="0830";
        	break;
        	case "3-0016":
        	spotname="コープ共済";
        	limit="0830";
        	break;
        	case "3-0017":
        	spotname="東芝府中";
        	limit="0830";
        	break;
        	case "3-0018":
        	spotname="丸の内一丁目みずほビル";
        	limit="0810";
        	break;
        	case "3-0019":
        	spotname="アークヒルズビル";
        	limit="0930";
        	break;
        	case "3-0020":
        	spotname="横浜東口ウィスポートビル３F";
        	limit="0830";
        	break;
        	case "3-0021":
        	spotname="楽天ビル２号館";
        	limit="0810";
        	break;
        	case "3-0022":
        	spotname="ガーデンシティ品川御殿山";
        	limit="0830";
        	break;
        	case "3-0023":
        	spotname="日新ビル";
        	limit="0830";
        	break;
        	case "3-0024":
        	spotname="新川崎三井ビルディング";
        	limit="0820";
        	break;
        	case "3-0025":
        	spotname="品川アレア";
        	limit="0900";
        	break;
        	case "3-0026":
        	spotname="横浜ビジネスパーク";
        	limit="0830";
        	break;
        	case "3-0027":
        	spotname="NEC玉川事業場ルネッサンスシティN棟";
        	limit="0830";
        	break;
        	case "3-0028":
        	spotname="コープ共済プラザ";
        	limit="0900";
        	break;
        	case "4-0001":
        	spotname="AXA";
        	limit="0830";
        	break;
        	case "4-0002":
        	spotname="NTTDATAビル（航空管制）";
        	limit="0900";
        	break;
        	case "4-0003":
        	spotname="住友ツインビル（NSOL）";
        	limit="0830";
        	break;
        	case "4-0004":
        	spotname="東京電力";
        	limit="0900";
        	break;
        	case "4-0005":
        	spotname="コニカミノルタ";
        	limit="0830";
        	break;
        	case "4-0006":
        	spotname="アルファ2号館";
        	limit="0830";
        	break;
        	case "4-0007":
        	spotname="コムシス";
        	limit="0830";
        	break;
        	case "4-0008":
        	spotname="住友芝浦ビル";
        	limit="0900";
        	break;
        	case "4-0009":
        	spotname="DNP五反田ビル";
        	limit="0830";
        	break;
        	case "4-0010":
        	spotname="パナソニック";
        	limit="0830";
        	break;
        	case "4-0011":
        	spotname="虎ノ門ビル";
        	limit="0830";
        	break;
        	case "4-0012":
        	spotname="井門九段北ビル";
        	limit="0830";
        	break;
        	case "4-0013":
        	spotname="NRIセキュア";
        	limit="0930";
        	break;
        	case "4-0014":
        	spotname="T社向け電力システム開発";
        	limit="0930";
        	break;
        	case "4-0015":
        	spotname="日本HP本社ビル（ドライバー端末アプリ開発）";
        	limit="0930";
        	break;
        	case "4-0016":
        	spotname="日本HP本社ビル（電力システム開発）";
        	limit="0900";
        	break;
        	case "4-0017":
        	spotname="図研　センター南ビル";
        	limit="0830";
        	break;
        	case "4-0018":
        	spotname="NTT横浜山下ビル";
        	limit="0830";
        	break;
        	case "4-0019":
        	spotname="横浜ダイヤビル";
        	limit="0830";
        	break;
        	case "4-0020":
        	spotname="五洋芝浦ビル";
        	limit="0830";
        	break;
        	case "4-0021":
        	spotname="新駿河台ビル";
        	limit="0830";
        	break;
        	case "4-0022":
        	spotname="東京ガーデンテラス紀尾井町";
        	limit="0930";
        	break;
        	case "4-0023":
        	spotname="NRI";
        	limit="0830";
        	break;
        	case "4-0024":
        	spotname="アイマーク";
        	limit="0830";
        	break;
        	case "4-0025":
        	spotname="中島商事ビル";
        	limit="0930";
        	break;
        	case "4-0026":
        	spotname="新東京センター";
        	limit="0930";
        	break;
        	case "4-0027":
        	spotname="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "4-0028":
        	spotname="第３アルファテクノセンター";
        	limit="0830";
        	break;
        	case "4-0029":
        	spotname="mBAYPOINT幕張";
        	limit="0900";
        	break;
        	case "4-0030":
        	spotname="パークタワー";
        	limit="0900";
        	break;
        	case "4-0031":
        	spotname="日本HP本社ビル";
        	limit="0930";
        	break;
        	case "4-0032":
        	spotname="太陽生命浦和ビル";
        	limit="0830";
        	break;
        	case "4-0033":
        	spotname="NTT品川TWINSアネックス";
        	limit="0900";
        	break;
        	case "4-0034":
        	spotname="品川シーサイドサウスタワー";
        	limit="0900";
        	break;
        	case "4-0035":
        	spotname="豊洲フロント";
        	limit="0930";
        	break;
        	case "4-0036":
        	spotname="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0830";
        	break;
        	case "4-0037":
        	spotname="日本HP本社ビル";
        	limit="0900";
        	break;
        	case "4-0038":
        	spotname="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0930";
        	break;
        	case "4-0039":
        	spotname="I・Sビル";
        	limit="0830";
        	break;
        	case "5-0001":
        	spotname="中之島フェスティバルタワー（DKI）";
        	limit="0830";
        	break;
        	case "5-0002":
        	spotname="東京建物梅田ビル（CTC）";
        	limit="0830";
        	break;
        	case "5-0003":
        	spotname="日本流通システム";
        	limit="0830";
        	break;
        	case "5-0004":
        	spotname="オージス総研　千里オフィス";
        	limit="0830";
        	break;
        	case "5-0005":
        	spotname="日本IBM　大阪京橋事業所";
        	limit="0830";
        	break;
        	case "5-0006":
        	spotname="パナソニックスマートファクトリーソリューションズ";
        	limit="0800";
        	break;
        	case "5-0007":
        	spotname="梅田センタービル（NTTﾃﾞｰﾀｾｷｽｲｼｽﾃﾑ）";
        	limit="0900";
        	break;
        	case "5-0008":
        	spotname="新ダイビル（日立ｼｽﾃﾑｽﾞ）";
        	limit="0820";
        	break;
        	case "5-0009":
        	spotname="東洋紡ビル（ｿﾌﾟﾗ）";
        	limit="0830";
        	break;
        	case "5-0010":
        	spotname="新大阪ニッセイビル（住友電工情報ｼｽﾃﾑ）";
        	limit="0800";
        	break;
        	case "5-0011":
        	spotname="大津市役所（日立ｼｽﾃﾑｽﾞ）";
        	limit="0820";
        	break;
        	case "5-0012":
        	spotname="和田岬（三菱電機製作所）";
        	limit="0815";
        	break;
        	case "5-0013":
        	spotname="三井住友信託銀行";
        	limit="0820";
        	break;
        	case "5-0014":
        	spotname="オージス総研千里オフィス";
        	limit="0830";
        	break;
        	case "5-0015":
        	spotname="三井住友信託銀行";
        	limit="0830";
        	break;
        	case "5-0016":
        	spotname="アートヴィレッジ大崎セントラルタワー";
        	limit="0930";
        	break;
        	case "5-0017":
        	spotname="ニッセイアロマスクウェア";
        	limit="0930";
        	break;
        	case "5-0018":
        	spotname="品川シーサイドサウスタワー";
        	limit="0900";
        	break;
        	case "5-0019":
        	spotname="イヌイビル";
        	limit="0830";
        	break;
        	case "5-0020":
        	spotname="SLC";
        	limit="0830";
        	break;
        	case "5-0021":
        	spotname="新大阪ニッセイビル（ニッセイ情報テクノロジー）";
        	limit="0830";
        	break;
        	case "5-0022":
        	spotname="大阪中之島ビル（ｱｸｾﾝﾁｭｱ）";
        	limit="0830";
        	break;
        	case "5-0023":
        	spotname="中之島セントラルタワー";
        	limit="0830";
        	break;
        	case "5-0024":
        	spotname="大阪日興ビル";
        	limit="0830";
        	break;
        	case "5-0025":
        	spotname="北浜東森田ビル";
        	limit="0830";
        	break;
        	case "6-0001":
        	spotname="横浜ダイヤビル（NRI）";
        	limit="0830";
        	break;
        	case "6-0002":
        	spotname="アルカウェスト（AIU）";
        	limit="0830";
        	break;
        	case "6-0003":
        	spotname="日新火災";
        	limit="0830";
        	break;
        	case "6-0004":
        	spotname="住友生命";
        	limit="0820";
        	break;
        	case "6-0005":
        	spotname="イーストネットビル(コープ共済)";
        	limit="0830";
        	break;
        	case "6-0006":
        	spotname="FBS（CEQ)";
        	limit="0810";
        	break;
        	case "6-0007":
        	spotname="三菱電機製作所";
        	limit="0830";
        	break;
        	case "6-0008":
        	spotname="日興システムソリューションズ";
        	limit="0900";
        	break;
        	case "7-0001":
        	spotname="トレードピアお台場";
        	limit="0830";
        	break;
        	case "7-0002":
        	spotname="NTTDOCOMOR&Dセンター２号館";
        	limit="0900";
        	break;
        	case "7-0003":
        	spotname="ソフトバンク";
        	limit="0830";
        	break;
        	case "7-0004":
        	spotname="日立ソリューションズタワー";
        	limit="0830";
        	break;
        	case "7-0005":
        	spotname="SLC";
        	limit="0730";
        	break;
        	case "7-0006":
        	spotname="SLC";
        	limit="0930";
        	break;
        	case "7-0007":
        	spotname="NTT西日本";
        	limit="0830";
        	break;
        	case "7-0008":
        	spotname="オペラシティタワー";
        	limit="0930";
        	break;
        	default:
        	spotname="無効なコードです";
        	limit="9999";
        }


        //無届かどうかをif文で記述
        if(Integer.parseInt(span.get(listnumber).substring(4,8))<=Integer.parseInt(Mmdd.get(listnumber))){
            if(Integer.parseInt(Send_Time.get(listnumber))>Integer.parseInt(limit)){
                send="無届";}else{
                    send="";
                }
        	}else{
        		send="";
        	}
 %>





         <%-- span==span2だった場合--%>
        <%  if(kintai_s[listnumber].substring(6,8).equals(kintai_s2[listnumber].substring(6,8))){%>
				<td><%=dada%>日</td>
				<td><%=Mmdd.get(listnumber).substring(0,2)+"/"+Mmdd.get(listnumber).substring(2,4)%></td>
				<td><%=Send_Time.get(listnumber).substring(0,2)+":"+Send_Time.get(listnumber).substring(2,4)%></td>
				<td><%=limit.substring(0,2)+":"+limit.substring(2,4) %></td>
				<td><%=send %></td>
				<td><%=division.get(listnumber)%></td>
				<td><%=spotname%></td>
				<%
					if(perm.get(listnumber)==null){
				%>
					<td><%=""%></td>
				<%
					}
					else{
				%>
					<td><%=perm.get(listnumber)%></td>
				<%
					}
				%>
				<td><%=remark.get(listnumber)%></td>
			</tr>
			<%
			flg=1;
			break;

			//span<span2だった場合
         }else{
        	 for(int i=Integer.parseInt(kintai_s[listnumber].substring(6,8));i<=(Integer.parseInt(kintai_s2[listnumber].substring(6,8)));i++){%>
 				<td><%=i%>日</td>
 				<td><%=Mmdd.get(listnumber).substring(0,2)+"/"+Mmdd.get(listnumber).substring(2,4)%></td>
 				<td><%=Send_Time.get(listnumber).substring(0,2)+":"+Send_Time.get(listnumber).substring(2,4)%></td>
 				<td><%=limit.substring(0,2)+":"+limit.substring(2,4) %></td>
 				<td><%=send %></td>
 				<td><%=division.get(listnumber)%></td>
 				<td><%=spotname%></td>
 				<%
					if(perm.get(listnumber)==null){
				%>
					<td><%=""%></td>
				<%
					}
					else{
				%>
					<td><%=perm.get(listnumber)%></td>
				<%
					}
				%>
 				<td><%=remark.get(listnumber)%></td>
 			</tr>
 			<%
 			flg=1;
 			day = i;
        	 }
         }
         }
         }
       if(flg==0){%>
    	   <td><%=dada%>日</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
      <% }
            }
        %>


		</table>
		<p style="color:red;">勤怠連絡情報がない場合はエクセル出力できません
		</p>
		</center>

 		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="エクセル出力"
				styleId="MonthlyReportcomp"/>

		</div>
		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="戻る"
				styleId="kintailist" />

		</div>
	</body>
	<%
		Chk_flg = false;
	%>

</html:form>
</html:html>

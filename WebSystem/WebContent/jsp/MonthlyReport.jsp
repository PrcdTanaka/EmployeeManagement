<%@page import="sample.pr.main.MonthlyReportForm"%>
<%@page import="sample.pr.main.MonthlyReportAction"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="sample.pr.main.LoginForm"%>
<%@ page import="sample.pr.main.MonthlyReportForm"%>
<%@ page import="sample.pr.main.MainForm"%>
<%@ page import="sample.ap.DbAction"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String" %>
<%@ page import="java.lang.StringBuffer" %>

<html:html>
<head>
<html lang="ja">
<link rel="stylesheet" type="text/css" href="/WebSystem/css/style.css">
</head>
<html:form action="/MonthlyReportAction">
	<%!
		boolean Chk_flg = false;
		boolean month_flg = true;
		String Year_Data = "";
  		String Month_Data = "";
	%>
	<body>
		<%
        MonthlyReportForm form=new MonthlyReportForm();
        Calendar cal = Calendar.getInstance();
        String year = (cal.get(cal.YEAR))+"";
        String month=(cal.get(cal.MONTH)+1)+"";
        int monthlastDay = cal.getActualMaximum(Calendar.DATE);
        DbAction dba = new DbAction();
        LoginForm lForm=(LoginForm)session.getAttribute("form");
        form.setEmployee_no(lForm.getEmployee_no());

        dba.getMonthly_report(form);
        List<String> division = form.getDivision();
        List<String> span = form.getSpan();
        List<String>span2=form.getSpan2();
        List<String>remark=form.getRemark();
        List<String>perm=form.getPerm();
        List<String>Mmdd=form.getMmdd();
        List<String>Send_Time=form.getSend_Time();
        List<String> spotcode =form.getSpotcode();


        String link1 = "http://localhost:8080/WebSystem/KintaiListAction.do";


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

        String a="";
        String limit="";
        String send="";

        %>
		 <%
	 		// 前の画面よりリンク取得し、月に反映させる
	 		String str_Date = "";
			StringBuffer sb = new StringBuffer();
			sb.append(new String(request.getHeader("REFERER")));

			String BeforeUrl = sb.substring(51);
			if(BeforeUrl.equals("null"))
			{
				month_flg = false;
			}
			else if(BeforeUrl.isEmpty())
			{
				month_flg = false;
			}
			else if(BeforeUrl.substring(0, 5).equals("year="))
			{
				if(month_flg == true || Chk_flg == false)
				{
					String[] lBeforeUrl1 = new String[1];
					lBeforeUrl1 = BeforeUrl.split("year=", 0);
					String[] lBeforeUrl2 = new String[1];
					lBeforeUrl2 = lBeforeUrl1[1].split("&month=", 0);
					Year_Data = lBeforeUrl2[0];
					Month_Data = lBeforeUrl2[1];

					month_flg = true;
				}
			}
			else
			{
				month_flg = false;
			}

		%>
		<center>
			<h1>勤怠月報画面</h1>
		</center>
		<table border="3" bordercolor="#0000ff">
			<tr bgcolor="#87cefa">
			<tr>
				<%
					if(month_flg == false){
				%>
					<td><%=month %>月</td>
				<%
					}
					else if(month_flg == true){
				%>
					<td><%=Month_Data %>月</td>
				<%
					Chk_flg = true;
					month = Month_Data +"";
					}
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
         for (int day = 1; day <= monthlastDay; day++) {
             if(month.length()==1)
                    month="0"+month;
                 if(String.valueOf(day).length()==1)
                     dada="0"+day;
                 else
                     dada=""+day;

                // カレンダーから呼び出された時は、次の処理をする。
				if(Chk_flg == true)
				{
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
        	a="本社";
        	limit="0830";
        	break;
        	case "9-0002":
        	a="大阪事業所";
        	limit="0830";
        	break;
        	case "1-0001":
        	a="アルカウェスト（AIU）";
        	limit="0830";
        	break;
        	case "1-0002":
        	a="サンシャイン（そんぽ２４）";
        	limit="0830";
        	break;
        	case "1-0003":
        	a="上野フジタエステート（えきねっと）";
        	limit="0930";
        	break;
        	case "1-0004":
        	a="日生三田ビル";
        	limit="0830";
        	break;
        	case "1-0005":
        	a="三鷹高木ビル(システムテスト)";
        	limit="0900";
        	break;
        	case "1-0006":
        	a="宝印刷";
        	limit="0900";
        	break;
        	case "1-0007":
        	a="紀尾井町パークビル（福利厚生）";
        	limit="0830";
        	break;
        	case "1-0008":
        	a="コムシス新横浜";
        	limit="0830";
        	break;
        	case "1-0009":
        	a="虎ノ門ヒルズ";
        	limit="0830";
        	break;
        	case "1-0010":
        	a="JA川崎(普及)";
        	limit="0830";
        	break;
        	case "1-0011":
        	a="武蔵小杉タワープレイス";
        	limit="0830";
        	break;
        	case "1-0012":
        	a="ニッセイアロマスクウェア";
        	limit="0830";
        	break;
        	case "1-0013":
        	a="三菱電機製作所";
        	limit="0900";
        	break;
        	case "1-0014":
        	a="日本ユニシス";
        	limit="0830";
        	break;
        	case "1-0015":
        	a="虎ノ門ヒルズ";
        	limit="0930";
        	break;
        	case "1-0016":
        	a="蒲田INAビル";
        	limit="0930";
        	break;
        	case "1-0017":
        	a="三田NNビル";
        	limit="0830";
        	break;
        	case "1-0018":
        	a="府中Jタワー";
        	limit="0830";
        	break;
        	case "1-0019":
        	a="三田NNビル";
        	limit="0810";
        	break;
        	case "1-0020":
        	a="蒲田アロマスクエア";
        	limit="0930";
        	break;
        	case "1-0021":
        	a="リバーサイド読売ビル";
        	limit="0830";
        	break;
        	case "1-0022":
        	a="東京ダイヤビルディング";
        	limit="0830";
        	break;
        	case "1-0023":
        	a="高崎ルネサス";
        	limit="0800";
        	break;
        	case "1-0024":
        	a="イヌイビル";
        	limit="0830";
        	break;
        	case "1-0025":
        	a="グラスシティ晴海";
        	limit="0830";
        	break;
        	case "1-0026":
        	a="中野セントラルパークサウス";
        	limit="0830";
        	break;
        	case "1-0027":
        	a="新光ビルディング日本橋";
        	limit="0810";
        	break;
        	case "1-0028":
        	a="ランディック第2新橋ビル";
        	limit="0830";
        	break;
        	case "1-0029":
        	a="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "1-0030":
        	a="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "1-0031":
        	a="オリナスタワー";
        	limit="0830";
        	break;
        	case "1-0032":
        	a="日立愛宕別館";
        	limit="0830";
        	break;
        	case "1-0033":
        	a="アークヒルズビル";
        	limit="0830";
        	break;
        	case "1-0034":
        	a="パナソニック佐江戸事業所";
        	limit="0830";
        	break;
        	case "1-0035":
        	a="蒲田アロマスクエア";
        	limit="0900";
        	break;
        	case "1-0036":
        	a="蒲田アロマスクエア";
        	limit="0900";
        	break;
        	case "1-0037":
        	a="SGシステム";
        	limit="0830";
        	break;
        	case "1-0038":
        	a="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0830";
        	break;
        	case "1-0039":
        	a="浜松町ビルディング";
        	limit="0900";
        	break;
        	case "1-0040":
        	a="アプラス　東京ダイヤビル5号館";
        	limit="0845";
        	break;
        	case "1-0041":
        	a="一番町東急ビル";
        	limit="0830";
        	break;
        	case "1-0042":
        	a="新宿グリーンタワービル";
        	limit="0930";
        	break;
        	case "1-0043":
        	a="浜松町ビルディング";
        	limit="0830";
        	break;
        	case "1-0044":
        	a="目白台ビル";
        	limit="0830";
        	break;
        	case "1-0045":
        	a="トレードピアお台場";
        	limit="0930";
        	break;
        	case "1-0046":
        	a="NRIタワー";
        	limit="0930";
        	break;
        	case "1-0047":
        	a="目白台ビル";
        	limit="0810";
        	break;
        	case "2-0001":
        	a="日立　戸塚";
        	limit="0815";
        	break;
        	case "2-0002":
        	a="横浜西ビル（NSKJひまわり）";
        	limit="0900";
        	break;
        	case "2-0003":
        	a="NTTS横浜(IC標準)";
        	limit="0930";
        	break;
        	case "2-0004":
        	a="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0005":
        	a="ドコモR＆Dセンタ（Cカテゴリ）";
        	limit="0930";
        	break;
        	case "2-0006":
        	a="明治安田生命ビル(基盤)";
        	limit="0830";
        	break;
        	case "2-0007":
        	a="明治安田生命ビル(アプリ営業)";
        	limit="0830";
        	break;
        	case "2-0008":
        	a="明治安田生命ビル(活動基盤)";
        	limit="0830";
        	break;
        	case "2-0009":
        	a="JA川崎(普及)";
        	limit="0830";
        	break;
        	case "2-0010":
        	a="JA川崎(再構築)";
        	limit="0830";
        	break;
        	case "2-0011":
        	a="東京情報センター";
        	limit="0830";
        	break;
        	case "2-0012":
        	a="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0013":
        	a="NTTS横浜(IC標準)";
        	limit="0930";
        	break;
        	case "2-0014":
        	a="NTTS横浜(OCN)";
        	limit="0830";
        	break;
        	case "2-0015":
        	a="穴守稲荷(ID)";
        	limit="0900";
        	break;
        	case "2-0016":
        	a="FBS（CEQ)";
        	limit="0810";
        	break;
        	case "2-0017":
        	a="日新火災";
        	limit="0830";
        	break;
        	case "2-0018":
        	a="ｱｸｾｽPF―光ｺﾗﾎﾞ対応/#P#FUTURE_F27-1";
        	limit="0900";
        	break;
        	case "2-0019":
        	a="移動機試験";
        	limit="0830";
        	break;
        	case "2-0020":
        	a="HiICS戸塚";
        	limit="0815";
        	break;
        	case "2-0021":
        	a="コンカード横浜";
        	limit="0830";
        	break;
        	case "2-0022":
        	a="三菱電機(湘セン)";
        	limit="0900";
        	break;
        	case "2-0023":
        	a="丸の内中央ビル(JR)";
        	limit="0830";
        	break;
        	case "2-0024":
        	a="情報総研（大船）";
        	limit="0800";
        	break;
        	case "2-0025":
        	a="ワテラスタワー";
        	limit="0830";
        	break;
        	case "2-0026":
        	a="コンカード横浜";
        	limit="0815";
        	break;
        	case "2-0027":
        	a="神谷町MTビル";
        	limit="0830";
        	break;
        	case "2-0028":
        	a="NEC別館ビル";
        	limit="0900";
        	break;
        	case "2-0029":
        	a="ソフトバンクテレコム東京イーストセンター";
        	limit="0930";
        	break;
        	case "2-0030":
        	a="HIENG戸塚";
        	limit="0815";
        	break;
        	case "2-0031":
        	a="コープ共済プラザ";
        	limit="0830";
        	break;
        	case "2-0032":
        	a="楽天クリムゾンハウス";
        	limit="0900";
        	break;
        	case "2-0033":
        	a="三菱電機鎌倉製作所";
        	limit="0815";
        	break;
        	case "3-0001":
        	a="GA多摩ビル（TNK）";
        	limit="0830";
        	break;
        	case "3-0002":
        	a="GA多摩ビル（情報H）";
        	limit="0830";
        	break;
        	case "3-0003":
        	a="明治安田生命ビル(業務管理)";
        	limit="0845";
        	break;
        	case "3-0004":
        	a="明治安田生命ビル(ネットワーク基盤Ｇ)";
        	limit="0830";
        	break;
        	case "3-0005":
        	a="明治安田生命ビル(ＢＩ開発営業)";
        	limit="0830";
        	break;
        	case "3-0006":
        	a="KSP（富士通）";
        	limit="0820";
        	break;
        	case "3-0007":
        	a="三菱電機(鎌電)";
        	limit="0815";
        	break;
        	case "3-0008":
        	a="ZENITAKAANNEXビル(三菱電機)";
        	limit="0830";
        	break;
        	case "3-0009":
        	a="勝どき（運用）";
        	limit="0930";
        	break;
        	case "3-0010":
        	a="マイテクノ新人研修";
        	limit="0830";
        	break;
        	case "3-0011":
        	a="イーストネットビル(コープ共済)";
        	limit="0830";
        	break;
        	case "3-0012":
        	a="クラフト";
        	limit="0930";
        	break;
        	case "3-0013":
        	a="新東京ビル";
        	limit="0830";
        	break;
        	case "3-0014":
        	a="東京ファッションタウンビル(みずほ総研)";
        	limit="0810";
        	break;
        	case "3-0015":
        	a="芝浦ルネサイトタワー";
        	limit="0830";
        	break;
        	case "3-0016":
        	a="コープ共済";
        	limit="0830";
        	break;
        	case "3-0017":
        	a="東芝府中";
        	limit="0830";
        	break;
        	case "3-0018":
        	a="丸の内一丁目みずほビル";
        	limit="0810";
        	break;
        	case "3-0019":
        	a="アークヒルズビル";
        	limit="0930";
        	break;
        	case "3-0020":
        	a="横浜東口ウィスポートビル３F";
        	limit="0830";
        	break;
        	case "3-0021":
        	a="楽天ビル２号館";
        	limit="0810";
        	break;
        	case "3-0022":
        	a="ガーデンシティ品川御殿山";
        	limit="0830";
        	break;
        	case "3-0023":
        	a="日新ビル";
        	limit="0830";
        	break;
        	case "3-0024":
        	a="新川崎三井ビルディング";
        	limit="0820";
        	break;
        	case "3-0025":
        	a="品川アレア";
        	limit="0900";
        	break;
        	case "3-0026":
        	a="横浜ビジネスパーク";
        	limit="0830";
        	break;
        	case "3-0027":
        	a="NEC玉川事業場ルネッサンスシティN棟";
        	limit="0830";
        	break;
        	case "3-0028":
        	a="コープ共済プラザ";
        	limit="0900";
        	break;
        	case "4-0001":
        	a="AXA";
        	limit="0830";
        	break;
        	case "4-0002":
        	a="NTTDATAビル（航空管制）";
        	limit="0900";
        	break;
        	case "4-0003":
        	a="住友ツインビル（NSOL）";
        	limit="0830";
        	break;
        	case "4-0004":
        	a="東京電力";
        	limit="0900";
        	break;
        	case "4-0005":
        	a="コニカミノルタ";
        	limit="0830";
        	break;
        	case "4-0006":
        	a="アルファ2号館";
        	limit="0830";
        	break;
        	case "4-0007":
        	a="コムシス";
        	limit="0830";
        	break;
        	case "4-0008":
        	a="住友芝浦ビル";
        	limit="0900";
        	break;
        	case "4-0009":
        	a="DNP五反田ビル";
        	limit="0830";
        	break;
        	case "4-0010":
        	a="パナソニック";
        	limit="0830";
        	break;
        	case "4-0011":
        	a="虎ノ門ビル";
        	limit="0830";
        	break;
        	case "4-0012":
        	a="井門九段北ビル";
        	limit="0830";
        	break;
        	case "4-0013":
        	a="NRIセキュア";
        	limit="0930";
        	break;
        	case "4-0014":
        	a="T社向け電力システム開発";
        	limit="0930";
        	break;
        	case "4-0015":
        	a="日本HP本社ビル（ドライバー端末アプリ開発）";
        	limit="0930";
        	break;
        	case "4-0016":
        	a="日本HP本社ビル（電力システム開発）";
        	limit="0900";
        	break;
        	case "4-0017":
        	a="図研　センター南ビル";
        	limit="0830";
        	break;
        	case "4-0018":
        	a="NTT横浜山下ビル";
        	limit="0830";
        	break;
        	case "4-0019":
        	a="横浜ダイヤビル";
        	limit="0830";
        	break;
        	case "4-0020":
        	a="五洋芝浦ビル";
        	limit="0830";
        	break;
        	case "4-0021":
        	a="新駿河台ビル";
        	limit="0830";
        	break;
        	case "4-0022":
        	a="東京ガーデンテラス紀尾井町";
        	limit="0930";
        	break;
        	case "4-0023":
        	a="NRI";
        	limit="0830";
        	break;
        	case "4-0024":
        	a="アイマーク";
        	limit="0830";
        	break;
        	case "4-0025":
        	a="中島商事ビル";
        	limit="0930";
        	break;
        	case "4-0026":
        	a="新東京センター";
        	limit="0930";
        	break;
        	case "4-0027":
        	a="新宿ガーデンタワー";
        	limit="0830";
        	break;
        	case "4-0028":
        	a="第３アルファテクノセンター";
        	limit="0830";
        	break;
        	case "4-0029":
        	a="mBAYPOINT幕張";
        	limit="0900";
        	break;
        	case "4-0030":
        	a="パークタワー";
        	limit="0900";
        	break;
        	case "4-0031":
        	a="日本HP本社ビル";
        	limit="0930";
        	break;
        	case "4-0032":
        	a="太陽生命浦和ビル";
        	limit="0830";
        	break;
        	case "4-0033":
        	a="NTT品川TWINSアネックス";
        	limit="0900";
        	break;
        	case "4-0034":
        	a="品川シーサイドサウスタワー";
        	limit="0900";
        	break;
        	case "4-0035":
        	a="豊洲フロント";
        	limit="0930";
        	break;
        	case "4-0036":
        	a="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0830";
        	break;
        	case "4-0037":
        	a="日本HP本社ビル";
        	limit="0900";
        	break;
        	case "4-0038":
        	a="KDX晴海ビル，晴海トリトンスクエア";
        	limit="0930";
        	break;
        	case "4-0039":
        	a="I・Sビル";
        	limit="0830";
        	break;
        	case "5-0001":
        	a="中之島フェスティバルタワー（DKI）";
        	limit="0830";
        	break;
        	case "5-0002":
        	a="東京建物梅田ビル（CTC）";
        	limit="0830";
        	break;
        	case "5-0003":
        	a="日本流通システム";
        	limit="0830";
        	break;
        	case "5-0004":
        	a="オージス総研　千里オフィス";
        	limit="0830";
        	break;
        	case "5-0005":
        	a="日本IBM　大阪京橋事業所";
        	limit="0830";
        	break;
        	case "5-0006":
        	a="パナソニックスマートファクトリーソリューションズ";
        	limit="0800";
        	break;
        	case "5-0007":
        	a="梅田センタービル（NTTﾃﾞｰﾀｾｷｽｲｼｽﾃﾑ）";
        	limit="0900";
        	break;
        	case "5-0008":
        	a="新ダイビル（日立ｼｽﾃﾑｽﾞ）";
        	limit="0820";
        	break;
        	case "5-0009":
        	a="東洋紡ビル（ｿﾌﾟﾗ）";
        	limit="0830";
        	break;
        	case "5-0010":
        	a="新大阪ニッセイビル（住友電工情報ｼｽﾃﾑ）";
        	limit="0800";
        	break;
        	case "5-0011":
        	a="大津市役所（日立ｼｽﾃﾑｽﾞ）";
        	limit="0820";
        	break;
        	case "5-0012":
        	a="和田岬（三菱電機製作所）";
        	limit="0815";
        	break;
        	case "5-0013":
        	a="三井住友信託銀行";
        	limit="0820";
        	break;
        	case "5-0014":
        	a="オージス総研千里オフィス";
        	limit="0830";
        	break;
        	case "5-0015":
        	a="三井住友信託銀行";
        	limit="0830";
        	break;
        	case "5-0016":
        	a="アートヴィレッジ大崎セントラルタワー";
        	limit="0930";
        	break;
        	case "5-0017":
        	a="ニッセイアロマスクウェア";
        	limit="0930";
        	break;
        	case "5-0018":
        	a="品川シーサイドサウスタワー";
        	limit="0900";
        	break;
        	case "5-0019":
        	a="イヌイビル";
        	limit="0830";
        	break;
        	case "5-0020":
        	a="SLC";
        	limit="0830";
        	break;
        	case "5-0021":
        	a="新大阪ニッセイビル（ニッセイ情報テクノロジー）";
        	limit="0830";
        	break;
        	case "5-0022":
        	a="大阪中之島ビル（ｱｸｾﾝﾁｭｱ）";
        	limit="0830";
        	break;
        	case "5-0023":
        	a="中之島セントラルタワー";
        	limit="0830";
        	break;
        	case "5-0024":
        	a="大阪日興ビル";
        	limit="0830";
        	break;
        	case "5-0025":
        	a="北浜東森田ビル";
        	limit="0830";
        	break;
        	case "6-0001":
        	a="横浜ダイヤビル（NRI）";
        	limit="0830";
        	break;
        	case "6-0002":
        	a="アルカウェスト（AIU）";
        	limit="0830";
        	break;
        	case "6-0003":
        	a="日新火災";
        	limit="0830";
        	break;
        	case "6-0004":
        	a="住友生命";
        	limit="0820";
        	break;
        	case "6-0005":
        	a="イーストネットビル(コープ共済)";
        	limit="0830";
        	break;
        	case "6-0006":
        	a="FBS（CEQ)";
        	limit="0810";
        	break;
        	case "6-0007":
        	a="三菱電機製作所";
        	limit="0830";
        	break;
        	case "6-0008":
        	a="日興システムソリューションズ";
        	limit="0900";
        	break;
        	case "7-0001":
        	a="トレードピアお台場";
        	limit="0830";
        	break;
        	case "7-0002":
        	a="NTTDOCOMOR&Dセンター２号館";
        	limit="0900";
        	break;
        	case "7-0003":
        	a="ソフトバンク";
        	limit="0830";
        	break;
        	case "7-0004":
        	a="日立ソリューションズタワー";
        	limit="0830";
        	break;
        	case "7-0005":
        	a="SLC";
        	limit="0730";
        	break;
        	case "7-0006":
        	a="SLC";
        	limit="0930";
        	break;
        	case "7-0007":
        	a="NTT西日本";
        	limit="0830";
        	break;
        	case "7-0008":
        	a="オペラシティタワー";
        	limit="0930";
        	break;
        	default:
        	a="無効なコードです";
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
				<td><%=Mmdd.get(listnumber)%></td>
				<td><%=Send_Time.get(listnumber)%></td>
				<td><%=limit %></td>
				<td><%=send %></td>
				<td><%=division.get(listnumber)%></td>
				<td><%=a%></td>
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
 				<td><%=Mmdd.get(listnumber)%></td>
 				<td><%=Send_Time.get(listnumber)%></td>
 				<td><%=limit %></td>
 				<td><%=send %></td>
 				<td><%=division.get(listnumber)%></td>
 				<td><%=a%></td>
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
		</center>
<%-- 		<div style="position: relative; margin-top: 5%; align: center;">
			<html:submit property="button" styleClass="btn" value="保存"
				styleId="MonthlyReport" />
		</div> --%>
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

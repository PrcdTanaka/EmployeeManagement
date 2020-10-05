package sample.pr.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public class MonthlyReportAction extends Action {

	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;
	public static boolean OutputFlg = false;
	// カンマ
	private static final String COMMA = ",";
	// 改行
	private static final String NEW_LINE = "\r\n";

	public MonthlyReportAction() throws IOException {
	}

	String button;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MonthlyReportForm kForm = (MonthlyReportForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		kForm.setEmployee_no(lForm.getEmployee_no());
		forward = "MonthlyReport";
		String button = kForm.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "kintailist";
				session.removeAttribute("kForm");
			} else if (button.equals("保存")) {
				forward = "MonthlyReport";
				session.setAttribute("kform", kForm);
				boolean chkflg = Output_Csv(kForm, request);
				if (chkflg == true) {
					System.out.println("CSVファイル出力完了");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("kForm");
		return map.findForward(forward);
	}

	public boolean Output_Csv(MonthlyReportForm kForm,
			HttpServletRequest request) throws IOException {

		// カレンダークラスを取得
		Calendar cal = Calendar.getInstance();
		String year = (cal.get(cal.YEAR)) + "";
		String month = (cal.get(cal.MONTH) + 1) + "";
		int monthlastDay = cal.getActualMaximum(Calendar.DATE);

		// Monthly_reportのDB情報取得
		dba.getMonthly_report(kForm,String.valueOf(KintaiManagement.Cale_Date_Year),String.valueOf(KintaiManagement.Cale_Date_Month));

		// リスト化を行う
		ArrayList<String> MForm = new ArrayList<String>();
		List<String> mmdd = kForm.getMmdd();
		List<String> send_time = kForm.getSend_Time();
		List<String> division = kForm.getDivision();
		List<String> spotcode = kForm.getSpotcode();
		List<String> perm = kForm.getPerm();
		List<String> remark = kForm.getRemark();
		List<String> span = kForm.getSpan();
		List<String> span2 = kForm.getSpan2();

		MForm.addAll(mmdd);
		MForm.addAll(send_time);
		MForm.addAll(division);
		MForm.addAll(spotcode);
		MForm.addAll(perm);
		MForm.addAll(remark);
		MForm.addAll(span);
		MForm.addAll(span2);
		FileWriter fileWriter = null;

		// 現場名
		String a = "";
		// limit
		String limit = "";
		// 無届かどうか
		String send = "";

		// spanを配列へ入れる
		int listspan = 0;
		String[] kintai_s = new String[30];
		for (int Target_day = 0; Target_day < span.size(); Target_day++) {
			kintai_s[listspan] = span.get(Target_day);
			listspan++;
		}
		// span2を配列へ入れる
		int listspan2 = 0;
		String[] kintai_s2 = new String[30];
		for (int Target_day = 0; Target_day < span2.size(); Target_day++) {
			kintai_s2[listspan2] = span2.get(Target_day);
			listspan2++;
		}

		try {

			fileWriter = new FileWriter("C:\\kintaiExcel\\person.txt");
			request.setCharacterEncoding("UTF-8");

			fileWriter.append("/");
			fileWriter.append(COMMA);
			fileWriter.append("届出日");
			fileWriter.append(COMMA);
			fileWriter.append("時刻");
			fileWriter.append(COMMA);
			fileWriter.append("Limit");
			fileWriter.append(COMMA);
			fileWriter.append("連絡遅延");
			fileWriter.append(COMMA);
			fileWriter.append("届出区分");
			fileWriter.append(COMMA);
			fileWriter.append("作業場所");
			fileWriter.append(COMMA);
			fileWriter.append("許可");
			fileWriter.append(COMMA);
			fileWriter.append("備考");
			fileWriter.append(COMMA);
			fileWriter.append(NEW_LINE);

			// リストの内容を順に処理
			String dada = "";
			cal.set(Integer.parseInt(year), Integer.parseInt(month), 0);
			monthlastDay = cal.getActualMaximum(Calendar.DATE);
			for (int day = 1; day <= monthlastDay; day++) {
				if (month.length() == 1) {
					month = "0" + month;
				}
				if (String.valueOf(day).length() == 1) {
					dada = "0" + day;
				} else {
					dada = "" + day;
				}
				int flg = 0;
				for (int i = 0; i < mmdd.size(); i++) {
					if (kintai_s[i].substring(6, 8).equals(dada) && flg == 0) {

						// 現場コードからlimit,現場名を取得
						switch (spotcode.get(i)) {
						case "9-0001":
							a = "本社";
							limit = "0830";
							break;
						case "9-0002":
							a = "大阪事業所";
							limit = "0830";
							break;
						case "1-0001":
							a = "アルカウェスト（AIU）";
							limit = "0830";
							break;
						case "1-0002":
							a = "サンシャイン（そんぽ２４）";
							limit = "0830";
							break;
						case "1-0003":
							a = "上野フジタエステート（えきねっと）";
							limit = "0930";
							break;
						case "1-0004":
							a = "日生三田ビル";
							limit = "0830";
							break;
						case "1-0005":
							a = "三鷹高木ビル(システムテスト)";
							limit = "0900";
							break;
						case "1-0006":
							a = "宝印刷";
							limit = "0900";
							break;
						case "1-0007":
							a = "紀尾井町パークビル（福利厚生）";
							limit = "0830";
							break;
						case "1-0008":
							a = "コムシス新横浜";
							limit = "0830";
							break;
						case "1-0009":
							a = "虎ノ門ヒルズ";
							limit = "0830";
							break;
						case "1-0010":
							a = "JA川崎(普及)";
							limit = "0830";
							break;
						case "1-0011":
							a = "武蔵小杉タワープレイス";
							limit = "0830";
							break;
						case "1-0012":
							a = "ニッセイアロマスクウェア";
							limit = "0830";
							break;
						case "1-0013":
							a = "三菱電機製作所";
							limit = "0900";
							break;
						case "1-0014":
							a = "日本ユニシス";
							limit = "0830";
							break;
						case "1-0015":
							a = "虎ノ門ヒルズ";
							limit = "0930";
							break;
						case "1-0016":
							a = "蒲田INAビル";
							limit = "0930";
							break;
						case "1-0017":
							a = "三田NNビル";
							limit = "0830";
							break;
						case "1-0018":
							a = "府中Jタワー";
							limit = "0830";
							break;
						case "1-0019":
							a = "三田NNビル";
							limit = "0810";
							break;
						case "1-0020":
							a = "蒲田アロマスクエア";
							limit = "0930";
							break;
						case "1-0021":
							a = "リバーサイド読売ビル";
							limit = "0830";
							break;
						case "1-0022":
							a = "東京ダイヤビルディング";
							limit = "0830";
							break;
						case "1-0023":
							a = "高崎ルネサス";
							limit = "0800";
							break;
						case "1-0024":
							a = "イヌイビル";
							limit = "0830";
							break;
						case "1-0025":
							a = "グラスシティ晴海";
							limit = "0830";
							break;
						case "1-0026":
							a = "中野セントラルパークサウス";
							limit = "0830";
							break;
						case "1-0027":
							a = "新光ビルディング日本橋";
							limit = "0810";
							break;
						case "1-0028":
							a = "ランディック第2新橋ビル";
							limit = "0830";
							break;
						case "1-0029":
							a = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "1-0030":
							a = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "1-0031":
							a = "オリナスタワー";
							limit = "0830";
							break;
						case "1-0032":
							a = "日立愛宕別館";
							limit = "0830";
							break;
						case "1-0033":
							a = "アークヒルズビル";
							limit = "0830";
							break;
						case "1-0034":
							a = "パナソニック佐江戸事業所";
							limit = "0830";
							break;
						case "1-0035":
							a = "蒲田アロマスクエア";
							limit = "0900";
							break;
						case "1-0036":
							a = "蒲田アロマスクエア";
							limit = "0900";
							break;
						case "1-0037":
							a = "SGシステム";
							limit = "0830";
							break;
						case "1-0038":
							a = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0830";
							break;
						case "1-0039":
							a = "浜松町ビルディング";
							limit = "0900";
							break;
						case "1-0040":
							a = "アプラス　東京ダイヤビル5号館";
							limit = "0845";
							break;
						case "1-0041":
							a = "一番町東急ビル";
							limit = "0830";
							break;
						case "1-0042":
							a = "新宿グリーンタワービル";
							limit = "0930";
							break;
						case "1-0043":
							a = "浜松町ビルディング";
							limit = "0830";
							break;
						case "1-0044":
							a = "目白台ビル";
							limit = "0830";
							break;
						case "1-0045":
							a = "トレードピアお台場";
							limit = "0930";
							break;
						case "1-0046":
							a = "NRIタワー";
							limit = "0930";
							break;
						case "1-0047":
							a = "目白台ビル";
							limit = "0810";
							break;
						case "2-0001":
							a = "日立　戸塚";
							limit = "0815";
							break;
						case "2-0002":
							a = "横浜西ビル（NSKJひまわり）";
							limit = "0900";
							break;
						case "2-0003":
							a = "NTTS横浜(IC標準)";
							limit = "0930";
							break;
						case "2-0004":
							a = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0005":
							a = "ドコモR＆Dセンタ（Cカテゴリ）";
							limit = "0930";
							break;
						case "2-0006":
							a = "明治安田生命ビル(基盤)";
							limit = "0830";
							break;
						case "2-0007":
							a = "明治安田生命ビル(アプリ営業)";
							limit = "0830";
							break;
						case "2-0008":
							a = "明治安田生命ビル(活動基盤)";
							limit = "0830";
							break;
						case "2-0009":
							a = "JA川崎(普及)";
							limit = "0830";
							break;
						case "2-0010":
							a = "JA川崎(再構築)";
							limit = "0830";
							break;
						case "2-0011":
							a = "東京情報センター";
							limit = "0830";
							break;
						case "2-0012":
							a = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0013":
							a = "NTTS横浜(IC標準)";
							limit = "0930";
							break;
						case "2-0014":
							a = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0015":
							a = "穴守稲荷(ID)";
							limit = "0900";
							break;
						case "2-0016":
							a = "FBS（CEQ)";
							limit = "0810";
							break;
						case "2-0017":
							a = "日新火災";
							limit = "0830";
							break;
						case "2-0018":
							a = "ｱｸｾｽPF―光ｺﾗﾎﾞ対応/#P#FUTURE_F27-1";
							limit = "0900";
							break;
						case "2-0019":
							a = "移動機試験";
							limit = "0830";
							break;
						case "2-0020":
							a = "HiICS戸塚";
							limit = "0815";
							break;
						case "2-0021":
							a = "コンカード横浜";
							limit = "0830";
							break;
						case "2-0022":
							a = "三菱電機(湘セン)";
							limit = "0900";
							break;
						case "2-0023":
							a = "丸の内中央ビル(JR)";
							limit = "0830";
							break;
						case "2-0024":
							a = "情報総研（大船）";
							limit = "0800";
							break;
						case "2-0025":
							a = "ワテラスタワー";
							limit = "0830";
							break;
						case "2-0026":
							a = "コンカード横浜";
							limit = "0815";
							break;
						case "2-0027":
							a = "神谷町MTビル";
							limit = "0830";
							break;
						case "2-0028":
							a = "NEC別館ビル";
							limit = "0900";
							break;
						case "2-0029":
							a = "ソフトバンクテレコム東京イーストセンター";
							limit = "0930";
							break;
						case "2-0030":
							a = "HIENG戸塚";
							limit = "0815";
							break;
						case "2-0031":
							a = "コープ共済プラザ";
							limit = "0830";
							break;
						case "2-0032":
							a = "楽天クリムゾンハウス";
							limit = "0900";
							break;
						case "2-0033":
							a = "三菱電機鎌倉製作所";
							limit = "0815";
							break;
						case "3-0001":
							a = "GA多摩ビル（TNK）";
							limit = "0830";
							break;
						case "3-0002":
							a = "GA多摩ビル（情報H）";
							limit = "0830";
							break;
						case "3-0003":
							a = "明治安田生命ビル(業務管理)";
							limit = "0845";
							break;
						case "3-0004":
							a = "明治安田生命ビル(ネットワーク基盤Ｇ)";
							limit = "0830";
							break;
						case "3-0005":
							a = "明治安田生命ビル(ＢＩ開発営業)";
							limit = "0830";
							break;
						case "3-0006":
							a = "KSP（富士通）";
							limit = "0820";
							break;
						case "3-0007":
							a = "三菱電機(鎌電)";
							limit = "0815";
							break;
						case "3-0008":
							a = "ZENITAKAANNEXビル(三菱電機)";
							limit = "0830";
							break;
						case "3-0009":
							a = "勝どき（運用）";
							limit = "0930";
							break;
						case "3-0010":
							a = "マイテクノ新人研修";
							limit = "0830";
							break;
						case "3-0011":
							a = "イーストネットビル(コープ共済)";
							limit = "0830";
							break;
						case "3-0012":
							a = "クラフト";
							limit = "0930";
							break;
						case "3-0013":
							a = "新東京ビル";
							limit = "0830";
							break;
						case "3-0014":
							a = "東京ファッションタウンビル(みずほ総研)";
							limit = "0810";
							break;
						case "3-0015":
							a = "芝浦ルネサイトタワー";
							limit = "0830";
							break;
						case "3-0016":
							a = "コープ共済";
							limit = "0830";
							break;
						case "3-0017":
							a = "東芝府中";
							limit = "0830";
							break;
						case "3-0018":
							a = "丸の内一丁目みずほビル";
							limit = "0810";
							break;
						case "3-0019":
							a = "アークヒルズビル";
							limit = "0930";
							break;
						case "3-0020":
							a = "横浜東口ウィスポートビル３F";
							limit = "0830";
							break;
						case "3-0021":
							a = "楽天ビル２号館";
							limit = "0810";
							break;
						case "3-0022":
							a = "ガーデンシティ品川御殿山";
							limit = "0830";
							break;
						case "3-0023":
							a = "日新ビル";
							limit = "0830";
							break;
						case "3-0024":
							a = "新川崎三井ビルディング";
							limit = "0820";
							break;
						case "3-0025":
							a = "品川アレア";
							limit = "0900";
							break;
						case "3-0026":
							a = "横浜ビジネスパーク";
							limit = "0830";
							break;
						case "3-0027":
							a = "NEC玉川事業場ルネッサンスシティN棟";
							limit = "0830";
							break;
						case "3-0028":
							a = "コープ共済プラザ";
							limit = "0900";
							break;
						case "4-0001":
							a = "AXA";
							limit = "0830";
							break;
						case "4-0002":
							a = "NTTDATAビル（航空管制）";
							limit = "0900";
							break;
						case "4-0003":
							a = "住友ツインビル（NSOL）";
							limit = "0830";
							break;
						case "4-0004":
							a = "東京電力";
							limit = "0900";
							break;
						case "4-0005":
							a = "コニカミノルタ";
							limit = "0830";
							break;
						case "4-0006":
							a = "アルファ2号館";
							limit = "0830";
							break;
						case "4-0007":
							a = "コムシス";
							limit = "0830";
							break;
						case "4-0008":
							a = "住友芝浦ビル";
							limit = "0900";
							break;
						case "4-0009":
							a = "DNP五反田ビル";
							limit = "0830";
							break;
						case "4-0010":
							a = "パナソニック";
							limit = "0830";
							break;
						case "4-0011":
							a = "虎ノ門ビル";
							limit = "0830";
							break;
						case "4-0012":
							a = "井門九段北ビル";
							limit = "0830";
							break;
						case "4-0013":
							a = "NRIセキュア";
							limit = "0930";
							break;
						case "4-0014":
							a = "T社向け電力システム開発";
							limit = "0930";
							break;
						case "4-0015":
							a = "日本HP本社ビル（ドライバー端末アプリ開発）";
							limit = "0930";
							break;
						case "4-0016":
							a = "日本HP本社ビル（電力システム開発）";
							limit = "0900";
							break;
						case "4-0017":
							a = "図研　センター南ビル";
							limit = "0830";
							break;
						case "4-0018":
							a = "NTT横浜山下ビル";
							limit = "0830";
							break;
						case "4-0019":
							a = "横浜ダイヤビル";
							limit = "0830";
							break;
						case "4-0020":
							a = "五洋芝浦ビル";
							limit = "0830";
							break;
						case "4-0021":
							a = "新駿河台ビル";
							limit = "0830";
							break;
						case "4-0022":
							a = "東京ガーデンテラス紀尾井町";
							limit = "0930";
							break;
						case "4-0023":
							a = "NRI";
							limit = "0830";
							break;
						case "4-0024":
							a = "アイマーク";
							limit = "0830";
							break;
						case "4-0025":
							a = "中島商事ビル";
							limit = "0930";
							break;
						case "4-0026":
							a = "新東京センター";
							limit = "0930";
							break;
						case "4-0027":
							a = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "4-0028":
							a = "第３アルファテクノセンター";
							limit = "0830";
							break;
						case "4-0029":
							a = "mBAYPOINT幕張";
							limit = "0900";
							break;
						case "4-0030":
							a = "パークタワー";
							limit = "0900";
							break;
						case "4-0031":
							a = "日本HP本社ビル";
							limit = "0930";
							break;
						case "4-0032":
							a = "太陽生命浦和ビル";
							limit = "0830";
							break;
						case "4-0033":
							a = "NTT品川TWINSアネックス";
							limit = "0900";
							break;
						case "4-0034":
							a = "品川シーサイドサウスタワー";
							limit = "0900";
							break;
						case "4-0035":
							a = "豊洲フロント";
							limit = "0930";
							break;
						case "4-0036":
							a = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0830";
							break;
						case "4-0037":
							a = "日本HP本社ビル";
							limit = "0900";
							break;
						case "4-0038":
							a = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0930";
							break;
						case "4-0039":
							a = "I・Sビル";
							limit = "0830";
							break;
						case "5-0001":
							a = "中之島フェスティバルタワー（DKI）";
							limit = "0830";
							break;
						case "5-0002":
							a = "東京建物梅田ビル（CTC）";
							limit = "0830";
							break;
						case "5-0003":
							a = "日本流通システム";
							limit = "0830";
							break;
						case "5-0004":
							a = "オージス総研　千里オフィス";
							limit = "0830";
							break;
						case "5-0005":
							a = "日本IBM　大阪京橋事業所";
							limit = "0830";
							break;
						case "5-0006":
							a = "パナソニックスマートファクトリーソリューションズ";
							limit = "0800";
							break;
						case "5-0007":
							a = "梅田センタービル（NTTﾃﾞｰﾀｾｷｽｲｼｽﾃﾑ）";
							limit = "0900";
							break;
						case "5-0008":
							a = "新ダイビル（日立ｼｽﾃﾑｽﾞ）";
							limit = "0820";
							break;
						case "5-0009":
							a = "東洋紡ビル（ｿﾌﾟﾗ）";
							limit = "0830";
							break;
						case "5-0010":
							a = "新大阪ニッセイビル（住友電工情報ｼｽﾃﾑ）";
							limit = "0800";
							break;
						case "5-0011":
							a = "大津市役所（日立ｼｽﾃﾑｽﾞ）";
							limit = "0820";
							break;
						case "5-0012":
							a = "和田岬（三菱電機製作所）";
							limit = "0815";
							break;
						case "5-0013":
							a = "三井住友信託銀行";
							limit = "0820";
							break;
						case "5-0014":
							a = "オージス総研千里オフィス";
							limit = "0830";
							break;
						case "5-0015":
							a = "三井住友信託銀行";
							limit = "0830";
							break;
						case "5-0016":
							a = "アートヴィレッジ大崎セントラルタワー";
							limit = "0930";
							break;
						case "5-0017":
							a = "ニッセイアロマスクウェア";
							limit = "0930";
							break;
						case "5-0018":
							a = "品川シーサイドサウスタワー";
							limit = "0900";
							break;
						case "5-0019":
							a = "イヌイビル";
							limit = "0830";
							break;
						case "5-0020":
							a = "SLC";
							limit = "0830";
							break;
						case "5-0021":
							a = "新大阪ニッセイビル（ニッセイ情報テクノロジー）";
							limit = "0830";
							break;
						case "5-0022":
							a = "大阪中之島ビル（ｱｸｾﾝﾁｭｱ）";
							limit = "0830";
							break;
						case "5-0023":
							a = "中之島セントラルタワー";
							limit = "0830";
							break;
						case "5-0024":
							a = "大阪日興ビル";
							limit = "0830";
							break;
						case "5-0025":
							a = "北浜東森田ビル";
							limit = "0830";
							break;
						case "6-0001":
							a = "横浜ダイヤビル（NRI）";
							limit = "0830";
							break;
						case "6-0002":
							a = "アルカウェスト（AIU）";
							limit = "0830";
							break;
						case "6-0003":
							a = "日新火災";
							limit = "0830";
							break;
						case "6-0004":
							a = "住友生命";
							limit = "0820";
							break;
						case "6-0005":
							a = "イーストネットビル(コープ共済)";
							limit = "0830";
							break;
						case "6-0006":
							a = "FBS（CEQ)";
							limit = "0810";
							break;
						case "6-0007":
							a = "三菱電機製作所";
							limit = "0830";
							break;
						case "6-0008":
							a = "日興システムソリューションズ";
							limit = "0900";
							break;
						case "7-0001":
							a = "トレードピアお台場";
							limit = "0830";
							break;
						case "7-0002":
							a = "NTTDOCOMOR&Dセンター２号館";
							limit = "0900";
							break;
						case "7-0003":
							a = "ソフトバンク";
							limit = "0830";
							break;
						case "7-0004":
							a = "日立ソリューションズタワー";
							limit = "0830";
							break;
						case "7-0005":
							a = "SLC";
							limit = "0730";
							break;
						case "7-0006":
							a = "SLC";
							limit = "0930";
							break;
						case "7-0007":
							a = "NTT西日本";
							limit = "0830";
							break;
						case "7-0008":
							a = "オペラシティタワー";
							limit = "0930";
							break;
						default:
							a = "無効なコードです";
						}

						// 無届かどうかをif文で表示
						if (Integer.parseInt(span.get(i).substring(4, 8)) <= Integer
								.parseInt(mmdd.get(i))) {
							if (Integer.parseInt(send_time.get(i)) > Integer
									.parseInt(limit)) {
								send = "無届";
							} else {
								send = "";
							}
						} else {
							send = "";
						}

				 if(kintai_s[i].substring(6,8).equals(kintai_s2[i].substring(6,8))){
						fileWriter.append(dada+"日");
						fileWriter.append(COMMA);
						fileWriter.append(mmdd.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(send_time.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(limit);
						fileWriter.append(COMMA);
						fileWriter.append(send);
						fileWriter.append(COMMA);
						fileWriter.append(division.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(a);
						fileWriter.append(COMMA);
						fileWriter.append(perm.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(remark.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(NEW_LINE);

						flg = 1;
						break;
				 }else{
					 for(int k=Integer.parseInt(kintai_s[i].substring(6,8));k<=(Integer.parseInt(kintai_s2[i].substring(6,8)));k++){
						fileWriter.append(k+"日");
						fileWriter.append(COMMA);
						fileWriter.append(mmdd.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(send_time.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(limit);
						fileWriter.append(COMMA);
						fileWriter.append(send);
						fileWriter.append(COMMA);
						fileWriter.append(division.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(a);
						fileWriter.append(COMMA);
						fileWriter.append(perm.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(remark.get(i));
						fileWriter.append(COMMA);
						fileWriter.append(NEW_LINE);

						flg=1;
						day=k;
					 }
				 }
					}
				}
				if (flg == 0) {
					fileWriter.append(dada+"日");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append("");
					fileWriter.append(COMMA);
					fileWriter.append(NEW_LINE);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}
}

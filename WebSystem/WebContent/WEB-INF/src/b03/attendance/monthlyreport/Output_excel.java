package b03.attendance.monthlyreport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sample.pr.main.LoginForm;
import b04.attendance.calendar.KintaiManagement;
import b05.attendance.dbaction.MonthlyReportDb;

public class Output_excel {

	public void Output_Excel(MonthlyReportForm MRForm, LoginForm lForm)
			throws IOException {
		MonthlyReportDb dba = new MonthlyReportDb();
		// カレンダークラスを取得
		Calendar cal = Calendar.getInstance();
		String year = (cal.get(cal.YEAR)) + "";
		String month = (cal.get(cal.MONTH) + 1) + "";
		int monthlastDay = cal.getActualMaximum(Calendar.DATE);

		// Monthly_reportのDB情報取得
		dba.getMonthly_report(MRForm,
				String.valueOf(KintaiManagement.Cale_Date_Year),
				String.valueOf(KintaiManagement.Cale_Date_Month));

		// リスト化を行う
		List<String> mmdd = MRForm.getMmdd();
		List<String> send_time = MRForm.getSend_Time();
		List<String> division = MRForm.getDivision();
		List<String> spotcode = MRForm.getSpotcode();
		List<String> perm = MRForm.getPerm();
		List<String> remark = MRForm.getRemark();
		List<String> span = MRForm.getSpan();
		List<String> span2 = MRForm.getSpan2();
		List<String> depart = MRForm.getDepart();

		// 現場名
		String spotname = "";

		// limit
		String limit = "";

		// 無届かどうか
		String send = "";

		// 届出区分を数字から読み取る変数
		String div = "";

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

		// ファイル出力方法
		Workbook workbook = new XSSFWorkbook();
		FileOutputStream out = null;
		FileInputStream fis = null;

		try {
			// 「.xlsx」形式のファイル作成

			fis = new FileInputStream(
					"//db366ybx/Proc-Server/Pro-Top/新人研修/2020年度/03.講義/04_成果/08_Webシステム/江泉洸佑/勤怠月報画面テンプレ_"+
							String.valueOf(KintaiManagement.Cale_Date_Month)+"月.xlsx");
			workbook = WorkbookFactory.create(fis);
			// シートを「勤怠月報画面」という名前で作成
			Sheet sheet = workbook.cloneSheet(workbook.getSheetIndex("勤怠月報"));
			// シートの保護
			sheet.protectSheet("");
			workbook.setSheetName(workbook.getSheetIndex(sheet), "勤怠月報画面");

			// 行を指定する変数
			Row row;
			// 列を指定する変数
			Cell cell;


			// 8行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(7);
			cell = row.getCell(21);
			cell.setCellValue(depart.get(0));

			// 10行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(9);
			cell = row.getCell(1);
			cell.setCellValue(String.valueOf(KintaiManagement.Cale_Date_Year)
					+ "年" + String.valueOf(KintaiManagement.Cale_Date_Month)
					+ "月" + monthlastDay + "日");
			cell = row.getCell(21);
			cell.setCellValue(lForm.getEmployee_name());

			// 11行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(10);
			cell = row.getCell(15);
			cell.setCellValue(lForm.getEmployee_no());

			// 有給などの回数をカウントする変数
			int tikoku = 0;
			int yuukyuu = 0;
			int hurikae = 0;
			int tokubetsu = 0;
			int shihuto = 0;
			int sotai = 0;
			int kotu = 0;
			int kekkin = 0;

			// 有給などの回数をカウントするfor文、switch文
			for (int c = 0; c < mmdd.size(); c++) {
				if (kintai_s[c].substring(6, 8).equals(
						kintai_s2[c].substring(6, 8))) {
					switch (division.get(c)) {
					case "1":
						tikoku++;
						break;
					case "2":
						yuukyuu++;
						break;
					case "3":
						hurikae++;
						break;
					case "4":
						tokubetsu++;
						break;
					case "5":
						shihuto++;
						break;
					case "6":
						sotai++;
						break;
					case "7":
						kotu++;
						break;
					case "8":
						kekkin++;
						break;
					}
				} else {
					for (int k = Integer.parseInt(kintai_s[c].substring(6, 8)); k <= (Integer
							.parseInt(kintai_s2[c].substring(6, 8))); k++) {
						switch (division.get(c)) {
						case "1":
							tikoku++;
							break;
						case "2":
							yuukyuu++;
							break;
						case "3":
							hurikae++;
							break;
						case "4":
							tokubetsu++;
							break;
						case "5":
							shihuto++;
							break;
						case "6":
							sotai++;
							break;
						case "7":
							kotu++;
							break;
						case "8":
							kekkin++;
							break;
						}
					}
				}
			}


			// 無届かつ遅刻などをしているかどうかをカウント
			int unreported_tikoku = 0;
			int unreported_shihuto = 0;
			int unreported_sotai = 0;
			int unreported_kotu = 0;
			int unreported_kekkin = 0;

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
							spotname = "本社";
							limit = "0830";
							break;
						case "9-0002":
							spotname = "大阪事業所";
							limit = "0830";
							break;
						case "1-0001":
							spotname = "アルカウェスト（AIU）";
							limit = "0830";
							break;
						case "1-0002":
							spotname = "サンシャイン（そんぽ２４）";
							limit = "0830";
							break;
						case "1-0003":
							spotname = "上野フジタエステート（えきねっと）";
							limit = "0930";
							break;
						case "1-0004":
							spotname = "日生三田ビル";
							limit = "0830";
							break;
						case "1-0005":
							spotname = "三鷹高木ビル(システムテスト)";
							limit = "0900";
							break;
						case "1-0006":
							spotname = "宝印刷";
							limit = "0900";
							break;
						case "1-0007":
							spotname = "紀尾井町パークビル（福利厚生）";
							limit = "0830";
							break;
						case "1-0008":
							spotname = "コムシス新横浜";
							limit = "0830";
							break;
						case "1-0009":
							spotname = "虎ノ門ヒルズ";
							limit = "0830";
							break;
						case "1-0010":
							spotname = "JA川崎(普及)";
							limit = "0830";
							break;
						case "1-0011":
							spotname = "武蔵小杉タワープレイス";
							limit = "0830";
							break;
						case "1-0012":
							spotname = "ニッセイアロマスクウェア";
							limit = "0830";
							break;
						case "1-0013":
							spotname = "三菱電機製作所";
							limit = "0900";
							break;
						case "1-0014":
							spotname = "日本ユニシス";
							limit = "0830";
							break;
						case "1-0015":
							spotname = "虎ノ門ヒルズ";
							limit = "0930";
							break;
						case "1-0016":
							spotname = "蒲田INAビル";
							limit = "0930";
							break;
						case "1-0017":
							spotname = "三田NNビル";
							limit = "0830";
							break;
						case "1-0018":
							spotname = "府中Jタワー";
							limit = "0830";
							break;
						case "1-0019":
							spotname = "三田NNビル";
							limit = "0810";
							break;
						case "1-0020":
							spotname = "蒲田アロマスクエア";
							limit = "0930";
							break;
						case "1-0021":
							spotname = "リバーサイド読売ビル";
							limit = "0830";
							break;
						case "1-0022":
							spotname = "東京ダイヤビルディング";
							limit = "0830";
							break;
						case "1-0023":
							spotname = "高崎ルネサス";
							limit = "0800";
							break;
						case "1-0024":
							spotname = "イヌイビル";
							limit = "0830";
							break;
						case "1-0025":
							spotname = "グラスシティ晴海";
							limit = "0830";
							break;
						case "1-0026":
							spotname = "中野セントラルパークサウス";
							limit = "0830";
							break;
						case "1-0027":
							spotname = "新光ビルディング日本橋";
							limit = "0810";
							break;
						case "1-0028":
							spotname = "ランディック第2新橋ビル";
							limit = "0830";
							break;
						case "1-0029":
							spotname = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "1-0030":
							spotname = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "1-0031":
							spotname = "オリナスタワー";
							limit = "0830";
							break;
						case "1-0032":
							spotname = "日立愛宕別館";
							limit = "0830";
							break;
						case "1-0033":
							spotname = "アークヒルズビル";
							limit = "0830";
							break;
						case "1-0034":
							spotname = "パナソニック佐江戸事業所";
							limit = "0830";
							break;
						case "1-0035":
							spotname = "蒲田アロマスクエア";
							limit = "0900";
							break;
						case "1-0036":
							spotname = "蒲田アロマスクエア";
							limit = "0900";
							break;
						case "1-0037":
							spotname = "SGシステム";
							limit = "0830";
							break;
						case "1-0038":
							spotname = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0830";
							break;
						case "1-0039":
							spotname = "浜松町ビルディング";
							limit = "0900";
							break;
						case "1-0040":
							spotname = "アプラス　東京ダイヤビル5号館";
							limit = "0845";
							break;
						case "1-0041":
							spotname = "一番町東急ビル";
							limit = "0830";
							break;
						case "1-0042":
							spotname = "新宿グリーンタワービル";
							limit = "0930";
							break;
						case "1-0043":
							spotname = "浜松町ビルディング";
							limit = "0830";
							break;
						case "1-0044":
							spotname = "目白台ビル";
							limit = "0830";
							break;
						case "1-0045":
							spotname = "トレードピアお台場";
							limit = "0930";
							break;
						case "1-0046":
							spotname = "NRIタワー";
							limit = "0930";
							break;
						case "1-0047":
							spotname = "目白台ビル";
							limit = "0810";
							break;
						case "2-0014":
							spotname = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0016":
							spotname = "FBS（CEQ)";
							limit = "0810";
							break;
						case "2-0018":
							spotname = "ｱｸｾｽPF―光ｺﾗﾎﾞ対応/#P#FUTURE_F27-1";
							limit = "0900";
							break;
						case "2-0019":
							spotname = "移動機試験";
							limit = "0830";
							break;
						case "2-0021":
							spotname = "コンカード横浜";
							limit = "0830";
							break;
						case "2-0022":
							spotname = "三菱電機(湘セン)";
							limit = "0900";
							break;
						case "2-0024":
							spotname = "情報総研（大船）";
							limit = "0800";
							break;
						case "2-0025":
							spotname = "ワテラスタワー";
							limit = "0830";
							break;
						case "2-0026":
							spotname = "コンカード横浜";
							limit = "0815";
							break;
						case "2-0027":
							spotname = "神谷町MTビル";
							limit = "0830";
							break;
						case "2-0028":
							spotname = "NEC別館ビル";
							limit = "0900";
							break;
						case "2-0029":
							spotname = "ソフトバンクテレコム東京イーストセンター";
							limit = "0930";
							break;
						case "2-0031":
							spotname = "コープ共済プラザ";
							limit = "0830";
							break;
						case "2-0032":
							spotname = "楽天クリムゾンハウス";
							limit = "0900";
							break;
						case "2-0033":
							spotname = "三菱電機鎌倉製作所";
							limit = "0815";
							break;
						case "3-0001":
							spotname = "GA多摩ビル（TNK）";
							limit = "0830";
							break;
						case "3-0002":
							spotname = "GA多摩ビル（情報H）";
							limit = "0830";
							break;
						case "3-0003":
							spotname = "明治安田生命ビル(業務管理)";
							limit = "0845";
							break;
						case "3-0004":
							spotname = "明治安田生命ビル(ネットワーク基盤Ｇ)";
							limit = "0830";
							break;
						case "3-0005":
							spotname = "明治安田生命ビル(ＢＩ開発営業)";
							limit = "0830";
							break;
						case "3-0006":
							spotname = "KSP（富士通）";
							limit = "0820";
							break;
						case "3-0007":
							spotname = "三菱電機(鎌電)";
							limit = "0815";
							break;
						case "3-0008":
							spotname = "ZENITAKAANNEXビル(三菱電機)";
							limit = "0830";
							break;
						case "3-0009":
							spotname = "勝どき（運用）";
							limit = "0930";
							break;
						case "3-0010":
							spotname = "マイテクノ新人研修";
							limit = "0830";
							break;
						case "3-0011":
							spotname = "イーストネットビル(コープ共済)";
							limit = "0830";
							break;
						case "3-0012":
							spotname = "クラフト";
							limit = "0930";
							break;
						case "3-0013":
							spotname = "新東京ビル";
							limit = "0830";
							break;
						case "3-0014":
							spotname = "東京ファッションタウンビル(みずほ総研)";
							limit = "0810";
							break;
						case "3-0015":
							spotname = "芝浦ルネサイトタワー";
							limit = "0830";
							break;
						case "3-0016":
							spotname = "コープ共済";
							limit = "0830";
							break;
						case "3-0017":
							spotname = "東芝府中";
							limit = "0830";
							break;
						case "3-0018":
							spotname = "丸の内一丁目みずほビル";
							limit = "0810";
							break;
						case "3-0019":
							spotname = "アークヒルズビル";
							limit = "0930";
							break;
						case "3-0020":
							spotname = "横浜東口ウィスポートビル３F";
							limit = "0830";
							break;
						case "3-0021":
							spotname = "楽天ビル２号館";
							limit = "0810";
							break;
						case "3-0022":
							spotname = "ガーデンシティ品川御殿山";
							limit = "0830";
							break;
						case "3-0023":
							spotname = "日新ビル";
							limit = "0830";
							break;
						case "3-0024":
							spotname = "新川崎三井ビルディング";
							limit = "0820";
							break;
						case "3-0025":
							spotname = "品川アレア";
							limit = "0900";
							break;
						case "3-0026":
							spotname = "横浜ビジネスパーク";
							limit = "0830";
							break;
						case "3-0027":
							spotname = "NEC玉川事業場ルネッサンスシティN棟";
							limit = "0830";
							break;
						case "3-0028":
							spotname = "コープ共済プラザ";
							limit = "0900";
							break;
						case "4-0001":
							spotname = "AXA";
							limit = "0830";
							break;
						case "4-0002":
							spotname = "NTTDATAビル（航空管制）";
							limit = "0900";
							break;
						case "4-0003":
							spotname = "住友ツインビル（NSOL）";
							limit = "0830";
							break;
						case "4-0004":
							spotname = "東京電力";
							limit = "0900";
							break;
						case "4-0005":
							spotname = "コニカミノルタ";
							limit = "0830";
							break;
						case "4-0006":
							spotname = "アルファ2号館";
							limit = "0830";
							break;
						case "4-0007":
							spotname = "コムシス";
							limit = "0830";
							break;
						case "4-0008":
							spotname = "住友芝浦ビル";
							limit = "0900";
							break;
						case "4-0009":
							spotname = "DNP五反田ビル";
							limit = "0830";
							break;
						case "4-0010":
							spotname = "パナソニック";
							limit = "0830";
							break;
						case "4-0011":
							spotname = "虎ノ門ビル";
							limit = "0830";
							break;
						case "4-0012":
							spotname = "井門九段北ビル";
							limit = "0830";
							break;
						case "4-0013":
							spotname = "NRIセキュア";
							limit = "0930";
							break;
						case "4-0014":
							spotname = "T社向け電力システム開発";
							limit = "0930";
							break;
						case "4-0015":
							spotname = "日本HP本社ビル（ドライバー端末アプリ開発）";
							limit = "0930";
							break;
						case "4-0016":
							spotname = "日本HP本社ビル（電力システム開発）";
							limit = "0900";
							break;
						case "4-0017":
							spotname = "図研　センター南ビル";
							limit = "0830";
							break;
						case "4-0018":
							spotname = "NTT横浜山下ビル";
							limit = "0830";
							break;
						case "4-0019":
							spotname = "横浜ダイヤビル";
							limit = "0830";
							break;
						case "4-0020":
							spotname = "五洋芝浦ビル";
							limit = "0830";
							break;
						case "4-0021":
							spotname = "新駿河台ビル";
							limit = "0830";
							break;
						case "4-0022":
							spotname = "東京ガーデンテラス紀尾井町";
							limit = "0930";
							break;
						case "4-0023":
							spotname = "NRI";
							limit = "0830";
							break;
						case "4-0024":
							spotname = "アイマーク";
							limit = "0830";
							break;
						case "4-0025":
							spotname = "中島商事ビル";
							limit = "0930";
							break;
						case "4-0026":
							spotname = "新東京センター";
							limit = "0930";
							break;
						case "4-0027":
							spotname = "新宿ガーデンタワー";
							limit = "0830";
							break;
						case "4-0028":
							spotname = "第３アルファテクノセンター";
							limit = "0830";
							break;
						case "4-0029":
							spotname = "mBAYPOINT幕張";
							limit = "0900";
							break;
						case "4-0030":
							spotname = "パークタワー";
							limit = "0900";
							break;
						case "4-0031":
							spotname = "日本HP本社ビル";
							limit = "0930";
							break;
						case "4-0032":
							spotname = "太陽生命浦和ビル";
							limit = "0830";
							break;
						case "4-0033":
							spotname = "NTT品川TWINSアネックス";
							limit = "0900";
							break;
						case "4-0034":
							spotname = "品川シーサイドサウスタワー";
							limit = "0900";
							break;
						case "4-0035":
							spotname = "豊洲フロント";
							limit = "0930";
							break;
						case "4-0036":
							spotname = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0830";
							break;
						case "4-0037":
							spotname = "日本HP本社ビル";
							limit = "0900";
							break;
						case "4-0038":
							spotname = "KDX晴海ビル，晴海トリトンスクエア";
							limit = "0930";
							break;
						case "4-0039":
							spotname = "I・Sビル";
							limit = "0830";
							break;
						case "5-0001":
							spotname = "中之島フェスティバルタワー（DKI）";
							limit = "0830";
							break;
						case "5-0010":
							spotname = "新大阪ニッセイビル（住友電工情報ｼｽﾃﾑ）";
							limit = "0800";
							break;
						case "5-0013":
							spotname = "三井住友信託銀行";
							limit = "0820";
							break;
						case "5-0016":
							spotname = "アートヴィレッジ大崎セントラルタワー";
							limit = "0930";
							break;
						case "5-0017":
							spotname = "ニッセイアロマスクウェア";
							limit = "0930";
							break;
						case "5-0018":
							spotname = "品川シーサイドサウスタワー";
							limit = "0900";
							break;
						case "5-0019":
							spotname = "イヌイビル";
							limit = "0830";
							break;
						case "5-0020":
							spotname = "SLC";
							limit = "0830";
							break;
						case "5-0023":
							spotname = "中之島セントラルタワー";
							limit = "0830";
							break;
						case "5-0024":
							spotname = "大阪日興ビル";
							limit = "0830";
							break;
						case "5-0025":
							spotname = "北浜東森田ビル";
							limit = "0830";
							break;
						case "6-0001":
							spotname = "横浜ダイヤビル（NRI）";
							limit = "0830";
							break;
						case "6-0002":
							spotname = "アルカウェスト（AIU）";
							limit = "0830";
							break;
						case "6-0003":
							spotname = "日新火災";
							limit = "0830";
							break;
						case "6-0004":
							spotname = "住友生命";
							limit = "0820";
							break;
						case "6-0005":
							spotname = "イーストネットビル(コープ共済)";
							limit = "0830";
							break;
						case "6-0006":
							spotname = "FBS（CEQ)";
							limit = "0810";
							break;
						case "6-0007":
							spotname = "三菱電機製作所";
							limit = "0830";
							break;
						case "6-0008":
							spotname = "日興システムソリューションズ";
							limit = "0900";
							break;
						case "7-0001":
							spotname = "トレードピアお台場";
							limit = "0830";
							break;
						case "7-0002":
							spotname = "NTTDOCOMOR&Dセンター２号館";
							limit = "0900";
							break;
						case "7-0003":
							spotname = "ソフトバンク";
							limit = "0830";
							break;
						case "7-0004":
							spotname = "日立ソリューションズタワー";
							limit = "0830";
							break;
						case "7-0005":
							spotname = "SLC";
							limit = "0730";
							break;
						case "7-0006":
							spotname = "SLC";
							limit = "0930";
							break;
						case "7-0007":
							spotname = "NTT西日本";
							limit = "0830";
							break;
						case "7-0008":
							spotname = "オペラシティタワー";
							limit = "0930";
							break;
						default:
							spotname = "無効なコードです";
							limit = "9999";
						}

						// カウントするための変数
						// 届出区分から有給休暇などを取得(例 2→有給休暇)
						switch (division.get(i)) {
						case "1":
							div = "遅刻";
							break;
						case "2":
							div = "有給休暇";
							break;
						case "3":
							div = "振替休暇";
							break;
						case "4":
							div = "特別休暇";
							break;
						case "5":
							div = "シフト勤務";
							break;
						case "6":
							div = "早退,その他";
							break;
						case "7":
							div = "交通遅延";
							break;
						case "8":
							div = "欠勤";
							break;
						case "9":
							div = "深夜作業";
							break;
						case "10":
							div = "休日出勤(振)";
							break;
						}

						// 無届かどうかをif文で表示
						if (Integer.parseInt(span.get(i).substring(4, 8)) <= Integer
								.parseInt(mmdd.get(i))) {
							if (Integer.parseInt(send_time.get(i)) > Integer
									.parseInt(limit)) {
								send = "無届";

								if (kintai_s[i].substring(6, 8).equals(
										kintai_s2[i].substring(6, 8))) {
									switch (division.get(i)) {
									case "1":
										unreported_tikoku++;
										break;
									case "5":
										unreported_shihuto++;
										break;
									case "6":
										unreported_sotai++;
										break;
									case "7":
										unreported_kotu++;
										break;
									case "8":
										unreported_kekkin++;
										break;
									}
								} else {
									for (int k = Integer.parseInt(kintai_s[i]
											.substring(6, 8)); k <= (Integer
											.parseInt(kintai_s2[i].substring(6,
													8))); k++) {
										switch (division.get(i)) {
										case "1":
											unreported_tikoku++;
											break;
										case "5":
											unreported_shihuto++;
											break;
										case "6":
											unreported_sotai++;
											break;
										case "7":
											unreported_kotu++;
											break;
										case "8":
											unreported_kekkin++;
											break;
										}
									}
								}
							} else {
								send = "";
							}
						} else {
							send = "";
						}

						// 15行目
						row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
								.getRow(14);
						cell = row.getCell(5);
						if (unreported_tikoku != 0) {
							cell.setCellValue(tikoku-unreported_tikoku);
						} else {
							cell.setCellValue(tikoku);
						}
						cell = row.getCell(9);
						if (unreported_kotu != 0) {
							cell.setCellValue(kotu-unreported_kotu);
						} else {
							cell.setCellValue(kotu);
						}
						cell = row.getCell(13);
						if (unreported_sotai != 0) {
							cell.setCellValue(sotai-unreported_sotai);
						} else {
							cell.setCellValue(sotai);
						}
						cell = row.getCell(17);
						if (unreported_shihuto != 0) {
							cell.setCellValue(shihuto-unreported_shihuto);
						} else {
							cell.setCellValue(shihuto);
						}
						cell = row.getCell(20);
						cell.setCellValue(yuukyuu);
						cell = row.getCell(23);
						cell.setCellValue(hurikae);
						cell = row.getCell(29);
						cell.setCellValue(tokubetsu);
						cell = row.getCell(32);
						if (unreported_kekkin != 0) {
							cell.setCellValue(kekkin-unreported_kekkin);
						} else {
							cell.setCellValue(kekkin);
						}

						// 16行目
						row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
								.getRow(15);
						cell = row.getCell(5);
						cell.setCellValue(unreported_tikoku);
						cell = row.getCell(9);
						cell.setCellValue(unreported_kotu);
						cell = row.getCell(13);
						cell.setCellValue(unreported_sotai);
						cell = row.getCell(17);
						cell.setCellValue(unreported_shihuto);
						cell = row.getCell(32);
						cell.setCellValue(unreported_kekkin);

						// 19行目以降
						// span==span2だった場合（期間が一日だった場合）
						if (kintai_s[i].substring(6, 8).equals(
								kintai_s2[i].substring(6, 8))) {
							row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
									.getRow(day + 17);
							cell = row.getCell(4);
							cell.setCellValue(mmdd.get(i).substring(0, 2) + "/"
									+ mmdd.get(i).substring(2, 4));
							cell = row.getCell(8);
							cell.setCellValue(send_time.get(i).substring(0, 2)
									+ ":" + send_time.get(i).substring(2, 4));
							cell = row.getCell(10);
							cell.setCellValue(limit.substring(0, 2) + ":"
									+ limit.substring(2, 4));
							cell = row.getCell(13);
							cell.setCellValue(send);
							cell = row.getCell(16);
							cell.setCellValue(division.get(i));
							cell = row.getCell(17);
							cell.setCellValue(div);
							cell = row.getCell(20);
							cell.setCellValue(spotname);
							if (perm.get(i) == null) {
								cell = row.getCell(25);
								cell.setCellValue("");
							} else {
								cell = row.getCell(25);
								cell.setCellValue(perm.get(i));
							}
							cell = row.getCell(28);
							cell.setCellValue(remark.get(i));
							flg = 1;
							break;
							// span<span2だった場合(期間が連続して複数ある時)
						} else {
							for (int k = Integer.parseInt(kintai_s[i]
									.substring(6, 8)); k <= (Integer
									.parseInt(kintai_s2[i].substring(6, 8))); k++) {
								row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
										.getRow(day + 17);
								cell = row.getCell(4);
								cell.setCellValue(mmdd.get(i).substring(0, 2)
										+ "/" + mmdd.get(i).substring(2, 4));
								cell = row.getCell(8);
								cell.setCellValue(send_time.get(i).substring(0,
										2)
										+ ":"
										+ send_time.get(i).substring(2, 4));
								cell = row.getCell(10);
								cell.setCellValue(limit.substring(0, 2) + ":"
										+ limit.substring(2, 4));
								cell = row.getCell(13);
								cell.setCellValue(send);
								cell = row.getCell(16);
								cell.setCellValue(division.get(i));
								cell = row.getCell(17);
								cell.setCellValue(div);
								cell = row.getCell(20);
								cell.setCellValue(spotname);
								if (perm.get(i) == null) {
									cell = row.getCell(25);
									cell.setCellValue("");
								} else {
									cell = row.getCell(25);
									cell.setCellValue(perm.get(i));
								}
								cell = row.getCell(28);
								cell.setCellValue(remark.get(i));
								flg = 1;
								day = k + 1;
							}
						}
					}
				}
			}

			workbook.removeSheetAt(0);

			// 出力先のファイル名を指定
			out = new FileOutputStream(
					"//db366ybx/Proc-Server/Pro-Top/新人研修/2020年度/03.講義/04_成果/08_Webシステム/勤怠月報エクセル出力/"
							+ String.valueOf(KintaiManagement.Cale_Date_Year)
							+ ""
							+ String.valueOf(KintaiManagement.Cale_Date_Month)
							+ "_勤怠連絡月報_" + lForm.getEmployee_no()
							+ lForm.getEmployee_name() + ".xlsx");
			// ブックに書き込み
			workbook.write(out);

		} finally {

			if (fis != null) {
				fis.close();
			}
			if (out != null) {
				out.close();
			}
			if (workbook != null) {
				workbook.close();
			}
		}
		System.out.println("出力完了");
	}

}

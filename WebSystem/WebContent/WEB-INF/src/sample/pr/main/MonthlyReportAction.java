package sample.pr.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

		MonthlyReportForm MForm =  (MonthlyReportForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		//MForm.setEmployee_no(lForm.getEmployee_no());
		forward = "";
		String button = MForm.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "kintailist";
				//session.removeAttribute("kForm");
			} else if (button.equals("保存")) {
				forward = "MonthlyReport";
				session.setAttribute("kform", MForm);
				boolean chkflg = Output_Csv(MForm, lForm);
				if (chkflg == true) {
					System.out.println("CSVファイル出力完了");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//session.removeAttribute("kForm");
		return map.findForward(forward);
	}

	// csv出力メソッド
	public boolean Output_Csv(MonthlyReportForm MRForm,
			 LoginForm lForm) throws IOException {

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
		ArrayList<String> MForm = new ArrayList<String>();
		List<String> mmdd = MRForm.getMmdd();
		List<String> send_time = MRForm.getSend_Time();
		List<String> division = MRForm.getDivision();
		List<String> spotcode = MRForm.getSpotcode();
		List<String> perm = MRForm.getPerm();
		List<String> remark = MRForm.getRemark();
		List<String> span = MRForm.getSpan();
		List<String> span2 = MRForm.getSpan2();
		List<String> depart = MRForm.getDepart();


		//いらないかも
		MForm.addAll(mmdd);
		MForm.addAll(send_time);
		MForm.addAll(division);
		MForm.addAll(spotcode);
		MForm.addAll(perm);
		MForm.addAll(remark);
		MForm.addAll(span);
		MForm.addAll(span2);
		MForm.addAll(depart);

		// 現場名
		String spotname = "";

		// limit
		String limit = "";

		// 無届かどうか
		String send = "";

		//届出区分を数字から読み取る変数
		String div="";

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
		Workbook workbook = null;
		FileOutputStream out = null;

		try {
			//「.xlsx」形式のファイル作成
			workbook = new XSSFWorkbook();
			// シートを「勤怠月報画面」という名前で作成
			org.apache.poi.ss.usermodel.Sheet sheet = workbook
					.createSheet("勤怠月報画面");

			// 罫線のスタイルを指定
			//中太線
			CellStyle cellStyle = null;
			cellStyle = setStyle(workbook, BorderStyle.MEDIUM,
					IndexedColors.BLACK.getIndex());
			//細線
			CellStyle THINStyle=null;
			THINStyle = setStyle(workbook, BorderStyle.THIN,
					IndexedColors.BLACK.getIndex());
			//点線
			CellStyle DOTTEDStyle=null;
			DOTTEDStyle = setStyle(workbook, BorderStyle.DOTTED,
					IndexedColors.BLACK.getIndex());

			// 行を指定する変数
			Row row;
			// 列を指定する変数
			Cell cell;


			//列の幅を指定
			for(int i=0;i<=8;i++){
			 sheet.setColumnWidth(i, 600);
			}
			sheet.setColumnWidth(9, 850);
			for(int i=10;i<=13;i++){
				 sheet.setColumnWidth(i, 600);
				}
			sheet.setColumnWidth(14, 900);
			sheet.setColumnWidth(15, 800);
			for(int i=16;i<=18;i++){
				 sheet.setColumnWidth(i, 600);
				}
			sheet.setColumnWidth(19, 1300);
			for(int i=20;i<=21;i++){
				 sheet.setColumnWidth(i, 600);
				}
			sheet.setColumnWidth(22, 800);
			sheet.setColumnWidth(23, 600);
			sheet.setColumnWidth(24, 1600);
			for(int i=25;i<=34;i++){
				 sheet.setColumnWidth(i, 600);
				}

//	 //セルの結合
			 //印鑑を押す場所
			 sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 8));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 1, 4));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 5, 8));
			 sheet.addMergedRegion(new CellRangeAddress(1, 1, 9, 16));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 12));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 13, 16));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 9, 12));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 13, 16));
			 sheet.addMergedRegion(new CellRangeAddress(1, 1, 17, 32));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 17, 20));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 21, 24));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 25, 28));
			 sheet.addMergedRegion(new CellRangeAddress(2, 2, 29, 32));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 17, 20));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 21, 24));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 25, 28));
			 sheet.addMergedRegion(new CellRangeAddress(3, 5, 29, 32));
			 //勤怠月報画面と記述する場所
			 sheet.addMergedRegion(new CellRangeAddress(7, 8, 0, 12));
			 //提出日を記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(9, 10, 1, 11));
			 //報告者と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(7, 10, 13, 14));
			 //所属部署と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(7, 8, 15, 20));
			 //所属部署を記載する項目
			 sheet.addMergedRegion(new CellRangeAddress(7, 8, 21, 32));
			 //氏名を記載する項目
			 sheet.addMergedRegion(new CellRangeAddress(9, 10, 21, 32));
			 //社員番号と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(9, 9, 15, 20));
			 //社員番号を記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(10, 10, 15, 20));
			 //年を記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(12, 13, 0, 4));
			 //月を記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(14, 15, 0, 4));
			 // 遅刻/早退回数と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(12, 12, 5, 16));
			 //遅刻と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 5, 8));
			 //交通遅延と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13,13, 9, 12));
			 //早退・その他と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 13, 16));
			 //シフトと記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(12, 13, 17, 19));
			 //休暇取得日数と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(12, 12, 20, 34));
			 //有給/リフと記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 20, 22));
			 //振替と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 23, 25));
			 //  [/]と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 26, 28));
			 //特別と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 29, 31));
			 //欠勤と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(13, 13, 32, 34));
			 //上段の遅刻数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 5, 8));
			 //下段の遅刻数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 5, 8));
			 //上段の交通遅延数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 9, 12));
			 //下段の交通遅延数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 9, 12));
			 //上段の早退・その他数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 13, 16));
			 //下段の早退・その他数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 13, 16));
			 //上段のシフト数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 17, 19));
			 //下段のシフト数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 17, 19));
			 //上段の有給/リフ数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 20, 22));
			 //下段の有給/リフ数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 20, 22));
			 //上段の振替数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 23, 25));
			 //下段の振替数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 23, 25));
			 //[/]の上段
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 26, 28));
			 //[/]の下段
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 26, 28));
			 //上段の特別数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 29, 31));
			 //下段の特別数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 29, 31));
			 //上段の欠勤数
			 sheet.addMergedRegion(new CellRangeAddress(14, 14, 32, 34));
			 //下段の欠勤数
			 sheet.addMergedRegion(new CellRangeAddress(15, 15, 32, 34));
			 //※上段：届有件数、下段：無届（連絡遅延）件数と記載する場所
			 sheet.addMergedRegion(new CellRangeAddress(16, 16, 5, 20));
			 //18行目の項目
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 0, 3));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 4, 7));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 8, 9));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 10, 12));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 13, 15));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 16, 19));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 20, 24));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 25, 27));
			 sheet.addMergedRegion(new CellRangeAddress(17, 17, 28, 34));
			 //19から49行目の日にち
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,0 ,1));
			 }
			//19から49行目の休の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,2 ,3));
			 }
			//19から49行目の届出日の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,4 ,7));
			 }
			//19から49行目の時刻の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,8 ,9));
			 }
			//19から49行目のLimitの項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,10 ,12));
			 }
			//19から49行目の連絡遅延の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,13 ,15));
			 }
			//19から49行目の届け区分(右)の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,17 ,19));
			 }
			//19から49行目の作業場所の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,20 ,24));
			 }
			//19から49行目の許可者の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,25 ,27));
			 }
			//19から49行目の備考の項目
			 for(int i=18;i<=48;i++){
				 sheet.addMergedRegion(new CellRangeAddress(i, i,28 ,34));
			 }




	// excel出力時のフォーム作成
			//2行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(1);
			cell = row.createCell(1);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("承認役員");
			for(int i=2;i<=8;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(9);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("総務部");
			for(int i=10;i<=16;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(17);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("報告承認部課");
			for(int i=18;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//3行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(2);
			for(int i=1;i<=8;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(9);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("責任者");
			for(int i=10;i<=12;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(13);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("担当");
			for(int i=14;i<=16;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(17);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("役員");
			for(int i=18;i<=20;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(21);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("部長");
			for(int i=22;i<=24;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(25);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("課長");
			for(int i=26;i<=28;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(29);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("リーダー");
			for(int i=30;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//4行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(3);
			for(int i=1;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//5行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(4);
			for(int i=1;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//6行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(5);
			for(int i=1;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//8行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(7);
			cell = row.createCell(0);
			cell.setCellValue("勤怠連絡月報");
			cell = row.createCell(13);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("報告者");
			cell = row.createCell(14);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(15);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("所属部署");
			for(int i=16;i<=20;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(21);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue(lForm.getEmployee_name());
			for(int i=22;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			//9行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(8);
			for(int i=13;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//10行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(9);
			cell = row.createCell(1);
			cell.setCellValue("提出日"+String.valueOf(KintaiManagement.Cale_Date_Year)+"年"+String.valueOf(KintaiManagement.Cale_Date_Month)+"月"+monthlastDay+"日");
			cell = row.createCell(13);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(14);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(15);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("社員番号");
			for(int i=16;i<=20;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}
			cell = row.createCell(21);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue(lForm.getEmployee_name());
			for(int i=22;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//11行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(10);
			cell = row.createCell(13);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(14);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(15);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue(lForm.getEmployee_no());
			for(int i=16;i<=32;i++){
				cell = row.createCell(i);
				cell.setCellStyle(DOTTEDStyle);
			}

			//13行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(12);
			cell = row.createCell(0);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(String.valueOf(KintaiManagement.Cale_Date_Year)+"年度");
			for(int i=1;i<=4;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(5);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("遅刻/早退回数");
			for(int i=6;i<=16;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(17);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("シフト");
			for(int i=18;i<=19;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(20);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("休暇取得日数");
			for(int i=21;i<=34;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}

			//14行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(13);
			for(int i=0;i<=4;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(5);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("遅刻");
			for(int i=6;i<=8;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(9);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("交通遅延");
			for(int i=10;i<=12;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(13);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("早退・その他");
			for(int i=14;i<=19;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(20);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("有給/リフ");
			cell = row.createCell(21);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(22);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(23);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("振替");
			cell = row.createCell(24);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(25);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(26);
			cell.setCellValue("-----");
			cell = row.createCell(27);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(28);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(29);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("特別");
			cell = row.createCell(30);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(31);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(32);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("欠勤");
			cell = row.createCell(33);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(34);
			cell.setCellStyle(THINStyle);


			//有給などの回数をカウントする変数
			int tikoku=0;
			int yuukyuu=0;
			int hurikae=0;
			int tokubetsu=0;
			int shihuto=0;
			int sotai=0;
			int kotu=0;
			int kekkin=0;
			//有給などの回数をカウントするfor文、switch文
			for(int c=0;c<mmdd.size();c++){
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
			//15行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(14);
			cell = row.createCell(0);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(String.valueOf(KintaiManagement.Cale_Date_Month)+"月度");
			for(int i=1;i<=4;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(5);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(tikoku);
			for(int i=6;i<=8;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(9);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(kotu);
			for(int i=10;i<=12;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(13);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(sotai);
			for(int i=11;i<=16;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(17);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(shihuto);
			cell = row.createCell(18);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(19);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(20);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(yuukyuu);
			cell = row.createCell(21);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(22);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(23);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(hurikae);
			cell = row.createCell(24);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(25);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(26);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("-----");
			cell = row.createCell(27);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(28);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(29);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(tokubetsu);
			cell = row.createCell(30);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(31);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(32);
			cell.setCellStyle(THINStyle);
			cell.setCellValue(kekkin);
			cell = row.createCell(33);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(34);
			cell.setCellStyle(THINStyle);

			//16行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(15);
			for(int i=0;i<=4;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(5);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("0(遅刻下段)");
			for(int i=6;i<=8;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(9);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("0(交通遅延下段)");
			for(int i=10;i<=12;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(13);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("0(早退・その他下段)");
			for(int i=14;i<=16;i++){
				cell = row.createCell(i);
				cell.setCellStyle(THINStyle);
			}
			cell = row.createCell(17);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("0(シフト下段)");
			cell = row.createCell(18);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(19);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(20);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("-----");
			cell = row.createCell(21);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(22);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(23);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("-----");
			cell = row.createCell(24);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(25);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(26);
			cell.setCellValue("-----");
			cell = row.createCell(27);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(28);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(29);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("-----");
			cell = row.createCell(30);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(31);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(32);
			cell.setCellStyle(THINStyle);
			cell.setCellValue("0(欠勤下段)");
			cell = row.createCell(33);
			cell.setCellStyle(THINStyle);
			cell = row.createCell(34);
			cell.setCellStyle(THINStyle);


			//17行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(16);
			cell = row.createCell(5);
			cell.setCellValue("※上段：届有件数、下段：無届（連絡遅延）件数");


			//18行目
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(17);
			row.setHeightInPoints(15);
			cell = row.createCell(0);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("/");
			cell = row.createCell(1);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(2);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(3);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(4);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("届出日");
			cell = row.createCell(5);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(6);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(7);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(8);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("時刻");
			cell = row.createCell(9);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(10);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("Limit");
			cell = row.createCell(11);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(12);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(13);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("連絡遅延");
			cell = row.createCell(14);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(15);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(16);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("届出区分");
			cell = row.createCell(17);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(18);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(19);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(20);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("作業場所");
			cell = row.createCell(21);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(22);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(23);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(24);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(25);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("許可者");
			cell = row.createCell(26);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(27);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(28);
			cell.setCellStyle(DOTTEDStyle);
			cell.setCellValue("備考");
			cell = row.createCell(29);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(30);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(31);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(32);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(33);
			cell.setCellStyle(DOTTEDStyle);
			cell = row.createCell(34);
			cell.setCellStyle(DOTTEDStyle);





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
						case "2-0001":
							spotname = "日立　戸塚";
							limit = "0815";
							break;
						case "2-0002":
							spotname = "横浜西ビル（NSKJひまわり）";
							limit = "0900";
							break;
						case "2-0003":
							spotname = "NTTS横浜(IC標準)";
							limit = "0930";
							break;
						case "2-0004":
							spotname = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0005":
							spotname = "ドコモR＆Dセンタ（Cカテゴリ）";
							limit = "0930";
							break;
						case "2-0006":
							spotname = "明治安田生命ビル(基盤)";
							limit = "0830";
							break;
						case "2-0007":
							spotname = "明治安田生命ビル(アプリ営業)";
							limit = "0830";
							break;
						case "2-0008":
							spotname = "明治安田生命ビル(活動基盤)";
							limit = "0830";
							break;
						case "2-0009":
							spotname = "JA川崎(普及)";
							limit = "0830";
							break;
						case "2-0010":
							spotname = "JA川崎(再構築)";
							limit = "0830";
							break;
						case "2-0011":
							spotname = "東京情報センター";
							limit = "0830";
							break;
						case "2-0012":
							spotname = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0013":
							spotname = "NTTS横浜(IC標準)";
							limit = "0930";
							break;
						case "2-0014":
							spotname = "NTTS横浜(OCN)";
							limit = "0830";
							break;
						case "2-0015":
							spotname = "穴守稲荷(ID)";
							limit = "0900";
							break;
						case "2-0016":
							spotname = "FBS（CEQ)";
							limit = "0810";
							break;
						case "2-0017":
							spotname = "日新火災";
							limit = "0830";
							break;
						case "2-0018":
							spotname = "ｱｸｾｽPF―光ｺﾗﾎﾞ対応/#P#FUTURE_F27-1";
							limit = "0900";
							break;
						case "2-0019":
							spotname = "移動機試験";
							limit = "0830";
							break;
						case "2-0020":
							spotname = "HiICS戸塚";
							limit = "0815";
							break;
						case "2-0021":
							spotname = "コンカード横浜";
							limit = "0830";
							break;
						case "2-0022":
							spotname = "三菱電機(湘セン)";
							limit = "0900";
							break;
						case "2-0023":
							spotname = "丸の内中央ビル(JR)";
							limit = "0830";
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
						case "2-0030":
							spotname = "HIENG戸塚";
							limit = "0815";
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
						case "5-0002":
							spotname = "東京建物梅田ビル（CTC）";
							limit = "0830";
							break;
						case "5-0003":
							spotname = "日本流通システム";
							limit = "0830";
							break;
						case "5-0004":
							spotname = "オージス総研　千里オフィス";
							limit = "0830";
							break;
						case "5-0005":
							spotname = "日本IBM　大阪京橋事業所";
							limit = "0830";
							break;
						case "5-0006":
							spotname = "パナソニックスマートファクトリーソリューションズ";
							limit = "0800";
							break;
						case "5-0007":
							spotname = "梅田センタービル（NTTﾃﾞｰﾀｾｷｽｲｼｽﾃﾑ）";
							limit = "0900";
							break;
						case "5-0008":
							spotname = "新ダイビル（日立ｼｽﾃﾑｽﾞ）";
							limit = "0820";
							break;
						case "5-0009":
							spotname = "東洋紡ビル（ｿﾌﾟﾗ）";
							limit = "0830";
							break;
						case "5-0010":
							spotname = "新大阪ニッセイビル（住友電工情報ｼｽﾃﾑ）";
							limit = "0800";
							break;
						case "5-0011":
							spotname = "大津市役所（日立ｼｽﾃﾑｽﾞ）";
							limit = "0820";
							break;
						case "5-0012":
							spotname = "和田岬（三菱電機製作所）";
							limit = "0815";
							break;
						case "5-0013":
							spotname = "三井住友信託銀行";
							limit = "0820";
							break;
						case "5-0014":
							spotname = "オージス総研千里オフィス";
							limit = "0830";
							break;
						case "5-0015":
							spotname = "三井住友信託銀行";
							limit = "0830";
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
						case "5-0021":
							spotname = "新大阪ニッセイビル（ニッセイ情報テクノロジー）";
							limit = "0830";
							break;
						case "5-0022":
							spotname = "大阪中之島ビル（ｱｸｾﾝﾁｭｱ）";
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
						}

						//カウントするための変数
						// 届出区分から有給休暇などを取得(例 2→有給休暇)
						switch (division.get(i)) {
						case "1":
							div="遅刻";
							break;
						case "2":
							div="有給休暇";
							break;
						case "3":
							div="振替休暇";
							break;
						case "4":
							div="特別休暇";
							break;
						case "5":
							div="シフト勤務";
							break;
						case "6":
							div="早退,その他";
							break;
						case "7":
							div="交通遅延";
							break;
						case "8":
							div="欠勤";
							break;
						case "9":
							div="深夜作業";
							break;
						case "10":
							div="休日出勤(振)";
							break;
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

						//19行目以降
						//span==span2だった場合（期間が一日だった場合）
						if (kintai_s[i].substring(6, 8).equals(
								kintai_s2[i].substring(6, 8))) {
							row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
									.createRow(day + 17);
							row.setHeightInPoints(15);
							cell = row.createCell(0);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(dada + "日");
							cell = row.createCell(1);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(2);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue("");
							cell = row.createCell(3);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(4);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(mmdd.get(i));
							cell = row.createCell(5);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(6);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(7);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(8);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(send_time.get(i));
							cell = row.createCell(9);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(10);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(limit);
							cell = row.createCell(11);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(12);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(13);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(send);
							cell = row.createCell(14);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(15);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(16);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(division.get(i));
							cell = row.createCell(17);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(div);
							cell = row.createCell(18);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(19);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(20);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(spotname);
							cell = row.createCell(21);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(22);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(23);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(24);
							cell.setCellStyle(DOTTEDStyle);
							if (perm.get(i) == null) {
								cell = row.createCell(25);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue("");
							} else {
								cell = row.createCell(25);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(perm.get(i));
							}
							cell = row.createCell(26);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(27);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(28);
							cell.setCellStyle(DOTTEDStyle);
							cell.setCellValue(remark.get(i));
							cell = row.createCell(29);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(30);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(31);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(32);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(33);
							cell.setCellStyle(DOTTEDStyle);
							cell = row.createCell(34);
							cell.setCellStyle(DOTTEDStyle);
							flg = 1;
							break;
							//span<span2だった場合(期間が連続して複数ある時)
						} else {
							for (int k = Integer.parseInt(kintai_s[i]
									.substring(6, 8)); k <= (Integer
									.parseInt(kintai_s2[i].substring(6, 8))); k++) {
								row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
										.createRow(day + 17);
								row.setHeightInPoints(15);
								cell = row.createCell(0);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(k + "日");
								cell = row.createCell(1);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(2);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue("");
								cell = row.createCell(3);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(4);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(mmdd.get(i));
								cell = row.createCell(5);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(6);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(7);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(8);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(send_time.get(i));
								cell = row.createCell(9);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(10);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(limit);
								cell = row.createCell(11);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(12);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(13);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(send);
								cell = row.createCell(14);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(15);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(16);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(division.get(i));
								cell = row.createCell(17);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(div);
								cell = row.createCell(18);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(19);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(20);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(spotname);
								cell = row.createCell(21);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(22);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(23);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(24);
								cell.setCellStyle(DOTTEDStyle);
								if (perm.get(i) == null) {
									cell = row.createCell(25);
									cell.setCellStyle(DOTTEDStyle);
									cell.setCellValue("");
								} else {
									cell = row.createCell(25);
									cell.setCellStyle(DOTTEDStyle);
									cell.setCellValue(perm.get(i));
								}
								cell = row.createCell(26);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(27);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(28);
								cell.setCellStyle(DOTTEDStyle);
								cell.setCellValue(remark.get(i));
								cell = row.createCell(29);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(30);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(31);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(32);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(33);
								cell.setCellStyle(DOTTEDStyle);
								cell = row.createCell(34);
								cell.setCellStyle(DOTTEDStyle);
								flg = 1;
								day = k;
							}
						}
					}
				}
				if (flg == 0) {
					row = ((org.apache.poi.ss.usermodel.Sheet) sheet)
							.createRow(day + 17);
					row.setHeightInPoints(15);
					cell = row.createCell(0);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue(dada + "日");
					cell = row.createCell(1);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(2);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(3);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(4);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(5);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(6);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(7);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(8);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(9);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(10);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(11);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(12);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(13);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(14);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(15);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(16);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(17);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(18);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(19);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(20);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(21);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(22);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(23);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(24);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(25);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(26);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(27);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(28);
					cell.setCellStyle(DOTTEDStyle);
					cell.setCellValue("");
					cell = row.createCell(29);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(30);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(31);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(32);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(33);
					cell.setCellStyle(DOTTEDStyle);
					cell = row.createCell(34);
					cell.setCellStyle(DOTTEDStyle);
				}
			}
			// 出力先のファイル名を指定
			out = new FileOutputStream("C:\\kintaiExcel\\"
					+ String.valueOf(KintaiManagement.Cale_Date_Year) + ""
					+ String.valueOf(KintaiManagement.Cale_Date_Month)
					+ "_勤怠連絡月報_" + lForm.getEmployee_no()
					+ lForm.getEmployee_name() + ".xlsx");
			// ブックに書き込み
			workbook.write(out);
		} finally {
			if (out != null) {
				out.close();
			}
			if (workbook != null) {
				workbook.close();
			}
		}
		return true;
	}

	// 罫線を設定
	private static CellStyle setStyle(Workbook workbook,
			BorderStyle borderStyle, short color) {
		CellStyle cellStyle = workbook.createCellStyle();
		// 罫線設定
		cellStyle.setBorderBottom(borderStyle);
		cellStyle.setBorderLeft(borderStyle);
		cellStyle.setBorderRight(borderStyle);
		cellStyle.setBorderTop(borderStyle);
		// 罫線色設定
		cellStyle.setBottomBorderColor(color);
		cellStyle.setLeftBorderColor(color);
		cellStyle.setRightBorderColor(color);
		cellStyle.setTopBorderColor(color);

		return cellStyle;

	}
}

package sample.pr.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelOutputActionNT {

	//エクセルファイルを置いているフォルダー
	static final String INPUT_DIR = "C:/Temp//excelInput/";
	static final String OUTPUT_DIR = "C:/Temp//excelOutput/";

	public String exceloutput(KintaiNotificationForm knform) throws IOException {

		// 変更するエクセルファイルを指定
		FileInputStream in  = new FileInputStream(INPUT_DIR + "勤怠届(Ver3.2).xlsm");
		Workbook wb = null;

		//遷移先指定
		String forward="";

		String sendFileName = "";

		String employee_no = knform.getEmployee_no();
		String syain_name = knform.getSyain_name();
		String depart = knform.getDepart();
		String petition_ymd = knform.getPetition_ymd();
		String attendance_startday = knform.getAttendance_startday();
		String attendance_endday = knform.getAttendance_endday();
		String attendance_starttime = knform.getAttendance_starttime();
		String attendance_endtime = knform.getAttendance_endtime();
		String notification_reason = knform.getNotification_reason();
		String vacation_division = knform.getVacation_division();
		String transfer_day = knform.getTransfer_day();
		String sp_holiday_reason = knform.getSp_holiday_reason();
		String absenteeism_reason = knform.getAbsenteeism_reason();
		String reason = knform.getReason();


		System.out.println(employee_no);
		System.out.println(syain_name);
		System.out.println(depart);
		System.out.println(petition_ymd);
		System.out.println(attendance_startday);
		System.out.println(attendance_endday);
		System.out.println(attendance_starttime);
		System.out.println(attendance_endtime);
		System.out.println(notification_reason);
		System.out.println(vacation_division);
		System.out.println(transfer_day);
		System.out.println(sp_holiday_reason);
		System.out.println(absenteeism_reason);
		System.out.println(reason);


		//編集するために原本をコピーする
		sendFileName = Filecopy(employee_no,sendFileName);

		System.out.println("Excel出力処理開始");

		try {
			// 既存のエクセルファイルを編集する際は、WorkbookFactoryを使用
			wb = WorkbookFactory.create(in);


		} catch (Exception e) {
			e.printStackTrace();
		}

		//勤務表.xlsxの勤務表シートを取得
		Sheet sheet = wb.getSheet("勤怠届");

	    Row row1 = sheet.getRow(1);
	    Row row2 = sheet.getRow(2);

	    Cell cell1_0 = row1.getCell(0);
	    Cell cell1_1 = row1.getCell(1);
	    Cell cell1_2 = row1.getCell(2);

	    Cell cell2_0 = row2.getCell(0);
	    Cell cell2_1 = row2.getCell(1);
	    Cell cell2_2 = row2.getCell(2);

	    cell1_0.setCellValue(10);
	    cell1_1.setCellValue(-8.5);
	    cell1_2.setCellValue(3.14);

	    cell2_0.setCellValue("Hello");
	    cell2_1.setCellValue("表形式");
	    cell2_2.setCellValue("3.14");

//		//社員番号を入力するセルの行(P)を取得
//		Row row = sheet.createRow(11);
//
//		//6行目の3こ目のセルを取得
//		Cell cell = row.createCell(12);
//
//		//取得したセルにセットする値を指定
//		cell.setCellValue(employee_no);
//
		FileOutputStream out = null;

		try {
			// 変更するエクセルファイルを指定
			out = new FileOutputStream(OUTPUT_DIR + sendFileName);

			// 書き込み
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			out.close();
			wb.close();

		}
		System.out.println("Excel出力処理完了");

		forward = "kintaiNotification";
		return forward;

	}

	public String Filecopy(String empNo,String sendFileName) throws IOException{


		//現在の時刻を取得する。
		LocalDateTime localDateTime =LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss");

		String timename=localDateTime.format(dateTimeFormatter);

		//コピー元ディレクトリパス
		String path_To = "C:\\Temp\\excelInput\\";

		//コピー先ディレクトリパス
		String path_From = "C:\\Temp\\excelOutput\\";

		//コピー元ファイル名
		String fileNameGen="勤怠届(Ver3.2).xlsm";

		//コピー先ファイル名
		sendFileName ="勤怠届(Ver3.2)_" +  empNo + "_"+ timename +".xlsm";

		File file = new File(path_To);

		// ファイルが存在するか確認
		if (file.exists()) {

			File dir = new File(path_From);

			// フォルダが存在するか確認
			if (!dir.exists()) {

				// フォルダを作成
				dir.mkdirs();
			}

			// パスを連結
			Path filePathFrom = Paths.get(path_From, sendFileName);

			Path filePathTo = Paths.get(path_From, fileNameGen);
			File fileFrom = new File(filePathFrom.toString());
			File fileTo = new File(filePathTo.toString());
			if (fileTo.exists()) {

				// ファイルを削除
				fileTo.delete();
			}

			// ファイルを名前変更(移動)
			fileFrom.renameTo(fileTo);
		}
		return sendFileName;
	}


}
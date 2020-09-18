package sample.pr.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
	static final String OUTPUT_DIR = "C:/Temp//excelOutput/";

	public String exceloutput(KintaiNotificationForm knform) throws IOException {

		// 変更するエクセルファイルを指定
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

		FileInputStream in = null;
		FileOutputStream out = null;

		String OutputFile=OUTPUT_DIR + sendFileName;

		try {
			// 変更するエクセルファイルを指定
			in = new FileInputStream(OutputFile);
			// 既存のエクセルファイルを編集する際は、WorkbookFactoryを使用
			wb = WorkbookFactory.create(in);

			//勤怠届.xlsxの勤怠届シートを取得
			Sheet sheet = wb.getSheet("勤怠届");

			//社員番号を入力するセルの行(P)を取得
			Row row = sheet.createRow(11);

			//6行目の3こ目のセルを取得
			Cell cell = row.createCell(12);

			//取得したセルにセットする値を指定
			cell.setCellValue(employee_no);

			// 変更するエクセルファイルを指定
			out= new FileOutputStream(OutputFile);

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

		//コピー元ファイル名
		String fileNameGen="勤怠届(Ver3.2).xlsm";

		//コピー先ファイル名
		sendFileName ="勤怠届(Ver3.2)_" +  empNo + "_"+ timename +".xlsm";

		//コピー元ディレクトリパス
		String path_To = "C:\\Temp\\excelInput\\";

		//コピー先ディレクトリパス
		String path_From = "C:\\Temp\\excelOutput\\";

		File dir = new File(path_From);

		// フォルダが存在するか確認
		if (!dir.exists()) {

			// フォルダを作成
			dir.mkdirs();
		}

		// パスを連結
		Path filePathFrom = Paths.get(path_From, sendFileName);
		Path filePathTo = Paths.get(path_To, fileNameGen);

		// ファイルを名前変更(コピー移動)
		Files.copy(filePathTo, filePathFrom);

		return sendFileName;
	}


}
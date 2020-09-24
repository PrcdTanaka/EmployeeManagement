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
	static final String OUTPUT_DIR = "C:\\Temp\\excelOutput\\";

	public boolean exceloutput(String[] kintaiItem) throws IOException {

		// 変更するエクセルファイルを指定
		Workbook wb = null;

		//編集後の名前を格納する変数
		String sendFileName = "";
		StringBuffer br = new StringBuffer();

		String employee_no = kintaiItem[0];
		String syain_name = kintaiItem[1];
		String depart = kintaiItem[2];
		String petition_ymd = kintaiItem[3];
		String attendance_startday = kintaiItem[4];
		String attendance_endday = kintaiItem[5];
		String attendance_starttime = kintaiItem[6];
		String attendance_endtime = kintaiItem[7];
		String notification_reason = kintaiItem[8];
		String vacation_division = kintaiItem[9];
		String transfer_day = kintaiItem[10];
		String sp_holiday_reason = kintaiItem[11];
		String absenteeism_reason = kintaiItem[12];
		String reason = kintaiItem[13];



		//値確認用
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


		//ループして入力するものを配列に格納する。
		String KNitem[] = new String[13];

		//社員番号、氏名を設定
		KNitem[0] = employee_no;
		KNitem[1] = syain_name;

		//所属部門を文字形式にする
		switch(depart){
		case "1":
			KNitem[2]  = "第1技術部";
			break;
		case "2":
			KNitem[2]  = "第2技術部";
			break;
		case "3":
			KNitem[2]  = "第3技術部";
			break;
		case "4":
			KNitem[2]  = "第4技術部";
			break;
		case "5":
			KNitem[2]  = "第5技術部";
			break;
		case "6":
			KNitem[2]  = "ソリューション技術部";
			break;
		default:
			KNitem[2]  = "";
			break;
		}

		//申請日を設定
		if(petition_ymd.equals("")){
			KNitem[3] = "";

		}else{
			//申請日を[yyyymmdd]⇒[yyyy/mm/dd]に形式にする。
			br.append(petition_ymd.substring(0,4)+"/");
			br.append(petition_ymd.substring(4,6)+"/");
			br.append(petition_ymd.substring(6,8));
			KNitem[3] = br.toString();

			//文字列初期化
			br.setLength(0);
		}

		//対象日(開始)を[yyyymmdd]⇒[yyyy/mm/dd]に形式にする。
		br.append(attendance_startday.substring(0,4)+"/");
		br.append(attendance_startday.substring(4,6)+"/");
		br.append(attendance_startday.substring(6,8));
		KNitem[4] = br.toString();

		//文字列初期化
		br.setLength(0);

		//対象日(終了)を[yyyymmdd]⇒[yyyy/mm/dd]形式にする。
		br.append(attendance_endday.substring(0,4)+"/");
		br.append(attendance_endday.substring(4,6)+"/");
		br.append(attendance_endday.substring(6,8));
		KNitem[5] = br.toString();


		//対象時間(開始)を設定
		if(attendance_starttime.equals("")){
			KNitem[6] = "";
		}else{
			//文字列初期化
			br.setLength(0);

			//対象時間(開始)を[hhmm]⇒[hh:mm]形式にする。
			br.append(attendance_starttime.substring(0,2)+":");
			br.append(attendance_starttime.substring(2,4));
			KNitem[6] = br.toString();
		}
		//文字列初期化
		br.setLength(0);

		//対象時間(終了)を[hhmm]⇒[hh:mm]形式にする。
		br.append(attendance_endtime.substring(0,2)+":");
		br.append(attendance_endtime.substring(2,4));
		KNitem[7] = br.toString();

		//申請事由を設定
		KNitem[8] = notification_reason;

		//振替対象日を設定
		if(transfer_day.equals("")){
			KNitem[9]=transfer_day;

		}else{
			//文字列初期化
			br.setLength(0);

			//振替対象日をyyyymmdd⇒yyyy/mm/ddに形式にする。
			br.append(transfer_day.substring(0,4)+"/");
			br.append(transfer_day.substring(4,6)+"/");
			br.append(transfer_day.substring(6,8));
			KNitem[9] = br.toString();
		}
		KNitem[10] = reason;


		/*値を入力するセル位置を配列に格納する。
		 *
		 * KNitemCell[0] ：P12
		 * KNitemCell[1] ：V11
		 * KNitemCell[2] ：V9
		 * KNitemCell[3] ：B11
		 * KNitemCell[4] ：F25
		 * KNitemCell[5] ：R25
		 * KNitemCell[6] ：F27
		 * KNitemCell[7] ：R27
		 * KNitemCell[8] ：T33
		 * KNitemCell[9] ：T35
		 * KNitemCell[10]：F41
		 */

		int KNitemCell[][] = new int[13][2];
		KNitemCell[0][0]= 11;
		KNitemCell[0][1]= 15;
		KNitemCell[1][0]= 10;
		KNitemCell[1][1]= 21;
		KNitemCell[2][0]= 8;
		KNitemCell[2][1]= 21;
		KNitemCell[3][0]= 10;
		KNitemCell[3][1]= 1;
		KNitemCell[4][0]= 24;
		KNitemCell[4][1]= 5;
		KNitemCell[5][0]= 24;
		KNitemCell[5][1]= 17;
		KNitemCell[6][0]= 26;
		KNitemCell[6][1]= 5;
		KNitemCell[7][0]= 26;
		KNitemCell[7][1]= 17;
		KNitemCell[8][0]= 32;
		KNitemCell[8][1]= 19;
		KNitemCell[9][0]= 34;
		KNitemCell[9][1]= 19;
		KNitemCell[10][0]= 40;
		KNitemCell[10][1]= 5;


		//編集するために原本をコピーする
		sendFileName = Filecopy(employee_no,sendFileName);

		//コピーに失敗した場合は出力せず返却する
		if(sendFileName.equals("")){
			return false;
		}

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


			//入力された値だけ入力する
			for (int i=0;i<11;i++){
				int j=0;
				//社員番号を入力するセルの行(P)を取得
				Row row = sheet.createRow(KNitemCell[i][j]);

				//配列をずらす。
				j++;

				//6行目の3こ目のセルを取得
				Cell cell = row.createCell(KNitemCell[i][j]);

				//値がNullである場合は次のレコードへ
				if(KNitem[i].contentEquals("")){
					continue;
				}
				//取得したセルにセットする値を指定
				cell.setCellValue(KNitem[i]);
			}

			// 変更するエクセルファイルを指定
			out= new FileOutputStream(OutputFile);

			// 書き込み
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			if(out!=null){
				out.close();
			}
			if(wb!=null){
				wb.close();
			}

		}
		System.out.println("Excel出力処理完了");

		return true;
	}
	public String Filecopy(String empNo,String sendFileName) throws IOException{

		//現在の時刻を取得する。
		LocalDateTime localDateTime =LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_kkmmss");

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
		File filefrom = new File(filePathFrom.toString());

		// ファイルを名前変更(コピー移動)
		Files.copy(filePathTo, filePathFrom);

		// コピーしたファイルが存在するか確認
		if (!filefrom.exists()) {
			return sendFileName;
		}
		return sendFileName;
	}


}
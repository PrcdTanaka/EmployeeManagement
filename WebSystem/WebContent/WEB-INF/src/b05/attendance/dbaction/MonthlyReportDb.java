package b05.attendance.dbaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.utility.FileLoader;
import b03.attendance.monthlyreport.MonthlyReportForm;


public class MonthlyReportDb extends Object{

	public String gHost;

	public String gSid;

	public String gUser;

	public String gPass;

	/**
	 * <p>メイン画面アクションの初期設定を行う。</p>
	 *
	 * 1.初期設定を行う。<br>
	 * 　1-1.データベース設定ファイル読込み処理をコール。<br>
	 * 　　クラス　：FileLoader<br>
	 * 　　メソッド：getButton(各種キー値)<br>
	 * 　2-1.フィールドに取得した値を設定する。<br>
	 *
	 * @throws IOException -
	 */
	public MonthlyReportDb() throws IOException {
		FileLoader fl = new FileLoader("Configuration.properties");
		gHost = fl.getItem("host");
		gSid = fl.getItem("sid");
		gUser = fl.getItem("user");
		gPass = fl.getItem("pass");
	}

	//勤怠連絡入力画面で送信した情報を取得
	public boolean getMonthly_report(MonthlyReportForm form, String year, String month) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String Monthly_Month = "";
		Monthly_Month = month;
		if(Monthly_Month.length()==1)
        {
			Monthly_Month="0"+Monthly_Month;
        }
		String Monthly_Date = year + Monthly_Month;

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT "+crlf);
			sb.append("SPAN,"+crlf);
			sb.append("SPAN2,"+crlf);
			sb.append("CC,"+crlf);
			sb.append("BCC," + crlf);
			sb.append("DEPART," + crlf);
			sb.append("PTIME," + crlf);
			sb.append("DIVISION,"+crlf);
			sb.append("MMDD,"+crlf);
			sb.append("SPOTCODE,"+crlf);
			sb.append("SEND_TIME,"+crlf);
			sb.append("PERM,"+crlf);
			sb.append("REMARK"+crlf);
			sb.append("FROM"+crlf);
			sb.append("KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append("EMP_NO= ?"+crlf);
			// 引数が空で呼ばれた場合は、検索処理を行わない
			if(year == "" && month == "")
			{

			}
			// 引数がKintaiList.jspのカレンダーで選択した月だった場合、検索処理を行う。
			else
			{
				sb.append("AND SPAN LIKE '" + Monthly_Date +"%'"+crlf);
			}

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SPAN");
			columnList.add("SPAN2");
			columnList.add("CC");
			columnList.add("BCC");
			columnList.add("DEPART");
			columnList.add("PTIME");
			columnList.add("DIVISION");
			columnList.add("MMDD");
			columnList.add("SPOTCODE");
			columnList.add("SEND_TIME");
			columnList.add("PERM");
			columnList.add("REMARK");


			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getEmployee_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					form.setSpan(val.get("SPAN"));
					form.setSpan2(val.get("SPAN2"));
					form.setCc(val.get("CC"));
					form.setBcc(val.get("BCC"));
					form.setDepart(val.get("DEPART"));
					form.setPtime(val.get("PTIME"));
					form.setDivision(val.get("DIVISION"));
					form.setMmdd(val.get("MMDD"));
					form.setSpotcode(val.get("SPOTCODE"));
					form.setSend_Time(val.get("SEND_TIME"));
					form.setPerm(val.get("PERM"));
					form.setRemark(val.get("REMARK"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
}

package b05.attendance.dbaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import sample.pr.main.LoginForm;
import sample.utility.FileLoader;
import a01.room.reservation.ReservationForm;
import b02.attendance.inform.KintaiMailForm;
import b03.attendance.monthlyreport.MonthlyReportForm;

public class DbAction extends Object{

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
	public DbAction() throws IOException {
		FileLoader fl = new FileLoader("Configuration.properties");
		gHost = fl.getItem("host");
		gSid = fl.getItem("sid");
		gUser = fl.getItem("user");
		gPass = fl.getItem("pass");
	}

	public boolean setKintaiInfo(KintaiMailForm form, LoginForm lform) {

		boolean ret = false;
		// DB接続
		DbConnector dba = null;
		Calendar calendar = Calendar.getInstance();
		String month=(calendar.get(calendar.MONTH)+1)+"";
		if(month.length()!=2)
			month="0"+month;
		String day=""+calendar.get(calendar.DATE);
		if(day.length()!=2)
			day="0"+day;
		String hour=""+calendar.get(calendar.HOUR_OF_DAY);
		if(hour.length()!=2){
			hour="0"+hour;
		}
		String minutes=""+calendar.get(calendar.MINUTE);
		if(minutes.length()!=2){
			minutes="0"+minutes;
		}
		String mmdd=month+day;
		String send_time=hour+minutes;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");


			sb.append("INSERT INTO" + crlf);
			sb.append("  KINTAIMAIL(" + crlf);
			sb.append("  EMP_NO," + crlf);
			sb.append("  CC," + crlf);
			sb.append("  BCC," + crlf);
			sb.append("  SPOTCODE," + crlf);
			sb.append("  DIVISION," + crlf);
			sb.append("  SPAN," + crlf);
			sb.append("  PTIME," + crlf);
			sb.append("  REMARK," + crlf);
			sb.append("  PERM," + crlf);
			sb.append("  DEPART," + crlf);
			sb.append("  MMDD," + crlf);
			sb.append("  SEND_TIME," + crlf);
			sb.append("  SPAN2" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("'"+lform.getEmployee_no()+"',"+crlf);
			sb.append("'"+form.getCC()+"',"+crlf);
			sb.append("'"+form.getBcc()+"',"+crlf);
			sb.append("'"+form.getSpotcode()+"',"+crlf);
			sb.append("'"+form.getDivision()+"',"+crlf);
			sb.append("'"+form.getSpan()+"',"+crlf);
			sb.append("'"+form.getPtime()+"',"+crlf);
			sb.append("'"+form.getRemark()+"',"+crlf);
			sb.append("'"+form.getPerm()+"',"+crlf);
			sb.append("'"+form.getDepart()+"',"+crlf);
			sb.append("'"+mmdd+"',"+crlf);
			sb.append("'"+send_time+"',"+crlf);
			sb.append("'"+form.getSpan2()+"'"+crlf);
			sb.append(")"+crlf);
			String query = sb.toString();

			// 設定値 - 型


			try {

				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ret=true;

		return ret;
	}

	/*
	 * 勤怠編集メソッド
	 */
	public boolean setKintaiEdit(KintaiMailForm form, LoginForm lform, String MMdd, String SendTime) {

		boolean ret = false;
		// DB接続
		DbConnector dba = null;
		Calendar calendar = Calendar.getInstance();
		String month=(calendar.get(calendar.MONTH)+1)+"";
		if(month.length()!=2)
			month="0"+month;
		String day=""+calendar.get(calendar.DATE);
		if(day.length()!=2)
			day="0"+day;
		String hour=""+calendar.get(calendar.HOUR_OF_DAY);
		if(hour.length()!=2){
			hour="0"+hour;
		}
		String minutes=""+calendar.get(calendar.MINUTE);
		if(minutes.length()!=2){
			minutes="0"+minutes;
		}
		String mmdd=month+day;
		String send_time=hour+minutes;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("UPDATE" + crlf);
			sb.append("  KINTAIMAIL" + crlf);
			sb.append("  SET" + crlf);
			sb.append("  EMP_NO = '"  + lform.getEmployee_no() + "'," + crlf);
			sb.append("  CC ='" + form.getCC()+"',"+crlf);
			sb.append("  BCC ='" + form.getBcc()+"',"+crlf);
			sb.append("  SPOTCODE ='" + form.getSpotcode()+"',"+crlf);
			sb.append("  DIVISION ='" + form.getDivision()+"',"+crlf);
			sb.append("  SPAN ='" + form.getSpan()+"',"+crlf);
			sb.append("  PTIME ='" + form.getPtime()+"',"+crlf);
			sb.append("  REMARK ='" + form.getRemark()+"',"+crlf);
			sb.append("  PERM ='" + form.getPerm()+"',"+crlf);
			sb.append("  DEPART ='" + form.getDepart()+"',"+crlf);
			sb.append("  MMDD ='" + mmdd+"',"+crlf);
			sb.append("  SEND_TIME ='" + send_time+"',"+crlf);
			sb.append("  SPAN2 ='" + form.getSpan2()+"'"+crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMP_NO = ?" + crlf);
			sb.append("  AND MMDD =" + MMdd + crlf);
			sb.append("  AND SEND_TIME =" + SendTime + crlf);
			String query = sb.toString();

			// 設定値 - 型
			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getEmployee_no());

			try {

				dba.executeQuery(query, typeList, bindList);
				dba.commit();
				dba.closeConnection();


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ret=true;

		return ret;
	}
	/*
	 * 勤怠連絡削除メソッド
	 */
	public boolean setKintaiDelete(KintaiMailForm form, LoginForm lform, String MMdd, String SendTime)
	{
		boolean ret = false;

		DbConnector dba=null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (dba.conSts) {


			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("DELETE FROM KINTAIMAIL" + crlf);
			sb.append(" WHERE" + crlf);
			sb.append(" SPAN = '" + form.getSpan() + "'" + crlf );
			String query = sb.toString();

			try {
				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();
				ret=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return ret;
	}

	public boolean getSPAN(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" SPAN"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SPAN");


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
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getSPAN2(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" SPAN2"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SPAN2");


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
					form.setSpan2(val.get("SPAN2"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getMMDD(ReservationForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" MMDD"+crlf);
			sb.append(",RES_TIME"+crlf);
			sb.append(",NAME"+crlf);
			sb.append(",ROOM_NAME"+crlf);
			sb.append(",MEMBER"+crlf);
			sb.append(",USE"+crlf);
			sb.append("FROM"+crlf);
			sb.append("RESERVATION"+crlf);
			sb.append("WHERE"+crlf);
			sb.append("ROOM_NAME = '2F';"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("MMDD");
			columnList.add("RES_TIME");
			columnList.add("NAME");
			columnList.add("ROOM_NAME");
			columnList.add("MEMBER");
			columnList.add("USE");


			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getRoom_name());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					form.setMmdd(val.get("MMDD"));
					form.setRes_time(val.get("RES_TIME"));
					form.setName(val.get("NAME"));
					form.setRoom_name(val.get("ROOM_NAME"));
					form.setMember(val.get("MEMBER"));
					form.setUse(val.get("USE"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getSEND_TIME(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" SEND_TIME"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SEND_TIME");


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
					form.setSend_Time(val.get("SEND_TIME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getDivision(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" DIVISION"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("DIVISION");


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
					form.setDivision(val.get("DIVISION"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	public boolean getPerm(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" PERM"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);


			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("PERM");


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
					form.setPerm(val.get("PERM"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getRemark(KintaiMailForm form) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT"+crlf);
			sb.append(" REMARK"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" KINTAIMAIL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" EMP_NO=?"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
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
					form.setRemark(val.get("REMARK"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
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

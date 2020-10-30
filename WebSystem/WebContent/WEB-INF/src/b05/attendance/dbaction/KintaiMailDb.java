package b05.attendance.dbaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sample.pr.main.LoginForm;
import sample.utility.FileLoader;
import b02.attendance.inform.KintaiMailForm;

public class KintaiMailDb extends Object{

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
	public KintaiMailDb() throws IOException {
		FileLoader fl = new FileLoader("Configuration.properties");
		gHost = fl.getItem("host");
		gSid = fl.getItem("sid");
		gUser = fl.getItem("user");
		gPass = fl.getItem("pass");
	}

	//勤怠連絡入力画面で送信した情報をDBに保存
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
}

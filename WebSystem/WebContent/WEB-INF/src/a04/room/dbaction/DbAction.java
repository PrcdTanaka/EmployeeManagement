package a04.room.dbaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.utility.FileLoader;
import a01.room.reservation.ReservationForm;
import a02.room.reservation.confirm.ReservationConfirmForm;
import a03.room.register.RoomReservationForm;

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


	public boolean InsReservation(ReservationConfirmForm form) {

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

			sb.append("INSERT INTO " + crlf);
			sb.append("  RESERVATION(room_name,mmdd,res_time,name,use,member)" + crlf);
			sb.append("values" + crlf);
			sb.append("('"+ form.getRoom_name()+"'"+crlf);
			sb.append(",'"+ form.getMmdd()+"'"+crlf);
			sb.append(",'"+ form.getRes_time()+"'"+crlf);
			sb.append(",'"+ form.getName()+"'"+crlf);
			sb.append(",'"+ form.getUse()+"'"+crlf);
			sb.append(",'"+ form.getMember()+"')"+crlf);
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

	public boolean InsRoomReservation(RoomReservationForm form) {

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

			sb.append("INSERT INTO " + crlf);
			sb.append("  ROOM_RESERVATION(room_name,place,seat,monitor,camera)" + crlf);
			sb.append("values" + crlf);
			sb.append("('"+form.getRoom_name()+"'" +crlf);
			sb.append(",'"+ form.getPlace()+"'"+crlf);
			sb.append(",'"+ form.getSeat()+"'"+crlf);
			sb.append(",'"+ form.getMonitor()+"'"+crlf);
			sb.append(",'"+ form.getCamera()+"')"+crlf);
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


	public boolean getRoomstatus(ReservationForm form) {

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

			sb.append("SELECT" + crlf);
			sb.append("  ROOM_NAME" + crlf);
			sb.append("  ,SEAT" + crlf);
			sb.append("  ,MONITOR" + crlf);
			sb.append("  ,CAMERA" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  ROOM_RESERVATION" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("ROOM_NAME");
			columnList.add("SEAT");
			columnList.add("MONITOR");
			columnList.add("CAMERA");

			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					form.setRoom_name(val.get("ROOM_NAME"));
					form.setSeat_number(val.get("SEAT"));
					form.setMonitor(val.get("MONITOR"));
					form.setCamera(val.get("CAMERA"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
}

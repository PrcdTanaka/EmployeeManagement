package sample.ap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.db.DbConnector;
import sample.pr.main.LoginForm;
import sample.pr.main.MainForm;
import sample.utility.FileLoader;

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

	/**
	 * <p>
	 * 勤怠情報を取得する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getKintaiInfo(LoginForm form) {

		boolean ret = true;

		try {
			DbConnector dba = new DbConnector(gHost, gSid, gUser, gPass);
		} catch (IOException e) {
			ret = false;
			e.printStackTrace();
		}



		return ret;
	}
	/**
	 * <p>
	 * 社員番号を取得する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getEmoloyee_No(LoginForm form) {

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
			sb.append("  EMPLOYEE_NO" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  EMPLOYEE_MST" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("EMPLOYEE_NO");

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
					form.setEmployee_name(val.get("SYAIN_NAME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}

	/**
	 * <p>
	 * 社員名を取得する。
	 * </p>
	 * 
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 * 
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getEmployeeName(MainForm form) {

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
			sb.append("  SYAIN_NAME" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  MST_SYAIN_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  SYAIN_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SYAIN_NAME");

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
					form.setEmployee_name(val.get("SYAIN_NAME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}


	/**
	 * <p>
	 * 出退勤時間を取得する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getTimeFromTo(LoginForm form) {

		boolean ret = true;
	//	String datetime = form.getTime_from();
	//	String [] dtime_box = datetime.split(",",0);

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			ret = false;
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT" + crlf);
			sb.append("  TIME_FROM," + crlf);
			sb.append("  TIME_TO" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  KINTAI_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  SYAIN_NO = ?" + crlf);
		//	sb.append("  AND  DAY = " + dtime_box[0] + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("TIME_FROM");
			columnList.add("TIME_TO");

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
				//	form.setTime_from(val.get("TIME_FROM"));
				//	form.setTime_to(val.get("TIME_TO"));
					ret = false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}




	/**
	 * <p>
	 * 出社時刻を設定する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean setTimeFrom(LoginForm form) {

		boolean ret = true;
	//	String datetime = form.getTime_from();
	//	String [] dtime_box = datetime.split(",",0);

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			ret = false;
			e1.printStackTrace();
		}

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("INSERT INTO" + crlf);
			sb.append("  KINTAI_TBL(" + crlf);
			sb.append("  SYAIN_NO," + crlf);
			sb.append("  DAY," + crlf);
			sb.append("  TIME_FROM)" + crlf);
			sb.append("VALUES(" + crlf);
			sb.append("  ?" + crlf);
		//	sb.append("  ,'" + dtime_box[0]);
		//	sb.append("','" + dtime_box[1]);
			sb.append("')" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("SYAIN_NO");

			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getEmployee_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, typeList, bindList);
				dba.commit();
				dba.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}

	/**
	 * <p>
	 * 退社時刻を設定する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean setTimeTo(LoginForm form) {
		return true;
	}

	/**
	 * <p>
	 * pwを取得する。
	 * </p>
	 *
	 * 1.DBに接続する。<br>
	 * 2.DB接続に成功したらSQLの発行。<br>
	 * 　　2-1.発行するSQLと項目の情報を生成する。<br>
	 * 　　　SQL設定<br>
	 * 　　　取得項目設定<br>
	 * 　　　型設定<br>
	 * 　　　検索条件設定<br>
	 * 　　2-2.SQLを発行。<br>
	 * 　　　クラス　：DbConnector<br>
	 * 　　　メソッド：executeQuery()<br>
	 * 　　　引数１　：SQL設定<br>
	 * 　　　引数２　：取得項目設定<br>
	 * 　　　引数３　：型設定<br>
	 * 　　　引数４　：検索条件設定<br>
	 * 　　　引数５　：返却値用リスト<br>
	 * 　　2-3.SQLの実行。<br>
	 * 3.DB接続解除。<br>
	 * 4.DBから取得した情報をアクションフォームに設定。<br>
	 * 5.例外発生時の処理。<br>
	 * 　　5-1.スタックトレースを出力。<br>
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getPassword(LoginForm form) {

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
			sb.append("  PASSWORD" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  EMPLOYEE_MST" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  PASSWORD = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("PASSWORD");

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
					form.setEmployee_name(val.get("PASSWORD"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
}

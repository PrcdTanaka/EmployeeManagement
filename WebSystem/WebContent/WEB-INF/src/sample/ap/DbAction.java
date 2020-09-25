package sample.ap;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import sample.db.DbConnector;
import sample.pr.main.AttendanceForm;
import sample.pr.main.EnterForm;
//import sample.pr.main.KinmuRecordForm;
import sample.pr.main.KinmuRecordSendForm;
import sample.pr.main.KintaiMailForm;
import sample.pr.main.KintaiNotificationForm;
import sample.pr.main.LoginForm;
import sample.pr.main.MainForm;
import sample.pr.main.MonthlyReportForm;
import sample.pr.main.Open_informationForm;
import sample.pr.main.PasswordForm;
import sample.pr.main.Personal_informationForm;
import sample.pr.main.RegisterForm;
import sample.pr.main.RoomReservationForm;
import sample.pr.main.SearchForm;
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
			sb.append("  NAME" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("NAME");

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
					form.setEmployee_name(val.get("NAME"));
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
	public boolean getEmployeeName(LoginForm form) {

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
			sb.append("  NAME" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("NAME");

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
					form.setEmployee_name(val.get("NAME"));
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
	 * 管理者フラグを取得する。
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
	public boolean getManager(LoginForm form) {

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
			sb.append("  MANAGER_FLAG" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  EMPLOYEE_MST" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("MANAGER_FLAG");

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
					form.setManager(val.get("MANAGER_FLAG"));
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
			sb.append("  EMPLOYEE_NO = ?" + crlf);

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
					form.setPassword(val.get("PASSWORD"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	/**
	 * ユーザー検索処理
	 * nullなら全件表示
	 * 小牧誠治
	 */
	public boolean getSearchAns(SearchForm form) {
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
			sb.append(" DEPARTMENT," + crlf);
			sb.append(" NAME,"+crlf);
			sb.append(" PUBLIC_INFORMATION_TBL.EMPLOYEE_NO," + crlf);
			sb.append(" MANAGER_FLAG"+crlf);
			sb.append("FROM" + crlf);
			sb.append(" PUBLIC_INFORMATION_TBL" + crlf);
			sb.append("LEFT OUTER JOIN" + crlf);
			sb.append(" PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("ON" + crlf);
			sb.append(" PUBLIC_INFORMATION_TBL.EMPLOYEE_NO=PERSONAL_INFORMATION_TBL.EMPLOYEE_NO" + crlf);
			sb.append("LEFT OUTER JOIN" + crlf);
			sb.append(" EMPLOYEE_MST" + crlf);
			sb.append("ON" + crlf);
			sb.append(" EMPLOYEE_MST.EMPLOYEE_NO=PERSONAL_INFORMATION_TBL.EMPLOYEE_NO" + crlf);
			if(form.getText().equals("")){
				sb.append("WHERE" + crlf);
				sb.append( "MANAGER_FLAG=?"+crlf);
			}
			else{
				sb.append("WHERE" + crlf);
				sb.append("MANAGER_FLAG=0 AND" + crlf);
				sb.append(  form.getRadio()+crlf);
				sb.append("LIKE ?");
			}


			//			if(form.getText()!=null)
			//
			//			else
			//				sb.append("*;");

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("DEPARTMENT");
			columnList.add("NAME");
			columnList.add("EMPLOYEE_NO");

			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);


			// 設定値 - 値
			List<Object> bindList= new ArrayList<Object>();
			if(form.getText().equals(""))
				bindList.add("0");
			else
				bindList.add("%"+form.getText()+"%");



			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;
			try {
				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();


				for (Map<String, String> val : rsList) {
					form.setDepertment(val.get("DEPARTMENT"));
					form.setEmployee_name(val.get("NAME"));
					form.setEmployee_no(val.get("EMPLOYEE_NO"));
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
	 * 社員番号確認処理
	 * </p>
	 *
	 * @param form ユーザー登録画面アクションフォーム
	 * @return 重複ナシ：true DB接続失敗,重複アリ：false
	 */
	public boolean confirmationNo(RegisterForm form){

		boolean ret = true;

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
					ret = false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	/***
	 * <p>
	 * 新規ユーザーを登録する。
	 * </p>
	 *
	 * @param form ユーザー登録画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean userRegister(RegisterForm form){

		boolean ret = true;
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

			sb.append("INSERT INTO EMPLOYEE_MST(" + crlf);
			sb.append("  EMPLOYEE_NO," + crlf);
			sb.append("  PASSWORD," + crlf);
			sb.append("  MANAGER_FLAG" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  '" + form.getEmployee_no() + "'," + crlf);
			sb.append("  '" + form.getPassword() + "'," + crlf);
			sb.append("  0" + crlf);
			sb.append(")" + crlf);

			String query = sb.toString();

			try {

				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}
		}
		return ret;
	}

	/***
	 * <p>
	 * 新規ユーザーを登録する。
	 * </p>
	 *
	 * @param form ユーザー登録画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */

	public boolean userRegister2(RegisterForm form){

		boolean ret = true;
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

			sb.append("INSERT INTO PUBLIC_INFORMATION_TBL(" + crlf);
			sb.append("  EMPLOYEE_NO" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  '" + form.getEmployee_no() +"'" +crlf);
			sb.append(")" + crlf);

			String query = sb.toString();

			try {

				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}
		}
		return ret;
	}
	public boolean userRegister3(RegisterForm form){

		boolean ret = true;
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

			sb.append("INSERT INTO PERSONAL_INFORMATION_TBL(" + crlf);
			sb.append("  EMPLOYEE_NO" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  '" + form.getEmployee_no() +"'" +crlf);
			sb.append(")" + crlf);

			String query = sb.toString();

			try {

				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}
		}
		return ret;
	}
	/***
	 * <p>
	 * パスワードを取得する。
	 * </p>
	 *
	 * @param form パスワード変更画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */

	public boolean getPassword(PasswordForm form) {

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
					form.setDbpassword(val.get("SYAIN_NAME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/***
	 * <p>
	 * パスワードを変更する。
	 * </p>
	 *
	 * @param form パスワード変更画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */

	public boolean setPassword(PasswordForm form) {

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

			sb.append("UPDATE" + crlf);
			sb.append("EMPLOYEE_MST" + crlf);
			sb.append("SET" + crlf);
			sb.append("PASSWORD = " + "'" +form.getNewpassword1()+"'" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

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

				for (Map<String, String> val : rsList) {
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public boolean getDbpassword(PasswordForm form) {
		// TODO 自動生成されたメソッド・スタブ
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
			sb.append("password" + crlf);
			sb.append("FROM" + crlf);
			sb.append("EMPLOYEE_MST"  + crlf);
			sb.append("WHERE" + crlf);
			sb.append("employee_no = ?" + crlf);

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
					form.setDbpassword(val.get("PASSWORD"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * 社員名を取得する。
	 *
	 * @param form メイン画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getEmoloyee_Name(Personal_informationForm form) {

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
			sb.append("  NAME" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("NAME");

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
					if (val.get("NAME") != null) {
						form.setEmployee_name(val.get("NAME"));
						ret = true;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	/**
	 * 個人情報設定処理
	 * @param form
	 * @return
	 */
	public boolean setPersonalData(Personal_informationForm form) {

		boolean ret = true;

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

			sb.append("UPDATE" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("SET" + crlf);
			sb.append("  NAME = '" + form.getEmployee_name() + "'," + crlf);
			sb.append("  FURIGANA_NAME = '" + form.getFurigana_name() + "'," + crlf);
			sb.append("  SEX = '" + form.getSex() + "'," + crlf);
			sb.append("  BIRTH = '" + form.getBirth() + "'," + crlf);
			sb.append("  POSTAL_CODE = '" + form.getPostal_code() + "'," + crlf);
			sb.append("  ADDRESS = '" + form.getAddress() + "'," + crlf);
			sb.append("  DIVISION = '" + form.getDivision() + "'," + crlf);
			sb.append("  TEL_HOME = '" + form.getTel_home() + "'," + crlf);
			sb.append("  TEL_PHONE = '" + form.getTel_phone() + "'," + crlf);
			sb.append("  EMERGENCY_ADDRESS = '" + form.getEmergency_address() + "'," + crlf);
			sb.append("  EMERGENCY_TEL = '" + form.getEmergency_tel() + "'," + crlf);
			if(form.getQuestion()!=null){
				sb.append("  QUESTION = '" + form.getQuestion() + "'," + crlf);
				sb.append("  ANSWER = '" + form.getAnswer() + "'," + crlf);
			}
			if(form.getQuestion2()!=null){
				sb.append("  QUESTION2 = '" + form.getQuestion2() + "'," + crlf);
				sb.append("  ANSWER2 = '" + form.getAnswer2() + "'" + crlf);
			}
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

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
				ret = false;
			}
		}


		return ret;
	}

	/**
	 * 社員番号確認処理
	 *
	 * @param form アクションフォーム
	 * @param table 確認テーブル名
	 * @param no 検索値
	 * @return true：存在する , false：存在しない or 接続失敗
	 */
	public boolean getEmployee_no(Personal_informationForm form,String table, int no){

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
			sb.append("  " + table + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);
			sb.append("AND  NO = '" + no + "'" + crlf);

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
					if (val.get("EMPLOYEE_NO") != null) {
						ret = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return ret;
	}


	/**
	 * 緊急連絡先設定処理
	 * @param form
	 * @return
	 */
	public boolean setEmergencyContactU(Personal_informationForm form, int no) {

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


			sb.append("UPDATE" + crlf);
			sb.append("  EMERGENCY_CONTACT_TBL " + crlf);
			sb.append("SET" + crlf);
			switch(no) {
			case 1:
				sb.append("  NAME ='"  + form.getEmergency_name1() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getRelationship1() + "'," + crlf);
				sb.append("  TEL ='" + form.getEmergency_tel1() + "'" + crlf);
				break;
			case 2:
				sb.append("  NAME ='"  + form.getEmergency_name2() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getRelationship2() + "'," + crlf);
				sb.append("  TEL ='" + form.getEmergency_tel2() + "'" + crlf);
				break;
			case 3:
				sb.append("  NAME ='"  + form.getEmergency_name3() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getRelationship3() + "'," + crlf);
				sb.append("  TEL ='" + form.getEmergency_tel3() + "'" + crlf);
				break;
			case 4:
				sb.append("  NAME ='"  + form.getEmergency_name4() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getRelationship4() + "'," + crlf);
				sb.append("  TEL ='" + form.getEmergency_tel4() + "'" + crlf);
				break;
			case 5:
				sb.append("  NAME ='"  + form.getEmergency_name5() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getRelationship5() + "'," + crlf);
				sb.append("  TEL ='" + form.getEmergency_tel5() + "'" + crlf);
				break;

			}
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);
			sb.append("AND NO = " + no + crlf);


			String query = sb.toString();

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


		return ret;
	}

	/**
	 * 緊急連絡先設定処理
	 * @param form
	 * @return
	 */
	public boolean setEmergencyContactI(Personal_informationForm form, int no) {

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

			sb.append("INSERT INTO" + crlf);
			sb.append("  EMERGENCY_CONTACT_TBL (" + crlf);
			sb.append("  EMPLOYEE_NO," + crlf);
			sb.append("  NO," + crlf);
			sb.append("  NAME," + crlf);
			sb.append("  RELATIONSHIP," + crlf);
			sb.append("  TEL" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  ?," + crlf);
			sb.append("  '" + no + "'," + crlf);
			switch(no){
			case 1:
				sb.append("  '" + form.getEmergency_name1() + "'," + crlf);
				sb.append("  '" + form.getRelationship1() + "'," + crlf);
				sb.append("  '" + form.getEmergency_tel1() + "'" + crlf);
				break;
			case 2:
				sb.append("  '" + form.getEmergency_name2() + "'," + crlf);
				sb.append("  '" + form.getRelationship2() + "'," + crlf);
				sb.append("  '" + form.getEmergency_tel2() + "'" + crlf);
				break;
			case 3:
				sb.append("  '" + form.getEmergency_name3() + "'," + crlf);
				sb.append("  '" + form.getRelationship3() + "'," + crlf);
				sb.append("  '" + form.getEmergency_tel3() + "'" + crlf);
				break;
			case 4:
				sb.append("  '" + form.getEmergency_name4() + "'," + crlf);
				sb.append("  '" + form.getRelationship4() + "'," + crlf);
				sb.append("  '" + form.getEmergency_tel4() + "'" + crlf);
				break;
			case 5:
				sb.append("  '" + form.getEmergency_name5() + "'," + crlf);
				sb.append("  '" + form.getRelationship5() + "'," + crlf);
				sb.append("  '" + form.getEmergency_tel5() + "'" + crlf);
				break;
			}
			sb.append(")" + crlf);

			String query = sb.toString();

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


		return ret;
	}

	/**
	 * 家族構成設定処理
	 * @param form
	 * @return
	 */
	public boolean setFamilyStructureU(Personal_informationForm form, int no) {

		boolean ret = true;

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


			sb.append("UPDATE" + crlf);
			sb.append("  FAMILY_STRUCTURE_TBL " + crlf);
			sb.append("SET" + crlf);
			switch(no) {
			case 1:
				sb.append("  NAME ='" + form.getFamily_structure_name1() + "'," + crlf);
				sb.append("  FURIGANA ='" + form.getFamily_structure_furigana1() + "'," + crlf);
				sb.append("  SEX = '" + form.getFamily_structure_sex1() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getFamily_structure_relationship1() + "'," + crlf);
				sb.append("  BIRTH ='"  + form.getFamily_structure_birth1() + "'," + crlf);
				sb.append("  RESIDENCE ='"  + form.getFamily_structure_residence1() + "'," + crlf);
				sb.append("  SUPPORT = '" + form.getFamily_structure_support1() + "'," + crlf);
				sb.append("  JOB = '" + form.getFamily_structure_job1() + "'" + crlf);
				break;
			case 2:
				sb.append("  NAME ='" + form.getFamily_structure_name2() + "'," + crlf);
				sb.append("  FURIGANA ='" + form.getFamily_structure_furigana2() + "'," + crlf);
				sb.append("  SEX = '" + form.getFamily_structure_sex2() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getFamily_structure_relationship2() + "'," + crlf);
				sb.append("  BIRTH ='"  + form.getFamily_structure_birth2() + "'," + crlf);
				sb.append("  RESIDENCE ='"  + form.getFamily_structure_residence2() + "'," + crlf);
				sb.append("  SUPPORT = '" + form.getFamily_structure_support2() + "'," + crlf);
				sb.append("  JOB = '" + form.getFamily_structure_job2() + "'" + crlf);
				break;
			case 3:
				sb.append("  NAME ='" + form.getFamily_structure_name3() + "'," + crlf);
				sb.append("  FURIGANA ='" + form.getFamily_structure_furigana3() + "'," + crlf);
				sb.append("  SEX = '" + form.getFamily_structure_sex3() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getFamily_structure_relationship3() + "'," + crlf);
				sb.append("  BIRTH ='"  + form.getFamily_structure_birth3() + "'," + crlf);
				sb.append("  RESIDENCE ='"  + form.getFamily_structure_residence3() + "'," + crlf);
				sb.append("  SUPPORT = '" + form.getFamily_structure_support3() + "'," + crlf);
				sb.append("  JOB = '" + form.getFamily_structure_job3() + "'" + crlf);
				break;
			case 4:
				sb.append("  NAME ='" + form.getFamily_structure_name4() + "'," + crlf);
				sb.append("  FURIGANA ='" + form.getFamily_structure_furigana4() + "'," + crlf);
				sb.append("  SEX = '" + form.getFamily_structure_sex4() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getFamily_structure_relationship4() + "'," + crlf);
				sb.append("  BIRTH ='"  + form.getFamily_structure_birth4() + "'," + crlf);
				sb.append("  RESIDENCE ='"  + form.getFamily_structure_residence4() + "'," + crlf);
				sb.append("  SUPPORT = '" + form.getFamily_structure_support4() + "'," + crlf);
				sb.append("  JOB = '" + form.getFamily_structure_job4() + "'" + crlf);
				break;
			case 5:
				sb.append("  NAME ='" + form.getFamily_structure_name5() + "'," + crlf);
				sb.append("  FURIGANA ='" + form.getFamily_structure_furigana5() + "'," + crlf);
				sb.append("  SEX = '" + form.getFamily_structure_sex5() + "'," + crlf);
				sb.append("  RELATIONSHIP ='"  + form.getFamily_structure_relationship5() + "'," + crlf);
				sb.append("  BIRTH ='"  + form.getFamily_structure_birth5() + "'," + crlf);
				sb.append("  RESIDENCE ='"  + form.getFamily_structure_residence5() + "'," + crlf);
				sb.append("  SUPPORT = '" + form.getFamily_structure_support5() + "'," + crlf);
				sb.append("  JOB = '" + form.getFamily_structure_job5() + "'" + crlf);
				break;

			}
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);
			sb.append("AND NO = " + no + crlf);


			String query = sb.toString();

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
				ret = false;
			}
		}


		return ret;
	}

	/**
	 * 家族構成設定処理
	 * @param form
	 * @return
	 */
	public boolean setFamilyStructureI(Personal_informationForm form, int no) {

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

			sb.append("INSERT INTO" + crlf);
			sb.append("  FAMILY_STRUCTURE_TBL (" + crlf);
			sb.append("  EMPLOYEE_NO," + crlf);
			sb.append("  NO," + crlf);
			sb.append("  NAME," + crlf);
			sb.append("  FURIGANA," + crlf);
			sb.append("  SEX," + crlf);
			sb.append("  RELATIONSHIP," + crlf);
			sb.append("  BIRTH," + crlf);
			sb.append("  RESIDENCE," + crlf);
			sb.append("  SUPPORT," + crlf);
			sb.append("  JOB" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  ?," + crlf);
			sb.append("'" + no + "'," + crlf);
			switch(no){
			case 1:
				sb.append("  '" + form.getFamily_structure_name1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_furigana1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_sex1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_relationship1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_birth1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_residence1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_support1() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_job1() + "'" + crlf);
				break;
			case 2:
				sb.append("  '" + form.getFamily_structure_name2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_furigana2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_sex2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_relationship2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_birth2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_residence2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_support2() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_job2() + "'" + crlf);
				break;
			case 3:
				sb.append("  '" + form.getFamily_structure_name3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_furigana3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_sex3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_relationship3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_birth3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_residence3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_support3() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_job3() + "'" + crlf);
				break;
			case 4:
				sb.append("  '" + form.getFamily_structure_name4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_furigana4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_sex4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_relationship4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_birth4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_residence4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_support4() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_job4() + "'" + crlf);
				break;
			case 5:
				sb.append("  '" + form.getFamily_structure_name5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_furigana5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_sex5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_relationship5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_birth5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_residence5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_support5() + "'," + crlf);
				sb.append("  '" + form.getFamily_structure_job5() + "'" + crlf);
				break;
			}
			sb.append(")" + crlf);

			String query = sb.toString();

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


		return ret;
	}

	/**
	 * 個人情報を取得する。
	 *
	 * @param form
	 * @return
	 * @throws ParseException
	 */
	public boolean getPersonalData(Personal_informationForm form) throws ParseException {

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
			sb.append("  HIRE_DATE," + crlf);
			sb.append("  NAME," + crlf);
			sb.append("  FURIGANA_NAME," + crlf);
			sb.append("  SEX," + crlf);
			sb.append("  BIRTH," + crlf);
			sb.append("  POSTAL_CODE," + crlf);
			sb.append("  ADDRESS," + crlf);
			sb.append("  DIVISION," + crlf);
			sb.append("  TEL_HOME," + crlf);
			sb.append("  TEL_PHONE," + crlf);
			sb.append("  EMERGENCY_ADDRESS," + crlf);
			sb.append("  EMERGENCY_TEL," + crlf);
			sb.append("  DOCUMENT," + crlf);
			sb.append("  NB," + crlf);
			sb.append("  CONFIRMER" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("HIRE_DATE");
			columnList.add("NAME");
			columnList.add("FURIGANA_NAME");
			columnList.add("SEX");
			columnList.add("BIRTH");
			columnList.add("POSTAL_CODE");
			columnList.add("ADDRESS");
			columnList.add("DIVISION");
			columnList.add("TEL_HOME");
			columnList.add("TEL_PHONE");
			columnList.add("EMERGENCY_ADDRESS");
			columnList.add("EMERGENCY_TEL");
			columnList.add("DOCUMENT");
			columnList.add("NB");
			columnList.add("CONFIRMER");

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
					form.setHire_date(val.get("HIRE_DATE"));
					form.setEmployee_name(val.get("NAME"));
					form.setFurigana_name(val.get("FURIGANA_NAME"));
					form.setSex(val.get("SEX"));
					/*SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
					form.setBirth(sdFormat.parse(val.get("BIRTH")));
					 */
					form.setBirth(val.get("BIRTH"));
					form.setPostal_code(val.get("POSTAL_CODE"));
					form.setAddress(val.get("ADDRESS"));
					form.setDivision(val.get("DIVISION"));
					form.setTel_home(val.get("TEL_HOME"));
					form.setTel_phone(val.get("TEL_PHONE"));
					form.setEmergency_address(val.get("EMERGENCY_ADDRESS"));
					form.setEmergency_tel1(val.get("EMERGENCY_TEL"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}


	/**
	 * 緊急連絡先を取得する。
	 *
	 * @param form
	 * @return
	 */
	public boolean getEmergencyContact(Personal_informationForm form) {

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
			sb.append("  EMPLOYEE_NO," + crlf);
			sb.append("  NO," + crlf);
			sb.append("  NAME," + crlf);
			sb.append("  RELATIONSHIP," + crlf);
			sb.append("  TEL" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  EMERGENCY_CONTACT_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("EMPLOYEE_NO");
			columnList.add("NO");
			columnList.add("NAME");
			columnList.add("RELATIONSHIP");
			columnList.add("TEL");

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

				int count = 0;
				for (Map<String, String> val : rsList) {
					String no = val.get("NO");
					switch(no){
					case "1":
						form.setEmergency_name1(val.get("NAME"));
						form.setRelationship1(val.get("RELATIONSHIP"));
						form.setEmergency_tel1(val.get("TEL"));
						break;
					case "2":
						form.setEmergency_name2(val.get("NAME"));
						form.setRelationship2(val.get("RELATIONSHIP"));
						form.setEmergency_tel2(val.get("TEL"));
						break;
					case "3":
						form.setEmergency_name3(val.get("NAME"));
						form.setRelationship3(val.get("RELATIONSHIP"));
						form.setEmergency_tel3(val.get("TEL"));
						break;
					case "4":
						form.setEmergency_name4(val.get("NAME"));
						form.setRelationship4(val.get("RELATIONSHIP"));
						form.setEmergency_tel4(val.get("TEL"));
						break;
					case "5":
						form.setEmergency_name5(val.get("NAME"));
						form.setRelationship5(val.get("RELATIONSHIP"));
						form.setEmergency_tel5(val.get("TEL"));
						break;

					}
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * 家族構成を取得する。
	 *
	 * @param form
	 * @return
	 */
	public boolean getFamily(Personal_informationForm form) {

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
			sb.append("  NO," + crlf);
			sb.append("  NAME," + crlf);
			sb.append("  FURIGANA," + crlf);
			sb.append("  SEX," + crlf);
			sb.append("  RELATIONSHIP," + crlf);
			sb.append("  BIRTH," + crlf);
			sb.append("  RESIDENCE," + crlf);
			sb.append("  SUPPORT," + crlf);
			sb.append("  JOB" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  FAMILY_STRUCTURE_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("NO");
			columnList.add("NAME");
			columnList.add("FURIGANA");
			columnList.add("SEX");
			columnList.add("RELATIONSHIP");
			columnList.add("BIRTH");
			columnList.add("RESIDENCE");
			columnList.add("SUPPORT");
			columnList.add("JOB");

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

				int count = 0;
				for (Map<String, String> val : rsList) {
					String no = val.get("NO");
					switch(no){
					case "1":
						form.setFamily_structure_name1(val.get("NAME"));
						form.setFamily_structure_furigana1(val.get("FURIGANA"));
						form.setFamily_structure_sex1(val.get("SEX"));
						form.setFamily_structure_birth1(val.get("BIRTH"));
						form.setFamily_structure_relationship1(val.get("RELATIONSHIP"));
						form.setFamily_structure_support1(val.get("SUPPORT"));
						form.setFamily_structure_job1(val.get("JOB"));
						break;
					case "2":
						form.setFamily_structure_name2(val.get("NAME"));
						form.setFamily_structure_furigana2(val.get("FURIGANA"));
						form.setFamily_structure_sex2(val.get("SEX"));
						form.setFamily_structure_birth2(val.get("BIRTH"));
						form.setFamily_structure_relationship2(val.get("RELATIONSHIP"));
						form.setFamily_structure_support2(val.get("SUPPORT"));
						form.setFamily_structure_job2(val.get("JOB"));
						break;
					case "3":
						form.setFamily_structure_name3(val.get("NAME"));
						form.setFamily_structure_furigana3(val.get("FURIGANA"));
						form.setFamily_structure_sex3(val.get("SEX"));
						form.setFamily_structure_birth3(val.get("BIRTH"));
						form.setFamily_structure_relationship3(val.get("RELATIONSHIP"));
						form.setFamily_structure_support3(val.get("SUPPORT"));
						form.setFamily_structure_job3(val.get("JOB"));
						break;
					case "4":
						form.setFamily_structure_name4(val.get("NAME"));
						form.setFamily_structure_furigana4(val.get("FURIGANA"));
						form.setFamily_structure_sex4(val.get("SEX"));
						form.setFamily_structure_birth4(val.get("BIRTH"));
						form.setFamily_structure_relationship4(val.get("RELATIONSHIP"));
						form.setFamily_structure_support4(val.get("SUPPORT"));
						form.setFamily_structure_job4(val.get("JOB"));
						break;
					case "5":
						form.setFamily_structure_name5(val.get("NAME"));
						form.setFamily_structure_furigana5(val.get("FURIGANA"));
						form.setFamily_structure_sex5(val.get("SEX"));
						form.setFamily_structure_birth5(val.get("BIRTH"));
						form.setFamily_structure_relationship5(val.get("RELATIONSHIP"));
						form.setFamily_structure_support5(val.get("SUPPORT"));
						form.setFamily_structure_job5(val.get("JOB"));
						break;
					}
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	/***
	 * <p>
	 * 公開情報を登録する。
	 * </p>
	 *
	 * @param form 公開情報編集画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */

	public boolean setOpen(Open_informationForm form) {

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

			sb.append("UPDATE" + crlf);
			sb.append("PUBLIC_INFORMATION_TBL" + crlf);
			sb.append("SET" + crlf);
			sb.append("DEPARTMENT = " + "'" +form.getTec()+"'" + crlf);
			sb.append(",POST = " + "'" +form.getPos()+"'" + crlf);
			sb.append(",HOBBIES = " + "'" +form.getHobby()+"'" + crlf);
			sb.append(",SPECIALTY = " + "'" +form.getSs()+"'" + crlf);
			sb.append(",INTRODUCTION = " + "'" +form.getIntr()+"'" + crlf);
			sb.append(",IMG = " + "'" +form.getImg()+"'" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

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

				ret = true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/***
	 * <p>
	 * 公開情報を取得する。
	 * </p>
	 *
	 * @param form 公開情報編集画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getMizuki(Open_informationForm form) {

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
			sb.append("  department" + crlf);
			sb.append("  ,post" + crlf);
			sb.append("  ,hobbies" + crlf);
			sb.append("  ,specialty" + crlf);
			sb.append("  ,introduction" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  PUBLIC_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("department");
			columnList.add("post");
			columnList.add("hobbies");
			columnList.add("specialty");
			columnList.add("introduction");
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
					form.setTec(val.get("department"));
					form.setPos(val.get("post"));
					form.setHobby(val.get("hobbies"));
					form.setSs(val.get("specialty"));
					form.setIntr(val.get("introduction"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	/***
	 * <p>
	 * 入社年月日を取得する。
	 * </p>
	 *
	 * @param form パスワード変更画面アクションフォーム
	 * @return DB接続成功：true DB接続失敗：false
	 */
	public boolean getHire_date(Open_informationForm form) {

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
			sb.append("HIRE_DATE"+crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("HIRE_DATE");
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
					form.setDjc(val.get("HIRE_DATE"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getTel_phone(Personal_informationForm form) {

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
			sb.append("TEL_PHONE"+crlf);
			sb.append("FROM" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("TEL_PHONE");
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
					form.setTel_phone(val.get("TEL_PHONE"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean setConfirm(Personal_informationForm form,LoginForm lform) {

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

			sb.append("UPDATE" + crlf);
			sb.append("  PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("SET" + crlf);
			sb.append("  DOCUMENT='"+ form.getDocument()+"'," + crlf);
			//			sb.append("  NB"  + form.getNb() + crlf);
			sb.append("  CONFIRMER='" + lform.getEmployee_no()+"'"+ crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

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
			ret = true;
		}

		return ret;
	}

	public boolean setHire_date(Personal_informationForm form) {

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

			sb.append("UPDATE" + crlf);
			sb.append("PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("SET" + crlf);
			sb.append("HIRE_DATE = " + "'" +form.getHire_date()+"'" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("EMPLOYEE_NO = ?" + crlf);

			String query = sb.toString();

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

				ret = true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public boolean getStart_time(AttendanceForm aForm,LoginForm lForm){
		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			Calendar calendar = Calendar.getInstance();
			String month=(calendar.get(calendar.MONTH)+1)+"";
			if(month.length()!=2)
				month="0"+month;
			String date=calendar.get(calendar.DATE)+"";
			if(date.length()!=2)
				date="0"+date;
			String cale =month+date;
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			sb.append("SELECT" + crlf);
			sb.append("START_TIME"+crlf);
			sb.append("FROM" + crlf);
			sb.append("  ATTEND" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO =? AND"+ crlf);
			sb.append("  MMDD='"+cale+"'"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("START_TIME");
			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);
			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(lForm.getEmployee_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();
				for (Map<String, String> val : rsList) {
					aForm.setStart_time(val.get("START_TIME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public boolean setStart_time(AttendanceForm aForm,LoginForm lForm){
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
			if(getStart_time(aForm, lForm)){

			}
			else{
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
				String time=hour+minutes;
				String cale =month+day;
				sb.append("INSERT INTO" + crlf);
				sb.append("  ATTEND(EMPLOYEE_NO,START_TIME,MMDD)" + crlf);
				sb.append("VALUES" + crlf);
				sb.append("  ( ?");
				sb.append("  ,"+time+",'"+cale+"')"+ crlf);
				String query = sb.toString();

				// 設定値 - 型
				List<Integer> typeList = new ArrayList<Integer>();
				typeList.add(dba.DB_STRING);

				// 設定値 - 値
				List<Object> bindList = new ArrayList<Object>();

				bindList.add(lForm.getEmployee_no());

				try {

					dba.executeQuery(query, typeList, bindList);
					dba.commit();
					dba.closeConnection();

					ret = true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return ret;
	}

	public boolean getEnd_time(AttendanceForm aForm,LoginForm lForm){
		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			Calendar calendar = Calendar.getInstance();
			String month=(calendar.get(calendar.MONTH)+1)+"";
			if(month.length()!=2)
				month="0"+month;
			String cale =month+calendar.get(calendar.DATE);
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			sb.append("SELECT" + crlf);
			sb.append("  END_TIME"+crlf);
			sb.append("FROM" + crlf);
			sb.append("  ATTEND" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO =? AND"+ crlf);
			sb.append("  MMDD='"+cale+"'"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("MMDD");
			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);
			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(lForm.getEmployee_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();
				for (Map<String, String> val : rsList) {
					aForm.setEnd_time(val.get("END_TIME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public boolean setEnd_time(AttendanceForm aForm,LoginForm lForm){
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
			if(getStart_time(aForm, lForm)){
				Calendar calendar = Calendar.getInstance();
				String month=(calendar.get(calendar.MONTH)+1)+"";
				if(month.length()!=2)
					month="0"+month;
				String day=""+calendar.get(calendar.DATE);
				if(day.length()!=2)
					day="0"+day;
				String hour=""+calendar.get(calendar.HOUR_OF_DAY);
				if(hour.length()!=2)
					hour="0"+hour;
				String minutes=""+calendar.get(calendar.MINUTE);
				if(minutes.length()!=2)
					minutes="0"+minutes;
				String time=hour+minutes;
				String cale =month+day;
				sb.append("UPDATE" + crlf);
				sb.append("  ATTEND" + crlf);
				sb.append("SET" + crlf);
				sb.append("  END_TIME="+time+crlf);
				sb.append("WHERE"+ crlf);
				sb.append("  EMPLOYEE_NO=?"+crlf);
				sb.append("AND"+crlf);
				sb.append("  MMDD="+cale+crlf);
				String query = sb.toString();

				// 設定値 - 型
				List<Integer> typeList = new ArrayList<Integer>();
				typeList.add(dba.DB_STRING);

				// 設定値 - 値
				List<Object> bindList = new ArrayList<Object>();

				bindList.add(lForm.getEmployee_no());

				try {

					dba.executeQuery(query, typeList, bindList);
					dba.commit();
					dba.closeConnection();

					ret = true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return ret;
	}
	public boolean getRest_time(AttendanceForm aForm) {

		boolean ret = false;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			Calendar calendar = Calendar.getInstance();
			String month=(calendar.get(calendar.MONTH)+1)+"";
			String day=""+calendar.get(calendar.DATE);
			String cale =month+day;
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT" + crlf);
			sb.append("  REST" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  ATTEND" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  EMPLOYEE_NO = ?" + crlf);
			sb.append("AND"+crlf);
			sb.append("  MMDD="+cale+crlf);

			String query = sb.toString();
			List<String> columnList = new ArrayList<String>();
			columnList.add("REST");
			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);
			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(aForm.getEmployee_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					aForm.setRest_time(val.get("REST"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}return ret;
	}

	public boolean setRest_time(AttendanceForm aForm){
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
			if(aForm.getRest_time()!=null){
				Calendar calendar = Calendar.getInstance();
				String month=(calendar.get(calendar.MONTH)+1)+"";
				if(month.length()!=2)
					month="0"+month;
				String day=""+calendar.get(calendar.DATE);
				if(day.length()!=2)
					day="0"+day;
				String cale =month+day;
				String time=aForm.getRest_time();

				sb.append("UPDATE" + crlf);
				sb.append("  ATTEND" + crlf);
				sb.append("SET" + crlf);
				sb.append("  REST = " + "'" +time+"'" + crlf);
				sb.append("WHERE" + crlf);
				sb.append(  "EMPLOYEE_NO = ?" + crlf);
				sb.append("AND"+crlf);
				sb.append("  MMDD="+cale+crlf);

				String query = sb.toString();

				// 設定値 - 型
				List<Integer> typeList = new ArrayList<Integer>();
				typeList.add(dba.DB_STRING);

				// 設定値 - 値
				List<Object> bindList = new ArrayList<Object>();

				bindList.add(aForm.getEmployee_no());

				try {

					dba.executeQuery(query, typeList, bindList);
					dba.commit();
					dba.closeConnection();

					ret = true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	public boolean getQuestion(PasswordForm form) {

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
			sb.append("  QUESTION" + crlf);
			sb.append("  QUESTION2" + crlf);
			sb.append("  ANSWER" + crlf);
			sb.append("  ANSWER2" + crlf);
			sb.append("  MANAGER_FLAG" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  EMPLOYEE_MST E INNER JOIN PERSONAL_INFORMATION_TBL P ON E.EMPLOYEE_NO = P.EMPLOYEE_NO;" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("QUESTION");
			columnList.add("QUESTION2");
			columnList.add("ANSWER");
			columnList.add("ANSWER2");
			columnList.add("MANAGER_FLAG");

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

					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	//同一の日付が存在するかを検索
	public boolean checkday(String a){
		boolean ret=false;
		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(dba.conSts){
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			Calendar calendar = Calendar.getInstance();
			String month=(calendar.get(calendar.MONTH)+1)+"";
			if(month.length()!=2)
				month="0"+month;
			String day=""+calendar.get(calendar.DATE);
			if(day.length()!=2)
				day="0"+day;
			String cale=month+day;

			sb.append("SELECT" + crlf);
			sb.append("DAY " + crlf);
			sb.append("FROM" + crlf);
			sb.append("ROOM_ACCESS_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("DAY='" + cale + "'" + crlf);
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

	public boolean InsertEnter(EnterForm form,String a,String b) {

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



			//日付、入室時間を登録する(	"ENTRY_EMP" NUMBER(8) NOT NULL ENABLE,
			sb.append("INSERT INTO " + crlf);
			sb.append("  ROOM_ACCESS_TBL(ENTRY_EMP,DAY,ENTRY_TIME,LEAVING_TIME,CHECK_LIST,FLOOR,LEAVING_NAME,EMPLOYEE_NAME)" + crlf);
			sb.append("values" + crlf);
			sb.append("('"+form.getEmployee_no()+"'," +crlf);
			sb.append("'"+a+"',"+ crlf);
			sb.append("'"+b+"',"+ crlf);
			sb.append("0,"+ crlf);
			sb.append("0,"+ crlf);
			sb.append("'"+form.getLink()+"',"+ crlf);
			sb.append("0,"+crlf);
			sb.append("'"+form.getEmployee_name()+"')"+crlf);
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
	public boolean UpdateLeave(EnterForm form,String a,String b){
		// DB接続
		boolean ret=false;
		DbConnector dba = null;
		try {
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (dba.conSts) {
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			String floor=form.getLink();
			floor=floor.substring(0,1);


			sb.append("UPDATE" + crlf);
			sb.append("  ROOM_ACCESS_TBL" + crlf);
			sb.append("SET" + crlf);
			if(form.getButton().equals("退室"))
			{
			sb.append("  LEAVING_NAME = " + "'"+form.getLeaving_name()+"'," + crlf);
			sb.append("  LEAVING_TIME = " + "'" +a+"'," + crlf);
			sb.append("  CHECK_LIST='1'"+ crlf);
			}
			else
			{
				sb.append("  LEAVING_NAME = " + "'"+form.getEmployee_no()+"'," + crlf);
				sb.append("  LEAVING_TIME = " + "'0000'," + crlf);
				sb.append("  CHECK_LIST='0'"+ crlf);
			}
			sb.append("WHERE" + crlf);
			sb.append(  "DAY = '"+b+"'" + crlf);
			sb.append("AND"+crlf);
			sb.append(  "FLOOR ='"+floor+"'"+crlf);

			String query = sb.toString();

			try {

				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();

				ret = true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
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
		ret = true;
		return ret;
	}

	public boolean InsReservation(RoomReservationForm form) {

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
	public boolean getAccessControl(EnterForm form) {

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

			sb.append("SELECT");
			sb.append(" EMPLOYEE_NAME,"+crlf);
			sb.append(" DAY,"+crlf);
			sb.append(" ENTRY_TIME,"+crlf);
			sb.append(" LEAVING_TIME,"+crlf);
			sb.append(" LEAVING_NAME,"+crlf);
			sb.append(" CHECK_LIST"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" ROOM_ACCESS_TBL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" FLOOR= ?"+crlf);


			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("EMPLOYEE_NAME");
			columnList.add("DAY");
			columnList.add("ENTRY_TIME");
			columnList.add("LEAVING_TIME");
			columnList.add("LEAVING_NAME");
			columnList.add("CHECK_LIST");


			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getFloor());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					form.setEMPLOYEE_NAME(val.get("EMPLOYEE_NAME"));
					form.setDAY(val.get("DAY"));
					form.setENTRY_TIME(val.get("ENTRY_TIME"));
					form.setLEAVING_TIME(val.get("LEAVING_TIME"));
					form.setLEAVING_NAME(val.get("LEAVING_NAME"));
					form.setCHECK_LIST(val.get("CHECK_LIST"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getEntry_Empl(EnterForm form) {

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
			Calendar calendar = Calendar.getInstance();
			String year=""+(calendar.get(calendar.YEAR));
			String month=""+(calendar.get(calendar.MONTH)+1);
			if(month.length()==1)
				month=0+month;
			String date=""+calendar.get(calendar.DATE);
			if(date.length()==1)
				date=0+date;
			String day=month+date;

			sb.append("SELECT"+crlf);
			sb.append(" EMPLOYEE_NAME"+crlf);
			sb.append(" FROM"+crlf);
			sb.append(" ROOM_ACCESS_TBL"+crlf);
			sb.append("WHERE"+crlf);
			//sb.append(" FLOOR= ?"+crlf);
			sb.append(" DAY='"+year+day+"'"+crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("EMPLOYEE_NAME");
			//columnList.add(dba.getEMPLOYEE_NAME);

			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getFloor());
			//bindList.add(form.getEMPLOYEE_NAME);

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					form.setEmployee_name(val.get("EMPLOYEE_NAME"));
					ret = true;
				}

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
	public boolean getMMDD(RoomReservationForm form) {

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
					form.setMmdd(val.get("Mmdd"));
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
	public boolean getMonthly_report(MonthlyReportForm form) {

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


	//kinmuRecordRegisterメソッド
	//機能：勤務管理表の入力内容をDBへ登録
	//引数：KinmuRecordSendFormクラスのインスタンス(ここに入力内容が入っている)
	//戻り値：boolean型(DBへの登録が成功ならtrue、失敗ならfalseを返す)
	public boolean kinmuRecordRegister(KinmuRecordSendForm form){
		boolean ret = true;
		//まずDBに接続
		DbConnector dba = null;
		try{
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		}
		//例外発生時は以下の処理を実行
		catch(IOException e1){
			ret = false;
			e1.printStackTrace();
		}

		//DB接続が問題なければif文の中を実行
		if(dba.conSts){
			//DELETE文作成
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			//appendメソッドで文字列を連結
			sb.append("DELETE FROM KINMU_RECORD_TBL" + crlf);
			sb.append(" WHERE" + crlf);
			sb.append(" EMPLOYEE_NO = '" + form.getEmployeeNum() + "'" + crlf);
			sb.append(" AND" + crlf);
			sb.append(" KINTAI_YMD = '" + form.getKintaiYMD() + "'" + crlf );
			//連結した文字列を変数に代入
			String query = sb.toString();
			//DBに保存されているレコードをいったん削除
			try{
				//DELETE文の発行
				dba.executeQuery(query);
				//COMMIT実行
				dba.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}
			//StringBufferの中身を削除
			sb.delete(0, sb.length());


			//INSERT文作成
			//appendメソッドで文字列を連結
			sb.append("INSERT INTO KINMU_RECORD_TBL(" + crlf);
			sb.append("  EMPLOYEE_NO," + crlf);
			sb.append("  KINTAI_YMD," + crlf);
			sb.append("  HOLIDAY_DIVISION," + crlf);
			sb.append("  START_TIME," + crlf);
			sb.append("  END_TIME," + crlf);
			sb.append("  BREAK_TIMEA," + crlf);
			sb.append("  BREAK_TIMEB," + crlf);
			sb.append("  VACATION_DIVISION," + crlf);
			sb.append("  REMARK" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  '" + form.getEmployeeNum() + "'," + crlf);
			sb.append("  '" + form.getKintaiYMD() + "'," + crlf);
			sb.append("  '" + form.getHolidayDiv() + "'," + crlf);
			sb.append("  '" + form.getStartTime() + "'," + crlf);
			sb.append("  '" + form.getEndTime() + "'," + crlf);
			sb.append("  '" + form.getBreakTimeA() + "'," + crlf);
			sb.append("  '" + form.getBreakTimeB() + "'," + crlf);
			sb.append("  '" + form.getVacationDiv() + "'," + crlf);
			sb.append("  '" + form.getRemark() + "'" + crlf);
			sb.append(")" + crlf);
			//連結した文字列を変数に代入
			query = sb.toString();
			//DBへ入力内容をINSERT
			try{
				//INSERT文の発行
				dba.executeQuery(query);
				//COMMIT実行
				dba.commit();
				//DB接続を解除
				dba.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}
		}
		return ret;
	}




	//勤怠届画面の入力内容を登録する
	public boolean KintaiNotification_INSERT(KintaiNotificationForm form){
		boolean ret = true;
		//DB接続
		DbConnector dba = null;
		try{
			dba = new DbConnector(gHost,gSid,gUser,gPass);
		} catch(IOException e1){
			ret = false;
			e1.printStackTrace();
		}

		if(dba.conSts){
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("INSERT INTO KINTAI_NOTIFICATION_TBL(" + crlf);
			sb.append("EMPLOYEE_NO," + crlf);
			sb.append("SYAIN_NAME," + crlf);
			sb.append("DEPART," + crlf);
			sb.append("PETITION_YMD," + crlf);
			sb.append("ATTENDANCE_STARTDAY," + crlf);
			sb.append("ATTENDANCE_ENDDAY," + crlf);
			sb.append("ATTENDANCE_STARTTIME," + crlf);
			sb.append("ATTENDANCE_ENDTIME," + crlf);
			sb.append("NOTIFICATION_REASON," + crlf);
			sb.append("VACATION_DIVISION," + crlf);
			sb.append("TRANSFER_DAY," + crlf);
			sb.append("SP_HOLIDAY_REASON," + crlf);
			sb.append("ABSENTEEISM_REASON," + crlf);
			sb.append("REASON" + crlf);
			sb.append(")VALUES(" + crlf);
			sb.append("  '" + form.getEmployee_no() + "'," + crlf);
			sb.append("  '" + form.getSyain_name() + "'," + crlf);
			sb.append("  '" + form.getDepart() + "'," + crlf);
			sb.append("  '" + form.getPetition_ymd() + "'," + crlf);
			sb.append("  '" + form.getAttendance_startday() + "'," + crlf);
			sb.append("  '" + form.getAttendance_endday() + "'," + crlf);
			sb.append("  '" + form.getAttendance_starttime() + "'," + crlf);
			sb.append("  '" + form.getAttendance_endtime() + "'," + crlf);
			sb.append("  '" + form.getNotification_reason() + "'," + crlf);
			sb.append("  '" + form.getVacation_division() + "'," + crlf);
			sb.append("  '" + form.getTransfer_day() + "'," + crlf);
			sb.append("  '" + form.getSp_holiday_reason() + "'," + crlf);
			sb.append("  '" + form.getAbsenteeism_reason() + "'," + crlf);
			sb.append("  '" + form.getReason() + "'" + crlf);
			sb.append(")" + crlf);

			String query = sb.toString();

			try{
				dba.executeQuery(query);
				dba.commit();
				dba.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				ret = false;
			}

		}
		return ret;
	}
	public boolean getRoomstatus(RoomReservationForm form) {

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
			sb.append("  *" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  ROOM_RESERVATION" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  " + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("department");
			columnList.add("post");
			columnList.add("hobbies");
			columnList.add("specialty");
			columnList.add("introduction");
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
					form.setName(val.get("department"));
					form.setMmdd(val.get("post"));
					form.setRoom_name(val.get("hobbies"));
					form.setUse(val.get("specialty"));
					form.setRes_time(val.get("introduction"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
	public boolean getRoom_name(RoomReservationForm form) {

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
			sb.append("COUNT" + crlf);
			sb.append("  (ROOM_NAME)" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  ROOM_RESERVATION;" + crlf);

			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("ROOM_NAME");

			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(form.getEmp_no());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();


				for (Map<String, String> val : rsList) {
					form.setRoom_name(val.get("ROOM_NAME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
}

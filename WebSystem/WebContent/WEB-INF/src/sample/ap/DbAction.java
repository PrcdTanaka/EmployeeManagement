package sample.ap;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.db.DbConnector;
import sample.pr.main.LoginForm;
import sample.pr.main.MainForm;
import sample.pr.main.Open_informationForm;
import sample.pr.main.PasswordForm;
import sample.pr.main.Personal_informationForm;
import sample.pr.main.RegisterForm;
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
			sb.append(" EMPLOYEE_MST.EMPLOYEE_NO," + crlf);
			sb.append(" MANAGER_FLAG"+crlf);
			sb.append("FROM" + crlf);
			sb.append(" EMPLOYEE_MST" + crlf);
			sb.append("LEFT OUTER JOIN" + crlf);
			sb.append(" PERSONAL_INFORMATION_TBL" + crlf);
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
			sb.append("  EMERGENCY_TEL = '" + form.getEmergency_tel() + "'" + crlf);
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

	public boolean setKomaki(Open_informationForm form) {

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
	public boolean getTel_phone(Open_informationForm form) {

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
					form.setDjc(val.get("TEL_PHONE"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
}

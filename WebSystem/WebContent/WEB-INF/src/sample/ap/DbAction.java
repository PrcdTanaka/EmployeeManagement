package sample.ap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.db.DbConnector;
import sample.pr.main.LoginForm;
import sample.pr.main.MainForm;
import sample.pr.main.PasswordForm;
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
					form.setPassword(val.get("PASSWORD"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}
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
			sb.append(" EMPLOYEE_MST.EMPLOYEE_NO" + crlf);
			sb.append("FROM" + crlf);
			sb.append(" EMPLOYEE_MST" + crlf);
			sb.append("LEFT OUTER JOIN" + crlf);
			sb.append(" PERSONAL_INFORMATION_TBL" + crlf);
			sb.append("ON" + crlf);
			sb.append(" EMPLOYEE_MST.EMPLOYEE_NO=PERSONAL_INFORMATION_TBL.EMPLOYEE_NO" + crlf);
			sb.append("WHERE" + crlf);
			sb.append(  form.getRadio()+"=?"+crlf);

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
			if(form.getRadio().equals("DEPARTMENT")&&form.getText().length()==1)
				bindList.add("0"+form.getText());
			else
				bindList.add(form.getText());

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {
				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();


				for (Map<String, String> val : rsList) {
					form.setEmployee_name(val.get("NAME"));
					form.setEmployee_no(val.get("EMPLOYEE_NO"));
					form.setDepertmant(val.get("DEPERTMENT"));
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


		/***
		 * <p>
		 * 新規ユーザーを登録する。
		 * </p>
		 *
		 * @param form ユーザー登録画面アクションフォーム
		 * @return DB接続成功：true DB接続失敗：false
		 */
	}
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

			sb.append("UPDDATE" + crlf);
			sb.append("ENPLOYEE_MST" + crlf);
			sb.append("SET" + crlf);
			sb.append("password = " + form.getNewpassword() + crlf);
			sb.append("WHERE" + crlf);
			sb.append("employee_no = ?" + crlf);

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
					form.setDbpassword(val.get("SYAIN_NAME"));
					ret = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

}

package sample.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * データベースアクセス
 */
public class DbConnector {

	/** データベースコネククション */
	private Connection con = null;
	/** データベース接続状態 */
	public boolean conSts = false;

	/** STRING定義 */
	public final int DB_STRING = 1;
	/** INT定義 */
	public final int DB_INT = 2;
	/** LONG定義 */
	public final int DB_LONG = 3;

	/**
	 * データベースのホスト名。
	 * <p>
	 * 設定例１) 192.168.1.1<br>
	 * 設定例２) KENSHU-01<br>
	 * </p>
	 */
	public String gHost = "";
	/** データベースのSID。 */
	public String gSid = "";
	/** データベースのユーザー名。 */
	public String gUser = "";
	/** データベースのパスワード。 */
	public String gPass = "";

	/**
	 * データベース接続処理の初期設定を行う。
	 *
	 * @throws IOException
	 */
	public DbConnector(String pHost, String pSid, String pUser, String pPass) throws IOException {

		// パラメータをフィールドに設定
		gHost = pHost;
		gSid = pSid;
		gUser = pUser;
		gPass = pPass;

		/** DBに接続 */
		this.openConnection();

	}

	/**
	 * オブジェクトがガベージコレクタに回収される際の処理。
	 */
	@Override
	protected void finalize() {
		try {
			super.finalize();
			this.closeConnection();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * データベースとの接続を確立する。
	 *
	 * @return 実行結果
	 * @throws IOException
	 */
	public long openConnection() throws IOException {

		long ret = 0;

		if (this.con == null) {

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				this.con = DriverManager.getConnection("jdbc:oracle:thin:@" + gHost + ":1521:" + gSid,gUser,gPass);
				this.conSts = true;

			} catch (ClassNotFoundException e) {
				ret = 1;
				e.printStackTrace();
			} catch (SQLException e) {
				ret = 2;
				e.printStackTrace();
			}

		} else {
			// DBとの接続が確立済
		}
		return ret;
	}

	/**
	 * データベースとの接続を解除する。
	 *
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if (this.con != null) {
			try {
				this.con.close();
				this.conSts = false;
			} catch (SQLException e) {
				throw new SQLException("Connectionのcloseに失敗");
			}
		}
	}

	/**
	 * COMMITを行う。
	 *
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		try {
			this.con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw new SQLException("Commit失敗");
		}
	}

	/**
	 * SELECT句を発行する。
	 *
	 * @param pQuery
	 * @param pColumns
	 * @param pBindType
	 * @param pBindValue
	 * @param pRsList
	 * @return 実行結果
	 * @throws SQLException
	 */
	public long executeQuery(String pQuery, List<String> pColumns, List<Integer> pBindType, List<Object> pBindValue, List<Map<String, String>> pRsList) throws SQLException {

		long ret = 0;

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			pst = this.con.prepareStatement(pQuery);
			this.setQueryParameter(pst, pQuery, pBindType, pBindValue);
			rs = pst.executeQuery();

			while (rs.next()) {

				Map<String, String> rsMap = new HashMap<String, String>();

				for (String column : pColumns) {
					rsMap.put(column, rs.getString(column));
				}
				pRsList.add(rsMap);
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			ret = 1;
			con.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			ret = 1;
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * UPDATE句を発行する。
	 *
	 * @param pQuery
	 * @param pBindType
	 * @param pBindValue
	 * @return 実行結果
	 * @throws SQLException
	 */
	public long executeQuery(String pQuery, List<Integer> pBindType, List<Object> pBindValue) throws SQLException {

		long ret = 0;
		PreparedStatement pst = null;

		try {

			pst = this.con.prepareStatement(pQuery);
			this.setQueryParameter(pst, pQuery, pBindType, pBindValue);
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			ret = 1;
			con.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			ret = 1;
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * INSERT句を発行する。
	 *
	 * @param pQuery
	 * @return 実行結果
	 * @throws SQLException
	 */
	public long executeQuery(String pQuery) throws SQLException {

		long ret = 0;
		PreparedStatement pst = null;

		try {

			pst = this.con.prepareStatement(pQuery);
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			ret = 1;
			con.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			ret = 1;
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * バインド変数の設定を行う。
	 *
	 * @param pst
	 * @param pQuery
	 * @param pBindType
	 * @param pBindValue
	 * @return 実行結果
	 * @throws SQLException
	 */
	private long setQueryParameter(PreparedStatement pst, String pQuery, List<Integer> pBindType, List<Object> pBindValue) throws Exception {

		long ret = 0;

		if (pBindValue != null && pBindType != null) {

			if (pBindValue.size() != pBindType.size()) {
				throw new Exception("変数と型の件数が不一致");
			}

			for (int i = 0; i < pBindValue.size(); i++) {

				switch (pBindType.get(i)) {

					case DB_STRING :
						pst.setString(i+1, (String) pBindValue.get(i));
						break;

					case DB_INT :
						pst.setInt(i+1, (Integer) pBindValue.get(i));
						break;

					case DB_LONG :
						pst.setLong(i+1, (Long) pBindValue.get(i));
						break;

					default :
						throw new Exception("不正な型設定");
				}
			}
		}
		return ret;
	}

}

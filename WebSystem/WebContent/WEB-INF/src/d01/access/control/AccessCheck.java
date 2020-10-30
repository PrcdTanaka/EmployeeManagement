package d01.access.control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccessCheck {

	public String getStatus(AccessSelectForm aSForm) {

		//戻り値を格納する変数を宣言（ステータスを管理）
		String status = "0";

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//ボタン押下時の日付と時間を取得
		LocalDateTime localDateTime = LocalDateTime.now();
		//時間が0時～7時の場合日付を1日前に変更
		if (localDateTime.getHour() < 7) {
			localDateTime = localDateTime.plusDays(-1);
		}
		//日付のフォーマットを8桁に変更
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = localDateTime.format(dateFormat);

		//DB接続ができていれば以下を実行
		if (dba.conSts) {

			//ボタン押下時の日付のレコードがあるかどうか確認
			int count = 0;
			String selectCountQuery = "SELECT COUNT(ACCESS_DATE) FROM ACCESS_TBL WHERE ACCESS_DATE ="
					+ formattedDate;
			try {
				count = dba.getCount(selectCountQuery);
				dba.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//レコードがなかった場合、ボタン押下時の日付の最新レコードを取得
			if (count != 0) {
				StringBuffer sb = new StringBuffer();
				String crlf = System.getProperty("line.separator");

				sb.append("SELECT" + crlf);
				sb.append("  STATUS" + crlf);
				sb.append("FROM" + crlf);
				sb.append("  ACCESS_TBL" + crlf);
				sb.append("WHERE" + crlf);
				sb.append("  FLOOR = ?" + crlf);
				sb.append(" AND" + crlf);
				sb.append(" ACCESS_DATE=" + "'" + formattedDate + "'" + crlf);
				sb.append(" AND" + crlf);
				sb.append(" ENTRY_TIME= (SELECT MAX(ENTRY_TIME) FROM ACCESS_TBL WHERE ACCESS_DATE ="
						+ formattedDate + ")");

				String query = sb.toString();

				// 取得項目
				List<String> columnList = new ArrayList<String>();
				columnList.add("STATUS");

				// 設定値 - 型
				List<Integer> typeList = new ArrayList<Integer>();
				typeList.add(dba.DB_INT);

				// 設定値 - 値
				List<Object> bindList = new ArrayList<Object>();
				bindList.add(aSForm.getFloor());

				List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();

				try {
					dba.executeQuery(query, columnList, typeList, bindList,
							rsList);
					dba.commit();
					dba.closeConnection();

					for (Map<String, String> val : rsList) {
						aSForm.setStatus(val.get("STATUS"));
					}

					//取得したレコードのステータスを戻り値の変数に代入
					if (aSForm.getStatus() != null) {
						switch (aSForm.getStatus()) {
						case "1":
							status = "1";
							break;
						case "2":
							status = "2";
							break;
						case "3":
							status = "3";
							break;
						case "4":
							status = "4";
							break;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}

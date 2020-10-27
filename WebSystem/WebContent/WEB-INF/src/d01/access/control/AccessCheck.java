package d01.access.control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class AccessCheck {

	public int getStatus(AccessSelectForm aSForm) {

		int ret = 0;

		// DB接続
		DbConnector dba = null;
		try {
			dba = new DbConnector();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = localDate.format(dateFormat);

		if (dba.conSts) {

			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT" + crlf);
			sb.append("  STATUS" + crlf);
			sb.append("FROM" + crlf);
			sb.append("  ACCESS_TBL" + crlf);
			sb.append("WHERE" + crlf);
			sb.append("  FLOOR = ?" + crlf);
			sb.append(" AND"+crlf);
			sb.append(" ACCESS_DATE="+"'"+formattedDate+"'"+crlf);
			sb.append(" AND"+crlf);
			sb.append(" ENTRY_TIME= (SELECT MAX(ENTRY_TIME) FROM ACCESS_TBL)");

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

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					aSForm.setStatus(val.get("STATUS"));
				}

				if(aSForm != null){
					switch (aSForm.getStatus()) {
					case "0":
						ret = 0;
						break;
					case "1":
						ret = 1;
						break;
					case "2":
						ret = 2;
						break;
					case "3":
						ret = 3;
						break;
					case "4":
						ret = 4;
						break;
					}
				}


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;

	}

}

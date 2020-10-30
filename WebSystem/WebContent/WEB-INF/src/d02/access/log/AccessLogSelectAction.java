package d02.access.log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import d01.access.control.DbConnector;


public class AccessLogSelectAction extends Action{
	private static final long serialVersionUID = 1L;

	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		DbConnector dba = null;
		try {
			dba = new DbConnector();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//遷移先を格納するための変数を宣言
		String forward = "";

		//履歴閲覧のインスタンスを取得
		AccessLogSelectForm aLSForm = (AccessLogSelectForm)frm;

		//入退室管理システムのメイン画面で選択した階数、年、月を各変数に代入
		String floor = aLSForm.getFloor();
		String year = aLSForm.getYear();
		String month = aLSForm.getMonth();
//		String year = String.valueOf(yearInt);
//		String month = String.valueOf(monthInt);

		//DBに接続できている場合以下を実行
		if (dba.conSts) {

			//取得した階数、年、月でSELECT
			StringBuffer sb = new StringBuffer();
			String crlf = System.getProperty("line.separator");

			sb.append("SELECT");
			sb.append(" ACCESS_DATE,"+crlf);
			sb.append(" ENTRY_EMP_NAME,"+crlf);
			sb.append(" ENTRY_EMP_NO,"+crlf);
			sb.append(" ENTRY_TIME,"+crlf);
			sb.append(" EXIT_EMP_NAME,"+crlf);
			sb.append(" EXIT_EMP_NO,"+crlf);
			sb.append(" EXIT_TIME,"+crlf);
			sb.append(" CHECK_LIST,"+crlf);
			sb.append(" STATUS"+crlf);
			sb.append("FROM"+crlf);
			sb.append(" ACCESS_TBL"+crlf);
			sb.append("WHERE"+crlf);
			sb.append(" FLOOR= ?"+crlf);
			sb.append(" AND" + crlf);
			sb.append(" ACCESS_DATE LIKE " + "'" + year + month + "%" + "'"  + crlf);
			sb.append(" ORDER BY ACCESS_DATE, ENTRY_TIME" + crlf);


			String query = sb.toString();

			// 取得項目
			List<String> columnList = new ArrayList<String>();
			columnList.add("ACCESS_DATE");
			columnList.add("ENTRY_EMP_NAME");
			columnList.add("ENTRY_EMP_NO");
			columnList.add("ENTRY_TIME");
			columnList.add("EXIT_EMP_NAME");
			columnList.add("EXIT_EMP_NO");
			columnList.add("EXIT_TIME");
			columnList.add("CHECK_LIST");
			columnList.add("STATUS");


			// 設定値 - 型
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(dba.DB_STRING);

			// 設定値 - 値    （選択された階数）
			List<Object> bindList = new ArrayList<Object>();
			bindList.add(floor);

			List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();;

			try {

				dba.executeQuery(query, columnList, typeList, bindList, rsList);
				dba.commit();
				dba.closeConnection();

				for (Map<String, String> val : rsList) {
					aLSForm.setAccessDate(val.get("ACCESS_DATE"));
					aLSForm.setEntryEmpName(val.get("ENTRY_EMP_NAME"));
					aLSForm.setEntryEmpNo(val.get("ENTRY_EMP_NO"));
					aLSForm.setEntryTime(val.get("ENTRY_TIME"));
					aLSForm.setExitEmpName(val.get("EXIT_EMP_NAME"));
					aLSForm.setExitEmpNo(val.get("EXIT_EMP_NO"));
					aLSForm.setExitTime(val.get("EXIT_TIME"));
					aLSForm.setCheckList(val.get("CHECK_LIST"));
					aLSForm.setStatus(val.get("STATUS"));
				}

				//遷移先に履歴閲覧画面を代入
				forward = "AccessLogSelect";

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//履歴閲覧画面のjspにSELECTで取得した値を渡す
		request.setAttribute("aLSForm", aLSForm);

		return map.findForward(forward);
	}

}

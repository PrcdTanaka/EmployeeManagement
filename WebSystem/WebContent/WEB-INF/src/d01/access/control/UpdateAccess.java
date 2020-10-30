package d01.access.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UpdateAccess extends Action {
	private static final long serialVersionUID = 1L;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 遷移先を格納するための変数を宣言
		String forward = "";

		// セッション情報（入退室管理システムのインスタンス）を取得
		HttpSession session = request.getSession();
		AccessSelectForm aSForm = (AccessSelectForm) session
				.getAttribute("aSForm");

		// 取得したインスタンスから社員名、社員番号、階数、ステータスを取得
		String empName = aSForm.getEmpName();
		String empNo = aSForm.getEmpNo();
		int floor = aSForm.getFloor();
		String status = aSForm.getStatus();

		// ボタン押下時の日付と時間を取得
		LocalDateTime localDateTime = LocalDateTime.now();
		// 取得した時間が午前7時以前の場合、日付を1日前にし、取得した時間に24を足す
		int hour = localDateTime.getHour();
		DateTimeFormatter dateTimeFormat;
		if (hour < 7) {
			localDateTime = localDateTime.plusDays(-1);
			hour += 24;
			dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMdd" + hour
					+ ":mm");
		} else {
			dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMddHH:mm");
		}

		// LocalDateTimeを日付と時間に分ける
		String formattedDate = localDateTime.format(dateTimeFormat);
		String date = formattedDate.substring(0, 8);
		String time = formattedDate.substring(8, 13);

		// 退室画面で入力したチェックリストの値を配列に格納し、インスタンスにセット
		String[] checked = request.getParameterValues("checklist");
		aSForm.setChecklist(checked);
		int checkListNum;
		if (floor == 2) {
			checkListNum = 12;
		} else {
			checkListNum = 11;
		}

		//退室画面で入力したチェックリストの数がチェックボックスの数と合うかどうか確認。合う場合はUPDATEを実行
		if (aSForm.getChecklist() != checkListNum) {
			forward = "fail";
		} else {

			DbConnector dbCon = null;
			try {
				dbCon = new DbConnector();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			if (dbCon.conSts) {

				StringBuffer sb = new StringBuffer();
				String crlf = System.getProperty("line.separator");

				sb.append("UPDATE" + crlf);
				sb.append("  ACCESS_TBL" + crlf);
				sb.append("SET" + crlf);
				sb.append("  EXIT_EMP_NAME = " + "'" + empName + "'," + crlf);
				sb.append("  EXIT_EMP_NO = " + "'" + empNo + "'," + crlf);
				sb.append("  EXIT_TIME = " + "'" + time + "'," + crlf);
				sb.append("  CHECK_LIST = '1'" + "," + crlf);
				sb.append("  STATUS = " + "'" + status + "'" + crlf);
				sb.append("WHERE" + crlf);
				sb.append("ACCESS_DATE = '" + date + "'" + crlf);
				sb.append("AND" + crlf);
				sb.append("FLOOR = '" + floor + "'" + crlf);
				sb.append(" AND" + crlf);
				sb.append(" ENTRY_TIME= (SELECT MAX(ENTRY_TIME) FROM ACCESS_TBL WHERE ACCESS_DATE ="
						+ date + ")");

				String query = sb.toString();

				try {
					dbCon.executeQuery(query);
					dbCon.commit();
					dbCon.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//退室か再退室かにより、遷移先を変更
				if (status.equals("2")) {
					forward = "complete";
				} else if (status.equals("4")) {
					forward = "reComplete";
				}
			}
		}

		//入退室管理システムのインスタンスを削除
		session.removeAttribute("aSForm");

		return map.findForward(forward);
	}

}

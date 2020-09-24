package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class KintaiNotificationAction extends Action {

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KintaiNotificationAction() throws IOException {

	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// フォーム情報をキャスト
		KintaiNotificationForm KNForm = (KintaiNotificationForm) frm;

		//判定する変数定義
		boolean result = true ;

		//遷移先設定
		forward="kintaiNotification";

		//チェック要の項目を変数に格納する。
		String b=KNForm.getButton();
		if(b.equals("戻る")){
			forward ="main";
		}
		else{

			/*
			 * 取得項目
			 * [0] 社員番号
			 * [1] 氏名
			 * [2] 所属部門
			 * [3] 申請日
			 * [4] 対象日(開始)
			 * [5] 対象日(終了)
			 * [6] 対象時間(開始)
			 * [7] 対象時間(終了)
			 * [8] 届出事由
			 * [9] 休暇区分
			 * [10] 振替対象日
			 * [11] 特休理由
			 * [12] 欠勤理由
			 * [13] 事由
			 *
			 */

			String kintaiItem[] = new String[14];
			kintaiItem[0]=request.getParameter("employee_no");
			kintaiItem[1]=request.getParameter("syain_name");
			kintaiItem[2]=request.getParameter("depart");
			kintaiItem[3]=request.getParameter("petition_ymd");
			kintaiItem[4]=request.getParameter("attendance_startday");
			kintaiItem[5]=request.getParameter("attendance_endday");
			kintaiItem[6]=request.getParameter("attendance_starttime");
			kintaiItem[7]=request.getParameter("attendance_endtime");
			kintaiItem[8]=request.getParameter("notification_reason");
			kintaiItem[9]=request.getParameter("vacation_division");
			kintaiItem[10]=request.getParameter("transfer_day");
			kintaiItem[11]=request.getParameter("sp_holiday_reason");
			kintaiItem[12]=request.getParameter("absenteeism_reason");
			kintaiItem[13]=request.getParameter("reason");

			//リクエストパラメーターを取得
			//リクエストパラメータをセットする。

			KNForm.setEmployee_no(kintaiItem[0]);
			KNForm.setSyain_name(kintaiItem[1]);
			KNForm.setDepart(kintaiItem[2]);
			KNForm.setPetition_ymd(kintaiItem[3]);
			KNForm.setAttendance_startday(kintaiItem[4]);
			KNForm.setAttendance_endday(kintaiItem[5]);
			KNForm.setAttendance_starttime(kintaiItem[6]);
			KNForm.setAttendance_endtime(kintaiItem[7]);
			KNForm.setNotification_reason(kintaiItem[8]);
			KNForm.setVacation_division(kintaiItem[9]);
			KNForm.setReason(kintaiItem[13]);


			//休暇区分によって、入力不要なデータを消す。
			switch(kintaiItem[9]){
			//休暇区分が1(年次有給休暇/リフ休)の場合
			case "1":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;

				//休暇区分が3(振替休暇)の場合
			case "3":
				KNForm.setTransfer_day(kintaiItem[10]);
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;

				//休暇区分が4(特別休暇)の場合
			case "4":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason(kintaiItem[11]);
				KNForm.setAbsenteeism_reason("");
				break;

				//休暇区分が5(欠勤)の場合
			case "5":
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason(kintaiItem[12]);
				break;

				//休暇区分が入力されていない場合
			default:
				KNForm.setTransfer_day("");
				KNForm.setSp_holiday_reason("");
				KNForm.setAbsenteeism_reason("");
				break;
			}

			if (kintaiItem[0].length()<4) {
				KNForm.setMessage("社員番号が正しく入力されていません。");
			}
			else if(kintaiItem[4].length()<8){
				KNForm.setMessage("対象日(開始)が入力されていません。");

			}else if(kintaiItem[5].length()<8){
				KNForm.setMessage("対象日(終了)が入力されていません。");

			}else if(kintaiItem[8].length()<1){
				KNForm.setMessage("届出事由が入力されていません。");

			}
			else{
				/*Excel出力ボタンを押下し、空欄がない場合。*/

				/* ここからは構想上のプログラム
				 *
				 * 社員番号と対象開始日と対象終了日と届出事由をDBから取得して、画面入力値と比較し
				 * 完全一致ならUPDATE文、それ以外であればINSERT文でDBに登録する。
				 */


				//DB登録処理を実行する。
				result = saveInsert(KNForm);
				if(!result){
					KNForm.setMessage("DB処理に失敗しました。"
							+ "問い合わせについては管理者へ報告ください");
				}

				//Excelを出力する処理
				ExcelOutputActionNT excelOut = new ExcelOutputActionNT();
				try {
					result = excelOut.exceloutput(kintaiItem);
				} catch (IOException e) {
					e.printStackTrace();
				}

				//Excel出力に失敗した場合
				if(!result){
					KNForm.setMessage("エクセル出力に失敗しました。"
							+ "問い合わせについては管理者へ報告ください");
				}
			}
		}

		//エラーの場合はスキップ
		if(KNForm.getMessage() == null){
			KNForm.setMessage("出力が完了しました。");
		}

		request.setAttribute("KNForm", KNForm);

		HttpSession session = request.getSession();

		session.setAttribute("KNForm", KNForm);

		//遷移先を返却する
		return map.findForward(forward);
	}
	/*
	 *DBを登録する処理
	 *
	 */
	public boolean saveInsert(KintaiNotificationForm KNForm){
		boolean dbresult = dba.KintaiNotification_INSERT(KNForm);

		if(dbresult){
			return true;
		}else{
			return false;
		}
	}

}

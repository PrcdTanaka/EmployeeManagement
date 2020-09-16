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

public class KinmuRecordAction extends Action{


	//初期設定を行う
	//DB接続クラスのインスタンスを生成
	//遷移先を格納する変数を宣言
	//例外発生時はIOExceptionをthrowする
	public KinmuRecordAction() throws IOException {

	}

	private DbAction dba = new DbAction();   //DB接続用オブジェクト
	private String forward;  // 遷移先のパスはここに格納される

	//クリックされたボタンを判定し、遷移先情報を返す
	//①フォームから送られるURLエンコードを元に戻す
	//  (1)UnsupporrtedEncodingExeception(文字のエンコーディングがサポートされていない)が発生したらスタックとレースの出力
	String button;
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			//①フォームから送られるURLエンコードを元に戻す
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			//(1)文字のエンコーディングサポートの例外発生時はスタックとレースを出力
			e.printStackTrace();
		}

		//必要かどうか不明
//		KintaiMainForm kForm = (KintaiMainForm) frm;

		// 1.ログイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。
		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		KinmuRecordForm KRForm = (KinmuRecordForm) frm;

		//セッションインスタンスをまず取得()
		HttpSession session = request.getSession();

		//ログインユーザーの社員番号と名前をセッションスコープから取得
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		lForm.setEmployee_no(lForm.getEmployee_no());
		//ログインユーザーの所属部署をセッションスコープから取得
//		Open_informationForm oForm = (Open_informationForm) session.getAttribute("oForm");
//		oForm.setTec(oForm.getTec());



		String button=KRForm.getButton();
		try{
			if(button.equals("戻る")){
				forward="main";
			} else if(button.equals("入力内容を保存")){
				//31日分のインスタンスを保存
//				for(int i=1; i<=31; i++){
					//リクパラ用
//					String holidayDivReq = "\"" + "holidayDiv" + String.valueOf(i) + "\"";

					//リクエストパラメーターを取得
					String holidayDiv1 = request.getParameter("holidayDiv1");
					String holidayDiv2 = request.getParameter("holidayDiv2");
					String startTime1 = request.getParameter("startTime1");
					String startTime2 = request.getParameter("startTime2");
					String endTime1 = request.getParameter("endTime1");
					String endTime2 = request.getParameter("endTime2");
					String expectation1 = request.getParameter("expectation1");
					String expectation2 = request.getParameter("expectation2");
					String breakTimeA1 = request.getParameter("breakTimeA1");
					String breakTimeA2 = request.getParameter("breakTimeA2");
					String breakTimeB1 = request.getParameter("breakTimeB1");
					String breakTimeB2 = request.getParameter("breakTimeB2");
					String vacationDiv1 = request.getParameter("vacationDiv1");
					String vacationDiv2 = request.getParameter("vacationDiv2");
					String remark1 = request.getParameter("remark1");
					String remark2 = request.getParameter("remark2");
//					String startTime = request.getParameter("startTime" + String.valueOf(i));
//					String endTime = request.getParameter("endTime" + String.valueOf(i));
//					String expectation = request.getParameter("expectation" + String.valueOf(i));
//					String breakTimeA = request.getParameter("breakTimeA" + String.valueOf(i));
//					String breakTimeB = request.getParameter("breakTimeB" + String.valueOf(i));
//					String vacationDiv = request.getParameter("vacationDiv" + String.valueOf(i));
//					String remark = request.getParameter("remark" + String.valueOf(i));

					StringBuffer sb = new StringBuffer();


					sb.append(holidayDiv1 + startTime1 + endTime1 + expectation1 + breakTimeA1 + breakTimeB1 + vacationDiv1 + remark1);
					String query1 = sb.toString();

					if(query1.length()!=0){
						//セッターでインスタンスのフィールド変数を更新
						KRForm.setHolidayDiv1(holidayDiv1);
						KRForm.setStartTime1(startTime1);
						KRForm.setEndTime1(endTime1);
						KRForm.setExpectation1(expectation1);
						KRForm.setBreakTimeA1(breakTimeA1);
						KRForm.setBreakTimeB1(breakTimeB1);
						KRForm.setVacationDiv1(vacationDiv1);
						KRForm.setRemark1(remark1);
						//インスタンスのフィールド変数が更新された状態で保存処理を実行
						forward = save(KRForm);
					}




					sb.append(holidayDiv2 + startTime2 + endTime2 + expectation2 + breakTimeA2 + breakTimeB2 + vacationDiv2 + remark2);
					String query2 = sb.toString();

					if(query2.length()!=0){
						//セッターでインスタンスのフィールド変数を更新
						KRForm.setHolidayDiv2(holidayDiv2);
						KRForm.setStartTime2(startTime2);
						KRForm.setEndTime2(endTime2);
						KRForm.setExpectation2(expectation2);
						KRForm.setBreakTimeA2(breakTimeA2);
						KRForm.setBreakTimeB2(breakTimeB2);
						KRForm.setVacationDiv2(vacationDiv2);
						KRForm.setRemark2(remark2);
						//インスタンスのフィールド変数が更新された状態で保存処理を実行
						forward = save(KRForm);
					}
//				}
			}
//			else if(button.equals("勤怠連絡入力")){
//				forward="kintaimail";
//				session.setAttribute("kform", kForm);
//			}
//			else if(button.equals("勤怠一覧画面へ")){
//				forward="kintailist";
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
//		session.removeAttribute("kForm");
		return map.findForward(forward);
	}


	//入力された情報を保存するsaveメソッド
	public String save(KinmuRecordForm form){
		dba.kinmuRecordRegister(form);
		return "kinmurecord";
	}

}

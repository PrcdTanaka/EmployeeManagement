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
				//リクエストパラメーターを取得
				//休暇区分
				String holidayDiv1 = request.getParameter("holidayDiv1");
				String holidayDiv2 = request.getParameter("holidayDiv2");
				String holidayDiv3 = request.getParameter("holidayDiv3");
				String holidayDiv4 = request.getParameter("holidayDiv4");
				String holidayDiv5 = request.getParameter("holidayDiv5");
				String holidayDiv6 = request.getParameter("holidayDiv6");
				String holidayDiv7 = request.getParameter("holidayDiv7");
				String holidayDiv8 = request.getParameter("holidayDiv8");
				String holidayDiv9 = request.getParameter("holidayDiv9");
				String holidayDiv10 = request.getParameter("holidayDiv10");
				String holidayDiv11 = request.getParameter("holidayDiv11");
				String holidayDiv12 = request.getParameter("holidayDiv12");
				String holidayDiv13 = request.getParameter("holidayDiv13");
				String holidayDiv14 = request.getParameter("holidayDiv14");
				String holidayDiv15 = request.getParameter("holidayDiv15");
				String holidayDiv16 = request.getParameter("holidayDiv16");
				String holidayDiv17 = request.getParameter("holidayDiv17");
				String holidayDiv18 = request.getParameter("holidayDiv18");
				String holidayDiv19 = request.getParameter("holidayDiv19");
				String holidayDiv20 = request.getParameter("holidayDiv20");
				String holidayDiv21 = request.getParameter("holidayDiv21");
				String holidayDiv22 = request.getParameter("holidayDiv22");
				String holidayDiv23 = request.getParameter("holidayDiv23");
				String holidayDiv24 = request.getParameter("holidayDiv24");
				String holidayDiv25 = request.getParameter("holidayDiv25");
				String holidayDiv26 = request.getParameter("holidayDiv26");
				String holidayDiv27 = request.getParameter("holidayDiv27");
				String holidayDiv28 = request.getParameter("holidayDiv28");
				String holidayDiv29 = request.getParameter("holidayDiv29");
				String holidayDiv30 = request.getParameter("holidayDiv30");
				String holidayDiv31 = request.getParameter("holidayDiv31");
				//出社時間
				String startTime1 = request.getParameter("startTime1");
				String startTime2 = request.getParameter("startTime2");
				String startTime3 = request.getParameter("startTime3");
				String startTime4 = request.getParameter("startTime4");
				String startTime5 = request.getParameter("startTime5");
				String startTime6 = request.getParameter("startTime6");
				String startTime7 = request.getParameter("startTime7");
				String startTime8 = request.getParameter("startTime8");
				String startTime9 = request.getParameter("startTime9");
				String startTime10 = request.getParameter("startTime10");
				String startTime11 = request.getParameter("startTime11");
				String startTime12 = request.getParameter("startTime12");
				String startTime13 = request.getParameter("startTime13");
				String startTime14 = request.getParameter("startTime14");
				String startTime15 = request.getParameter("startTime15");
				String startTime16 = request.getParameter("startTime16");
				String startTime17 = request.getParameter("startTime17");
				String startTime18 = request.getParameter("startTime18");
				String startTime19 = request.getParameter("startTime19");
				String startTime20 = request.getParameter("startTime20");
				String startTime21 = request.getParameter("startTime21");
				String startTime22 = request.getParameter("startTime22");
				String startTime23 = request.getParameter("startTime23");
				String startTime24 = request.getParameter("startTime24");
				String startTime25 = request.getParameter("startTime25");
				String startTime26 = request.getParameter("startTime26");
				String startTime27 = request.getParameter("startTime27");
				String startTime28 = request.getParameter("startTime28");
				String startTime29 = request.getParameter("startTime29");
				String startTime30 = request.getParameter("startTime30");
				String startTime31 = request.getParameter("startTime31");
				//退社時間
				String endTime1 = request.getParameter("endTime1");
				String endTime2 = request.getParameter("endTime2");
				String endTime3 = request.getParameter("endTime3");
				String endTime4 = request.getParameter("endTime4");
				String endTime5 = request.getParameter("endTime5");
				String endTime6 = request.getParameter("endTime6");
				String endTime7 = request.getParameter("endTime7");
				String endTime8 = request.getParameter("endTime8");
				String endTime9 = request.getParameter("endTime9");
				String endTime10 = request.getParameter("endTime10");
				String endTime11 = request.getParameter("endTime11");
				String endTime12 = request.getParameter("endTime12");
				String endTime13 = request.getParameter("endTime13");
				String endTime14 = request.getParameter("endTime14");
				String endTime15 = request.getParameter("endTime15");
				String endTime16 = request.getParameter("endTime16");
				String endTime17 = request.getParameter("endTime17");
				String endTime18 = request.getParameter("endTime18");
				String endTime19 = request.getParameter("endTime19");
				String endTime20 = request.getParameter("endTime20");
				String endTime21 = request.getParameter("endTime21");
				String endTime22 = request.getParameter("endTime22");
				String endTime23 = request.getParameter("endTime23");
				String endTime24 = request.getParameter("endTime24");
				String endTime25 = request.getParameter("endTime25");
				String endTime26 = request.getParameter("endTime26");
				String endTime27 = request.getParameter("endTime27");
				String endTime28 = request.getParameter("endTime28");
				String endTime29 = request.getParameter("endTime29");
				String endTime30 = request.getParameter("endTime30");
				String endTime31 = request.getParameter("endTime31");
				//休憩A
				String breakTimeA1 = request.getParameter("breakTimeA1");
				String breakTimeA2 = request.getParameter("breakTimeA2");
				String breakTimeA3 = request.getParameter("breakTimeA3");
				String breakTimeA4 = request.getParameter("breakTimeA4");
				String breakTimeA5 = request.getParameter("breakTimeA5");
				String breakTimeA6 = request.getParameter("breakTimeA6");
				String breakTimeA7 = request.getParameter("breakTimeA7");
				String breakTimeA8 = request.getParameter("breakTimeA8");
				String breakTimeA9 = request.getParameter("breakTimeA9");
				String breakTimeA10 = request.getParameter("breakTimeA10");
				String breakTimeA11 = request.getParameter("breakTimeA11");
				String breakTimeA12 = request.getParameter("breakTimeA12");
				String breakTimeA13 = request.getParameter("breakTimeA13");
				String breakTimeA14 = request.getParameter("breakTimeA14");
				String breakTimeA15 = request.getParameter("breakTimeA15");
				String breakTimeA16 = request.getParameter("breakTimeA16");
				String breakTimeA17 = request.getParameter("breakTimeA17");
				String breakTimeA18 = request.getParameter("breakTimeA18");
				String breakTimeA19 = request.getParameter("breakTimeA19");
				String breakTimeA20 = request.getParameter("breakTimeA20");
				String breakTimeA21 = request.getParameter("breakTimeA21");
				String breakTimeA22 = request.getParameter("breakTimeA22");
				String breakTimeA23 = request.getParameter("breakTimeA23");
				String breakTimeA24 = request.getParameter("breakTimeA24");
				String breakTimeA25 = request.getParameter("breakTimeA25");
				String breakTimeA26 = request.getParameter("breakTimeA26");
				String breakTimeA27 = request.getParameter("breakTimeA27");
				String breakTimeA28 = request.getParameter("breakTimeA28");
				String breakTimeA29 = request.getParameter("breakTimeA29");
				String breakTimeA30 = request.getParameter("breakTimeA30");
				String breakTimeA31 = request.getParameter("breakTimeA31");
				//休憩B
				String breakTimeB1 = request.getParameter("breakTimeB1");
				String breakTimeB2 = request.getParameter("breakTimeB2");
				String breakTimeB3 = request.getParameter("breakTimeB3");
				String breakTimeB4 = request.getParameter("breakTimeB4");
				String breakTimeB5 = request.getParameter("breakTimeB5");
				String breakTimeB6 = request.getParameter("breakTimeB6");
				String breakTimeB7 = request.getParameter("breakTimeB7");
				String breakTimeB8 = request.getParameter("breakTimeB8");
				String breakTimeB9 = request.getParameter("breakTimeB9");
				String breakTimeB10 = request.getParameter("breakTimeB10");
				String breakTimeB11 = request.getParameter("breakTimeB11");
				String breakTimeB12 = request.getParameter("breakTimeB12");
				String breakTimeB13 = request.getParameter("breakTimeB13");
				String breakTimeB14 = request.getParameter("breakTimeB14");
				String breakTimeB15 = request.getParameter("breakTimeB15");
				String breakTimeB16 = request.getParameter("breakTimeB16");
				String breakTimeB17 = request.getParameter("breakTimeB17");
				String breakTimeB18 = request.getParameter("breakTimeB18");
				String breakTimeB19 = request.getParameter("breakTimeB19");
				String breakTimeB20 = request.getParameter("breakTimeB20");
				String breakTimeB21 = request.getParameter("breakTimeB21");
				String breakTimeB22 = request.getParameter("breakTimeB22");
				String breakTimeB23 = request.getParameter("breakTimeB23");
				String breakTimeB24 = request.getParameter("breakTimeB24");
				String breakTimeB25 = request.getParameter("breakTimeB25");
				String breakTimeB26 = request.getParameter("breakTimeB26");
				String breakTimeB27 = request.getParameter("breakTimeB27");
				String breakTimeB28 = request.getParameter("breakTimeB28");
				String breakTimeB29 = request.getParameter("breakTimeB29");
				String breakTimeB30 = request.getParameter("breakTimeB30");
				String breakTimeB31 = request.getParameter("breakTimeB31");
				//休暇区分
				String vacationDiv1 = request.getParameter("vacationDiv1");
				String vacationDiv2 = request.getParameter("vacationDiv2");
				String vacationDiv3 = request.getParameter("vacationDiv3");
				String vacationDiv4 = request.getParameter("vacationDiv4");
				String vacationDiv5 = request.getParameter("vacationDiv5");
				String vacationDiv6 = request.getParameter("vacationDiv6");
				String vacationDiv7 = request.getParameter("vacationDiv7");
				String vacationDiv8 = request.getParameter("vacationDiv8");
				String vacationDiv9 = request.getParameter("vacationDiv9");
				String vacationDiv10 = request.getParameter("vacationDiv10");
				String vacationDiv11 = request.getParameter("vacationDiv11");
				String vacationDiv12 = request.getParameter("vacationDiv12");
				String vacationDiv13 = request.getParameter("vacationDiv13");
				String vacationDiv14 = request.getParameter("vacationDiv14");
				String vacationDiv15 = request.getParameter("vacationDiv15");
				String vacationDiv16 = request.getParameter("vacationDiv16");
				String vacationDiv17 = request.getParameter("vacationDiv17");
				String vacationDiv18 = request.getParameter("vacationDiv18");
				String vacationDiv19 = request.getParameter("vacationDiv19");
				String vacationDiv20 = request.getParameter("vacationDiv20");
				String vacationDiv21 = request.getParameter("vacationDiv21");
				String vacationDiv22 = request.getParameter("vacationDiv22");
				String vacationDiv23 = request.getParameter("vacationDiv23");
				String vacationDiv24 = request.getParameter("vacationDiv24");
				String vacationDiv25 = request.getParameter("vacationDiv25");
				String vacationDiv26 = request.getParameter("vacationDiv26");
				String vacationDiv27 = request.getParameter("vacationDiv27");
				String vacationDiv28 = request.getParameter("vacationDiv28");
				String vacationDiv29 = request.getParameter("vacationDiv29");
				String vacationDiv30 = request.getParameter("vacationDiv30");
				String vacationDiv31 = request.getParameter("vacationDiv31");
				//備考
				String remark1 = request.getParameter("ramark1");
				String remark2 = request.getParameter("ramark2");
				String remark3 = request.getParameter("ramark3");
				String remark4 = request.getParameter("ramark4");
				String remark5 = request.getParameter("ramark5");
				String remark6 = request.getParameter("ramark6");
				String remark7 = request.getParameter("ramark7");
				String remark8 = request.getParameter("ramark8");
				String remark9 = request.getParameter("ramark9");
				String remark10 = request.getParameter("ramark10");
				String remark11 = request.getParameter("ramark11");
				String remark12 = request.getParameter("ramark12");
				String remark13 = request.getParameter("ramark13");
				String remark14 = request.getParameter("ramark14");
				String remark15 = request.getParameter("ramark15");
				String remark16 = request.getParameter("ramark16");
				String remark17 = request.getParameter("ramark17");
				String remark18 = request.getParameter("ramark18");
				String remark19 = request.getParameter("ramark19");
				String remark20 = request.getParameter("ramark20");
				String remark21 = request.getParameter("ramark21");
				String remark22 = request.getParameter("ramark22");
				String remark23 = request.getParameter("ramark23");
				String remark24 = request.getParameter("ramark24");
				String remark25 = request.getParameter("ramark25");
				String remark26 = request.getParameter("ramark26");
				String remark27 = request.getParameter("ramark27");
				String remark28 = request.getParameter("ramark28");
				String remark29 = request.getParameter("ramark29");
				String remark30 = request.getParameter("ramark30");
				String remark31 = request.getParameter("ramark31");
				//バッファー
				StringBuffer sb = new StringBuffer();
				//〇月1日が入力されているかチェック
				sb.append(holidayDiv1 + startTime1 + endTime1 + breakTimeA1 + breakTimeB1 + vacationDiv1 + remark1);
				String query1 = sb.toString();
				if(query1.length()!=0){
					//セッターでインスタンスのフィールド変数を更新
					KRForm.setHolidayDiv1(holidayDiv1);
					KRForm.setStartTime1(startTime1);
					KRForm.setEndTime1(endTime1);
					KRForm.setBreakTimeA1(breakTimeA1);
					KRForm.setBreakTimeB1(breakTimeB1);
					KRForm.setVacationDiv1(vacationDiv1);
					KRForm.setRemark1(remark1);
					//インスタンスのフィールド変数が更新された状態で保存処理を実行
					forward = save(KRForm);
				}
				//〇月2日が入力されているかチェック
				sb.append(holidayDiv2 + startTime2 + endTime2 + breakTimeA2 + breakTimeB2 + vacationDiv2 + remark2);
				String query2 = sb.toString();
				if(query2.length()!=0){
					//セッターでインスタンスのフィールド変数を更新
					KRForm.setHolidayDiv2(holidayDiv2);
					KRForm.setStartTime2(startTime2);
					KRForm.setEndTime2(endTime2);
					KRForm.setBreakTimeA2(breakTimeA2);
					KRForm.setBreakTimeB2(breakTimeB2);
					KRForm.setVacationDiv2(vacationDiv2);
					KRForm.setRemark2(remark2);
					//インスタンスのフィールド変数が更新された状態で保存処理を実行
					forward = save(KRForm);
				}
				//〇月3日が入力されているかチェック
				sb.append(holidayDiv3 + startTime3 + endTime3 + breakTimeA3 + breakTimeB3 + vacationDiv3 + remark3);
				String query3 = sb.toString();
				if(query3.length()!=0){
					//セッターでインスタンスのフィールド変数を更新
//					KRForm.setHolidayDiv3(holidayDiv3);
//					KRForm.setStartTime3(startTime3);
//					KRForm.setEndTime3(endTime3);
//					KRForm.setBreakTimeA3(breakTimeA3);
//					KRForm.setBreakTimeB3(breakTimeB3);
//					KRForm.setVacationDiv3(vacationDiv3);
//					KRForm.setRemark3(remark3);
					//インスタンスのフィールド変数が更新された状態で保存処理を実行
					forward = save(KRForm);
				}
				//〇月4日が入力されているかチェック
				sb.append(holidayDiv4 + startTime4 + endTime4 + breakTimeA4 + breakTimeB4 + vacationDiv4 + remark4);
				String query4 = sb.toString();
				//〇月5日が入力されているかチェック
				sb.append(holidayDiv5 + startTime5 + endTime5 + breakTimeA5 + breakTimeB5 + vacationDiv5 + remark5);
				String query5 = sb.toString();
				//〇月6日が入力されているかチェック
				sb.append(holidayDiv6 + startTime6 + endTime6 + breakTimeA6 + breakTimeB6 + vacationDiv6 + remark6);
				String query6 = sb.toString();
				//〇月7日が入力されているかチェック
				sb.append(holidayDiv7 + startTime7 + endTime7 + breakTimeA7 + breakTimeB7 + vacationDiv7 + remark7);
				String query7 = sb.toString();
				//〇月8日が入力されているかチェック
				sb.append(holidayDiv8 + startTime8 + endTime8 + breakTimeA8 + breakTimeB8 + vacationDiv8 + remark8);
				String query8 = sb.toString();
				//〇月9日が入力されているかチェック
				sb.append(holidayDiv9 + startTime9 + endTime9 + breakTimeA9 + breakTimeB9 + vacationDiv9 + remark9);
				String query9 = sb.toString();
				//〇月10日が入力されているかチェック
				sb.append(holidayDiv10 + startTime10 + endTime10 + breakTimeA10 + breakTimeB10 + vacationDiv10 + remark10);
				String query10 = sb.toString();
				//〇月11日が入力されているかチェック
				sb.append(holidayDiv11 + startTime11 + endTime11 + breakTimeA11 + breakTimeB11 + vacationDiv11 + remark11);
				String query11 = sb.toString();
				//〇月12日が入力されているかチェック
				sb.append(holidayDiv12 + startTime12 + endTime12 + breakTimeA12 + breakTimeB12 + vacationDiv12 + remark12);
				String query12 = sb.toString();
				//〇月13日が入力されているかチェック
				sb.append(holidayDiv13 + startTime13 + endTime13 + breakTimeA13 + breakTimeB13 + vacationDiv13 + remark13);
				String query13 = sb.toString();
				//〇月14日が入力されているかチェック
				sb.append(holidayDiv14 + startTime14 + endTime14 + breakTimeA14 + breakTimeB14 + vacationDiv14 + remark14);
				String query14 = sb.toString();
				//〇月15日が入力されているかチェック
				sb.append(holidayDiv15 + startTime15 + endTime15 + breakTimeA15 + breakTimeB15 + vacationDiv15 + remark15);
				String query15 = sb.toString();
				//〇月16日が入力されているかチェック
				sb.append(holidayDiv16 + startTime16 + endTime16 + breakTimeA16 + breakTimeB16 + vacationDiv16 + remark16);
				String query16 = sb.toString();
				//〇月17日が入力されているかチェック
				sb.append(holidayDiv17 + startTime17 + endTime17 + breakTimeA17 + breakTimeB17 + vacationDiv17 + remark17);
				String query17 = sb.toString();
				//〇月18日が入力されているかチェック
				sb.append(holidayDiv18 + startTime18 + endTime18 + breakTimeA18 + breakTimeB18 + vacationDiv18 + remark18);
				String query18 = sb.toString();
				//〇月19日が入力されているかチェック
				sb.append(holidayDiv19 + startTime19 + endTime19 + breakTimeA19 + breakTimeB19 + vacationDiv19 + remark19);
				String query19 = sb.toString();
				//〇月20日が入力されているかチェック
				sb.append(holidayDiv20 + startTime20 + endTime20 + breakTimeA20 + breakTimeB20 + vacationDiv20 + remark20);
				String query20 = sb.toString();
				//〇月21日が入力されているかチェック
				sb.append(holidayDiv21 + startTime21 + endTime21 + breakTimeA21 + breakTimeB21 + vacationDiv21 + remark21);
				String query21 = sb.toString();
				//〇月22日が入力されているかチェック
				sb.append(holidayDiv22 + startTime22 + endTime22 + breakTimeA22 + breakTimeB22 + vacationDiv22 + remark22);
				String query22 = sb.toString();
				//〇月23日が入力されているかチェック
				sb.append(holidayDiv23 + startTime23 + endTime23 + breakTimeA23 + breakTimeB23 + vacationDiv23 + remark23);
				String query23 = sb.toString();
				//〇月24日が入力されているかチェック
				sb.append(holidayDiv24 + startTime24 + endTime24 + breakTimeA24 + breakTimeB24 + vacationDiv24 + remark24);
				String query24 = sb.toString();
				//〇月25日が入力されているかチェック
				sb.append(holidayDiv25 + startTime25 + endTime25 + breakTimeA25 + breakTimeB25 + vacationDiv25 + remark25);
				String query25 = sb.toString();
				//〇月26日が入力されているかチェック
				sb.append(holidayDiv26 + startTime26 + endTime26 + breakTimeA26 + breakTimeB26 + vacationDiv26 + remark26);
				String query26 = sb.toString();
				//〇月27日が入力されているかチェック
				sb.append(holidayDiv27 + startTime27 + endTime27 + breakTimeA27 + breakTimeB27 + vacationDiv27 + remark27);
				String query27 = sb.toString();
				//〇月28日が入力されているかチェック
				sb.append(holidayDiv28 + startTime28 + endTime28 + breakTimeA28 + breakTimeB28 + vacationDiv28 + remark28);
				String query28 = sb.toString();
				//〇月29日が入力されているかチェック
				sb.append(holidayDiv29 + startTime29 + endTime29 + breakTimeA29 + breakTimeB29 + vacationDiv29 + remark29);
				String query29 = sb.toString();
				//〇月30日が入力されているかチェック
				sb.append(holidayDiv30 + startTime30 + endTime30 + breakTimeA30 + breakTimeB30 + vacationDiv30 + remark30);
				String query30 = sb.toString();
				//〇月31日が入力されているかチェック
				sb.append(holidayDiv31 + startTime31 + endTime31 + breakTimeA31 + breakTimeB31 + vacationDiv31 + remark31);
				String query31 = sb.toString();

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

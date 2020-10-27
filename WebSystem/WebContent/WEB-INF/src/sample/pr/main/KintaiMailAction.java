package sample.pr.main;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public class KintaiMailAction extends Action {
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;
	// 送信日(メンバ変数)
	private String Action_MMdd = "";
	// 送信時間(メンバ変数)
	private String Action_SendTime = "";

	public KintaiMailAction() throws IOException {
	}

	String button;

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		KintaiMailForm KMform = (KintaiMailForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		KMform.setEmployee_no(lForm.getEmployee_no());
		KMform.setEmployee_name(lForm.getEmployee_name());

		//forward = "kintaimail";
		String button = KMform.getButton();
		try {
			if (button.equals("戻る")) {

				forward = "kintailist";
			}
			if(button.equals("勤怠取消し"))
			{
				int Send_Edit_val = 2;
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, KMform, Send_Edit_val);
				if(Send_Chk_Flg == false)
				{
				//	session.setAttribute("form", form);
				//	session.removeAttribute("form");
					dba.setKintaiDelete(KMform,lForm,Action_MMdd,Action_SendTime);
					forward = "kintailist";
				}
			}
			if (button.equals("編集"))
			{
				//forward = "kintaieditor";
				// Send_Edit_valを1にする。
				int Send_Edit_val = 1;
				// 対象期間/日付がDBの既存情報と被っていないか確認
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, KMform, Send_Edit_val);

				if ((((KMform.getCC().equals("") || KMform.getSpotcode().equals("")
						|| KMform.getDivision().equals("")
						|| KMform.getSpan().equals("")
						|| KMform.getRemark().equals("")
						|| KMform.getDepart().equals("")
						|| KMform.getSpan2().equals(""))))
						|| !(KMform.getSpan().equals(KMform.getSpan()))
						|| !(KMform.getSpan2().equals(KMform.getSpan2()))){
					session.setAttribute("form", KMform);
				}
				else{
					// DB上のデータと対象期間に被りが無い場合にDBの編集処理を行う
					if(Send_Chk_Flg == false)
					{
						//メール機能
						boolean mailflg = Send_Mail(KMform,lForm);
						if(mailflg==true){
							System.out.println("メールフォーム出力完了");
						}else{
							System.out.println("メールフォーム出力失敗");
						}
						dba.setKintaiEdit(KMform, lForm, Action_MMdd, Action_SendTime);
					//	response.sendRedirect("http://localhost:8080/WebSystem/jsp/KintaiList.jsp");
					//	session.removeAttribute("form");
						forward = "kintailist";
					}
				}
			}
			if (button.equals("送信")) {
				// Send_Edit_valを0にする。
				int Send_Edit_val = 0;
				// 対象期間/日付がDBの既存情報と被っていないか確認
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, KMform, Send_Edit_val);

				if ((((KMform.getCC().equals("") || KMform.getSpotcode().equals("")
						|| KMform.getDivision().equals("")
						|| KMform.getSpan().equals("")
						|| KMform.getRemark().equals("")
						|| KMform.getDepart().equals("")
						|| KMform.getSpan2().equals(""))))
						|| !(KMform.getSpan().equals(KMform.getSpan()))
						|| !(KMform.getSpan2().equals(KMform.getSpan2()))){
					session.setAttribute("form", KMform);
					forward = "kintaimail";
				//	request.setAttribute("errowMsg", "必須項目を入力してください");
				//	String errorMsg=(String)request.getAttribute("errorMsg");
				//	JOptionPane.showMessageDialog(null, errorMsg);
				}
				else{
					// DB上のデータと対象期間に被りが無い場合にDBの追加処理を行う
					if(Send_Chk_Flg == false)
					{
						//メール機能
						boolean mailflg = Send_Mail(KMform,lForm);
						if(mailflg==true){
							System.out.println("メールフォーム出力完了");
						}else{
							System.out.println("メールフォーム出力失敗");
						}
						// DBへの登録作業以外をコメント化
						//session.setAttribute("form", form);
						dba.setKintaiInfo(KMform, lForm);
						forward = "kintailist";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		session.removeAttribute("form");
		Action_MMdd = "";
		Action_SendTime = "";
		return map.findForward(forward);
	}

	//メール機能(outlookのみ対応)
	public boolean Send_Mail(KintaiMailForm form, LoginForm lForm) throws IOException, URISyntaxException {

		boolean ret=false;

		String mail = String.format("mailto:%s?subject=%s&body=%s&cc=%s&bcc=%s",
				//	実際のアドレスkintai@procd-k.co.jp
				"test@test.test",
				"勤怠連絡",
				"所属部署:"   +form.getDepart()+"%0D%0A"+
				"社員番号:"	  +lForm.getEmployee_no()+"%0D%0A"+
				"氏名:"  	  +lForm.getEmployee_name()+"%0D%0A"+
				"現場コード:" +form.getSpotcode()+"%0D%0A"+
				"届出区分:"   +form.getDivision()+"%0D%0A"+
				"対象日付/期間"+form.getSpan()+"～"+form.getSpan2()+"%0D%0A"+
				"出勤予定時間:"+form.getPtime()+"%0D%0A"+
				"備考:"        +form.getRemark()+"%0D%0A"+
				"許可:"        +form.getPerm()+"%0D%0A"+
				"【届出区分】"+"%0D%0A"+
				"1:遅刻,2:有給休暇,4:振替休暇,5:特別休暇,6:シフト勤務,7:早退,その他,8:交通遅延,9:欠勤,A:深夜作業,B:休日出勤(振)",
				form.getCC(),
				form.getBcc());
		Desktop desktop = Desktop.getDesktop();
		// メール作成ウィンドウを起動
		desktop.mail(new URI(mail));
		ret=true;
		return ret;
	}

	/*
	 * 対象期間/日付の被り確認メソッド
	 * 入力
	 * I : lForm
	 * I : form
	 * I : Send_Edit_val (0・・送信 / 1・・編集 / 2・・勤怠取り消し)
	 * 出力
	 * O : chk_bukiing_flg (true・・被りあり / false・・被りなし)
	 */
	public boolean Send_Edit_Chk(LoginForm lForm, KintaiMailForm form, int Send_Edit_val)
	{
		MonthlyReportForm MRFORM=new MonthlyReportForm();
		MRFORM.setEmployee_no(lForm.getEmployee_no());
		dba.getMonthly_report(MRFORM,"","");
		List<String> FSpan1 = MRFORM.getSpan();
		List<String> FSpan2 = MRFORM.getSpan2();

		int lSpan1 = 0;
		int lSpan2 = 0;
		String[] Kintai_lst_Span1 = new String[30];
		String[] Kintai_lst_Span2 = new String[30];
		// DBのデータを配列要素に格納(span1分)
		for(int Target_span1_day = 0; Target_span1_day < FSpan1.size(); Target_span1_day++)
		{
			Kintai_lst_Span1[lSpan1] = FSpan1.get(Target_span1_day);
			lSpan1++;
		}
		// DBのデータを配列要素に格納(span2分)
		for(int Target_span2_day = 0; Target_span2_day < FSpan2.size(); Target_span2_day++)
		{
			Kintai_lst_Span2[lSpan2] = FSpan2.get(Target_span2_day);
			lSpan2++;
		}
		boolean chk_bukking_flg = false;
		for(int spans_culm = 0; spans_culm < FSpan1.size(); spans_culm++)
		{
			// 配列の要素を、int型に変換
			int int_Span1_List = Integer.parseInt(Kintai_lst_Span1[spans_culm]);
			// 配列の要素を、int型に変換
			int int_Span2_List = Integer.parseInt(Kintai_lst_Span2[spans_culm]);
			// 選択日
			int int_date = Integer.parseInt(form.getSpan());

			// 編集ボタンが選択されたら、以下の処理をする
			if(Send_Edit_val == 1)
			{
				if(int_date == int_Span1_List && int_Span2_List == int_date)
				{
					chk_bukking_flg = false;
					List<String> MMDD = MRFORM.getMmdd();
					List<String> SENDTIME = MRFORM.getSend_Time();
					Action_MMdd = MMDD.get(spans_culm);
					Action_SendTime = SENDTIME.get(spans_culm);

				}
				else if(int_date == int_Span1_List && int_Span2_List >= int_date)
				{
					chk_bukking_flg = false;
					List<String> MMDD = MRFORM.getMmdd();
					List<String> SENDTIME = MRFORM.getSend_Time();
					Action_MMdd = MMDD.get(spans_culm);
					Action_SendTime = SENDTIME.get(spans_culm);
				}
				else if(int_date >= int_Span1_List && int_Span2_List >= int_date)
				{
					chk_bukking_flg = true;
				}
			}
			// 送信ボタンが選択されたら、以下の処理をする。
			else if(Send_Edit_val == 0)
			{
				if(int_date >= int_Span1_List && int_Span2_List >= int_date)
				{
					chk_bukking_flg = true;
				}
			}
			else if(Send_Edit_val == 2)
			{
				if(int_date == int_Span1_List && int_Span2_List == int_date)
				{
					chk_bukking_flg = false;
					List<String> MMDD = MRFORM.getMmdd();
					List<String> SENDTIME = MRFORM.getSend_Time();
					Action_MMdd = MMDD.get(spans_culm);
					Action_SendTime = SENDTIME.get(spans_culm);

				}
			}

		}
		return chk_bukking_flg;
	}
}

package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
		KintaiMailForm form = (KintaiMailForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		form.setEmployee_no(lForm.getEmployee_no());
		form.setEmployee_name(lForm.getEmployee_name());

		forward = "kintaimail";
		String button = form.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "KintaiMain";
				session.removeAttribute("form");
			}
			if(button.equals("勤怠取消し"))
			{
				int Send_Edit_val = 2;
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, form, Send_Edit_val);
				if(Send_Chk_Flg == false)
				{
				//	session.setAttribute("form", form);
				//	session.removeAttribute("form");
					dba.setKintaiDelete(form,lForm,Action_MMdd,Action_SendTime);
					forward = "main";
				}
			}
			if (button.equals("編集"))
			{
				//forward = "kintaieditor";
				// Send_Edit_valを1にする。
				int Send_Edit_val = 1;
				// 対象期間/日付がDBの既存情報と被っていないか確認
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, form, Send_Edit_val);

				if ((((form.getCC().equals("") || form.getSpotcode().equals("")
						|| form.getDivision().equals("")
						|| form.getSpan().equals("")
						|| form.getRemark().equals("")
						|| form.getDepart().equals("")
						|| form.getSpan2().equals(""))))
						|| !(form.getSpan().equals(form.getSpan()))
						|| !(form.getSpan2().equals(form.getSpan2()))){
					session.setAttribute("form", form);
				}
				else{
					// DB上のデータと対象期間に被りが無い場合にDBの編集処理を行う
					if(Send_Chk_Flg == false)
					{
					//	session.setAttribute("form", form);
						dba.setKintaiEdit(form, lForm, Action_MMdd, Action_SendTime);
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
				boolean Send_Chk_Flg = Send_Edit_Chk(lForm, form, Send_Edit_val);

				if ((((form.getCC().equals("") || form.getSpotcode().equals("")
						|| form.getDivision().equals("")
						|| form.getSpan().equals("")
						|| form.getRemark().equals("")
						|| form.getDepart().equals("")
						|| form.getSpan2().equals(""))))
						|| !(form.getSpan().equals(form.getSpan()))
						|| !(form.getSpan2().equals(form.getSpan2()))){
					session.setAttribute("form", form);
					forward = "kintaimail";
				//	request.setAttribute("errowMsg", "必須項目を入力してください");
				//	String errorMsg=(String)request.getAttribute("errorMsg");
				//	JOptionPane.showMessageDialog(null, errorMsg);
				}
				else{
					// DB上のデータと対象期間に被りが無い場合にDBの追加処理を行う
					if(Send_Chk_Flg == false)
					{
						// DBへの登録作業以外をコメント化
						//session.setAttribute("form", form);
						dba.setKintaiInfo(form, lForm);
						// DBへの登録作業以外をコメント化
						//forward = "kintailist";
						// DBへの登録作業以外をコメント化
						//response.sendRedirect("http://localhost:8080/WebSystem/jsp/login.jsp");
						// DBへの登録作業以外をコメント化
						//session.removeAttribute("form");
						// JOptionPane.showMessageDialog(null,"送信しました");
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
		MonthlyReportForm FORM=new MonthlyReportForm();
		FORM.setEmployee_no(lForm.getEmployee_no());
		dba.getMonthly_report(FORM,"","");
		List<String> FSpan1 = FORM.getSpan();
		List<String> FSpan2 = FORM.getSpan2();

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
					List<String> MMDD = FORM.getMmdd();
					List<String> SENDTIME = FORM.getSend_Time();
					Action_MMdd = MMDD.get(spans_culm);
					Action_SendTime = SENDTIME.get(spans_culm);

				}
				else if(int_date == int_Span1_List && int_Span2_List >= int_date)
				{
					chk_bukking_flg = false;
					List<String> MMDD = FORM.getMmdd();
					List<String> SENDTIME = FORM.getSend_Time();
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
					List<String> MMDD = FORM.getMmdd();
					List<String> SENDTIME = FORM.getSend_Time();
					Action_MMdd = MMDD.get(spans_culm);
					Action_SendTime = SENDTIME.get(spans_culm);

				}
			}

		}
		return chk_bukking_flg;
	}
}

package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class EnterAction extends Action {

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	/**
	 * <p>
	 * メイン画面アクションの初期設定を行う。
	 * </p>
	 *
	 * 1.初期設定を行う。<br>
	 * 　1-1.DB接続クラスのインスタンスを生成する。<br>
	 * 　1-2.遷移先<br>
	 * 　　遷移先：""<br>
	 * 2.例外発生時の処理。<br>
	 * 　2-1.IOExceptionをthrowする。<br>
	 * <br>
	 *
	 * @throws IOException
	 *             -
	 */
	public EnterAction() throws IOException {
	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// 1.入退室画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。
		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		EnterForm eForm = (EnterForm) frm;


		HttpSession session=request.getSession();
		//セッション情報からログイン情報を取得
		LoginForm lForm = (LoginForm)session.getAttribute("form");
		//ログインした人の社員番号を取得
		eForm.setEmployee_no(lForm.getEmployee_no());
		//ログインした人の社員名取得
		eForm.setEmployee_name(lForm.getEmployee_name());
		//jsp上で入力されたボタンを取得
		String b=eForm.getButton();
		String link=lForm.getLink();

		//メイン画面で押されたボタンから、階数指定
		if(link.equals("1F"))
			link="1";
		else if(link.equals("2F"))
			link="2";
		else if(link.equals("3F"))
			link="3";
		else if(link.equals("4F"))
			link="4";

		//チェックリストの判定
		String check = lForm.getLink();
		if(check!="2F")
			check="1";
		else
			check="2";

		eForm.setLink(link);
		Calendar calendar = Calendar.getInstance();
		String year=(calendar.get(calendar.YEAR))+"";
		String month=(calendar.get(calendar.MONTH)+1)+"";
		if(month.length()!=2)
			month="0"+month;
		String day=""+calendar.get(calendar.DATE);
		if(day.length()!=2)
			day="0"+day;
		String hour=""+calendar.get(calendar.HOUR_OF_DAY);
		if(hour.length()!=2)
			hour="0"+hour;
		String minutes=""+calendar.get(calendar.MINUTE);
		if(minutes.length()!=2)
			minutes="0"+minutes;
		//String time=hour+minutes;
		String cale =month+day;
		String ymd = year+cale;



		if (b.equals("退室")) {
			String[] checked = request.getParameterValues("checklist");
			eForm.setChecklist(checked);
																			//チェックリストの判定結果
			if(lForm.getEmployee_name()==null||eForm.getChecklist()!=(10+Integer.parseInt(check))) {
				forward="failure";
			}
			else {
				forward="success";
;				dba.UpdateLeave(eForm, hour,minutes, ymd);
			}

		}
		else if(b.equals("入室")){
			if(lForm.getEmployee_name()!=null) {
				forward="success";
				dba.InsertEnter(eForm, ymd, hour,minutes);
			}
			else {
				forward="failure";
			}
		}
		else if(b.equals("深夜作業"))
		{
			if(lForm.getEmployee_name()!=null){

				dba.UpdateLeave(eForm, hour,minutes, ymd);
				forward="success";
			}
			else {
				forward="failure";
			}
		}
		session.removeAttribute("eform");
		/* 9.戻り値を返却する。<br>
		 * 　9-1.遷移先情報取得処理をコール。<br>
		 * 　　クラス　：ActionMapping<br>
		 * 　　メソッド：findForward(遷移先)<br>
		 */
		return map.findForward(forward);

	}
}
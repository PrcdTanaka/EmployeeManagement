package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class KintaiNotificationAction extends Action {

	// DB接続用オブジェクト
	//private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public KintaiNotificationAction() throws IOException {

	}

	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// 1.ログイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。
		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		KintaiNotificationForm KNForm = (KintaiNotificationForm) frm;


		//チェック要の項目を変数に格納する。
		String employee_no = KNForm.getEmployee_no();
		String petition_ymd = KNForm.getPetition_ymd();
		String b=KNForm.getButton();
		if(b.equals("戻る")){
			forward ="main";
		}
		else if (employee_no.equals("")) {
			KNForm.setMessage("社員番号が空白になっています。");
			forward = "kintaiNotification";
		}
		else if(petition_ymd.equals("")){
			KNForm.setMessage("申請日が空白になっています。");
			forward = "kintaiNotification";
		}
		else{
			forward="kintaiNotification";
		}

		/*
		request.setAttribute("form", KNForm);


		HttpSession session = request.getSession();

		session.setAttribute("form", KNForm);

		 */

		/*if(forward.equals("login")){
		//	JOptionPane.showMessageDialog(null,KNForm.getMessage());
		}*/
		/* 9.戻り値を返却する。<br>
		 * 　9-1.遷移先情報取得処理をコール。<br>
		 * 　　クラス　：ActionMapping<br>
		 * 　　メソッド：findForward(遷移先)<br>
		 */


		return map.findForward(forward);
	}
}

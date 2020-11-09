package b02.attendance.inform;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.pr.main.LoginForm;
import b05.attendance.dbaction.KintaiMailDb;

public class KintaiMailAction extends Action {
	private KintaiMailDb dba = new KintaiMailDb();

	// 遷移先
	private String forward;

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
		//メール機能のインスタンス生成
		SendMail SMail =new SendMail();
		KintaiMailForm KMform = (KintaiMailForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");
		KMform.setEmployee_no(lForm.getEmployee_no());
		KMform.setEmployee_name(lForm.getEmployee_name());
		String button = KMform.getButton();
		try {
			if (button.equals("戻る")) {
				forward = "kintailist";
			}
			if(button.equals("勤怠取消し"))
			{
					boolean mailflg = SMail.Delete_Mail(KMform,lForm);
					if(mailflg==true){
						System.out.println("メールフォーム出力完了");
						dba.setKintaiDelete(KMform,lForm);
						forward = "kintaimailcomp";
					}
			}
			if (button.equals("編集"))
			{

				if ((((KMform.getCC().equals("") || KMform.getSpotcode().equals("")
						|| KMform.getDivision().equals("")
						|| KMform.getSpan().equals("")
						|| KMform.getRemark().equals("")
						|| KMform.getDepart().equals("")
						|| KMform.getSpan2().equals(""))))){
					forward = "kintailist";
				}
				else{
						//メール機能
						boolean mailflg = SMail.Send_Mail(KMform,lForm);
						if(mailflg==true){
							System.out.println("メールフォーム出力完了");
						}else{
							System.out.println("メールフォーム出力失敗");
						}
						dba.setKintaiEdit(KMform, lForm);
						forward = "kintaimailcomp";
					}
				}
			if (button.equals("送信")) {
				if ((((KMform.getCC().equals("") || KMform.getSpotcode().equals("")
						|| KMform.getDivision().equals("")
						|| KMform.getSpan().equals("")
						|| KMform.getRemark().equals("")
						|| KMform.getDepart().equals("")
						|| KMform.getSpan2().equals(""))))){
					forward = "kintailist";
				}
				else{
					// DB上のデータと対象期間に被りが無い場合にDBの追加処理を行う
						//メール機能
						boolean mailflg = SMail.Send_Mail(KMform,lForm);
						if(mailflg==true){
							System.out.println("メールフォーム出力完了");
						}else{
							System.out.println("メールフォーム出力失敗");
						}
						// DBへの登録作業以外をコメント化
						dba.setKintaiInfo(KMform, lForm);
						forward = "kintaimailcomp";
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		session.removeAttribute("form");
		return map.findForward(forward);
	}
}

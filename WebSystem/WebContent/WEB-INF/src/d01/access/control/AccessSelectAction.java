package d01.access.control;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.pr.main.LoginForm;


public class AccessSelectAction extends Action {
	private static final long serialVersionUID = 1L;

	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//自動生成されたインスタンスを入退室管理システムのインスタンスに変更
		AccessSelectForm aSForm = (AccessSelectForm)frm;
		//セッション情報（ログイン情報）を取得
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm)session.getAttribute("form");

		//セッション情報を入退室管理システムのインスタンスへセット
		String empName = lForm.getEmployee_name();
		String empNo = lForm.getEmployee_no();
		aSForm.setEmpName(empName);
		aSForm.setEmpNo(empNo);


		//遷移先を格納するための変数を宣言
		String forward = "";

		try{
			//ボタン押下時の日付のレコードがあるかどうか確認し、なかった場合は0を、あった場合はステータスの値を取得
			AccessCheck accessCheck = new AccessCheck();
			String status = accessCheck.getStatus(aSForm);

			//取得したステータスに合わせて遷移先を格納
			switch (status) {
			case "0":
				forward = "entry";
				break;
			case "1":
				forward = "exit";
				break;
			case "2":
			case "4":
				forward = "reEntry";
				break;
			case "3":
				forward = "reExit";
				break;
			}
			//次の作業（入室・退室・再入室・再退室処理）でDBに保存するためにステータスの値を変更
			int intStatus = Integer.parseInt(status);
			if(status.equals("4")){
				intStatus = 3;
			}else {
				intStatus++;
			}
			String stringStatus = String.valueOf(intStatus);

			//変更したステータスを入退室管理システムのインスタンスに格納
			aSForm.setStatus(stringStatus);
		}catch(Exception e){

		}
		//入退室管理システムのインスタンスをセッションに保持
		session.setAttribute("aSForm", aSForm);

		return map.findForward(forward);
	}




}

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

	private String forward = "";

	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//自動生成されたインスタンスを入退室管理システムのインスタンスに変更
		AccessSelectForm aSForm = (AccessSelectForm)frm;
		//セッション情報取得
		HttpSession session=request.getSession();
		LoginForm lForm = (LoginForm)session.getAttribute("form");

		//セッション情報を入退室管理システムのインスタンスへセット
		aSForm.setEmpNo(lForm.getEmployee_no());
		aSForm.setEmpName(lForm.getEmployee_name());
		//入退室管理システムのインスタンスをセッションに保持
		session.setAttribute("aSForm", aSForm);

		try{
			AccessCheck accessCheck = new AccessCheck();
			int status = accessCheck.getStatus(aSForm);

			switch (status) {
			case 0:
				forward = "entry";
				break;
			case 1:
				forward = "exit";
				break;
			case 2:
			case 4:
				forward = "reEntry";
				break;
			case 3:
				forward = "reExit";
				break;
			}
		}catch(Exception e){

		}






		return map.findForward(forward);
	}




}

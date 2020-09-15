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
	//遷移先
	//例外発生時はIOExceptionをthrowする
	public KinmuRecordAction() throws IOException {

	}
	//DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

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
				forward = save(KRForm);
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
//		dba.kinmuRecordRegister(form);

		return "kinmurecord";
	}

}

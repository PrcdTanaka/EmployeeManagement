package sample.pr.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class Open_informationAction extends Action {

	/**
	 * <p>
	 * ユーザー情報登録画面-アクションの初期設定を行う。
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
	public Open_informationAction() throws IOException {
	}

	// DB接続用オブジェクト
	private DbAction dba = new DbAction();

	// 遷移先
	private String forward;

	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Open_informationForm  oForm = (Open_informationForm) frm;
		HttpSession session = request.getSession();
		LoginForm lForm = (LoginForm) session.getAttribute("form");

		oForm.setEmployee_no(lForm.getEmployee_no());

		forward = "open";

		String button = oForm.getButton();
		if(button.equals("戻る")) {
			forward = "main";
		}if(button.equals("登録")){
			dba.setOpen(oForm);
			oForm.setMessage("編集しました");
			imgsave(oForm);
			session.setAttribute("oForm", oForm);
			forward = "open";

		}
			return map.findForward(forward);
	}

	public void  imgsave(Open_informationForm form){
		String inputname = ""+form.getPass();

		// 出力ファイル
		String outputname = "//db366ybx/Proc-Server/Pro-Top/新人研修/2020年度/03.講義/04_成果/08_Webシステム/システム製作/img/"+form.getEmployee_no()+".png";

		try {

			//入力ファイルから画像データを読み込み
			//BufferedImageオブジェクトとする
			BufferedImage bImage = ImageIO.read(new File(inputname));

			//BufferedImageオブジェクトを出力ファイルにpng形式で書き出し
			ImageIO.write(bImage, "png", new File(outputname));

		} catch (Exception e) {


			// ファイルの入出力でエラーになった場合
			e.printStackTrace();

		}
	}
}
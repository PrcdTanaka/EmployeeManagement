package sample.pr.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.ap.DbAction;

public final class SearchAction extends Action {

	// DB接続用オブジェクト
	DbAction dbaction = new DbAction();

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
	public SearchAction() throws IOException {

	}
	/**
	 * <p>
	 * クリックされたボタンを判定し、遷移先情報を返却する。
	 * </p>
	 *
	 * 1.メイン画面のアクションフォーム情報をインプットパラメータ.アクションフォームから取得する。<br>
	 * <br>
	 * 2.クリックされたボタンの名称をアクションフォームから取得する。<br>
	 * 　2-1.ボタン名称取得処理をコール。<br>
	 * 　　クラス　：MainForm<br>
	 * 　　メソッド：getButton()<br>
	 * 　2-2.社員番号を整形する。<br>
	 * 　　形式：4桁の文字列<br>
	 * 　　※桁数が4桁未満の場合は先頭から"0"埋め)<br>
	 * <br>
	 * 3.社員名を取得する。<br>
	 * 　3-1.社員名取得処理をコール。<br>
	 * 　　クラス　：DbAction<br>
	 * 　　メソッド：getSyainName()<br>
	 * 　　　引数１：メイン画面アクションフォーム<br>
	 * <br>
	 * 4.社員名が取得できた場合の処理。<br>
	 * 　4-1.押下されたボタンを判定してそれぞれの処理をコール。<br>
	 * 　　4-1-1.出社ボタン押下処理をコール。<br>
	 * 　　　クラス　：MainAction<br>
	 * 　　　メソッド：clickBtnIn()<br>
	 * 　　　　引数１：メイン画面アクションフォーム<br>
	 * 　　4-1-2.退社ボタン押下処理をコール。<br>
	 * 　　　クラス　：MainAction<br>
	 * 　　　メソッド：clickBtnOut()<br>
	 * 　　　　引数１：メイン画面アクションフォーム<br>
	 * 　　4-1-3.参照ボタン押下処理をコール。<br>
	 * 　　　クラス　：MainAction<br>
	 * 　　　メソッド：clickBtnView()<br>
	 * 　　　　引数１：メイン画面アクションフォーム<br>
	 * 　4-2.遷移先を設定する。<br>
	 * 　　遷移先：各ボタン押下処理の戻り値<br>
	 * <br>
	 * 5.社員名が取得できなかった場合の処理。<br>
	 * 　5-1.メッセージを設定する。<br>
	 * 　　メッセージ：「社員マスタに存在しない社員番号です。」<br>
	 * 　5-2.遷移先を設定する。<br>
	 * 　　遷移先："message"<br>
	 * <br>
	 * 6.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
	 * 　6-1.リクエスト情報登録処理をコール。<br>
	 * 　　クラス　：HttpServletRequest<br>
	 * 　　メソッド：setAttribute()<br>
	 * 　　　引数１："form"<br>
	 * 　　　引数２：メイン画面アクションフォーム<br>
	 * <br>
	 * 7.戻り値を返却する。<br>
	 * 　7-1.遷移先情報取得処理をコール。<br>
	 * 　　クラス　：ActionMapping<br>
	 * 　　メソッド：findForward(遷移先)<br>
	 * <br>
	 *
	 * @param map
	 *            アクションマッピング<br>
	 *            frm アクションフォーム<br>
	 *            request リクエスト情報<br>
	 *            response レスポンス情報<br>
	 * @return 遷移先情報
	 *
	 */
	public ActionForward execute (ActionMapping map,ActionForm frm,HttpServletRequest request,HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// アクションフォームBeanより入力フォームのデータを取り出す処理
		// フォーム情報をキャスト
		SearchForm sForm = (SearchForm) frm;

		// フォームへ入力された情報をとりだす。
		String text = sForm.getText();
		// クリックされたボタンの名称をアクションフォームから取得
		String radio = sForm.getRadio();
		String button=sForm.getButton();

		// 社員名の取得
		// 　　クラス　：DbAction<br>
		// 　　メソッド：getSyainName()<br>
			// 社員名を取得できた場合
	
		try {
			request.setCharacterEncoding("utf-8");
			if(button.equals("戻る")) {
				forward="back";
			}
			else {
				forward="search";
				dbaction.getSearchAns(sForm);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		/* 6.アクションフォームをインプットパラメータ.リクエスト情報に設定する。<br>
		 * 　6-1.リクエスト情報登録処理をコール。<br>
		 * 　　クラス　：HttpServletRequest<br>
		 * 　　メソッド：setAttribute()<br>
		 									* 　　　引数１："form"<br>
		 * 　　　引数２：メイン画面アクションフォーム
		 */
		request.setAttribute("sform", sForm);

		/* 7.戻り値を返却する。<br>
		 * 　7-1.遷移先情報取得処理をコール。<br>
		 * 　　クラス　：ActionMapping<br>
		 * 　　メソッド：findForward(遷移先)<br>
		 */
		return map.findForward(forward);}
	}



package sample.pr.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public final class SearchForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** ボタン名 */
	private String button;
	/** メッセージ */
	private String text;
	/** ラジオボタン */
	private String radio;

	List<String> depertlist=new ArrayList<String>();
	List<String> namelist=new ArrayList<String>();
	List<String> numberlist=new ArrayList<String>();

	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		depertlist.clear();
		namelist.clear();
		numberlist.clear();
		button     = "";
		text    = "";
		radio      = "";
	}

	/**
	 * 社員番号取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員番号を取得する。
	 * </p>
	 *
	 * @return 社員番号
	 */
	public List<String> getSyain_no() {
		return numberlist;
	}

	/**
	 * 社員番号設定処理。
	 * <p>
	 * メイン画面アクションフォームに社員番号を設定する。
	 * </p>
	 *
	 * @param syain_no 社員番号
	 */
	public void setSyain_no(String syain_no) {
		numberlist.add(syain_no);
	}

	/**
	 * 社員氏名取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員氏名を取得する。
	 * </p>
	 *
	 * @return 社員氏名
	 */
	public List<String> getSyain_name() {
		return namelist;
	}

	/**
	 * 社員氏名設定処理。
	 * <p>
	 * メイン画面アクションフォームに社員氏名を設定する。
	 * </p>
	 *
	 * @param syain_name 社員氏名
	 */
	public void setSyain_name(String syain_name) {
		namelist.add(syain_name);
	}

	/**
	 * ボタン名取得処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */
	public String getButton() {

		return button;
	}

	/**
	 * ボタン名設定処理。
	 * <p>
	 * メイン画面アクションフォームにボタン名を設定する。
	 * </p>
	 *
	 * @param button ボタン名
	 */
	public void setButton(String button) {
		this.button = button;
	}

	/**
	 * メッセージ取得処理。
	 * <p>
	 * メイン画面アクションフォームからメッセージを取得する。
	 * </p>
	 *
	 * @return メッセージ
	 */
	public String getMessage() {
		return text;
	}

	/**
	 * メッセージ設定処理。
	 * <p>
	 * メイン画面アクションフォームにメッセージを設定する。
	 * </p>
	 *
	 * @param message メッセージ
	 */
	public void setText(String text) {
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}

	public List<String> getDepertmant()
	{
		return depertlist;
	}


	public void setDepertmant(String depertmant)
	{
		depertlist.add(depertmant);
	}

}

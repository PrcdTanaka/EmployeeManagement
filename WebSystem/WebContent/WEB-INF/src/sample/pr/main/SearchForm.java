package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class SearchForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 社員番号 */
	private String syain_no;
	/** 社員氏名 */
	private String syain_name;
	/** 技術部名 */
	private String depertmant;
	/** ボタン名 */
	private String button;
	/** メッセージ */
	private String text;
	/** ラジオボタン */
	private String radio;

	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		syain_no   = "";
		syain_name = "";
		depertmant = "";
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
	public String getSyain_no() {
		return syain_no;
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
		this.syain_no = syain_no;
	}

	/**
	 * 社員氏名取得処理。
	 * <p>
	 * メイン画面アクションフォームから社員氏名を取得する。
	 * </p>
	 *
	 * @return 社員氏名
	 */
	public String getSyain_name() {
		return syain_name;
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
		this.syain_name = syain_name;
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

		if(button.equals("åºç¤¾")){
			button = "syussya";
		}

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
	public String getTessage() {
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

	public String getDepertmant()
	{
		return depertmant;
	}


	public void setDepertmant(String depertmant)
	{
		this.depertmant=depertmant;
	}

}

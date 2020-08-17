package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class Open_informationForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/**名前*/
	private String name;

	/**役職*/
	private String pos;

	/**入社年月日*/
	private String djc;

	/**技術部*/
	private String tec;

	/**趣味*/
	private String hobby;

	/**特技*/
	private String ss;

	/**紹介文*/
	private String intr;

	/**ボタン名*/
	private String button;

	/**社員番号*/
	private String employee_no;

	/**メッセージ*/
	private String message;

	/**画像**/
	private String img;


	/**
	 * 初期化処理。
	 * <p>
	 * 公開情報画面アクションフォームを初期化する。
	 * </p>
	 */

	public void initialize() {
		name ="";
		pos="";
		djc="";
		tec="";
		hobby="";
		ss="";
		intr="";
		button="";
	}
	/**
	 * 氏名取得処理。
	 * <p>
	 * メイン画面アクションフォームから氏名を取得する。
	 * </p>
	 *
	 * @return 氏名
	 */

	public void setName(String name){
		this.name = name;
	}
	/**
	 * 氏名設定処理。
	 * <p>
	 * 公開情報画面アクションフォームに氏名を設定する。
	 * </p>
	 * @param employee_no 社員番号
	 */

	public String getName(){
		return name;
	}
	/**
	 * 役職取得処理。
	 * <p>
	 * メイン画面アクションフォームから役職を取得する。
	 * </p>
	 *
	 * @return 役職
	 */

	public void setPos(String pos){
		this.pos = pos;
	}
	/**
	 * 役職設定処理。
	 * <p>
	 * 公開情報画面アクションフォームに氏名を設定する。
	 * </p>
	 * @param employee_no 社員番号
	 */

	public String getPos(){

		return pos;
	}
	/**
	 * 入社年月日取得処理。
	 * <p>
	 * メイン画面アクションフォームから入社年月日を取得する。
	 * </p>
	 *
	 * @return 役職
	 */

	public void setDjc(String djc){
		this.djc=djc;
	}
	/**
	 * 入社年月日設定処理。
	 * <p>
	 * メイン画面アクションフォームから入社年月日を設定する。
	 * </p>
	 *
	 * @return 入社年月日
	 */

	public String getDjc(){
		return djc;
	}
	/**
	 * 技術部取得処理。
	 * <p>
	 * メイン画面アクションフォームから技術部を取得する。
	 * </p>
	 *
	 * @return 技術部
	 */

	public void setTec(String tec){
		this.tec=tec;
	}
	/**
	 * 技術部設定処理。
	 * <p>
	 * メイン画面アクションフォームから技術部を設定する。
	 * </p>
	 *
	 * @return 技術部
	 */

	public String getTec(){

		return tec;
	}
	/**
	 *趣味取得処理。
	 * <p>
	 * メイン画面アクションフォームから趣味を取得する。
	 * </p>
	 *
	 * @return 趣味
	 */

	public void setHobby(String hobby){
		this.hobby=hobby;
	}
	/**
	 * 趣味設定処理。
	 * <p>
	 * メイン画面アクションフォームから趣味を設定する。
	 * </p>
	 *
	 * @return 趣味
	 */

	public String getHobby(){
		return hobby;
	}
	/**
	 * 特技取得処理。
	 * <p>
	 * メイン画面アクションフォームから特技を取得する。
	 * </p>
	 *
	 * @return 特技
	 */

	public void setSs(String ss){
		this.ss=ss;
	}
	/**
	 * 特技設定処理。
	 * <p>
	 * メイン画面アクションフォームから特技を設定する。
	 * </p>
	 *
	 * @return 特技
	 */

	public String getSs(){
		return ss;
	}
	/**
	 * 紹介文取得処理。
	 * <p>
	 * メイン画面アクションフォームから紹介文を取得する。
	 * </p>
	 *
	 * @return 紹介文
	 */

	public void setIntr(String intr){
		this.intr=intr;
	}
	/**
	 * 紹介文設定処理。
	 * <p>
	 * メイン画面アクションフォームから紹介文を設定する。
	 * </p>
	 *
	 * @return 紹介文
	 */

	public String getIntr(){
		return intr;
	}
	/**
	 * ボタン名取得処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を取得する。
	 * </p>
	 *
	 * @return ボタン名
	 */

	public void setButton(String button){
		this.button=button;
	}
	/**
	 * ボタン名設定処理。
	 * <p>
	 * メイン画面アクションフォームからボタン名を設定する。
	 * </p>
	 *
	 * @return ボタン名
	 */

	public String getButton(){
		return button;
	}
	public String getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(String employee_no){
		this.employee_no = employee_no;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img){
		this.img = img;
	}
}
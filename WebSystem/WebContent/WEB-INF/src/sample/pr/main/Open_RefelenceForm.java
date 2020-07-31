package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class Open_RefelenceForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;

	/** 名前 */
	private String name;

	/** 役職 */
	private String pos;

	/** 入社年月日 */
	private String djc;

	/** 技術部 */
	private String tec;

	/** 趣味 */
	private String hobby;

	/** 特技 */
	private String ss;

	/** 紹介文 */
	private String intr;

	/** 社員番号 */
	private String employee_no;

	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		name = "";
		pos = "";
		djc = "";
		tec = "";
		hobby = "";
		ss = "";
		intr = "";
		employee_no = "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getPos() {
		return pos;
	}

	public void setDjc(String djc) {
		this.djc = djc;
	}

	public String getDjc() {
		return djc;
	}

	public void setTec(String tec) {
		this.tec = tec;
	}

	public String getTec() {
		return tec;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getHobby() {
		return hobby;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getSs() {
		return ss;
	}

	public void setIntr(String intr) {
		this.intr = intr;
	}

	public String getIntr() {
		return intr;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public String getEmployee_No() {
		return employee_no;
	}
}

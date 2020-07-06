package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class Personal_informationForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;
	
	/** 緊急連絡先：氏名 */
	private String emergency_name1;
	private String emergency_name2;
	private String emergency_name3;
	private String emergency_name4;
	private String emergency_name5;
	
	/** 緊急連絡先：本人との関係（続柄） */
	private String relationship1;
	private String relationship2;
	private String relationship3;
	private String relationship4;
	private String relationship5;
	
	/** 緊急連絡先：電話番号 */
	private String emergency_tel1;
	private String emergency_tel2;
	private String emergency_tel3;
	private String emergency_tel4;
	private String emergency_tel5;
	
	/** 家族構成：氏名 */
	private String family_structure_name1;
	private String family_structure_name2;
	private String family_structure_name3;
	private String family_structure_name4;
	private String family_structure_name5;
	
	/** 家族構成：フリガナ */
	private String family_structure_furigana1;
	private String family_structure_furigana2;
	private String family_structure_furigana3;
	private String family_structure_furigana4;
	private String family_structure_furigana5;
	
	/** 家族構成：生年月日 */
	private String family_structure_birth1;
	private String family_structure_birth2;
	private String family_structure_birth3;
	private String family_structure_birth4;
	private String family_structure_birth5;
	
	/** 家族構成：性別 */
	private String family_structure_sex1;
	private String family_structure_sex2;
	private String family_structure_sex3;
	private String family_structure_sex4;
	private String family_structure_sex5;

	/** 家族構成：続柄 */
	private String family_structure_relationship1;
	private String family_structure_relationship2;
	private String family_structure_relationship3;
	private String family_structure_relationship4;
	private String family_structure_relationship5;
	
	/** 家族構成：扶養の有無 */
	private String family_structure_support1;	
	private String family_structure_support2;	
	private String family_structure_support3;	
	private String family_structure_support4;	
	private String family_structure_support5;

	/** 家族構成：職業 */
	private String family_structure_job1;
	private String family_structure_job2;
	private String family_structure_job3;
	private String family_structure_job4;
	private String family_structure_job5;
	
	/**
	 * 初期化処理。
	 * <p>
	 * メイン画面アクションフォームを初期化する。
	 * </p>
	 */
	public void initialize() {
		emergency_name1 = "";
		emergency_name2 = "";
		emergency_name3 = "";
		emergency_name4 = "";
		emergency_name5 = "";
		relationship1 = "";
		relationship2 = "";
		relationship3 = "";
		relationship4 = "";
		relationship5 = "";
		emergency_tel1 = "";
		emergency_tel2 = "";
		emergency_tel3 = "";
		emergency_tel4 = "";
		emergency_tel5 = "";
		family_structure_name1 = "";
		family_structure_name2 = "";
		family_structure_name3 = "";
		family_structure_name4 = "";
		family_structure_name5 = "";
		family_structure_furigana1 = "";
		family_structure_furigana2 = "";
		family_structure_furigana3 = "";
		family_structure_furigana4 = "";
		family_structure_furigana5 = "";
		family_structure_birth1 = "";
		family_structure_birth2 = "";
		family_structure_birth3 = "";
		family_structure_birth4 = "";
		family_structure_birth5 = "";
		family_structure_sex1 = "";
		family_structure_sex2 = "";
		family_structure_sex3 = "";
		family_structure_sex4 = "";
		family_structure_sex5 = "";
		family_structure_relationship1 = "";
		family_structure_relationship2 = "";
		family_structure_relationship3 = "";
		family_structure_relationship4 = "";
		family_structure_relationship5 = "";
		family_structure_support1 = "";
		family_structure_support2 = "";
		family_structure_support3 = "";
		family_structure_support4 = "";
		family_structure_support5 = "";
		family_structure_job1 = "";
		family_structure_job2 = "";
		family_structure_job3 = "";
		family_structure_job4 = "";
		family_structure_job5 = "";
	}

	/** 緊急連絡先：電話番号 */
	public void setEmergency_name1(String emergency_name1){
		this.emergency_name1 = emergency_name1;
	}
	public String getEmergency_name1(){
		return emergency_name1;
	}

	public void setEmergency_name2(String emergency_name2){
		this.emergency_name2 = emergency_name2;
	}
	public String getEmergency_name2(){
		return emergency_name2;
	}

	public void setEmergency_name3(String emergency_name3){
		this.emergency_name3 = emergency_name3;
	}
	public String getEmergency_name3(){
		return emergency_name3;
	}

	public void setEmergency_name4(String emergency_name4){
		this.emergency_name4 = emergency_name4;
	}
	public String getEmergency_name4(){
		return emergency_name4;
	}

	public void setEmergency_name5(String emergency_name5){
		this.emergency_name5 = emergency_name5;
	}
	public String getEmergency_name5(){
		return emergency_name5;
	}

	
	/** 緊急連絡先：電話番号 */
	public void setRelationship1(String relationship1){
		this.relationship1 = relationship1;
	}
	public String getRelationship1(){
		return relationship1;
	}

	public void setRelationship2(String relationship2){
		this.relationship2 = relationship2;
	}
	public String getRelationship2(){
		return relationship2;
	}

	public void setRelationship3(String relationship3){
		this.relationship3 = relationship3;
	}
	public String getRelationship3(){
		return relationship3;
	}

	public void setRelationship4(String relationship4){
		this.relationship4 = relationship4;
	}
	public String getRelationship4(){
		return relationship4;
	}

	public void setRelationship5(String relationship5){
		this.relationship5 = relationship5;
	}
	public String getRelationship5(){
		return relationship5;
	}

	/** 緊急連絡先：電話番号 */
	public void setEmergency_tel1(String emergency_tel1){
		this.emergency_tel1 = emergency_tel1;
	}
	public String getEmergency_tel1(){
		return emergency_tel1;
	}

	public void setEmergency_tel2(String emergency_tel2){
		this.emergency_tel2 = emergency_tel2;
	}
	public String getEmergency_tel2(){
		return emergency_tel2;
	}

	public void setEmergency_tel3(String emergency_tel3){
		this.emergency_tel3 = emergency_tel3;
	}
	public String getEmergency_tel3(){
		return emergency_tel3;
	}

	public void setEmergency_tel4(String emergency_tel4){
		this.emergency_tel4 = emergency_tel4;
	}
	public String getEmergency_tel4(){
		return emergency_tel4;
	}

	public void setEmergency_tel5(String emergency_tel5){
		this.emergency_tel5 = emergency_tel5;
	}
	public String getEmergency_tel5(){
		return emergency_tel5;
	}

	/** 家族構成：氏名 */
	public void setFamily_structure_name1(String family_structure_name1){
		this.family_structure_name1 = family_structure_name1;
	}
	public String getFamily_structure_name1(){
		return family_structure_name1;
	}

	public void setFamily_structure_name2(String family_structure_name2){
		this.family_structure_name2 = family_structure_name2;
	}
	public String getFamily_structure_name2(){
		return family_structure_name2;
	}

	public void setFamily_structure_name3(String family_structure_name3){
		this.family_structure_name3 = family_structure_name3;
	}
	public String getFamily_structure_name3(){
		return family_structure_name3;
	}

	public void setFamily_structure_name4(String family_structure_name4){
		this.family_structure_name4 = family_structure_name4;
	}
	public String getFamily_structure_name4(){
		return family_structure_name4;
	}

	public void setFamily_structure_name5(String family_structure_name5){
		this.family_structure_name5 = family_structure_name5;
	}
	public String getFamily_structure_name5(){
		return family_structure_name5;
	}
	
	/** 家族構成：フリガナ */
	public void setFamily_structure_furigana1(String family_structure_furigana1){
		this.family_structure_furigana1 = family_structure_furigana1;
	}
	public String getFamily_structure_furigana1(){
		return family_structure_furigana1;
	}

	public void setFamily_structure_furigana2(String family_structure_furigana2){
		this.family_structure_furigana2 = family_structure_furigana2;
	}
	public String getFamily_structure_furigana2(){
		return family_structure_furigana2;
	}

	public void setFamily_structure_furigana3(String family_structure_furigana3){
		this.family_structure_furigana3 = family_structure_furigana3;
	}
	public String getFamily_structure_furigana3(){
		return family_structure_furigana3;
	}

	public void setFamily_structure_furigana4(String family_structure_furigana4){
		this.family_structure_furigana4 = family_structure_furigana4;
	}
	public String getFamily_structure_furigana4(){
		return family_structure_furigana4;
	}

	public void setFamily_structure_furigana5(String family_structure_furigana5){
		this.family_structure_furigana5 = family_structure_furigana5;
	}
	public String getFamily_structure_furigana5(){
		return family_structure_furigana5;
	}
	
	/** 家族構成：生年月日 */
	public void setFamily_structure_birth1(String family_structure_birth1){
		this.family_structure_birth1 = family_structure_birth1;
	}
	public String getFamily_structure_birth1(){
		return family_structure_birth1;
	}

	public void setFamily_structure_birth2(String family_structure_birth2){
		this.family_structure_birth2 = family_structure_birth2;
	}
	public String getFamily_structure_birth2(){
		return family_structure_birth2;
	}

	public void setFamily_structure_birth3(String family_structure_birth3){
		this.family_structure_birth3 = family_structure_birth3;
	}
	public String getFamily_structure_birth3(){
		return family_structure_birth3;
	}

	public void setFamily_structure_birth4(String family_structure_birth4){
		this.family_structure_birth4 = family_structure_birth4;
	}
	public String getFamily_structure_birth4(){
		return family_structure_birth4;
	}

	public void setFamily_structure_birth5(String family_structure_birth5){
		this.family_structure_birth5 = family_structure_birth5;
	}
	public String getFamily_structure_birth5(){
		return family_structure_birth5;
	}
	
	/** 家族構成：性別 */
	public void setFamily_structure_sex1(String family_structure_sex1){
		this.family_structure_sex1 = family_structure_sex1;
	}
	public String getFamily_structure_sex1(){
		return family_structure_sex1;
	}

	public void setFamily_structure_sex2(String family_structure_sex2){
		this.family_structure_sex2 = family_structure_sex2;
	}
	public String getFamily_structure_sex2(){
		return family_structure_sex2;
	}

	public void setFamily_structure_sex3(String family_structure_sex3){
		this.family_structure_sex3 = family_structure_sex3;
	}
	public String getFamily_structure_sex3(){
		return family_structure_sex3;
	}

	public void setFamily_structure_sex4(String family_structure_sex4){
		this.family_structure_sex4 = family_structure_sex4;
	}
	public String getFamily_structure_sex4(){
		return family_structure_sex4;
	}

	public void setFamily_structure_sex5(String family_structure_sex5){
		this.family_structure_sex5 = family_structure_sex5;
	}
	public String getFamily_structure_sex5(){
		return family_structure_sex5;
	}

	/** 家族構成：続柄 */
	public void setFamily_structure_relationship1(String family_structure_relationship1){
		this.family_structure_relationship1 = family_structure_relationship1;
	}
	public String getFamily_structure_relationship1(){
		return family_structure_relationship1;
	}

	public void setFamily_structure_relationship2(String family_structure_relationship2){
		this.family_structure_relationship2 = family_structure_relationship2;
	}
	public String getFamily_structure_relationship2(){
		return family_structure_relationship2;
	}

	public void setFamily_structure_relationship3(String family_structure_relationship3){
		this.family_structure_relationship3 = family_structure_relationship3;
	}
	public String getFamily_structure_relationship3(){
		return family_structure_relationship3;
	}

	public void setFamily_structure_relationship4(String family_structure_relationship4){
		this.family_structure_relationship4 = family_structure_relationship4;
	}
	public String getFamily_structure_relationship4(){
		return family_structure_relationship4;
	}

	public void setFamily_structure_relationship5(String family_structure_relationship5){
		this.family_structure_relationship5 = family_structure_relationship5;
	}
	public String getFamily_structure_relationship5(){
		return family_structure_relationship5;
	}

	/** 家族構成：扶養の有無 */
	public void setFamily_structure_support1(String family_structure_support1){
		this.family_structure_support1 = family_structure_support1;
	}
	public String getFamily_structure_support1(){
		return family_structure_support1;
	}

	public void setFamily_structure_support2(String family_structure_support2){
		this.family_structure_support2 = family_structure_support2;
	}
	public String getFamily_structure_support2(){
		return family_structure_support2;
	}

	public void setFamily_structure_support3(String family_structure_support3){
		this.family_structure_support3 = family_structure_support3;
	}
	public String getFamily_structure_support3(){
		return family_structure_support3;
	}

	public void setFamily_structure_support4(String family_structure_support4){
		this.family_structure_support4 = family_structure_support4;
	}
	public String getFamily_structure_support4(){
		return family_structure_support4;
	}

	public void setFamily_structure_support5(String family_structure_support5){
		this.family_structure_support5 = family_structure_support5;
	}
	public String getFamily_structure_support5(){
		return family_structure_support5;
	}

	/** 家族構成：職業 */
	public void setFamily_structure_job1(String family_structure_job1){
		this.family_structure_job1 = family_structure_job1;
	}
	public String getFamily_structure_job1(){
		return family_structure_job1;
	}
	
	public void setFamily_structure_job2(String family_structure_job2){
		this.family_structure_job2 = family_structure_job2;
	}
	public String getFamily_structure_job2(){
		return family_structure_job2;
	}
	
	public void setFamily_structure_job3(String family_structure_job3){
		this.family_structure_job3 = family_structure_job3;
	}
	public String getFamily_structure_job3(){
		return family_structure_job3;
	}
	
	public void setFamily_structure_job4(String family_structure_job4){
		this.family_structure_job4 = family_structure_job4;
	}
	public String getFamily_structure_job4(){
		return family_structure_job4;
	}
	
	public void setFamily_structure_job5(String family_structure_job5){
		this.family_structure_job5 = family_structure_job5;
	}
	public String getFamily_structure_job5(){
		return family_structure_job5;
	}

}

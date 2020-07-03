package sample.pr.main;

import org.apache.struts.action.ActionForm;

public final class Personal_informationForm extends ActionForm {

	/** シリアルバージョンID */
	private static final long serialVersionUID = 1L;


	private String hire_date;

	private String employee_name;

	private String furigana_name;

	private String birth;

	private String sex;

	private String tel_home;

	private String tel_phone;

	private String postal_code;

	private String address;

	private String division;

	private String emergency_postal_code;

	private String emergency_address;

	
	


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
		hire_date = "";
		employee_name = "";
		furigana_name = "";
		birth = "";
		sex = "";
		tel_home = "";
		tel_phone = "";
		postal_code = "";
		address = "";
		division = "";
		emergency_postal_code = "";
		emergency_address = "";
		relationship1 = "";
		emergency_tel1 = "";
		emergency_name2 = "";
		relationship2 = "";
		emergency_tel2 = "";
		emergency_name3 = "";
		relationship3 = "";
		emergency_tel3 = "";
		emergency_name4 = "";
		relationship4 = "";
		emergency_tel4 = "";
		emergency_name5 = "";
		relationship5 = "";
		emergency_tel5 = "";
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






	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getFurigana_name() {
		return furigana_name;
	}

	public void setFurigana_name(String furigana_name) {
		this.furigana_name = furigana_name;
	}
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel_home() {
		return tel_home;
	}

	public void setTel_home(String tel_home) {
		this.tel_home = tel_home;
	}
	public String getTel_phone() {
		return tel_phone;
	}

	public void setTel_phone(String tel_phone) {
		this.tel_phone = tel_phone;
	}
	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmergency_postal_code() {
		return emergency_postal_code;
	}

	public void setEmergency_postal_code(String emergency_postal_code) {
		this.emergency_postal_code = emergency_postal_code;
	}

	public String getEmergency_address() {
		return emergency_address;
	}

	public void setEmergency_address(String emergency_address) {
		this.emergency_address = emergency_address;
	}
	public String getRelationship1() {
		return relationship1;
	}

	public void setRelationship1(String relationship1) {
		this.relationship1 = relationship1;
	}
	public String getEmergency_tel2() {
		return emergency_tel2;
	}

	public void setEmergency_tel2(String emergency_tel2) {
		this.emergency_tel2 = emergency_tel2;
	}
	public String getEmergency_name3() {
		return emergency_name3;
	}

	public void setEmergency_name3(String emergency_name3) {
		this.emergency_name3 = emergency_name3;
	}
	public String getRelationship3() {
		return relationship3;
	}

	public void setRelationship3(String relationship3) {
		this.relationship3 = relationship3;
	}
	public String getEmergency_tel3() {
		return emergency_tel3;
	}

	public void setEmergency_tel3(String emergency_tel3) {
		this.emergency_tel3 = emergency_tel3;
	}
	public String getEmergency_name4() {
		return emergency_name4;
	}

	public void setEmergency_name4(String emergency_name4) {
		this.emergency_name4 = emergency_name4;
	}
	public String getRelationship4() {
		return relationship4;
	}

	public void setRelationship4(String relationship4) {
		this.relationship4 = relationship4;
	}
	public String getEmergency_tel4() {
		return emergency_tel4;
	}

	public void setEmergency_tel4(String emergency_tel4) {
		this.emergency_tel4 = emergency_tel4;
	}
	public String getEmergency_name5() {
		return emergency_name5;
	}

	public void setEmergency_name5(String emergency_name5) {
		this.emergency_name5 = emergency_name5;
	}
	public String getRelationship5() {
		return relationship5;
	}

	public void setRelationship5(String relationship5) {
		this.relationship5 = relationship5;
	}
	public String getEmergency_tel5() {
		return emergency_tel5;
	}

	public void setEmergency_tel5(String emergency_tel5) {
		this.emergency_tel5 = emergency_tel5;
	}
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


	
	/** 緊急連絡先：電話番号 */
	
	

	public void setRelationship2(String relationship2){
		this.relationship2 = relationship2;
	}
	public String getRelationship2(){
		return relationship2;
	}

	

	/** 緊急連絡先：電話番号 */
	public void setEmergency_tel1(String emergency_tel1){
		this.emergency_tel1 = emergency_tel1;
	}
	public String getEmergency_tel1(){
		return emergency_tel1;
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

}



package sample.pr.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sample.ap.DbAction;



public class KintaiMailExcelAction {

	  //カンマ
	  private static final String COMMA = ",";
	  //改行
	  private static final String NEW_LINE= "\r\n";


  public boolean Output_Csv(LoginForm lForm,MonthlyReportForm kForm) throws IOException {



      //MonthlyReportFormクラスのインスタンスに各値を設定
	  DbAction dba = new DbAction();
	  MonthlyReportForm form=new MonthlyReportForm();
	  dba.getMonthly_report(form);

    //リスト化を行う
    ArrayList<String> MForm = new ArrayList<String>();
    List<String> spotcode=form.getSpotcode();
    List<String> division=form.getDivision();
    List<String> remark=form.getRemark();
    List<String> perm=form.getPerm();
    List<String> mmdd=form.getMmdd();
    List<String> send_time=form.getSend_Time();
    String Employee_no=form.getEmployee_no();



    MForm.addAll(spotcode);
    MForm.addAll(division);
    MForm.addAll(remark);
    MForm.addAll(perm);
    MForm.addAll(mmdd);
    MForm.addAll(send_time);
    MForm.add(Employee_no);



    FileWriter fileWriter = null;
	try {
      fileWriter  = new FileWriter("person.csv");

      //リストの内容を順に処理
      for (String p : MForm) {
        fileWriter.append(p);
        fileWriter.append(COMMA);
        fileWriter.append(NEW_LINE);
       }


      System.out.println("CSVファイル出力完了");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      try {
        fileWriter.flush();
        fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
	return true;
  }
}
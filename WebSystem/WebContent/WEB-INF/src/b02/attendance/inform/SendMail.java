package b02.attendance.inform;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import sample.pr.main.LoginForm;

public class SendMail {
	//メール機能(outlookのみ対応)
	public boolean Send_Mail(KintaiMailForm KMForm, LoginForm lForm) throws IOException, URISyntaxException {

		boolean ret=false;

		//メール本文のフォーマットを作成
		String mail = String.format("mailto:%s?subject=%s&body=%s&cc=%s&bcc=%s",
				//	実際のアドレスkintai@procd-k.co.jp
				"test@test.test",
				"勤怠連絡",
				"所属部署:"   +KMForm.getDepart()+"%0D%0A"+
				"社員番号:"	  +lForm.getEmployee_no()+"%0D%0A"+
				"氏名:"  	  +lForm.getEmployee_name()+"%0D%0A"+
				"現場コード:" +KMForm.getSpotcode()+"%0D%0A"+
				"届出区分:"   +KMForm.getDivision()+"%0D%0A"+
				"対象日付/期間"+KMForm.getSpan()+"～"+KMForm.getSpan2()+"%0D%0A"+
				"出勤予定時間:"+KMForm.getPtime()+"%0D%0A"+
				"備考:"        +KMForm.getRemark()+"%0D%0A"+
				"許可:"        +KMForm.getPerm()+"%0D%0A"+
				"【届出区分】"+"%0D%0A"+
				"1:遅刻,2:有給休暇,4:振替休暇,5:特別休暇,6:シフト勤務,7:早退,その他,8:交通遅延,9:欠勤,A:深夜作業,B:休日出勤(振)",
				KMForm.getCC(),
				KMForm.getBcc());
		Desktop desktop = Desktop.getDesktop();
		// 電子メールウィンドウを起動
		desktop.mail(new URI(mail));
		ret=true;
		return ret;
	}


	//勤怠連絡情報取消し時
	public boolean Delete_Mail(KintaiMailForm KMForm, LoginForm lForm) throws IOException, URISyntaxException {
		// TODO 自動生成されたメソッド・スタブ
		boolean ret=false;
		String mail = String.format("mailto:%s?subject=%s&body=%s&cc=%s&bcc=%s",
				//	実際のアドレスkintai@procd-k.co.jp
				"test@test.test",
				"勤怠連絡取消し",
				"所属部署:"   +KMForm.getDepart()+"%0D%0A"+
				"社員番号:"	  +lForm.getEmployee_no()+"%0D%0A"+
				"氏名:"  	  +lForm.getEmployee_name()+"%0D%0A"+
				"現場コード:" +KMForm.getSpotcode()+"%0D%0A"+
				"届出区分:"   +KMForm.getDivision()+"%0D%0A"+
				"対象日付/期間"+KMForm.getSpan()+"～"+KMForm.getSpan2()+"%0D%0A"+
				"出勤予定時間:"+KMForm.getPtime()+"%0D%0A"+
				"備考:"        +KMForm.getRemark()+"%0D%0A"+
				"許可:"        +KMForm.getPerm()+"%0D%0A"+
				"情報を取り消します"+"%0D%0A"+
				"【届出区分】"+"%0D%0A"+
				"1:遅刻,2:有給休暇,4:振替休暇,5:特別休暇,6:シフト勤務,7:早退,その他,8:交通遅延,9:欠勤,A:深夜作業,B:休日出勤(振)",
				KMForm.getCC(),
				KMForm.getBcc());
		Desktop desktop = Desktop.getDesktop();
		// 電子メールウィンドウを起動
		desktop.mail(new URI(mail));
		ret=true;
		return ret;
	}
}

package b02.attendance.inform;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import sample.pr.main.LoginForm;

public class SendMail {
	//メール機能(outlookのみ対応)
	public boolean Send_Mail(KintaiMailForm form, LoginForm lForm) throws IOException, URISyntaxException {

		boolean ret=false;

		String mail = String.format("mailto:%s?subject=%s&body=%s&cc=%s&bcc=%s",
				//	実際のアドレスkintai@procd-k.co.jp
				"test@test.test",
				"勤怠連絡",
				"所属部署:"   +form.getDepart()+"%0D%0A"+
				"社員番号:"	  +lForm.getEmployee_no()+"%0D%0A"+
				"氏名:"  	  +lForm.getEmployee_name()+"%0D%0A"+
				"現場コード:" +form.getSpotcode()+"%0D%0A"+
				"届出区分:"   +form.getDivision()+"%0D%0A"+
				"対象日付/期間"+form.getSpan()+"～"+form.getSpan2()+"%0D%0A"+
				"出勤予定時間:"+form.getPtime()+"%0D%0A"+
				"備考:"        +form.getRemark()+"%0D%0A"+
				"許可:"        +form.getPerm()+"%0D%0A"+
				"【届出区分】"+"%0D%0A"+
				"1:遅刻,2:有給休暇,4:振替休暇,5:特別休暇,6:シフト勤務,7:早退,その他,8:交通遅延,9:欠勤,A:深夜作業,B:休日出勤(振)",
				form.getCC(),
				form.getBcc());
		Desktop desktop = Desktop.getDesktop();
		// メール作成ウィンドウを起動
		desktop.mail(new URI(mail));
		ret=true;
		return ret;
	}
}

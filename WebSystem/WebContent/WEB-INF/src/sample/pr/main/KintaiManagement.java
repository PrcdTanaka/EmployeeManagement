package sample.pr.main;

import java.util.List;

// 勤怠連絡管理システムの全般で使うクラス(共通関数)
public class KintaiManagement
{
	// メンバ変数
	public static int Cale_Date_Year = 0;	// KintaiList.jspで現在表示している年を格納
	public static int Cale_Date_Month = 0;	// KintaiList.jspで現在表示している月を格納

	/*
	 *  DBのデータより、SPANの情報をString配列に格納する
	 *  [I] ListMString> Span_Data (DBのSPANとSPAN2の情報)
	 *  [O] String[] kintai_span_Lst (SPANとSPAN2を配列化したデータ)
	 */
	public static String[] KintaiSpanSelect(List<String> Span_Data)
	{
		String[] kintai_span_Lst = new String[31];

		int kintai_span = 0;
		for(int Target_day = 0; Target_day < Span_Data.size(); Target_day++)
		{
			/*
			 * DBからSPAN情報を取得する際に、表示しているカレンダーの月
			 * と同一のもの以外は、配列に入れたくないのでt判定が必要。
			 * ただし、kintaiList.jspで現在表示している月のデータをメンバ変数に
			 * 格納して、このjavaファイルでも使用する必要がある。
			 */
			// kintai_span_Lstの先頭から、DBのSPAN情報の先頭から格納
			kintai_span_Lst[kintai_span] = Span_Data.get(Target_day);
			kintai_span++;
		}
		return kintai_span_Lst;
	}
}

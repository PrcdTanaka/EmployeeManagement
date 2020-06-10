package sample.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoader extends Object{

	private Properties properties = null;
	
	/**
	 * ファイル読込みの初期処理を行う。
	 * <p>
	 * 1.ファイル読込み処理をコール。<br>
	 * 　クラス　：FileLoader<br>
	 * 　メソッド：getProperty()<br>
	 * </p>
	 *
	 * @param pFileName
	 * @throws IOException
	 */
	public FileLoader (String pFileName) throws IOException {
		// 指定ファイル読込
		this.getProperty(pFileName);
	}
	
	/**
	 * ファイルの設定値を取得する。
	 * <p>
	 * 1.ファイル情報からキー値に紐付く値を取得する。<br>
	 * 　クラス　：Properties<br>
	 * 　メソッド：getProperty()<br>
	 * 　　引数１：インプットパラメータ.キー値<br>
	 * 2.取得した値を返却する。<br>
	 * </p>
	 *
	 * @param pKey
	 * @return ファイル設定値
	 */
	public String getItem(String pKey) {
		return this.properties.getProperty(pKey);
	}
	
	/**
	 * ファイル読込みを行う。
	 * <p>
	 * 1.クラスパスを取得する。<br>
	 * 　クラス　：Object<br>
	 * 　メソッド：getClass()<br>
	 * 2.ファイル情報を取得する。<br>
	 * 　クラス　：Object<br>
	 * 　メソッド：getResourceAsStream()<br>
	 * 　　引数１：インプットパラメータ.ファイル名<br>
	 * 3.ファイル情報を詠込む。<br>
	 * 　クラス　：Properties<br>
	 * 　メソッド：load(2.で取得したファイル情報)<br>
	 * 4.ファイル情報を閉じる。<br>
	 * 　クラス　：InputStream<br>
	 * 　メソッド：close()<br>
	 * </p>
	 *
	 * @param pFileName
	 * @throws IOException
	 */
	private void getProperty(String pFileName) throws IOException {

		this.properties = new Properties();

		Class<? extends FileLoader> c = this.getClass();
		InputStream is = c.getResourceAsStream(pFileName);

		this.properties.load(is);
		is.close();
	}

}

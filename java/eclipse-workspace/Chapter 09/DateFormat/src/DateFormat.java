import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {
		// 9-3-1 日付クラスを任意の形式で文字列出力する
		Date date = new Date();
		
		// DateFormatを生成する
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
		System.out.println(format.format(date));
		
		// 9-3-2 文字列で表現された日付をDateクラスに変換する
		try {
			date = format.parse("2017年01月01日01時23分45秒");
			System.out.println(date);
		} catch(ParseException ex) {
			System.out.println("パースエラー" + ex);
		}
	}
}

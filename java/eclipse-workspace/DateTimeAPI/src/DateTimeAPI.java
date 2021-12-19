import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeAPI {

	public static void main(String[] args) {
		// 9-2-2 日付・時間・日時をそれぞれ別クラスで使う
		// 日付
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		// 時刻
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		// 日時
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		// ofメソッドを使って指定する
		System.out.println(LocalDateTime.of(2017, Month.JANUARY, 1, 1, 23, 46));
		System.out.println(LocalDateTime.of(2017, 1, 1, 1, 23, 46, 678_000_000));
		
		// 文字列を指定
		System.out.println(LocalDateTime.parse("2017-01-01T01:23:45.678"));
		
		// 9-2-4 年月日の各フィールドの値を個別に取得できる
		dateTime = LocalDateTime.of(2017, Month.JANUARY, 2, 3, 45, 6, 890_000_000);
		System.out.println("年：       " + dateTime.getYear());
		System.out.println("月(Enum)： " + dateTime.getMonth());
		System.out.println("月(数字)：  " + dateTime.getMonthValue());
		System.out.println("日     ：  " + dateTime.getDayOfMonth());
		System.out.println("時     ：  " + dateTime.getHour());
		System.out.println("分     ：  " + dateTime.getMinute());
		System.out.println("秒     ：  " + dateTime.getSecond());
		System.out.println("ナノ秒  ：  " + dateTime.getNano());
		
		// 9-2-5 年月日の計算ができる
		dateTime = LocalDateTime.of(2017, 2, 3, 21, 30, 15);
		
		// 3日後
		System.out.println("3日後   ：" + dateTime.plusDays(3));
		
		// 100日前
		System.out.println("100日前 ：" + dateTime.minusDays(100));
		
		// 30秒前
		System.out.println("30秒前  ：" + dateTime.minusSeconds(30));
		
		// 元のインスタンスの値
		System.out.println("元の値  ：" + dateTime);
	}
}

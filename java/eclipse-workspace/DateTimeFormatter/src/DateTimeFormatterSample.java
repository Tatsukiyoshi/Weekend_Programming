import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterSample {

	public static void main(String[] args) {
		// 9-4-1 日付／時間クラスを任意の形式で文字列出力する
		LocalDateTime date = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS").format(date));
		
		// 9-4-2 文字列で表現された日付を日付／時間クラスに変換する
		TemporalAccessor parsed = DateTimeFormatter
				.ofPattern("yyyy/MM/dd HH:mm:ss")
				.parse("2017/02/25 19:09:59");
		date = LocalDateTime.from(parsed);
		System.out.println(date);
		
		// 9-4-3 DateTimeFormatterクラスはスレッドセーフ
		parsed = DateTimeFormatter.ISO_LOCAL_DATE.parse("2017-02-25");
		LocalDate date2 = LocalDate.from(parsed);
		System.out.println(date2);
	}
}

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

	public static void main(String[] args) {
		// 9-1-1 Dateクラスのインスタンスを利用する
		// 現在時刻でDateクラスを生成する
		Date now = new Date();
		System.out.println(now);

		// 時刻を指定して、Dateクラスのインスタンスを生成する
		// 1970年1月1日午前0時（GMT）から5000ミリ秒経過した時刻
		Date date = new Date(5000);
		System.out.println(date);
		
		// 9-1-2 Calendarクラスを利用する
		Calendar calendar = Calendar.getInstance();
		System.out.println("■Calenderの値");
		System.out.println(calendar);
		System.out.println("■getTimeの値");
		System.out.println(calendar.getTime());
		
		calendar = Calendar.getInstance();

		// 分だけ指定する
		calendar.set(Calendar.MINUTE, 18);
		System.out.println("分の指定：" + calendar.getTime());
		
		// 全部指定する（月は０～１１で表すことに注意）
		calendar.set(2013, 9, 22, 18, 36, 42);
		System.out.println("全部指定：" + calendar.getTime());
		
		// 日を表示する
		System.out.println("日の表示：" + calendar.get(Calendar.DATE));
		
		// 秒を表示する
		System.out.println("秒の表示：" + calendar.get(Calendar.SECOND));
		
		// 年を２追加する（2年後の日時に変更する）
		calendar.add(Calendar.YEAR, 2);
		System.out.println("年の加算：" + calendar.getTime());
		
		// 月を2減らす（2カ月前の日時に変更する）
		calendar.add(Calendar.MONTH, -2);
		System.out.println("月の減算：" + calendar.getTime());
		
		// 9-1-3 DateクラスとCalendarクラスの相互変換をおこなう
		calendar = Calendar.getInstance();
		date = calendar.getTime();
		System.out.println(date);
		
		calendar = Calendar.getInstance();
		date = new Date(calendar.getTimeInMillis());
		System.out.println(date);
		
		date = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTime());
	}
}

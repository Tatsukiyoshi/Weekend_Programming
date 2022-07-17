import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.format.DateTimeFormatter;

public class JapaneseDateSample {

	public static void main(String[] args) {
		// 9-5-1 西暦を和暦に変換する
		JapaneseDate date = JapaneseDate.of(2017, 2, 4);
		System.out.println(date);
		
		// 令和も対応済み？
		date = JapaneseDate.of(2021, 12, 22);
		System.out.println(date);
		
		date = JapaneseDate.of(JapaneseEra.REIWA, 4, 1, 1);
		System.out.println(date);
		
		// 9-5-2 和暦を利用した日付の文字列表現と日付クラスとの相互変換
		date = JapaneseDate.of(2021, 12, 22);
		System.out.println(DateTimeFormatter
				.ofPattern("GGGGy年M月d日")
				.format(date));
	}
}

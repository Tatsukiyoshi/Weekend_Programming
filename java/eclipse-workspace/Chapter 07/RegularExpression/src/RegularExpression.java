import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		// 7-2-1 文字列が正規表現のパターンに適合するかをチェックする
		System.out.println("7-2-1");
		sub1();
		
		// 7-2-2 正規表現を用いて文字列を分割する
		System.out.println("7-2-2");
		sub2();
		
		// 7-2-3 正規表現を用いて文字列を置換する
		System.out.println("7-2-3");
		sub3();
		
		// 7-2-4 Stringクラスのメソッドで正規表現を使う
		System.out.println("7-2-4");
		sub4();
	}
	
	private static void sub4() {
		String sentence = "This     is a  pen.";
		
		System.out.println("(1)");
		System.out.println(sentence.matches("Th.* is a .*\\."));
		
		System.out.println("(2)");
		String[] words = sentence.split("\\s+");
		for(String word : words) {
			System.out.println(word);
		}
		
		System.out.println("(3)");
		System.out.println(sentence.replaceAll("\\s+", " "));
	}

	private static void sub3() {
		// 1文字以上の空白というパターンを生成
		Pattern pattern = Pattern.compile("\\s+");
		
		String sentence = "This     is a  pen.";
		
		Matcher matcher = pattern.matcher(sentence);
		
		System.out.println(matcher.replaceAll(" "));
	}

	private static void sub2() {
		// 1文字以上の空白というパターンを生成
		Pattern pattern = Pattern.compile("\\s+");
		
		String sentence = "This     is a  pen.";
		
		// 1文字以上の空白で分割する
		String[] words = pattern.split(sentence);
		
		// 分割結果を表示する
		for(String word : words) {
			System.out.println(word);
		}
	}

	private static void sub1() {
		// ".*"は0個以上の任意の文字列、"\\."はドットを表す。-> This is aで始まり"."で終われば、適合。
		Pattern pattern = Pattern.compile("This is a .*\\.");
		
		String sentence = "This is a pen.";
		
		Matcher matcher = pattern.matcher(sentence);
		
		if(matcher.matches()) {
			System.out.println("適合する");
		} else {
			System.out.println("適合しない");
		}
	}
}

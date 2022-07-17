import java.util.ArrayList;
import java.util.List;

public class StringOperation {

	public static void main(String[] args) {
		// 7-1-1 Stringクラスの特徴
		String originalText = "THIS IS TEST!";
		String lowerText = originalText.toLowerCase();
		
		System.out.println(originalText);
		System.out.println(lowerText);
		
		// 7-1-2 文字列を結合する3つの方法
		// StringBuilderのappendが一番早い
		String aaa = "aaa";
		String bbb = "bbb";
		
		StringBuilder builder = new StringBuilder();
		builder.append(aaa);
		builder.append(bbb);
		
		String str = builder.toString();
		System.out.println("StringBuilder: " + str);
		
		str = aaa + bbb;
		System.out.println("+ " + str);
		
		str = aaa.concat(bbb);
		System.out.println("concat: " + str);
		
		// 7-1-3 文字列を分割する
		String sentence = "This is a pen.";
		String[] words = sentence.split(" ");
		for (String word : words) {
			System.out.println(word);
		}
		
		String url = "www.acroquest.co.jp";
		// "."は正規表現では、「任意の文字」という特殊な意味を持つ
		// そのため、「.」を通常の文字として認識させるために
		// エスケープ文字と呼ばれる「\」を直前に付ける必要がある
		words = url.split("\\.");

		for (String word : words) {
			System.out.println(word);
		}
		
		// 7-1-4 複数の文字列を連結する
		// Java 7まで
		List<String> stringList = new ArrayList<>();
		stringList.add("This");
		stringList.add("is");
		stringList.add("a");
		stringList.add("pen.");
		
		StringBuilder messageBuilder = new StringBuilder();
		for(String word : stringList) {
			messageBuilder.append(word);
			messageBuilder.append(" ");
		}
		if(messageBuilder.length() > 0) {
			messageBuilder.deleteCharAt(messageBuilder.length() - 1);
		}
		System.out.println(messageBuilder.toString());
		
		// Java 8 以降
		stringList = new ArrayList<>();
		stringList.add("This");
		stringList.add("is");
		stringList.add("a");
		stringList.add("pen.");
		
		String message = String.join(" ", stringList);
		System.out.println(message);
		
		// 7-1-5 文字列を置換する
		sentence = "This is a pen.";
		String replaceSentence = sentence.replace("is", "at");
		System.out.println(replaceSentence);

		// 7-1-6 文字列を検索する
		int index = sentence.indexOf("is");
		System.out.println(index);

		index = sentence.indexOf("at");
		System.out.println(index);

		index = sentence.indexOf("is", 3);
		System.out.println(index);

		index = sentence.lastIndexOf("is");
		System.out.println("末尾から検索   :" + index);

		index = sentence.lastIndexOf("is", 4);
		System.out.println("5文字目から検索:" + index);
	}
}

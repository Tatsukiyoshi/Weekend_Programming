import java.util.stream.IntStream;

// 5-2-4 数値範囲からStreamを作成する
public class RangeStream {

	public static void main(String[] args) {
		// rangeメソッドは末尾の値を含まない
		IntStream stream = IntStream.range(1, 5);
		stream.forEach(System.out::print);
		System.out.println("");
		
		// rangeClosedメソッドは末尾の値を含む
		stream = IntStream.rangeClosed(1, 5);
		stream.forEach(System.out::print);
	}
}

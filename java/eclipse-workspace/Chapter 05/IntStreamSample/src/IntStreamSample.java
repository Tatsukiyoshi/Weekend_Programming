import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 5-5-2 ｎ回の繰り返しをするIntStream
public class IntStreamSample {

	// ?,?,?を作る
	public static void main(String[] args) {
		// StringBuilder
		int count = 5;
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			if (i != 0) {
				builder.append(", ");
			}
			builder.append("?");
		}
		System.out.println(builder.toString());
		
		// StringUtils(Apache Commons Lang)
		// https://commons.apache.org/proper/commons-lang/
		String[] array = new String[count];
		Arrays.fill(array, "?");
		String query = StringUtils.join(array, ", ");
		System.out.println(query);
		
		// IntStream
		query = IntStream.range(0, count)
			.mapToObj(i -> "?")
			.collect(Collectors.joining(", "));
		System.out.println(query);
	}
}

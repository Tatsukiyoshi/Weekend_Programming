import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author taish
 * @see "https://commons.apache.org/proper/commons-lang/"
 *
 */
public class ApacheCommonsSample {

	public static void main(String[] args) {
		String text = null;
		if(StringUtils.isEmpty(text)) {
			System.out.println("textは空");
		}
		
		/**
		 * シャローコピー
		 */
		UserInfo original = new UserInfo();
		original.setId(2);
		original.setName("山田 太郎");
		original.setAge(30);

		UserInfo copied = original;
		copied.setAge(31);
		System.out.println(original.getAge());
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}
}

import java.util.ArrayList;
import java.util.List;

public class SampleMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("string1");
		list.add("string2");
		list.add("string3");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
	}

}

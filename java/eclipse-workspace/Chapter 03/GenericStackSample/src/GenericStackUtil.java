import java.util.List;

public class GenericStackUtil {
	public static <T> GenericStack<T> as(List<T> list) {
		GenericStack<T> stack = new GenericStack<>();
		list.forEach(stack::push);
		return stack;
	}
}

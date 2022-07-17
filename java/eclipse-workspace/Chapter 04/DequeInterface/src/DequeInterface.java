import java.util.Deque;
import java.util.LinkedList;

// 4-6-2 両端キューを使う
public class DequeInterface {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();
		deque.offerFirst(1);					// 先頭に追加する：		1
		deque.offerFirst(3);					// 先頭に追加する：		3-1
		deque.offerLast(4);						// 最後に追加する：		3-1-4
		System.out.println(deque.pollFirst());	// 先頭から取得する：	(3)-1-4
		deque.offerLast(5);						// 最後に追加する:		1-4-5
		System.out.println(deque.pollLast());	// 最後から取得する：	1-4-(5)
		System.out.println(deque.pollLast());	// 最後から取得する：	1-(4)
		System.out.println(deque.pollLast());	// 最後から取得する：	(1)
	}
}

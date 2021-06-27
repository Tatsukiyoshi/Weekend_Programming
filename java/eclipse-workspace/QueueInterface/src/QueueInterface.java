import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

// 4-6-1 値を追加した順と同じ順に値を取得する
public class QueueInterface {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayBlockingQueue<>(10);
		queue.offer(1);
		queue.offer(3);
		System.out.println(queue.poll());
		queue.offer(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.offer(6);
		queue.offer(8);
		System.out.println(queue.peek());
		System.out.println(queue.peek());
	}
}

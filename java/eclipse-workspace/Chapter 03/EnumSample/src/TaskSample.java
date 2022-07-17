
public class TaskSample {
	public static void main(String...args) {
		Task task = new Task(TaskType.PRIVATE, "buy milk");
		TaskType type = task.getType();
		
		System.out.println(TaskType.PRIVATE.equals(type));
		
		switch(type) {
		case PRIVATE:
			System.out.println("Task[type = " + type + "]");
			break;
		case WORK:
			System.out.println("Task[type = " + type + "]");
			break;
		}
	}
}

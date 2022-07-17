import java.util.UUID;

public class Task {
	private String id;
	private TaskType type;
	private String body;
	
	public Task(TaskType type, String body) {
		this.id = UUID.randomUUID().toString();
		this.type = type;
		this.body = body;
	}
	
	public String getId() {
		return id;
	}
	
	public TaskType getType() {
		return type;
	}
	
	public void setType(TaskType type) {
		this.type = type;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
}

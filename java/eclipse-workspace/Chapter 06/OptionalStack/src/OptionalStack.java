import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStack<E> {
	private List<E> taskList;
	
	public OptionalStack() {
		this.taskList = new ArrayList<>();
	}
	
	public boolean push(E task) {
		return this.taskList.add(task);
	}
	
	public Optional<E> pop(){
		if(this.taskList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(this.taskList.remove(this.taskList.size() - 1));
	}
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory implements Entry {
	private String name;
	private List<Entry> list;

	public Directory(String name) {
		this.name = name;
		this.list = new ArrayList<>();
	}
	
	@Override
	public void add(Entry entry) {
		list.add(entry);
	}

	@Override
	public void remove() {
		Iterator<Entry> itr = list.iterator();
		
		while(itr.hasNext()) {
			Entry entry = itr.next();
			entry.remove();
		}
		
		System.out.println(this.name + "を削除しました。");
	}

	@Override
	public void rename(String name) {
		this.name = name;
	}
}

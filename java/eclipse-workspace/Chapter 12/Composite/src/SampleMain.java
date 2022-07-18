
public class SampleMain {

	public static void main(String[] args) {
		File file1 = new File("file1");
		File file2 = new File("file2");
		File file3 = new File("file3");
		File file4 = new File("file4");
		
		Directory dir1 = new Directory("dir1");
		dir1.add(file1);
		
		Directory dir2 = new Directory("dir2");
		dir2.add(file2);
		dir2.add(file3);
		
		dir1.add(dir2);
		
		dir1.add(file4);
		
		dir1.remove();
	}
}

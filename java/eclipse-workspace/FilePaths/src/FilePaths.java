
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePaths {

	public static void main(String[] args) {
		// 8-1-1 Fileクラスで初期化する
		File dir = new File("..");
			
		for(String file : dir.list()) {
			System.out.println(file);
		}
		
		// 8-1-2 Pathクラスで初期化する
		Path path1 = Paths.get("C:\\work\\sample1.txt");
		Path path2 = Paths.get(".\\work\\sample2.txt");
		Path path3 = Paths.get("C:", "work", "sample3.txt");
		URI uri = URI.create("file:///C:/work/sample4.txt");
		Path path4 = Paths.get(uri);
		
		System.out.println(path1.getParent());
		System.out.println(path1.resolveSibling("sample2.txt"));
		System.out.println(path1.resolveSibling("../sample3.txt").normalize());
		
	}
}

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation {

	public static void main(String[] args) {
		// 8-3-1 ファイルをコピーする
		Path fromFile = Paths.get("..\\FileIO\\sample.dat");
		Path toFile = Paths.get(".\\copy.dat");
		
		try {
			Files.copy(fromFile, toFile);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		// 8-3-2 ファイルを削除する
		Path path = Paths.get(".\\copy.dat");
		
		try {
			Files.delete(path);
		} catch (NoSuchFileException ex) {	// 削除対象のファイルが存在しない
			System.out.println(ex);
		} catch (DirectoryNotEmptyException ex) { // 対象がディレクトリで、空ではない
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}

		// 8-3-3 ファイルを作成する
		Path newpath = Paths.get(".\\new.dat");
		
		try {
			Files.createFile(newpath);
		} catch (FileAlreadyExistsException ex) { // 対象が既に存在する
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		// 8-3-4 ディレクトリを作成する
		Path newdir = Paths.get(".\\newdir");
		
		try {
			Files.createDirectory(newdir);
		} catch (NoSuchFileException ex) { // 対象が既に存在する
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}

		Path subdir = Paths.get(".\\newdir\\subdir");
		
		try {
			Files.createDirectories(subdir);
		} catch (FileAlreadyExistsException ex) { // 対象が既に存在する
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}

		// 8-3-5 一時ファイルを作成する
		Path tmpdir = Paths.get(".\\newdir");
		
		try {
			Files.createTempFile(tmpdir, "pre", ".tmp");
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}

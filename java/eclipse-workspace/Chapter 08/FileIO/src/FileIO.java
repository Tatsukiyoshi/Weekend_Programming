import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {

	public static void main(String[] args) {
		// 8-2-2 バイナリファイルに書き込む
		Path path = Paths.get(".\\sample.dat");
		byte[] data = new byte[]{0x41, 0x42, 0x43};
		
		try {
			Files.write(path, data, StandardOpenOption.APPEND,
					StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		} catch(IOException ex) {
			System.out.println(ex);
		}
		
		// 8-2-1 バイナリファイルを読み込む
		try (InputStream is = Files.newInputStream(path)){
			for(int ch; (ch = is.read()) != -1;) {
				System.out.print((char)ch);
			}
		} catch(IOException ex) {
			System.out.println(ex);
		}
		
		// 8-2-4 テキストファイルを書き込む
		Path path2 = Paths.get(".\\sample.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(path2, StandardCharsets.UTF_8)){
			writer.append("test");
			writer.newLine();
			writer.append("test2");
		} catch(IOException ex) {
			System.out.println(ex);
		}
		
		// 8-2-3 テキストファイルを読み込む
		try (BufferedReader reader = Files.newBufferedReader(path2, StandardCharsets.UTF_8)){
			for(String line; (line = reader.readLine()) != null; ) {
				System.out.println(line);
			}
		} catch(IOException ex) {
			System.out.println(ex);
		}
		
		// 8-2-5 Stream APIを使ってファイルを読み込む
		Path path3 = Paths.get(".\\userlist.txt");
		
		try(BufferedReader reader = Files.newBufferedReader(path3, StandardCharsets.UTF_8)){
			reader.lines()
			.map(s -> s.split(" ")[0]).distinct()
			.forEach(System.out::println);
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}
}

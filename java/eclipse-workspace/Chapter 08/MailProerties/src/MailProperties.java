import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

public class MailProperties {

	// 8-4-1 プロパティファイル
	public static void main(String[] args) {
		//System.out.println(System.getProperty("java.class.path"));
		
		Path path = Paths.get("mail.properties");
		
		try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
			Properties properties = new Properties();
			properties.load(reader);
			
			String address = properties.getProperty("system.mail.address");
			System.out.println(address);
			
		} catch (IOException ex) {
			System.out.println(ex);
		}

		// 8-4-2 国際化対応
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("mail");
			String errormessage = bundle.getString("system.mail.errormessage");
			System.out.println(errormessage);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

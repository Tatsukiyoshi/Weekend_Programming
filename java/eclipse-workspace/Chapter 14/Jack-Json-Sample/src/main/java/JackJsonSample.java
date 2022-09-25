import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackJsonSample {

	public static void main(String[] args) {
		readJsonFile("data/employee.json");
		writeJsonFile("data/newEmployee.json");
	}

	/**
	 * Jsonファイルの読み込み
	 * @param jsonFile JSONデータファイル
	 */
	public static void readJsonFile(String jsonFile) {
		File file = new File(jsonFile);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(file, Employee.class);
			System.out.println(employee.getName());
			System.out.println(employee.getAge().toString());
			System.out.println(employee.getLicenses().toString());
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * JSONファイルの生成
	 * @param jsonFile JSONデータファイル
	 */
	private static void writeJsonFile(String jsonFile) {
		Employee employee = new Employee();
		employee.setName("山田 太郎");
		employee.setAge(35);
		employee.setLicenses(Arrays.asList("第一種運転免許", "応用情報技術者"));
		
		File file = new File(jsonFile);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(file, employee);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

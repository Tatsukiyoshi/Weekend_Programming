import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

/**
 * @author taish
 *
 */
public class SuperCSVSample {
	private static final Logger logger = LoggerFactory.getLogger(SuperCSVSample.class);

	/**
	 * CSVデータを読み込む（SuperCSV）
	 * @param csvFile CSVファイル名
	 */
	public static void ReadCSV(String csvFile) {
		// 項目の制約を定義する
		CellProcessor[] processors = new CellProcessor[] {
				new NotNull(),
				new ParseInt(new NotNull()),
				new ParseDate("yyyy/MM/dd"),
				new StrRegEx("[a-z0-9\\._]+@[a-z0-9\\.]+"),
				new Optional()
		};

		logger.info("pwd = {}", System.getProperty("user.dir"));

		Path path = Paths.get(csvFile);
			
		try (ICsvBeanReader beanReader = new CsvBeanReader(Files.newBufferedReader(path),
				CsvPreference.STANDARD_PREFERENCE)) {
			String[] header = beanReader.getHeader(true);
			Employee employee;
			
			while((employee = beanReader.read(Employee.class, header, processors)) != null) {
				logger.info(employee.getName());
				logger.info(employee.getAge().toString());
				logger.info(employee.getBirth().toString());
				logger.info(employee.getEmail());
				logger.info(employee.getNote());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CSVデータを書き込む（SuperCSV）
	 * @param csvFile CSVファイル名
	 */
	public static void WriteCSV(String csvFile) {
		// 保存するデータ
		List<Employee> employeeList = new ArrayList<Employee>();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		TemporalAccessor parsed = dateTimeFormatter.parse("1978/04/01");
		LocalDate date = LocalDate.from(parsed);
		Employee employee = new Employee("山田 太郎", 35, Employee.localDate2Date(date), "yamada@xxx.co.jp", "所有免許：第一種運転免許,応用情報技術者");
		employeeList.add(employee);

		parsed = dateTimeFormatter.parse("1985/10/23");
		date = LocalDate.from(parsed);
		employee = new Employee("鈴木 花子", 28, Employee.localDate2Date(date), "suzuki@xxx.co.jp", null);
		employeeList.add(employee);
		
		// CSVデータのヘッダ
		String[] header = new String[]{"name", "age", "birth", "email", "note"};
		
		// 項目の制約を定義する
		CellProcessor[] processors = new CellProcessor[] {
				new NotNull(),				// name
				new NotNull(),				// age
				new FmtDate("yyyy/MM/dd"),	// birth
				new NotNull(),				// email
				new Optional()				// note
		};
		
		Path path = Paths.get(csvFile);
		
		try (ICsvBeanWriter beanWriter = new CsvBeanWriter(Files.newBufferedWriter(path),
				CsvPreference.STANDARD_PREFERENCE)) {
			beanWriter.writeHeader(header);
			for(Employee workEmployee : employeeList) {
				beanWriter.write(workEmployee, header, processors);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReadCSV("data\\employee.csv");

		WriteCSV("data\\employee2.csv");
	}
}

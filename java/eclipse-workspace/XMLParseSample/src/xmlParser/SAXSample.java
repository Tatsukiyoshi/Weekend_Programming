package xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SAXSample {
	public void parse(String xmlFile) {
		try (InputStream is = Files.newInputStream(Paths.get(xmlFile))) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SampleHandler handler = new SampleHandler();
			
			parser.parse(is, handler);
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println(ex);
		}
	}
}

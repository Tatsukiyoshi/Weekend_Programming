package xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXCoursorSample {
	public void parse(String xmlFile) {
		try (InputStream is = Files.newInputStream(Paths.get(xmlFile))){
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(is);
			
			while(reader.hasNext()) {
				reader.next();
				
				int eventType = reader.getEventType();
				
				if(eventType == XMLStreamConstants.START_ELEMENT) {
					System.out.println("Name: " + reader.getName());
					
					int count = reader.getAttributeCount();
					if(count != 0) {
						System.out.println("Attribute:");
						for(int index = 0; index < count; index++) {
							System.out.println("  Name: " + reader.getAttributeLocalName(index));
							System.out.println("  Value: " + reader.getAttributeValue(index));
						}
					}
				} else if(eventType == XMLStreamConstants.CHARACTERS) {
					String text = reader.getText().trim();
					if(!text.isEmpty()) {
						System.out.println("Text: " + text);
						System.out.println();
					}
				}
			}
		} catch (IOException | XMLStreamException ex) {
			System.out.println(ex);
		}
	}
}

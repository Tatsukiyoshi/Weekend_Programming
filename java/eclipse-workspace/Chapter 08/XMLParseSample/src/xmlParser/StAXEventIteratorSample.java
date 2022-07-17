package xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXEventIteratorSample {
	public void parse(String xmlFile) {
		try (InputStream is = Files.newInputStream(Paths.get(xmlFile))){
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader reader = factory.createXMLEventReader(is);
			
			// 処理対象のイベントを絞り込むフィルタを設定する
			EventFilter filter = new EventFilter() {
				public boolean accept(XMLEvent event) {
					return event.isStartElement() || event.isCharacters();
				}
			};
			
			reader = factory.createFilteredReader(reader, filter);
			
			while(reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				
				if(event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					System.out.println("Name: " + startElement.getName());
					
					Iterator<Attribute> attributes = startElement.getAttributes();
					if(attributes.hasNext()) {
						System.out.println("Attribute:");
						
						while(attributes.hasNext()) {
							Attribute attribute = attributes.next();
							System.out.println("  Name: " + attribute.getName());
							System.out.println("  Value: " + attribute.getValue());
						}
					}
				} else if(event.isCharacters()) {
					Characters characters = event.asCharacters();
					String text = characters.getData().trim();
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

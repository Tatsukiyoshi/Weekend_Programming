package xmlParser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SampleHandler extends DefaultHandler {
	@Override
	public void startDocument() {
		System.out.println("Start Document");
	}
	
	@Override
	public void endDocument() {
		System.out.println("End Document");
	}
	
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
		if(atts != null) {
			for(int index = 0; index < atts.getLength(); index++) {
				System.out.println("Attribute: " + atts.getQName(index) + "=" + atts.getValue(index));
			}
		}
		System.out.println("Start Element: " + qName);
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) {
		System.out.println("End Element: " + qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		String text = new String(ch, start, length);
		System.out.println("Text: " + text);
	}
}

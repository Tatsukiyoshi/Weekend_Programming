package xmlParser;

public class XMLParseSample {

	private static String parseFile = "staff.xml";
	
	public static String getParseFile() {
		return parseFile;
	}

	public static void main(String[] args) {
		System.out.println("DOM Sample:");
		DOMSample domSample = new DOMSample();
		domSample.parse(getParseFile());

		System.out.println("SAX Sample:");
		SAXSample saxSample = new SAXSample();
		saxSample.parse(getParseFile());

		System.out.println("StAX Cursor API Sample:");
		StAXCoursorSample staxCursorSample = new StAXCoursorSample();
		staxCursorSample.parse(getParseFile());
		
		System.out.println("StAX Event Iterator API Sample:");
		StAXEventIteratorSample staxEventIteratorSample = new StAXEventIteratorSample();
		staxEventIteratorSample.parse(getParseFile());
		
		System.out.println("XPath Sample:");
		XPathSample xpathSample = new XPathSample();
		xpathSample.parse(getParseFile());
	}
}

package xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMSample {
	public void parse(String xmlfile) {
		try (InputStream is = Files.newInputStream(Paths.get(xmlfile))){
			DocumentBuilder builder = DocumentBuilderFactory
					.newInstance().newDocumentBuilder();
			Node root = builder.parse(is);
			readRecursive(root);
		} catch (ParserConfigurationException | IOException | SAXException ex) {
			System.out.println(ex);
		}
	}

	private void readRecursive(Node node) {
		Node child = node.getFirstChild();
		
		while (child != null) {
			printNode(child);
			NamedNodeMap attributes = child.getAttributes();
			if( attributes != null) {
				for(int index = 0; index < attributes.getLength(); index++) {
					Node attribute = attributes.item(index);
					System.out.print("Attribute: ");
					printNode(attribute);
				}
			}
			readRecursive(child);
			child = child.getNextSibling();
		}
	}

	private void printNode(Node node) {
		System.out.println(node.getNodeName() + "=" + node.getNodeValue());
	}
}

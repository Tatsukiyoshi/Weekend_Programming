package xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathSample {
	public void parse(String xmlFile) {
		try (InputStream is = Files.newInputStream(Paths.get(xmlFile))){
			DocumentBuilder builder = DocumentBuilderFactory
					.newInstance().newDocumentBuilder();
			Document document = builder.parse(is);
			
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			
			// staffタグのid属性を取得する
			System.out.println("id=" + xpath.evaluate("/staffs/staff/@id", document));
			
			// staffタグ内、nameタグ内のfirstnameタグで囲まれた文字列を取得する
			System.out.println("firstname=" + xpath.evaluate("/staffs/staff/name/firstname/text()", document));
			
			// staffタグ内のnameタグで、firstnameタグで囲まれた文字列が「Takuya」であるnameタグの
			// lastnameタグで囲まれた文字列を取得する
			System.out.println("lastname=" + xpath.evaluate("/staffs/staff/name[firstname='Takuya']/lastname/text()", document));
		} catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException ex) {
			System.out.println(ex);
		}
	}
}

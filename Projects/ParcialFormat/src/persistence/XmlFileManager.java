package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlFileManager {

	public ArrayList<Object> readFile(String fileName){
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(new File(fileName));
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}
		document.getDocumentElement().normalize();
		return parserDocument(document);
	}
	
	public ArrayList<Object> parserDocument(Document document){
		ArrayList<Object> dataList = new ArrayList<>();
		NodeList nodeList = document.getElementsByTagName("contenido");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			dataList.add(element);
		}
		return dataList;
	}	
}

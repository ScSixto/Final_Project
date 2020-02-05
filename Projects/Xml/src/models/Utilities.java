package models;

import org.w3c.dom.Element;

public class Utilities {
	
	public static Content parseContent(Object object){
		Element element = (Element) object;
		int id = Integer.parseInt(element.getElementsByTagName("atributo").item(0).getTextContent());
		String name = element.getElementsByTagName("atributo").item(1).getTextContent();
		return new Content(id, name);
	}
}
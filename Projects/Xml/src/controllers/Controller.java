package controllers;

import java.util.ArrayList;

import models.Content;
import models.ModelManager;
import models.Utilities;
import persistence.XmlFileManager;

import org.w3c.dom.Element;

public class Controller {

	public static final String DATA_FILE_PATH = "https://datos.madrid.es/portal/site/egob/menuitem.ac61933d6ee3c" +
			"31cae77ae7784f1a5a0/?vgnextoid=00149033f2201410VgnVCM100000171f5a0aRCRD&format=xml&file=0&filename=2" +
			"00186-0-polideportivos&mgmtid=4a5fbef4b2503410VgnVCM2000000c205a0aRCRD&preview=full"/*"resources/contentList.xml"*/;

	private XmlFileManager fileXml;
	private ModelManager modelManager;
	
	Controller(){
		fileXml = new XmlFileManager();
		modelManager = new ModelManager();
		init();
	}
	
	private void init(){
		manageReadXmlFile();
		showConsoleReport();
	}
	
	private void manageReadXmlFile(){
		ArrayList<Object> dataList = fileXml.readFile(DATA_FILE_PATH
				, false);
		for (Object object : dataList) {
			modelManager.addContent(Utilities.parseContent(object));
		}
	}
	
	public void showConsoleReport(){
		modelManager.showReport();
	}
	
	public void writeXmlFile(){
		for(Content content: modelManager.getContentList()) {
 		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}

package persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


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


	public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		URL url = null;
		InputStream inputStream = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(filePath);
			HttpURLConnection httpURLConnection;
			url = new URL( filePath );
			if ( !isProxy ) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();
				inputStream = httpURLConnection.getInputStream();
			}else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if(inputStream == null )
					System.out.println( "Este input no quiere funcionar" );
			}

		}catch(ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection( isProxy, filePath );
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println( "Catch: " + e.getMessage()  );
			return getHttpURLConnection( isProxy, filePath );
		} catch (MalformedURLException e1) {
			System.out.println(  e1.getMessage()  );
		}catch (IOException e) {
			System.out.println(  e.getMessage()  );
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}

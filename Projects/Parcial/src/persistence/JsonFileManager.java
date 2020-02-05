package persistence;

import models.EmployeeVariable;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonFileManager {
    public static final char READ_MODE = 'r';
    public static final char WRITE_MODE = 'w';

    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;
    private BufferedReader buffReader;

    public static ArrayList<Object[]> readEmployees(String fileName) throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        BufferedReader br = new BufferedReader(getReader(fileName,true));
        ArrayList<Object[]> employeeList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) org.json.simple.Jsoner.deserialize(br);
        JsonArray listOfEmployee = (JsonArray)  jsonObject.get("empleados");
        for(Object object: listOfEmployee){
            JsonObject employeeObj = (JsonObject) object;
            employeeList.add(new Object[]{employeeObj.getString(EmployeeVariable.FIRST_NAME.getJsonName()), 
            		employeeObj.getString(EmployeeVariable.LAST_NAME.getJsonName()),
            		employeeObj.getString(EmployeeVariable.DOCUMENT_TYPE.getJsonName()),
            		employeeObj.getString(EmployeeVariable.DOCUMENT_NUMBER.getJsonName()),
            		employeeObj.getString(EmployeeVariable.BONDING_TYPE.getJsonName()),
            		employeeObj.getString(EmployeeVariable.RANKING_CATEGORY.getJsonName()),
            		employeeObj.getString(EmployeeVariable.SALARY_POINTS.getJsonName()),
            		employeeObj.getString(EmployeeVariable.WORKED_MONTHS.getJsonName())});
        }
        return employeeList;
    }

    public JsonArray getJsonEmployeeArray(ArrayList<HashMap<EmployeeVariable, Object>> employeeList){
        JsonArray jsonEmployeeList = new JsonArray();
        for(HashMap<EmployeeVariable, Object> employee: employeeList){
            if(employee!= null){
            JsonObject employeeObj = new JsonObject();
            Iterator<Map.Entry<EmployeeVariable,Object>> it = employee.entrySet().iterator();
//            System.out.println(employee.get(EmployeeVariable.ID) + " - " + employee.get(EmployeeVariable.FIRST_NAME));
            while(it.hasNext()){
                Map.Entry<EmployeeVariable,Object> employeeInfo = it.next();
                employeeObj.put(employeeInfo.getKey().getJsonName(), "" + employeeInfo.getValue());
            }
        jsonEmployeeList.add(employeeObj);
        }}
        return jsonEmployeeList;
    }

    public void writeJsonFile(String filePath, String fileContent) throws IOException{
        this.openFile(filePath, WRITE_MODE);
        this.buffWriter = new BufferedWriter(this.fileWriter);
        this.buffWriter.write(fileContent);/*
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                this.buffWriter.write(info[i]);
                this.buffWriter.newLine();
            }
        }*/
        this.closeFile();
    }

    private void openFile(String filePath, char mode) throws IOException{
        this.file = new File(filePath);
        if(!this.file.isDirectory()){
            if(mode == WRITE_MODE){
                this.fileWriter = new FileWriter(file);
            }else if(mode == READ_MODE)
                this.fileReader = new FileReader(file);
        }
    }

    private void closeFile() throws IOException{
        if (fileReader != null) {
            buffReader.close();
            fileReader.close();
        }
        if (fileWriter != null) {
            buffWriter.close();
            fileWriter.close();
        }
    }

    public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
        HttpURLConnection httpURLConnection;
        URL url = null;
        InputStream inputStream = null;
        try {
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
        }
        return inputStream;
    }

    public static Reader getReader(String route, boolean isFile) throws FileNotFoundException{
        Reader reader;
        if(isFile)
            reader = new FileReader(route);
        else
            reader = new BufferedReader(new InputStreamReader(JsonFileManager.getHttpURLConnection(false, route)));
        return reader;
    }
}
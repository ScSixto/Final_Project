package persistence;

import models.AlgoVariable;
import models.ClaseVariable;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

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

    public ArrayList<Object[]> readAlgos(String fileName) throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        BufferedReader br = new BufferedReader(new InputStreamReader(getHttpURLConnection(false,fileName)));
        ArrayList<Object[]> playerList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) org.json.simple.Jsoner.deserialize(br);
        JsonArray listOfAlgo = (JsonArray) ((JsonObject) jsonObject.get("league")).get("standard");
        for(Object object: listOfAlgo){
            JsonObject playerObj = (JsonObject) object;
            playerList.add(new Object[]{playerObj.getString(AlgoVariable.ID.getJsonName()), playerObj.getString(AlgoVariable.FIRST_NAME.getJsonName()), playerObj.getString(AlgoVariable.LAST_NAME.getJsonName()), playerObj.getString(AlgoVariable.TEAM_ID.getJsonName()).split(" ")[0], playerObj.getString(AlgoVariable.JERSEY.getJsonName()), playerObj.getString(AlgoVariable.BIRTHDATE.getJsonName()), playerObj.getString(AlgoVariable.HEIGHT.getJsonName())});
        }
        return playerList;
    }

    public JsonArray getJsonAlgoArray(ArrayList<HashMap<AlgoVariable, Object>> playerList){
        JsonArray jsonAlgoList = new JsonArray();
        for(HashMap<AlgoVariable, Object> player: playerList){
            if(player!= null){
            JsonObject playerObj = new JsonObject();
            Iterator<Map.Entry<AlgoVariable,Object>> it = player.entrySet().iterator();
//            System.out.println(player.get(AlgoVariable.ID) + " - " + player.get(AlgoVariable.FIRST_NAME));
            while(it.hasNext()){
                Map.Entry<AlgoVariable,Object> playerInfo = it.next();
                playerObj.put(playerInfo.getKey().getJsonName(), "" + playerInfo.getValue());
            }
        jsonAlgoList.add(playerObj);
        }}
        return jsonAlgoList;
    }

    public JsonArray getJsonClaseArray(ArrayList<HashMap<ClaseVariable,Object>> teamList){
        JsonArray jsonClaseList = new JsonArray();
        for(HashMap<ClaseVariable,Object> team: teamList){
            JsonObject teamObj = new JsonObject();
            Iterator<Map.Entry<ClaseVariable,Object>> it = team.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<ClaseVariable,Object> teamInfo = it.next();
                if(teamInfo.getKey().equals(ClaseVariable.PLAYER_LIST)){
                    teamObj.put(ClaseVariable.PLAYER_LIST.getJsonName(), this.getJsonAlgoArray((ArrayList<HashMap<AlgoVariable, Object>>) teamInfo.getValue()));
                }else{
                    teamObj.put(teamInfo.getKey().getJsonName(), "" + teamInfo.getValue());
                }
            }
            jsonClaseList.add(teamObj);
        }
        return jsonClaseList;
    }

    public JsonObject getJsonClaseHeightReportObject(HashMap<ClaseVariable,Object> object){
        JsonObject jsonObject = new JsonObject();
        Iterator<Map.Entry<ClaseVariable, Object>> it = object.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<ClaseVariable, Object> objectEntry = it.next();
            if(objectEntry.getKey().equals(ClaseVariable.TEAM_LIST)){
                jsonObject.put(objectEntry.getKey().getJsonName(), this.getJsonClaseArray((ArrayList<HashMap<ClaseVariable,Object>>)objectEntry.getValue()));
            }else{
                jsonObject.put(objectEntry.getKey().getJsonName(),objectEntry.getValue());
            }
        }
        return jsonObject;
    }


    public JsonObject getJsonClaseAgeReportObject(HashMap<AgePeriod, Object> object){
        JsonObject jsonObject = new JsonObject();
        Iterator<Map.Entry<AgePeriod, Object>> it = object.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<AgePeriod, Object> objectEntry = it.next();
            if(objectEntry.getKey().equals(ClaseVariable.TEAM_LIST)){
                jsonObject.put(objectEntry.getKey().getJsonName(), this.getJsonClaseArray((ArrayList<HashMap<ClaseVariable,Object>>)objectEntry.getValue()));
            }else{
                jsonObject.put(objectEntry.getKey().getJsonName(),objectEntry.getValue());
            }
        }
        return jsonObject;
    }

    public static ArrayList<Object[]> readClases(String fileName) throws FileNotFoundException, IOException, DeserializationException{
        BufferedReader br = new BufferedReader(new InputStreamReader(getHttpURLConnection(false,fileName)));
//        System.out.println(br.readLine());
        ArrayList<Object[]> teamList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) Jsoner.deserialize(br);
//        System.out.println(((JsonObject)((JsonArray) ((JsonObject) ((JsonObject) jsonObject.get("sports_content")).get("teams")).get("team")).get(0)).getString("team_name"));
        JsonArray listOfClase = (JsonArray) ((JsonObject) ((JsonObject) jsonObject.get("sports_content")).get("teams")).get("team");
        for(Object object: listOfClase){
            JsonObject teamObj = (JsonObject) object;
            teamList.add(new Object[]{teamObj.getString(ClaseVariable.ID.getJsonName()), teamObj.getString(ClaseVariable.NAME.getJsonName()), teamObj.getString(ClaseVariable.NICKNAME.getJsonName()), teamObj.getString(ClaseVariable.CITY.getJsonName()), teamObj.getString(ClaseVariable.CONFERENCE.getJsonName()), teamObj.getBoolean(ClaseVariable.NBA_TEAM.getJsonName())});
        }
        return teamList;
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

    public Reader getReader(String route, boolean isFile) throws FileNotFoundException{
        Reader reader;
        if(isFile)
            reader = new FileReader(route);
        else
            reader = new BufferedReader(new InputStreamReader(JsonFile.getHttpURLConnection(false, route)));
        return reader;
    }
}
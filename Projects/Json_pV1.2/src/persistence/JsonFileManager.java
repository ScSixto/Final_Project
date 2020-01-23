package persistence;

import models.PlayerVariable;
import models.TeamVariable;
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

public class JsonFileManager{
    public static final char READ_MODE = 'r';
    public static final char WRITE_MODE = 'w';

    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;
    private BufferedReader buffReader;

    public ArrayList<Object[]> readPlayers(String fileName) throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        BufferedReader br = new BufferedReader(new InputStreamReader(getHttpURLConnection(false,fileName)));
        ArrayList<Object[]> playerList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) org.json.simple.Jsoner.deserialize(br);
        JsonArray listOfPlayer = (JsonArray) ((JsonObject) jsonObject.get("league")).get("standard");
        for(Object object: listOfPlayer){
            JsonObject playerObj = (JsonObject) object;
            playerList.add(new Object[]{playerObj.getString(PlayerVariable.ID.getJsonName()), playerObj.getString(PlayerVariable.FIRST_NAME.getJsonName()), playerObj.getString(PlayerVariable.LAST_NAME.getJsonName()), playerObj.getString(PlayerVariable.TEAM_ID.getJsonName()).split(" ")[0], playerObj.getString(PlayerVariable.JERSEY.getJsonName()), playerObj.getString(PlayerVariable.BIRTHDATE.getJsonName()), playerObj.getString(PlayerVariable.HEIGHT.getJsonName())});
        }
        return playerList;
    }

    public JsonArray getJsonPlayerArray(ArrayList<HashMap<PlayerVariable, Object>> playerList){
        JsonArray jsonPlayerList = new JsonArray();
        for(HashMap<PlayerVariable, Object> player: playerList){
            if(player!= null){
            JsonObject playerObj = new JsonObject();
            Iterator<Map.Entry<PlayerVariable,Object>> it = player.entrySet().iterator();
//            System.out.println(player.get(PlayerVariable.ID) + " - " + player.get(PlayerVariable.FIRST_NAME));
            while(it.hasNext()){
                Map.Entry<PlayerVariable,Object> playerInfo = it.next();
                playerObj.put(playerInfo.getKey().getJsonName(), "" + playerInfo.getValue());
            }
        jsonPlayerList.add(playerObj);
        }}
        return jsonPlayerList;
    }

    public JsonArray getJsonTeamArray(ArrayList<HashMap<TeamVariable,Object>> teamList){
        JsonArray jsonTeamList = new JsonArray();
        for(HashMap<TeamVariable,Object> team: teamList){
            JsonObject teamObj = new JsonObject();
            Iterator<Map.Entry<TeamVariable,Object>> it = team.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<TeamVariable,Object> teamInfo = it.next();
                if(teamInfo.getKey().equals(TeamVariable.PLAYER_LIST)){
                    teamObj.put(TeamVariable.PLAYER_LIST.getJsonName(), this.getJsonPlayerArray((ArrayList<HashMap<PlayerVariable, Object>>) teamInfo.getValue()));
                }else{
                    teamObj.put(teamInfo.getKey().getJsonName(), "" + teamInfo.getValue());
                }
            }
            jsonTeamList.add(teamObj);
        }
        return jsonTeamList;
    }

    public JsonObject getJsonTeamHeightReportObject(HashMap<TeamVariable,Object> object){
        JsonObject jsonObject = new JsonObject();
        Iterator<Map.Entry<TeamVariable, Object>> it = object.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<TeamVariable, Object> objectEntry = it.next();
            if(objectEntry.getKey().equals(TeamVariable.TEAM_LIST)){
                jsonObject.put(objectEntry.getKey().getJsonName(), this.getJsonTeamArray((ArrayList<HashMap<TeamVariable,Object>>)objectEntry.getValue()));
            }else{
                jsonObject.put(objectEntry.getKey().getJsonName(),objectEntry.getValue());
            }
        }
        return jsonObject;
    }


    public JsonObject getJsonTeamAgeReportObject(HashMap<AgePeriod, Object> object){
        JsonObject jsonObject = new JsonObject();
        Iterator<Map.Entry<AgePeriod, Object>> it = object.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<AgePeriod, Object> objectEntry = it.next();
            if(objectEntry.getKey().equals(TeamVariable.TEAM_LIST)){
                jsonObject.put(objectEntry.getKey().getJsonName(), this.getJsonTeamArray((ArrayList<HashMap<TeamVariable,Object>>)objectEntry.getValue()));
            }else{
                jsonObject.put(objectEntry.getKey().getJsonName(),objectEntry.getValue());
            }
        }
        return jsonObject;
    }

    public ArrayList<Object[]> readTeams(String fileName) throws FileNotFoundException, IOException, DeserializationException{
        BufferedReader br = new BufferedReader(new InputStreamReader(getHttpURLConnection(false,fileName)));
//        System.out.println(br.readLine());
        ArrayList<Object[]> teamList = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) Jsoner.deserialize(br);
//        System.out.println(((JsonObject)((JsonArray) ((JsonObject) ((JsonObject) jsonObject.get("sports_content")).get("teams")).get("team")).get(0)).getString("team_name"));
        JsonArray listOfTeam = (JsonArray) ((JsonObject) ((JsonObject) jsonObject.get("sports_content")).get("teams")).get("team");
        for(Object object: listOfTeam){
            JsonObject teamObj = (JsonObject) object;
            teamList.add(new Object[]{teamObj.getString(TeamVariable.ID.getJsonName()), teamObj.getString(TeamVariable.NAME.getJsonName()), teamObj.getString(TeamVariable.NICKNAME.getJsonName()), teamObj.getString(TeamVariable.CITY.getJsonName()), teamObj.getString(TeamVariable.CONFERENCE.getJsonName()), teamObj.getBoolean(TeamVariable.NBA_TEAM.getJsonName())});
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
                    System.out.println( "Este input No quiere funcionar" );
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


}
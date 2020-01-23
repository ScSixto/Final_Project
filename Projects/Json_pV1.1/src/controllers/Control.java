package controllers;

import models.Player;
import models.Team;
import models.TeamManager;
import models.Util;
import org.json.simple.DeserializationException;
import org.json.simple.JSONArray;
import persistence.JsonFileManager;

import java.io.IOException;
import java.util.ArrayList;

public class Control{

    private JsonFileManager fileManager;
    private TeamManager teamManager;

    public Control(){
        fileManager = new JsonFileManager();
        teamManager = new TeamManager();
        this.init();
    }

    private void init(){
        this.readFiles();
//        this.teamManager.showConsoleReport();
        this.writeTeamArray();
        this.generateHeightReport();
    }

    private void readFiles(){
        this.readTeams();
        this.readPlayers();
    }

    private void readTeams(){
        try {
            ArrayList<Object[]> teamObjectArrayList = fileManager.readTeams("http://data.nba.net/10s/");
            for(Object[] teamArray: teamObjectArrayList){
                teamManager.addTeam(new Team(Util.toLong((String)teamArray[0]),(String)teamArray[1],(String)teamArray[2],(String)teamArray[3],(String)teamArray[4],(boolean)teamArray[5]));
            }        } catch (IOException e) {
            e.printStackTrace();

        } catch (DeserializationException e) {
            e.printStackTrace();
        }
    }

    private void readPlayers(){
        try {
            ArrayList<Object[]> playerObjectArrayList = fileManager.readPlayers("http://data.nba.net/10s/prod/v1/2016/players.json");
            for(Object[] playerArray: playerObjectArrayList){
                long teamId = Util.toLong((String)playerArray[3]);
//                System.out.println((String)playerArray[1] + " teamId: (" +teamId  + ")");
                teamManager.addPlayer(new Player(Util.toLong((String)playerArray[0]),(String)playerArray[1],(String)playerArray[2],teamId,Util.toLong((String)playerArray[4]), Util.toLocalDate((String)playerArray[5]), Util.toDouble((String) playerArray[6])), teamId);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (DeserializationException e) {
            e.printStackTrace();
        }
    }

    private void writeTeamArray(){
        try{
            fileManager.writeJsonFile("C:/Users/S.c. Sixto/Documents/U/Programacion/P(II)/Projects/Json_pV1.1/resources/teams.json",((fileManager.getJsonTeamArray(teamManager.toHashMapList())).toJson()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void generateHeightReport(){
        try{
            fileManager.writeJsonFile("C:/Users/S.c. Sixto/Documents/U/Programacion/P(II)/Projects/Json_pV1.1/resources/HeighterPlayersByTeam.json",fileManager.getJsonTeamArray(teamManager.getPlayerListAboveHeightAverage()).toJson());
            fileManager.writeJsonFile("C:/Users/S.c. Sixto/Documents/U/Programacion/P(II)/Projects/Json_pV1.1/resources/HeighterPlayers.json",fileManager.getJsonTeamReportObject(Util.getHeightReportFormat(teamManager.getHeightAverage(), teamManager.getPlayerListAboveAverage())).toJson());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
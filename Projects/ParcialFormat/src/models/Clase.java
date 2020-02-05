package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;

public class Team{

    private long id;
    private String name;
    private String nickname;
    private String city;
    private String conference;
    private boolean nbaTeam;

    public String getName(){
        return name;
    }

    public String getNickname(){
        return nickname;
    }

    public String getCity(){
        return city;
    }

    public String getConference(){
        return conference;
    }

    public boolean isNbaTeam(){
        return nbaTeam;
    }

    public ArrayList<Player> getPlayerList(){
        return playerList;
    }

    public long getId(){
        return id;
    }

    private ArrayList<Player> playerList;

    public Team(long id, String name, String nickname, String city, String conference, boolean nbaTeam){
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.city = city;
        this.conference = conference;
        this.nbaTeam = nbaTeam;
        this.playerList = new ArrayList<>();
    }

    public Object[] toObjectArray(){
        return new Object[]{this.id, this.name, this.nickname, this.city, this.conference, this.nbaTeam};
    }

    public HashMap<TeamVariable, Object> toHashMap(){
        HashMap<TeamVariable, Object> teamVariables = new HashMap<TeamVariable, Object>();
        teamVariables.put(TeamVariable.ID, this.getId());
        teamVariables.put(TeamVariable.NAME, this.getName());
        teamVariables.put(TeamVariable.NICKNAME, this.getNickname());
        teamVariables.put(TeamVariable.CITY, this.getCity());
        teamVariables.put(TeamVariable.CONFERENCE, this.getConference());
        teamVariables.put(TeamVariable.NBA_TEAM, this.isNbaTeam());
        ArrayList<HashMap<PlayerVariable, Object>> playerList = new ArrayList<>();
        for(Player player: this.playerList){
            playerList.add(player.toHashMap());
        }
        teamVariables.put(TeamVariable.PLAYER_LIST, playerList);
        return teamVariables;
    }

    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public double getHeightAverage(){
        double heightPlus = 0;
        if(this.playerList.size() > 0){
            DecimalFormat decimalFormat = new DecimalFormat("#.000");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            for(Player player: playerList){
//            System.out.println((name) + ". " + (player.getFirstName()) + "-" + (player.getHeight()));
                heightPlus += Double.parseDouble(decimalFormat.format(player.getHeight()));
            }
            heightPlus = Double.parseDouble(decimalFormat.format(heightPlus/this.playerList.size()));
        }
        return heightPlus;
    }

    public HashMap<TeamVariable, Object> getPlayerListAboveAverage(){
        double heightAverage = this.getHeightAverage();
        HashMap<TeamVariable, Object> teamHeightReport = new HashMap<>();
        teamHeightReport.put(TeamVariable.ID, this.id);
        teamHeightReport.put(TeamVariable.NAME, this.name);
        teamHeightReport.put(TeamVariable.HEIGHT_AVERAGE, heightAverage);
        ArrayList<HashMap<PlayerVariable, Object>> playerListByHeight = new ArrayList<>();
        for(Player player: playerList){
            if(player.getHeight() > heightAverage){
                HashMap<PlayerVariable, Object> playerInfo = new HashMap<>();
                playerInfo.put(PlayerVariable.ID, player.getPlayerId());
                playerInfo.put(PlayerVariable.FIRST_NAME, player.getFirstName());
                playerInfo.put(PlayerVariable.LAST_NAME, player.getLastName());
                playerInfo.put(PlayerVariable.HEIGHT, player.getHeight());
                playerListByHeight.add(playerInfo);
            }
        }
        teamHeightReport.put(TeamVariable.PLAYER_LIST, playerListByHeight);
        return teamHeightReport;
    }

    public HashMap<TeamVariable, Object> getPlayerListAboveAverage(double heightAverage){
        HashMap<TeamVariable, Object> teamHeightReport = new HashMap<>();
        teamHeightReport.put(TeamVariable.ID, this.id);
        teamHeightReport.put(TeamVariable.NAME, this.name);
        ArrayList<HashMap<PlayerVariable, Object>> playerListByHeight = new ArrayList<>();
        for(Player player: playerList){
            if(player.getHeight() > heightAverage){
                HashMap<PlayerVariable, Object> playerInfo = new HashMap<>();
                playerInfo.put(PlayerVariable.ID, player.getPlayerId());
                playerInfo.put(PlayerVariable.FIRST_NAME, player.getFirstName());
                playerInfo.put(PlayerVariable.LAST_NAME, player.getLastName());
                playerInfo.put(PlayerVariable.HEIGHT, player.getHeight());
                playerListByHeight.add(playerInfo);
            }
        }
        teamHeightReport.put(TeamVariable.PLAYER_LIST, playerListByHeight);
        return teamHeightReport;
    }

    public HashMap<TeamVariable, Object> getPlayerListAboveAge(int yearAge){
        HashMap<TeamVariable, Object> teamAgeReport = new HashMap<>();
        teamAgeReport.put(TeamVariable.ID, this.id);
        teamAgeReport.put(TeamVariable.NAME, this.name);
        ArrayList<HashMap<PlayerVariable, Object>> playerListByAge = new ArrayList<>();
        for(Player player: playerList){
            int playerAge = player.calculateAge();
            if(playerAge > yearAge){
                HashMap<PlayerVariable, Object> playerInfo = new HashMap<>();
                playerInfo.put(PlayerVariable.ID, player.getPlayerId());
                playerInfo.put(PlayerVariable.FIRST_NAME, player.getFirstName());
                playerInfo.put(PlayerVariable.LAST_NAME, player.getLastName());
                playerInfo.put(PlayerVariable.AGE, playerAge);
                playerListByAge.add(playerInfo);
            }
        }
        teamAgeReport.put(TeamVariable.PLAYER_LIST, playerListByAge);
        return teamAgeReport;
    }
}
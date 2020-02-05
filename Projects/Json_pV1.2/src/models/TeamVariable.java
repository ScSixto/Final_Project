package models;

public enum TeamVariable{
    ID("team_id"), NAME("team_name"), NICKNAME("team_nickname"), HEIGHT_AVERAGE("height_average"), TEAM_LIST("team_list"),
    CITY("city"), CONFERENCE("conference"), NBA_TEAM("is_nba_team"), PLAYER_LIST("player_list");

    private String jsonName;

    TeamVariable(String jsonName){
        this.jsonName = jsonName;
    }

    public String getJsonName(){
        return jsonName;
    }
}
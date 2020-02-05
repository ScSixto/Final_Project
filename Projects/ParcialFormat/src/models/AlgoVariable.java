package models;

public enum PlayerVariable{
    ID("personId"), FIRST_NAME("firstName"), LAST_NAME("lastName"), TEAM_ID("teamId"),
    JERSEY("jersey"), BIRTHDATE("dateOfBirthUTC"), HEIGHT("heightMeters"), AGE("player_age");

    private String jsonName;

    PlayerVariable(String jsonName){
        this.jsonName = jsonName;
    }

    public String getJsonName(){
        return jsonName;
    }
}
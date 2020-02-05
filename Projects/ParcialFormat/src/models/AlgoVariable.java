package models;

public enum AlgoVariable {
    ID("personId"), FIRST_NAME("firstName"), LAST_NAME("lastName"), TEAM_ID("teamId"),
    JERSEY("jersey"), BIRTHDATE("dateOfBirthUTC"), HEIGHT("heightMeters"), AGE("algo_age");

    private String jsonName;

    AlgoVariable(String jsonName){
        this.jsonName = jsonName;
    }

    public String getJsonName(){
        return jsonName;
    }
}
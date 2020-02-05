package models;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

public class Player{

    private String firstName;
    private String lastName;
    private long playerId;
    private long  teamId;
    private long jersey;
    private LocalDate birthDate;
    private double height;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPlayerId() {
        return playerId;
    }

    public long getTeamId() {
        return teamId;
    }

    public long getJersey() {
        return jersey;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getHeight() {
        return height;
    }

    public Player(long playerId, String firstName, String lastName, long teamId, long jersey, LocalDate birthDate, double height){
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerId = playerId;
        this.teamId = teamId;
        this.jersey = jersey;
        this.birthDate = birthDate;
        this.height = height;
    }

    public Object[] toObjectArray(){
        return new Object[]{ this.playerId, this.firstName, this.lastName, this.jersey, this.teamId, this.birthDate, this.height};
    }

    public HashMap<PlayerVariable, Object> toHashMap(){
        HashMap<PlayerVariable, Object> playerVariables = new HashMap<>();
        playerVariables.put(PlayerVariable.ID, this.playerId);
        playerVariables.put(PlayerVariable.FIRST_NAME, this.firstName);
        playerVariables.put(PlayerVariable.LAST_NAME, this.lastName);
        playerVariables.put(PlayerVariable.JERSEY, this.jersey);
        playerVariables.put(PlayerVariable.TEAM_ID, this.teamId);
        playerVariables.put(PlayerVariable.BIRTHDATE, this.birthDate);
        playerVariables.put(PlayerVariable.HEIGHT, this.height);
        return playerVariables;
    }

    public int calculateAge(){
        return Period.between(this.birthDate,LocalDate.now()).getYears();
    }
}
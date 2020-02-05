package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Algo {
	private int id;
	private String firstName;
	private String secondName;
	private String lastName;
	private Team team;
	private LocalTime routeTime;
	
	public Algo(int id, String firstName, String secondName, String lastName, Team team, LocalTime routeTime){
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.team = team;
		this.routeTime = routeTime;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getLastName() {
		return lastName;
	}


	public Team getTeam() {
		return team;
	}

	public LocalTime getRouteTime() {
		return routeTime;
	}

	public int getId(){
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setTeam(Team team) {
		this.team = team;
	}

	public void setRouteTime(LocalTime routeTime) {
		this.routeTime = routeTime;
	}

	public Object[] toObjectArray(){
		return new Object[]{this.id, this.firstName, this.secondName, this.lastName, this.team, this.routeTime};
	}

}
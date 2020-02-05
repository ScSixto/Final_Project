package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Runner{
	private int id;
	private String firstName;
	private String secondName;
	private String lastName;
	private LocalDate birthDate;
	private Gender gender;
	private Team team;
	private LocalTime routeTime;
	
	public Runner(int id, String firstName,String secondName,String lastName,LocalDate birthDate,Gender gender,Team team,LocalTime routeTime){
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Gender getGender() {
		return gender;
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

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setRouteTime(LocalTime routeTime) {
		this.routeTime = routeTime;
	}

	public Object[] toObjectArray(){
		return new Object[]{this.id, this.firstName, this.secondName, this.lastName, this.birthDate, this.gender, this.team, this.routeTime, this.calculateAge()};
	}

	public int calculateAge(){
		return Period.between(this.birthDate,LocalDate.now()).getYears();
	}
}
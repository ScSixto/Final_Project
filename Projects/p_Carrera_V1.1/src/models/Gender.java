package models;

public enum Gender {
	MALE(1,"Masculino"),FEMALE(2,"Femenino");

	private String gender;
	private int id;

	Gender(int id,String gender){
		this.gender = gender;
		this.id = id;
	}

	public String getGender(){
		return gender;
	}
	
	public int getId(){
		return id;
	}
}

package models;

public enum BedroomType {
	SENCILLA(1,"Sencilla"), DOBLE(2,"Doble"), ACOMODACION_MULTIPLE(3,"Acomodacion Multiple"),SUITE(4,"Suite"), EXIT(0,"Volver al menu");
	
	private String type;
	private int code;
	
	BedroomType(int code, String type){
		this.type = type;
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public int getCode() {
		return code;
	}
}

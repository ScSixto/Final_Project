package models;

public enum DocumentType {
	IDENTIFICATION_CARD("Cedula"), FOREIGNER_ID("Cedula de extranjeria"),PASSPORT("Pasaporte");

	private String text;

	DocumentType(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
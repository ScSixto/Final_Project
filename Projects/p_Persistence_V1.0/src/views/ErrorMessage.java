package views;

public enum ErrorMessage {
	INVALID_VALUE("Elemento invalido."), INVALID_FILE("Archivo invalido.");
	
	private String message;
	
	ErrorMessage(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

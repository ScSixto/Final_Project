package views;

public enum ErrorMessage {
	EMPLOYEE_LIST_EMPTY("No hay existencia de empleados en el sistema"),
	INVALID_VALUE("Elemento invalido"),
	INVALID_FILE("Archivo invalido"),
	INVALID_ID("Codigo ID invalido"),
	INVALID_DATE("Fecha invalida"),
	INVALID_SECOND_NAME("El segundo nombre debe iniciar en mayuscula");
	
	private String message;
	
	ErrorMessage(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
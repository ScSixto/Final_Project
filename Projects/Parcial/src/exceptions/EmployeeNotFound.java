package exceptions;

public class EmployeeNotFound extends Exception{

	private static final long serialVersionUID = 1L;

    public static final String MESSAGE = "El Algo ingresado no existe en el sistema.";

	public EmployeeNotFound(String message){
		super(MESSAGE + "\" " + message + "\"");
	}

	public EmployeeNotFound(){
		super(MESSAGE);
	}
}
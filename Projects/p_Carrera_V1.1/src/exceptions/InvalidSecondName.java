package exceptions;

public class InvalidSecondName extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "El Nombre ingresado es invalido.";
	
	public InvalidSecondName(String message){
		super(MESSAGE + " " + message);
	}
	
	public InvalidSecondName(){
		super(MESSAGE);
	}
}

package exceptions;

public class BirthDateInvalid extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "No es posible registrar la fecha ingresada.";
	
	public BirthDateInvalid(String message){
		super(MESSAGE + " " + message);
	}
	
	public BirthDateInvalid(){
		super(MESSAGE);
	}
}
package exceptions;

public class FileFormatInvalid extends Exception{
	public static final String MESSAGE = "El formato del fichero ingresado es invalido para la accion requerida.";
	
	public FileFormatInvalid(String message){
		super(MESSAGE + " " + message);
	}
	
	public FileFormatInvalid(){
		super(MESSAGE);
	}
}
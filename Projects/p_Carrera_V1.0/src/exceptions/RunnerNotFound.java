package exceptions;

public class RunnerNotFound extends Exception{
    public static final String MESSAGE = "El Corredor ingresado no existe en el sistema.";
	
	public RunnerNotFound(String message){
		super(MESSAGE + "\" " + message + "\"");
	}
	
	public RunnerNotFound(){
		super(MESSAGE);
	}
}
package exceptions;

public class RunnerNotFound extends Exception{

	private static final long serialVersionUID = 1L;
	
    public static final String MESSAGE = "El Corredor ingresado no existe en el sistema.";
	
	public RunnerNotFound(String message){
		super(MESSAGE + "\" " + message + "\"");
	}
	
	public RunnerNotFound(){
		super(MESSAGE);
	}
}
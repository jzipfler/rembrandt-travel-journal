package de.htwds.rembrandt.exception;

public class WizzardInputException extends RuntimeException{
	
	public static final String ERROR_FIELD = Messages.getString("WizzardInputException.0"); //$NON-NLS-1$
	public static final String MSG_ERROR_OCCURED = Messages.getString("WizzardInputException.1"); //$NON-NLS-1$
	
	public WizzardInputException(){
		super();
	}
	
	public WizzardInputException(String field){
		super(field);
	}

}

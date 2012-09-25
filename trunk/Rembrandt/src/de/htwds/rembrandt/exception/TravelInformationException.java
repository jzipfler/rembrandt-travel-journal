package de.htwds.rembrandt.exception;

/**
 * 
 * @author Daniel
 * @version 1.0 (12.09.2012)
 */
public class TravelInformationException extends RuntimeException {
	
	public static final String ERROR_FILE_NOT_FOUND = Messages.getString("TravelInformationException.0"); //$NON-NLS-1$
	
	public TravelInformationException(){
		super();
	}
	
	public TravelInformationException(String message){
		super(message);
	}

}

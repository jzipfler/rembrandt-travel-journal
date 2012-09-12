package de.htwds.rembrandt.exception;

/**
 * 
 * @author Daniel
 * @version 1.0 (12.09.2012)
 */
public class TravelInformationException extends RuntimeException {
	
	public static final String ERROR_FILE_NOT_FOUND = "Die entsprechende generalInformation.dat wurde nicht gefunden";
	
	public TravelInformationException(){
		super();
	}
	
	public TravelInformationException(String message){
		super(message);
	}

}

package de.htwds.rembrandt.exception;

public class WizzardInputException extends RuntimeException{
	
	public static final String ERROR_FIELD = " Feld darf nicht leer sein. Bitte geben sie Daten ein.";
	public static final String MSG_ERROR_OCCURED = "Fehler bei der Eingabe";
	
	public WizzardInputException(){
		super();
	}
	
	public WizzardInputException(String field){
		super(field);
	}

}

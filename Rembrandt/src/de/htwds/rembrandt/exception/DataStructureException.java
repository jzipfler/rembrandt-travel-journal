package de.htwds.rembrandt.exception;

public class DataStructureException extends RuntimeException {

	public static final String ERROR_EXISTS_AS_FILE = " - Existiert bereits als Datei.";
	public static final String ERROR_CREATE_FOLDER = " - Dieser Ordner konnte nicht erstellt werden.";
	
	
	public DataStructureException() {
		super();
	}
	
	public DataStructureException( String errorMessage ) {
		super( errorMessage );
	}
}

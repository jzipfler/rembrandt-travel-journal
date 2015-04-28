package de.htwds.rembrandt.exception;

public class DataStructureException extends RuntimeException {

	public static final String ERROR_EXISTS_AS_FILE = Messages.getString("DataStructureException.0"); //$NON-NLS-1$
	public static final String ERROR_CREATE_FOLDER = Messages.getString("DataStructureException.1"); //$NON-NLS-1$
	
	
	public DataStructureException() {
		super();
	}
	
	public DataStructureException( String errorMessage ) {
		super( errorMessage );
	}
}

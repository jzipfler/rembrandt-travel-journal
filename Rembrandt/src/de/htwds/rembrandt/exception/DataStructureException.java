package de.htwds.rembrandt.exception;

public class DataStructureException extends RuntimeException {

	public DataStructureException() {
		super();
	}
	
	public DataStructureException( String errorMessage ) {
		super( errorMessage );
	}
}

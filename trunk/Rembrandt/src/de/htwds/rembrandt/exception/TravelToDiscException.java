package de.htwds.rembrandt.exception;


/**
 * 
 * Use this class to report an error during an save or load operation of your classes.
 * 
 * @author Jan Zipfler
 * @version 1.0 ( Jan Zipfler - 2012-09-16 )
 *
 */
public class TravelToDiscException extends RuntimeException {

	
	public static final String NEW_LINE_HELPER_STRING = Messages.getString("TravelToDiscException.0"); //$NON-NLS-1$
	
	public static final String MSG_ERROR_DURING_SAVE_OR_LOAD = Messages.getString("TravelToDiscException.1"); //$NON-NLS-1$
	public static final String ERROR_SAVE_GENERAL_INFORMATION = Messages.getString("TravelToDiscException.2"); //$NON-NLS-1$
	public static final String ERROR_LOAD_GENERAL_INFORMATION = Messages.getString("TravelToDiscException.3"); //$NON-NLS-1$
	public static final String ERROR_LOAD_SELECTED_JOURNEY = Messages.getString("TravelToDiscException.4") + //$NON-NLS-1$
																Messages.getString("TravelToDiscException.5"); //$NON-NLS-1$
	public static final String ERROR_LOAD_GENERAL_INFO_FOR_START_VIEW = 	Messages.getString("TravelToDiscException.6") + //$NON-NLS-1$
																			Messages.getString("TravelToDiscException.7"); //$NON-NLS-1$
	public static final String ERROR_LOAD_START_VIEW = Messages.getString("TravelToDiscException.8"); //$NON-NLS-1$
	
	/**
	 * Standard constructor
	 */
	public TravelToDiscException() {
		super();
	}
	
	public TravelToDiscException( String message ) {
		super( message );
	}
}

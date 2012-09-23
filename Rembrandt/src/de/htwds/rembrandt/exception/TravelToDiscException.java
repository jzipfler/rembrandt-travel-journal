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

	
	public static final String NEW_LINE_HELPER_STRING = "\n";
	
	public static final String MSG_ERROR_DURING_SAVE_OR_LOAD = "Fehler bei speicher/lade Operation";
	public static final String ERROR_SAVE_GENERAL_INFORMATION = "Fehler beim speichern des Übersicht-Objekts.";
	public static final String ERROR_LOAD_GENERAL_INFORMATION = "Fehler beim laden des Übersicht-Objekts.";
	public static final String ERROR_LOAD_SELECTED_JOURNEY = "Die ausgewählte Reise wurde nicht vollständig geladen\n" +
																"da beim laden ein Fehler aufgetreten ist.";
	public static final String ERROR_LOAD_GENERAL_INFO_FOR_START_VIEW = 	"Das gelieferte GeneralInformation Objekt für die StartView\n" +
																			"war NULL. Bitte wenden Sie sich an ihren Ansprechpartner.";
	public static final String ERROR_LOAD_START_VIEW = "Fehler beim laden der StartView.";
	
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

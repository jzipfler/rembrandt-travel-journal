package de.htwds.rembrandt.exception;

public class ContactException extends RuntimeException {

	/**
	 * This constant is used to report that the first name have to be filled.
	 */
	public static final String ERROR_FIRSTNAME_EMPTY = Messages.getString("ContactException.0"); //$NON-NLS-1$
	/**
	 * This constant is used to report that the last name have to be filled.
	 */
	public static final String ERROR_LASTNAME_EMPTY = Messages.getString("ContactException.1"); //$NON-NLS-1$
	
	public static final String ERROR_CONTACT_ALREADY_EXISTS = Messages.getString("ContactException.2"); //$NON-NLS-1$
	
	public static final String ERROR_CONTACT_EXISTS_IN_BOTH_LISTS = Messages.getString("ContactException.3"); //$NON-NLS-1$
	
	public static final String ERROR_CONTACT_EXISTS_IN_PRIVATE_LIST = 	Messages.getString("ContactException.4") + //$NON-NLS-1$
																			Messages.getString("ContactException.5"); //$NON-NLS-1$
	
	public static final String ERROR_CONTACT_EXISTS_IN_GLOBAL_LIST = 	Messages.getString("ContactException.6") + //$NON-NLS-1$
																		Messages.getString("ContactException.7"); //$NON-NLS-1$
	
	public static final String MSG_ERROR_OCCURED = Messages.getString("ContactException.8"); //$NON-NLS-1$
	
	
	
	/**
	 * Standard constructor for this exception class that calls the RuntimeException constructor
	 */
	public ContactException() {
		super();
	}
	/**
	 * This constructor calls the RuntimeException constructor and sends an error massage to display it when caught.
	 * 
	 * @param errorMessage Specify why this exception is thrown to display it when caught.
	 */
	public ContactException( String errorMessage ){
		super( errorMessage );
	}
	
	/**
	 * This method checks if the parameter lastName is empty.
	 * If empty, an ContactException is thrown.
	 * 
	 * @param lastName The value that should be checked.
	 * @throws ContactException When the parameter is empty. Error constant for last name is used.
	 */
	public static void lastNameEmpty( String lastName ) throws ContactException {
		if ( lastName.trim().length() == 0 )
			throw new ContactException( ERROR_LASTNAME_EMPTY );
	}
	/**
	 * This method checks if the parameter firstName is empty.
	 * If empty, an ContactException is thrown.
	 * 
	 * @param firstName The value that should be checked.
	 * @throws ContactException When the parameter is empty. Error constant for first name is used.
	 */
	public static void firstNameEmpty( String firstName ) throws ContactException {
		if ( firstName.trim().length() == 0 )
			throw new ContactException( ERROR_FIRSTNAME_EMPTY );
	}
}

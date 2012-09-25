package de.htwds.rembrandt.controler.datastructure;

/**
 * This class provides informations about the operation system you are on.
 * 
 * @author Jan Zipfler
 * @version 20120910
 */
public final class OperationSystemPropertiesControler {

	/**
	 * The property string to get the home directory of the current user.
	 */
	public static final String PROPERTY_HOME_DIR = Messages.getString("OperationSystemPropertiesControler.0"); //$NON-NLS-1$
	
	/**
	 *The property string to get the name of the current logged in user. 
	 */
	public static final String PROPERTY_USER_NAME = Messages.getString("OperationSystemPropertiesControler.1"); //$NON-NLS-1$
	
	/**
	 * The property string to get the systems line separator.
	 */
	public static final String PROPERTY_LINE_SEPERATOR = Messages.getString("OperationSystemPropertiesControler.2"); //$NON-NLS-1$
	
	/**
	 * The property string to get the systems file separator.
	 */
	public static final String PROPERTY_FILE_SEPERATOR = Messages.getString("OperationSystemPropertiesControler.3"); //$NON-NLS-1$
	
	/**
	 * The property string to get the working directory if the current logged in user.
	 */
	public static final String PROPERTY_USER_DIR = Messages.getString("OperationSystemPropertiesControler.4"); //$NON-NLS-1$
	
	
	/**
	 * The file separator of windows.
	 */
	public static final String WINDOWS_FILE_SEPERATOR = Messages.getString("OperationSystemPropertiesControler.5"); //$NON-NLS-1$
	
	/**
	 * The file separator of unix.
	 */
	public static final String UNIX_FILE_SEPERATOR = Messages.getString("OperationSystemPropertiesControler.6");  //$NON-NLS-1$
	
	
	/**
	 * Cause the class contains only static methods, no constructor is needed.
	 */
	private OperationSystemPropertiesControler() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks if the system is a unix or a windows system.
	 * 
	 * @return true if unix system, false else.
	 */
	public static boolean isUnix() {
		return System.getProperty( PROPERTY_FILE_SEPERATOR ).equalsIgnoreCase( UNIX_FILE_SEPERATOR );
	}
	
	/**
	 * Checks if the system is a windows system.
	 * 
	 * @return true if windows system, false else.
	 */
	public static boolean isWindows() {
		return System.getProperty( PROPERTY_FILE_SEPERATOR ).equalsIgnoreCase( WINDOWS_FILE_SEPERATOR ); 
	}
	
	/**
	 * Returns the home directory path of the current logged in user.
	 * 
	 * @return Path of the home directory.
	 */
	public static String getHomeDirecroty() {
		return System.getProperty( PROPERTY_HOME_DIR );
	}
	
	/**
	 * Returns the user name of the current logged in user.
	 * 
	 * @return The current logged in user.
	 */
	public String getUserName() {
		return System.getProperty( PROPERTY_USER_NAME );
	}
	
	/**
	 * If you got a unix system, this method will return the file separator of it.
	 * If you on a windows system if will return null.
	 * 
	 * @return The unix file separator if unix, null else.
	 */
	public static String getFileSeperatorUnix() {
		if ( isUnix() )
			return System.getProperty( PROPERTY_FILE_SEPERATOR );
		return null;
	}
	
	/**
	 * If you got a windows system, this method will return the file separator of it.
	 * If you on a unix system if will return null.
	 * 
	 * @return The windows file separator if windows, null else.
	 */
	public String getFileSeperatorWindows() {
		if ( isWindows() )
			return System.getProperty( PROPERTY_FILE_SEPERATOR );
		return null;
	}
	
	/**
	 * If you want to know from which location the user starts your program, you can use this method. 
	 * 
	 * @return The working directory of the current logged in user.
	 */
	public static String getCurrentWorkingDirectory() {
		return System.getProperty( PROPERTY_USER_DIR );
	}
	
	/**
	 * 
	 * @return The line seperator.
	 */
	public static String getLineSeperator() {
		return System.getProperty( PROPERTY_LINE_SEPERATOR );
	}
	
	/**
	 * This method checks if your java version is at least version 6. 
	 * 
	 * @return true if minimum version 6, false else.
	 */
	public static boolean isJavaVersionMin6() {
		return ( getJavaVersion() >= 6 );
	}
	
	/**
	 * This method returns the number of java.
	 * 
	 * @return Your java version.
	 */
	public static int getJavaVersion() {
		
		String version = System.getProperty(Messages.getString("OperationSystemPropertiesControler.7")); //$NON-NLS-1$
		int indexOfDot = version.indexOf( Messages.getString("OperationSystemPropertiesControler.8") ); //$NON-NLS-1$
		
		version = version.substring( indexOfDot + 1 );
		indexOfDot = version.indexOf( Messages.getString("OperationSystemPropertiesControler.9") ); //$NON-NLS-1$
		
		version = version.substring(0, indexOfDot);
		
		return Integer.parseInt( version );
	}
	
}

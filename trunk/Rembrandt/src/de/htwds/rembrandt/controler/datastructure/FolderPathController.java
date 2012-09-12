package de.htwds.rembrandt.controler.datastructure;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-12 )
 */
public class FolderPathController {

	/**
	 * The main folder of our program
	 */
	public static final String MAIN_DIRECTORY_NAME 				= ".travel-journal";
	/**
	 * The contacts folder that contains all global contacts
	 */
	public static final String GLOBAL_CONTACT_DIRECTORY_NAME 		= "contacts";
	/**
	 * The general information folder that contains all travel information that appears in the info field of the ViewStart
	 */
	public static final String GENERAL_INFORMATION_DIRECTORY_NAME	= "generalInformation";
	/**
	 * The contact folder that contains all private contacts in each journey 
	 */
	public static final String PRIVATE_CONTACT_DIRECTORY_NAME		= "contacts";
	/**
	 * The photo folder that contains all photos in each journey 
	 */
	public static final String PHOTOS_DIRECTORY_NAME				= "photos";
	/**
	 * The checklist folder that contains all checklists in each journey 
	 */
	public static final String CHECKLISTS_DIRECTORY_NAME 			= "checklists";
	/**
	 * The acitvity folder that contains all activities in each journey 
	 */
	public static final String ACTIVITIES_DIRECTORY_NAME 			= "activities";
	/**
	 * The travel information folder that contains all general information about a journey in each journey
	 */
	public static final String TRAVEL_INFORMATION_DIRECTROY_NAME	= "travelInformation";
	
	/**
	 * Private cause - this class contains only static methods
	 */
	private FolderPathController() {
		
	}
	
	/**
	 * Returns the main directory of our program in the home directory of the specific user as String object
	 * 
	 * @return The main folder in the home directory
	 */
	public static String getMainFolder() {
		return ( getHomeFolder() 
				+ getFileSeperator()
				+ MAIN_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the general information directory of our program as String object
	 * 
	 * @return The general information folder
	 */
	public static String getGeneralInformationFolder() {
		return ( getMainFolder()
				+ getFileSeperator()
				+ GENERAL_INFORMATION_DIRECTORY_NAME );
	}
	
	public static String getGlobalContactFolder() {
		return ( getMainFolder()
				+ getFileSeperator()
				+ GLOBAL_CONTACT_DIRECTORY_NAME );
	}
	
	public static String getJourneyFolder( String journeyName ) {
		return ( getMainFolder()
				+ getFileSeperator()
				+ journeyName );
	}
	
	public static String getPrivateContactFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ PRIVATE_CONTACT_DIRECTORY_NAME );
	}
	
	public static String getPhotosFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ PHOTOS_DIRECTORY_NAME );
	}
	
	public static String getCecklistsFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ CHECKLISTS_DIRECTORY_NAME );
	}
	
	public static String getActivitiesFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ ACTIVITIES_DIRECTORY_NAME );
	}
	
	public static String getTravelInformationFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ TRAVEL_INFORMATION_DIRECTROY_NAME );
	}
	
	public static String getFileSeperator() {
		if ( OperationSystemPropertiesControler.isUnix() )
			return OperationSystemPropertiesControler.UNIX_FILE_SEPERATOR; 
		else
			return OperationSystemPropertiesControler.WINDOWS_FILE_SEPERATOR;
	}
	
	private static String getHomeFolder() {
		return OperationSystemPropertiesControler.getHomeDirecroty();
	}
}

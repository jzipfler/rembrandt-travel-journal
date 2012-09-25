package de.htwds.rembrandt.controler.datastructure;

/**
 * 
 * Use this class to get the information about the folder locations and the used file separator.
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-12 )
 */
public class FolderPathController {

	/**
	 * The main folder of our program
	 */
	public static final String MAIN_DIRECTORY_NAME 				= Messages.getString("FolderPathController.0"); //$NON-NLS-1$
	/**
	 * The contacts folder that contains all global contacts
	 */
	public static final String GLOBAL_CONTACT_DIRECTORY_NAME 		= Messages.getString("FolderPathController.1"); //$NON-NLS-1$
	/**
	 * The general information folder that contains all travel information that appears in the info field of the ViewStart
	 */
	public static final String GENERAL_INFORMATION_DIRECTORY_NAME	= Messages.getString("FolderPathController.2"); //$NON-NLS-1$
	/**
	 * The contact folder that contains all private contacts in each journey 
	 */
	public static final String PRIVATE_CONTACT_DIRECTORY_NAME		= Messages.getString("FolderPathController.3"); //$NON-NLS-1$
	/**
	 * The photo folder that contains all photos in each journey 
	 */
	public static final String PHOTOS_DIRECTORY_NAME				= Messages.getString("FolderPathController.4"); //$NON-NLS-1$
	/**
	 * The checklist folder that contains all checklists in each journey 
	 */
	public static final String CHECKLISTS_DIRECTORY_NAME 			= Messages.getString("FolderPathController.5"); //$NON-NLS-1$
	/**
	 * The acitvity folder that contains all activities in each journey 
	 */
	public static final String ACTIVITIES_DIRECTORY_NAME 			= Messages.getString("FolderPathController.6"); //$NON-NLS-1$
	/**
	 * The travel information folder that contains all general information about a journey in each journey
	 */
	public static final String TRAVEL_INFORMATION_DIRECTROY_NAME	= Messages.getString("FolderPathController.7"); //$NON-NLS-1$
	
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
	
	/**
	 * 
	 * @return The path name of the global contact folder
	 */
	public static String getGlobalContactFolder() {
		return ( getMainFolder()
				+ getFileSeperator()
				+ GLOBAL_CONTACT_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the journey folder and need the folder name of this journey which is explained in the param part of this doc
	 * 
	 * @param journeyName For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 * @return 
	 */
	public static String getJourneyFolder( String journeyName ) {
		return ( getMainFolder()
				+ getFileSeperator()
				+ journeyName );
	}
	
	/**
	 * Returns the private contact folder inside an existing journey, because of this it needs the journey name as parameter.
	 * 
	 * @param journeyName For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 * @return The path to the private contact folder
	 */
	public static String getPrivateContactFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ PRIVATE_CONTACT_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the photo folder inside an existing journey, because of this it needs the journey name as parameter.
	 * 
	 * @param journeyName For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 * @return The path to the photos folder
	 */
	public static String getPhotosFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ PHOTOS_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the checklist folder inside an existing journey, because of this it needs the journey name as parameter.
	 * 
	 * @param journeyName For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 * @return The path to the checklists folder
	 */
	public static String getCecklistsFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ CHECKLISTS_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the activities folder inside an existing journey, because of this it needs the journey name as parameter.
	 * 
	 * @param journeyName  For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 * @return The path to the activities folder
	 */
	public static String getActivitiesFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ ACTIVITIES_DIRECTORY_NAME );
	}
	
	/**
	 * Returns the travel information folder inside an existing journey, because of this it needs the journey name as parameter.
	 * 
	 * @param journeyName For this object use the GerneralInformationMode.getFolderName() --> viewStart.getJourneyModel().getGeneralInformationMode().getFolderName()
	 *
	 * @return The path to the travel information folder
	 */
	public static String getTravelInformationFolder( String journeyName ) {
		return ( getJourneyFolder(journeyName)
				+ getFileSeperator()
				+ TRAVEL_INFORMATION_DIRECTROY_NAME );
	}
	
	/**
	 * Returns the relevant file separator for unix or windows. Depends on which system you are working on.
	 * 
	 * @return the unix or windows file separator ( / or \ )
	 */
	public static String getFileSeperator() {
		if ( OperationSystemPropertiesControler.isUnix() )
			return OperationSystemPropertiesControler.UNIX_FILE_SEPERATOR; 
		else
			return OperationSystemPropertiesControler.WINDOWS_FILE_SEPERATOR;
	}
	
	/**
	 * Returns the home folder of the currend logged in user.
	 * 
	 * @return Home folder of the currend logged in user.
	 */
	private static String getHomeFolder() {
		return OperationSystemPropertiesControler.getHomeDirecroty();
	}
}

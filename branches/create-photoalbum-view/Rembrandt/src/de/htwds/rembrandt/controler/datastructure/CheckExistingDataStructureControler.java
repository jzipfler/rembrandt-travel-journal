package de.htwds.rembrandt.controler.datastructure;

import java.io.File;
import java.util.Properties;

import de.htwds.rembrandt.exception.DataStructureException;


/**
 * 
 * @author jan
 * @version 20120910
 */
public class CheckExistingDataStructureControler {

	private static String MAIN_DIRECTORY_NAME 				= ".travel-journal";
	private static String GLOBAL_CONTACT_DIRECTORY_NAME 	= "contacts";
	
	private String fileSeperator;
	private String homeDirectory;
	
	public CheckExistingDataStructureControler() {
		// TODO Auto-generated constructor stub
		checkExistingDataStructure();
	}
	
	public void checkExistingDataStructure() throws DataStructureException {
		
		homeDirectory = OperationSystemPropertiesControler.getHomeDirecroty();
		
		if ( OperationSystemPropertiesControler.isUnix() )
			fileSeperator = OperationSystemPropertiesControler.UNIX_FILE_SEPERATOR; 
		else
			fileSeperator = OperationSystemPropertiesControler.WINDOWS_FILE_SEPERATOR;
		
		checkAndCreateMainFolder();
		checkAndCreateGlobalContactFolder();
		
		
	}
	
	
	public void checkExistingDataStructure( String journey ) throws DataStructureException {
		
		homeDirectory = OperationSystemPropertiesControler.getHomeDirecroty();
		
		if ( OperationSystemPropertiesControler.isUnix() )
			fileSeperator = OperationSystemPropertiesControler.UNIX_FILE_SEPERATOR; 
		else
			fileSeperator = OperationSystemPropertiesControler.WINDOWS_FILE_SEPERATOR;
		
		checkAndCreateMainFolder();
		checkAndCreateGlobalContactFolder();
		
		
	}
	
	
	private void checkAndCreateGlobalContactFolder() {
		
		
		File globalContactDirectory = new File( 	homeDirectory + 
													fileSeperator + 
													MAIN_DIRECTORY_NAME +
													fileSeperator +
													GLOBAL_CONTACT_DIRECTORY_NAME );
		
		if ( globalContactDirectory.exists() ) {
			if (globalContactDirectory.isFile())
				throw new DataStructureException();
		}
		if ( !globalContactDirectory.exists() )
			if ( !(globalContactDirectory.mkdir()) )
				throw new DataStructureException();		
	}

	private void checkAndCreateMainFolder() throws DataStructureException {
		
		File projectDirectory = new File( 			homeDirectory + 
													fileSeperator + 
													MAIN_DIRECTORY_NAME );
		
		if ( projectDirectory.exists() ) {
			if (projectDirectory.isFile())
				throw new DataStructureException();
		}
		if ( !projectDirectory.exists() )
			if ( !(projectDirectory.mkdir()) )
				throw new DataStructureException();
				
	}	
	
}

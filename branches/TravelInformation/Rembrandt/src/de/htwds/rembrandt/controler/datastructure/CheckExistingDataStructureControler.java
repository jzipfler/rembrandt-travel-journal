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
	
	private String journey;
	
	public CheckExistingDataStructureControler() {
		
	}
	
	public void checkExistingDataStructure() throws DataStructureException {
		
		checkExistingDataStructure(null);
	}
	

	public void checkExistingDataStructure( String journey ) throws DataStructureException {
		
		checkAndCreateFile( FolderPathController.getMainFolder() );
		checkAndCreateFile( FolderPathController.getGeneralInformationFolder() );
		checkAndCreateFile( FolderPathController.getGlobalContactFolder() );
		
		if ( journey != null ) {
			this.journey = journey;
			checkAndCreateFile( FolderPathController.getJourneyFolder(journey) );
			checkAndCreateFile( FolderPathController.getPhotosFolder(journey) );
			checkAndCreateFile( FolderPathController.getPrivateContactFolder(journey) );
			checkAndCreateFile( FolderPathController.getCecklistsFolder(journey) );
			checkAndCreateFile( FolderPathController.getActivitiesFolder(journey) );
		}
		
	}
	
	private void checkAndCreateFile( String fileName ) {
		
		File checkingFile = new File( fileName );
		
		if ( checkingFile.exists() ) {
			if (checkingFile.isFile())
				throw new DataStructureException( fileName + DataStructureException.ERROR_EXISTS_AS_FILE );
		}
		if ( !checkingFile.exists() )
			if ( !(checkingFile.mkdir()) )
				throw new DataStructureException( fileName + DataStructureException.ERROR_CREATE_FOLDER );
	}
	
}

package de.htwds.rembrandt.controler.datastructure;

import java.io.File;

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
		
		checkAndCreateFolder( FolderPathController.getMainFolder() );
		checkAndCreateFolder( FolderPathController.getGeneralInformationFolder() );
		checkAndCreateFolder( FolderPathController.getGlobalContactFolder() );
		
		if ( journey != null ) {
			this.journey = journey;
			checkAndCreateFolder( FolderPathController.getJourneyFolder(journey) );
			checkAndCreateFolder( FolderPathController.getPhotosFolder(journey) );
			checkAndCreateFolder( FolderPathController.getPrivateContactFolder(journey) );
			checkAndCreateFolder( FolderPathController.getCecklistsFolder(journey) );
			checkAndCreateFolder( FolderPathController.getActivitiesFolder(journey) );
			checkAndCreateFolder( FolderPathController.getTravelInformationFolder(journey) );
		}
		
	}
	
	private void checkAndCreateFolder( String fileName ) {
		
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

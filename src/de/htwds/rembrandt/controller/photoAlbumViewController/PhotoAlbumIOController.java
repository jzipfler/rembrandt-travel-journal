package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.model.PhotoAlbumModel;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class PhotoAlbumIOController {
	
	private JourneyModel journeyModel;
	private String fileName;

	public PhotoAlbumIOController( JourneyModel journeyModel ) {
		this.journeyModel = journeyModel;
		this.fileName = FolderPathController.getPhotosFolder( journeyModel.getGeneralInformationModel().getFolderName() ) + FolderPathController.getFileSeperator() + Messages.getString("PhotoAlbumIOController.0"); //$NON-NLS-1$
	}

	public void save() {
		try {
			PhotoAlbumModel photoAlbumModel = journeyModel.getPhotoAlbumModel();
			File file = new File( fileName );			
			
			if( !file.isFile() ) file.createNewFile(); // file does not exists yet, create it first
			
			ObjectOutputStream outputStream = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream( file ) ) );
			outputStream.writeObject(photoAlbumModel);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
	
	public PhotoAlbumModel load() {
		try {
			PhotoAlbumModel photoAlbumModel;
			File file = new File( fileName );
			
			if( file.isFile() ) { // file exists, read 
				ObjectInputStream inputStream = new ObjectInputStream( new BufferedInputStream( new FileInputStream( file ) ) );
				photoAlbumModel = (PhotoAlbumModel) inputStream.readObject();
				inputStream.close();
				return photoAlbumModel;
			// TODO now in the views unneccessary here remove/change
			} else { // file does not exist yet, return new model instead
				photoAlbumModel = new PhotoAlbumModel();
				return photoAlbumModel;
			}
		} catch( Exception e ) {
			System.err.println( e );
		}
		return null; // load failed, return null
	}
}
package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.htwds.rembrandt.components.ImageFileView;
import de.htwds.rembrandt.components.ImageFilter;
import de.htwds.rembrandt.components.ImagePreview;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class PhotoAlbumDetailsViewAddPhotoActionListener implements ActionListener {
	
	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private LinkedList<Photo> photoAlbum;
	
	public PhotoAlbumDetailsViewAddPhotoActionListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileFilter( new ImageFilter() );
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileView(new ImageFileView());
		fileChooser.setAccessory(new ImagePreview(fileChooser));

		// process the selection 
		int selection = fileChooser.showDialog(viewPhotoAlbumDetails, Messages.getString("PhotoAlbumDetailsViewAddPhotoActionListener.0")); //$NON-NLS-1$
		
		if( selection == JFileChooser.APPROVE_OPTION ) {
			
			String selectedFilePath = fileChooser.getSelectedFile().getPath();
			File selectedFile = new File( selectedFilePath );
			
			// determine file name and last modified date
			Date fileDate = new Date(selectedFile.lastModified());
	    	String fileName = selectedFile.getName();	
	    	
	    	// determine new path inside the photos folder
	    	String photosFolderPath = FolderPathController.getPhotosFolder( viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getGeneralInformationModel().getFolderName() );
	    	String filePath = photosFolderPath + FolderPathController.getFileSeperator() + fileName;
	    	
	    	// create photo object
	    	Photo photo = new Photo( fileName, fileDate, filePath, Messages.getString("PhotoAlbumDetailsViewAddPhotoActionListener.1") ); //$NON-NLS-1$
	    	
	    	photoAlbum = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();
			
	    	if( photoAlbum.contains(photo)  ) {
				// photo already in the album display error message
	    		JOptionPane.showMessageDialog( viewPhotoAlbumDetails, Messages.getString("PhotoAlbumDetailsViewAddPhotoActionListener.2"), Messages.getString("PhotoAlbumDetailsViewAddPhotoActionListener.3"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
		    	// copy file to new location
				try {
					BufferedInputStream inputStream = new BufferedInputStream( new FileInputStream( selectedFilePath ) );
					BufferedOutputStream outputStream = new BufferedOutputStream( new FileOutputStream( filePath ) );
					
					byte[] buffer = new byte[1024];
					int length;
					
					while( ( length = inputStream.read(buffer) ) > 0 ) {
						outputStream.write(buffer, 0, length);
					}
					
					inputStream.close();
					outputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// add photo to album
				photoAlbum.add( photo );
				
				viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().setCurrentPhoto( photo );
				viewPhotoAlbumDetails.populate();
			}			
			
			// save
			new PhotoAlbumIOController( viewPhotoAlbumDetails.getParentFrame().getJourneyModel() ).save();	    	
		}
	}
}
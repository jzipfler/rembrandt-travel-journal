package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class PhotoAlbumDetailsViewRemovePhotoActionListener implements ActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	
	public PhotoAlbumDetailsViewRemovePhotoActionListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}	
	
	public void actionPerformed( ActionEvent event ) {
		
		// get current photo
		Photo currentPhoto = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().getCurrentPhoto();
		
		// remove photo from Album
		LinkedList<Photo> photoAlbum = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();
		int index = photoAlbum.indexOf( currentPhoto );
		photoAlbum.remove( currentPhoto );
		viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().setPhotoAlbum( photoAlbum );
		
		// update preview
		if( !photoAlbum.isEmpty() ) {
			if( index != 0 ) index--;
			Photo photo = photoAlbum.get( index );
			
			viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().setCurrentPhoto(photo);
			viewPhotoAlbumDetails.populatePhotoArea(photo);
		} else {
			viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().setCurrentPhoto(null);
			viewPhotoAlbumDetails.clearPhotoArea();
		}
		
		viewPhotoAlbumDetails.populateThumbnailArea( photoAlbum );
		
		// save
		new PhotoAlbumIOController( viewPhotoAlbumDetails.getParentFrame().getJourneyModel() ).save();
	}
}
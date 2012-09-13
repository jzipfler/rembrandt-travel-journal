package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class RemovePhotoActionListener implements ActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private Photo currentPhoto;
	LinkedList<Photo> photoAlbum;
	private Photo photo;
	
	public RemovePhotoActionListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}	
	
	public void actionPerformed( ActionEvent event ) {
		
		// get current photo
		currentPhoto = viewPhotoAlbumDetails.getPhotoAlbumModel().getCurrentPhoto();
		
		// remove photo from Album
		photoAlbum = viewPhotoAlbumDetails.getPhotoAlbumModel().getPhotoAlbum();
		int index = photoAlbum.indexOf( currentPhoto );
		System.out.println("index: " + index);
		photoAlbum.remove( currentPhoto );
		viewPhotoAlbumDetails.getPhotoAlbumModel().setPhotoAlbum( photoAlbum );
		
		// save
		new PhotoAlbumIOController().save( viewPhotoAlbumDetails.getPhotoAlbumModel() );		
		
		// update preview
		if( !photoAlbum.isEmpty() ) {
			if( index != 0 ) index--;
			photo = photoAlbum.get( index );
			
			viewPhotoAlbumDetails.getPhotoAlbumModel().setCurrentPhoto(photo);
			viewPhotoAlbumDetails.populatePhotoArea(photo);
		} else {
			viewPhotoAlbumDetails.clearPhotoArea();
			viewPhotoAlbumDetails.getPhotoAlbumModel().setCurrentPhoto(null);
		}
		
		viewPhotoAlbumDetails.populateThumbnailArea( photoAlbum );
	}

}
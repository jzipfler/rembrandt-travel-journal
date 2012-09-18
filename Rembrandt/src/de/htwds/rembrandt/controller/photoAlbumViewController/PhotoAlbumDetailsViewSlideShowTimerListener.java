package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class PhotoAlbumDetailsViewSlideShowTimerListener implements ActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;

	public PhotoAlbumDetailsViewSlideShowTimerListener(ViewPhotoAlbumDetails viewPhotoAlbumDetails) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	public void actionPerformed(ActionEvent event) {
		PhotoAlbumModel photoAlbumModel = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel();
		LinkedList<Photo> photoAlbum = photoAlbumModel.getPhotoAlbum();
		
		Photo currentPhoto = photoAlbumModel.getCurrentPhoto();
		Photo lastPhoto = photoAlbum.getLast();
		Photo firstPhoto = photoAlbum.getFirst();
		
		// last photo? begin at start
		if( currentPhoto.equals(lastPhoto) ) {
			photoAlbumModel.setCurrentPhoto(firstPhoto);
		} else { // else continue
			int index = photoAlbum.indexOf(currentPhoto);
			photoAlbumModel.setCurrentPhoto( photoAlbum.get(index+1) );
		}
		
		viewPhotoAlbumDetails.populatePhotoArea();
	}
}
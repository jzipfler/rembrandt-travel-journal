package de.htwds.rembrandt.controller.photoAlbumViewController;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class SavePhotoCommentActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;

	public SavePhotoCommentActionListener(ViewPhotoAlbumDetails viewPhotoAlbum) {
		this.viewPhotoAlbumDetails = viewPhotoAlbum;
	}

	public void saveComment() {
		String comment = viewPhotoAlbumDetails.getEpnPhotoComment().getText();
		Photo currentPhoto = viewPhotoAlbumDetails.getPhotoAlbumModel().getCurrentPhoto();
		currentPhoto.setComment( comment );
		
		new PhotoAlbumIOController().save( viewPhotoAlbumDetails.getPhotoAlbumModel() );
	}

}

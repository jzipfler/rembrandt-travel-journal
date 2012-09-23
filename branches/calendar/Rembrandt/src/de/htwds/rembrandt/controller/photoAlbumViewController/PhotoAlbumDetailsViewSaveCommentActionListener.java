package de.htwds.rembrandt.controller.photoAlbumViewController;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class PhotoAlbumDetailsViewSaveCommentActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;

	public PhotoAlbumDetailsViewSaveCommentActionListener(ViewPhotoAlbumDetails viewPhotoAlbum) {
		this.viewPhotoAlbumDetails = viewPhotoAlbum;
	}

	public void saveComment() {
		String comment = viewPhotoAlbumDetails.getEpnPhotoComment().getText();
		Photo currentPhoto = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().getCurrentPhoto();
		currentPhoto.setComment( comment );
		
		// save
		new PhotoAlbumIOController( viewPhotoAlbumDetails.getParentFrame().getJourneyModel() ).save();
	}

}

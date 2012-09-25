package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class PhotoAlbumDetailsViewToggleSlideShowListener implements ActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;

	public PhotoAlbumDetailsViewToggleSlideShowListener(ViewPhotoAlbumDetails viewPhotoAlbumDetails) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		viewPhotoAlbumDetails.toggleSlideShow();
	}


}

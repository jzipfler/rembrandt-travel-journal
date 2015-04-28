package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class PhotoAlbumDetailsViewResizeListener implements ComponentListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;

	public PhotoAlbumDetailsViewResizeListener(ViewPhotoAlbumDetails viewPhotoAlbumDetails) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}
	
	public void componentResized(ComponentEvent event) {
		viewPhotoAlbumDetails.adjustPhotoArea();
	}
	
	// not needed
	public void componentHidden ( ComponentEvent event ) {}
	public void componentMoved  ( ComponentEvent event ) {}
	public void componentShown  ( ComponentEvent event ) {}	
}
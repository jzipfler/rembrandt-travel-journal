package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumOverview;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class PhotoAlbumOverviewViewResizeListener implements ComponentListener {

	private ViewPhotoAlbumOverview viewPhotoAlbumOverview;

	public PhotoAlbumOverviewViewResizeListener(ViewPhotoAlbumOverview viewPhotoAlbumOverview) {
		this.viewPhotoAlbumOverview = viewPhotoAlbumOverview;
	}

	@Override
	public void componentResized(ComponentEvent event) {
		viewPhotoAlbumOverview.adjustPhotoArea();
	}
	
	// not needed
	@Override
	public void componentHidden ( ComponentEvent event ) {}
	@Override
	public void componentMoved  ( ComponentEvent event ) {}
	@Override
	public void componentShown  ( ComponentEvent event ) {}	
}
package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumOverview;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class ReturnToPhotoAlbumDetailsViewActionListener implements ActionListener {

	private ViewPhotoAlbumOverview viewPhotoAlbumOverview;

	public ReturnToPhotoAlbumDetailsViewActionListener(ViewPhotoAlbumOverview viewPhotoAlbumOverview) {
		this.viewPhotoAlbumOverview = viewPhotoAlbumOverview;
	}
	
	public void actionPerformed(ActionEvent event) {
		new LoadPhotoAlbumPanelActionListener( viewPhotoAlbumOverview.getParentFrame() ).loadPhotoAlbum();
	}

}

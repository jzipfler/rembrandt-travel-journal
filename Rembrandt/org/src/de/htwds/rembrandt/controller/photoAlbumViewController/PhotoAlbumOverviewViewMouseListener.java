package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumOverview;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class PhotoAlbumOverviewViewMouseListener implements MouseListener {

	private ViewPhotoAlbumOverview viewPhotoAlbumOverview;

	public PhotoAlbumOverviewViewMouseListener( ViewPhotoAlbumOverview viewPhotoAlbumOverview ) {
		this.viewPhotoAlbumOverview = viewPhotoAlbumOverview;
	}

	public void mouseClicked(MouseEvent event) {
		PhotoAlbumModel photoAlbumModel = viewPhotoAlbumOverview.getParentFrame().getJourneyModel().getPhotoAlbumModel();
		Photo photo = photoAlbumModel.findPhotoByPath( ((ImageIcon) ((JLabel) event.getComponent()).getIcon()).getDescription() );

		// switch to detail view
		photoAlbumModel.setCurrentPhoto(photo);
		new LoadPhotoAlbumDetailsPanelActionListener(viewPhotoAlbumOverview.getParentFrame()).loadPhotoAlbum();
	}

	// not needed
	public void mouseExited   ( MouseEvent event ) {}
	public void mouseEntered  ( MouseEvent event ) {}
	public void mousePressed  ( MouseEvent event ) {}
	public void mouseReleased ( MouseEvent event ) {}
}
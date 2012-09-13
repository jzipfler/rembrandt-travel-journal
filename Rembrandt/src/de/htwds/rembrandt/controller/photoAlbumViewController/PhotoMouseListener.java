package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumOverview;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class PhotoMouseListener implements MouseListener {

	private ViewPhotoAlbumOverview viewPhotoAlbumOverview;
	private PhotoAlbumModel photoAlbumModel;
	private Photo photo;

	public PhotoMouseListener( ViewPhotoAlbumOverview viewPhotoAlbumOverview ) {
		this.viewPhotoAlbumOverview = viewPhotoAlbumOverview;
	}

	public void mouseClicked(MouseEvent event) {
		photoAlbumModel = viewPhotoAlbumOverview.getPhotoAlbumModel();
		System.out.println(photoAlbumModel);
		photo = photoAlbumModel.findPhotoByImage( ((JLabel) event.getComponent()).getIcon() );
		System.out.println(photo);
		
		// switch to detail view
		new LoadPhotoAlbumPanelActionListener(viewPhotoAlbumOverview.getParentFrame(),photo).loadPhotoAlbum();
	}

	public void mouseExited( MouseEvent event ) {}
	public void mouseEntered( MouseEvent event ) {}
	public void mousePressed( MouseEvent event ) {}
	public void mouseReleased( MouseEvent event ) {}
}

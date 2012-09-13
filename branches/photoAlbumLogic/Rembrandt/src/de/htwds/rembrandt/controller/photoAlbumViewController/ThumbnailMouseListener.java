package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class ThumbnailMouseListener implements MouseListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private PhotoAlbumModel photoAlbumModel;
	private Photo photo;

	public ThumbnailMouseListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	public void mouseClicked(MouseEvent event) {
		photoAlbumModel = viewPhotoAlbumDetails.getPhotoAlbumModel();
		viewPhotoAlbumDetails.getPhotoAlbumModel().getPhotoAlbum();
		photo = photoAlbumModel.findPhotoByThumbnail( ((JLabel) event.getComponent()).getIcon() );
		
		// comment not locked, save?
		if( viewPhotoAlbumDetails.getEpnPhotoComment().isEditable() ) {
			Object[] options = { "Ja, speichern", "Nein, Änderungen verwerfen" };
			int choice = JOptionPane.showOptionDialog( viewPhotoAlbumDetails, "Möchten Sie ihre Änderungen speichern?", "Speichern?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0] );
			
			if( choice == JOptionPane.YES_OPTION ) {
				new SavePhotoCommentActionListener( viewPhotoAlbumDetails ).saveComment();
			} 
			
			viewPhotoAlbumDetails.toggleCommmentEditStatus();
		}
		
		// update preview
		viewPhotoAlbumDetails.populatePhotoArea(photo);
	}

	public void mouseExited( MouseEvent event ) {}
	public void mouseEntered( MouseEvent event ) {}
	public void mousePressed( MouseEvent event ) {}
	public void mouseReleased( MouseEvent event ) {}
}

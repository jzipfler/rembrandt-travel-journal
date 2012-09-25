package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class PhotoAlbumDetailsViewThumbnailMouseListener implements MouseListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private PhotoAlbumModel photoAlbumModel;
	private Photo photo;

	public PhotoAlbumDetailsViewThumbnailMouseListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		photoAlbumModel = viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel();
		viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();
		photo = photoAlbumModel.findPhotoByPath( ((ImageIcon) ((JLabel) event.getComponent()).getIcon()).getDescription() );
	
		// comment not locked, save?
		if( viewPhotoAlbumDetails.getEpnPhotoComment().isEditable() ) {
			Object[] options = { Messages.getString("PhotoAlbumDetailsViewThumbnailMouseListener.0"), Messages.getString("PhotoAlbumDetailsViewThumbnailMouseListener.1") }; //$NON-NLS-1$ //$NON-NLS-2$
			int choice = JOptionPane.showOptionDialog( viewPhotoAlbumDetails, Messages.getString("PhotoAlbumDetailsViewThumbnailMouseListener.2"), Messages.getString("PhotoAlbumDetailsViewThumbnailMouseListener.3"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0] ); //$NON-NLS-1$ //$NON-NLS-2$
			
			if( choice == JOptionPane.YES_OPTION ) {
				new PhotoAlbumDetailsViewSaveCommentActionListener( viewPhotoAlbumDetails ).saveComment();
			} 
			viewPhotoAlbumDetails.toggleCommmentEditStatus();
		}
		// update preview
		viewPhotoAlbumDetails.getParentFrame().getJourneyModel().getPhotoAlbumModel().setCurrentPhoto(photo);
		viewPhotoAlbumDetails.populatePhotoArea();
	}

	// not needed
	@Override
	public void mouseExited   ( MouseEvent event ) {}
	@Override
	public void mouseEntered  ( MouseEvent event ) {}
	@Override
	public void mousePressed  ( MouseEvent event ) {}
	@Override
	public void mouseReleased ( MouseEvent event ) {}
}

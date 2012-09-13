package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class SetCurrentPhotoActionListener implements ActionListener {

	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private boolean forward;
	private LinkedList<Photo> photoAlbum;
	private Photo currentPhoto;
	private Photo photo;

	public SetCurrentPhotoActionListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails, boolean forward ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
		this.forward = forward;
	}	
	
	public void actionPerformed(ActionEvent event) {
		
		photoAlbum = viewPhotoAlbumDetails.getPhotoAlbumModel().getPhotoAlbum();
		currentPhoto = viewPhotoAlbumDetails.getPhotoAlbumModel().getCurrentPhoto();
		
		// comment not locked, save?
		if( viewPhotoAlbumDetails.getEpnPhotoComment().isEditable() ) {
			Object[] options = { "Ja, speichern", "Nein, Änderungen verwerfen" };
			int choice = JOptionPane.showOptionDialog( viewPhotoAlbumDetails, "Möchten Sie ihre Änderungen speichern?", "Speichern?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0] );
			
			if( choice == JOptionPane.YES_OPTION ) {
				new SavePhotoCommentActionListener( viewPhotoAlbumDetails ).saveComment();
			} 
			
			viewPhotoAlbumDetails.toggleCommmentEditStatus();
		}

		if( !photoAlbum.isEmpty() ) {

			if( !forward && currentPhoto.equals( photoAlbum.getFirst() ) ) { // beginning of list?
				// debug
				System.out.println("Listenanfang");
			} else if( forward && currentPhoto.equals( photoAlbum.getLast() ) ) { // end of list?
				// debug
				System.out.println("Listenende");
			} else { 
				int index = photoAlbum.indexOf(currentPhoto);
				
				if( forward ) index++;
				else index--;
				
				photo = photoAlbum.get( index );
				
				viewPhotoAlbumDetails.populatePhotoArea( photo );
				viewPhotoAlbumDetails.getPhotoAlbumModel().setCurrentPhoto( photo );
				
				// debug
				System.out.println( "index:" + index + "size:" + photoAlbum.size() ) ;
			}
		} else {
			// debug
			System.out.println("Liste leer");
		}
	}

}
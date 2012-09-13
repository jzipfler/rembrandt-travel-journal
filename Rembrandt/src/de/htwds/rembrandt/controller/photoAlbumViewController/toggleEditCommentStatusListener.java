package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.controler.contactViewControler.SaveContactDetailsActionListener;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class toggleEditCommentStatusListener implements ActionListener {

    // fields
    private ViewPhotoAlbumDetails viewPhotoAlbum;
    
    // constructor 
    public toggleEditCommentStatusListener(ViewPhotoAlbumDetails viewPhotoAlbum) {
        this.viewPhotoAlbum = viewPhotoAlbum;
    }

    public void actionPerformed(ActionEvent action) {
        viewPhotoAlbum.toggleCommmentEditStatus();
        
        if( viewPhotoAlbum.getBtnPhotoCommentEditToggle().getText().equals( ViewPhotoAlbumDetails.COMMENT_BUTTON_EDIT ) ) {
        	// save
        	new SavePhotoCommentActionListener(viewPhotoAlbum).saveComment();
        }
    }

}

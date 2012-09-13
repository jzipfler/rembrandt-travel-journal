package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwds.rembrandt.view.ViewPhotoAlbumDetails;

/**
 * @author sFey
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
    }

}

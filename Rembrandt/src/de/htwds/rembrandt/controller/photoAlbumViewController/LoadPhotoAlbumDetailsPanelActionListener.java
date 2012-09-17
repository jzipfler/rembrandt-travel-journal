package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class LoadPhotoAlbumDetailsPanelActionListener implements ActionListener {

    private ViewPhotoAlbumDetails viewPhotoAlbum;
	
	public LoadPhotoAlbumDetailsPanelActionListener(ViewMain viewMain) {
        this.viewPhotoAlbum = new ViewPhotoAlbumDetails( viewMain );
    }
    
    public void actionPerformed(ActionEvent event) {
    	loadPhotoAlbum();
    }
    
    public void loadPhotoAlbum() {
    	ViewMain viewMain = viewPhotoAlbum.getParentFrame();
    	
    	viewPhotoAlbum.populate();
    	
    	viewMain.getCurrentContentPanel().removeAll();
        viewMain.getCurrentContentPanel().add(viewPhotoAlbum);
        viewPhotoAlbum.updateUI();    	
    }
}

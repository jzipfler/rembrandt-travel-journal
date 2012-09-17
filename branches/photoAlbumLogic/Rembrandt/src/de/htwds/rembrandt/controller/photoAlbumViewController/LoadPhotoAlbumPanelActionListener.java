package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class LoadPhotoAlbumPanelActionListener implements ActionListener {

    private ViewPhotoAlbumDetails viewPhotoAlbum;
	private Photo photo;
	
	public LoadPhotoAlbumPanelActionListener(ViewMain viewMain) {
        this.viewPhotoAlbum = new ViewPhotoAlbumDetails( viewMain );
    }
    
    public LoadPhotoAlbumPanelActionListener(ViewMain viewMain, Photo photo){
    	this.photo = photo;
    	this.viewPhotoAlbum = new ViewPhotoAlbumDetails( viewMain, photo );
    }
    
    public void actionPerformed(ActionEvent event) {
    	loadPhotoAlbum();
    }
    
    public void loadPhotoAlbum() {
    	ViewMain viewMain = viewPhotoAlbum.getParentFrame();
    	
    	if( photo == null ) viewPhotoAlbum.populate();
    	
    	viewMain.getCurrentContentPanel().removeAll();
        viewMain.getCurrentContentPanel().add(viewPhotoAlbum);
        viewPhotoAlbum.updateUI();    	
    }
}

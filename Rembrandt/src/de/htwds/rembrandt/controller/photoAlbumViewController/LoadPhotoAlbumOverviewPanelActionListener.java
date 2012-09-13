package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumOverview;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class LoadPhotoAlbumOverviewPanelActionListener implements ActionListener {

    private ViewPhotoAlbumOverview viewPhotoAlbum;
    
    public LoadPhotoAlbumOverviewPanelActionListener(ViewMain viewMain) {
        this.viewPhotoAlbum = new ViewPhotoAlbumOverview( viewMain );
    }
    
	public void actionPerformed(ActionEvent event) {
        ViewMain viewMain = viewPhotoAlbum.getParentFrame(); 
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewPhotoAlbum);
		viewPhotoAlbum.updateUI();
    }

}

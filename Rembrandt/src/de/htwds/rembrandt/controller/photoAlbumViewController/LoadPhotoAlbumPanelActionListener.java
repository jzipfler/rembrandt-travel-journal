package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewPhotoAlbumDetails;

public class LoadPhotoAlbumPanelActionListener implements ActionListener {

    private ViewMain viewMain;
    private ViewPhotoAlbumDetails viewPhotoAlbum;
    
    public LoadPhotoAlbumPanelActionListener(ViewMain viewMain){
            this.viewMain = viewMain;
            this.viewPhotoAlbum = new ViewPhotoAlbumDetails();
    }
    
    public void actionPerformed(ActionEvent event) {
            viewMain.getCurrentContentPanel().removeAll();
            viewMain.getCurrentContentPanel().add(viewPhotoAlbum);
            viewPhotoAlbum.updateUI();
    }

}

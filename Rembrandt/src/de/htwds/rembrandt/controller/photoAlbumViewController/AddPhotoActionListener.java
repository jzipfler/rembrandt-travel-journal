package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.htwds.rembrandt.components.ImageFileView;
import de.htwds.rembrandt.components.ImageFilter;
import de.htwds.rembrandt.components.ImagePreview;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.view.photoAlbum.ViewPhotoAlbumDetails;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class AddPhotoActionListener implements ActionListener {
	
	private ViewPhotoAlbumDetails viewPhotoAlbumDetails;
	private LinkedList<Photo> photoAlbum;
	
	public AddPhotoActionListener( ViewPhotoAlbumDetails viewPhotoAlbumDetails ) {
		this.viewPhotoAlbumDetails = viewPhotoAlbumDetails;
	}

	public void actionPerformed(ActionEvent event) {
		
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileFilter( new ImageFilter() );
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileView(new ImageFileView());
		fileChooser.setAccessory(new ImagePreview(fileChooser));

		// process the selection 
		int selection = fileChooser.showDialog(viewPhotoAlbumDetails, "Bild hinzufügen");
		
		if( selection == JFileChooser.APPROVE_OPTION ) {
			
	    	// create icon (i.e. the image)
			String path = fileChooser.getSelectedFile().getPath();
	    	ImageIcon image = new ImageIcon( path );
	    	if( image.getIconHeight() > 180 ) { // resize
	    		image = new ImageIcon( image.getImage().getScaledInstance( -1, 185, Image.SCALE_DEFAULT ) );
	    	} 
	    	
	    	// create thumbail (i.e. smaller version of the icon)
	    	ImageIcon thumbnail = new ImageIcon( image.getImage().getScaledInstance(-1, 50, Image.SCALE_DEFAULT) );
	    	
	    	// determine file name and last modified date
	    	File file = new File( path );
	    	Date fileDate = new Date(file.lastModified());
	    	String fileName = file.getName();			    	
	    	
	    	// create Photo object
			Photo photo = new Photo( image, thumbnail, fileName, fileDate, path, "" );
			photoAlbum = viewPhotoAlbumDetails.getPhotoAlbumModel().getPhotoAlbum();
			
			// photo already in album? 
			if( photoAlbum.contains(photo)  ) {
				JOptionPane.showMessageDialog( viewPhotoAlbumDetails, "Dieses Bild ist bereits in dem Photoalbum enthalten.", "Fehler", JOptionPane.ERROR_MESSAGE);
			} else {
				// add photo to album
				photoAlbum.add( photo );
				
				viewPhotoAlbumDetails.populatePhotoArea(photo);
				viewPhotoAlbumDetails.getPhotoAlbumModel().setCurrentPhoto( photo );
				viewPhotoAlbumDetails.populateThumbnailArea( photoAlbum );
				
				// save
				new PhotoAlbumIOController().save( viewPhotoAlbumDetails.getPhotoAlbumModel() );
			}
		}
	}
}
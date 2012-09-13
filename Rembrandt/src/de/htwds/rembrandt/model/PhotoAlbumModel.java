package de.htwds.rembrandt.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.Icon;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class PhotoAlbumModel  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LinkedList<Photo> photoAlbum;
	private Photo currentPhoto;
	
	public PhotoAlbumModel() {
		this.photoAlbum = new LinkedList<Photo>();
	}
	
	// GETTER
	
	public LinkedList<Photo> getPhotoAlbum() { return photoAlbum; }	
	public Photo getCurrentPhoto() { return currentPhoto; }	
	
	// SETTER
	
	public void setPhotoAlbum( LinkedList<Photo> photoAlbum ) {
		this.photoAlbum = photoAlbum;
	}
	
	public void setCurrentPhoto( Photo photo ) {
		this.currentPhoto = photo;
	}
	
	// FUNCTIONS 
	
	public Photo findPhotoByThumbnail( Icon thumbnail ) {
		ListIterator<Photo> iterator = photoAlbum.listIterator();
	    
		while( iterator.hasNext() ) {
			Photo photo = iterator.next();

			if( photo.getThumbnail().equals( thumbnail ) )
				return photo; // found
		}

		// not found
		return null;
	}
	
	public Photo findPhotoByImage( Icon image ) {
		ListIterator<Photo> iterator = photoAlbum.listIterator();
	    
		while( iterator.hasNext() ) {
			Photo photo = iterator.next();

			if( photo.getImage().equals( image ) )
				return photo; // found
		}

		// not found
		return null;
	}	

}
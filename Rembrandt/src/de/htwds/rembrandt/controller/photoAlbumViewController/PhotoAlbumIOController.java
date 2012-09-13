package de.htwds.rembrandt.controller.photoAlbumViewController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.htwds.rembrandt.model.PhotoAlbumModel;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class PhotoAlbumIOController {

	public void save( PhotoAlbumModel photoAlbum) {
		try {
			FileOutputStream fileDescriptor = new FileOutputStream( "D:\\Eigene Dokumente\\Rembrandt\\photoAlbum.dat" );
			ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileDescriptor );
			objectOutputStream.writeObject(photoAlbum);
			objectOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	public PhotoAlbumModel load() {
		try {
			FileInputStream fileDescriptor = new FileInputStream( "D:\\Eigene Dokumente\\Rembrandt\\photoAlbum.dat" );
			ObjectInputStream objectInputStream = new ObjectInputStream( fileDescriptor );
			PhotoAlbumModel photoAlbum = (PhotoAlbumModel) objectInputStream.readObject();
			objectInputStream.close();
			return photoAlbum;
		} catch( Exception e ) {
			System.err.println( e );
		}
		return null;
	}

}

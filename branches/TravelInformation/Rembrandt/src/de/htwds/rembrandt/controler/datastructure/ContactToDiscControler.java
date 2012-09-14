package de.htwds.rembrandt.controler.datastructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.model.JourneyModel;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler - 2012-09-13 )
 *
 */
public class ContactToDiscControler {
	
	private final String PRIVATE_CONTACTS_FILE_NAME 	= "privateContacts.dat";
	private final String GLOBAL_CONTACTS_FILE_NAME 	= "globalContacts.dat";
	
	private ArrayList<Contact> privateList;
	private ArrayList<Contact> globalList;
	private JourneyModel journeyModel;
	
	public ContactToDiscControler( JourneyModel journeyModel ) {
		privateList = null;
		globalList = null;
		this.journeyModel = journeyModel;
	}
	
	public void loadContactsFromDisc() {
		
		loadPrivateContactFromDisc( null );
		loadGlobalContactFromDisc();
	}
	
	public void loadContactsFromDisc( String folderName ) {
		
		if ( folderName == null )
			folderName = journeyModel.getGeneralInformationModel().getFolderName();
		loadPrivateContactFromDisc( folderName );
		loadGlobalContactFromDisc();
	}
	
	public void loadPrivateContactFromDisc( String journeyFolder ) {
		ObjectInputStream in;
	     try {
	    	 
	    	 in = 	new ObjectInputStream(
		    			new BufferedInputStream(
		    			new FileInputStream( FolderPathController.getPrivateContactFolder( journeyModel.getGeneralInformationModel().getFolderName() )
		    								 + FolderPathController.getFileSeperator() 
		    								 + PRIVATE_CONTACTS_FILE_NAME ) ) );
	    	 
	    	 privateList = ( ArrayList<Contact> ) in.readObject();
	    	 
	    	 in.close();
	    	 
	        } catch (IOException e) {
	        	
	        	privateList = null;
	            e.printStackTrace();
	            //throw new RuntimeException( "Die zu lesende Datei existiert nicht." );
	        } catch (ClassNotFoundException e) {
	        	
	        	privateList = null;
	            System.err.println("Falschen Klassentyp gelesen");
	        } finally {

	        	journeyModel.getContactListModel().setPrivateContactList( privateList );
	        }
	}
	
	public void loadGlobalContactFromDisc() {
		ObjectInputStream in;
	     try {
	    	 in = 	new ObjectInputStream(
	    			new BufferedInputStream(
	    			new FileInputStream( FolderPathController.getGlobalContactFolder()
	    								 + FolderPathController.getFileSeperator() 
	    								 + GLOBAL_CONTACTS_FILE_NAME ) ) );
	    	 
	    	 globalList = ( ArrayList<Contact> ) in.readObject();
	    	 
	    	 in.close();

	        } catch (IOException e) {
	        	
	        	globalList = null;
	            //e.printStackTrace();
	            //throw new RuntimeException( "Die zu lesende Datei existiert nicht." );
	        } catch (ClassNotFoundException e) {
	        	
	        	globalList = null;
	            System.err.println("Falschen Klassentyp gelesen");
	        } finally {

	        	journeyModel.getContactListModel().setGlobalContactList(globalList);
	        }
	}
	
	
	public void writeContactsToDisc() {
		ObjectOutputStream global_out, private_out;
        try {
        	
        	if ( journeyModel.getContactListModel().getGlobalContactList() != null ) {
        	
        		global_out = 	new ObjectOutputStream(
        						new BufferedOutputStream(
        						new FileOutputStream(	FolderPathController.getGlobalContactFolder()
								 						+ FolderPathController.getFileSeperator() 
								 						+ GLOBAL_CONTACTS_FILE_NAME ) ) );
	        
        		global_out.writeObject ( journeyModel.getContactListModel().getGlobalContactList() );
        		global_out.close();
            
        	}
        	
	        	if ( journeyModel.getContactListModel().getPrivateContactList() != null ) {
	             
	        	private_out = 	new ObjectOutputStream(
	        					new BufferedOutputStream(
	        					new FileOutputStream(	FolderPathController.getPrivateContactFolder( journeyModel.getGeneralInformationModel().getFolderName() )
	                   		 							+ FolderPathController.getFileSeperator() 
	                   		 							+ PRIVATE_CONTACTS_FILE_NAME ) ) );
	          
	        	private_out.writeObject ( journeyModel.getContactListModel().getPrivateContactList() );
	        	private_out.close();
            
        	}
               
       } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Kontaktlisten!");
            e.printStackTrace();
       }
	}
	
}

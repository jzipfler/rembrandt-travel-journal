package de.htwds.rembrandt.controler.datastructure;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.model.JourneyModel;

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
		 ObjectInputStream in;
	     try {
	    	 in = 	new ObjectInputStream(
	    			new BufferedInputStream(
	    			new FileInputStream( FolderPathController.getGlobalContactFolder()
	    								 + FolderPathController.getFileSeperator() 
	    								 + GLOBAL_CONTACTS_FILE_NAME ) ) );
	    	 
	    	 globalList = ( ArrayList<Contact> ) in.readObject();
	    	 
	    	 in.close();

	    	 in = 	new ObjectInputStream(
		    			new BufferedInputStream(
		    			new FileInputStream( FolderPathController.getPrivateContactFolder( journeyModel.getTravelInformation().toString() )
		    								 + FolderPathController.getFileSeperator() 
		    								 + PRIVATE_CONTACTS_FILE_NAME ) ) );
	    	 
	    	 privateList = ( ArrayList<Contact> ) in.readObject();
	    	 
	    	 in.close();
	    	 
	        } catch (IOException e) {
	        	
	        	globalList = null;
	        	privateList = null;
	            //e.printStackTrace();
	            //throw new RuntimeException( "Die zu lesende Datei existiert nicht." );
	        } catch (ClassNotFoundException e) {
	        	
	        	globalList = null;
	        	privateList = null;
	            System.err.println("Falschen Klassentyp gelesen");
	        } finally {

	        	journeyModel.getContactListModel().setGlobalContactList(globalList);
	        	journeyModel.getContactListModel().setPrivateContactList(privateList);
	        }
	}
	
	public void writeContactsToDisc() {
		
	}
	
}

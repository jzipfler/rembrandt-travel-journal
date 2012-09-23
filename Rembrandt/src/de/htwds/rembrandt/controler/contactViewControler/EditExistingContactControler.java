package de.htwds.rembrandt.controler.contactViewControler;

import java.util.ArrayList;

import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContactDetails;

public class EditExistingContactControler {

	private ViewContactDetails viewContactDetails;
	private ArrayList<Contact> contactList;
	
	public EditExistingContactControler( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	public void editExistingContact() {
		String firstName = viewContactDetails.getTxtFirstName().getText();
		String lastName = viewContactDetails.getTxtLastName().getText();
		Contact editingContact = new Contact( firstName, lastName );
		
		
	}
}

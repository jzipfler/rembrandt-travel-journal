package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.exception.ContactException;
import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContactDetails;

public class SaveContactDetailsActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	private Contact contact;
	
	public SaveContactDetailsActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	public void createNewContact() throws ContactException {
		contact = new Contact(viewContactDetails.getTxtFirstName()
					.getText(), viewContactDetails.getTxtLastName().getText());
		contact.setBusinessAdress(viewContactDetails.getTextAreaBusinessAdress().getText() );
			
		contact.setPostfach( viewContactDetails.getTxtPostfach().getText() );
		contact.setCity( viewContactDetails.getTxtCity().getText() );
		contact.setStateProvinz( viewContactDetails.getTxtStateProvinz().getText() );
		contact.setCountry( viewContactDetails.getTxtCountry().getText() );
		contact.setHomepage( viewContactDetails.getTxtHomepage().getText() );
		contact.setJob( viewContactDetails.getTxtJob().getText() );
		contact.setCompany( viewContactDetails.getTxtCompany().getText() );
		contact.setDepartment( viewContactDetails.getTxtDepartment().getText() );
		contact.setOffice( viewContactDetails.getTxtOffice().getText() );
		contact.setSpouses( viewContactDetails.getTxtSpouses().getText() );
		contact.setPrivatMail( viewContactDetails.getTxtPrivatMail().getText() );
		contact.setBusinessMail( viewContactDetails.getTxtBusinessMail().getText() );
		contact.setPrivatAdress( viewContactDetails.getTextAreaPrivatAdress().getText() );
		contact.setNotices( viewContactDetails.getTextAreaNotices().getText() );
			
		try {
			contact.setZipPlz( Integer.parseInt( viewContactDetails.getTxtZipPlz().getText() ) );
			contact.setPrivatPhone( Integer.parseInt( viewContactDetails.getTxtPrivatPhone().getText() ) );
			contact.setBusinessPhone( Integer.parseInt( viewContactDetails.getTxtBusinessPhone().getText() ) );
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		createNewContact();
	}

}

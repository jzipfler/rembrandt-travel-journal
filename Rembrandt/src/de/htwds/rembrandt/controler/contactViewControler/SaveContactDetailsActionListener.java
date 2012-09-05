package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.htwds.rembrandt.exception.ContactException;
import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContactDetails;

public class SaveContactDetailsActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	private Contact contact;
	private ArrayList<Contact> contactList;
	
	public SaveContactDetailsActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	private void createNewContact() throws ContactException {
		
		contact = new Contact(	viewContactDetails.getTxtFirstName().getText(), 
								viewContactDetails.getTxtLastName().getText()
								);
		
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
			if ( viewContactDetails.getTxtZipPlz().getText() != null )
				contact.setZipPlz( Integer.parseInt( viewContactDetails.getTxtZipPlz().getText() ) );
			else
				contact.setZipPlz(0);
			if ( viewContactDetails.getTxtPrivatPhone().getText() != null )
				contact.setPrivatPhone( Integer.parseInt( viewContactDetails.getTxtPrivatPhone().getText() ) );
			else
				contact.setPrivatPhone(0);
			if ( viewContactDetails.getTxtBusinessPhone().getText() != null )
				contact.setBusinessPhone( Integer.parseInt( viewContactDetails.getTxtBusinessPhone().getText() ) );
			else
				contact.setBusinessPhone(0);
			
		
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	private void saveContactToList() throws ContactException {
		
		if ( viewContactDetails.getRdbtnPrivateContact().isSelected() ) {
			
			contactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			addContactToList();
			viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(contactList);
		}
		else if ( viewContactDetails.getRdbtnGlobalContact().isSelected() ) {
			
			contactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
			addContactToList();
			viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(contactList);
		}
		else if ( viewContactDetails.getRdbtnGlobalAndLocal().isSelected() ) {
			
			ArrayList<Contact> privateContactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
			ArrayList<Contact> globalContactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
			if ( privateContactList == null )
				privateContactList = new ArrayList<Contact>();
			if ( globalContactList == null )
				globalContactList = new ArrayList<Contact>();
			
			if ( privateContactList.contains(contact) && globalContactList.contains(contact) )
				throw new ContactException( ContactException.ERROR_CONTACT_EXISTS_IN_BOTH_LISTS );
			else if ( privateContactList.contains(contact) && !globalContactList.contains(contact) ) {
				globalContactList.add( contact );
				viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(globalContactList);
				throw new ContactException( ContactException.ERROR_CONTACT_EXISTS_IN_PRIVATE_LIST );
			}
			else if ( !privateContactList.contains(contact) && globalContactList.contains(contact) ) {
				privateContactList.add( contact );
				viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(privateContactList);
				throw new ContactException( ContactException.ERROR_CONTACT_EXISTS_IN_GLOBAL_LIST );
			}
			else {
				;
				privateContactList.add( contact );
				globalContactList.add(contact);
				viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setPrivateContactList(privateContactList);
				viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().setGlobalContactList(globalContactList);
			}
		}
		else
			;
		
	}
	
	private void addContactToList() throws ContactException {
		
		if ( contactList == null )
			contactList = new ArrayList<Contact>();
		
		if ( contactList.contains(contact) )
			throw new ContactException( ContactException.ERROR_CONTACT_ALREADY_EXISTS );
		contactList.add( contact );
	}
	
	protected void saveContactDetails() {
		createNewContact();
		saveContactToList();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		saveContactDetails();
	}

}

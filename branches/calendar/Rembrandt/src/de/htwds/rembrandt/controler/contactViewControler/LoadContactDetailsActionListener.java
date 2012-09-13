package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.htwds.rembrandt.exception.ContactException;
import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContactDetails;
import de.htwds.rembrandt.view.ViewMain;

public class LoadContactDetailsActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	private Contact editingContact;
	
	public LoadContactDetailsActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}	
	
	protected void loadContactDetails(){
		ViewMain viewMain = viewContactDetails.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewContactDetails);
		viewContactDetails.getPnlTabbedContactDetails().setSelectedIndex(0);
		viewMain.getCurrentContentPanel().updateUI();
	}
	
	private void loadContactDetailTextFields() {
		editingContact = new LoadSelectedContactControler(viewContactDetails.getViewContact()).loadSelectedContact();
		if ( editingContact == null )
			return;
		
		viewContactDetails.getTxtFirstName().setText( editingContact.getFirstName() ); 
		viewContactDetails.getTxtLastName().setText( editingContact.getLastName() );

		viewContactDetails.getTextAreaBusinessAdress().setText( editingContact.getBusinessAdress() );	
		viewContactDetails.getTxtPostfach().setText( editingContact.getPostfach() );
		viewContactDetails.getTxtCity().setText( editingContact.getCity() );
		viewContactDetails.getTxtStateProvinz().setText( editingContact.getStateProvinz() );
		viewContactDetails.getTxtCountry().setText(editingContact.getCountry() );
		viewContactDetails.getTxtHomepage().setText( editingContact.getHomepage() );
		viewContactDetails.getTxtJob().setText( editingContact.getJob() );
		viewContactDetails.getTxtCompany().setText(editingContact.getCompany() );
		viewContactDetails.getTxtDepartment().setText(editingContact.getDepartment() );
		viewContactDetails.getTxtOffice().setText(editingContact.getOffice() );
		viewContactDetails.getTxtSpouses().setText(editingContact.getSpouses() );
		viewContactDetails.getTxtPrivatMail().setText(editingContact.getPrivatMail() );
		viewContactDetails.getTxtBusinessMail().setText( editingContact.getBusinessMail() );
		viewContactDetails.getTextAreaPrivatAdress().setText(editingContact.getPrivatAdress() );
		viewContactDetails.getTextAreaNotices().setText( editingContact.getNotices() );
		
		viewContactDetails.getTxtZipPlz().setText( editingContact.getZipPlz() );
		viewContactDetails.getTxtPrivatPhone().setText( editingContact.getPrivatPhone() );
		viewContactDetails.getTxtBusinessPhone().setText( editingContact.getBusinessPhone() );
		
		viewContactDetails.getBtnPicture().setIcon( editingContact.getPicture() );
		viewContactDetails.getBtnPicture().setDisabledIcon( editingContact.getPicture() );
		viewContactDetails.getBtnPicture().setText(null);
		
		viewContactDetails.setAlreadyExistingContact(editingContact);
		
	}
	
	private void loadContactCategoryInformation() {
		
		ArrayList<Contact> privateContactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getPrivateContactList();
		ArrayList<Contact> globalContactList = viewContactDetails.getParentFrame().getJourneyModel().getContactListModel().getGlobalContactList();
		
		if ( privateContactList == null )
			privateContactList = new ArrayList<Contact>();
		if ( globalContactList == null )
			globalContactList = new ArrayList<Contact>();
		
		boolean isInPrivateList = privateContactList.contains(editingContact);
		boolean isInGlobalList = globalContactList.contains(editingContact);
		
		if ( isInPrivateList && isInGlobalList )
			viewContactDetails.getRdbtnGlobalAndLocal().setSelected(true);
		else if ( isInPrivateList && !isInGlobalList ) 
			
			viewContactDetails.getRdbtnPrivateContact().setSelected(true);
		else if ( !isInPrivateList && isInGlobalList )

			viewContactDetails.getRdbtnGlobalContact().setSelected(true);
		else
			;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		loadContactDetailTextFields();
		loadContactCategoryInformation();
		loadContactDetails();
	}

}

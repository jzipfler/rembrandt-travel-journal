package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.exception.ContactException;
import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewContacts;

public class ReturnToContactsActionListener implements ActionListener {

	private ViewContacts viewContacts;
	
	private static final String MSG_NOT_SAVED_YET = 	"Ihre Änderungen wurden noch nicht gespeichert.\n" +
														"Möchten Sie ihre Änderungen Speichern?";
	private static final String MSG_ERROR_TITLE =		"Speichern vergessen";
	
	
	public ReturnToContactsActionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	private int checkIfSaved() {
		
		if ( 	viewContacts.getViewContactDetails().getBtnUnlock().getText() == 
				viewContacts.getViewContactDetails().STD_BUTTON_UNLOCK_LOCK ) {
			
			Object[] options = {	"Ja, speichern",
        						"Nein, Änderungen verwerfen"};
		
			int n = JOptionPane.showOptionDialog(	null,
												MSG_NOT_SAVED_YET,
												MSG_ERROR_TITLE,
												JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null,     		//do not use a custom Icon
												options,  		//the titles of buttons
												options[0]);	//default button title
			
			if ( n == JOptionPane.YES_OPTION ) {
				
				try {
					new SaveContactDetailsActionListener( viewContacts.getViewContactDetails() ).saveContactDetails();
					return JOptionPane.YES_OPTION;				// equals n
				} catch (ContactException contactException) {
					JOptionPane.showMessageDialog(	null,
							contactException.getMessage(),
							ContactException.MSG_ERROR_OCCURED,
							JOptionPane.ERROR_MESSAGE );
					return JOptionPane.ABORT;
				}
			}
			else if ( n == JOptionPane.NO_OPTION )
				return JOptionPane.NO_OPTION;
			else
				return JOptionPane.ABORT;
		}
		return JOptionPane.YES_OPTION;
//		
	}
	

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * TODO: At the moment...the same code is used in if and else!
		 */
		int shouldItBeSaved = checkIfSaved();
		if ( shouldItBeSaved == JOptionPane.YES_OPTION ) {
			new UpdateListControler(viewContacts).updateList();
			new ClearAllDetailTextFieldsControler( viewContacts.getViewContactDetails() ).clearAllTextFields();
			new LoadContactsActionListener(viewContacts).loadContacts();
		}
		else if ( shouldItBeSaved == JOptionPane.NO_OPTION ) {
			new UpdateListControler(viewContacts).updateList();
			new ClearAllDetailTextFieldsControler( viewContacts.getViewContactDetails() ).clearAllTextFields();
			new LoadContactsActionListener(viewContacts).loadContacts();
		}
		else
			; // noop

	}

}

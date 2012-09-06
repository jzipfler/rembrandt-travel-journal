package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.exception.ContactException;
import de.htwds.rembrandt.view.ViewContactDetails;

public class EnableTextFieldsActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	
	public EnableTextFieldsActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	protected void setTextFieldsEnabled( ) {
		if ( !viewContactDetails.isInformationEditable() ) {
			viewContactDetails.setInformationEditable();
			viewContactDetails.getBtnUnlock().setText( viewContactDetails.STD_BUTTON_UNLOCK_LOCK );
		}
	}
	
	private void setTextFieldsNotEnabled( ) {
		if ( viewContactDetails.isInformationEditable() ) {
			viewContactDetails.setInformationEditable();
			viewContactDetails.getBtnUnlock().setText( viewContactDetails.STD_BUTTON_UNLOCK_UNLOCK );
		}
	}
	
	private void changeCurrendEnableOption( ) {
		viewContactDetails.setInformationEditable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if ( viewContactDetails.getBtnUnlock().getText().equals( viewContactDetails.STD_BUTTON_UNLOCK_UNLOCK ) ) {
			
			setTextFieldsEnabled( );
			
		} else if (viewContactDetails.getBtnUnlock().getText().equals( viewContactDetails.STD_BUTTON_UNLOCK_LOCK )) {
			
			try {
				new SaveContactDetailsActionListener(viewContactDetails).saveContactDetails();
				setTextFieldsNotEnabled( );
			} catch (ContactException contactException) {
				
				JOptionPane.showMessageDialog(	null,
												contactException.getMessage(),
												ContactException.MSG_ERROR_OCCURED,
												JOptionPane.ERROR_MESSAGE );
			}
							
		} else {
			/*
			 * Should never happen.
			 */
			changeCurrendEnableOption( );
		}
	}
}

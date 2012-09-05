package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContactDetails;
import de.htwds.rembrandt.view.ViewMain;

public class LoadContactDetailsActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	
	public LoadContactDetailsActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}	
	
	protected void loadContactDetails(){
		ViewMain viewMain = viewContactDetails.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewContactDetails);
		viewMain.getCurrentContentPanel().updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		loadContactDetails();
	}

}

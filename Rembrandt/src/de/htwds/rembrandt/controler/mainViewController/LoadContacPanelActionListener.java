package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewContacts;


public class LoadContacPanelActionListener implements ActionListener {

	private ViewMain viewMain;
	private ViewContacts viewContacts;
	
	public LoadContacPanelActionListener(ViewMain viewMain ) {
		this.viewMain = viewMain;
		this.viewContacts = new ViewContacts();
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		viewMain.getPnlContent().add(viewContacts);
		viewContacts.updateUI();
	}

}

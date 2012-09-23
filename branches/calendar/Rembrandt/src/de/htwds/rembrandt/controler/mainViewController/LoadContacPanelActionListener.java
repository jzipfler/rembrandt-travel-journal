package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewContacts;

public class LoadContacPanelActionListener implements ActionListener {

	private ViewContacts viewContacts;
	
	public LoadContacPanelActionListener(ViewMain viewMain ) {
		
		this.viewContacts = new ViewContacts( viewMain );
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewMain viewMain = viewContacts.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewContacts);
		viewContacts.updateUI();
	}

}

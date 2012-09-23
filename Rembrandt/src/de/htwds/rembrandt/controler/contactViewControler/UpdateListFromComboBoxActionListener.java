package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewContacts;

public class UpdateListFromComboBoxActionListener implements ActionListener {

	private ViewContacts viewContacts;
	
	public UpdateListFromComboBoxActionListener( ViewContacts viewContacts ) {
		this.viewContacts = viewContacts;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new UpdateListControler(viewContacts).updateList();

	}

}

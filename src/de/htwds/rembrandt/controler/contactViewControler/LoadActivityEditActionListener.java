
package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewActivity;



public class LoadActivityEditActionListener implements ActionListener {


	private ViewActivity viewActivity;

	public LoadActivityEditActionListener(ViewActivity viewActivity) {
		this.viewActivity = viewActivity;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		viewActivity.get_saveButton().setVisible(true);
		viewActivity.get_editButton().setVisible(false);
		viewActivity.get_abortButton().setText(Messages.getString("LoadActivityEditActionListener.0")); //$NON-NLS-1$
		viewActivity.get_descriptionField().setEditable(true);
		viewActivity.get_timeField().setEditable(true);
		viewActivity.get_locationField().setEditable(true);
		viewActivity.get_storyArea().setEditable(true);	
	}


}

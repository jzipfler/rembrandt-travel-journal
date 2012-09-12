package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewStart;

public class RemoveSelectedJourneyActionListener implements ActionListener {

	private ViewStart viewStart;
	
	public RemoveSelectedJourneyActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		viewStart.getTableModel().removeRow(row);
	}
	
}

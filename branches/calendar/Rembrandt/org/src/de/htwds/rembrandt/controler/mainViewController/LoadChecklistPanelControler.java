package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewChecklist;
import de.htwds.rembrandt.view.ViewMain;

public class LoadChecklistPanelControler implements ActionListener {

	private ViewChecklist viewChecklist;
	private ViewMain viewMain;
	
	public LoadChecklistPanelControler(ViewMain viewMain ) {
		
		this.viewChecklist = new ViewChecklist( );
		this.viewMain = viewMain;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ViewMain viewMain = viewChecklist.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewChecklist);
		viewChecklist.updateUI();
	}


}

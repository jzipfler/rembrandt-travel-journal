package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.controler.viewChecklistControler.ViewChecklistLoadFromDisc;
import de.htwds.rembrandt.view.ViewChecklist;
import de.htwds.rembrandt.view.ViewMain;

public class LoadChecklistPanelControler implements ActionListener {

	private ViewChecklist viewChecklist;
	private ViewMain viewMain;
	private boolean loaded = false;
	
	public LoadChecklistPanelControler(ViewMain viewMain ) {
		
		this.viewChecklist = new ViewChecklist(viewMain );
		this.viewMain = viewMain;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewMain viewMain = viewChecklist.getParentFrame();
		viewMain.getCurrentContentPanel().removeAll();
		viewMain.getCurrentContentPanel().add(viewChecklist);
		viewChecklist.updateUI();
		
		if(!loaded)
		{
			ViewChecklistLoadFromDisc discloader = new ViewChecklistLoadFromDisc(viewMain.getJourneyModel());
			discloader.load();
			loaded = true;
			viewChecklist.refreshTables();
		}
	}


}

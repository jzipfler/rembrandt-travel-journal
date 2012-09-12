package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.view.ViewMain;

public class SaveAllToDiscActionListener implements ActionListener {

	private ViewMain viewMain;
	
	public SaveAllToDiscActionListener( ViewMain viewMain ) {
		this.viewMain = viewMain;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("SAVE ALL TO DISC");
		try {
			new GeneralInformationFromDiskControler().save( viewMain.getJourneyModel().getGeneralInformationArray() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.ContactToDiscControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.travelview.SaveTravelInformationToDiskControler;
import de.htwds.rembrandt.view.ViewMain;

/**
 * 
 * @author Jan Zipfler
 * @version ( Daniel Horbach - 2012-09-14 )
 *
 */
public class SaveAllToDiscActionListener implements ActionListener {

	private ViewMain viewMain;
	
	public SaveAllToDiscActionListener( ViewMain viewMain ) {
		this.viewMain = viewMain;
	}
	
	public void saveAllToDisc() {
		
		System.out.println("SAVE ALL TO DISC");
		try {
			new GeneralInformationFromDiskControler().save( viewMain.getJourneyModel().getGeneralInformationArray() );
			new ContactToDiscControler( viewMain.getJourneyModel() ).writeContactsToDisc();
			new SaveTravelInformationToDiskControler(viewMain).store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new LoadStartViewActionListener( viewMain.getViewWrapper() ).loadStartView();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		saveAllToDisc();
	}
}
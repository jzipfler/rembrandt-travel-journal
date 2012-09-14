package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.controler.datastructure.ContactToDiscControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.travelview.SaveTravelInformationToDiskControler;
import de.htwds.rembrandt.exception.TravelToDiscException;
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
	
	/**
	 * Save all objects from an open journey to the disc.
	 */
	public void saveAllToDisc() {
		
//		System.out.println("SAVE ALL TO DISC");
		try {
			new GeneralInformationFromDiskControler().save( viewMain.getJourneyModel().getGeneralInformationArray() );
			new ContactToDiscControler( viewMain.getJourneyModel() ).writeContactsToDisc();
			new SaveTravelInformationToDiskControler(viewMain).store();
		} catch ( TravelToDiscException discException ) {

			JOptionPane.showMessageDialog(viewMain, 
					discException.getMessage() 
					+ "\n" 
					+TravelToDiscException.ERROR_LOAD_SELECTED_JOURNEY, 
					TravelToDiscException.MSG_ERROR_DURING_SAVE_OR_LOAD, 
					JOptionPane.ERROR_MESSAGE );
		}
		
		new LoadStartViewActionListener( viewMain.getViewWrapper() ).loadStartView();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		saveAllToDisc();
	}
}
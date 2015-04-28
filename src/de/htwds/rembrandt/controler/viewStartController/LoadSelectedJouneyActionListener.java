package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.controler.datastructure.ContactToDiscControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationFromDiskControler;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumIOController;
import de.htwds.rembrandt.exception.TravelInformationException;
import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler - 2012-09-14 )
 *
 */
public class LoadSelectedJouneyActionListener implements ActionListener {

	private ViewWrapperWindow viewWrapper;
	private ViewStart viewStart;
	
	public LoadSelectedJouneyActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
		this.viewWrapper = viewStart.getViewWrapper();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		ViewMain viewMain = new ViewMain( viewWrapper, new JourneyModel() );
		
		try {
			
			loadSelectedTravelInformationObject (viewMain);
			loadSelectedGeneralInformationObject( viewMain);
		
		
			viewMain.getJourneyModel().setGeneralInformationModelArray( new GeneralInformationFromDiskControler().load() );
			new ContactToDiscControler(viewMain.getJourneyModel()).loadContactsFromDisc( getJourneyName() );
			// photoAlbum
			viewMain.getJourneyModel().setPhotoAlbumModel( new PhotoAlbumIOController( viewMain.getJourneyModel() ).load() );
			
		} catch ( TravelToDiscException discException ) {
			
			JOptionPane.showMessageDialog(viewStart, 
					discException.getMessage() 
					+ Messages.getString("LoadSelectedJouneyActionListener.0")  //$NON-NLS-1$
					+TravelToDiscException.ERROR_LOAD_SELECTED_JOURNEY, 
					TravelToDiscException.MSG_ERROR_DURING_SAVE_OR_LOAD, 
					JOptionPane.ERROR_MESSAGE );
		}
		
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( viewMain.getViewMain() );
		viewWrapper.getPanel().updateUI();
		
	}
	
	/*
	 * Cause of the TravelInformation Object is always loadet at this time...just create a GeneralInformation object from this...
	 */
	private void loadSelectedGeneralInformationObject( ViewMain viewMain ) {
		
		viewMain.getJourneyModel().setGeneralInformationModel( viewMain.getJourneyModel().getTravelInformation().createGeneralInformation() );

//		GeneralInformationModel tmpModel = new GeneralInformationModel(null, null, null, null);
//		tmpModel.setCountryAndArrivalFromFolderName(journeyName);
//		viewMain.getJourneyModel().setGeneralInformationModel(tmpModel);
	}
	
	private void loadSelectedTravelInformationObject( ViewMain viewMain) throws TravelInformationException {
		viewMain.getJourneyModel().setTravelInformation(new LoadTravelInformationFromDiskControler(getJourneyName()).getReadData());
	}
	
	private String getJourneyName(){
		int column = viewStart.getTblJourneyOverview().getSelectedColumn();
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		return (String) viewStart.getTblJourneyOverview().getValueAt(row, column);
	}

}

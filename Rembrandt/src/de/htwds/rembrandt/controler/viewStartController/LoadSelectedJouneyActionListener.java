package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.ContactToDiscControler;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationFromDiskControler;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.view.ViewMain;
import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author Jan Zipfler
 * @version ( Daniel Horbach - 2012-09-14 )
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
		// TODO Auto-generated method stub

		ViewMain viewMain = new ViewMain( viewWrapper, new JourneyModel() );
		
		if ( viewStart.getTblJourneyOverview().getSelectedRow() >= 0 )
			loadSelectedGeneralInformationObject( viewMain);
			loadSelectedTravelInformationObject (viewMain);
		
		try {
			viewMain.getJourneyModel().setGeneralInformationModelArray( new GeneralInformationFromDiskControler().load() );
			new ContactToDiscControler(viewMain.getJourneyModel()).loadContactsFromDisc();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( viewMain.getViewMain() );
		viewWrapper.getPanel().updateUI();
		
	}
	
	private void loadSelectedGeneralInformationObject( ViewMain viewMain ) {
		
		int column = viewStart.getTblJourneyOverview().getSelectedColumn();
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		String journeyName = (String) viewStart.getTblJourneyOverview().getValueAt(row, column);
		
		GeneralInformationModel tmpModel = new GeneralInformationModel(null, null, null, null);
		tmpModel.setCountryAndArrivalFromFolderName(journeyName);
		viewMain.getJourneyModel().setGeneralInformationModel(tmpModel);
	}
	
	private void loadSelectedTravelInformationObject( ViewMain viewMain){
		viewMain.getJourneyModel().setTravelInformation(new LoadTravelInformationFromDiskControler(getJourneyName()).getReadData());
	}
	
	private String getJourneyName(){
		int column = viewStart.getTblJourneyOverview().getSelectedColumn();
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		return (String) viewStart.getTblJourneyOverview().getValueAt(row, column);
	}

}

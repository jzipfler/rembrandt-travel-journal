package de.htwds.rembrandt.controler.viewStartController;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler - 2012-09-13 )
 *
 */
public class TableOverviewListSelectionListener implements
		ListSelectionListener {

	private ViewStart viewStart;
	
	public TableOverviewListSelectionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		// TODO: work on this....
		int column = viewStart.getTblJourneyOverview().getSelectedColumn();
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		
		/*
		 * If cell is removed, the selected row is equal -1.
		 * So set all components to visible = false if row < 0.
		 */
		if ( row >= 0 )	{
			
//			viewStart.getTxtTarget().setText( (String) viewStart.getTblJourneyOverview().getValueAt(row, column) );
			/*
			 * If row > 0 then array can not be null.
			 */
			fillInfoAboutTravelPanel( (String) viewStart.getTblJourneyOverview().getValueAt(row, column) );
			viewStart.getInfoAboutTravelPane().setVisible(true);
			viewStart.getBtnShowJourney().setEnabled(true);
			viewStart.getBtnRemoveJourney().setEnabled(true);
		} else {
			viewStart.getInfoAboutTravelPane().setVisible(false);
			viewStart.getBtnShowJourney().setEnabled(false);
			viewStart.getBtnRemoveJourney().setEnabled(false);
		}
	}
	
	private void fillInfoAboutTravelPanel( String folderName ) {
		
		GeneralInformationModel searchedModel = null;
		for (GeneralInformationModel generalInformationModel : viewStart.getGeneralInformationArray()) {
			if ( generalInformationModel.getFolderName().equals(folderName) )
				searchedModel = generalInformationModel;
		} 
		if ( searchedModel == null )
			return;
		viewStart.getTxtCountry().setText( searchedModel.getCountry() );
		viewStart.getTxtTarget().setText( searchedModel.getCity() );
		viewStart.getTxtDeparture().setText( searchedModel.getDateArrival() );
		viewStart.getTxtJounreyEnd().setText( searchedModel.getDateDeparture() );
	}

}

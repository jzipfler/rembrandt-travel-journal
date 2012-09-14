package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-14 )
 *
 */
public class LoadStartViewActionListener implements ActionListener {

	private ViewWrapperWindow viewWrapper;
	private ViewStart viewStart;
	
	public LoadStartViewActionListener( ViewWrapperWindow viewWrapper ) {
		this.viewWrapper = viewWrapper;
		viewStart = new ViewStart(viewWrapper);
	}
	
	public void loadStartView() {
		
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( viewStart.getViewStart() );
		loadTableItems();
		viewWrapper.getPanel().updateUI();
	}
	
	private void loadTableItems() {

		try {
			viewStart.setGeneralInformationArray( new GeneralInformationFromDiskControler().load() );
//			System.out.println( "Lade Start View, Ist Array null?: " + ( viewStart.getGeneralInformationArray() == null ) );
//			System.out.println( "Lade Start View, Array Länge: " + viewStart.getGeneralInformationArray().length );
//			for (GeneralInformationModel generalInformationModel : viewStart.getGeneralInformationArray() ) {
//				System.out.println( generalInformationModel == null );
//				System.out.println(generalInformationModel);
//			}
			if ( viewStart.getGeneralInformationArray() == null )
				throw new TravelToDiscException( TravelToDiscException.ERROR_LOAD_GENERAL_INFO_FOR_START_VIEW );
			for (GeneralInformationModel generalInformationModel : viewStart.getGeneralInformationArray() ) {
				if ( generalInformationModel != null )
					viewStart.getTableModel().addRow( new String[] { generalInformationModel.getFolderName() } );
			}
		} catch ( TravelToDiscException discException) {

			JOptionPane.showMessageDialog(viewStart, 
					discException.getMessage(),
					TravelToDiscException.MSG_ERROR_DURING_SAVE_OR_LOAD, 
					JOptionPane.ERROR_MESSAGE );
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		loadStartView();
	}

}

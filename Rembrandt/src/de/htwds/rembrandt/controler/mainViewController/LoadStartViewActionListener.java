package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-13 )
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
			GeneralInformationModel[] generalInformationArray = new GeneralInformationFromDiskControler().load();
			System.out.println( "Lade Start View, Ist Array null?: " + ( generalInformationArray == null ) );
			System.out.println( "Lade Start View, Array Länge: " + generalInformationArray.length );
			for (GeneralInformationModel generalInformationModel : generalInformationArray) {
				System.out.println( generalInformationModel == null );
				System.out.println(generalInformationModel);
			}
			if ( generalInformationArray == null )
				throw new RuntimeException("Laden der Startview: RückgabeArray ist NULL");
			for (GeneralInformationModel generalInformationModel : generalInformationArray) {
				if ( generalInformationModel != null )
					viewStart.getTableModel().addRow( new String[] { generalInformationModel.getFolderName() } );
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		loadStartView();
	}

}
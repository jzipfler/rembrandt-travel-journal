package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.exception.TravelToDiscException;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;

/**
 * 
 * @author Jan Zipfler & Daniel
 * @version ( Jan Zipfler - 2012-09-16 )
 *
 */
public class RemoveSelectedJourneyActionListener implements ActionListener {

	private ViewStart viewStart;
	private GeneralInformationModel[] oldGeneralInformationArray;
	private GeneralInformationModel[] newGeneralInformationArray = null;
	private int itemPosition;
	
	public RemoveSelectedJourneyActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int column 	= viewStart.getTblJourneyOverview().getSelectedColumn();
		int row 	= viewStart.getTblJourneyOverview().getSelectedRow();
		
		String folderName = (String) viewStart.getTblJourneyOverview().getValueAt( row, column );
		
		oldGeneralInformationArray = viewStart.getGeneralInformationArray( );
		
		
		if ( oldGeneralInformationArray.length == 1 )
			
			removeItemAndArray();	
		else {
			removeItemAndReplaceArray( folderName );
		
		}
		
		try {
			new CheckExistingDataStructureControler().checkExistingDataStructure();
			new GeneralInformationFromDiskControler().save( newGeneralInformationArray );
			viewStart.setGeneralInformationArray( newGeneralInformationArray );
			viewStart.getTableModel().removeRow(row);
		} catch ( TravelToDiscException discException ) {
			
			discException.printStackTrace();
			
			JOptionPane.showMessageDialog(viewStart, 
					discException.getMessage() 
					+ TravelToDiscException.NEW_LINE_HELPER_STRING 
					+ TravelToDiscException.ERROR_SAVE_GENERAL_INFORMATION, 
					TravelToDiscException.MSG_ERROR_DURING_SAVE_OR_LOAD, 
					JOptionPane.ERROR_MESSAGE );
			
			// If there was a failure while deleting the object, check if the folder was renamed and undo it.
			if ( new File( FolderPathController.getMainFolder() 
							+ FolderPathController.getFileSeperator() 
							+ oldGeneralInformationArray[ itemPosition ].getFolderName() + "_old").exists() 
				)
				
				new File( FolderPathController.getMainFolder() 
						+ FolderPathController.getFileSeperator() 
						+ oldGeneralInformationArray[ itemPosition ].getFolderName() + "_old" ).renameTo( new File( 
								FolderPathController.getMainFolder() 
								+ FolderPathController.getFileSeperator() 
								+ oldGeneralInformationArray[ itemPosition ].getFolderName() ) );
		}
	}
	
	private void removeItemAndArray() {

		itemPosition = 0;
		new File( FolderPathController.getMainFolder() 
				+ FolderPathController.getFileSeperator() 
				+ oldGeneralInformationArray[ itemPosition ].getFolderName() ).renameTo( new File( 
						FolderPathController.getMainFolder() 
						+ FolderPathController.getFileSeperator() 
						+ oldGeneralInformationArray[ itemPosition ].getFolderName() + "_old" ) );
		
		new File( FolderPathController.getGeneralInformationFolder() ).delete();
//		viewStart.setGeneralInformationArray( newGeneralInformationArray );
	}
	
	private void removeItemAndReplaceArray( String folderName ) {
		
		boolean gefunden = false;
		newGeneralInformationArray = new GeneralInformationModel[ ( oldGeneralInformationArray.length - 1 ) ];
		
		for (int i = 0; i < oldGeneralInformationArray.length; i++) {
			
			if (!gefunden)
				if (oldGeneralInformationArray[i].getFolderName().equals( folderName ) ) {
					gefunden = true;
					itemPosition = i;
					new File( FolderPathController.getMainFolder() 
							+ FolderPathController.getFileSeperator() 
							+ oldGeneralInformationArray[ itemPosition ].getFolderName() ).renameTo( new File( 
									FolderPathController.getMainFolder() 
									+ FolderPathController.getFileSeperator() 
									+ oldGeneralInformationArray[ itemPosition ].getFolderName() + "_old" ) );
				} else
					newGeneralInformationArray[i] = oldGeneralInformationArray[i];
			else
				newGeneralInformationArray[i-1] = oldGeneralInformationArray[i];
		}
	}
}

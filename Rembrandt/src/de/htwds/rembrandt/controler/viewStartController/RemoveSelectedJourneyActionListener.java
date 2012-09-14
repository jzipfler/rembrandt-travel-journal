package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.controler.datastructure.GeneralInformationFromDiskControler;
import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;

public class RemoveSelectedJourneyActionListener implements ActionListener {

	private ViewStart viewStart;
	
	public RemoveSelectedJourneyActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int column = viewStart.getTblJourneyOverview().getSelectedColumn();
		int row = viewStart.getTblJourneyOverview().getSelectedRow();
		
		String folderName = (String) viewStart.getTblJourneyOverview().getValueAt(row, column);
		
		GeneralInformationModel[] oldGeneralInformationArray = viewStart.getGeneralInformationArray();
		boolean gefunden = false;
		
		if ( oldGeneralInformationArray.length == 1 ) {
			
			System.out.println("IF-Anweisung: array==1");
			viewStart.setGeneralInformationArray(null);
			new File( FolderPathController.getMainFolder() 
					+ FolderPathController.getFileSeperator() 
					+ oldGeneralInformationArray[0].getFolderName() ).renameTo( new File( 
							FolderPathController.getMainFolder() 
							+ FolderPathController.getFileSeperator() 
							+ oldGeneralInformationArray[0].getFolderName() + "_old" ) );
			new File( FolderPathController.getGeneralInformationFolder() ).delete();
			viewStart.getTableModel().removeRow(row);
			viewStart.setGeneralInformationArray(null);
			return;
		}
		
		GeneralInformationModel[] newGeneralInformationArray = new GeneralInformationModel[ ( oldGeneralInformationArray.length - 1 ) ];
		
		for (int i = 0; i < oldGeneralInformationArray.length; i++) {
			
			if (!gefunden)
				
				if (oldGeneralInformationArray[i].getFolderName().equals( folderName)) {
					gefunden = true;
					new File( FolderPathController.getMainFolder() 
							+ FolderPathController.getFileSeperator() 
							+ oldGeneralInformationArray[i].getFolderName() ).renameTo( new File( 
									FolderPathController.getMainFolder() 
									+ FolderPathController.getFileSeperator() 
									+ oldGeneralInformationArray[i].getFolderName() + "_old" ) );
				} else
					newGeneralInformationArray[i] = oldGeneralInformationArray[i];
			else
				newGeneralInformationArray[i-1] = oldGeneralInformationArray[i];
		}
		
		viewStart.setGeneralInformationArray(newGeneralInformationArray);
		try {
			new GeneralInformationFromDiskControler().save(newGeneralInformationArray);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println("Nach for-Schleife");
		viewStart.getTableModel().removeRow(row);
	}
	
}

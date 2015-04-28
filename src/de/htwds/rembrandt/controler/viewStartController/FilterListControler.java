package de.htwds.rembrandt.controler.viewStartController;

import java.util.ArrayList;

import de.htwds.rembrandt.model.GeneralInformationModel;
import de.htwds.rembrandt.view.ViewStart;

public class FilterListControler {
	
	private ViewStart viewStart;
	private GeneralInformationModel[] filtered;
	
	public FilterListControler(ViewStart viewStart){
		this.viewStart = viewStart;
		filtered = filter(viewStart.getGeneralInformationArray());
		loadTableItems();
	}
	
	private GeneralInformationModel[] filter(GeneralInformationModel[] actual){
		ArrayList<GeneralInformationModel> list = new ArrayList<GeneralInformationModel>();
		for(int i=0; i < actual.length;i++){
			if(actual[i].getFolderName().contains(getFilter()) || getFilter().length() < 1)
				list.add(actual[i]);
		}
		
		if (!list.isEmpty()) {
			return list.toArray(new GeneralInformationModel[list.size()]);
		} else {
			return null;
		}
	}
	
	private String getFilter(){
		return viewStart.getTxtFilter().getText();
	}
	
	
	private void loadTableItems() {
//		for(int i=0; i < viewStart.getTableModel().getRowCount(); i++){
//			System.out.println(i + ".Reihe: " + viewStart.getTableModel().getValueAt(i, 0));
//			viewStart.getTableModel().removeRow(i);
//		}
		while(viewStart.getTableModel().getRowCount() > 0){
			viewStart.getTableModel().removeRow(0);
		}
		if ( filtered == null )
			viewStart.getTableModel().addRow( new String[] { Messages.getString("FilterListControler.0") } ); //$NON-NLS-1$
		else {
			for (GeneralInformationModel generalInformationModel : filtered ) {
				if ( generalInformationModel != null ){
					viewStart.getTableModel().addRow( new String[] { generalInformationModel.getFolderName() } );
				}
			}
		}
	}
	
	
}

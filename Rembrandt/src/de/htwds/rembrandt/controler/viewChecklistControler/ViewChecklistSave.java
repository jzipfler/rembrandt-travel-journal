package de.htwds.rembrandt.controler.viewChecklistControler;

import de.htwds.rembrandt.model.CheckList;
import de.htwds.rembrandt.model.JourneyModel;

public class ViewChecklistSave {

	private JourneyModel info = null;
	
	public ViewChecklistSave(JourneyModel info)
	{
			this.info = info;
	}

	public void save(CheckList bag, CheckList check)
	{
		info.getCheckListInformationModel().setBagList(bag);
		info.getCheckListInformationModel().setCheckList(check);
	}

}

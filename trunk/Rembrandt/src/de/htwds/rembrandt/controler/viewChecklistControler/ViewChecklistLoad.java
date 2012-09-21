package de.htwds.rembrandt.controler.viewChecklistControler;

import de.htwds.rembrandt.model.CheckList;
import de.htwds.rembrandt.model.JourneyModel;

public class ViewChecklistLoad {

	private JourneyModel info = null;
	
	public ViewChecklistLoad(JourneyModel info)
	{
		this.info = info;
	}
	
	public void load(CheckList bag, CheckList check)
	{
		bag = info.getCheckListInformationModel().getBagList();
		check = info.getCheckListInformationModel().getCheckList();
	}
	
	public CheckList loadChecklistBag()
	{
		return info.getCheckListInformationModel().getBagList();
	}
	
	public CheckList loadChecklistCheck()
	{
		return info.getCheckListInformationModel().getCheckList();
	}

}

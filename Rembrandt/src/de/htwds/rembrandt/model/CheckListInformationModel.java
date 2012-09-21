package de.htwds.rembrandt.model;

public class CheckListInformationModel {

	CheckList listBag = null;
	CheckList listCheck = null;
	
	public CheckListInformationModel()
	{
	
	}
	
	public CheckList getBagList()
	{
		return listBag;
	}
	
	public CheckList getCheckList()
	{
		return listCheck;
	}
	
	public void setBagList(CheckList listBag)
	{
		this.listBag = listBag;
	}
	
	public void setCheckList(CheckList listCheck)
	{
		this.listCheck = listCheck;
	}
}

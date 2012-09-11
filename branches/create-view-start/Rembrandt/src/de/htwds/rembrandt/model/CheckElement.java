package de.htwds.rembrandt.model;

public class CheckElement 
{
	CheckElement next;
	String description;
	boolean checked;
	int amount;
	
	public CheckElement(String description, int amount)
	{
		checked = false;
		next = null;
		this.amount = amount;
		this.description = description;
	}
	
	public void check()
	{
		if(!checked)
		{
			checked = true;
		}
		else
		{
			checked = false;
		}
	}
}

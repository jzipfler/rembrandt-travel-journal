package de.htwds.rembrandt.model;


public class CheckElement 
{
	private CheckElement next;
	private String description;
	private boolean checked;
	private int amount;
	
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
	
	public int getAmount()
	{
		return amount;
	}
	
	public boolean getChecked()
	{
		return checked;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public CheckElement getNext()
	{
		return next;
	}
	
	public void setNext(CheckElement element)
	{
		next = element;
	}
	
	
	
}

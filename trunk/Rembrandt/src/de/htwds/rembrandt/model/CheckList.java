package de.htwds.rembrandt.model;


public class CheckList 
{
	private CheckElement root;
	private int elementCounter;
	
	public CheckList()
	{
		root = null;
		elementCounter = 0;
	}
	
	public void addLast(CheckElement element)
	{
		if(elementCounter == 0)
		{
			root = element;
		}
		else
		{
			CheckElement actElement = root;
			while(actElement.getNext() != null)
			{
				actElement = actElement.getNext();
			}
			actElement.setNext(element);
		}
		elementCounter++;
	}
	
	public void addLast(String description, int amount)
	{
		CheckElement element = new CheckElement(description, amount); 
		if(elementCounter == 0)
		{
			root = element;
		}
		else
		{
			CheckElement actElement = root;
			while(actElement.getNext() != null)
			{
				actElement = actElement.getNext();
			}
			actElement.setNext(element);
		}
		elementCounter++;
	}
	
	public void deleteElement(int index)
	{
		if(index == 0)
		{
			root = root.getNext();
		}
		else
		{
			CheckElement actElement = root;
			for(int i = 1; i < index; i++)
			{
				actElement = actElement.getNext();
			}
			actElement.setNext(actElement.getNext().getNext());
		}
		elementCounter--;
	}
	
	public void checkElement(int index)
	{
		if(index == 0)
		{
			root.check();
		}
		else
		{
			CheckElement actElement = root;
			for(int i = 0; i < index; i++)
			{
				actElement = actElement.getNext();
			}
			actElement.check();
		}
	}
	
	public int getElementNumber()
	{
		return this.elementCounter;
	}
	
	public CheckElement getRoot()
	{
		return root;
	}
}

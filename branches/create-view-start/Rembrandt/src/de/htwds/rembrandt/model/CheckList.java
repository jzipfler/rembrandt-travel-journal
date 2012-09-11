package de.htwds.rembrandt.model;

public class CheckList 
{
	CheckElement root;
	int elementCounter;
	
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
			while(actElement.next != null)
			{
				actElement = actElement.next;
			}
			actElement.next = element;
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
			while(actElement.next != null)
			{
				actElement = actElement.next;
			}
			actElement.next = element;
		}
		elementCounter++;
	}
	
	public void deleteElement(int index)
	{
		if(index == 0)
		{
			root = root.next;
		}
		else
		{
			CheckElement actElement = root;
			for(int i = 1; i < index; i++)
			{
				actElement = actElement.next;
			}
			actElement.next = actElement.next.next;
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
				actElement = actElement.next;
			}
			actElement.check();
		}
	}
}

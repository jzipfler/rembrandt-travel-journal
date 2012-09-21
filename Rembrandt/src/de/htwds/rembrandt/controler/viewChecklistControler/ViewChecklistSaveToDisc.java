package de.htwds.rembrandt.controler.viewChecklistControler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.htwds.rembrandt.model.CheckElement;
import de.htwds.rembrandt.model.CheckList;
import de.htwds.rembrandt.model.CheckListInformationModel;
import de.htwds.rembrandt.model.JourneyModel;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;

public class ViewChecklistSaveToDisc {

	private CheckList bag;
	private CheckList check;
	private String journeyname;
	private String[] bagArray;
	private String[] checkArray;
	
	public ViewChecklistSaveToDisc(JourneyModel model)
	{
		this.bag = model.getCheckListInformationModel().getBagList();
		this.check = model.getCheckListInformationModel().getCheckList();
		journeyname = model.getTravelInformation().getCountry() + "_" + model.getTravelInformation().getDateArrival();
	}
	
	public void save()
	{
		if(bag != null && bag.getElementNumber()!= 0)
		{
			fillBagArray();
			saveBag();
		}
		else
		{
			clearBagFile();
		}
		if(check != null && check.getElementNumber()!= 0)
		{
			fillCheckArray();
			saveCheck();
		}
		else
		{
			clearCheckFile();
		}
	}
	
	private void clearCheckFile() {
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistCheck.dat";
		File file = new File(datei);
		FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	private void clearBagFile() {
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistBag.dat";
		File file = new File(datei);
		FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	private void saveBag()
	{
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistBag.dat";
		File file = new File(datei);
		FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            for(String zeile : bagArray)
            {
            	bw.write(zeile + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        	
	}
	
	private void saveCheck()
	{
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistCheck.dat";
		File file = new File(datei);
		FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        	fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            for(String zeile : checkArray)
            {
            	bw.write(zeile + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	private void fillBagArray()
	{
		CheckElement actele;
		int i = 0;
		bagArray = new String[bag.getElementNumber()];
		actele = bag.getRoot();
		bagArray[i] = actele.getDescription() + ";" + actele.getAmount() + ";" + actele.getChecked();
		while(actele.getNext() != null)
		{
			i++;
			actele = actele.getNext();
			bagArray[i] = actele.getDescription() + ";" + actele.getAmount() + ";" + actele.getChecked();
		}
	}
	
	private void fillCheckArray()
	{
		CheckElement actele;
		int i = 0;
		checkArray = new String[check.getElementNumber()];
		actele = check.getRoot();
		checkArray[i] = actele.getDescription() + ";" + actele.getAmount() + ";" + actele.getChecked();
		while(actele.getNext() != null)
		{
			i++;
			actele = actele.getNext();
			checkArray[i] = actele.getDescription() + ";" + actele.getAmount() + ";" + actele.getChecked();
		}
	}
}

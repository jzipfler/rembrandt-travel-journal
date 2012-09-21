package de.htwds.rembrandt.controler.viewChecklistControler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.CheckList;
import de.htwds.rembrandt.model.JourneyModel;

public class ViewChecklistLoadFromDisc {
	
	private JourneyModel model;
	private CheckList bag;
	private CheckList check;
	private String journeyname;
	
	public ViewChecklistLoadFromDisc(JourneyModel model)
	{
		this.model = model;
		journeyname = model.getTravelInformation().getCountry() + "_" + model.getTravelInformation().getDateArrival();
	}

	public void load()
	{
		fillChecklistBag();
		fillChecklistCheck();
		fillJourneyModel();
	}
	
	private void fillChecklistBag()
	{
		bag = new CheckList();
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistBag.dat";
		File file = new File(datei);
		FileReader fw = null;
        BufferedReader bw = null;
        try {
        	fw = new FileReader(file);
            bw = new BufferedReader(fw);
            String zeile;
            while((zeile = bw.readLine()) != null)
            {
            	String[] zeilenele = zeile.split(";");
            	if(zeilenele[2].equals("true"))
            	{
            		bag.addLast(zeilenele[0], Integer.parseInt(zeilenele[1]), true);
            	}
            	else
            	{
            		bag.addLast(zeilenele[0], Integer.parseInt(zeilenele[1]), false);
            	}
            	
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
	
	private void fillChecklistCheck()
	{
		check = new CheckList();
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + "ChecklistCheck.dat";
		File file = new File(datei);
		FileReader fw = null;
        BufferedReader bw = null;
        try {
        	fw = new FileReader(file);
            bw = new BufferedReader(fw);
            String zeile;
            while((zeile = bw.readLine()) != null)
            {
            	String[] zeilenele = zeile.split(";");
            	if(zeilenele[2].equals("true"))
            	{
            		check.addLast(zeilenele[0], Integer.parseInt(zeilenele[1]), true);
            	}
            	else
            	{
            		check.addLast(zeilenele[0], Integer.parseInt(zeilenele[1]), false);
            	}
            	
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
	
	private void fillJourneyModel()
	{
		model.getCheckListInformationModel().setBagList(bag);
		model.getCheckListInformationModel().setCheckList(check);
	}
}

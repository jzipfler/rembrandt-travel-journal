package de.htwds.rembrandt.controler.viewChecklistControler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		journeyname = model.getTravelInformation().getCountry() + Messages.getString("ViewChecklistLoadFromDisc.0") + model.getTravelInformation().getDateArrival(); //$NON-NLS-1$
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
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + Messages.getString("ViewChecklistLoadFromDisc.1"); //$NON-NLS-1$
		File file = new File(datei);
		FileReader fw = null;
        BufferedReader bw = null;
        try {
        	fw = new FileReader(file);
            bw = new BufferedReader(fw);
            String zeile;
            while((zeile = bw.readLine()) != null)
            {
            	String[] zeilenele = zeile.split(Messages.getString("ViewChecklistLoadFromDisc.2")); //$NON-NLS-1$
            	if(zeilenele[2].equals(Messages.getString("ViewChecklistLoadFromDisc.3"))) //$NON-NLS-1$
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
		String datei = FolderPathController.getCecklistsFolder(journeyname) + FolderPathController.getFileSeperator() + Messages.getString("ViewChecklistLoadFromDisc.4"); //$NON-NLS-1$
		File file = new File(datei);
		FileReader fw = null;
        BufferedReader bw = null;
        try {
        	fw = new FileReader(file);
            bw = new BufferedReader(fw);
            String zeile;
            while((zeile = bw.readLine()) != null)
            {
            	String[] zeilenele = zeile.split(Messages.getString("ViewChecklistLoadFromDisc.5")); //$NON-NLS-1$
            	if(zeilenele[2].equals(Messages.getString("ViewChecklistLoadFromDisc.6"))) //$NON-NLS-1$
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

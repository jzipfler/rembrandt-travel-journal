package de.htwds.rembrandt.controler.travelview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewTravelinformation;

public class SetCommentEnableActionListener implements ActionListener{

	private ViewTravelinformation viewInformation;
	
	public SetCommentEnableActionListener(ViewTravelinformation viewInformation){
		this.viewInformation = viewInformation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		viewInformation.setCommentEditable();
	}
	
}

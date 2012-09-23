package de.htwds.rembrandt.controler.viewStartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWizzard;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-12 )
 *
 */
public class LoadWizzardActionListener implements ActionListener {

	private ViewStart viewStart;
	
	public LoadWizzardActionListener( ViewStart viewStart ) {
		this.viewStart = viewStart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new ViewWizzard(viewStart);//.main(null);
		
	}
}

package de.htwds.rembrandt.controler.mainViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwds.rembrandt.view.ViewStart;
import de.htwds.rembrandt.view.ViewWrapperWindow;

/**
 * 
 * @author jan
 * @version ( Jan Zipfler 2012-09-12 )
 *
 */
public class LoadStartViewActionListener implements ActionListener {

	private ViewWrapperWindow viewWrapper;
	
	public LoadStartViewActionListener( ViewWrapperWindow viewWrapper ) {
		this.viewWrapper = viewWrapper;
	}
	
	public void loadStartView() {
		viewWrapper.getPanel().removeAll();
		viewWrapper.getPanel().add( new ViewStart(viewWrapper).getViewStart() );
		viewWrapper.getPanel().updateUI();
	}
	
	private void loadTableItems() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		loadTableItems();
		loadStartView();
	}

}

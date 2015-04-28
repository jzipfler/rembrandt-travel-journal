package de.htwds.rembrandt.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTravelInformationTextfield extends JTextField{
	
	final static String BAD_CHARS 
	= Messages.getString("JTravelInformationTextfield.0"); //$NON-NLS-1$
	
	@Override
	public void processKeyEvent(KeyEvent ev) {

		char c = ev.getKeyChar();

		if(BAD_CHARS.indexOf(c) > -1) {
			ev.consume();
        	return;
		}
     	else super.processKeyEvent(ev);
	}
	
}

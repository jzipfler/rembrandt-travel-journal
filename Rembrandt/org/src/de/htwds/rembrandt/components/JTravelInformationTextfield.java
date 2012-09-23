package de.htwds.rembrandt.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTravelInformationTextfield extends JTextField{
	
	final static String BAD_CHARS 
	= "`~!@#$%^&*()+=\\|\"':;?/><";
	
	public void processKeyEvent(KeyEvent ev) {

		char c = ev.getKeyChar();

		if(BAD_CHARS.indexOf(c) > -1) {
			ev.consume();
        	return;
		}
     	else super.processKeyEvent(ev);
	}
	
}

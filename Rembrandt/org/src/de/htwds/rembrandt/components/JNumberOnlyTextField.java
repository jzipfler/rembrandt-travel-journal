package de.htwds.rembrandt.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JNumberOnlyTextField extends JTextField {
	
	final static String BAD_CHARS 
    	= "`~!@#$%^&*()_+=\\|\"':;?/>.<, ";

	public void processKeyEvent(KeyEvent ev) {

		char c = ev.getKeyChar();

		if((Character.isLetter(c) && !ev.isAltDown()) || BAD_CHARS.indexOf(c) > -1) {
			ev.consume();
        	return;
		}
//Change the getLength() >= 0 to > 0 to allow "-" in the front of the String
     	if(c == '-' && getDocument().getLength() >= 0) 
     		ev.consume();
     	else super.processKeyEvent(ev);
	}
 
}

package de.htwds.rembrandt.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;




public class ViewActivity extends JPanel {
	
	
	private ViewMain frmMainFrame;
	private ViewCalendar viewCalendar;
	
	public JPanel activityPane;
	public JPanel buttonPane;
	private JTextField description;
	private JTextField time;
	private JTextField location;
	private JTextArea story;
	private JButton save;
	private JButton abort;
	

	
	
	public ViewActivity() {
		

			
		description = new JTextField();
		description.setMaximumSize(new Dimension(1000, 25));
		description.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
		description.setText("Beschreibung");
		time = new JTextField();
		time.setMaximumSize(new Dimension(1000, 25));
		time.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
		time.setText("Zeitpunkt");
		location = new JTextField();
		location.setMaximumSize(new Dimension(1000, 25));
		location.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
		location.setText("Ort");
		story = new JTextArea();
		story.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
		
		save = new JButton("speichern");
		save.setFont(new Font("Arial", Font.BOLD, 14));
		save.setSize(111,111);
		abort = new JButton("abbruch");
		abort.setFont(new Font("Arial", Font.BOLD, 14));
		abort.setSize(111,111);
		
		
		buttonPane = new JPanel();
		buttonPane.setMaximumSize(new Dimension(1885, 32767));
		buttonPane.setPreferredSize(new Dimension(425, 380));
		buttonPane.setMinimumSize(new Dimension(425, 100));
		buttonPane.add(save);
		buttonPane.add(abort);
		
		
		
		
		activityPane = new JPanel();
		activityPane.setLayout(new BoxLayout(activityPane, BoxLayout.Y_AXIS));
		activityPane.setFont(new Font("Nimbus Sans L", Font.PLAIN, 15));
		activityPane.setMaximumSize(new Dimension(1885, 32767));
		activityPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		activityPane.setPreferredSize(new Dimension(425, 380));
		activityPane.setMinimumSize(new Dimension(425, 380));
		activityPane.add(description);
		activityPane.add(time);
		activityPane.add(location);
		activityPane.add(story);	

		
		add(activityPane);
		add(buttonPane);

	}
	
	public ViewActivity( ViewMain frmMainFrame, ViewCalendar viewCalendar){
		this();
		this.frmMainFrame = frmMainFrame;
		this.viewCalendar = viewCalendar;
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
		
}

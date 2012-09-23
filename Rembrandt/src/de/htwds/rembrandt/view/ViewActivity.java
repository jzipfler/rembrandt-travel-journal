package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import de.htwds.rembrandt.controler.contactViewControler.LoadCalendarActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadActivityAbortActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadActivitySaveActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadActivityDeleteActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadActivityEditActionListener;

import java.awt.*;





/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ViewActivity extends JPanel {
	
	
	private ViewMain frmMainFrame;
	private ViewCalendar viewCalendar;
	
	public JPanel activityPane;
	public JPanel buttonPane;
	public JPanel pnlActivityAndButtons;
	public JPanel descriptionPane;
	public JPanel timePane;
	public JPanel locationPane;
	
	public JTextField description;
	public JTextField time;
	public JTextField location;
	public JTextArea story;
	public JButton save;
	public JButton abort;
	public JButton delete;
	public JButton edit;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;	
	

	
	
	public ViewActivity() {
		
		
		
		setBorder(new EmptyBorder(2, 4, 2, 2));
		setMinimumSize(new Dimension(440, 440));
		setPreferredSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));
		
		
		FlowLayout myLayout = new FlowLayout();
		myLayout.setAlignment(FlowLayout.LEADING);
		
		
		label1 = new JLabel("Titel");
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		
		description = new JTextField(17);
		description.setMaximumSize(new Dimension(1000, 25));
		description.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
					
		descriptionPane = new JPanel();
		descriptionPane.setLayout(myLayout);
		descriptionPane.add(label1);
		label1.setPreferredSize(new java.awt.Dimension(100, 16));
		descriptionPane.add(description);
		
		
		
		
		
		label2 = new JLabel("Zeitpunkt");
		label2.setFont(new Font("Arial", Font.BOLD, 14));
		
		time = new JTextField(17);
		time.setMaximumSize(new Dimension(1000, 25));
		time.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
				
		timePane = new JPanel();
		timePane.setLayout(myLayout);
		timePane.add(label2);
		label2.setPreferredSize(new java.awt.Dimension(100, 16));
		timePane.add(time);		
		
		
		
		
		
		label3 = new JLabel("Ort");	
		label3.setFont(new Font("Arial", Font.BOLD, 14));
		
		location = new JTextField(17);
		location.setMaximumSize(new Dimension(1000, 25));
		location.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
				
		locationPane = new JPanel();
		locationPane.setLayout(myLayout);
		locationPane.add(label3);
		label3.setPreferredSize(new java.awt.Dimension(100, 16));
		locationPane.add(location);				
		
		
		
		
		
		story = new JTextArea();
		story.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
		
		save = new JButton("speichern");
		save.setFont(new Font("Arial", Font.BOLD, 16));
		save.setPreferredSize(new java.awt.Dimension(120, 50));
	
		abort = new JButton("zurück");
		abort.setFont(new Font("Arial", Font.BOLD, 16));
		abort.setPreferredSize(new java.awt.Dimension(120, 50));
		
		delete = new JButton("löschen");
		delete.setFont(new Font("Arial", Font.BOLD, 16));
		delete.setPreferredSize(new java.awt.Dimension(120, 50));
		
		edit = new JButton("bearbeiten");
		edit.setFont(new Font("Arial", Font.BOLD, 16));
		edit.setPreferredSize(new java.awt.Dimension(120, 50));
		
	
			
		buttonPane = new JPanel();
		buttonPane.setPreferredSize(new Dimension(422, 60));
		buttonPane.add(save);
		buttonPane.add(abort);
		buttonPane.add(delete);
		buttonPane.add(edit);
	

		activityPane = new JPanel();
		activityPane.setLayout(new BoxLayout(activityPane, BoxLayout.Y_AXIS));
		activityPane.setFont(new Font("Nimbus Sans L", Font.PLAIN, 15));
		activityPane.setMaximumSize(new Dimension(1885, 32767));
		activityPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		activityPane.setPreferredSize(new Dimension(425, 380));
		activityPane.setMinimumSize(new Dimension(425, 380));
		activityPane.add(descriptionPane);
		activityPane.add(timePane);
		activityPane.add(locationPane);
		activityPane.add(story);	

		
		
		pnlActivityAndButtons = new JPanel();
		pnlActivityAndButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlActivityAndButtons.setLayout(new BorderLayout(0, 0));
		pnlActivityAndButtons.add(activityPane, BorderLayout.CENTER);
		pnlActivityAndButtons.add(buttonPane, BorderLayout.SOUTH);		
		
		add(pnlActivityAndButtons, BorderLayout.CENTER);

	}
	
	public ViewActivity( ViewMain frmMainFrame, ViewCalendar viewCalendar){
		this();
		this.frmMainFrame = frmMainFrame;
		this.viewCalendar = new ViewCalendar();		
		this.abort.addActionListener(new LoadActivityAbortActionListener(this));
		this.save.addActionListener(new LoadActivitySaveActionListener(this, frmMainFrame.getJourneyModel()));
		this.delete.addActionListener(new LoadActivityDeleteActionListener(this));
		this.edit.addActionListener(new LoadActivityEditActionListener(this));
	}
	
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
	public JTextField get_descriptionField(){
		return description;
	}	
	
	public JTextField get_timeField(){
		return time;
	}	
	
	public JTextField get_locationField(){
		return location;
	}	
	
	public JTextArea get_storyArea(){
		return story;
	}		
	
	public JButton get_deleteButton(){
		return delete;
	}		
	
	public JButton get_saveButton(){
		return save;
	}
	
	public JButton get_editButton(){
		return edit;
	}

	public JButton get_abortButton(){
		return abort;
	}
	
	public String get_Description(){
		return description.getText();
	}
	
	public String get_Time(){
		return time.getText();
	}
	
	public String get_Location(){
		return location.getText();
	}
	
	public String get_Story(){
		return story.getText();
	}
	
	public void set_Description(String s){
		description.setText(s);
	}
		
	public void set_Time(String s){
		time.setText(s);
	}
	
	public void set_Location(String s){
		location.setText(s);
	}
	
	public void set_Story(String s){
		story.setText(s);
	}
}

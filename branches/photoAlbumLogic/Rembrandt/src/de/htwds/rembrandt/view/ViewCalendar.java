package de.htwds.rembrandt.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import org.freixas.jcalendar.*;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.contactViewControler.LoadCalendarActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadContactDetailsActionListener;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationPanelActionListener;

import de.htwds.rembrandt.controler.contactViewControler.LoadActivityActionListener;




public class ViewCalendar extends JPanel{

	
	
	public JButton jButton1 ;
	private JButton jButton2;
	private JButton jButton3;
	private JCalendar calendar;
	public JPanel calendarPane;
	public JPanel buttonPane;
	public JPanel pnlCalendarAndButtons;
	private MyDateListener listener;
	private ViewMain frmMainFrame;
	private ViewActivity viewActivity;

	
	
	
	

	public ViewCalendar() {
		

		setBorder(new EmptyBorder(2, 4, 2, 2));
		setMinimumSize(new Dimension(440, 440));
		setPreferredSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));

		
		listener = new MyDateListener();
		
		calendar= new JCalendar();	
		calendar.setTitleFont(new Font("Arial", Font.BOLD|Font.ITALIC, 20));
	    calendar.setDayOfWeekFont(new Font("Arial", Font.ITALIC, 20));
	    calendar.setDayFont(new Font("Arial", Font.BOLD, 20));
		calendar.setTimeFont(new Font("Arial", Font.PLAIN, 20));
		calendar.setTodayFont(new Font("Arial", Font.PLAIN, 20));
		calendar.addDateListener(listener);
		
		jButton1 = new JButton("hinzufügen");
		jButton2 = new JButton("bearbeiten");
		jButton3 = new JButton(" löschen  ");
		
		
		buttonPane = new JPanel();
		buttonPane.setPreferredSize(new Dimension(422, 60));
		buttonPane.add(jButton1);
		buttonPane.add(jButton2);
		buttonPane.add(jButton3);		
		
		
		calendarPane = new JPanel();
		calendarPane.setLayout(new BorderLayout(0, 0));
		calendarPane.add(calendar);
		
		

		pnlCalendarAndButtons = new JPanel();
		pnlCalendarAndButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlCalendarAndButtons.setLayout(new BorderLayout(0, 0));
		pnlCalendarAndButtons.add(calendarPane, BorderLayout.CENTER);
		pnlCalendarAndButtons.add(buttonPane, BorderLayout.SOUTH);
		
		add(pnlCalendarAndButtons, BorderLayout.CENTER);	
	};
	

	
	public ViewCalendar( ViewMain frmMainFrame ){


		this();
		this.frmMainFrame = frmMainFrame;
		ViewActivity viewActivity = new ViewActivity(frmMainFrame, this);
		jButton1.addActionListener(new LoadActivityActionListener(viewActivity));
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	

	private class MyDateListener implements DateListener{

		public void dateChanged(DateEvent e){
			Calendar c = e.getSelectedDate();
			if (c != null) {
				System.out.println(c.getTime());
			} else {
				System.out.println("No time selected.");
			}
		}
	}
	
}

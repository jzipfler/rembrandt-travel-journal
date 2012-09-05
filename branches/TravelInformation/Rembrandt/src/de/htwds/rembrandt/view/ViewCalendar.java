package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;




public class ViewCalendar extends JPanel{

	
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JCalendar calendar;
	public JPanel calendarPane;
	private JPanel buttonPane;
	MyDateListener listener;
	private ViewMain frmMainFrame;

	
	
	
	

	public ViewCalendar() {
		
		setLayout(new BorderLayout());
		
		
		listener = new MyDateListener();
		
		calendar= new JCalendar();
		this.calendar.setFont(new Font("Arial", Font.PLAIN, 13));
	
		calendar.setTitleFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
	    calendar.setDayOfWeekFont(new Font("Arial", Font.ITALIC, 20));
	    calendar.setDayFont(new Font("Arial", Font.BOLD, 20));
		calendar.setTimeFont(new Font("Arial", Font.PLAIN, 20));
		calendar.setTodayFont(new Font("Arial", Font.PLAIN, 20));
		


		calendar.addDateListener(listener);
		
		
		jButton1 = new JButton("Hinzufügen");
		this.jButton1.setFont(new Font("Arial", Font.BOLD, 13));
		jButton2 = new JButton("Bearbeiten");
		this.jButton2.setFont(new Font("Arial", Font.BOLD, 13));
		jButton3 = new JButton("Löschen");
		this.jButton3.setFont(new Font("Arial", Font.BOLD, 13));
		
		
		buttonPane = new JPanel();
		this.buttonPane.setFont(new Font("Arial", Font.PLAIN, 13));
		buttonPane.add(jButton1);
		buttonPane.add(jButton2);
		buttonPane.add(jButton3);		
		
		
		calendarPane = new JPanel();
		calendarPane.setLayout(new BoxLayout(calendarPane, BoxLayout.Y_AXIS));
		calendarPane.setFont(new Font("Arial", Font.PLAIN, 13));
		calendarPane.setMaximumSize(new Dimension(1885, 32767));
		calendarPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendarPane.setPreferredSize(new Dimension(440, 440));
		calendarPane.setMinimumSize(new Dimension(440, 440));
		calendarPane.add(calendar);
		calendarPane.add(buttonPane);
//		add(calendarPane);
//		add(buttonPane);
	};
		

	
	
	

	
	public ViewCalendar( ViewMain frmMainFrame ){


		this();
		this.frmMainFrame = frmMainFrame;
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
		
	JPanel getCalendarPane(){
		return calendarPane;	
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

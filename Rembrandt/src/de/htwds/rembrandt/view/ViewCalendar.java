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

import de.htwds.rembrandt.controler.contactViewControler.LoadContactDetailsActionListener;




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
		
		
		
		
		listener = new MyDateListener();
		
		calendar= new JCalendar();
	
		calendar.setTitleFont(new Font("Serif", Font.BOLD|Font.ITALIC, 20));
	    calendar.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 20));
	    calendar.setDayFont(new Font("SansSerif", Font.BOLD, 20));
		calendar.setTimeFont(new Font("DialogInput", Font.PLAIN, 20));
		calendar.setTodayFont(new Font("Dialog", Font.PLAIN, 20));
		


		calendar.addDateListener(listener);
		
		
		jButton1 = new JButton("Aktivität hinzufügen");
		jButton2 = new JButton("Aktivität bearbeiten");
		jButton3 = new JButton("Aktivität löschen");
		
		
		buttonPane = new JPanel();
		buttonPane.add(jButton1);
		buttonPane.add(jButton2);
		buttonPane.add(jButton3);		
		
		
		calendarPane = new JPanel();
		calendarPane.setLayout(new BoxLayout(calendarPane, BoxLayout.Y_AXIS));
		calendarPane.setFont(new Font("Nimbus Sans L", Font.PLAIN, 15));
		calendarPane.setMaximumSize(new Dimension(1885, 32767));
		calendarPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendarPane.setPreferredSize(new Dimension(425, 380));
		calendarPane.setMinimumSize(new Dimension(425, 380));
		calendarPane.add(calendar);
		calendarPane.add(buttonPane);
		add(calendarPane);
		add(buttonPane);
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

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
import javax.swing.JTextArea;
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
public class ViewCalendar extends JPanel{

	
	
	public JButton jButton1 ;
	private JButton jButton2;
	private JButton jButton3;
	private JCalendar calendar;
	private JTextArea list;
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

		//calendar.setPreferredSize(new Dimension(100, 33));

		jButton1 = new JButton("hinzufügen");
		jButton2 = new JButton("bearbeiten");
		jButton3 = new JButton(" löschen  ");
		
		
		buttonPane = new JPanel();
		buttonPane.setPreferredSize(new Dimension(422, 60));
		buttonPane.add(jButton1);
		buttonPane.add(jButton2);
		buttonPane.add(jButton3);

		//calendarPane.setLayout(new BorderLayout(0, 0));
		//calendarPane.setLayout(new FlowLayout());
		//calendarPane.add(calendar, BorderLayout.NORTH);

		pnlCalendarAndButtons = new JPanel();
		pnlCalendarAndButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlCalendarAndButtons.setLayout(new BorderLayout(0, 0));
		pnlCalendarAndButtons.add(buttonPane, BorderLayout.SOUTH);
		
			calendarPane = new JPanel();
			calendarPane.setLayout(new BorderLayout(0, 0));
			pnlCalendarAndButtons.add(calendarPane, BorderLayout.CENTER);
			
				list = new JTextArea();
				calendarPane.add(list, BorderLayout.WEST);
				list.setFont(new Font("Arial", Font.BOLD|Font.PLAIN, 18));
				list.setPreferredSize(new java.awt.Dimension(140, 228));
				
				if ( frmMainFrame != null){
					int c = frmMainFrame.getJourneyModel().getTravelInformation().getActivityList().getCounter();
					for ( int i = 0; i < c; i++){
						list.append(frmMainFrame.getJourneyModel().getTravelInformation().getActivityList().getActivityName(i)+"\n");
					}
				}
		
			
				calendar= new JCalendar();	
				calendarPane.add(calendar, BorderLayout.CENTER);
				calendar.setTitleFont(new Font("Arial", Font.BOLD|Font.ITALIC, 10));
				calendar.setDayOfWeekFont(new Font("Arial", Font.ITALIC, 10));
				calendar.setDayFont(new Font("Arial", Font.BOLD, 10));
				calendar.setTimeFont(new Font("Arial", Font.BOLD, 10));
			    calendar.setTodayFont(new Font("Arial", Font.BOLD, 10));
				calendar.setPreferredSize(new java.awt.Dimension(223, 225));
				calendar.addDateListener(listener);
			
		
		
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

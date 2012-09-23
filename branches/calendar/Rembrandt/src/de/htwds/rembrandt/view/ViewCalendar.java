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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.freixas.jcalendar.*;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.contactViewControler.LoadCalendarActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadContactDetailsActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadSelectedActivityListSelectionListener;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationPanelActionListener;
import de.htwds.rembrandt.model.ActivityList;
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
	private JCalendar calendar;
	public JPanel calendarPane;
	public JPanel buttonPane;
	public JPanel jp;
	public JList list;
	private MyDateListener listener;
	private ViewMain frmMainFrame;
	private ViewActivity viewActivity;
	private ActivityList activityList;
	private String time;

	
	
	
	

	public ViewCalendar() {
	

		setBorder(new EmptyBorder(2, 4, 2, 2));
		setMinimumSize(new Dimension(440, 440));
		setPreferredSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));

		
		listener = new MyDateListener();

		jButton1 = new JButton();
		jButton1.setFont(new Font("Arial", Font.BOLD, 13));
		jButton1.setPreferredSize(new java.awt.Dimension(120, 50));

	
			
		calendar= new JCalendar();	
		calendar.setTitleFont(new Font("Arial", Font.BOLD, 13));
		calendar.setDayOfWeekFont(new Font("Arial", Font.BOLD, 15));
		calendar.setDayFont(new Font("Arial", Font.BOLD, 14));
		calendar.addDateListener(listener);
						
		jp = new JPanel( new GridLayout(2,1));
		jp.add(calendar);
		jp.add(jButton1);
				
				
		calendarPane = new JPanel();
		calendarPane.setLayout(new BorderLayout(0, 0));
		calendarPane.add(jp, BorderLayout.CENTER);

						
		add(calendarPane, BorderLayout.CENTER);	
	};
	

	public void setActivityList(ActivityList activityList){
		this.activityList = activityList;
		if (activityList.getCounter() > 0){
			list  = new JList(activityList.getList());
		} else {
			list  = new JList();
		}
		list.setFont(new Font("Arial", Font.PLAIN, 13));
		list.setFont(new Font("Arial", Font.BOLD|Font.BOLD, 14));
		list.setPreferredSize(new java.awt.Dimension(140, 228));
		list.setAutoscrolls(false);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener( new LoadSelectedActivityListSelectionListener( this ) );
		calendarPane.add(list, BorderLayout.WEST);
	}
	
	
	public ViewCalendar( ViewMain frmMainFrame ){


		this();
		this.frmMainFrame = frmMainFrame;
		time = (new GregorianCalendar()).getTime().getDate()  + "." +(((new GregorianCalendar()).getTime()).getMonth()+1) + "."+ (((new GregorianCalendar()).getTime()).getYear()-100);
		jButton1.setText("Neue Aktivität: " + time);
		ViewActivity viewActivity = new ViewActivity(frmMainFrame, this);
		jButton1.addActionListener(new LoadActivityActionListener(viewActivity, this));
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
	public JList getList(){
		return list;
	}
	
	public String get_time(){
		return time;
	}

	private class MyDateListener implements DateListener{

		public void dateChanged(DateEvent e){
			Calendar c = e.getSelectedDate();
			if (c != null) {
				time = c.getTime().getDate()+ "."+ (c.getTime().getMonth()+1) +  "."+ (c.getTime().getYear()-100);
				jButton1.setText("Neue Aktivität: " + time);
			} else {
				System.out.println("No time selected.");
			}
		}
	}
	
}

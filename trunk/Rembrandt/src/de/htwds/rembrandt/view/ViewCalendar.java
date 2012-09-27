package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;

import de.htwds.rembrandt.controler.contactViewControler.LoadActivityActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadSelectedActivityListSelectionListener;
import de.htwds.rembrandt.model.ActivityList;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;





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
	private JPanel panelHeader;
	private JLabel lblAktivitten;
	private JPanel panelButton;
	private JScrollPane scrollPane;
	private JList list_1;

	
	
	
	

	public ViewCalendar() {
	

		setBorder(new EmptyBorder(2, 4, 2, 2));
		setMinimumSize(new Dimension(440, 440));
		setPreferredSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));

		
		listener = new MyDateListener();

	
			
		calendar= new JCalendar();	
		calendar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		calendar.setTitleFont(new Font(Messages.getString("ViewCalendar.1"), Font.BOLD, 13)); //$NON-NLS-1$
		calendar.setDayOfWeekFont(new Font(Messages.getString("ViewCalendar.2"), Font.BOLD, 15)); //$NON-NLS-1$
		calendar.setDayFont(new Font(Messages.getString("ViewCalendar.3"), Font.BOLD, 13)); //$NON-NLS-1$
		calendar.addDateListener(listener);
						
		jp = new JPanel( );
		jp.setBorder(new EmptyBorder(5, 5, 2, 2));
		jp.setLayout(new BorderLayout(0, 0));
		jp.add(calendar, BorderLayout.CENTER);
				
				
		calendarPane = new JPanel();
		calendarPane.setLayout(new BorderLayout(0, 0));
		calendarPane.add(jp, BorderLayout.CENTER);
		
		panelButton = new JPanel();
		panelButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		jp.add(panelButton, BorderLayout.SOUTH);
				panelButton.setLayout(new BorderLayout(0, 0));
		
				jButton1 = new JButton();
				panelButton.add(jButton1);
				jButton1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				this.jButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
				jButton1.setFont(new Font(Messages.getString("ViewCalendar.0"), Font.BOLD, 13)); //$NON-NLS-1$
				jButton1.setPreferredSize(new java.awt.Dimension(120, 50));

						
		add(calendarPane, BorderLayout.CENTER);	
		
		panelHeader = new JPanel();
		calendarPane.add(panelHeader, BorderLayout.NORTH);
		
		lblAktivitten = new JLabel("Aktivitäten");
		lblAktivitten.setFont(new Font("Arial", Font.BOLD, 16));
		panelHeader.add(lblAktivitten);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(144, 3));
		scrollPane.setMinimumSize(new Dimension(144, 22));
		calendarPane.add(scrollPane, BorderLayout.WEST);
	};
	

	public void setActivityList(ActivityList activityList){
		this.activityList = activityList;
		if (activityList.getCounter() > 0){
			list  = new JList(activityList.getList());
		} else {
			list  = new JList();
		}

		list.setFont(new Font(Messages.getString("ViewCalendar.4"), Font.PLAIN, 13)); //$NON-NLS-1$
		list.setFont(new Font(Messages.getString("ViewCalendar.5"), Font.BOLD|Font.BOLD, 14)); //$NON-NLS-1$
//		Set preferedSize to NULL for compitibility with scrollPane
//		list.setPreferredSize(new java.awt.Dimension(120, 228));
		list.setPreferredSize(null);
		list.setAutoscrolls(false);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener( new LoadSelectedActivityListSelectionListener( this ) );
		scrollPane.setViewportView(list);
//		calendarPane.add(list, BorderLayout.WEST);
	}
	
	
	public ViewCalendar( ViewMain frmMainFrame ){


		this();
		this.frmMainFrame = frmMainFrame;
		time = (new GregorianCalendar()).getTime().getDate()  + Messages.getString("ViewCalendar.6") +(((new GregorianCalendar()).getTime()).getMonth()+1) + Messages.getString("ViewCalendar.7")+ (((new GregorianCalendar()).getTime()).getYear()-100); //$NON-NLS-1$ //$NON-NLS-2$
		jButton1.setText(Messages.getString("ViewCalendar.8") + time); //$NON-NLS-1$
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

		@Override
		public void dateChanged(DateEvent e){
			Calendar c = e.getSelectedDate();
			if (c != null) {
				time = c.getTime().getDate()+ Messages.getString("ViewCalendar.9")+ (c.getTime().getMonth()+1) +  Messages.getString("ViewCalendar.10")+ (c.getTime().getYear()-100); //$NON-NLS-1$ //$NON-NLS-2$
				jButton1.setText(Messages.getString("ViewCalendar.11") + time); //$NON-NLS-1$
			} else {
				System.out.println(Messages.getString("ViewCalendar.12")); //$NON-NLS-1$
			}
		}
	}
	
}

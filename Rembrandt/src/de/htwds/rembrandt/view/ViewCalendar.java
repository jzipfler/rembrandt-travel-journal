
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import org.freixas.jcalendar.*;




public class ViewCalendar extends JFrame {

	
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JCalendar calendar;
	public JPanel calendarPane;
	private JPanel buttonPane;
	MyDateListener listener;


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
		calendarPane.setPreferredSize(new Dimension(188, 10));
		calendarPane.setMinimumSize(new Dimension(188, 10));
		calendarPane.add(calendar);
		calendarPane.add(buttonPane);
	};
		
		
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

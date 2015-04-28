


	import java.awt.event.ActionEvent;
import java.io.File;

	import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

	import de.htwds.rembrandt.controler.activityController.ActivityListFile;
import de.htwds.rembrandt.controler.activityController.ActivityFile;
import de.htwds.rembrandt.controler.datastructure.FolderPathController;
import de.htwds.rembrandt.model.ActivityList;
import de.htwds.rembrandt.model.ActivityModel;
import de.htwds.rembrandt.model.Contact;
import de.htwds.rembrandt.view.ViewActivity;
import de.htwds.rembrandt.view.ViewCalendar;
import de.htwds.rembrandt.view.ViewMain;

public class Test {
	
	
	private ViewActivity viewActivity;
	private ViewCalendar viewCalendar;

	
	public static void main(String[] args) {
		ActivityList al = new ActivityList();
		ActivityModel a1 = new ActivityModel();
		a1.set_titel("A");
		a1.set_time("1");
		ActivityModel a2 = new ActivityModel();
		a2.set_titel("B");
		a2.set_time("2");
		ActivityModel a3 = new ActivityModel();
		a3.set_titel("C");
		a3.set_time("3");
		ActivityModel a4 = new ActivityModel();
		a4.set_titel("D");
		a4.set_time("4");
		
		al.addActivity(a1);
		al.addActivity(a2);
		al.addActivity(a3);
		al.addActivity(a4);
		
		System.out.println("Counter : " + al.getCounter());
		for (int i = 0 ; i < al.getCounter(); i++){
			System.out.println(al.getActivityName(i));
		}
		System.out.println("\n");
		
		al.deleteActivity("B_2");
		
		System.out.println("Counter : " + al.getCounter());
		for (int i = 0 ; i < al.getCounter(); i++){
			System.out.println(al.getActivityName(i));
		}
		System.out.println("\n");
	}

	




			
			

	

	
	
	
	
}

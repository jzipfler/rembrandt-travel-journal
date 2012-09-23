package de.htwds.rembrandt.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import de.htwds.rembrandt.components.JTrayIcon;
import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.mainViewController.LoadStartViewActionListener;
import java.awt.Toolkit;

/**
 * 
 * Wrapper class for all views.
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-16 )
 *
 */
public class ViewWrapperWindow extends JFrame {
	
	public static final String APPLICATION_NAME = "Reisetagebuch";
	
	private JPanel panel;
	private JPopupMenu popupMenu;
	private JMenuItem mntmHilfe;
	private boolean isMainView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWrapperWindow frame = new ViewWrapperWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewWrapperWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewWrapperWindow.class.getResource("/de/htwds/rembrandt/resources/images/Travel.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/*
				 * This action starts, when the user close the window 
				 * with the X option in the window decoration panel.
				 */
				if ( getIsMainView() ) {
					Object[] options = {	"Beenden",
											"Nicht beeden"};

					int n = JOptionPane.showOptionDialog(	getPanel(),
									"Wenn Sie das Programm so beenden, werden ihne Änderungen nicht gespeichert.",
									"Änderungen werden nicht gespeichert",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null,     		//do not use a custom Icon
									options,  		//the titles of buttons
									options[0]);	//default button title

					if ( n == JOptionPane.YES_OPTION ) {
						setDefaultCloseOperation(EXIT_ON_CLOSE);
					} else {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					}
				} else {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});
		
		
		addTrayIcon();
		
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(640, 480));
		setTitle( APPLICATION_NAME );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 439);
		
		this.popupMenu = new JPopupMenu();
		addPopup(this, this.popupMenu);
		
		this.mntmHilfe = new JMenuItem("Hilfe");
		this.mntmHilfe.setFont(new Font("Arial", Font.BOLD, 13));
		this.mntmHilfe.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Hilfe","Hilfe",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.popupMenu.add(this.mntmHilfe);
		
		this.panel = new JPanel();
		setContentPane( this.panel );
		this.panel.setLayout(new BorderLayout(0, 0));
		
		new CheckExistingDataStructureControler().checkExistingDataStructure();
		new LoadStartViewActionListener(this).loadStartView();
		
	}

	public JPanel getPanel() {
		return panel;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}
	
	/**
	 * 
	 * @return true if mainView. false if startView.
	 */
	public boolean getIsMainView() {
		return isMainView;
	}
	
	public void setIsMainView( boolean isMainView ) {
		this.isMainView = isMainView;
	}
	
	private void addTrayIcon() {

		 //Check the SystemTray is supported
       if (!SystemTray.isSupported()) {
//           System.out.println("SystemTray is not supported");
           return;
       }
       final JPopupMenu popup = new JPopupMenu();
       ImageIcon image = new ImageIcon( ViewWrapperWindow.class.getResource("/de/htwds/rembrandt/resources/images/Travel.png" ));
//       final JXTrayIcon trayIcon = new JXTrayIcon( image.getImage() );
       final JTrayIcon trayIcon = new JTrayIcon( image.getImage(), APPLICATION_NAME );
       final SystemTray tray = SystemTray.getSystemTray();
       
       // Create a pop-up menu components
       JMenuItem aboutItem = new JMenuItem("About");
       JMenu displayMenu = new JMenu("Display");
       JMenuItem errorItem = new JMenuItem("Error");
       JMenuItem warningItem = new JMenuItem("Warning");
       JMenuItem infoItem = new JMenuItem("Info");
       JMenuItem noneItem = new JMenuItem("None");
       JMenuItem exitItem = new JMenuItem("Exit");
      
       //Add components to pop-up menu
       popup.add(aboutItem);
       popup.addSeparator();
       popup.addSeparator();
       popup.add(displayMenu);
       displayMenu.add(errorItem);
       displayMenu.add(warningItem);
       displayMenu.add(infoItem);
       displayMenu.add(noneItem);
       popup.add(exitItem);

       trayIcon.setMenu(popup);
//       Use this for JXTrayIcon
//       trayIcon.setJPopupMenu(popup);
       
       try {
           tray.add(trayIcon);
       } catch (AWTException e) {
           System.out.println("TrayIcon could not be added.");
       }
		
	}
}

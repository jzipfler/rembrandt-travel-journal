package de.htwds.rembrandt.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import de.htwds.rembrandt.components.JTrayIcon;
import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.mainViewController.LoadStartViewActionListener;

/**
 * 
 * Wrapper class for all views.
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-16 )
 *
 */
public class ViewWrapperWindow extends JFrame {
	
	public static final String APPLICATION_NAME = Messages.getString("ViewWrapperWindow.0"); //$NON-NLS-1$
	
	private JPanel panel;
	private JPopupMenu popupMenu;
	private JMenuItem mntmHilfe;
	private boolean isMainView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewWrapperWindow.class.getResource(Messages.getString("ViewWrapperWindow.1")))); //$NON-NLS-1$
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/*
				 * This action starts, when the user close the window 
				 * with the X option in the window decoration panel.
				 */
				if ( getIsMainView() ) {
					Object[] options = {	Messages.getString("ViewWrapperWindow.2"), //$NON-NLS-1$
											Messages.getString("ViewWrapperWindow.3")}; //$NON-NLS-1$

					int n = JOptionPane.showOptionDialog(	getPanel(),
									Messages.getString("ViewWrapperWindow.4"), //$NON-NLS-1$
									Messages.getString("ViewWrapperWindow.5"), //$NON-NLS-1$
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
		setMinimumSize(new Dimension(700, 530));
		setTitle( APPLICATION_NAME );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 439);
		
		this.popupMenu = new JPopupMenu();
		addPopup(this, this.popupMenu);
		
		this.mntmHilfe = new JMenuItem(Messages.getString("ViewWrapperWindow.6")); //$NON-NLS-1$
		this.mntmHilfe.setFont(new Font(Messages.getString("ViewWrapperWindow.7"), Font.BOLD, 13)); //$NON-NLS-1$
		this.mntmHilfe.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, Messages.getString("ViewWrapperWindow.8"),Messages.getString("ViewWrapperWindow.9"),JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
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
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			@Override
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
	
	private ViewWrapperWindow getViewWrapperWindow(){
		return this;
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
       ImageIcon image = new ImageIcon( ViewWrapperWindow.class.getResource(Messages.getString("ViewWrapperWindow.10") )); //$NON-NLS-1$
       final JTrayIcon trayIcon = new JTrayIcon( image.getImage(), APPLICATION_NAME );
       final SystemTray tray = SystemTray.getSystemTray();
       
       // Create a pop-up menu components
       JMenuItem aboutItem = new JMenuItem(Messages.getString("ViewWrapperWindow.11")); //$NON-NLS-1$
       aboutItem.setFont(new Font(Messages.getString("ViewWrapperWindow.12"), Font.BOLD, 17)); //$NON-NLS-1$
       aboutItem.setIcon( new ImageIcon( ViewWrapperWindow.class.getResource(Messages.getString("ViewWrapperWindow.13") ) ) ); //$NON-NLS-1$
       // Set size to make the popup menu a little bigger.
       aboutItem.setMinimumSize(new Dimension(150, 25));
       aboutItem.setPreferredSize(new Dimension(150, 25));
       aboutItem.addActionListener( new ActionListener() {
		
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
			
    		   new ViewInfo( getViewWrapperWindow() ).setVisible(true);
    	   }
       } );
       
       JMenuItem exitItem = new JMenuItem(Messages.getString("ViewWrapperWindow.14")); //$NON-NLS-1$
       exitItem.setFont(new Font(Messages.getString("ViewWrapperWindow.15"), Font.BOLD, 17)); //$NON-NLS-1$
       exitItem.setIcon( new ImageIcon( ViewWrapperWindow.class.getResource(Messages.getString("ViewWrapperWindow.16") ) ) ); //$NON-NLS-1$
       exitItem.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
      
       //Add components to pop-up menu
       popup.add(aboutItem);
       popup.addSeparator();
       popup.add(exitItem);
       
       trayIcon.setMenu(popup);
//       Use this for JXTrayIcon
//       trayIcon.setJPopupMenu(popup);
       
       try {
           tray.add(trayIcon);
       } catch (AWTException e) {
           System.out.println(Messages.getString("ViewWrapperWindow.17")); //$NON-NLS-1$
       }
		
	}

}

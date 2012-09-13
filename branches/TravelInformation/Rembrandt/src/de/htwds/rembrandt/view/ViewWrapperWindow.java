package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;
import de.htwds.rembrandt.controler.mainViewController.LoadStartViewActionListener;

/**
 * 
 * Wrapper class for all views.
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-12 )
 *
 */
public class ViewWrapperWindow extends JFrame {
	
	private JPanel panel;
	private JPopupMenu popupMenu;
	private JMenuItem mntmHilfe;

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
		
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(640, 480));
		setTitle("Reisetagebuch");
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
}

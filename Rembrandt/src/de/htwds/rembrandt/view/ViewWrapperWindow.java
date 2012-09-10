package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

import de.htwds.rembrandt.controler.datastructure.CheckExistingDataStructureControler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Wrapper class for all views.
 * 
 * @author Jan Zipfler
 * @version 20120910
 *
 */
public class ViewWrapperWindow extends JFrame {
	
	private ViewStart panel;

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
		
		this.panel = new ViewStart( this );
		setContentPane(panel.getViewStart( ) );
		
		new CheckExistingDataStructureControler();
		
	}

	public JPanel getPanel() {
		return panel;
	}
}

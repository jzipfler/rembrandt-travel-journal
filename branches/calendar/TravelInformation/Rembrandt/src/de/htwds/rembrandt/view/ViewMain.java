package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.travelview.LoadTravelInformationPanelActionListener;

/**
 * 
 * @author Jan Zipfler
 * @version 1
 * 
 * This class provides the main menu for the Rembrandt project. 
 *
 */
public class ViewMain extends JFrame {

	private JPanel contentPane;
	private JPanel pnlContent;
	private JButton btnPhotos;
	private JButton btnData;
	private JButton btnLists;
	private JLabel lblFavorits;
	private JButton btnKontakte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain frame = new ViewMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Contructor for the main menu.
	 */
	public ViewMain() {
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(640, 480));
		setTitle("Travel Journal");
		setName("MainMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlQuicklunch = new JPanel();
		pnlQuicklunch.setFont(new Font("Nimbus Sans L", Font.PLAIN, 15));
		pnlQuicklunch.setMaximumSize(new Dimension(188, 32767));
		pnlQuicklunch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlQuicklunch.setPreferredSize(new Dimension(188, 10));
		pnlQuicklunch.setMinimumSize(new Dimension(188, 10));
		contentPane.add(pnlQuicklunch, BorderLayout.WEST);
		pnlQuicklunch.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(72dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(40dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnPhotos = new JButton("Fotos");
		btnPhotos.setBackground(UIManager.getColor("Button.background"));
		btnPhotos.setFont(new Font("Nimbus Sans L", Font.BOLD, 14));
		pnlQuicklunch.add(btnPhotos, "2, 2");
		
		btnData = new JButton("Daten");
		btnData.addActionListener(new LoadTravelInformationPanelActionListener(this));
		btnData.setFont(new Font("Nimbus Sans L", Font.BOLD, 14));
		pnlQuicklunch.add(btnData, "2, 4");
		
		btnLists = new JButton("Listen");
		btnLists.setFont(new Font("Nimbus Sans L", Font.BOLD, 14));
		pnlQuicklunch.add(btnLists, "2, 6");
		
		lblFavorits = new JLabel("Favoriten:");
		lblFavorits.setFont(new Font("Nimbus Sans L", Font.BOLD, 14));
		lblFavorits.setHorizontalAlignment(SwingConstants.CENTER);
		pnlQuicklunch.add(lblFavorits, "2, 12");
		
		btnKontakte = new JButton("Kontakte");
		btnKontakte.setFont(new Font("Nimbus Sans L", Font.BOLD, 14));
		pnlQuicklunch.add(btnKontakte, "2, 8");
		
		/*
		 * Dimensions of the contentPanes = 440,440
		 */
		pnlContent = new JPanel();
		contentPane.add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new BorderLayout(0, 0));
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}
}

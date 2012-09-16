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

import de.htwds.rembrandt.controler.mainViewController.LoadContacPanelActionListener;
import de.htwds.rembrandt.controler.mainViewController.LoadStartViewActionListener;
import de.htwds.rembrandt.controler.mainViewController.SaveAllToDiscActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadCalendarActionListener;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationPanelActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.LoadPhotoAlbumPanelActionListener;
import de.htwds.rembrandt.model.JourneyModel;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler - 2012-09-13 )
 * 
 * This class provides the main menu for the Rembrandt project. 
 *
 */
public class ViewMain extends JPanel {
	
	// Class that holds all informations
	private JourneyModel journeyModel;
	
	private ViewWrapperWindow viewWrapper;

	private JPanel pnlViewMain;
	private JPanel pnlContent;
	private JButton btnPhotos;
	private JButton btnData;
	private JButton btnLists;
	private JLabel lblFavorits;
	private JButton btnKontakte;
	private JButton btnReiseinfos;
	private JButton btnBeenden;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewMain frame = new ViewMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Contructor for the main menu.
	 */
	public ViewMain( ViewWrapperWindow viewWrapper, JourneyModel journeyModel ) {
		
		/*
		 * Create new JourneyModel
		 * Add wizard specific implementations
		 */
		this.journeyModel = journeyModel;
		this.viewWrapper = viewWrapper;
		this.viewWrapper.setIsMainView(true);
		
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(640, 480));
//		setTitle("Reisetagebuch");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 626, 439);
		
		
		setFont(new Font("Arial", Font.PLAIN, 11));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 3));
		

		pnlViewMain = new JPanel();
		pnlViewMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlViewMain.setLayout(new BorderLayout(0, 0));
//		setContentPane( pnlViewMain );
		
		JPanel pnlQuicklunch = new JPanel();
		pnlQuicklunch.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlQuicklunch.setMaximumSize(new Dimension(188, 32767));
		pnlQuicklunch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlQuicklunch.setPreferredSize(new Dimension(188, 10));
		pnlQuicklunch.setMinimumSize(new Dimension(188, 10));
		pnlViewMain.add(pnlQuicklunch, BorderLayout.WEST);
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnPhotos = new JButton("Fotos");
		btnPhotos.setBackground(UIManager.getColor("Button.background"));
		btnPhotos.setFont(new Font("Arial", Font.BOLD, 14));
		btnPhotos.addActionListener(new LoadPhotoAlbumPanelActionListener(this));
		pnlQuicklunch.add(btnPhotos, "2, 2");
		
		btnData = new JButton("Daten");
		btnData.addActionListener(new LoadTravelInformationPanelActionListener(this));
		btnData.setFont(new Font("Arial", Font.BOLD, 14));
		pnlQuicklunch.add(btnData, "2, 4");
		
		btnLists = new JButton("Listen");
		btnLists.setFont(new Font("Arial", Font.BOLD, 14));
		pnlQuicklunch.add(btnLists, "2, 6");
		
		btnReiseinfos = new JButton("Reiseinfos");
		btnReiseinfos.addActionListener(new LoadCalendarActionListener(this));
		btnReiseinfos.setFont(new Font("Arial", Font.BOLD, 14));
		pnlQuicklunch.add(btnReiseinfos, "2, 10");
		
		lblFavorits = new JLabel("Favoriten:");
		lblFavorits.setFont(new Font("Arial", Font.BOLD, 14));
		lblFavorits.setHorizontalAlignment(SwingConstants.CENTER);
		pnlQuicklunch.add(lblFavorits, "2, 14");
		
		btnKontakte = new JButton("Kontakte");
		btnKontakte.addActionListener( new LoadContacPanelActionListener( this ) );
		btnKontakte.setFont(new Font("Arial", Font.BOLD, 14));
		pnlQuicklunch.add(btnKontakte, "2, 8");
		
		this.btnBeenden = new JButton("Beenden");
		this.btnBeenden.setFont(new Font("Arial", Font.BOLD, 14));
		this.btnBeenden.addActionListener( new SaveAllToDiscActionListener( this ) );
		pnlQuicklunch.add(this.btnBeenden, "2, 24");
		
		/*
		 * Dimensions of the contentPanes = 440,440
		 */
		pnlContent = new JPanel();
		this.pnlContent.setPreferredSize(new Dimension(440, 440));
		this.pnlContent.setMinimumSize(new Dimension(440, 440));
		pnlViewMain.add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new BorderLayout(0, 0));
		
	}
	
	public JPanel getViewMain() {
		return pnlViewMain;
	}

	public JPanel getCurrentContentPanel() {
		return pnlContent;
	}
	
	public JourneyModel getJourneyModel() {
		return journeyModel;
	}
	
	public ViewWrapperWindow getViewWrapper() {
		return viewWrapper;
	}
}

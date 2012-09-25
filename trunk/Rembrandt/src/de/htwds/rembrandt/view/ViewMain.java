package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
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

import de.htwds.rembrandt.controler.contactViewControler.LoadCalendarActionListener;
import de.htwds.rembrandt.controler.mainViewController.LoadChecklistPanelControler;
import de.htwds.rembrandt.controler.mainViewController.LoadContacPanelActionListener;
import de.htwds.rembrandt.controler.mainViewController.SaveAllToDiscActionListener;
import de.htwds.rembrandt.controler.travelview.LoadTravelInformationPanelActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.LoadPhotoAlbumDetailsPanelActionListener;
import de.htwds.rembrandt.model.JourneyModel;

/**
 * 
 * @author Jan Zipfler
 * @version ( sfey 17.09.2012 )
 * 
 * This class provides the main menu for the Rembrandt project. 
 *
 */
public class ViewMain extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
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
		
		
		setFont(new Font(Messages.getString("ViewMain.0"), Font.PLAIN, 11)); //$NON-NLS-1$
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 3));
		

		pnlViewMain = new JPanel();
		pnlViewMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlViewMain.setLayout(new BorderLayout(0, 0));
//		setContentPane( pnlViewMain );
		
		JPanel pnlQuicklunch = new JPanel();
		pnlQuicklunch.setFont(new Font(Messages.getString("ViewMain.1"), Font.PLAIN, 15)); //$NON-NLS-1$
		pnlQuicklunch.setMaximumSize(new Dimension(188, 32767));
		pnlQuicklunch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlQuicklunch.setPreferredSize(new Dimension(188, 10));
		pnlQuicklunch.setMinimumSize(new Dimension(188, 10));
		pnlViewMain.add(pnlQuicklunch, BorderLayout.WEST);
		pnlQuicklunch.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewMain.2")), //$NON-NLS-1$
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
				RowSpec.decode(Messages.getString("ViewMain.3")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewMain.4")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnPhotos = new JButton(Messages.getString("ViewMain.5")); //$NON-NLS-1$
		btnPhotos.setBackground(UIManager.getColor(Messages.getString("ViewMain.6"))); //$NON-NLS-1$
		btnPhotos.setFont(new Font(Messages.getString("ViewMain.7"), Font.BOLD, 14)); //$NON-NLS-1$
		btnPhotos.addActionListener(new LoadPhotoAlbumDetailsPanelActionListener(this));
		pnlQuicklunch.add(btnPhotos, Messages.getString("ViewMain.8")); //$NON-NLS-1$
		
		btnData = new JButton(Messages.getString("ViewMain.9")); //$NON-NLS-1$
		btnData.addActionListener(new LoadTravelInformationPanelActionListener(this));
		btnData.setFont(new Font(Messages.getString("ViewMain.10"), Font.BOLD, 14)); //$NON-NLS-1$
		pnlQuicklunch.add(btnData, Messages.getString("ViewMain.11")); //$NON-NLS-1$
		
		btnLists = new JButton(Messages.getString("ViewMain.12")); //$NON-NLS-1$
		btnLists.addActionListener(new LoadChecklistPanelControler(this));
		btnLists.setFont(new Font(Messages.getString("ViewMain.13"), Font.BOLD, 14)); //$NON-NLS-1$
		pnlQuicklunch.add(btnLists, Messages.getString("ViewMain.14")); //$NON-NLS-1$
		
		btnReiseinfos = new JButton(Messages.getString("ViewMain.15")); //$NON-NLS-1$
		btnReiseinfos.addActionListener(new LoadCalendarActionListener(this));
		btnReiseinfos.setFont(new Font(Messages.getString("ViewMain.16"), Font.BOLD, 14)); //$NON-NLS-1$
		pnlQuicklunch.add(btnReiseinfos, Messages.getString("ViewMain.17")); //$NON-NLS-1$
		
		lblFavorits = new JLabel(Messages.getString("ViewMain.18")); //$NON-NLS-1$
		lblFavorits.setFont(new Font(Messages.getString("ViewMain.19"), Font.BOLD, 14)); //$NON-NLS-1$
		lblFavorits.setHorizontalAlignment(SwingConstants.CENTER);
		pnlQuicklunch.add(lblFavorits, Messages.getString("ViewMain.20")); //$NON-NLS-1$
		
		btnKontakte = new JButton(Messages.getString("ViewMain.21")); //$NON-NLS-1$
		btnKontakte.addActionListener( new LoadContacPanelActionListener( this ) );
		btnKontakte.setFont(new Font(Messages.getString("ViewMain.22"), Font.BOLD, 14)); //$NON-NLS-1$
		pnlQuicklunch.add(btnKontakte, Messages.getString("ViewMain.23")); //$NON-NLS-1$
		
		this.btnBeenden = new JButton(Messages.getString("ViewMain.24")); //$NON-NLS-1$
		this.btnBeenden.setFont(new Font(Messages.getString("ViewMain.25"), Font.BOLD, 14)); //$NON-NLS-1$
		this.btnBeenden.addActionListener( new SaveAllToDiscActionListener( this ) );
		pnlQuicklunch.add(this.btnBeenden, Messages.getString("ViewMain.26")); //$NON-NLS-1$
		
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

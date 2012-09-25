package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.viewStartController.FilterListControler;
import de.htwds.rembrandt.controler.viewStartController.LoadSelectedJouneyActionListener;
import de.htwds.rembrandt.controler.viewStartController.LoadWizzardActionListener;
import de.htwds.rembrandt.controler.viewStartController.RemoveSelectedJourneyActionListener;
import de.htwds.rembrandt.controler.viewStartController.TableOverviewListSelectionListener;
import de.htwds.rembrandt.model.GeneralInformationModel;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-16 )
 */
public class ViewStart extends JPanel {

	private ViewWrapperWindow wrapperView;

	private GeneralInformationModel[] generalInformationArray;

	private JPanel panelViewStart;
	private JTextField txtFilter;
	private JTable tblJourneyOverview;
	private DefaultTableModel tableModel;
	private String[] tableTitles;
	private Vector<String> tableDataVector;
	private JButton btnRemoveJourney;
	private JButton btnShowJourney;
	private JTextField txtTarget;
	private JTextField txtDeparture;
	private JTextField txtCountry;
	private JTextField txtJounreyEnd;
	private JPanel infoAboutTravelPane;
	private ViewStart viewStart;


	/**
	 * Create the frame.
	 */
	public ViewStart( ViewWrapperWindow wrapperView )  {
		
		this.viewStart = this;
		this.wrapperView = wrapperView;
		this.generalInformationArray = null;
		this.wrapperView.setIsMainView(false);
		
		setName(Messages.getString("ViewStart.0")); //$NON-NLS-1$
		setMinimumSize(new Dimension(640, 480));
		setBounds(100, 100, 640, 480);

		panelViewStart = new JPanel();
		this.panelViewStart.setPreferredSize(new Dimension(607, 376));
		this.panelViewStart.setMinimumSize(new Dimension(440, 440));
		panelViewStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelViewStart.setLayout(new BorderLayout(0, 0));

		JPanel quicklunchPanel = new JPanel();
		quicklunchPanel.setPreferredSize(new Dimension(180, 10));
		quicklunchPanel.setMinimumSize(new Dimension(135, 10));
		quicklunchPanel.setMaximumSize(new Dimension(135, 32767));
		panelViewStart.add(quicklunchPanel, BorderLayout.WEST);
		
		JButton btnCreateJourney = new JButton(Messages.getString("ViewStart.1")); //$NON-NLS-1$
		btnCreateJourney.setFont(new Font(Messages.getString("ViewStart.2"), Font.BOLD, 13)); //$NON-NLS-1$
		btnCreateJourney.setPreferredSize(new Dimension(150, 25));
		btnCreateJourney.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCreateJourney.addActionListener( new LoadWizzardActionListener(this));
		
		quicklunchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		quicklunchPanel.add( btnCreateJourney );
		
		btnRemoveJourney = new JButton(Messages.getString("ViewStart.3")); //$NON-NLS-1$
		this.btnRemoveJourney.setFont(new Font(Messages.getString("ViewStart.4"), Font.BOLD, 13)); //$NON-NLS-1$
		btnRemoveJourney.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRemoveJourney.setPreferredSize(new Dimension(150, 25));
		btnRemoveJourney.addActionListener( new RemoveSelectedJourneyActionListener( this ) );
		btnRemoveJourney.setEnabled(false);
		quicklunchPanel.add(btnRemoveJourney);
		
		btnShowJourney = new JButton(Messages.getString("ViewStart.5")); //$NON-NLS-1$
		btnShowJourney.addActionListener( new LoadSelectedJouneyActionListener( this ) );
		btnShowJourney.setEnabled(false);
		btnShowJourney.setFont(new Font(Messages.getString("ViewStart.6"), Font.BOLD, 13)); //$NON-NLS-1$
		btnShowJourney.setPreferredSize(new Dimension(150, 25));
		btnShowJourney.setMinimumSize(new Dimension(135, 25));
		quicklunchPanel.add( btnShowJourney );
		
		JPanel initialContentPane = new JPanel();
		panelViewStart.add(initialContentPane, BorderLayout.CENTER);
		initialContentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		initialContentPane.add(scrollPane);
		
		tableTitles = new String[]{ Messages.getString("ViewStart.7") }; //$NON-NLS-1$
		/*
		 * Override isCellEditable() --> makes all cells not editable.
		 */
		tableModel = new DefaultTableModel( tableTitles, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblJourneyOverview = new JTable( tableModel ){
			/**
			 * Ermöglicht Alighment = Rechts
			 */
			private static final long serialVersionUID = 1L;
			DefaultTableCellRenderer defaultRendererTest = new DefaultTableCellRenderer(); {
				defaultRendererTest.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			@Override
			public TableCellRenderer getCellRenderer(int arg0, int arg1){
				return defaultRendererTest;
			}
		};
		
		// Nur Testdatum
		//tableModel.addRow(new String[] {"Test"});
		//tableModel.addRow(new String[] {"Test2"});
		//
		this.tblJourneyOverview.setFont(new Font(Messages.getString("ViewStart.8"), Font.PLAIN, 13)); //$NON-NLS-1$
		tblJourneyOverview.setRowHeight(20);
		tblJourneyOverview.setRowMargin(2);
		tblJourneyOverview.setAutoCreateRowSorter(true);
		tblJourneyOverview.setBorder(null);
		tblJourneyOverview.setDragEnabled(true);
		tblJourneyOverview.setFillsViewportHeight(true);
		tblJourneyOverview.setRowSelectionAllowed(false);
		tblJourneyOverview.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblJourneyOverview.setShowVerticalLines(false);
		/*
		 * Event when mouse clicks on row ( row is selected )
		 */
		tblJourneyOverview.getSelectionModel().addListSelectionListener( new TableOverviewListSelectionListener( this ) );
		scrollPane.setViewportView(tblJourneyOverview);
		
		JPanel panel = new JPanel();
		initialContentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		
		JLabel lblReisenFiltern = new JLabel(Messages.getString("ViewStart.9")); //$NON-NLS-1$
		lblReisenFiltern.setFont(new Font(Messages.getString("ViewStart.10"), Font.BOLD, 13)); //$NON-NLS-1$
		panel.add(lblReisenFiltern);
		
		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				new FilterListControler(viewStart);
			}
		});
		this.txtFilter.setFont(new Font(Messages.getString("ViewStart.11"), Font.PLAIN, 13)); //$NON-NLS-1$
		panel.add(txtFilter);
		txtFilter.setColumns(15);
		
		infoAboutTravelPane = new JPanel();
		infoAboutTravelPane.setVisible(false);
		infoAboutTravelPane.setPreferredSize(new Dimension(10, 180));
		initialContentPane.add(infoAboutTravelPane, BorderLayout.SOUTH);
		infoAboutTravelPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewStart.12")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewStart.13")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblInfo = new JLabel(Messages.getString("ViewStart.14")); //$NON-NLS-1$
		lblInfo.setFont(new Font(Messages.getString("ViewStart.15"), Font.BOLD, 20)); //$NON-NLS-1$
		infoAboutTravelPane.add(lblInfo, Messages.getString("ViewStart.16")); //$NON-NLS-1$
		
		JLabel lblZiel = new JLabel(Messages.getString("ViewStart.17")); //$NON-NLS-1$
		lblZiel.setFont(new Font(Messages.getString("ViewStart.18"), Font.BOLD, 13)); //$NON-NLS-1$
		infoAboutTravelPane.add(lblZiel, Messages.getString("ViewStart.19")); //$NON-NLS-1$
		
		JLabel lblAbfahrtszeitpunkt = new JLabel(Messages.getString("ViewStart.20")); //$NON-NLS-1$
		lblAbfahrtszeitpunkt.setFont(new Font(Messages.getString("ViewStart.21"), Font.BOLD, 13)); //$NON-NLS-1$
		infoAboutTravelPane.add(lblAbfahrtszeitpunkt, Messages.getString("ViewStart.22")); //$NON-NLS-1$
		
		txtTarget = new JTextField();
		this.txtTarget.setFont(new Font(Messages.getString("ViewStart.23"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtTarget.setEditable(false);
		infoAboutTravelPane.add(txtTarget, Messages.getString("ViewStart.24")); //$NON-NLS-1$
		txtTarget.setColumns(10);
		
		txtDeparture = new JTextField();
		this.txtDeparture.setFont(new Font(Messages.getString("ViewStart.25"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtDeparture.setEditable(false);
		infoAboutTravelPane.add(txtDeparture, Messages.getString("ViewStart.26")); //$NON-NLS-1$
		txtDeparture.setColumns(10);
		
		JLabel lblCountry = new JLabel(Messages.getString("ViewStart.27")); //$NON-NLS-1$
		lblCountry.setFont(new Font(Messages.getString("ViewStart.28"), Font.BOLD, 13)); //$NON-NLS-1$
		infoAboutTravelPane.add(lblCountry, Messages.getString("ViewStart.29")); //$NON-NLS-1$
		
		JLabel lblGendertAm = new JLabel(Messages.getString("ViewStart.30")); //$NON-NLS-1$
		lblGendertAm.setFont(new Font(Messages.getString("ViewStart.31"), Font.BOLD, 13)); //$NON-NLS-1$
		infoAboutTravelPane.add(lblGendertAm, Messages.getString("ViewStart.32")); //$NON-NLS-1$
		
		txtCountry = new JTextField();
		this.txtCountry.setFont(new Font(Messages.getString("ViewStart.33"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtCountry.setEditable(false);
		infoAboutTravelPane.add(txtCountry, Messages.getString("ViewStart.34")); //$NON-NLS-1$
		txtCountry.setColumns(10);
		
		txtJounreyEnd = new JTextField();
		this.txtJounreyEnd.setFont(new Font(Messages.getString("ViewStart.35"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtJounreyEnd.setEditable(false);
		infoAboutTravelPane.add(txtJounreyEnd, Messages.getString("ViewStart.36")); //$NON-NLS-1$
		txtJounreyEnd.setColumns(10);
	}
	
	/**
	 * @return the infoAboutTravelPane
	 */
	public JPanel getInfoAboutTravelPane() {
		return infoAboutTravelPane;
	}
	
	String getCurrentDate() {	
		SimpleDateFormat formatter = new SimpleDateFormat (Messages.getString("ViewStart.37")); //$NON-NLS-1$
		Date currentTime = new Date();
		return formatter.format(currentTime).toString();
	}
	
	public JButton getBtnRemoveJourney() {
		return btnRemoveJourney;
	}
	
	public JButton getBtnShowJourney() {
		return btnShowJourney;
	}
	
	public JPanel getViewStart(){
		return panelViewStart;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	public ViewWrapperWindow getViewWrapper() {
		return wrapperView;
	}
	 
	 public JTextField getTxtTarget() {
		 return txtTarget;
	 }

	/**
	 * @return the txtFilter
	 */
	public JTextField getTxtFilter() {
		return txtFilter;
	}

	/**
	 * @return the tblJourneyOverview
	 */
	public JTable getTblJourneyOverview() {
		return tblJourneyOverview;
	}

	/**
	 * @return the txtDeparture
	 */
	public JTextField getTxtDeparture() {
		return txtDeparture;
	}

	/**
	 * @return the txtCountry
	 */
	public JTextField getTxtCountry() {
		return txtCountry;
	}

	/**
	 * @return the txtJounreyEnd
	 */
	public JTextField getTxtJounreyEnd() {
		return txtJounreyEnd;
	}
	
	public GeneralInformationModel[] getGeneralInformationArray() {
		return generalInformationArray;
	}
	
	public void setGeneralInformationArray( GeneralInformationModel[] generalInformationArray ) {
		this.generalInformationArray = generalInformationArray;
	}
	
}
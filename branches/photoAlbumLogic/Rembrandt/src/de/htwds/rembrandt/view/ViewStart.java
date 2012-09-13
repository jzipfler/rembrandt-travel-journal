package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import de.htwds.rembrandt.controler.viewStartController.LoadWizzardActionListener;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler 2012-09-12 )
 */
public class ViewStart extends JPanel {

	private ViewWrapperWindow wrapperView;


	private JPanel panelViewStart;
	private JTextField txtFilter;
	private JTable tblJourneyOverview;
	private DefaultTableModel tableModel;
	private String[] tableTitles;
	private Vector<String> tableDataVector;
	private JButton btnRemoveJourney;
	private JTextField txtTarget;
	private JTextField txtDeparture;
	private JTextField txtCountry;
	private JTextField txtJounreyEnd;
	private JPanel infoAboutTravelPane;


	/**
	 * Create the frame.
	 */
	public ViewStart( ViewWrapperWindow wrapperView ) {
		
		this.wrapperView = wrapperView;
		
//			setTitle("Mainmenu Travel Journal Software");
		setName("Mainmenu Journey Log");
		setMinimumSize(new Dimension(640, 480));
		setBounds(100, 100, 640, 480);

		panelViewStart = new JPanel();
		this.panelViewStart.setPreferredSize(new Dimension(607, 376));
		this.panelViewStart.setMinimumSize(new Dimension(440, 440));
		panelViewStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelViewStart.setLayout(new BorderLayout(0, 0));
//			setContentPane(contentPane);

		JPanel quicklunchPanel = new JPanel();
		quicklunchPanel.setPreferredSize(new Dimension(180, 10));
		quicklunchPanel.setMinimumSize(new Dimension(135, 10));
		quicklunchPanel.setMaximumSize(new Dimension(135, 32767));
		panelViewStart.add(quicklunchPanel, BorderLayout.WEST);
		
		JButton btnCreateJourney = new JButton("Reise anlegen");
		btnCreateJourney.setFont(new Font("Arial", Font.BOLD, 13));
		btnCreateJourney.setPreferredSize(new Dimension(150, 25));
		btnCreateJourney.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCreateJourney.addActionListener( new LoadWizzardActionListener(this));
		
		quicklunchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		quicklunchPanel.add(btnCreateJourney);
		
		btnRemoveJourney = new JButton("Reise entfernen");
		this.btnRemoveJourney.setFont(new Font("Arial", Font.BOLD, 13));
		btnRemoveJourney.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRemoveJourney.setPreferredSize(new Dimension(150, 25));
		btnRemoveJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTableRow(null);
			}
		});
		btnRemoveJourney.setEnabled(false);
		quicklunchPanel.add(btnRemoveJourney);
		
		JPanel initialContentPane = new JPanel();
		panelViewStart.add(initialContentPane, BorderLayout.CENTER);
		initialContentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		initialContentPane.add(scrollPane);
		
		tableTitles = new String[]{ "Reise:" };
		tableModel = new DefaultTableModel( tableTitles, 0);
		tblJourneyOverview = new JTable( tableModel ){
			/**
			 * Ermöglicht Alighment = Rechts
			 */
			private static final long serialVersionUID = 1L;
			DefaultTableCellRenderer defaultRendererTest = new DefaultTableCellRenderer(); {
				defaultRendererTest.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			public TableCellRenderer getCellRenderer(int arg0, int arg1){
				return defaultRendererTest;
			}
		};
		this.tblJourneyOverview.setFont(new Font("Arial", Font.PLAIN, 13));
		tblJourneyOverview.setRowHeight(20);
		tblJourneyOverview.setRowMargin(2);
		tblJourneyOverview.setAutoCreateRowSorter(true);
		tblJourneyOverview.setBorder(null);
		tblJourneyOverview.setDragEnabled(true);
		tblJourneyOverview.setFillsViewportHeight(true);
		tblJourneyOverview.setRowSelectionAllowed(false);
		tblJourneyOverview.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblJourneyOverview.setShowVerticalLines(false);
		scrollPane.setViewportView(tblJourneyOverview);
		
		JPanel panel = new JPanel();
		initialContentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		
		JLabel lblReisenFiltern = new JLabel("Reisen filtern: ");
		lblReisenFiltern.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(lblReisenFiltern);
		
		txtFilter = new JTextField();
		this.txtFilter.setFont(new Font("Arial", Font.PLAIN, 13));
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
				ColumnSpec.decode("max(50dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Arial", Font.BOLD, 20));
		infoAboutTravelPane.add(lblInfo, "4, 2");
		
		JLabel lblZiel = new JLabel("Ziel");
		lblZiel.setFont(new Font("Arial", Font.BOLD, 13));
		infoAboutTravelPane.add(lblZiel, "4, 4");
		
		JLabel lblAbfahrtszeitpunkt = new JLabel("Abfahrtszeitpunkt");
		lblAbfahrtszeitpunkt.setFont(new Font("Arial", Font.BOLD, 13));
		infoAboutTravelPane.add(lblAbfahrtszeitpunkt, "6, 4");
		
		txtTarget = new JTextField();
		this.txtTarget.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTarget.setEditable(false);
		infoAboutTravelPane.add(txtTarget, "4, 6, fill, default");
		txtTarget.setColumns(10);
		
		txtDeparture = new JTextField();
		this.txtDeparture.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDeparture.setEditable(false);
		infoAboutTravelPane.add(txtDeparture, "6, 6, fill, default");
		txtDeparture.setColumns(10);
		
		JLabel lblCountry = new JLabel("Land");
		lblCountry.setFont(new Font("Arial", Font.BOLD, 13));
		infoAboutTravelPane.add(lblCountry, "4, 10");
		
		JLabel lblGendertAm = new JLabel("Abreisezeitpunkt");
		lblGendertAm.setFont(new Font("Arial", Font.BOLD, 13));
		infoAboutTravelPane.add(lblGendertAm, "6, 10");
		
		txtCountry = new JTextField();
		this.txtCountry.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCountry.setEditable(false);
		infoAboutTravelPane.add(txtCountry, "4, 12, fill, default");
		txtCountry.setColumns(10);
		
		txtJounreyEnd = new JTextField();
		this.txtJounreyEnd.setFont(new Font("Arial", Font.PLAIN, 13));
		txtJounreyEnd.setEditable(false);
		infoAboutTravelPane.add(txtJounreyEnd, "6, 12, fill, default");
		txtJounreyEnd.setColumns(10);
	}
	
	void addTableRow( String item ){
		//int size = tableModel.getColumnCount();
		tableDataVector = new Vector<String>();
		tableDataVector.add( item );
		//tableDataVector.add( getCurrentDate() );
		
		tableModel.addRow(tableDataVector);

		btnRemoveJourney.setEnabled(true);
	}
	
	void removeTableRow( String item ){
		int size = tableModel.getRowCount();
		//int index = (int)(Math.random() * size);
		tableModel.removeRow( size - 1 );
		
		btnRemoveJourney.setEnabled( size > 1 );	
	}
	
	String getCurrentDate() {	
		SimpleDateFormat formatter = new SimpleDateFormat ("dd.MM.yyyy 'um' HH:mm 'Uhr' ");
		Date currentTime = new Date();
		return formatter.format(currentTime).toString();
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
}
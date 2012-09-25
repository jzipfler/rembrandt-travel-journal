package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import de.htwds.rembrandt.components.JTravelInformationTextfield;
import de.htwds.rembrandt.controler.wizzardControler.readInputData;
import de.htwds.rembrandt.exception.WizzardInputException;

/**
 * Diese Klasse implementiert den Wizzard zur Sammlung der Reisedaten
 * 
 * @author Daniel
 * @version ( Jan Zipfler 2012-09-16 )
 */
public class ViewWizzard extends JFrame {
	
	private ViewStart viewStart;
	private ViewWizzard wizzard;
	
	private JPanel pnlQuestionCards;
	private JTravelInformationTextfield txtInputCountry;
	private JTextField txtInputCity;
	private JTravelInformationTextfield txtDate;
	private JTextField txtEndDate;
	private JPanel pnlCards;
	private JPanel pnlFirstView;
	private JPanel pnlSecondView;
	private JPanel pnlThirdView;
	private JButton btnBack;
	private JButton btnNext;
	private JTextField txtStartArrivalInput;
	private JTextField txtDestinationArrivalInput;
	private JTextField txtDepartureStartInput;
	private JTextField txtDepartureDestinationInput;
	private JComboBox cboOptions;
	private String extension;
	private JLabel lblStartArrival;
	private JLabel lblDestinationArrival;
	private JLabel lblDepartureStart;
	private JLabel lblDepartureDestination;
	
	//Konstanten und Felder
	private int cardNumber;
	private static final int FIRST  = 0;
	private static final int SECOND = 1;
	private static final int THIRD  = 2;
	private static final int LAST   = 3; 
	private readInputData controler;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWizzard frame = new ViewWizzard( null );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ViewWizzard( ViewStart viewStart ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewWizzard.class.getResource(Messages.getString("ViewWizzard.0")))); //$NON-NLS-1$
		
		this.wizzard = this;
		this.viewStart = viewStart;
		setLocationRelativeTo(viewStart);
		setVisible(true);
		
		setFont(new Font(Messages.getString("ViewWizzard.1"), Font.PLAIN, 12)); //$NON-NLS-1$
		cardNumber = 0;
		controler = new readInputData(this);
		setTitle(Messages.getString("ViewWizzard.2")); //$NON-NLS-1$
		setMinimumSize(new Dimension(640, 480));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 497);
		pnlQuestionCards = new JPanel();
		pnlQuestionCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlQuestionCards);
		pnlQuestionCards.setLayout(new BorderLayout(0, 0));
		
		pnlCards = new JPanel();
		pnlQuestionCards.add(pnlCards, BorderLayout.CENTER);
		pnlCards.setLayout(new CardLayout(0, 0));
		
		pnlFirstView = new JPanel();
		pnlCards.add(pnlFirstView, Messages.getString("ViewWizzard.3")); //$NON-NLS-1$
		pnlFirstView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent = new JPanel();
		pnlFirstView.add(pnlViewContent, BorderLayout.CENTER);
		pnlViewContent.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine = new JLabel(Messages.getString("ViewWizzard.4")); //$NON-NLS-1$
		lblHeadLine.setSize(new Dimension(67, 17));
		lblHeadLine.setMaximumSize(new Dimension(67, 20));
		lblHeadLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeadLine.setFont(new Font(Messages.getString("ViewWizzard.5"), Font.BOLD, 15)); //$NON-NLS-1$
		pnlViewContent.add(lblHeadLine, BorderLayout.NORTH);
		
		JPanel pnlContainer = new JPanel();
		pnlViewContent.add(pnlContainer, BorderLayout.CENTER);
		pnlContainer.setLayout(new GridLayout(2, 0, 0, 0));
		
		JTextPane txtpnExplanation = new JTextPane();
		pnlContainer.add(txtpnExplanation);
		txtpnExplanation.setFont(new Font(Messages.getString("ViewWizzard.6"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtpnExplanation.setSelectedTextColor(Color.BLACK);
		txtpnExplanation.setSelectionColor(Color.WHITE);
		txtpnExplanation.setText(Messages.getString("ViewWizzard.7")); //$NON-NLS-1$
		txtpnExplanation.setEditable(false);
		
		JPanel pnlQuestion = new JPanel();
		pnlContainer.add(pnlQuestion);
		pnlQuestion.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.8")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.9")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.10")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.11")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.12")),}, //$NON-NLS-1$
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLocation = new JLabel(Messages.getString("ViewWizzard.13")); //$NON-NLS-1$
		lblLocation.setFont(new Font(Messages.getString("ViewWizzard.14"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlQuestion.add(lblLocation, Messages.getString("ViewWizzard.15")); //$NON-NLS-1$
		
		JLabel lblCountry = new JLabel(Messages.getString("ViewWizzard.16")); //$NON-NLS-1$
		lblCountry.setFont(new Font(Messages.getString("ViewWizzard.17"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlQuestion.add(lblCountry, Messages.getString("ViewWizzard.18")); //$NON-NLS-1$
		
		JLabel lblCity = new JLabel(Messages.getString("ViewWizzard.19")); //$NON-NLS-1$
		lblCity.setFont(new Font(Messages.getString("ViewWizzard.20"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlQuestion.add(lblCity, Messages.getString("ViewWizzard.21")); //$NON-NLS-1$
		
		txtInputCountry = new JTravelInformationTextfield();
		txtInputCountry.setFont(new Font(Messages.getString("ViewWizzard.22"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlQuestion.add(txtInputCountry, Messages.getString("ViewWizzard.23")); //$NON-NLS-1$
		txtInputCountry.setColumns(10);
		
		txtInputCity = new JTextField();
		txtInputCity.setFont(new Font(Messages.getString("ViewWizzard.24"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlQuestion.add(txtInputCity, Messages.getString("ViewWizzard.25")); //$NON-NLS-1$
		txtInputCity.setColumns(10);
		
		pnlSecondView = new JPanel();
		pnlCards.add(pnlSecondView, Messages.getString("ViewWizzard.26")); //$NON-NLS-1$
		pnlSecondView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent_1 = new JPanel();
		pnlSecondView.add(pnlViewContent_1, BorderLayout.CENTER);
		pnlViewContent_1.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine_1 = new JLabel(Messages.getString("ViewWizzard.27")); //$NON-NLS-1$
		lblHeadLine_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine_1.setFont(new Font(Messages.getString("ViewWizzard.28"), Font.BOLD, 15)); //$NON-NLS-1$
		pnlViewContent_1.add(lblHeadLine_1, BorderLayout.NORTH);
		
		JPanel pnlContainer_1 = new JPanel();
		pnlContainer_1.setFont(new Font(Messages.getString("ViewWizzard.29"), Font.PLAIN, 11)); //$NON-NLS-1$
		pnlViewContent_1.add(pnlContainer_1, BorderLayout.CENTER);
		pnlContainer_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant(Messages.getString("ViewWizzard.30"), true), Sizes.constant(Messages.getString("ViewWizzard.31"), true)), 0), //$NON-NLS-1$ //$NON-NLS-2$
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant(Messages.getString("ViewWizzard.32"), true), Sizes.constant(Messages.getString("ViewWizzard.33"), true)), 1), //$NON-NLS-1$ //$NON-NLS-2$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant(Messages.getString("ViewWizzard.34"), true), Sizes.constant(Messages.getString("ViewWizzard.35"), true)), 1), //$NON-NLS-1$ //$NON-NLS-2$
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant(Messages.getString("ViewWizzard.36"), true), Sizes.constant(Messages.getString("ViewWizzard.37"), true)), 0),}, //$NON-NLS-1$ //$NON-NLS-2$
			new RowSpec[] {
				RowSpec.decode(Messages.getString("ViewWizzard.38")), //$NON-NLS-1$
				RowSpec.decode(Messages.getString("ViewWizzard.39")), //$NON-NLS-1$
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewWizzard.40")), //$NON-NLS-1$
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewWizzard.41")), //$NON-NLS-1$
				RowSpec.decode(Messages.getString("ViewWizzard.42")), //$NON-NLS-1$
				RowSpec.decode(Messages.getString("ViewWizzard.43")), //$NON-NLS-1$
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewWizzard.44")), //$NON-NLS-1$
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewWizzard.45")), //$NON-NLS-1$
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewWizzard.46")),})); //$NON-NLS-1$
		
		JLabel lblDateSection = new JLabel(Messages.getString("ViewWizzard.47")); //$NON-NLS-1$
		lblDateSection.setFont(new Font(Messages.getString("ViewWizzard.48"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblDateSection, Messages.getString("ViewWizzard.49")); //$NON-NLS-1$
		
		JLabel lblDate = new JLabel(Messages.getString("ViewWizzard.50")); //$NON-NLS-1$
		lblDate.setFont(new Font(Messages.getString("ViewWizzard.51"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblDate, Messages.getString("ViewWizzard.52")); //$NON-NLS-1$
		
		JLabel lblEndDate = new JLabel(Messages.getString("ViewWizzard.53")); //$NON-NLS-1$
		lblEndDate.setFont(new Font(Messages.getString("ViewWizzard.54"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblEndDate, Messages.getString("ViewWizzard.55")); //$NON-NLS-1$
		
		txtDate = new JTravelInformationTextfield();
		txtDate.setFont(new Font(Messages.getString("ViewWizzard.56"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_1.add(txtDate, Messages.getString("ViewWizzard.57")); //$NON-NLS-1$
		txtDate.setColumns(10);
		
		txtEndDate = new JTextField();
		txtEndDate.setFont(new Font(Messages.getString("ViewWizzard.58"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_1.add(txtEndDate, Messages.getString("ViewWizzard.59")); //$NON-NLS-1$
		txtEndDate.setColumns(10);
		
		JLabel lblTravelOptions = new JLabel(Messages.getString("ViewWizzard.60")); //$NON-NLS-1$
		lblTravelOptions.setFont(new Font(Messages.getString("ViewWizzard.61"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblTravelOptions, Messages.getString("ViewWizzard.62")); //$NON-NLS-1$
		
		JPanel pnlSubContainer = new JPanel();
		pnlContainer_1.add(pnlSubContainer, Messages.getString("ViewWizzard.63")); //$NON-NLS-1$
		pnlSubContainer.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.64")),}, //$NON-NLS-1$
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		cboOptions = new JComboBox();
		cboOptions.setFont(new Font(Messages.getString("ViewWizzard.65"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlSubContainer.add(cboOptions, Messages.getString("ViewWizzard.66")); //$NON-NLS-1$
		cboOptions.setSize(new Dimension(50, 20));
		cboOptions.setPreferredSize(new Dimension(50, 20));
		cboOptions.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("ViewWizzard.67"), Messages.getString("ViewWizzard.68"), Messages.getString("ViewWizzard.69"), Messages.getString("ViewWizzard.70"), Messages.getString("ViewWizzard.71"), Messages.getString("ViewWizzard.72"), Messages.getString("ViewWizzard.73")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		
		JLabel lblHeadlineNote = new JLabel(Messages.getString("ViewWizzard.74")); //$NON-NLS-1$
		lblHeadlineNote.setFont(new Font(Messages.getString("ViewWizzard.75"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblHeadlineNote, Messages.getString("ViewWizzard.76")); //$NON-NLS-1$
		
		JLabel lblNote = new JLabel(Messages.getString("ViewWizzard.77")); //$NON-NLS-1$
		lblNote.setFont(new Font(Messages.getString("ViewWizzard.78"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_1.add(lblNote, Messages.getString("ViewWizzard.79")); //$NON-NLS-1$
		
		pnlThirdView = new JPanel();
		pnlThirdView.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				
			}
		});
		pnlCards.add(pnlThirdView, Messages.getString("ViewWizzard.80")); //$NON-NLS-1$
		pnlThirdView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent_2 = new JPanel();
		pnlThirdView.add(pnlViewContent_2, BorderLayout.CENTER);
		pnlViewContent_2.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine_2 = new JLabel(Messages.getString("ViewWizzard.81")); //$NON-NLS-1$
		pnlViewContent_2.add(lblHeadLine_2, BorderLayout.NORTH);
		lblHeadLine_2.setFont(new Font(Messages.getString("ViewWizzard.82"), Font.BOLD, 15)); //$NON-NLS-1$
		lblHeadLine_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pnlContainer_2 = new JPanel();
		pnlViewContent_2.add(pnlContainer_2, BorderLayout.CENTER);
		pnlContainer_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.83")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewWizzard.84")), //$NON-NLS-1$
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblArrivalTxt = new JLabel(Messages.getString("ViewWizzard.85")); //$NON-NLS-1$
		lblArrivalTxt.setFont(new Font(Messages.getString("ViewWizzard.86"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblArrivalTxt, Messages.getString("ViewWizzard.87")); //$NON-NLS-1$
		
		lblStartArrival = new JLabel(Messages.getString("ViewWizzard.88") + extension); //$NON-NLS-1$
		lblStartArrival.setFont(new Font(Messages.getString("ViewWizzard.89"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblStartArrival, Messages.getString("ViewWizzard.90")); //$NON-NLS-1$
		
		lblDestinationArrival = new JLabel(Messages.getString("ViewWizzard.91") + extension); //$NON-NLS-1$
		lblDestinationArrival.setFont(new Font(Messages.getString("ViewWizzard.92"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblDestinationArrival, Messages.getString("ViewWizzard.93")); //$NON-NLS-1$
		
		txtStartArrivalInput = new JTextField();
		txtStartArrivalInput.setFont(new Font(Messages.getString("ViewWizzard.94"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(txtStartArrivalInput, Messages.getString("ViewWizzard.95")); //$NON-NLS-1$
		txtStartArrivalInput.setColumns(10);
		
		txtDestinationArrivalInput = new JTextField();
		txtDestinationArrivalInput.setFont(new Font(Messages.getString("ViewWizzard.96"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(txtDestinationArrivalInput, Messages.getString("ViewWizzard.97")); //$NON-NLS-1$
		txtDestinationArrivalInput.setColumns(10);
		
		JLabel lblDeparture = new JLabel(Messages.getString("ViewWizzard.98")); //$NON-NLS-1$
		lblDeparture.setFont(new Font(Messages.getString("ViewWizzard.99"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblDeparture, Messages.getString("ViewWizzard.100")); //$NON-NLS-1$
		
		lblDepartureStart = new JLabel(Messages.getString("ViewWizzard.101") + extension); //$NON-NLS-1$
		lblDepartureStart.setFont(new Font(Messages.getString("ViewWizzard.102"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblDepartureStart, Messages.getString("ViewWizzard.103")); //$NON-NLS-1$
		
		lblDepartureDestination = new JLabel(Messages.getString("ViewWizzard.104") + extension); //$NON-NLS-1$
		lblDepartureDestination.setFont(new Font(Messages.getString("ViewWizzard.105"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(lblDepartureDestination, Messages.getString("ViewWizzard.106")); //$NON-NLS-1$
		
		txtDepartureStartInput = new JTextField();
		txtDepartureStartInput.setFont(new Font(Messages.getString("ViewWizzard.107"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(txtDepartureStartInput, Messages.getString("ViewWizzard.108")); //$NON-NLS-1$
		txtDepartureStartInput.setColumns(10);
		
		txtDepartureDestinationInput = new JTextField();
		txtDepartureDestinationInput.setFont(new Font(Messages.getString("ViewWizzard.109"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContainer_2.add(txtDepartureDestinationInput, Messages.getString("ViewWizzard.110")); //$NON-NLS-1$
		txtDepartureDestinationInput.setColumns(10);
		
		JPanel pnlNavigation = new JPanel();
		pnlQuestionCards.add(pnlNavigation, BorderLayout.SOUTH);
		pnlNavigation.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlNavigation.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant(Messages.getString("ViewWizzard.111"), true), Sizes.constant(Messages.getString("ViewWizzard.112"), true)), 1), //$NON-NLS-1$ //$NON-NLS-2$
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant(Messages.getString("ViewWizzard.113"), true), Sizes.constant(Messages.getString("ViewWizzard.114"), true)), 1), //$NON-NLS-1$ //$NON-NLS-2$
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant(Messages.getString("ViewWizzard.115"), true), Sizes.constant(Messages.getString("ViewWizzard.116"), true)), 1),}, //$NON-NLS-1$ //$NON-NLS-2$
			new RowSpec[] {
				RowSpec.decode(Messages.getString("ViewWizzard.117")),})); //$NON-NLS-1$
		
		btnNext = new JButton(Messages.getString("ViewWizzard.118")); //$NON-NLS-1$
		btnNext.setFont(new Font(Messages.getString("ViewWizzard.119"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cardNumber < LAST){
					cardNumber += 1;
				}
				switch (cardNumber){
				case FIRST:
					break;
				case SECOND:
					try{
						if(txtInputCountry.getText().trim().length() == 0 || txtInputCountry.getText() == null)
							throw new WizzardInputException(Messages.getString("ViewWizzard.120") + WizzardInputException.ERROR_FIELD); //$NON-NLS-1$
						pnlSecondView.setVisible(true);
						pnlFirstView.setVisible(false);
					} catch(Exception e){
						JOptionPane.showMessageDialog(	wizzard,
								e.getMessage(),
								WizzardInputException.MSG_ERROR_OCCURED,
								JOptionPane.ERROR_MESSAGE );
						btnBack.setText(Messages.getString("ViewWizzard.121")); //$NON-NLS-1$
						pnlSecondView.setVisible(false);
						pnlFirstView.setVisible(true);
						cardNumber --;
					}
					break;
				case THIRD:
					getChoosed();
					try{
						if(txtDate.getText().trim().length() == 0 || txtInputCountry.getText() == null)
							throw new WizzardInputException(Messages.getString("ViewWizzard.122") + WizzardInputException.ERROR_FIELD); //$NON-NLS-1$
						pnlThirdView.setVisible(true);
						pnlSecondView.setVisible(false);
					} catch(Exception e){
						JOptionPane.showMessageDialog(	wizzard,
								e.getMessage(),
								WizzardInputException.MSG_ERROR_OCCURED,
								JOptionPane.ERROR_MESSAGE );
						pnlThirdView.setVisible(false);
						pnlSecondView.setVisible(true);
						cardNumber --;
					}
					break;
				case LAST:
					controler.readStoreAndExit();
					break;
				default:
					break;
				}
				if (cardNumber != FIRST){
					btnBack.setText(Messages.getString("ViewWizzard.123")); //$NON-NLS-1$
				}
				if (cardNumber == THIRD){
					btnNext.setText(Messages.getString("ViewWizzard.124")); //$NON-NLS-1$
				}
			}
		});
		
		btnBack = new JButton(Messages.getString("ViewWizzard.125")); //$NON-NLS-1$
		btnBack.setFont(new Font(Messages.getString("ViewWizzard.126"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cardNumber > FIRST){
					cardNumber -= 1;
				} else {
					dispose();
				}
				switch (cardNumber){
				case FIRST:
					pnlFirstView.setVisible(true);
					pnlSecondView.setVisible(false);
					break;
				case SECOND:
					pnlSecondView.setVisible(true);
					pnlFirstView.setVisible(false);
					break;
				case THIRD:
					pnlThirdView.setVisible(true);
					pnlSecondView.setVisible(false);
					break;
				default:
					break;
				}
				if (cardNumber == FIRST){
					btnBack.setText(Messages.getString("ViewWizzard.127")); //$NON-NLS-1$
				}
				if (cardNumber != THIRD){
					btnNext.setText(Messages.getString("ViewWizzard.128")); //$NON-NLS-1$
				}
			}
		});
		pnlNavigation.add(btnBack, Messages.getString("ViewWizzard.129")); //$NON-NLS-1$
		btnBack.setSize(new Dimension(80, 23));
		btnBack.setMaximumSize(new Dimension(80, 23));
		btnBack.setMinimumSize(new Dimension(80, 23));
		pnlNavigation.add(btnNext, Messages.getString("ViewWizzard.130")); //$NON-NLS-1$
		btnNext.setSize(new Dimension(80, 23));
		btnNext.setMaximumSize(new Dimension(80, 23));
		btnNext.setMinimumSize(new Dimension(80, 23));
	}

	
	//Getter to read the input
	public String getCity(){
		return txtInputCity.getText();
	}
	
	public String getCountry(){
		return txtInputCountry.getText();
	}
	
	public String getEndDate(){
		return txtEndDate.getText();
	}
	
	public String getDate(){
		return txtDate.getText();
	}
	
	public String getArrivalStart(){
		return txtStartArrivalInput.getText();
	}
	
	public String getArrivalDestination(){
		return txtDestinationArrivalInput.getText();
	}
	
	public String getDepartureStart(){
		return txtDepartureStartInput.getText();
	}
	
	public String getDepartureDestination(){
		return txtDepartureDestinationInput.getText();
	}
	
	public int getOption(){
		return cboOptions.getSelectedIndex();
	}
	
	public JLabel getLblStartArrival() {
		return lblStartArrival;
	}
	
	public JLabel getLblDestinationArrival() {
		return lblDestinationArrival;
	}

	public JLabel getLblDepartureStart() {
		return lblDepartureStart;
	}

	public JLabel getLblDepartureDestination() {
		return lblDepartureDestination;
	}
	
	private void getChoosed(){
		int choosed = cboOptions.getSelectedIndex();
		switch (choosed){
		case 0:
			extension = Messages.getString("ViewWizzard.131"); //$NON-NLS-1$
			break;
		case 1:
			extension = Messages.getString("ViewWizzard.132"); //$NON-NLS-1$
			break;
		case 2:
			extension = Messages.getString("ViewWizzard.133"); //$NON-NLS-1$
			break;
		case 3:
			extension = Messages.getString("ViewWizzard.134"); //$NON-NLS-1$
			break;
		case 4:
			extension = Messages.getString("ViewWizzard.135"); //$NON-NLS-1$
			break;
		case 5:
			extension = Messages.getString("ViewWizzard.136"); //$NON-NLS-1$
			break;
		case 6:
			extension = Messages.getString("ViewWizzard.137"); //$NON-NLS-1$
			break;
		default:
			extension = null;
		}
		if (extension != null) {
			getLblStartArrival().setText(Messages.getString("ViewWizzard.138") + extension); //$NON-NLS-1$
			getLblDestinationArrival().setText(Messages.getString("ViewWizzard.139") + extension); //$NON-NLS-1$
			getLblDepartureStart().setText(Messages.getString("ViewWizzard.140") + extension); //$NON-NLS-1$
			getLblDepartureDestination().setText(Messages.getString("ViewWizzard.141") + extension); //$NON-NLS-1$
		}
	}
	
	public ViewStart getViewStart() {
		return viewStart;
	}
}

package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.Sizes;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewWizzard extends JFrame {

	private JPanel pnlQuestionCards;
	private JTextField txtInputCountry;
	private JTextField txtInputCity;
	private JTextField txtDate;
	private JTextField txtEndDate;
	private JPanel pnlCards;
	private JPanel pnlSecondView;
	private JButton btnExit;
	private JTextField txtStartArrivalInput;
	private JTextField txtDestinationArrivalInput;
	private JTextField txtDepartureStartInput;
	private JTextField txtDepartureDestinationInput;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWizzard frame = new ViewWizzard();
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
	public ViewWizzard() {
		setTitle("Reise anlegen");
		setMinimumSize(new Dimension(640, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 497);
		pnlQuestionCards = new JPanel();
		pnlQuestionCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlQuestionCards);
		pnlQuestionCards.setLayout(new BorderLayout(0, 0));
		
		pnlCards = new JPanel();
		pnlQuestionCards.add(pnlCards, BorderLayout.CENTER);
		pnlCards.setLayout(new CardLayout(0, 0));
		
		JPanel pnlFirstView = new JPanel();
		pnlCards.add(pnlFirstView, "name_17364743092986");
		pnlFirstView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent = new JPanel();
		pnlFirstView.add(pnlViewContent, BorderLayout.CENTER);
		pnlViewContent.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine = new JLabel("WILLKOMMEN");
		lblHeadLine.setSize(new Dimension(67, 17));
		lblHeadLine.setMaximumSize(new Dimension(67, 20));
		lblHeadLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeadLine.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlViewContent.add(lblHeadLine, BorderLayout.NORTH);
		
		JPanel pnlContainer = new JPanel();
		pnlViewContent.add(pnlContainer, BorderLayout.CENTER);
		pnlContainer.setLayout(new GridLayout(2, 0, 0, 0));
		
		JTextPane txtpnExplanation = new JTextPane();
		pnlContainer.add(txtpnExplanation);
		txtpnExplanation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnExplanation.setSelectedTextColor(Color.BLACK);
		txtpnExplanation.setSelectionColor(Color.WHITE);
		txtpnExplanation.setText("Dieser Wizzard wird Ihnen helfen eine neue Reise anzulegen.\r\n\r\nDazu werden Ihnen verschiedene Fragen, ihre Reise betreffend gestellt. \r\nSie werden nach Ihrem:\r\n\r\n\t- Datum\r\n\t- Reiseland\r\n\t- Ort\r\n\t- usw.\r\n\r\ngefragt. \r\nDiese Angaben dienen ebenfalls dazu den Reiseeintrag sp\u00E4ter wieder zu finden. Daher sollten die Angaben m\u00F6glichst pr\u00E4zise sein.");
		txtpnExplanation.setEditable(false);
		
		JPanel pnlQuestion = new JPanel();
		pnlContainer.add(pnlQuestion);
		pnlQuestion.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(186dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(186dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
		
		JLabel lblLocation = new JLabel("Land- und Ortsangabe:");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlQuestion.add(lblLocation, "4, 2");
		
		JLabel lblCountry = new JLabel("In welches Land reisen Sie?");
		pnlQuestion.add(lblCountry, "4, 4");
		
		JLabel lblCity = new JLabel("Name des Ortes Ihres Aufenthalts?");
		pnlQuestion.add(lblCity, "8, 4");
		
		txtInputCountry = new JTextField();
		pnlQuestion.add(txtInputCountry, "4, 6");
		txtInputCountry.setColumns(10);
		
		txtInputCity = new JTextField();
		pnlQuestion.add(txtInputCity, "8, 6, fill, default");
		txtInputCity.setColumns(10);
		
		pnlSecondView = new JPanel();
		pnlCards.add(pnlSecondView, "name_17366503517548");
		pnlSecondView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent_1 = new JPanel();
		pnlSecondView.add(pnlViewContent_1, BorderLayout.CENTER);
		pnlViewContent_1.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine_1 = new JLabel("Reiseart und Datum");
		lblHeadLine_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlViewContent_1.add(lblHeadLine_1, BorderLayout.NORTH);
		
		JPanel pnlContainer_1 = new JPanel();
		pnlViewContent_1.add(pnlContainer_1, BorderLayout.CENTER);
		pnlContainer_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("20px", true), Sizes.constant("20px", true)), 0),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("150px", true), Sizes.constant("200px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("150px", true), Sizes.constant("200px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("20px", true), Sizes.constant("20px", true)), 0),},
			new RowSpec[] {
				RowSpec.decode("65px"),
				RowSpec.decode("14px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("62px"),
				RowSpec.decode("14px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),}));
		
		JLabel lblDateSection = new JLabel("Datumsangaben:");
		lblDateSection.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlContainer_1.add(lblDateSection, "4, 2, left, top");
		
		JLabel lblDate = new JLabel("Datum des Reisebeginns?");
		pnlContainer_1.add(lblDate, "4, 4, left, top");
		
		JLabel lblEndDate = new JLabel("Das Ende der Reise?");
		pnlContainer_1.add(lblEndDate, "8, 4, left, top");
		
		txtDate = new JTextField();
		pnlContainer_1.add(txtDate, "4, 6, fill, top");
		txtDate.setColumns(10);
		
		txtEndDate = new JTextField();
		pnlContainer_1.add(txtEndDate, "8, 6, fill, top");
		txtEndDate.setColumns(10);
		
		JLabel lblTravelOptions = new JLabel("Reiseart:");
		lblTravelOptions.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlContainer_1.add(lblTravelOptions, "4, 8, left, top");
		
		JComboBox cboOptions = new JComboBox();
		cboOptions.setSize(new Dimension(50, 20));
		cboOptions.setPreferredSize(new Dimension(50, 20));
		cboOptions.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Bus", "Fahrrad", "Flugzeug", "Motorrad", "Schiff", "Zug"}));
		pnlContainer_1.add(cboOptions, "4, 10, left, top");
		
		JLabel lblHeadlineNote = new JLabel("Hinweise:");
		lblHeadlineNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlContainer_1.add(lblHeadlineNote, "4, 12, left, top");
		
		JLabel lblNote = new JLabel("Die hier angegebene Reiseart beschr\u00E4nkt sich auf den Hauptweg. Ben\u00F6tigte Transfers werden hier nicht ber\u00FCcksichtigt.");
		pnlContainer_1.add(lblNote, "4, 14, 5, 1, left, top");
		
		JPanel pnlThirdView = new JPanel();
		pnlCards.add(pnlThirdView, "name_2758029025195");
		pnlThirdView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlViewContent_2 = new JPanel();
		pnlThirdView.add(pnlViewContent_2, BorderLayout.CENTER);
		pnlViewContent_2.setLayout(new BorderLayout(0, 5));
		
		JLabel lblHeadLine_2 = new JLabel("Details zur Reiseroute");
		pnlViewContent_2.add(lblHeadLine_2, BorderLayout.NORTH);
		lblHeadLine_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeadLine_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pnlContainer_2 = new JPanel();
		pnlViewContent_2.add(pnlContainer_2, BorderLayout.CENTER);
		pnlContainer_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblArrivalTxt = new JLabel("Anreise:");
		lblArrivalTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlContainer_2.add(lblArrivalTxt, "3, 2");
		
		JLabel lblStartArrival = new JLabel("Start ?");
		pnlContainer_2.add(lblStartArrival, "3, 4");
		
		JLabel lblDestinationArrival = new JLabel("Ziel ?");
		pnlContainer_2.add(lblDestinationArrival, "7, 4");
		
		txtStartArrivalInput = new JTextField();
		pnlContainer_2.add(txtStartArrivalInput, "3, 6, fill, default");
		txtStartArrivalInput.setColumns(10);
		
		txtDestinationArrivalInput = new JTextField();
		pnlContainer_2.add(txtDestinationArrivalInput, "7, 6, fill, default");
		txtDestinationArrivalInput.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Abreise:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnlContainer_2.add(lblDeparture, "3, 12");
		
		JLabel lblDepartureStart = new JLabel("Start ?");
		pnlContainer_2.add(lblDepartureStart, "3, 14");
		
		JLabel lblDepartureDestination = new JLabel("Ziel ?");
		pnlContainer_2.add(lblDepartureDestination, "7, 14");
		
		txtDepartureStartInput = new JTextField();
		pnlContainer_2.add(txtDepartureStartInput, "3, 16, fill, default");
		txtDepartureStartInput.setColumns(10);
		
		txtDepartureDestinationInput = new JTextField();
		pnlContainer_2.add(txtDepartureDestinationInput, "7, 16, fill, default");
		txtDepartureDestinationInput.setColumns(10);
		
		JPanel pnlNavigation = new JPanel();
		pnlQuestionCards.add(pnlNavigation, BorderLayout.SOUTH);
		pnlNavigation.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlNavigation.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),
				FormFactory.GROWING_BUTTON_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("75px", true), Sizes.constant("75px", true)), 1),},
			new RowSpec[] {
				RowSpec.decode("23px"),}));
		
		JButton btnNext = new JButton("Weiter");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSecondView.show();
				btnExit.setText("Zur�ck");
			}
		});
		
		btnExit = new JButton("Abbrechen");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		pnlNavigation.add(btnExit, "2, 1");
		btnExit.setSize(new Dimension(80, 23));
		btnExit.setMaximumSize(new Dimension(80, 23));
		btnExit.setMinimumSize(new Dimension(80, 23));
		pnlNavigation.add(btnNext, "4, 1");
		btnNext.setSize(new Dimension(80, 23));
		btnNext.setMaximumSize(new Dimension(80, 23));
		btnNext.setMinimumSize(new Dimension(80, 23));
	}

}

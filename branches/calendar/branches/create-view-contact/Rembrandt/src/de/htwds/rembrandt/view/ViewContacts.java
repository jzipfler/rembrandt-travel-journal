package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.contactViewControler.LoadContactDetailsActionListener;

public class ViewContacts extends JPanel {
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtOther;
	private JButton btnBearbeiten;
	
	private ViewMain frmMainFrame;
	private ViewContactDetails viewContactDetails;

	/**
	 * Create the panel.
	 */
	public ViewContacts() {
		setBorder(new EmptyBorder(2, 4, 2, 2));
		setMinimumSize(new Dimension(440, 440));
		setPreferredSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlListAndButtons = new JPanel();
		pnlListAndButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(pnlListAndButtons, BorderLayout.WEST);
		pnlListAndButtons.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlContactButtons = new JPanel();
		pnlListAndButtons.add(pnlContactButtons, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(180, 22));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlListAndButtons.add(scrollPane, BorderLayout.CENTER);
		
		
		DefaultListModel lstModelContacts;
		lstModelContacts = new DefaultListModel();
				
		
		String[] inhalte = {"testeDieHenneDuSau","test1","test2","test3","test4","test5","test6","test","test",
							"test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"};
		
		for (String string : inhalte) {
			lstModelContacts.addElement(string);
		}
		
		
		/*
		 * 
		 * HIER DIE BINDINGS IMPLEMENTIEREN!!!!!
		 * 
		 */
		
		final JList lstContacts = new JList( lstModelContacts );
		lstContacts.setFont(new Font("Arial", Font.PLAIN, 12));
		lstContacts.setMaximumSize(new Dimension(500, 1000));
		lstContacts.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
//				txtName.setText( GetField.class.toString() );
				txtName.setText( lstContacts.getModel().getElementAt( lstContacts.getSelectedIndex() ).toString() );
			}
		});
		lstContacts.setMinimumSize(new Dimension(50, 408));
		lstContacts.setPreferredSize(new Dimension(50, 408));
		lstContacts.setAutoscrolls(false);
		lstContacts.setVisibleRowCount(5);
		lstContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstContacts);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Arial", Font.BOLD, 13));
		button.setToolTipText("Fügen Sie einen neuen Kontakt hinzu.");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lstContacts.setListData(new String[] { "List" } );
			}
		});
		pnlContactButtons.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1.setToolTipText("Entfernen Sie den aktuell ausgewählten Kontakt.");
		pnlContactButtons.add(button_1);
		
		btnBearbeiten = new JButton("Edit");
		btnBearbeiten.setFont(new Font("Arial", Font.BOLD, 13));
		btnBearbeiten.setToolTipText("Bearbeiten des aktullen Kontaktes");
		pnlContactButtons.add(btnBearbeiten);
		
		JPanel pnlYourContactsLabel = new JPanel();
		pnlListAndButtons.add(pnlYourContactsLabel, BorderLayout.NORTH);
		
		JLabel lblIhreKontakte = new JLabel("Ihre Kontakte:");
		lblIhreKontakte.setFont(new Font("Arial", Font.BOLD, 13));
		pnlYourContactsLabel.add(lblIhreKontakte);
		
		JPanel pnlContactHeader = new JPanel();
		add(pnlContactHeader, BorderLayout.NORTH);
		pnlContactHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPlatzhalter = new JLabel("Kontakte");
		pnlContactHeader.add(lblPlatzhalter);
		lblPlatzhalter.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel pnlInformationsAndChooser = new JPanel();
		pnlInformationsAndChooser.setPreferredSize(new Dimension(180, 10));
		add(pnlInformationsAndChooser, BorderLayout.CENTER);
		pnlInformationsAndChooser.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlWhichContacts = new JPanel();
		FlowLayout fl_pnlWhichContacts = (FlowLayout) pnlWhichContacts.getLayout();
		fl_pnlWhichContacts.setAlignment(FlowLayout.RIGHT);
		pnlInformationsAndChooser.add(pnlWhichContacts, BorderLayout.SOUTH);
		
		JLabel lblAuswahl = new JLabel("Auswahl:");
		lblAuswahl.setFont(new Font("Arial", Font.BOLD, 13));
		pnlWhichContacts.add(lblAuswahl);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		horizontalStrut.setMinimumSize(new Dimension(5, 0));
		pnlWhichContacts.add(horizontalStrut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"private Kontakte", "globale Kontakte", "alle Kontakte"}));
		comboBox.setSelectedIndex(0);
		pnlWhichContacts.add(comboBox);
		
		JPanel pnlContactInformations = new JPanel();
		pnlInformationsAndChooser.add(pnlContactInformations, BorderLayout.CENTER);
		pnlContactInformations.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default):grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.BOLD, 13));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblName, "2, 4, left, default");
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtName, "4, 4, fill, default");
		txtName.setColumns(10);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
		lblTelefonnummer.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefonnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblTelefonnummer, "2, 8, left, default");
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtPhone, "4, 8, fill, default");
		txtPhone.setColumns(10);
		
		JLabel lblIrgendetwas = new JLabel("Irgendetwas:");
		lblIrgendetwas.setFont(new Font("Arial", Font.BOLD, 13));
		lblIrgendetwas.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblIrgendetwas, "2, 12, left, default");
		
		txtOther = new JTextField();
		txtOther.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtOther, "4, 12, fill, default");
		txtOther.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Arial", Font.BOLD, 13));
		lblBeschreibung.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblBeschreibung, "2, 18, left, default");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlContactInformations.add(scrollPane_1, "2, 20, 3, 7, fill, fill");
		
		JTextPane txtpaneDescription = new JTextPane();
		txtpaneDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane_1.setViewportView(txtpaneDescription);
		
	}
	
	public ViewContacts( ViewMain frmMainFrame ){

		this();
//		try {
//			if ( frmMainFrame == null )
//				throw new RuntimeException("ViewContacts: Kein MainFrame");
//		} catch (RuntimeException e) {
//			System.out.println(e);
//		}
		this.frmMainFrame = frmMainFrame;
		this.viewContactDetails = new ViewContactDetails( getParentFrame(), this );
		/*
		 * ActionListener
		 */
		this.btnBearbeiten.addActionListener( new LoadContactDetailsActionListener( viewContactDetails ) );
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
}

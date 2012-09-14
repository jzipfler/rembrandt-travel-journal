package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.controler.contactViewControler.LoadAndClearDetailsActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadContactDetailsActionListener;
import de.htwds.rembrandt.controler.contactViewControler.LoadSelectedContactListSelectionListener;
import de.htwds.rembrandt.controler.contactViewControler.RemoveSelectedContactActionListener;
import de.htwds.rembrandt.controler.contactViewControler.UpdateListControler;
import de.htwds.rembrandt.controler.contactViewControler.UpdateListFromComboBoxActionListener;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

/**
 * 
 * @author Jan Zipfler
 * @version ( Jan Zipfler - 2012-09-14 )
 *
 */
public class ViewContacts extends JPanel {
	
	public static final String STD_CMB_CATEGORY_PRIVATE 	= "private Kontakte";
	public static final String STD_CMB_CATEGORY_GLOBAL 	= "globale Kontakte";
	public static final String STD_CMB_CATEGORY_ALL 		= "alle Kontakte";
	
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtPhone;
	private JTextArea txtAreaDescription;
	
	
	private JButton btnEditContact;
	private JButton btnAddContact;
	private JButton btnDeleteContact;
	
	private JComboBox cmbCategory;
	
	private DefaultListModel lstModelContacts;
	private JList lstContacts;
	
	private ViewMain frmMainFrame;
	private ViewContactDetails viewContactDetails;

	/**
	 * Create the panel.
	 */
	public ViewContacts() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				new UpdateListControler(getViewContacts()).updateList();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
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
		
		lstModelContacts = new DefaultListModel();
		
		/*
		 * USE THIS TO ADD STD VALUES TO THE LIST
		
		String[] inhalte = {"testeDieHenneDuSau","test1","test2","test3","test4","test5","test6","test","test",
							"test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"};
		
		for (String string : inhalte) {
			lstModelContacts.addElement(string);
		}
		
		*/
		
		/*
		 * 
		 * HIER DIE BINDINGS IMPLEMENTIEREN!!!!!
		 * 
		 */
		
		lstContacts = new JList( lstModelContacts );
		lstContacts.setFont(new Font("Arial", Font.PLAIN, 13));
		lstContacts.setMaximumSize(new Dimension(500, 1000));
		lstContacts.setMinimumSize(new Dimension(50, 408));
		lstContacts.setPreferredSize(new Dimension(50, 408));
		lstContacts.setAutoscrolls(false);
		lstContacts.setVisibleRowCount(5);
		lstContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstContacts);
		
		btnAddContact = new JButton("+");
		btnAddContact.setFont(new Font("Arial", Font.BOLD, 13));
		btnAddContact.setToolTipText("Fügen Sie einen neuen Kontakt hinzu.");
		pnlContactButtons.add(btnAddContact);
		
		btnDeleteContact = new JButton("-");
		btnDeleteContact.setFont(new Font("Arial", Font.BOLD, 13));
		btnDeleteContact.setToolTipText("Entfernen Sie den aktuell ausgewählten Kontakt.");
		// only activate it, if a list element is selected.
		if ( lstContacts.isSelectionEmpty() )
			btnDeleteContact.setEnabled(false);
		pnlContactButtons.add(btnDeleteContact);
		
		btnEditContact = new JButton("Edit");
		btnEditContact.setFont(new Font("Arial", Font.BOLD, 13));
		btnEditContact.setToolTipText("Bearbeiten des aktullen Kontaktes");
		// only activate it, if a list element is selected.
		if ( lstContacts.isSelectionEmpty() )
			btnEditContact.setEnabled(false);
		pnlContactButtons.add(btnEditContact);
		
		JPanel pnlYourContactsLabel = new JPanel();
		pnlListAndButtons.add(pnlYourContactsLabel, BorderLayout.NORTH);
		
		JLabel lblIhreKontakte = new JLabel("Ihre Kontakte:");
		lblIhreKontakte.setFont(new Font("Arial", Font.PLAIN, 13));
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
		lblAuswahl.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlWhichContacts.add(lblAuswahl);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		horizontalStrut.setMinimumSize(new Dimension(5, 0));
		pnlWhichContacts.add(horizontalStrut);
		
		cmbCategory = new JComboBox();
		cmbCategory.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbCategory.setModel(new DefaultComboBoxModel(new String[] {	STD_CMB_CATEGORY_PRIVATE, 
																		STD_CMB_CATEGORY_GLOBAL, 
																		STD_CMB_CATEGORY_ALL 
																	} ) );
		cmbCategory.setSelectedIndex(0);
		pnlWhichContacts.add(cmbCategory);
		
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
		lblName.setFont(new Font("Arial", Font.PLAIN, 13));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblName, "2, 4, left, default");
		
		txtName = new JTextField();
		this.txtName.setDisabledTextColor(getForeground());
		this.txtName.setEditable(false);
		this.txtName.setEnabled(false);
		txtName.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtName, "4, 4, fill, default");
		txtName.setColumns(10);
		
		JLabel lblTelefonnummer = new JLabel("E-Mail:");
		lblTelefonnummer.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTelefonnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblTelefonnummer, "2, 8, left, default");
		
		txtMail = new JTextField();
		this.txtMail.setDisabledTextColor(getForeground());
		this.txtMail.setEditable(false);
		this.txtMail.setEnabled(false);
		txtMail.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtMail, "4, 8, fill, default");
		txtMail.setColumns(10);
		
		JLabel lblIrgendetwas = new JLabel("Telefonnr.:");
		lblIrgendetwas.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIrgendetwas.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblIrgendetwas, "2, 12, left, default");
		
		txtPhone = new JTextField();
		this.txtPhone.setDisabledTextColor(getForeground());
		this.txtPhone.setEditable(false);
		this.txtPhone.setEnabled(false);
		txtPhone.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactInformations.add(txtPhone, "4, 12, fill, default");
		txtPhone.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Arial", Font.PLAIN, 13));
		lblBeschreibung.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlContactInformations.add(lblBeschreibung, "2, 18, left, default");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlContactInformations.add(scrollPane_1, "2, 20, 3, 7, fill, fill");
		
		txtAreaDescription = new JTextArea();
		this.txtAreaDescription.setEditable(false);
		this.txtAreaDescription.setLineWrap(true);
		this.txtAreaDescription.setDisabledTextColor(getForeground());
		txtAreaDescription.setEnabled(false);
		txtAreaDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane_1.setViewportView(txtAreaDescription);
		
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
		this.btnEditContact.addActionListener( new LoadContactDetailsActionListener( viewContactDetails ) );
		this.btnAddContact.addActionListener( new LoadAndClearDetailsActionListener( this ) );
		this.btnDeleteContact.addActionListener( new RemoveSelectedContactActionListener(this) );
		
		this.lstContacts.addListSelectionListener( new LoadSelectedContactListSelectionListener( this ) );
		
		
		this.cmbCategory.addActionListener(new UpdateListFromComboBoxActionListener( this ) );
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
	public ViewContacts getViewContacts() {
		return this;
	}
	
	public ViewContactDetails getViewContactDetails(){
		return viewContactDetails;
	}
	
	public DefaultListModel getLstModelContacts() {
		return lstModelContacts;
	}
	public JList getLstContacts() {
		return lstContacts;
	}
	public JComboBox getCmbCategory() {
		return cmbCategory;
	}
	public JButton getBtnDeleteContact() {
		return btnDeleteContact;
	}
	public JButton getBtnEditContact() {
		return btnEditContact;
	}

	/**
	 * @return the txtName
	 */
	public JTextField getTxtName() {
		return txtName;
	}

	/**
	 * @return the txtMail
	 */
	public JTextField getTxtMail() {
		return txtMail;
	}

	/**
	 * @return the txtPhone
	 */
	public JTextField getTxtPhone() {
		return txtPhone;
	}

	/**
	 * @return the txtAreaDescription
	 */
	public JTextArea getTxtAreaDescription() {
		return txtAreaDescription;
	}
}

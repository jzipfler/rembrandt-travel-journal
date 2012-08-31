package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import de.htwds.rembrandt.controler.contactViewControler.LoadContactsActionListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class ViewContactDetails extends JPanel {
	private JButton btnBack;
	private JButton btnUnlock;
	private JTabbedPane pnlTabbedContactDetails;
	private JPanel pnlContactDetailsInformations;
	
	private ViewMain frmMainFrame;
	private ViewContacts viewContacts;
	
	
	private static final String STD_BUTTON_UNLOCK_UNLOCK = "Entsperren";
	private static final String STD_BUTTON_UNLOCK_LOCK = "Speichern und Sperren";
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPostfach;
	private JTextField txtCity;
	private JTextField txtZipPlz;
	private JTextField txtStateProvinz;
	private JTextField txtCountry;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtPrivatMail;
	private JTextField txtBusinessMail;
	private JTextField txtPrivatPhone;
	private JTextField txtBusinessPhone;

	/**
	 * Create the panel.
	 */
	public ViewContactDetails() {
		setBorder(new EmptyBorder(2, 4, 2, 2));
		setPreferredSize(new Dimension(440, 440));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlContactDetailsHeader = new JPanel();
		add(pnlContactDetailsHeader, BorderLayout.NORTH);
		
		JLabel lblKontaktdetails = new JLabel("Kontaktdetails");
		lblKontaktdetails.setFont(new Font("Arial", Font.BOLD, 16));
		pnlContactDetailsHeader.add(lblKontaktdetails);
		
		JPanel pnlContactDetailsCenter = new JPanel();
		add(pnlContactDetailsCenter, BorderLayout.CENTER);
		pnlContactDetailsCenter.setLayout(new BorderLayout(0, 0));
		
		this.pnlTabbedContactDetails = new JTabbedPane(JTabbedPane.TOP);
		this.pnlTabbedContactDetails.setFont(new Font("Arial", Font.BOLD, 13));
		pnlContactDetailsCenter.add(this.pnlTabbedContactDetails);
		
		this.pnlContactDetailsInformations = new JPanel();
		this.pnlContactDetailsInformations.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlTabbedContactDetails.addTab("Kontakt", null, this.pnlContactDetailsInformations, null);
		this.pnlContactDetailsInformations.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
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
				RowSpec.decode("bottom:pref"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:pref"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblGeneralInformation = new JLabel("Generelle Informationen");
		lblGeneralInformation.setFont(new Font("Arial", Font.BOLD, 13));
		this.pnlContactDetailsInformations.add(lblGeneralInformation, "2, 2, 7, 1, default, bottom");
		
		JButton btnPicture = new JButton("Picture");
		btnPicture.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(btnPicture, "2, 4, 3, 9");
		
		JLabel lblFirstName = new JLabel("Vorname:");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(lblFirstName, "8, 4, right, default");
		
		this.txtFirstName = new JTextField();
		this.txtFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(this.txtFirstName, "10, 4, 5, 1, fill, default");
		this.txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Nachname:");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(lblLastName, "8, 6, right, default");
		
		this.txtLastName = new JTextField();
		this.txtLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(this.txtLastName, "10, 6, 5, 1, fill, default");
		this.txtLastName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Kategorie:");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 13));
		this.pnlContactDetailsInformations.add(lblCategory, "8, 8");
		
		JRadioButton rdbtnLocalContact = new JRadioButton("lokaler Kontakt");
		rdbtnLocalContact.setMnemonic(KeyEvent.VK_L);
		rdbtnLocalContact.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(rdbtnLocalContact, "10, 8, 5, 1");
		
		JRadioButton rdbtnGlobalContact = new JRadioButton("globaler Kontakt");
		rdbtnGlobalContact.setMnemonic(KeyEvent.VK_G);
		rdbtnGlobalContact.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(rdbtnGlobalContact, "10, 10, 5, 1");
		
		JRadioButton rdbtnGlobalAndLocal = new JRadioButton("globaler und lokaler Kontakt");
		rdbtnGlobalAndLocal.setMnemonic(KeyEvent.VK_U);
		rdbtnGlobalAndLocal.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(rdbtnGlobalAndLocal, "10, 12, 5, 1");
		this.pnlTabbedContactDetails.setEnabledAt(0, true);
		
		/*
		 * Group the radio buttons.
		 */
	    ButtonGroup btngrpCategory = new ButtonGroup();
	    btngrpCategory.add(rdbtnLocalContact);
	    btngrpCategory.add(rdbtnGlobalContact);
	    btngrpCategory.add(rdbtnGlobalAndLocal);
	    
	    JLabel lblMail = new JLabel("E-Mail");
	    lblMail.setFont(new Font("Arial", Font.BOLD, 13));
	    this.pnlContactDetailsInformations.add(lblMail, "2, 14, 3, 1, default, bottom");
	    
	    JLabel lblPrivatMail = new JLabel("Privat:");
	    lblPrivatMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblPrivatMail, "4, 16, right, default");
	    
	    this.txtPrivatMail = new JTextField();
	    this.txtPrivatMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtPrivatMail, "6, 16, 9, 1, fill, default");
	    this.txtPrivatMail.setColumns(10);
	    
	    JLabel lblBusinessMail = new JLabel("Geschäftlich:");
	    lblBusinessMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblBusinessMail, "4, 18, right, default");
	    
	    this.txtBusinessMail = new JTextField();
	    this.txtBusinessMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtBusinessMail, "6, 18, 9, 1, fill, default");
	    this.txtBusinessMail.setColumns(10);
	    
	    JLabel lblPhone = new JLabel("Telefon");
	    lblPhone.setFont(new Font("Arial", Font.BOLD, 13));
	    this.pnlContactDetailsInformations.add(lblPhone, "2, 20, 3, 1, default, bottom");
	    
	    JLabel lblPrivatPhone = new JLabel("Privat:");
	    lblPrivatPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblPrivatPhone, "4, 22, right, default");
	    
	    this.txtPrivatPhone = new JTextField();
	    this.txtPrivatPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtPrivatPhone, "6, 22, 9, 1, fill, default");
	    this.txtPrivatPhone.setColumns(10);
	    
	    JLabel lblBusinessPhone = new JLabel("Geschäftlich:");
	    lblBusinessPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblBusinessPhone, "4, 24, right, default");
	    
	    this.txtBusinessPhone = new JTextField();
	    this.txtBusinessPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtBusinessPhone, "6, 24, 9, 1, fill, default");
	    this.txtBusinessPhone.setColumns(10);
		
		JPanel pnlContactDetailsPersonalInformations = new JPanel();
		this.pnlTabbedContactDetails.addTab("Persönliche Infos", null, pnlContactDetailsPersonalInformations, null);
		pnlContactDetailsPersonalInformations.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default)"),
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
				RowSpec.decode("bottom:pref"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblWebadressen = new JLabel("Web-Adressen");
		pnlContactDetailsPersonalInformations.add(lblWebadressen, "2, 2, 3, 1");
		lblWebadressen.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblHomepage = new JLabel("Homepage:");
		lblHomepage.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblHomepage, "4, 4, right, default");
		
		this.textField_2 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_2, "6, 4, fill, default");
		this.textField_2.setColumns(10);
		
		JLabel lblBeruf = new JLabel("Beruf");
		pnlContactDetailsPersonalInformations.add(lblBeruf, "2, 6, 3, 1");
		lblBeruf.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblBeruf_1 = new JLabel("Beruf:");
		lblBeruf_1.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblBeruf_1, "4, 8, right, default");
		
		this.textField_3 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_3, "6, 8, fill, default");
		this.textField_3.setColumns(10);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblFirma, "4, 10, right, default");
		
		this.textField_4 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_4, "6, 10, fill, default");
		this.textField_4.setColumns(10);
		
		JLabel lblAbteilung = new JLabel("Abteilung:");
		lblAbteilung.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblAbteilung, "4, 12, right, default");
		
		this.textField_5 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_5, "6, 12, fill, default");
		this.textField_5.setColumns(10);
		
		JLabel lblVerschiedenes = new JLabel("Verschiedenes");
		pnlContactDetailsPersonalInformations.add(lblVerschiedenes, "2, 14, 3, 1");
		lblVerschiedenes.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblBro = new JLabel("Büro:");
		lblBro.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblBro, "4, 16, right, default");
		
		this.textField_6 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_6, "6, 16, fill, default");
		this.textField_6.setColumns(10);
		
		JLabel lblEhepartner = new JLabel("Ehepartner:");
		lblEhepartner.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblEhepartner, "4, 18, right, default");
		
		this.textField_7 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_7, "6, 18, fill, default");
		this.textField_7.setColumns(10);
		
		JPanel pnlContactDetailsPostal = new JPanel();
		this.pnlTabbedContactDetails.addTab("Postadresse", null, pnlContactDetailsPostal, null);
		pnlContactDetailsPostal.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPrivat = new JLabel("Privat");
		pnlContactDetailsPostal.add(lblPrivat, "2, 2, 3, 1");
		lblPrivat.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblAdresse, "4, 4, right, default");
		
		JScrollPane pnlScrollPaneAdressField = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneAdressField, "6, 4, 3, 3, fill, fill");
		
		JTextArea textArea_1 = new JTextArea();
		pnlScrollPaneAdressField.setViewportView(textArea_1);
		
		JLabel lblPostfach = new JLabel("Postfach:");
		lblPostfach.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblPostfach, "4, 8, right, default");
		
		this.txtPostfach = new JTextField();
		pnlContactDetailsPostal.add(this.txtPostfach, "6, 8, 3, 1, fill, default");
		this.txtPostfach.setColumns(10);
		
		JLabel lblStadt = new JLabel("Stadt:");
		lblStadt.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblStadt, "4, 10, right, default");
		
		this.txtCity = new JTextField();
		pnlContactDetailsPostal.add(this.txtCity, "6, 10, 3, 1, fill, default");
		this.txtCity.setColumns(10);
		
		JLabel lblPostleitzahl = new JLabel("Postleitzahl:");
		lblPostleitzahl.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblPostleitzahl, "4, 12, right, default");
		
		this.txtZipPlz = new JTextField();
		pnlContactDetailsPostal.add(this.txtZipPlz, "6, 12, 3, 1, fill, default");
		this.txtZipPlz.setColumns(10);
		
		JLabel lblBundeststaatprovinz = new JLabel("Bundeststaat/Provinz:");
		lblBundeststaatprovinz.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblBundeststaatprovinz, "4, 14, 3, 1, right, default");
		
		this.txtStateProvinz = new JTextField();
		pnlContactDetailsPostal.add(this.txtStateProvinz, "8, 14, fill, default");
		this.txtStateProvinz.setColumns(10);
		
		JLabel lblLand = new JLabel("Land:");
		lblLand.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblLand, "4, 16, 3, 1, right, default");
		
		this.txtCountry = new JTextField();
		pnlContactDetailsPostal.add(this.txtCountry, "8, 16, fill, default");
		this.txtCountry.setColumns(10);
		
		JLabel lblGeschftlich = new JLabel("Geschäftlich");
		pnlContactDetailsPostal.add(lblGeschftlich, "2, 20, 3, 1");
		lblGeschftlich.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblAdresse_1 = new JLabel("Adresse:");
		lblAdresse_1.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblAdresse_1, "4, 22, right, default");
		
		JScrollPane pnlScrollPaneBuisnessAdress = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneBuisnessAdress, "6, 22, 3, 3, fill, fill");
		
		JTextArea textArea_2 = new JTextArea();
		pnlScrollPaneBuisnessAdress.setViewportView(textArea_2);
		
		JPanel pnlContactDetailsNotices = new JPanel();
		this.pnlTabbedContactDetails.addTab("Notitzen", null, pnlContactDetailsNotices, null);
		pnlContactDetailsNotices.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContactDetailsNotices.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel pnlEditButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlEditButton.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(pnlEditButton, BorderLayout.SOUTH);
		
		this.btnBack = new JButton("Zurück");
		this.btnBack.setFont(new Font("Arial", Font.BOLD, 13));
		pnlEditButton.add(this.btnBack);
		
		btnUnlock = new JButton( STD_BUTTON_UNLOCK_UNLOCK );
		btnUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( btnUnlock.getText().equals( STD_BUTTON_UNLOCK_UNLOCK ) ) {
					btnUnlock.setText( STD_BUTTON_UNLOCK_LOCK );
				} else if (btnUnlock.getText().equals( STD_BUTTON_UNLOCK_LOCK )) {
					btnUnlock.setText( STD_BUTTON_UNLOCK_UNLOCK );
				} else {
					/*
					 * Should never happen.
					 */
					throw new RuntimeException();
				}
			}
		});
		btnUnlock.setFont(new Font("Arial", Font.BOLD, 13));
		pnlEditButton.add(btnUnlock);


	}
	
	public ViewContactDetails( ViewMain frmMainFrame, ViewContacts viewContacts ){
		
		this();
//		try {
//			if ( frmMainFrame == null )
//				throw new RuntimeException("ContactDetails: Kein MainFrame");
//		} catch (RuntimeException e) {
//			System.out.println(e);
//		}
		this.frmMainFrame = frmMainFrame;
		this.viewContacts = viewContacts;
		this.btnBack.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				btnUnlock.setText(STD_BUTTON_UNLOCK_UNLOCK);				
			}
		});
		this.btnBack.addActionListener( new LoadContactsActionListener( viewContacts ) );
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}

}

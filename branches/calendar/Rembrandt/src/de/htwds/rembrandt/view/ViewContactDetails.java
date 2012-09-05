package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.components.JNumberOnlyTextField;
import de.htwds.rembrandt.controler.contactViewControler.EnableTextFieldsActionListener;
import de.htwds.rembrandt.controler.contactViewControler.EnsureSavedDataControler;
import de.htwds.rembrandt.controler.contactViewControler.LoadContactsActionListener;

public class ViewContactDetails extends JPanel {
	
	public static final String STD_BUTTON_UNLOCK_UNLOCK = "Entsperren";
	public static final String STD_BUTTON_UNLOCK_LOCK = "Speichern und Sperren";
	
	private boolean informationEditable = false;
	
	private JButton btnBack;
	private JButton btnUnlock;
	private JButton btnPicture;
	private JTabbedPane pnlTabbedContactDetails;
	private JPanel pnlContactDetailsInformations;
	
	private ViewMain frmMainFrame;
	private ViewContacts viewContacts;
		
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPostfach;
	private JTextField txtCity;
	private JTextField txtStateProvinz;
	private JTextField txtCountry;
	private JTextField txtHomepage;
	private JTextField txtJob;
	private JTextField txtCompany;
	private JTextField txtDepartment;
	private JTextField txtOffice;
	private JTextField txtSpouses;
	private JTextField txtPrivatMail;
	private JTextField txtBusinessMail;

	private JNumberOnlyTextField txtZipPlz;
	private JNumberOnlyTextField txtPrivatPhone;
	private JNumberOnlyTextField txtBusinessPhone;
	
	private JTextArea textAreaPrivatAdress;
	private JTextArea textAreaBusinessAdress;
	private JTextArea textAreaNotices;
	
	private JRadioButton rdbtnLocalContact;
	private JRadioButton rdbtnGlobalContact;
	private JRadioButton rdbtnGlobalAndLocal;

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
		
		btnPicture = new JButton("Picture");
		btnPicture.setEnabled(false);
		btnPicture.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(btnPicture, "2, 4, 3, 9");
		
		JLabel lblFirstName = new JLabel("Vorname:");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(lblFirstName, "8, 4, right, default");
		
		this.txtFirstName = new JTextField();
		this.txtFirstName.setDisabledTextColor(getForeground());
		this.txtFirstName.setEditable(false);
		this.txtFirstName.setEnabled(false);
		this.txtFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(this.txtFirstName, "10, 4, 5, 1, fill, default");
		this.txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Nachname:");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(lblLastName, "8, 6, right, default");
		
		this.txtLastName = new JTextField();
		this.txtLastName.setDisabledTextColor(getForeground());
		this.txtLastName.setEditable(false);
		this.txtLastName.setEnabled(false);
		this.txtLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(this.txtLastName, "10, 6, 5, 1, fill, default");
		this.txtLastName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Kategorie:");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 13));
		this.pnlContactDetailsInformations.add(lblCategory, "8, 8");
		
		rdbtnLocalContact = new JRadioButton("lokaler Kontakt");
		rdbtnLocalContact.setSelected(true);
		rdbtnLocalContact.setEnabled(false);
		rdbtnLocalContact.setMnemonic(KeyEvent.VK_L);
		rdbtnLocalContact.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(rdbtnLocalContact, "10, 8, 5, 1");
		
		rdbtnGlobalContact = new JRadioButton("globaler Kontakt");
		rdbtnGlobalContact.setEnabled(false);
		rdbtnGlobalContact.setMnemonic(KeyEvent.VK_G);
		rdbtnGlobalContact.setFont(new Font("Arial", Font.PLAIN, 13));
		this.pnlContactDetailsInformations.add(rdbtnGlobalContact, "10, 10, 5, 1");
		
		rdbtnGlobalAndLocal = new JRadioButton("globaler und lokaler Kontakt");
		rdbtnGlobalAndLocal.setEnabled(false);
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
	    this.txtPrivatMail.setDisabledTextColor(getForeground());
	    this.txtPrivatMail.setEditable(false);
	    this.txtPrivatMail.setEnabled(false);
	    this.txtPrivatMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtPrivatMail, "6, 16, 9, 1, fill, default");
	    this.txtPrivatMail.setColumns(10);
	    
	    JLabel lblBusinessMail = new JLabel("Geschäftlich:");
	    lblBusinessMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblBusinessMail, "4, 18, right, default");
	    
	    this.txtBusinessMail = new JTextField();
	    this.txtBusinessMail.setDisabledTextColor(getForeground());
	    this.txtBusinessMail.setEditable(false);
	    this.txtBusinessMail.setEnabled(false);
	    this.txtBusinessMail.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtBusinessMail, "6, 18, 9, 1, fill, default");
	    this.txtBusinessMail.setColumns(10);
	    
	    JLabel lblPhone = new JLabel("Telefon");
	    lblPhone.setFont(new Font("Arial", Font.BOLD, 13));
	    this.pnlContactDetailsInformations.add(lblPhone, "2, 20, 3, 1, default, bottom");
	    
	    JLabel lblPrivatPhone = new JLabel("Privat:");
	    lblPrivatPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblPrivatPhone, "4, 22, right, default");
	    
	    this.txtPrivatPhone = new JNumberOnlyTextField();
	    this.txtPrivatPhone.setDisabledTextColor(getForeground());
	    this.txtPrivatPhone.setEditable(false);
	    this.txtPrivatPhone.setEnabled(false);
	    this.txtPrivatPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(this.txtPrivatPhone, "6, 22, 9, 1, fill, default");
	    this.txtPrivatPhone.setColumns(10);
	    
	    JLabel lblBusinessPhone = new JLabel("Geschäftlich:");
	    lblBusinessPhone.setFont(new Font("Arial", Font.PLAIN, 13));
	    this.pnlContactDetailsInformations.add(lblBusinessPhone, "4, 24, right, default");
	    
	    this.txtBusinessPhone = new JNumberOnlyTextField();
	    this.txtBusinessPhone.setDisabledTextColor(getForeground());
	    this.txtBusinessPhone.setEditable(false);
	    this.txtBusinessPhone.setEnabled(false);
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
		
		this.txtHomepage = new JTextField();
		this.txtHomepage.setDisabledTextColor(getForeground());
		this.txtHomepage.setEditable(false);
		this.txtHomepage.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtHomepage, "6, 4, fill, default");
		this.txtHomepage.setColumns(10);
		
		JLabel lblBerufCategory = new JLabel("Beruf");
		pnlContactDetailsPersonalInformations.add(lblBerufCategory, "2, 6, 3, 1");
		lblBerufCategory.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblBeruf = new JLabel("Beruf:");
		lblBeruf.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblBeruf, "4, 8, right, default");
		
		this.txtJob = new JTextField();
		this.txtJob.setDisabledTextColor(getForeground());
		this.txtJob.setEditable(false);
		this.txtJob.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtJob, "6, 8, fill, default");
		this.txtJob.setColumns(10);
		
		JLabel lblCompany = new JLabel("Firma:");
		lblCompany.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblCompany, "4, 10, right, default");
		
		this.txtCompany = new JTextField();
		this.txtCompany.setDisabledTextColor(getForeground());
		this.txtCompany.setEditable(false);
		this.txtCompany.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtCompany, "6, 10, fill, default");
		this.txtCompany.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Abteilung:");
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblDepartment, "4, 12, right, default");
		
		this.txtDepartment = new JTextField();
		this.txtDepartment.setDisabledTextColor(getForeground());
		this.txtDepartment.setEditable(false);
		this.txtDepartment.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtDepartment, "6, 12, fill, default");
		this.txtDepartment.setColumns(10);
		
		JLabel lblMiscellaneousCategory = new JLabel("Verschiedenes");
		pnlContactDetailsPersonalInformations.add(lblMiscellaneousCategory, "2, 14, 3, 1");
		lblMiscellaneousCategory.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblOffice = new JLabel("Büro:");
		lblOffice.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblOffice, "4, 16, right, default");
		
		this.txtOffice = new JTextField();
		this.txtOffice.setDisabledTextColor(getForeground());
		this.txtOffice.setEditable(false);
		this.txtOffice.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtOffice, "6, 16, fill, default");
		this.txtOffice.setColumns(10);
		
		JLabel lblSpouses = new JLabel("Ehepartner:");
		lblSpouses.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblSpouses, "4, 18, right, default");
		
		this.txtSpouses = new JTextField();
		this.txtSpouses.setDisabledTextColor(getForeground());
		this.txtSpouses.setEditable(false);
		this.txtSpouses.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtSpouses, "6, 18, fill, default");
		this.txtSpouses.setColumns(10);
		
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
				RowSpec.decode("default:grow"),}));
		
		JLabel lblPrivat = new JLabel("Privat");
		pnlContactDetailsPostal.add(lblPrivat, "2, 2, 3, 1");
		lblPrivat.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblAdresse, "4, 4, right, default");
		
		JScrollPane pnlScrollPaneAdressField = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneAdressField, "6, 4, 3, 3, fill, fill");
		
		textAreaPrivatAdress = new JTextArea();
		this.textAreaPrivatAdress.setDisabledTextColor(getForeground());
		textAreaPrivatAdress.setEditable(false);
		textAreaPrivatAdress.setLineWrap(true);
		textAreaPrivatAdress.setFont(new Font("Arial", Font.PLAIN, 13));
		textAreaPrivatAdress.setEnabled(false);
		pnlScrollPaneAdressField.setViewportView(textAreaPrivatAdress);
		
		JLabel lblPostfach = new JLabel("Postfach:");
		lblPostfach.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblPostfach, "4, 8, right, default");
		
		this.txtPostfach = new JTextField();
		this.txtPostfach.setDisabledTextColor(getForeground());
		this.txtPostfach.setEditable(false);
		this.txtPostfach.setFont(new Font("Arial", Font.PLAIN, 13));
		this.txtPostfach.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtPostfach, "6, 8, 3, 1, fill, default");
		this.txtPostfach.setColumns(10);
		
		JLabel lblStadt = new JLabel("Stadt:");
		lblStadt.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblStadt, "4, 10, right, default");
		
		this.txtCity = new JTextField();
		this.txtCity.setDisabledTextColor(getForeground());
		this.txtCity.setEditable(false);
		this.txtCity.setFont(new Font("Arial", Font.PLAIN, 13));
		this.txtCity.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtCity, "6, 10, 3, 1, fill, default");
		this.txtCity.setColumns(10);
		
		JLabel lblPostleitzahl = new JLabel("Postleitzahl:");
		lblPostleitzahl.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblPostleitzahl, "4, 12, right, default");
		
		this.txtZipPlz = new JNumberOnlyTextField();
		this.txtZipPlz.setDisabledTextColor(getForeground());
		this.txtZipPlz.setEditable(false);
		this.txtZipPlz.setFont(new Font("Arial", Font.PLAIN, 13));
		this.txtZipPlz.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtZipPlz, "6, 12, 3, 1, fill, default");
		this.txtZipPlz.setColumns(10);
		
		JLabel lblBundeststaatprovinz = new JLabel("Bundeststaat/Provinz:");
		lblBundeststaatprovinz.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblBundeststaatprovinz, "4, 14, 3, 1, right, default");
		
		this.txtStateProvinz = new JTextField();
		this.txtStateProvinz.setDisabledTextColor(getForeground());
		this.txtStateProvinz.setEditable(false);
		this.txtStateProvinz.setFont(new Font("Arial", Font.PLAIN, 13));
		this.txtStateProvinz.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtStateProvinz, "8, 14, fill, default");
		this.txtStateProvinz.setColumns(10);
		
		JLabel lblLand = new JLabel("Land:");
		lblLand.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblLand, "4, 16, 3, 1, right, default");
		
		this.txtCountry = new JTextField();
		this.txtCountry.setDisabledTextColor(getForeground());
		this.txtCountry.setEditable(false);
		this.txtCountry.setFont(new Font("Arial", Font.PLAIN, 13));
		this.txtCountry.setEnabled(false);
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
		
		textAreaBusinessAdress = new JTextArea();
		this.textAreaBusinessAdress.setDisabledTextColor(getForeground());
		textAreaBusinessAdress.setEditable(false);
		textAreaBusinessAdress.setLineWrap(true);
		textAreaBusinessAdress.setFont(new Font("Arial", Font.PLAIN, 13));
		textAreaBusinessAdress.setEnabled(false);
		pnlScrollPaneBuisnessAdress.setViewportView(textAreaBusinessAdress);
		
		JPanel pnlContactDetailsNotices = new JPanel();
		this.pnlTabbedContactDetails.addTab("Notitzen", null, pnlContactDetailsNotices, null);
		pnlContactDetailsNotices.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContactDetailsNotices.add(scrollPane, BorderLayout.CENTER);
		
		textAreaNotices = new JTextArea();
		this.textAreaNotices.setDisabledTextColor(getForeground());
		textAreaNotices.setEditable(false);
		textAreaNotices.setEnabled(false);
		textAreaNotices.setLineWrap(true);
		textAreaNotices.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(textAreaNotices);
		
		JPanel pnlEditButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlEditButton.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(pnlEditButton, BorderLayout.SOUTH);
		
		this.btnBack = new JButton("Zurück");
		this.btnBack.setFont(new Font("Arial", Font.BOLD, 13));
		pnlEditButton.add(this.btnBack);
		
		btnUnlock = new JButton( STD_BUTTON_UNLOCK_UNLOCK );
		btnUnlock.addActionListener( new EnableTextFieldsActionListener(this) );
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
		this.btnBack.addActionListener( new EnsureSavedDataControler( this ) );
		this.btnBack.addActionListener( new LoadContactsActionListener( viewContacts ) );
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
	/**
	 * If all components are not enabled, this method set them to enable,
	 * else this method set them to be not enabled.
	 * If you want to know: Is it enabled or not. Use the isInformationEditable() function.
	 */
	public void setInformationEditable(){
		informationEditable = !informationEditable;
		
		txtFirstName.setEditable(informationEditable);
		txtFirstName.setEnabled(informationEditable);
		
		txtLastName.setEditable(informationEditable);
		txtLastName.setEnabled(informationEditable);
		
		txtPostfach.setEditable(informationEditable);
		txtPostfach.setEnabled(informationEditable);
		
		txtCity.setEditable(informationEditable);
		txtCity.setEnabled(informationEditable);
		
		txtZipPlz.setEditable(informationEditable);
		txtZipPlz.setEnabled(informationEditable);
		
		txtStateProvinz.setEditable(informationEditable);
		txtStateProvinz.setEnabled(informationEditable);
		
		txtCountry.setEditable(informationEditable);
		txtCountry.setEnabled(informationEditable);
		
		txtHomepage.setEditable(informationEditable);
		txtHomepage.setEnabled(informationEditable);
		
		txtJob.setEditable(informationEditable);
		txtJob.setEnabled(informationEditable);
		
		txtCompany.setEditable(informationEditable);
		txtCompany.setEnabled(informationEditable);
		
		txtDepartment.setEditable(informationEditable);
		txtDepartment.setEnabled(informationEditable);
		
		txtOffice.setEditable(informationEditable);
		txtOffice.setEnabled(informationEditable);
		
		txtSpouses.setEditable(informationEditable);
		txtSpouses.setEnabled(informationEditable);

		txtPrivatMail.setEditable(informationEditable);
		txtPrivatMail.setEnabled(informationEditable);
		
		txtBusinessMail.setEditable(informationEditable);
		txtBusinessMail.setEnabled(informationEditable);
		
		txtPrivatPhone.setEditable(informationEditable);
		txtPrivatPhone.setEnabled(informationEditable);
		
		txtBusinessPhone.setEditable(informationEditable);
		txtBusinessPhone.setEnabled(informationEditable);
				
		textAreaPrivatAdress.setEditable(informationEditable);
		textAreaPrivatAdress.setEnabled(informationEditable);
		
		textAreaBusinessAdress.setEditable(informationEditable);
		textAreaBusinessAdress.setEnabled(informationEditable);
		
		textAreaNotices.setEditable(informationEditable);
		textAreaNotices.setEnabled(informationEditable);
		
		rdbtnLocalContact.setEnabled(informationEditable);
		rdbtnGlobalContact.setEnabled(informationEditable);
		rdbtnGlobalAndLocal.setEnabled(informationEditable);
		
		btnPicture.setEnabled(informationEditable);
	}
	/**
	 * Checks if the components are enabled or not.
	 * 
	 * @return true if the components are enabled, else false.
	 */
	public boolean isInformationEditable() {
		return informationEditable;
	}
	
	public JButton getBtnUnlock() {
		return this.btnUnlock;
	}

	/**
	 * @return the txtFirstName
	 */
	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	/**
	 * @return the txtLastName
	 */
	public JTextField getTxtLastName() {
		return txtLastName;
	}

	/**
	 * @return the txtPostfach
	 */
	public JTextField getTxtPostfach() {
		return txtPostfach;
	}

	/**
	 * @return the txtCity
	 */
	public JTextField getTxtCity() {
		return txtCity;
	}

	/**
	 * @return the txtZipPlz
	 */
	public JNumberOnlyTextField getTxtZipPlz() {
		return txtZipPlz;
	}

	/**
	 * @return the txtStateProvinz
	 */
	public JTextField getTxtStateProvinz() {
		return txtStateProvinz;
	}

	/**
	 * @return the txtCountry
	 */
	public JTextField getTxtCountry() {
		return txtCountry;
	}

	/**
	 * @return the txtHomepage
	 */
	public JTextField getTxtHomepage() {
		return txtHomepage;
	}

	/**
	 * @return the txtJob
	 */
	public JTextField getTxtJob() {
		return txtJob;
	}

	/**
	 * @return the txtCompany
	 */
	public JTextField getTxtCompany() {
		return txtCompany;
	}

	/**
	 * @return the txtDepartment
	 */
	public JTextField getTxtDepartment() {
		return txtDepartment;
	}

	/**
	 * @return the txtOffice
	 */
	public JTextField getTxtOffice() {
		return txtOffice;
	}

	/**
	 * @return the txtSpouses
	 */
	public JTextField getTxtSpouses() {
		return txtSpouses;
	}

	/**
	 * @return the txtPrivatMail
	 */
	public JTextField getTxtPrivatMail() {
		return txtPrivatMail;
	}

	/**
	 * @return the txtBusinessMail
	 */
	public JTextField getTxtBusinessMail() {
		return txtBusinessMail;
	}

	/**
	 * @return the txtPrivatPhone
	 */
	public JNumberOnlyTextField getTxtPrivatPhone() {
		return txtPrivatPhone;
	}

	/**
	 * @return the txtBusinessPhone
	 */
	public JNumberOnlyTextField getTxtBusinessPhone() {
		return txtBusinessPhone;
	}

	/**
	 * @return the textAreaPrivatAdress
	 */
	public JTextArea getTextAreaPrivatAdress() {
		return textAreaPrivatAdress;
	}

	/**
	 * @return the textAreaBusinessAdress
	 */
	public JTextArea getTextAreaBusinessAdress() {
		return textAreaBusinessAdress;
	}

	/**
	 * @return the textAreaNotices
	 */
	public JTextArea getTextAreaNotices() {
		return textAreaNotices;
	}

	/**
	 * @return the rdbtnLocalContact
	 */
	public JRadioButton getRdbtnLocalContact() {
		return rdbtnLocalContact;
	}

	/**
	 * @return the rdbtnGlobalContact
	 */
	public JRadioButton getRdbtnGlobalContact() {
		return rdbtnGlobalContact;
	}

	/**
	 * @return the rdbtnGlobalAndLocal
	 */
	public JRadioButton getRdbtnGlobalAndLocal() {
		return rdbtnGlobalAndLocal;
	}
}
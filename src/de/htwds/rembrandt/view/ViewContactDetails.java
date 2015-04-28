package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.components.JNumberOnlyTextField;
import de.htwds.rembrandt.controler.contactViewControler.AddPictureActionListener;
import de.htwds.rembrandt.controler.contactViewControler.EnableTextFieldsActionListener;
import de.htwds.rembrandt.controler.contactViewControler.ReturnToContactsActionListener;
import de.htwds.rembrandt.model.Contact;

public class ViewContactDetails extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STD_BUTTON_UNLOCK_UNLOCK = Messages.getString("ViewContactDetails.0"); //$NON-NLS-1$
	public static final String STD_BUTTON_UNLOCK_LOCK = Messages.getString("ViewContactDetails.1"); //$NON-NLS-1$
	
	private boolean informationEditable = false;
	
	//If contact needs to be edited
	private Contact alreadyExistingContact;
	
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
	
	private JRadioButton rdbtnPrivateContact;
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
		
		JLabel lblKontaktdetails = new JLabel(Messages.getString("ViewContactDetails.2")); //$NON-NLS-1$
		lblKontaktdetails.setFont(new Font(Messages.getString("ViewContactDetails.3"), Font.BOLD, 16)); //$NON-NLS-1$
		pnlContactDetailsHeader.add(lblKontaktdetails);
		
		JPanel pnlContactDetailsCenter = new JPanel();
		add(pnlContactDetailsCenter, BorderLayout.CENTER);
		pnlContactDetailsCenter.setLayout(new BorderLayout(0, 0));
		
		this.pnlTabbedContactDetails = new JTabbedPane(SwingConstants.TOP);
		this.pnlTabbedContactDetails.setFont(new Font(Messages.getString("ViewContactDetails.4"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlContactDetailsCenter.add(this.pnlTabbedContactDetails);
		
		this.pnlContactDetailsInformations = new JPanel();
		this.pnlContactDetailsInformations.setFont(new Font(Messages.getString("ViewContactDetails.5"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlTabbedContactDetails.addTab(Messages.getString("ViewContactDetails.6"), null, this.pnlContactDetailsInformations, null); //$NON-NLS-1$
		this.pnlContactDetailsInformations.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.7")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.8")), //$NON-NLS-1$
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
				RowSpec.decode(Messages.getString("ViewContactDetails.9")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewContactDetails.10")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblGeneralInformation = new JLabel(Messages.getString("ViewContactDetails.11")); //$NON-NLS-1$
		lblGeneralInformation.setFont(new Font(Messages.getString("ViewContactDetails.12"), Font.BOLD, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(lblGeneralInformation, Messages.getString("ViewContactDetails.13")); //$NON-NLS-1$
		
		btnPicture = new JButton(Messages.getString("ViewContactDetails.14")); //$NON-NLS-1$
		btnPicture.setEnabled(false);
		btnPicture.setFont(new Font(Messages.getString("ViewContactDetails.15"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(btnPicture, Messages.getString("ViewContactDetails.16")); //$NON-NLS-1$
		
		/*
		 * Image image = new ImageIcon(getClass().getResource("pfeil.png")).getImage();
            ImageIcon icon = new ImageIcon(image.getScaledInstance(btCopy.getWidth(),btCopy.getHeight(),Image.SCALE_FAST ));
            btCopy.setIcon(icon);
		 */
		
		JLabel lblFirstName = new JLabel(Messages.getString("ViewContactDetails.17")); //$NON-NLS-1$
		lblFirstName.setFont(new Font(Messages.getString("ViewContactDetails.18"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(lblFirstName, Messages.getString("ViewContactDetails.19")); //$NON-NLS-1$
		
		this.txtFirstName = new JTextField();
		this.txtFirstName.setDisabledTextColor(getForeground());
		this.txtFirstName.setEditable(false);
		this.txtFirstName.setEnabled(false);
		this.txtFirstName.setFont(new Font(Messages.getString("ViewContactDetails.20"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(this.txtFirstName, Messages.getString("ViewContactDetails.21")); //$NON-NLS-1$
		this.txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel(Messages.getString("ViewContactDetails.22")); //$NON-NLS-1$
		lblLastName.setFont(new Font(Messages.getString("ViewContactDetails.23"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(lblLastName, Messages.getString("ViewContactDetails.24")); //$NON-NLS-1$
		
		this.txtLastName = new JTextField();
		this.txtLastName.setDisabledTextColor(getForeground());
		this.txtLastName.setEditable(false);
		this.txtLastName.setEnabled(false);
		this.txtLastName.setFont(new Font(Messages.getString("ViewContactDetails.25"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(this.txtLastName, Messages.getString("ViewContactDetails.26")); //$NON-NLS-1$
		this.txtLastName.setColumns(10);
		
		JLabel lblCategory = new JLabel(Messages.getString("ViewContactDetails.27")); //$NON-NLS-1$
		lblCategory.setFont(new Font(Messages.getString("ViewContactDetails.28"), Font.BOLD, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(lblCategory, Messages.getString("ViewContactDetails.29")); //$NON-NLS-1$
		
		rdbtnPrivateContact = new JRadioButton(Messages.getString("ViewContactDetails.30")); //$NON-NLS-1$
		rdbtnPrivateContact.setSelected(true);
		rdbtnPrivateContact.setEnabled(false);
		rdbtnPrivateContact.setMnemonic(KeyEvent.VK_L);
		rdbtnPrivateContact.setFont(new Font(Messages.getString("ViewContactDetails.31"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(rdbtnPrivateContact, Messages.getString("ViewContactDetails.32")); //$NON-NLS-1$
		
		rdbtnGlobalContact = new JRadioButton(Messages.getString("ViewContactDetails.33")); //$NON-NLS-1$
		rdbtnGlobalContact.setEnabled(false);
		rdbtnGlobalContact.setMnemonic(KeyEvent.VK_G);
		rdbtnGlobalContact.setFont(new Font(Messages.getString("ViewContactDetails.34"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(rdbtnGlobalContact, Messages.getString("ViewContactDetails.35")); //$NON-NLS-1$
		
		rdbtnGlobalAndLocal = new JRadioButton(Messages.getString("ViewContactDetails.36")); //$NON-NLS-1$
		rdbtnGlobalAndLocal.setEnabled(false);
		rdbtnGlobalAndLocal.setMnemonic(KeyEvent.VK_U);
		rdbtnGlobalAndLocal.setFont(new Font(Messages.getString("ViewContactDetails.37"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.pnlContactDetailsInformations.add(rdbtnGlobalAndLocal, Messages.getString("ViewContactDetails.38")); //$NON-NLS-1$
		this.pnlTabbedContactDetails.setEnabledAt(0, true);
		
		/*
		 * Group the radio buttons.
		 */
	    ButtonGroup btngrpCategory = new ButtonGroup();
	    btngrpCategory.add(rdbtnPrivateContact);
	    btngrpCategory.add(rdbtnGlobalContact);
	    btngrpCategory.add(rdbtnGlobalAndLocal);
	    
	    JLabel lblMail = new JLabel(Messages.getString("ViewContactDetails.39")); //$NON-NLS-1$
	    lblMail.setFont(new Font(Messages.getString("ViewContactDetails.40"), Font.BOLD, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblMail, Messages.getString("ViewContactDetails.41")); //$NON-NLS-1$
	    
	    JLabel lblPrivatMail = new JLabel(Messages.getString("ViewContactDetails.42")); //$NON-NLS-1$
	    lblPrivatMail.setFont(new Font(Messages.getString("ViewContactDetails.43"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblPrivatMail, Messages.getString("ViewContactDetails.44")); //$NON-NLS-1$
	    
	    this.txtPrivatMail = new JTextField();
	    this.txtPrivatMail.setDisabledTextColor(getForeground());
	    this.txtPrivatMail.setEditable(false);
	    this.txtPrivatMail.setEnabled(false);
	    this.txtPrivatMail.setFont(new Font(Messages.getString("ViewContactDetails.45"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(this.txtPrivatMail, Messages.getString("ViewContactDetails.46")); //$NON-NLS-1$
	    this.txtPrivatMail.setColumns(10);
	    
	    JLabel lblBusinessMail = new JLabel(Messages.getString("ViewContactDetails.47")); //$NON-NLS-1$
	    lblBusinessMail.setFont(new Font(Messages.getString("ViewContactDetails.48"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblBusinessMail, Messages.getString("ViewContactDetails.49")); //$NON-NLS-1$
	    
	    this.txtBusinessMail = new JTextField();
	    this.txtBusinessMail.setDisabledTextColor(getForeground());
	    this.txtBusinessMail.setEditable(false);
	    this.txtBusinessMail.setEnabled(false);
	    this.txtBusinessMail.setFont(new Font(Messages.getString("ViewContactDetails.50"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(this.txtBusinessMail, Messages.getString("ViewContactDetails.51")); //$NON-NLS-1$
	    this.txtBusinessMail.setColumns(10);
	    
	    JLabel lblPhone = new JLabel(Messages.getString("ViewContactDetails.52")); //$NON-NLS-1$
	    lblPhone.setFont(new Font(Messages.getString("ViewContactDetails.53"), Font.BOLD, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblPhone, Messages.getString("ViewContactDetails.54")); //$NON-NLS-1$
	    
	    JLabel lblPrivatPhone = new JLabel(Messages.getString("ViewContactDetails.55")); //$NON-NLS-1$
	    lblPrivatPhone.setFont(new Font(Messages.getString("ViewContactDetails.56"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblPrivatPhone, Messages.getString("ViewContactDetails.57")); //$NON-NLS-1$
	    
	    this.txtPrivatPhone = new JNumberOnlyTextField();
	    this.txtPrivatPhone.setDisabledTextColor(getForeground());
	    this.txtPrivatPhone.setEditable(false);
	    this.txtPrivatPhone.setEnabled(false);
	    this.txtPrivatPhone.setFont(new Font(Messages.getString("ViewContactDetails.58"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(this.txtPrivatPhone, Messages.getString("ViewContactDetails.59")); //$NON-NLS-1$
	    this.txtPrivatPhone.setColumns(10);
	    
	    JLabel lblBusinessPhone = new JLabel(Messages.getString("ViewContactDetails.60")); //$NON-NLS-1$
	    lblBusinessPhone.setFont(new Font(Messages.getString("ViewContactDetails.61"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(lblBusinessPhone, Messages.getString("ViewContactDetails.62")); //$NON-NLS-1$
	    
	    this.txtBusinessPhone = new JNumberOnlyTextField();
	    this.txtBusinessPhone.setDisabledTextColor(getForeground());
	    this.txtBusinessPhone.setEditable(false);
	    this.txtBusinessPhone.setEnabled(false);
	    this.txtBusinessPhone.setFont(new Font(Messages.getString("ViewContactDetails.63"), Font.PLAIN, 13)); //$NON-NLS-1$
	    this.pnlContactDetailsInformations.add(this.txtBusinessPhone, Messages.getString("ViewContactDetails.64")); //$NON-NLS-1$
	    this.txtBusinessPhone.setColumns(10);
		
		JPanel pnlContactDetailsPersonalInformations = new JPanel();
		this.pnlTabbedContactDetails.addTab(Messages.getString("ViewContactDetails.65"), null, pnlContactDetailsPersonalInformations, null); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.66")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.67")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewContactDetails.68")), //$NON-NLS-1$
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
		
		JLabel lblWebadressen = new JLabel(Messages.getString("ViewContactDetails.69")); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblWebadressen, Messages.getString("ViewContactDetails.70")); //$NON-NLS-1$
		lblWebadressen.setFont(new Font(Messages.getString("ViewContactDetails.71"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JLabel lblHomepage = new JLabel(Messages.getString("ViewContactDetails.72")); //$NON-NLS-1$
		lblHomepage.setFont(new Font(Messages.getString("ViewContactDetails.73"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblHomepage, Messages.getString("ViewContactDetails.74")); //$NON-NLS-1$
		
		this.txtHomepage = new JTextField();
		this.txtHomepage.setDisabledTextColor(getForeground());
		this.txtHomepage.setEditable(false);
		this.txtHomepage.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtHomepage, Messages.getString("ViewContactDetails.75")); //$NON-NLS-1$
		this.txtHomepage.setColumns(10);
		
		JLabel lblBerufCategory = new JLabel(Messages.getString("ViewContactDetails.76")); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblBerufCategory, Messages.getString("ViewContactDetails.77")); //$NON-NLS-1$
		lblBerufCategory.setFont(new Font(Messages.getString("ViewContactDetails.78"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JLabel lblBeruf = new JLabel(Messages.getString("ViewContactDetails.79")); //$NON-NLS-1$
		lblBeruf.setFont(new Font(Messages.getString("ViewContactDetails.80"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblBeruf, Messages.getString("ViewContactDetails.81")); //$NON-NLS-1$
		
		this.txtJob = new JTextField();
		this.txtJob.setDisabledTextColor(getForeground());
		this.txtJob.setEditable(false);
		this.txtJob.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtJob, Messages.getString("ViewContactDetails.82")); //$NON-NLS-1$
		this.txtJob.setColumns(10);
		
		JLabel lblCompany = new JLabel(Messages.getString("ViewContactDetails.83")); //$NON-NLS-1$
		lblCompany.setFont(new Font(Messages.getString("ViewContactDetails.84"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblCompany, Messages.getString("ViewContactDetails.85")); //$NON-NLS-1$
		
		this.txtCompany = new JTextField();
		this.txtCompany.setDisabledTextColor(getForeground());
		this.txtCompany.setEditable(false);
		this.txtCompany.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtCompany, Messages.getString("ViewContactDetails.86")); //$NON-NLS-1$
		this.txtCompany.setColumns(10);
		
		JLabel lblDepartment = new JLabel(Messages.getString("ViewContactDetails.87")); //$NON-NLS-1$
		lblDepartment.setFont(new Font(Messages.getString("ViewContactDetails.88"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblDepartment, Messages.getString("ViewContactDetails.89")); //$NON-NLS-1$
		
		this.txtDepartment = new JTextField();
		this.txtDepartment.setDisabledTextColor(getForeground());
		this.txtDepartment.setEditable(false);
		this.txtDepartment.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtDepartment, Messages.getString("ViewContactDetails.90")); //$NON-NLS-1$
		this.txtDepartment.setColumns(10);
		
		JLabel lblMiscellaneousCategory = new JLabel(Messages.getString("ViewContactDetails.91")); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblMiscellaneousCategory, Messages.getString("ViewContactDetails.92")); //$NON-NLS-1$
		lblMiscellaneousCategory.setFont(new Font(Messages.getString("ViewContactDetails.93"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JLabel lblOffice = new JLabel(Messages.getString("ViewContactDetails.94")); //$NON-NLS-1$
		lblOffice.setFont(new Font(Messages.getString("ViewContactDetails.95"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblOffice, Messages.getString("ViewContactDetails.96")); //$NON-NLS-1$
		
		this.txtOffice = new JTextField();
		this.txtOffice.setDisabledTextColor(getForeground());
		this.txtOffice.setEditable(false);
		this.txtOffice.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtOffice, Messages.getString("ViewContactDetails.97")); //$NON-NLS-1$
		this.txtOffice.setColumns(10);
		
		JLabel lblSpouses = new JLabel(Messages.getString("ViewContactDetails.98")); //$NON-NLS-1$
		lblSpouses.setFont(new Font(Messages.getString("ViewContactDetails.99"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPersonalInformations.add(lblSpouses, Messages.getString("ViewContactDetails.100")); //$NON-NLS-1$
		
		this.txtSpouses = new JTextField();
		this.txtSpouses.setDisabledTextColor(getForeground());
		this.txtSpouses.setEditable(false);
		this.txtSpouses.setEnabled(false);
		pnlContactDetailsPersonalInformations.add(this.txtSpouses, Messages.getString("ViewContactDetails.101")); //$NON-NLS-1$
		this.txtSpouses.setColumns(10);
		
		JPanel pnlContactDetailsPostal = new JPanel();
		this.pnlTabbedContactDetails.addTab(Messages.getString("ViewContactDetails.102"), null, pnlContactDetailsPostal, null); //$NON-NLS-1$
		pnlContactDetailsPostal.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.103")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.104")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewContactDetails.105")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode(Messages.getString("ViewContactDetails.106")), //$NON-NLS-1$
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
				RowSpec.decode(Messages.getString("ViewContactDetails.107")),})); //$NON-NLS-1$
		
		JLabel lblPrivat = new JLabel(Messages.getString("ViewContactDetails.108")); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblPrivat, Messages.getString("ViewContactDetails.109")); //$NON-NLS-1$
		lblPrivat.setFont(new Font(Messages.getString("ViewContactDetails.110"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JLabel lblAdresse = new JLabel(Messages.getString("ViewContactDetails.111")); //$NON-NLS-1$
		lblAdresse.setFont(new Font(Messages.getString("ViewContactDetails.112"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblAdresse, Messages.getString("ViewContactDetails.113")); //$NON-NLS-1$
		
		JScrollPane pnlScrollPaneAdressField = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneAdressField, Messages.getString("ViewContactDetails.114")); //$NON-NLS-1$
		
		textAreaPrivatAdress = new JTextArea();
		this.textAreaPrivatAdress.setDisabledTextColor(getForeground());
		textAreaPrivatAdress.setEditable(false);
		textAreaPrivatAdress.setLineWrap(true);
		textAreaPrivatAdress.setFont(new Font(Messages.getString("ViewContactDetails.115"), Font.PLAIN, 13)); //$NON-NLS-1$
		textAreaPrivatAdress.setEnabled(false);
		pnlScrollPaneAdressField.setViewportView(textAreaPrivatAdress);
		
		JLabel lblPostfach = new JLabel(Messages.getString("ViewContactDetails.116")); //$NON-NLS-1$
		lblPostfach.setFont(new Font(Messages.getString("ViewContactDetails.117"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblPostfach, Messages.getString("ViewContactDetails.118")); //$NON-NLS-1$
		
		this.txtPostfach = new JTextField();
		this.txtPostfach.setDisabledTextColor(getForeground());
		this.txtPostfach.setEditable(false);
		this.txtPostfach.setFont(new Font(Messages.getString("ViewContactDetails.119"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.txtPostfach.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtPostfach, Messages.getString("ViewContactDetails.120")); //$NON-NLS-1$
		this.txtPostfach.setColumns(10);
		
		JLabel lblStadt = new JLabel(Messages.getString("ViewContactDetails.121")); //$NON-NLS-1$
		lblStadt.setFont(new Font(Messages.getString("ViewContactDetails.122"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblStadt, Messages.getString("ViewContactDetails.123")); //$NON-NLS-1$
		
		this.txtCity = new JTextField();
		this.txtCity.setDisabledTextColor(getForeground());
		this.txtCity.setEditable(false);
		this.txtCity.setFont(new Font(Messages.getString("ViewContactDetails.124"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.txtCity.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtCity, Messages.getString("ViewContactDetails.125")); //$NON-NLS-1$
		this.txtCity.setColumns(10);
		
		JLabel lblPostleitzahl = new JLabel(Messages.getString("ViewContactDetails.126")); //$NON-NLS-1$
		lblPostleitzahl.setFont(new Font(Messages.getString("ViewContactDetails.127"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblPostleitzahl, Messages.getString("ViewContactDetails.128")); //$NON-NLS-1$
		
		this.txtZipPlz = new JNumberOnlyTextField();
		this.txtZipPlz.setDisabledTextColor(getForeground());
		this.txtZipPlz.setEditable(false);
		this.txtZipPlz.setFont(new Font(Messages.getString("ViewContactDetails.129"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.txtZipPlz.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtZipPlz, Messages.getString("ViewContactDetails.130")); //$NON-NLS-1$
		this.txtZipPlz.setColumns(10);
		
		JLabel lblBundeststaatprovinz = new JLabel(Messages.getString("ViewContactDetails.131")); //$NON-NLS-1$
		lblBundeststaatprovinz.setFont(new Font(Messages.getString("ViewContactDetails.132"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblBundeststaatprovinz, Messages.getString("ViewContactDetails.133")); //$NON-NLS-1$
		
		this.txtStateProvinz = new JTextField();
		this.txtStateProvinz.setDisabledTextColor(getForeground());
		this.txtStateProvinz.setEditable(false);
		this.txtStateProvinz.setFont(new Font(Messages.getString("ViewContactDetails.134"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.txtStateProvinz.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtStateProvinz, Messages.getString("ViewContactDetails.135")); //$NON-NLS-1$
		this.txtStateProvinz.setColumns(10);
		
		JLabel lblLand = new JLabel(Messages.getString("ViewContactDetails.136")); //$NON-NLS-1$
		lblLand.setFont(new Font(Messages.getString("ViewContactDetails.137"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblLand, Messages.getString("ViewContactDetails.138")); //$NON-NLS-1$
		
		this.txtCountry = new JTextField();
		this.txtCountry.setDisabledTextColor(getForeground());
		this.txtCountry.setEditable(false);
		this.txtCountry.setFont(new Font(Messages.getString("ViewContactDetails.139"), Font.PLAIN, 13)); //$NON-NLS-1$
		this.txtCountry.setEnabled(false);
		pnlContactDetailsPostal.add(this.txtCountry, Messages.getString("ViewContactDetails.140")); //$NON-NLS-1$
		this.txtCountry.setColumns(10);
		
		JLabel lblGeschftlich = new JLabel(Messages.getString("ViewContactDetails.141")); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblGeschftlich, Messages.getString("ViewContactDetails.142")); //$NON-NLS-1$
		lblGeschftlich.setFont(new Font(Messages.getString("ViewContactDetails.143"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JLabel lblAdresse_1 = new JLabel(Messages.getString("ViewContactDetails.144")); //$NON-NLS-1$
		lblAdresse_1.setFont(new Font(Messages.getString("ViewContactDetails.145"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlContactDetailsPostal.add(lblAdresse_1, Messages.getString("ViewContactDetails.146")); //$NON-NLS-1$
		
		JScrollPane pnlScrollPaneBuisnessAdress = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneBuisnessAdress, Messages.getString("ViewContactDetails.147")); //$NON-NLS-1$
		
		textAreaBusinessAdress = new JTextArea();
		this.textAreaBusinessAdress.setDisabledTextColor(getForeground());
		textAreaBusinessAdress.setEditable(false);
		textAreaBusinessAdress.setLineWrap(true);
		textAreaBusinessAdress.setFont(new Font(Messages.getString("ViewContactDetails.148"), Font.PLAIN, 13)); //$NON-NLS-1$
		textAreaBusinessAdress.setEnabled(false);
		pnlScrollPaneBuisnessAdress.setViewportView(textAreaBusinessAdress);
		
		JPanel pnlContactDetailsNotices = new JPanel();
		this.pnlTabbedContactDetails.addTab(Messages.getString("ViewContactDetails.149"), null, pnlContactDetailsNotices, null); //$NON-NLS-1$
		pnlContactDetailsNotices.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContactDetailsNotices.add(scrollPane, BorderLayout.CENTER);
		
		textAreaNotices = new JTextArea();
		this.textAreaNotices.setDisabledTextColor(getForeground());
		textAreaNotices.setEditable(false);
		textAreaNotices.setEnabled(false);
		textAreaNotices.setLineWrap(true);
		textAreaNotices.setFont(new Font(Messages.getString("ViewContactDetails.150"), Font.PLAIN, 13)); //$NON-NLS-1$
		scrollPane.setViewportView(textAreaNotices);
		
		JPanel pnlEditButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlEditButton.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(pnlEditButton, BorderLayout.SOUTH);
		
		this.btnBack = new JButton(Messages.getString("ViewContactDetails.151")); //$NON-NLS-1$
		this.btnBack.setFont(new Font(Messages.getString("ViewContactDetails.152"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlEditButton.add(this.btnBack);
		
		btnUnlock = new JButton( STD_BUTTON_UNLOCK_UNLOCK );
		btnUnlock.addActionListener( new EnableTextFieldsActionListener(this) );
		btnUnlock.setFont(new Font(Messages.getString("ViewContactDetails.153"), Font.BOLD, 13)); //$NON-NLS-1$
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
		this.btnBack.addActionListener( new ReturnToContactsActionListener( viewContacts ) );
		this.btnPicture.addActionListener( new AddPictureActionListener(this) );
	}
	
	public ViewMain getParentFrame(){
		
		return frmMainFrame;
	}
	
	public ViewContacts getViewContact() {
		return viewContacts;
	}
	
	public JTabbedPane getPnlTabbedContactDetails() {
		return pnlTabbedContactDetails;
	}
	
	public Contact getAlreadyExistingContact() {
		return alreadyExistingContact;
	}
	
	public void setAlreadyExistingContact( Contact alreadyExistingContact ) {
		this.alreadyExistingContact = alreadyExistingContact;
	}
	
	public JButton getBtnPicture() {
		return btnPicture;
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
		
		rdbtnPrivateContact.setEnabled(informationEditable);
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
	public JRadioButton getRdbtnPrivateContact() {
		return rdbtnPrivateContact;
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

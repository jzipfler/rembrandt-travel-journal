package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ViewContactDetails extends JPanel {
	private JButton btnBack;
	private JButton btnUnlock;
	private JTabbedPane pnlTabbedContactDetails;
	private JPanel pnlContactDetailsInformations;
	
	private ViewMain frmMainFrame;
	private ViewContacts viewContacts;
	
	
	private static final String STD_BUTTON_UNLOCK_UNLOCK = "Entsperren";
	private static final String STD_BUTTON_UNLOCK_LOCK = "Speichern und Sperren";
	private JTextField textField;
	private JTextField textField_1;
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default)"),
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
		
		JButton btnPicture = new JButton("Picture");
		this.pnlContactDetailsInformations.add(btnPicture, "2, 2, 1, 7");
		
		JLabel lblVorname = new JLabel("Vorname:");
		this.pnlContactDetailsInformations.add(lblVorname, "4, 2, right, default");
		
		this.textField = new JTextField();
		this.pnlContactDetailsInformations.add(this.textField, "6, 2, fill, default");
		this.textField.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname:");
		this.pnlContactDetailsInformations.add(lblNachname, "4, 6, right, default");
		
		this.textField_1 = new JTextField();
		this.pnlContactDetailsInformations.add(this.textField_1, "6, 6, fill, default");
		this.textField_1.setColumns(10);
		this.pnlTabbedContactDetails.setEnabledAt(0, true);
		
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
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlContactDetailsPersonalInformations.add(panel, "2, 2, 3, 1, fill, fill");
		
		JLabel lblWebadressen = new JLabel("Web-Adressen");
		lblWebadressen.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(lblWebadressen);
		
		JLabel lblHomepage = new JLabel("Homepage:");
		lblHomepage.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPersonalInformations.add(lblHomepage, "4, 4, right, default");
		
		this.textField_2 = new JTextField();
		pnlContactDetailsPersonalInformations.add(this.textField_2, "6, 4, fill, default");
		this.textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlContactDetailsPersonalInformations.add(panel_1, "2, 6, 3, 1, fill, fill");
		
		JLabel lblBeruf = new JLabel("Beruf");
		lblBeruf.setFont(new Font("Arial", Font.BOLD, 13));
		panel_1.add(lblBeruf);
		
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
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlContactDetailsPersonalInformations.add(panel_2, "2, 14, 3, 1, fill, fill");
		
		JLabel lblVerschiedenes = new JLabel("Verschiedenes");
		lblVerschiedenes.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(lblVerschiedenes);
		
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel pnlPrivateAdress = new JPanel();
		FlowLayout fl_pnlPrivateAdress = (FlowLayout) pnlPrivateAdress.getLayout();
		fl_pnlPrivateAdress.setAlignment(FlowLayout.LEFT);
		pnlContactDetailsPostal.add(pnlPrivateAdress, "2, 2, 3, 1, fill, fill");
		
		JLabel lblPrivat = new JLabel("Privat");
		lblPrivat.setFont(new Font("Arial", Font.BOLD, 13));
		pnlPrivateAdress.add(lblPrivat);
		
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
		
		JPanel pnlBuisnessAdress = new JPanel();
		FlowLayout fl_pnlBuisnessAdress = (FlowLayout) pnlBuisnessAdress.getLayout();
		fl_pnlBuisnessAdress.setAlignment(FlowLayout.LEFT);
		pnlContactDetailsPostal.add(pnlBuisnessAdress, "2, 18, 5, 1, fill, fill");
		
		JLabel lblGeschftlich = new JLabel("Geschäftlich");
		lblGeschftlich.setFont(new Font("Arial", Font.BOLD, 13));
		pnlBuisnessAdress.add(lblGeschftlich);
		
		JLabel lblAdresse_1 = new JLabel("Adresse:");
		lblAdresse_1.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlContactDetailsPostal.add(lblAdresse_1, "4, 20, right, default");
		
		JScrollPane pnlScrollPaneBuisnessAdress = new JScrollPane();
		pnlContactDetailsPostal.add(pnlScrollPaneBuisnessAdress, "6, 20, 3, 3, fill, fill");
		
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

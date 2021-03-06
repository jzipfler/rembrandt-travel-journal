package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.htwds.rembrandt.components.JTravelInformationTextfield;
import de.htwds.rembrandt.controler.travelview.SaveTravelInformationControler;
import de.htwds.rembrandt.controler.travelview.SetCommentEnableActionListener;
import de.htwds.rembrandt.controler.travelview.SetEditEnableActionListener;
import de.htwds.rembrandt.model.TravelInformationModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
/**
 * 
 * @author Daniel
 * @version 1.2
 */
public class ViewTravelinformation extends JPanel {
	
	private boolean informationEditable = false;
	private boolean commentEditable = false;
	private JTravelInformationTextfield txtCountryInput;
	private JTextField txtCityInput;
	private JTravelInformationTextfield txtArrivalInput;
	private JTextField txtDepartureInput;
	private JTextField txtArrivalStartInput;
	private JTextField txtArrivalDestinationInput;
	private JTextField txtDepartureStartInput;
	private JTextField txtDepartureDestinationInput;
	private JPanel pnlInformationContent;
	private JComboBox cboOptions = new JComboBox();
	private JEditorPane txtpnDescription = new JEditorPane();
	private JButton btnEditDescription;
	private JButton btnEdit;
	private ViewMain mainView;
	private SaveTravelInformationControler controler;
	
	/**
	 * Create the panel.
	 */
	public ViewTravelinformation(ViewMain mainView) {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				if(informationEditable){
					setInformationEditable();
				}
				if(commentEditable){
					setCommentEditable();
				}
			}
		});
		this.mainView = mainView;
		controler = new SaveTravelInformationControler(this, mainView);
		setFont(new Font("Arial", Font.PLAIN, 11));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 3));
		
		JLabel lblHeadline = new JLabel("Reiseinformationen");
		lblHeadline.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblHeadline.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeadline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHeadline.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblHeadline, BorderLayout.NORTH);
		
		JTabbedPane tpnSwitch = new JTabbedPane(JTabbedPane.TOP);
		tpnSwitch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(informationEditable){
					setInformationEditable();
				}
				if(commentEditable){
					setCommentEditable();
				}
			}
		});
		tpnSwitch.setFont(new Font("Arial", Font.BOLD, 13));
		add(tpnSwitch, BorderLayout.CENTER);
		
		JPanel pnlInformation = new JPanel();
		pnlInformation.setFont(new Font("Arial", Font.PLAIN, 13));
		tpnSwitch.addTab("Informationen", null, pnlInformation, null);
		pnlInformation.setLayout(new BorderLayout(0, 0));
		
		pnlInformationContent = new JPanel();
		pnlInformation.add(pnlInformationContent, BorderLayout.NORTH);
		pnlInformationContent.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("15px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(64dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("5px"),},
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
				RowSpec.decode("23px"),
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
		
		JLabel lblLocation = new JLabel("Reiseland und Ort:\r\n");
		lblLocation.setFont(new Font("Arial", Font.BOLD, 13));
		pnlInformationContent.add(lblLocation, "2, 2");
		
		JLabel lblCountry = new JLabel("Land:");
		lblCountry.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblCountry, "2, 4, right, default");
		
		txtCountryInput = new JTravelInformationTextfield();
		txtCountryInput.setEditable(false);
		txtCountryInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtCountryInput, "4, 4, fill, default");
		txtCountryInput.setColumns(10);
		
		JLabel lblCity = new JLabel("Ort:");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblCity, "8, 4, right, default");
		
		txtCityInput = new JTextField();
		txtCityInput.setEditable(false);
		txtCityInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtCityInput, "10, 4, fill, default");
		txtCityInput.setColumns(10);
		
		JLabel lblDateAndTravelInformation = new JLabel("Datum und Reiseart:");
		lblDateAndTravelInformation.setFont(new Font("Arial", Font.BOLD, 13));
		pnlInformationContent.add(lblDateAndTravelInformation, "2, 8");
		
		JLabel lblDateArrival = new JLabel("Anreise:");
		lblDateArrival.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblDateArrival, "2, 10, right, default");
		
		txtArrivalInput = new JTravelInformationTextfield();
		txtArrivalInput.setEditable(false);
		txtArrivalInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtArrivalInput, "4, 10, fill, default");
		txtArrivalInput.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Abreise:");
		lblDeparture.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblDeparture, "8, 10, right, default");
		
		txtDepartureInput = new JTextField();
		txtDepartureInput.setEditable(false);
		txtDepartureInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtDepartureInput, "10, 10, fill, default");
		txtDepartureInput.setColumns(10);
		
		JPanel pnlComboBox = new JPanel();
		pnlInformationContent.add(pnlComboBox, "4, 12, fill, fill");
		pnlComboBox.setLayout(new BorderLayout(0, 0));
		
		cboOptions.setEnabled(false);
		cboOptions.setFont(new Font("Arial", Font.PLAIN, 13));
		cboOptions.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Bus", "Fahrrad", "Flugzeug", "Motorrad", "Schiff", "Zug"}));
		pnlComboBox.add(cboOptions);
		
		JLabel lblDirections = new JLabel("Reisewege:");
		lblDirections.setFont(new Font("Arial", Font.BOLD, 13));
		pnlInformationContent.add(lblDirections, "2, 16");
		
		JLabel lblArrivalDirections = new JLabel("Anreise");
		lblArrivalDirections.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblArrivalDirections, "2, 18");
		
		JLabel lblArrivalStart = new JLabel("Start :");
		lblArrivalStart.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblArrivalStart, "2, 20, right, default");
		
		txtArrivalStartInput = new JTextField();
		txtArrivalStartInput.setEditable(false);
		txtArrivalStartInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtArrivalStartInput, "4, 20, fill, default");
		txtArrivalStartInput.setColumns(10);
		
		JLabel lblArrivalDestination = new JLabel("Ziel :");
		lblArrivalDestination.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblArrivalDestination, "8, 20, right, default");
		
		txtArrivalDestinationInput = new JTextField();
		txtArrivalDestinationInput.setEditable(false);
		txtArrivalDestinationInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtArrivalDestinationInput, "10, 20, fill, default");
		txtArrivalDestinationInput.setColumns(10);
		
		JLabel lblDepartureDirections = new JLabel("Abreise:");
		lblDepartureDirections.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblDepartureDirections, "2, 22");
		
		JLabel lblDepartureStart = new JLabel("Start :");
		lblDepartureStart.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblDepartureStart, "2, 24, right, default");
		
		txtDepartureStartInput = new JTextField();
		txtDepartureStartInput.setEditable(false);
		txtDepartureStartInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtDepartureStartInput, "4, 24, fill, default");
		txtDepartureStartInput.setColumns(10);
		
		JLabel lblDepartureDestination = new JLabel("Ziel :");
		lblDepartureDestination.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(lblDepartureDestination, "8, 24, right, default");
		
		txtDepartureDestinationInput = new JTextField();
		txtDepartureDestinationInput.setEditable(false);
		txtDepartureDestinationInput.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlInformationContent.add(txtDepartureDestinationInput, "10, 24, fill, default");
		txtDepartureDestinationInput.setColumns(10);
		
		JPanel pnlEditbuttonContainer = new JPanel();
		pnlInformation.add(pnlEditbuttonContainer, BorderLayout.SOUTH);
		
		btnEdit = new JButton("Bearbeiten");
		btnEdit.setFont(new Font("Arial", Font.PLAIN, 13));
		btnEdit.addActionListener(new SetEditEnableActionListener(this));
		pnlEditbuttonContainer.add(btnEdit);
		
		JPanel pnlComment = new JPanel();
		tpnSwitch.addTab("Kommentar", null, pnlComment, null);
		pnlComment.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlContentContainer = new JPanel();
		pnlContentContainer.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlComment.add(pnlContentContainer, BorderLayout.CENTER);
		pnlContentContainer.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTextfieldLabel = new JLabel("Kommentar zur Reise und Beschreibung:");
		pnlContentContainer.add(lblTextfieldLabel, BorderLayout.NORTH);
		lblTextfieldLabel.setFont(new Font("Arial", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContentContainer.add(scrollPane, BorderLayout.CENTER);
		txtpnDescription.setEditable(false);
		
		scrollPane.setViewportView(txtpnDescription);
		txtpnDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JPanel pnlButtonContainer = new JPanel();
		pnlContentContainer.add(pnlButtonContainer, BorderLayout.SOUTH);
		
		btnEditDescription = new JButton("Bearbeiten");
		btnEditDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		btnEditDescription.addActionListener(new SetCommentEnableActionListener(this));
		pnlButtonContainer.add(btnEditDescription);

	}
	
	/**
	 * Method to set all the textfields editable
	 */
	public void setInformationEditable(){
		informationEditable = (!informationEditable);
		txtArrivalDestinationInput.setEditable(informationEditable);
		//txtArrivalInput.setEditable(informationEditable); //Noch nicht editierbar, da sonst Ordnername falsch
		txtArrivalStartInput.setEditable(informationEditable);
		txtCityInput.setEditable(informationEditable);
		//txtCountryInput.setEditable(informationEditable); //Noch nicht editierbar, da sonst Ordnername falsch
		txtDepartureDestinationInput.setEditable(informationEditable);
		txtDepartureInput.setEditable(informationEditable);
		txtDepartureStartInput.setEditable(informationEditable);
		cboOptions.setEnabled(informationEditable);
		if(informationEditable){
			btnEdit.setText("Speichern");
		} else {
			btnEdit.setText("Bearbeiten");
			controler.save();
		}
	}
	
	/**
	 * Method to set all the comment field editable
	 */
	public void setCommentEditable(){
		commentEditable = (!commentEditable);
		txtpnDescription.setEditable(commentEditable);
		if(commentEditable){
			btnEditDescription.setText("Speichern");
		} else {
			btnEditDescription.setText("Bearbeiten");
			controler.save();
		}
	}
	
	public void readData(TravelInformationModel data){
		txtCountryInput.setText(data.getCountry());
		txtCityInput.setText(data.getCity());
		txtArrivalInput.setText(data.getDateArrival());
		txtDepartureInput.setText(data.getDateDeparture());
		cboOptions.setSelectedIndex(data.getOption());
		txtArrivalDestinationInput.setText(data.getArrivalDestination());
		txtArrivalStartInput.setText(data.getArrivalStart());
		txtDepartureDestinationInput.setText(data.getDepartureDestionation());
		txtDepartureStartInput.setText(data.getDepartureStart());
		txtpnDescription.setText(data.getComment());
	}
	
	public ViewMain getMainView(){
		return mainView;
	}
	
	public String getCountryText(){
		return txtCountryInput.getText();
	}
	
	public String getCityText(){
		return txtCityInput.getText();
	}
	
	public String getArrivalText(){
		return txtArrivalInput.getText();
	}
	
	public String getDaprtureText(){
		return txtDepartureInput.getText();
	}
	
	public String getArrivalDestinationText(){
		return txtArrivalDestinationInput.getText();
	}
	
	public String getArrivalStartText(){
		return txtArrivalStartInput.getText();
	}
	
	public String getDepartureStartText(){
		return txtDepartureStartInput.getText();
	}
	
	public String getDepartureDestinationText(){
		return txtDepartureDestinationInput.getText();
	}
	
	public int getOptionsInput(){
		return cboOptions.getSelectedIndex();
	}
	
	public String getCommentText(){
		return txtpnDescription.getText();
	}
}

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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
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
			@Override
			public void ancestorAdded(AncestorEvent event) {
			}
			@Override
			public void ancestorMoved(AncestorEvent event) {
			}
			@Override
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
		setFont(new Font(Messages.getString("ViewTravelinformation.0"), Font.PLAIN, 11)); //$NON-NLS-1$
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 3));
		
		JLabel lblHeadline = new JLabel(Messages.getString("ViewTravelinformation.1")); //$NON-NLS-1$
		lblHeadline.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblHeadline.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeadline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHeadline.setFont(new Font(Messages.getString("ViewTravelinformation.2"), Font.BOLD, 15)); //$NON-NLS-1$
		add(lblHeadline, BorderLayout.NORTH);
		
		JTabbedPane tpnSwitch = new JTabbedPane(SwingConstants.TOP);
		tpnSwitch.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(informationEditable){
					setInformationEditable();
				}
				if(commentEditable){
					setCommentEditable();
				}
			}
		});
		tpnSwitch.setFont(new Font(Messages.getString("ViewTravelinformation.3"), Font.BOLD, 13)); //$NON-NLS-1$
		add(tpnSwitch, BorderLayout.CENTER);
		
		JPanel pnlInformation = new JPanel();
		pnlInformation.setFont(new Font(Messages.getString("ViewTravelinformation.4"), Font.PLAIN, 13)); //$NON-NLS-1$
		tpnSwitch.addTab(Messages.getString("ViewTravelinformation.5"), null, pnlInformation, null); //$NON-NLS-1$
		pnlInformation.setLayout(new BorderLayout(0, 0));
		
		pnlInformationContent = new JPanel();
		pnlInformation.add(pnlInformationContent, BorderLayout.NORTH);
		pnlInformationContent.setFont(new Font(Messages.getString("ViewTravelinformation.6"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewTravelinformation.7")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewTravelinformation.8")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewTravelinformation.9")), //$NON-NLS-1$
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode(Messages.getString("ViewTravelinformation.10")),}, //$NON-NLS-1$
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
				RowSpec.decode(Messages.getString("ViewTravelinformation.11")), //$NON-NLS-1$
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
		
		JLabel lblLocation = new JLabel(Messages.getString("ViewTravelinformation.12")); //$NON-NLS-1$
		lblLocation.setFont(new Font(Messages.getString("ViewTravelinformation.13"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblLocation, Messages.getString("ViewTravelinformation.14")); //$NON-NLS-1$
		
		JLabel lblCountry = new JLabel(Messages.getString("ViewTravelinformation.15")); //$NON-NLS-1$
		lblCountry.setFont(new Font(Messages.getString("ViewTravelinformation.16"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblCountry, Messages.getString("ViewTravelinformation.17")); //$NON-NLS-1$
		
		txtCountryInput = new JTravelInformationTextfield();
		txtCountryInput.setEditable(false);
		txtCountryInput.setFont(new Font(Messages.getString("ViewTravelinformation.18"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtCountryInput, Messages.getString("ViewTravelinformation.19")); //$NON-NLS-1$
		txtCountryInput.setColumns(10);
		
		JLabel lblCity = new JLabel(Messages.getString("ViewTravelinformation.20")); //$NON-NLS-1$
		lblCity.setFont(new Font(Messages.getString("ViewTravelinformation.21"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblCity, Messages.getString("ViewTravelinformation.22")); //$NON-NLS-1$
		
		txtCityInput = new JTextField();
		txtCityInput.setEditable(false);
		txtCityInput.setFont(new Font(Messages.getString("ViewTravelinformation.23"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtCityInput, Messages.getString("ViewTravelinformation.24")); //$NON-NLS-1$
		txtCityInput.setColumns(10);
		
		JLabel lblDateAndTravelInformation = new JLabel(Messages.getString("ViewTravelinformation.25")); //$NON-NLS-1$
		lblDateAndTravelInformation.setFont(new Font(Messages.getString("ViewTravelinformation.26"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDateAndTravelInformation, Messages.getString("ViewTravelinformation.27")); //$NON-NLS-1$
		
		JLabel lblDateArrival = new JLabel(Messages.getString("ViewTravelinformation.28")); //$NON-NLS-1$
		lblDateArrival.setFont(new Font(Messages.getString("ViewTravelinformation.29"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDateArrival, Messages.getString("ViewTravelinformation.30")); //$NON-NLS-1$
		
		txtArrivalInput = new JTravelInformationTextfield();
		txtArrivalInput.setEditable(false);
		txtArrivalInput.setFont(new Font(Messages.getString("ViewTravelinformation.31"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtArrivalInput, Messages.getString("ViewTravelinformation.32")); //$NON-NLS-1$
		txtArrivalInput.setColumns(10);
		
		JLabel lblDeparture = new JLabel(Messages.getString("ViewTravelinformation.33")); //$NON-NLS-1$
		lblDeparture.setFont(new Font(Messages.getString("ViewTravelinformation.34"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDeparture, Messages.getString("ViewTravelinformation.35")); //$NON-NLS-1$
		
		txtDepartureInput = new JTextField();
		txtDepartureInput.setEditable(false);
		txtDepartureInput.setFont(new Font(Messages.getString("ViewTravelinformation.36"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtDepartureInput, Messages.getString("ViewTravelinformation.37")); //$NON-NLS-1$
		txtDepartureInput.setColumns(10);
		
		JPanel pnlComboBox = new JPanel();
		pnlInformationContent.add(pnlComboBox, Messages.getString("ViewTravelinformation.38")); //$NON-NLS-1$
		pnlComboBox.setLayout(new BorderLayout(0, 0));
		
		cboOptions.setEnabled(false);
		cboOptions.setFont(new Font(Messages.getString("ViewTravelinformation.39"), Font.PLAIN, 13)); //$NON-NLS-1$
		cboOptions.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("ViewTravelinformation.40"), Messages.getString("ViewTravelinformation.41"), Messages.getString("ViewTravelinformation.42"), Messages.getString("ViewTravelinformation.43"), Messages.getString("ViewTravelinformation.44"), Messages.getString("ViewTravelinformation.45"), Messages.getString("ViewTravelinformation.46")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		pnlComboBox.add(cboOptions);
		
		JLabel lblDirections = new JLabel(Messages.getString("ViewTravelinformation.47")); //$NON-NLS-1$
		lblDirections.setFont(new Font(Messages.getString("ViewTravelinformation.48"), Font.BOLD, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDirections, Messages.getString("ViewTravelinformation.49")); //$NON-NLS-1$
		
		JLabel lblArrivalDirections = new JLabel(Messages.getString("ViewTravelinformation.50")); //$NON-NLS-1$
		lblArrivalDirections.setFont(new Font(Messages.getString("ViewTravelinformation.51"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblArrivalDirections, Messages.getString("ViewTravelinformation.52")); //$NON-NLS-1$
		
		JLabel lblArrivalStart = new JLabel(Messages.getString("ViewTravelinformation.53")); //$NON-NLS-1$
		lblArrivalStart.setFont(new Font(Messages.getString("ViewTravelinformation.54"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblArrivalStart, Messages.getString("ViewTravelinformation.55")); //$NON-NLS-1$
		
		txtArrivalStartInput = new JTextField();
		txtArrivalStartInput.setEditable(false);
		txtArrivalStartInput.setFont(new Font(Messages.getString("ViewTravelinformation.56"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtArrivalStartInput, Messages.getString("ViewTravelinformation.57")); //$NON-NLS-1$
		txtArrivalStartInput.setColumns(10);
		
		JLabel lblArrivalDestination = new JLabel(Messages.getString("ViewTravelinformation.58")); //$NON-NLS-1$
		lblArrivalDestination.setFont(new Font(Messages.getString("ViewTravelinformation.59"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblArrivalDestination, Messages.getString("ViewTravelinformation.60")); //$NON-NLS-1$
		
		txtArrivalDestinationInput = new JTextField();
		txtArrivalDestinationInput.setEditable(false);
		txtArrivalDestinationInput.setFont(new Font(Messages.getString("ViewTravelinformation.61"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtArrivalDestinationInput, Messages.getString("ViewTravelinformation.62")); //$NON-NLS-1$
		txtArrivalDestinationInput.setColumns(10);
		
		JLabel lblDepartureDirections = new JLabel(Messages.getString("ViewTravelinformation.63")); //$NON-NLS-1$
		lblDepartureDirections.setFont(new Font(Messages.getString("ViewTravelinformation.64"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDepartureDirections, Messages.getString("ViewTravelinformation.65")); //$NON-NLS-1$
		
		JLabel lblDepartureStart = new JLabel(Messages.getString("ViewTravelinformation.66")); //$NON-NLS-1$
		lblDepartureStart.setFont(new Font(Messages.getString("ViewTravelinformation.67"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDepartureStart, Messages.getString("ViewTravelinformation.68")); //$NON-NLS-1$
		
		txtDepartureStartInput = new JTextField();
		txtDepartureStartInput.setEditable(false);
		txtDepartureStartInput.setFont(new Font(Messages.getString("ViewTravelinformation.69"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtDepartureStartInput, Messages.getString("ViewTravelinformation.70")); //$NON-NLS-1$
		txtDepartureStartInput.setColumns(10);
		
		JLabel lblDepartureDestination = new JLabel(Messages.getString("ViewTravelinformation.71")); //$NON-NLS-1$
		lblDepartureDestination.setFont(new Font(Messages.getString("ViewTravelinformation.72"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(lblDepartureDestination, Messages.getString("ViewTravelinformation.73")); //$NON-NLS-1$
		
		txtDepartureDestinationInput = new JTextField();
		txtDepartureDestinationInput.setEditable(false);
		txtDepartureDestinationInput.setFont(new Font(Messages.getString("ViewTravelinformation.74"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlInformationContent.add(txtDepartureDestinationInput, Messages.getString("ViewTravelinformation.75")); //$NON-NLS-1$
		txtDepartureDestinationInput.setColumns(10);
		
		JPanel pnlEditbuttonContainer = new JPanel();
		pnlInformation.add(pnlEditbuttonContainer, BorderLayout.SOUTH);
		
		btnEdit = new JButton(Messages.getString("ViewTravelinformation.76")); //$NON-NLS-1$
		btnEdit.setFont(new Font(Messages.getString("ViewTravelinformation.77"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnEdit.addActionListener(new SetEditEnableActionListener(this));
		pnlEditbuttonContainer.add(btnEdit);
		
		JPanel pnlComment = new JPanel();
		tpnSwitch.addTab(Messages.getString("ViewTravelinformation.78"), null, pnlComment, null); //$NON-NLS-1$
		pnlComment.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlContentContainer = new JPanel();
		pnlContentContainer.setFont(new Font(Messages.getString("ViewTravelinformation.79"), Font.PLAIN, 11)); //$NON-NLS-1$
		pnlComment.add(pnlContentContainer, BorderLayout.CENTER);
		pnlContentContainer.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTextfieldLabel = new JLabel(Messages.getString("ViewTravelinformation.80")); //$NON-NLS-1$
		pnlContentContainer.add(lblTextfieldLabel, BorderLayout.NORTH);
		lblTextfieldLabel.setFont(new Font(Messages.getString("ViewTravelinformation.81"), Font.BOLD, 13)); //$NON-NLS-1$
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContentContainer.add(scrollPane, BorderLayout.CENTER);
		txtpnDescription.setEditable(false);
		
		scrollPane.setViewportView(txtpnDescription);
		txtpnDescription.setFont(new Font(Messages.getString("ViewTravelinformation.82"), Font.PLAIN, 13)); //$NON-NLS-1$
		
		JPanel pnlButtonContainer = new JPanel();
		pnlContentContainer.add(pnlButtonContainer, BorderLayout.SOUTH);
		
		btnEditDescription = new JButton(Messages.getString("ViewTravelinformation.83")); //$NON-NLS-1$
		btnEditDescription.setFont(new Font(Messages.getString("ViewTravelinformation.84"), Font.PLAIN, 13)); //$NON-NLS-1$
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
			btnEdit.setText(Messages.getString("ViewTravelinformation.85")); //$NON-NLS-1$
		} else {
			btnEdit.setText(Messages.getString("ViewTravelinformation.86")); //$NON-NLS-1$
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
			btnEditDescription.setText(Messages.getString("ViewTravelinformation.87")); //$NON-NLS-1$
		} else {
			btnEditDescription.setText(Messages.getString("ViewTravelinformation.88")); //$NON-NLS-1$
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

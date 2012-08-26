package de.htwds.rembrandt.view;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewTravelinformation extends JPanel {
	private JTextField txtCountryInput;
	private JTextField txtCityInput;
	private JTextField txtArrivalInput;
	private JTextField txtDepartureInput;

	/**
	 * Create the panel.
	 */
	public ViewTravelinformation() {
		setFont(new Font("Arial", Font.PLAIN, 11));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 3));
		
		JLabel lblHeadline = new JLabel("Reiseinformationen");
		lblHeadline.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblHeadline.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeadline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHeadline.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblHeadline, BorderLayout.NORTH);
		
		JPanel pnlViewContent = new JPanel();
		pnlViewContent.setFont(new Font("Arial", Font.PLAIN, 11));
		add(pnlViewContent, BorderLayout.CENTER);
		pnlViewContent.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLocation = new JLabel("Reiseland und Ort:\r\n");
		lblLocation.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblLocation, "2, 2");
		
		JLabel lblCountry = new JLabel("Land:");
		lblCountry.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblCountry, "2, 4, right, default");
		
		txtCountryInput = new JTextField();
		txtCountryInput.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(txtCountryInput, "4, 4, fill, default");
		txtCountryInput.setColumns(10);
		
		JLabel lblCity = new JLabel("Ort:");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblCity, "8, 4, right, default");
		
		txtCityInput = new JTextField();
		txtCityInput.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(txtCityInput, "10, 4, fill, default");
		txtCityInput.setColumns(10);
		
		JLabel lblDateAndTravelInformation = new JLabel("Datum und Reiseart:");
		lblDateAndTravelInformation.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblDateAndTravelInformation, "2, 8");
		
		JLabel lblDateArrival = new JLabel("Anreise:");
		lblDateArrival.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblDateArrival, "2, 10, right, default");
		
		txtArrivalInput = new JTextField();
		txtArrivalInput.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(txtArrivalInput, "4, 10, fill, default");
		txtArrivalInput.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Abreise:");
		lblDeparture.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblDeparture, "8, 10, right, default");
		
		txtDepartureInput = new JTextField();
		txtDepartureInput.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(txtDepartureInput, "10, 10, fill, default");
		txtDepartureInput.setColumns(10);
		
		JPanel pnlComboBox = new JPanel();
		pnlViewContent.add(pnlComboBox, "4, 12, fill, fill");
		pnlComboBox.setLayout(new BorderLayout(0, 0));
		
		JComboBox cboOptions = new JComboBox();
		cboOptions.setFont(new Font("Arial", Font.PLAIN, 11));
		cboOptions.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Bus", "Fahrrad", "Flugzeug", "Motorrad", "Schiff", "Zug"}));
		pnlComboBox.add(cboOptions);
		
		JLabel lblDirections = new JLabel("Reisewege:");
		lblDirections.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlViewContent.add(lblDirections, "2, 16");

	}

}

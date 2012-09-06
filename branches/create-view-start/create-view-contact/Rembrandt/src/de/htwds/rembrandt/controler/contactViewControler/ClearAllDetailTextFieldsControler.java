package de.htwds.rembrandt.controler.contactViewControler;

import de.htwds.rembrandt.view.ViewContactDetails;

public class ClearAllDetailTextFieldsControler {

	private ViewContactDetails viewContactDetails;
	
	public ClearAllDetailTextFieldsControler( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	public void clearAllTextFields() {
		viewContactDetails.getTxtFirstName().setText(null);
		viewContactDetails.getTxtLastName().setText(null);
		viewContactDetails.getTxtPostfach().setText(null);
		viewContactDetails.getTxtCity().setText(null);
		viewContactDetails.getTxtZipPlz().setText(null);
		viewContactDetails.getTxtStateProvinz().setText(null);
		viewContactDetails.getTxtCountry().setText(null);
		viewContactDetails.getTxtHomepage().setText(null);
		viewContactDetails.getTxtJob().setText(null);
		viewContactDetails.getTxtCompany().setText(null);
		viewContactDetails.getTxtDepartment().setText(null);
		viewContactDetails.getTxtOffice().setText(null);
		viewContactDetails.getTxtSpouses().setText(null);
		viewContactDetails.getTxtPrivatMail().setText(null);
		viewContactDetails.getTxtBusinessMail().setText(null);
		viewContactDetails.getTxtPrivatPhone().setText(null);
		viewContactDetails.getTxtBusinessPhone().setText(null);
				
		viewContactDetails.getTextAreaPrivatAdress().setText(null);
		viewContactDetails.getTextAreaBusinessAdress().setText(null);
		viewContactDetails.getTextAreaNotices().setText(null);
	}
}

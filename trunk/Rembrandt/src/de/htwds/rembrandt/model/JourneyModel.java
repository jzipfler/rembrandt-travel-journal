package de.htwds.rembrandt.model;

/**
 * 
 * @author Jan Zipfler
 * @version sFey 15.09.12
 *
 * Superclass for all model classes, needed to get the data for the rembrandt project.
 */
public class JourneyModel {
	
	private JourneyContactListsModel contactListModel;
	private TravelInformationModel travelInformation;
	private GeneralInformationModel generalInformation;
	private GeneralInformationModel[] generalInformationArray;
	private CheckListInformationModel checklistInformation;
	
	/*
	 * Your implementation here
	 */
	
	public JourneyModel() {
		contactListModel = new JourneyContactListsModel();
		checklistInformation = new CheckListInformationModel();
	}
	
	public JourneyContactListsModel getContactListModel() {
		return contactListModel;
	}
	
	public void setTravelInformation(TravelInformationModel travelInformation){
		this.travelInformation = travelInformation;
	}
	
	public TravelInformationModel getTravelInformation(){
		return travelInformation;
	}
	
	
	public void setGeneralInformationModel(GeneralInformationModel generalInformation){
		this.generalInformation = generalInformation;
	}
	
	public GeneralInformationModel getGeneralInformationModel(){
		return generalInformation;
	}
	
	public GeneralInformationModel[] getGeneralInformationArray() {
		return generalInformationArray;
	}
	
	public void setGeneralInformationModelArray( GeneralInformationModel[] generalInformationArray ) {
		this.generalInformationArray = generalInformationArray;
	}
	
	public void setCheckListInformationModel(CheckListInformationModel checklistInformation)
	{
		this.checklistInformation = checklistInformation;
	}
	
	public CheckListInformationModel getCheckListInformationModel()
	{
		return this.checklistInformation;
	}
	
	// photoAlbumModel 
	private PhotoAlbumModel photoAlbumModel;
	
	public void setPhotoAlbumModel( PhotoAlbumModel photoAlbumModel ) { this.photoAlbumModel = photoAlbumModel; }
	public PhotoAlbumModel getPhotoAlbumModel() { return this.photoAlbumModel; }
}

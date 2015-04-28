package de.htwds.rembrandt.model;

import java.io.Serializable;

public class GeneralInformationModel implements Serializable {
	
	private String city;
	private String country;
	private String dateArrival;
	private String dateDeparture;
	
	
	public GeneralInformationModel(String city, String country, String dateArrival, String dateDeparture){
		this.city 			= city;
		this.country 		= country;
		this.dateArrival 	= dateArrival;
		this.dateDeparture 	= dateDeparture;	
	}
	
	
	//Getter
	
	public String getCity(){
		return city;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getDateArrival(){
		return dateArrival;
	}
	
	public String getDateDeparture(){
		return dateDeparture;
	}
	
	public String getFolderName(){
		return country + Messages.getString("GeneralInformationModel.0") + dateArrival; //$NON-NLS-1$
	}
	
	public void setCountryAndArrivalFromFolderName( String countryAndArrivalString ) {
		
		String[] countryAndArrivalArray = countryAndArrivalString.split(Messages.getString("GeneralInformationModel.1")); //$NON-NLS-1$
		setCity(countryAndArrivalArray[0]);
		setDateArrival(countryAndArrivalArray[1]);
	}
	
	//Setter
	
	public void setCity(String newCity){
		city = newCity;
	}
	
	public void setCountry(String newCountry){
		country = newCountry;
	}
	
	public void setDateArrival(String newDateArrival){
		dateArrival = newDateArrival;
	}
	
	public void setDateDeparture(String newDateDeparture){
		dateDeparture = newDateDeparture;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof GeneralInformationModel)) return false;
		return getFolderName().equals(((GeneralInformationModel)o).getFolderName());
	}
	
	@Override
	public String toString() {
		return getFolderName();
	}
}

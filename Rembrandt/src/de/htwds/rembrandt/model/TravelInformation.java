package de.htwds.rembrandt.model;

/**
 * Class for all the gathered information about the journey.
 * 
 * @author Daniel
 * @version 1.0
 */
public class TravelInformation {
	
	//Fields
	private String country;
	private String city;
	private String dateArrival;
	private String dateDeparture;
	private int option;
	private String locationArrivalStart;
	private String locationArrivalDestination;
	private String locationDepartureStart;
	private String locationDepartureDestination;
	private String comment;
	
	/**
	 * Constructor for the TravelInformation-class.
	 * @param country 		- The country of the journey
	 * @param city 			- The city of the Journey
	 * @param dateA 		- The first day of the journey
	 * @param dateD 		- The last day of the journey
	 * @param option 		- The option choosed to travel
	 * @param arrivalS 		- The start location for the travelroute
	 * @param arrivalD 		- The destionation for the travelroute
	 * @param departueS 	- The start location for the travel back home
	 * @param departureD 	- The destination for the travel back home
	 */
	public TravelInformation(String country, String city, String dateA, String dateD, int option, String arrivalS, String arrivalD, String departureS, String departureD){
		this.country 					= country;
		this.city 						= city;
		dateArrival 					= dateA;
		dateDeparture 					= dateD;
		this.option 					= option;
		locationArrivalStart 			= arrivalS;
		locationArrivalDestination 		= arrivalD;
		locationDepartureStart 			= departureS;
		locationDepartureDestination 	= departureD;
	}
	
	//Getter
	
	public String getCountry(){
		return country;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getDateArrival(){
		return dateArrival;
	}
	
	public String getDateDeparture(){
		return dateDeparture;
	}
	
	public int getOption(){
		return option;
	}
	
	public String getArrivalStart(){
		return locationArrivalStart;
	}
	
	public String getArrivalDestination(){
		return locationArrivalDestination;
	}
	
	public String getDepartureStart(){
		return locationDepartureStart;
	}
	
	public String getDepartureDestionation(){
		return locationDepartureDestination;
	}
	
	public String getComment(){
		return comment;
	}
	
	//Setter
	
	public void setCountry(String newCountry){
		country = newCountry;
	}
	
	public void setCity(String newCity){
		city = newCity;
	}
	
	public void setDateA(String newDate){
		dateArrival = newDate;
	}
	
	public void setDateD(String newDate){
		dateDeparture = newDate;
	}
	
	public void setOption(int newOption){
		option = newOption;
	}
	
	public void setArrivalStart(String newArrivalStart){
		locationArrivalStart = newArrivalStart;
	}
	
	public void setArrivalDestination(String newArrivalDestination){
		locationArrivalDestination = newArrivalDestination;
	}
	
	public void setDepartureStart(String newDepartureStart){
		locationDepartureStart = newDepartureStart;
	}
	
	public void setDepartureDestination(String newDepartureDestination){
		locationDepartureDestination = newDepartureDestination;
	}
	
	public void setComment(String newComment){
		comment = newComment;
	}
}

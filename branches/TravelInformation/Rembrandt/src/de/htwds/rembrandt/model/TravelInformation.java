package de.htwds.rembrandt.model;

/**
 * Class for all the gathered information about the journey.
 * 
 * @author Daniel
 * @version 1.0
 */
public class TravelInformation {
	
	//Constants
	private String country;
	private String city;
	private String dateArrival;
	private String dateDeparture;
	private int option;
	private String locationArrivalStart;
	private String locationArrivalDestination;
	private String locationDepartureStart;
	private String locationDepartureDestination;
	
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
}

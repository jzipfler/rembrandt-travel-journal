package de.htwds.rembrandt.model;

import de.htwds.rembrandt.exception.ContactException;

public class Contact {

	private String firstName;
	private String lastName;
	private String postfach;
	private String city;
	private int zipPlz;
	private String stateProvinz;
	private String country;
	private String homepage;
	private String job;
	private String company;
	private String department;
	private String office;
	private String spouses;
	private String privatMail;
	private String businessMail;
	private int privatPhone;
	private int businessPhone;
	private String privatAdress;
	private String businessAdress;
	private String notices;
	
	/**
	 * Minimum constructor that creates a contact only with his first an last name.
	 * @param firstname
	 * @param lastname
	 * @throws ContactException
	 */
	public Contact( String firstName, String lastName ) throws ContactException {
		ContactException.firstNameEmpty( firstName );
		ContactException.lastNameEmpty( lastName );
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Constructor with all parameters needed for that contact
	 * 
	 * @param firstName
	 * @param lastName
	 * @param postfach
	 * @param city
	 * @param zipPlz
	 * @param stateProvinz
	 * @param country
	 * @param homepage
	 * @param job
	 * @param company
	 * @param department
	 * @param office
	 * @param spouses
	 * @param privatMail
	 * @param businessMail
	 * @param privatPhone
	 * @param businessPhone
	 * @param privatAdress
	 * @param businessAdress
	 * @param notices
	 * @throws ContactException
	 */
	public Contact(	String firstName, String lastName, String postfach,
					String city, int zipPlz, String stateProvinz, String country,
					String homepage, String job, String company, String department,
					String office, String spouses, String privatMail,
					String businessMail, int privatPhone, int businessPhone,
					String privatAdress, String businessAdress, String notices) throws ContactException {
		
		ContactException.firstNameEmpty( firstName );
		ContactException.lastNameEmpty( lastName );
		this.firstName = firstName;
		this.lastName = lastName;
		this.postfach = postfach;
		this.city = city;
		this.zipPlz = zipPlz;
		this.stateProvinz = stateProvinz;
		this.country = country;
		this.homepage = homepage;
		this.job = job;
		this.company = company;
		this.department = department;
		this.office = office;
		this.spouses = spouses;
		this.privatMail = privatMail;
		this.businessMail = businessMail;
		this.privatPhone = privatPhone;
		this.businessPhone = businessPhone;
		this.privatAdress = privatAdress;
		this.businessAdress = businessAdress;
		this.notices = notices;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the postfach
	 */
	public String getPostfach() {
		return postfach;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the zipPlz
	 */
	public int getZipPlz() {
		return zipPlz;
	}

	/**
	 * @return the stateProvinz
	 */
	public String getStateProvinz() {
		return stateProvinz;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the homepage
	 */
	public String getHomepage() {
		return homepage;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * @return the spouses
	 */
	public String getSpouses() {
		return spouses;
	}

	/**
	 * @return the privatMail
	 */
	public String getPrivatMail() {
		return privatMail;
	}

	/**
	 * @return the businessMail
	 */
	public String getBusinessMail() {
		return businessMail;
	}

	/**
	 * @return the privatPhone
	 */
	public int getPrivatPhone() {
		return privatPhone;
	}

	/**
	 * @return the businessPhone
	 */
	public int getBusinessPhone() {
		return businessPhone;
	}

	/**
	 * @return the privatAdress
	 */
	public String getPrivatAdress() {
		return privatAdress;
	}

	/**
	 * @return the businessAdress
	 */
	public String getBusinessAdress() {
		return businessAdress;
	}

	/**
	 * @return the notices
	 */
	public String getNotices() {
		return notices;
	}

	/*
	 * ##################################################################
	 * Setter
	 * ##################################################################
	 */
	
	/**
	 * @param firstName the firstName to set
	 * @throws ContactException
	 */
	public void setFirstName(String firstName) throws ContactException {
		ContactException.firstNameEmpty( firstName );
		
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 * @throws ContactException
	 */
	public void setLastName(String lastName) throws ContactException {
		ContactException.lastNameEmpty( lastName );
		this.lastName = lastName;
	}

	/**
	 * @param postfach the postfach to set
	 */
	public void setPostfach(String postfach) {
		this.postfach = postfach;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param zipPlz the zipPlz to set
	 */
	public void setZipPlz(int zipPlz) {
		this.zipPlz = zipPlz;
	}

	/**
	 * @param stateProvinz the stateProvinz to set
	 */
	public void setStateProvinz(String stateProvinz) {
		this.stateProvinz = stateProvinz;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param homepage the homepage to set
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * @param spouses the spouses to set
	 */
	public void setSpouses(String spouses) {
		this.spouses = spouses;
	}

	/**
	 * @param privatMail the privatMail to set
	 */
	public void setPrivatMail(String privatMail) {
		this.privatMail = privatMail;
	}

	/**
	 * @param businessMail the businessMail to set
	 */
	public void setBusinessMail(String businessMail) {
		this.businessMail = businessMail;
	}

	/**
	 * @param privatPhone the privatPhone to set
	 */
	public void setPrivatPhone(int privatPhone) {
		this.privatPhone = privatPhone;
	}

	/**
	 * @param businessPhone the businessPhone to set
	 */
	public void setBusinessPhone(int businessPhone) {
		this.businessPhone = businessPhone;
	}

	/**
	 * @param privatAdress the privatAdress to set
	 */
	public void setPrivatAdress(String privatAdress) {
		this.privatAdress = privatAdress;
	}

	/**
	 * @param businessAdress the businessAdress to set
	 */
	public void setBusinessAdress(String businessAdress) {
		this.businessAdress = businessAdress;
	}

	/**
	 * @param notices the notices to set
	 */
	public void setNotices(String notices) {
		this.notices = notices;
	}
}
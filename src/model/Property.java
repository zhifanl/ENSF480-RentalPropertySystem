package model;

/**
 * Represents a housing property
 */
public class Property {
	private int id;
	private Address address;
	private String address_toString;
	private String house_type;
	private int bedrooms;
	private int bathrooms;
	private boolean furnished;
	private String city_quadrant;
	private int landlord_id;
	private String landlord_name;
	private String email_of_landlord;
	private long time_listed;
	private String status;
	
	/**
	 * Creates a property class with an ID, address, info about the interior,
	 * and the status of the house
	 * @param id the unique ID of the property
	 * @param address the address that the house is located at
	 * @param house_type the type of house the property is
	 * @param bedrooms the number of bedrooms in this property
	 * @param bathrooms the number of bathrooms in this property
	 * @param furnished indicated if the property is furnished or unfurnished
	 * @param city_quadrant the quadrant of the city that the house is located in
	 * @param status the status of the property listing (active, rented, cancelled, suspended)
	 */
	public Property(int id, 
			String address, 
			String house_type,
			int bedrooms, 
			int bathrooms, 
			boolean furnished,
			String city_quadrant, 
			String status)
	{
		this.id = id;
		this.address_toString = address;
		this.house_type=house_type;
		this.bedrooms = bedrooms;
		this.bathrooms=bathrooms;
		this.furnished = furnished;
		this.city_quadrant = city_quadrant;
		this.status=status;
	}
	
	/**
	 * Creates a property class
	 * @param landlord_name the landlord's name that is associated with this property
	 * @param id the unique id of this property
	 * @param address the address of this property
	 */
	public Property(String landlord_name,int id, String address)
	{
		this.id = id;
		this.address_toString = address;
		this.landlord_name=landlord_name;

	}
	
	
	/**
	 * Creates a property class with specific information
	 * @param id the unique ID of the property
	 * @param address the address of this property
	 * @param house_type the type of house that this property is
	 * @param bedrooms the number of bedrooms at this property
	 * @param bathrooms the number of bathrooms at this property
	 * @param furnished if the property is furnished or unfurnished
	 * @param city_quadrant the quadrant of the city that is property is located in
	 * @param landlord_id the ID of the landlord of this property
	 * @param landlord_name the name of the landlord of this property
	 * @param email_of_landlord the email address of the landlord
	 * @param time_listed the amount of time that the property is listed for
	 * @param status the status of this property (active, rented, cancelled, suspended)
	 */
	public Property(int id, 
			Address address, 
			String house_type,
			int bedrooms, 
			int bathrooms, 
			boolean furnished,
			String city_quadrant, 
			int landlord_id, 
			String landlord_name,
			String email_of_landlord,
			long time_listed, String status)
	{
		this.id = id;
		this.address = address;
		this.house_type=house_type;
		this.bedrooms = bedrooms;
		this.bathrooms=bathrooms;
		this.furnished = furnished;
		this.city_quadrant = city_quadrant;
		this.landlord_id = landlord_id;
		this.landlord_name=landlord_name;
		this.email_of_landlord = email_of_landlord;
		this.time_listed = time_listed;
		this.status=status;
	}

	/**
	 * 
	 * @return the address info of this property, formatted
	 */
	public String getAddress_toString() {
		return address_toString;
	}
	
	/**
	 * 
	 * @return the quadrant of the city that this property is located in
	 */
	public String getCity_quadrant() {
		return city_quadrant;
	}

	/**
	 * 
	 * @param city_quadrant the quadrant that will be set
	 */
	public void setCity_quadrant(String city_quadrant) {
		this.city_quadrant = city_quadrant;
	}


	/**
	 * 
	 * @return the unique ID of this property
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id the ID to be set to this property
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the address of this property
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address the address to set to this property
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @return the number of bedrooms at this property
	 */
	public int getBedrooms() {
		return bedrooms;
	}

	/**
	 * 
	 * @param bedrooms the number of bedrooms to set to this property
	 */
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * 
	 * @return the type of house that this property is
	 */
	public String getHouse_type() {
		return house_type;
	}

	/**
	 * 
	 * @param house_type the type of house to set to this property
	 */
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	/**
	 * 
	 * @return the number of bedrooms at this property
	 */
	public int getBathrooms() {
		return bathrooms;
	}

	/**
	 * 
	 * @param bathrooms the number of bathrooms to set to this property
	 */
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	/**
	 * 
	 * @return the furnishing status of this property
	 */
	public boolean isFurnished() {
		return furnished;
	}

	/**
	 * 
	 * @param furnished the status of the furnishing in this property
	 */
	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	/**
	 * 
	 * @return the name of that landlord associated with this property
	 */
	public String getLandlord_name() {
		return landlord_name;
	}

	/**
	 * 
	 * @param landlord_name the name of the landlord to set to this property
	 */
	public void setLandlord_name(String landlord_name) {
		this.landlord_name = landlord_name;
	}

	/**
	 * 
	 * @return the ID of the landlord of this property
	 */
	public int getLandlord_id() {
		return landlord_id;
	}

	/**
	 * 
	 * @param landlord_id the ID of the landlord to set to this property
	 */
	public void setLandlord_id(int landlord_id) {
		this.landlord_id = landlord_id;
	}

	/**
	 * 
	 * @return the email address of this property's landlord
	 */
	public String getEmail_of_landlord() {
		return email_of_landlord;
	}

	/**
	 * 
	 * @param email_of_landlord the email of the landlord to be set to this property
	 */
	public void setEmail_of_landlord(String email_of_landlord) {
		this.email_of_landlord = email_of_landlord;
	}

	/**
	 * 
	 * @return the amount of time the property is listed
	 */
	public long getTime_listed() {
		return time_listed;
	}

	/**
	 * 
	 * @param time_listed the amount of time to set the listing of this property
	 */
	public void setTime_listed(long time_listed) {
		this.time_listed = time_listed;
	}

	/**
	 * 
	 * @return the rental status of this property
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status the status of this property to be set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Formats a String with some of the attributes of this property
	 * @return a formatted String with property info
	 */
	public String toString() {
		return "Property ID: "+this.getId()+ "\n"+
				this.getBedrooms() + " bedroom(s) "+ this.getHouse_type() +  " at: " +this.getAddress_toString() + ", City Quadrant: "+this.getCity_quadrant() + "\n"+
				"Number of Bathroom: "+ this.getBathrooms()+ ", Furnished: "+(this.isFurnished() ? "Furnished " : "Not Furnished ")+ ", Current Status: "+this.getStatus()+"\n\n";
	}
	
	/**
	 * Formats a String with certain information for a report
	 * @return a formatted String with some property info
	 */
	public String toStringForReport() {
		return "Landlord Name: "+this.getLandlord_name()+" House ID: "+this.getId()+", Address: "+this.getAddress_toString()+"\n";
	}
	
}

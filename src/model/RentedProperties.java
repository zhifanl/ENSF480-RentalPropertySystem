package model;

/**
 * Represents a rented out property
 */
public class RentedProperties {
	private int property_id;
	private long time_rented;
	
	/**
	 * Creates a rented property, with a unique property ID and the amount
	 * of time the property is rented out for
	 * @param property_id the unique ID of the property
	 * @param time_rented the amount of time the property is rented out for
	 */
	RentedProperties(int property_id, long time_rented)
	{
		this.setProperty_id(property_id);
		this.setTime_rented(time_rented);
	}

	/**
	 * 
	 * @return the unique property ID
	 */
	public int getProperty_id() {
		return property_id;
	}

	/**
	 * 
	 * @param property_id the ID of the property to be set to this class
	 */
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}

	/**
	 * 
	 * @return the amount of time the property is rented out for
	 */
	public long getTime_rented() {
		return time_rented;
	}

	/**
	 * 
	 * @param time_rented the amount of time to be set to this rental
	 */
	public void setTime_rented(long time_rented) {
		this.time_rented = time_rented;
	}
	
	
}

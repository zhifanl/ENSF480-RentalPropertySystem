package controller;

import java.time.Instant;


/**
 * Controller than manages registered property data
 */
public class RegisteredPropertyController {
	
	private DBController DB;

	/**
	 * Default constructor
	 */
	public RegisteredPropertyController() {
		DB = DBController.getInstance();
	}

	/**
	 * Registers a property into the database
	 * @param landlord_id the landlord's ID of this property
	 * @param landlord_name the landlord's name of this property
	 * @param email_of_landlord the email of the landlord
	 * @param address the address of this property
	 * @param house_type the type of property
	 * @param num_bedroom the number of bedrooms
	 * @param num_bathroom the number of bathrooms
	 * @param furnished_bool the status of the property's furnishings
	 * @param quadrant the quadrant of the city this property is located in 
	 * @param status the status of this property
	 * @return not 1 if registering the property is successful;
	 */
	public int registerProperty(int landlord_id, String landlord_name,String email_of_landlord, String address, 
			String house_type, int num_bedroom, int num_bathroom, int furnished_bool, String quadrant,
			String status) 
	{
		
		int updateCount_1 =DB.execute("INSERT INTO properties (house_type,address,bedrooms,bathrooms,furnished,city_quadrant,landlord_id, landlord_name, email_of_landlord, time_listed,status ) VALUES (?,?,?,?,?,?,?,?,?,?,?)", 
				house_type,address,num_bedroom,num_bathroom, furnished_bool,quadrant, 
				landlord_id, landlord_name,email_of_landlord, Instant.now().getEpochSecond(),status);    
		if(updateCount_1 != 1) 
			return 0;
		return updateCount_1;
	}
	
	/**
	 * Notify all users that a new property has been added
	 */
	public void notifyUsers() {
		
	}
	

}

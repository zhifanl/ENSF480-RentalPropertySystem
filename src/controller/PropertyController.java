package controller;
import java.util.ArrayList;

import model.Property;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

/**
 * Property controller for property rental system
 */
public class PropertyController {

	private DBController DB;

	/**
	 * Default constructor
	 */
	public PropertyController() {
		DB = DBController.getInstance();
	}
	
	
	/**
	 * 
	 * @return a list of all properties in the database
	 */
	public ArrayList<Property> getPropertiesList(){
		ResultSet rs = DB.query("SELECT * FROM properties");
		ArrayList<Property> resultList=new ArrayList<Property>();
		try {
			while(rs.next()) {
				int furnished = 0;
				try {
					furnished = rs.getInt("furnished");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				boolean fur=false;
				if(furnished==1) {
					fur=true;
				}else {
					fur=false;
				}
				Property p=null;
				try {
					p = new Property(rs.getInt("id"), rs.getString("address"), rs.getString("house_type"), rs.getInt("bedrooms"), 
							rs.getInt("bathrooms"),fur, rs.getString("city_quadrant"), rs.getString("status") );
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	/**
	 * finds ID of the landlord
	 * @param id the ID of a specific landlord 
	 * @return the ID of the landlord
	 */
	public int findLandlord(int id)
	{
		ResultSet rs = DB.query("SELECT * FROM properties WHERE id = ?", id);
		int landlord_id = -1;
		try {
			if(rs.next()) {
				try {
					landlord_id =rs.getInt("landlord_id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return landlord_id;
	}
	
	/**
	 * Find a landlord's email address by their ID
	 * @param id the ID of the landlord to be searched for
	 * @return the landlord's email address
	 */
	public String findLandlordEmailById(int id){
		ResultSet rs = DB.query("SELECT * FROM properties WHERE id = ?", id);
		String email="";
		try {
			if(rs.next()) {
				try {
					email=rs.getString("email_of_landlord");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;

	}
	
	/**
	 * Returns the results of a search with a certain criteria
	 * @param house_type The type of house to be searched for
	 * @param bedrooms The number of bedrooms to be searched for
	 * @param bathrooms the number of bathrooms to be searched for
 	 * @param furnished the status of the property's furnishings
	 * @param city_quadrant the quadrant of the city of the property searched for
	 * @return a list of properties
	 */
	public ArrayList<Property> getSearchResults(String house_type, int bedrooms, int bathrooms, int furnished, String city_quadrant){
		ResultSet rs = DB.query("SELECT * FROM properties WHERE house_type = ? AND bedrooms=? AND bathrooms=? AND furnished=? AND city_quadrant=?", 
				house_type,bedrooms, bathrooms,furnished, city_quadrant);
		ArrayList<Property> resultList=new ArrayList<Property>();
		
		try {
			
			while(rs.next()) {
				
				int furnished_1 = 0;
				try {
					furnished_1 = rs.getInt("furnished");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				boolean fur=false;
				if(furnished_1==1) {
					fur=true;
				}else {
					fur=false;
				}
				Property p=null;
				try {
					p = new Property(rs.getInt("id"), rs.getString("address"), rs.getString("house_type"), rs.getInt("bedrooms"), 
							rs.getInt("bathrooms"),fur, rs.getString("city_quadrant"), rs.getString("status") );
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultList.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * Change the status of a property given a certain ID.
	 * @param property_id the ID of the property to change the status of
	 * @param property_status_choice the status to set to this property
	 * @return 1 if changing the status was successful
	 */
	public int changePropertyStatus(int property_id, String property_status_choice){
		int updateCount = DB.execute("UPDATE properties SET status = ? WHERE id = ?", property_status_choice, property_id);
		if(updateCount != 1) return 0;
		return 1;
	}
	
	/**
	 * Deletes a property given a certain ID
	 * @param property_id the ID of the property
	 * @return 1 if deleting the property is successful
	 */
	public int deleteProperty(int property_id) {
		int updateCount = DB.execute("DELETE FROM properties WHERE id=?", property_id);
		if(updateCount != 1) 
			return 0;
		return 1;
	}
	
	/**
	 * Updates a certain property given a certain ID
	 * @param property_id the ID of the property
	 * @return 1 if updating the property is successful
	 */
	public int updatedRentedProperty(int property_id){
		int updateCount = DB.execute("UPDATE rented_properties SET time_rented = ? WHERE id = ?", Instant.now().getEpochSecond(), property_id);
		
		if(updateCount == 0) {
			int updateCount_1 =DB.execute("INSERT INTO rented_properties (id, time_rented) VALUES (?, ?)", property_id, Instant.now().getEpochSecond());
			if(updateCount_1 != 1) 
				return 0;
		}
		return 1;
	}
	
}

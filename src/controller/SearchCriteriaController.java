package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SearchCriteria;

/**
 * Class to manage search criteria
 */
public class SearchCriteriaController {

	private DBController DB;

	/**
	 * Default constructor
	 */
	public SearchCriteriaController() {
		DB = DBController.getInstance();
	}
	
	/**
	 * Registers the search criteria of a certain
	 * @param user_id the ID of the searcher
	 * @param house_type the type of house the user searched for
	 * @param num_bedroom the number of bedrooms the user searched for
	 * @param num_bathroom the number of bathrooms the user searched for
	 * @param furnished_bool if the user specified furnished or unfurnished
	 * @param quadrant the quadrant of the city that the user searched for property in
	 * @return 1 if registering search criteria was successful
	 */
	public int registerSearchCriteria(int user_id, String house_type, int num_bedroom, int num_bathroom, int furnished_bool, String quadrant ) {
		int updateCount = DB.execute("UPDATE search_criteria SET house_type = ?, bedrooms=?, bathrooms=?, furnished=?, city_quadrant=? WHERE user_id = ?", 
				house_type,num_bedroom, num_bathroom, furnished_bool, quadrant,  user_id );
		
		if(updateCount == 0) {
			int updateCount_1 =DB.execute("INSERT INTO search_criteria (user_id,house_type,bedrooms,bathrooms,furnished,city_quadrant) VALUES (?,?,?,?,?,?)", user_id,house_type,num_bedroom,num_bathroom, furnished_bool,quadrant);    
			if(updateCount_1 != 1) 
				return 0;
		}
		return 1;
	}
	
	/**
	 * Gets the results of the search given a certain criteria
	 * @param user_id the ID of the user who made the search
	 * @return a list of all properties that meet this criteria
	 */
	public ArrayList<SearchCriteria> getResultById(int user_id){
		ResultSet rs = DB.query("SELECT * FROM search_criteria WHERE user_id = ?", user_id);
		ArrayList<SearchCriteria> resultList=new ArrayList<SearchCriteria>();
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
				SearchCriteria p=null;
				try {
					p = new SearchCriteria(rs.getInt("user_id"), rs.getString("house_type"), rs.getInt("bedrooms"), 
							rs.getInt("bathrooms"),fur, rs.getString("city_quadrant") );
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
	 * Deletes the search criteria history of a certain user
	 * @param user_id the ID of the user
	 * @return 1 if the deletion was successful
	 */
	public int deleteSearchCriteriaById(int user_id) {
		int updateCount = DB.execute("DELETE FROM search_criteria WHERE user_id=?", user_id);
		if(updateCount != 1) 
			return 0;
		return 1;
	}

}

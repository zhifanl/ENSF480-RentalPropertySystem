package controller;

import java.util.ArrayList;

import model.Property;
import model.SearchCriteria;

/**
 * 
 */
public class RegisteredRenterController {
	
	public int unsubscribe(int id) {
		SearchCriteriaController scc=new SearchCriteriaController();
		return scc.deleteSearchCriteriaById(id);
	}
	
	public int registerSearchCriteria(int user_id, String house_type, int num_bedroom, int num_bathroom, int furnished_bool, String quadrant ) {
		SearchCriteriaController scc=new SearchCriteriaController();
		return scc.registerSearchCriteria( user_id,  house_type,  num_bedroom,  num_bathroom,  furnished_bool,  quadrant );
	}
	
	public ArrayList<SearchCriteria> fndMatchesInSearchCriteriaTable(int id){
		SearchCriteriaController scc=new SearchCriteriaController();
		ArrayList<SearchCriteria>result=scc.getResultById(id);
		return result;
	}
	
	public ArrayList<Property> findMatchesInPropertyTable(int user_id, String house_type, int num_bedroom, int num_bathroom, int furnished_bool, String quadrant ) {
		PropertyController pc=new PropertyController();
		ArrayList<Property>listing_result=pc.getSearchResults(house_type,num_bedroom, num_bathroom,furnished_bool,quadrant);
		return listing_result;
	}
	
}

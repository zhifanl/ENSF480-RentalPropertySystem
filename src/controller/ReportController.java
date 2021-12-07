package controller;

import model.Property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Controller that manages monthly report data
 */
public class ReportController {
	private DBController DB;

	/**
	 * Default constructor
	 */
	public ReportController() {
		DB = DBController.getInstance();
	}
	
	
	/**
	 * Count the total amount of property listings
	 * @param period the period if time that the listing is up for
	 * @return the number of property listings
	 */
	int findTotalPropertyListing(long period){
		long now=Instant.now().getEpochSecond();
		long from_when=now-period;
		
		ResultSet rs = DB.query("SELECT * FROM properties WHERE time_listed > ?", from_when);
		ArrayList<Integer> resultList=new ArrayList<Integer>();
	
		try {
			while(rs.next()) {
				int id=0;
				try {
					id = rs.getInt("id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultList.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList.size();
	}
	
	
	/**
	 * Count the number of active property listings
	 * @param period the period of time 
	 * @return the number of active property listings
	 */
	int findActivePropertyListing(long period){
		long now=Instant.now().getEpochSecond();
		long from_when=now-period;
		
		ResultSet rs = DB.query("SELECT * FROM properties WHERE time_listed > ? AND status=?", from_when,"Active");
		ArrayList<Integer> resultList=new ArrayList<Integer>();
	
		try {
			while(rs.next()) {
				int id=0;
				try {
					id = rs.getInt("id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultList.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList.size();
	}
	
	/**
	 * Returns of list of rented properties
	 * @param period the period with which the property is available in
	 * @return a list of all rented properties
	 */
	ArrayList<Property> findRentedProperties(long period){
		long now=Instant.now().getEpochSecond();
		long from_when=now-period;
		
		ResultSet rs = DB.query("SELECT * FROM rented_properties WHERE time_rented > ?", from_when);
		ArrayList<Integer> resultList=new ArrayList<Integer>();

	
		try {
			while(rs.next()) {
				int id=0;
				try {
					id = rs.getInt("id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultList.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// now the resultList is populated with id's that is rented in the period.
		ArrayList<Property> rentedProperties=new ArrayList<Property>();
		for(int i=0;i<resultList.size();i++) {
			int id=resultList.get(i);
			ResultSet resultSet = DB.query("SELECT * FROM properties WHERE id=?", id);

			try {
				while(resultSet.next()) {
					
					
					Property p=null;
					try {
						
						p = new Property(resultSet.getString("landlord_name"),resultSet.getInt("id"), resultSet.getString("address"));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rentedProperties.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rentedProperties;
			
			
		
	}
	
	/**
	 * Converts a period of time to unix
	 * @param period a period of time
	 * @return a unix value that represents a period
	 */
	public long convertPeriodToUnixTime(int period) {
		return period * 86400; // 86400 seconds a day
		
	}

	/**
	 * 
	 * @param period a specific period of time
	 * @return a report that summarises info within a certain period
	 */
	public String getReport(int period) {
		
		long period_of_report=convertPeriodToUnixTime(period);
		ArrayList<Property>results_of_rented_properties=findRentedProperties(period_of_report);
		int num_rented_property=results_of_rented_properties.size();
		int num_active_listing=findActivePropertyListing(period_of_report);
		int num_total_listing=findTotalPropertyListing(period_of_report);
		
		String report="\n****Period: "+period+" Days****\n";
		report+="Number of house listed during the period: "+num_total_listing+"\n";
		report+="Number of houses rented during the period: "+num_rented_property+"\n";
		report+="Number of active houses during the period: "+num_active_listing+"\n";
		
		report+="Here are the rented properties during the period: \n";
		for(int i=0;i<results_of_rented_properties.size();i++) {
			report+=results_of_rented_properties.get(i).toStringForReport();
		}
		

		return report;
	}
	
}

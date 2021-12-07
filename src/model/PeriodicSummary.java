package model;

import java.util.ArrayList;

/**
 * Represents a periodic summary of information. It shows info such
 * as the total number of house rented in a certain period, the total
 * number of active listings, total number of houses listed during a 
 * certain period, and the list of houses rented in the period.
 */
public class PeriodicSummary {
	private int num_of_listing;
	private int num_of_rented_active_listing;
	private ArrayList<Property> list_rented_house;
	private int period;
	
	/**
	 * Constructor for a PeriodicSummary
	 * @param num_of_listing The number of active listings
	 * @param num_of_rented_active_listing the total number of houses rented in a period
	 * @param list_rented_house a list of rented houses in a period
	 * @param period the length of the period
	 */
	PeriodicSummary(int num_of_listing,
					int num_of_rented_active_listing,
					ArrayList<Property> list_rented_house,
					int period)
	{
		this.setNum_of_listing(num_of_listing);
		this.setNum_of_rented_active_listing(num_of_rented_active_listing);
		this.setPeriod(period);
		this.setList_rented_house(list_rented_house);
	}

	/**
	 * 
	 * @return the number of active listings
	 */
	public int getNum_of_listing() {
		return num_of_listing;
	}

	/**
	 * 
	 * @param num_of_listing the number to set the total number of listings
	 */
	public void setNum_of_listing(int num_of_listing) {
		this.num_of_listing = num_of_listing;
	}

	/**
	 * 
	 * @return the number of active listings
	 */
	public int getNum_of_rented_active_listing() {
		return num_of_rented_active_listing;
	}

	/**
	 * 
	 * @param num_of_rented_active_listing the number to set the total active listings
	 */
	public void setNum_of_rented_active_listing(int num_of_rented_active_listing) {
		this.num_of_rented_active_listing = num_of_rented_active_listing;
	}

	/**
	 * 
	 * @return the list of all the rented houses in a period
	 */
	public ArrayList<Property> getList_rented_house() {
		return list_rented_house;
	}

	/**
	 * 
	 * @param list_rented_house the list of rented houses to be set
	 */
	public void setList_rented_house(ArrayList<Property> list_rented_house) {
		this.list_rented_house = list_rented_house;
	}

	/**
	 * 
	 * @return the period of time that the summary covers
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * 
	 * @param period the amount of days to set the period
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
}

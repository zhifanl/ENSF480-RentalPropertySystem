package model;

public class SearchCriteria {
	private int user_id;
	private String house_type;
	private int bathrooms;
	private int bedrooms;
	private boolean furnished;
	private String city_quadrant;
	
	public SearchCriteria(int user_id,
						  String house_type,
						  int bedrooms,
						  int bathrooms,
						  boolean furnished,
						  String city_quadrant)
	{
		this.setUser_id(user_id);
		this.setHouse_type(house_type);
		this.setBathrooms(bathrooms);
		this.setBedrooms(bedrooms);
		this.setFurnished(furnished);
		this.setCity_quadrant(city_quadrant);
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public String getCity_quadrant() {
		return city_quadrant;
	}

	public void setCity_quadrant(String city_quadrant) {
		this.city_quadrant = city_quadrant;
	}
}

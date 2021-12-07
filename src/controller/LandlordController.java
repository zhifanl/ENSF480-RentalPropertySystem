package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Property;

public class LandlordController {
	private DBController DB;
	
	public LandlordController()
	{
		DB = DBController.getInstance();
	}
	
	public int registerProperty(int id, String name, String email, String address,
			String house_type, int bedrooms, int bathrooms, boolean furnished,
			String city_quadrant, String status)
	{
		RegisteredPropertyController rpc = new RegisteredPropertyController();
		return rpc.registerProperty(id, name, email, address, house_type, bedrooms, bathrooms, bathrooms, city_quadrant, status);
	}
	
  
	public ArrayList<Property> viewPropertybyID(int id)
	{
		ResultSet rs = DB.query("SELECT * FROM properties WHERE landlord_id =? ", id);

		ArrayList<Property> resultList=new ArrayList<Property>();
		try {
			while(rs.next()) {
				int furnished_1 = 0;
				try {
					furnished_1 = rs.getInt("furnished");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				boolean fur = furnished_1==1;
				Property p =null;
				
				try {
					p = new Property(rs.getInt("id"), rs.getString("address"), rs.getString("house_type"), rs.getInt("bedrooms"), 
							rs.getInt("bathrooms"), fur, rs.getString("city_quadrant"), rs.getString("status"));
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
	
	public int setStatusById(int id, String status)
	{
		PropertyController pc = new PropertyController();
		return pc.changePropertyStatus(id, status);
	}
}

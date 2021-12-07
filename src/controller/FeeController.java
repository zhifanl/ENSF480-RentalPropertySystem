package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeController {
	private DBController DB;
	
	public FeeController()
	{
		DB = DBController.getInstance();
	}
	
	public int getFee()
	{
		ResultSet set = DB.query("SELECT * FROM fee");
		
		try {
			if(set.next()) {
				int fee = set.getInt("amount");
				return fee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int changeAmount(int amount)
	{
		int updateCount = DB.execute("UPDATE fee SET amount = ? ", amount);
		if(updateCount == 0) {
			int updateCount_1 =DB.execute("INSERT INTO fee (amount) VALUES (?)",amount);    
			if(updateCount_1 != 1) 
				return 0;
		}
		return 1;
	}
	
	public int getPeriod()
	{
		ResultSet set = DB.query("SELECT * FROM fee");
		
		try {
			int period = set.getInt("period");
			return period;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int changePeriod(int period)
	{
		int updateCount = DB.execute("UPDATE fee SET period = ?", period);
		if(updateCount == 0) {
			int updateCount_1 =DB.execute("INSERT INTO fee (period) VALUES (?)",period);    
			if(updateCount_1 != 1) 
				return 0;
		}
		return 1;
	}
}

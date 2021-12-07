package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

/**
 * Controller to manage user data
 */
public class UserController {
	
	
	private DBController DB;

	/**
	 * Default constructor
	 */
	public UserController() {
		DB = DBController.getInstance();
	}
	
	/**
	 * Validates a user given username and password
	 * @param username the username of a user
	 * @param password the password associated with this usernmae
	 * @param role the role of this user
	 * @return true if user is valid
	 */
	public boolean validateUser( String username,  String password, String role){
		
		ResultSet result = DB.query("SELECT * FROM user WHERE username = ? AND role=? ", username, role);
		try {
			if(result.next()) {
				try {
					String rs_password=result.getString("password");
					if(rs_password.equals(password)) {
						return true;
					}else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * Add a user to the database
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param role the role of the user
	 * @return true if adding user is successful
	 */
	public boolean addUser( String username,  String password, String role) {
		int result_count = DB.execute("INSERT INTO user (username, password, role) VALUES (?,?,?)", username, password, role);
		
		if(result_count==1) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Adds a user the the database with an email
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param role the role of the user
	 * @param email the email of the user
	 * @return true if adding user is successful
	 */
	public boolean addUser( String username,  String password, String role, String email) {
		int result_count = DB.execute("INSERT INTO user (username, password, role, email) VALUES (?,?,?,?)", username, password, role, email);
		if(result_count==1) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Find the ID of a user given a specific username
	 * @param username the username of the user
	 * @return the ID of the user
	 */
	public int findIdByUsername(String username){
		ResultSet result = DB.query("SELECT * FROM user WHERE username = ?  ", username);
		int rs_id=0;
		try {
			if(result.next()) {
				try {
					rs_id=result.getInt("id");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs_id;
	}
	
	/**
	 * Return the email of user with username
	 * @param username
	 * @return email of user
	 */
	public String findEmailByUsername(String username){
		ResultSet result = DB.query("SELECT * FROM user WHERE username = ?  ", username);
		String email = null;
		try {
			if(result.next()) {
				try {
					email =result.getString("email");
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
	 * Check through the user table in the database to see if the user is already registered
	 * @param username
	 * @return true if there is a duplicate, false if there is no duplicate
	 */
	public boolean checkDuplicate(String username){
		ResultSet result = DB.query("SELECT * FROM user WHERE username = ?", username);
		int rsCount = 0;

		try {
			while(result.next())
			{			    
			    rsCount = rsCount + 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}//end while
		
		if(rsCount==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Deletes a user from database with a certain ID
	 * @param user_id the ID of the user
	 * @param user_type the type of the user
	 * @return 1 if deletion is successful, 0 if otherwise
	 */
	public int deleteUserById(int user_id,String user_type) {
		int updateCount = DB.execute("DELETE FROM user WHERE id=? AND role=? ", user_id, user_type);
		if(updateCount != 1) 
			return 0;
		return 1;
	}
	
	/**
	 * Makes an ArrayList of all landlord users
	 * @return a list of all landlords in database
	 */
	public ArrayList<User>listLandlords(){
			ResultSet rs = DB.query("SELECT * FROM user WHERE role=? ", "Landlord");
			ArrayList<User> resultList=new ArrayList<User>();
			try {
				while(rs.next()) {
					
					User p=null;
					try {
						p = new User(rs.getInt("id"), rs.getString("username"),rs.getString("role"), rs.getString("email"));
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
	 * A list of all renters in database
	 * @return a list of renters
	 */
	public ArrayList<User>listRenters(){
		ResultSet rs = DB.query("SELECT * FROM user WHERE role=? ", "RegisteredRenter");
		ArrayList<User> resultList=new ArrayList<User>();
		try {
			while(rs.next()) {
				
				User p=null;
				try {
					p = new User(rs.getInt("id"), rs.getString("username"),rs.getString("role"), rs.getString("email"));
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
	
}
package model;

/**
 * Represents a property management system user
 */
public class User {
	private int id;
	private String username;
	private String role;
	private String email;
	
	/**
	 * Creates a user with a unique ID, username, role, and email address
	 * @param id the unique ID that the user has
	 * @param username the user's username
	 * @param role the user's role (regular renter, registered renter, landlord, manager)
	 * @param email the email associated with this user
	 */
	public User(int id,
		 String username,
		 String role,
		 String email)
	{
		this.setId(id);
		this.setUsername(username);
		this.setRole(role);
		this.setEmail(email);
	}

	/**
	 * 
	 * @return the ID associated with this user
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id the ID to be set to this user
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username the username to be set to this user
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return this user's role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * 
	 * @param role the role that this user is given
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 
	 * @return this user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email the email to be set to this user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Converts this user's information into a formatted String
	 * @return	A string with this user's information
	 */
	public String toString() {
		return "id: "+this.getId()+
				"\nUsername: "+this.getUsername()+", Role: "+this.getRole()+
				", Email: "+this.getEmail()+"\n";
	}
	
	
}

package view;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.*;
import model.*;

/**
 * GUI Controller for a property rental system.
 */
public class GUIController {
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	private String type;
	private int user_id;
	private String username;
    
    /*
     * Constructor
     * 
     * @param f first frame of GUI
     */
    public GUIController(LoginFrame f) {
    	loginFrame = f;
    	
    	
    	loginFrame.addActionListeners(new ContinueAsGuestListener(), new LoginRegisteredRenterListener(),
    		new LoginLandlordListener(), new LoginManagerListener(),
    		new RegisterRenterListener(), new RegisterLandlordListener());
    }
    
    
    
    /**
	 * Adds a new user to the system.
	 * @param username the new user's username
	 * @param password the new user's password
	 * @param role this user's role
	 * @return true if user is not a duplicate, false otherwise
	 */
    public boolean addUser(String username, String password, String role) {
    	UserController uc=new UserController();
    	boolean result_depulicate=uc.checkDuplicate(username);
    	
    	if(result_depulicate==true) {
    		JOptionPane.showMessageDialog(loginFrame,"Username is duplicated");
    		return false;
    	}else {
    		boolean valid_user=uc.addUser( username,  password, role);
    		if(valid_user==true) 
    			return true;
    	}
    		
    	return false;
    	
    }

	/**
	 * Adds a new user to the system with included email information
	 * @param username the new user's username
	 * @param password the new user's password
	 * @param role this user's role
	 * @param email this user's email address
	 * @return true if user is not a duplicate, false otherwise
	 */
    public boolean addUser(String username, String password, String role, String email) {
    	UserController uc=new UserController();
    	boolean result_depulicate=uc.checkDuplicate(username);
    	
    	if(result_depulicate==true) {
    		JOptionPane.showMessageDialog(loginFrame,"Username is duplicated");
    		return false;
    	}else {
    		boolean valid_user=uc.addUser( username,  password, role, email);
    		if(valid_user==true) 
    			return true;
    	}
    		
    	return false;
    	
    }
    
	/**
	 * Validates if user information has been entered correctly for login
	 * @param username the user's username
	 * @param password the user's password
	 * @param type the type of user
	 * @return returns true if username and password is valid, false otherwise
	 */
    public boolean validateUser (String username, String password, String type) {
    	
    	UserController uc=new UserController();
    	boolean valid_user=uc.validateUser( username,  password, type);
    	if(!valid_user){
    		JOptionPane.showMessageDialog(loginFrame,"Username does not exist or Password is wrong");
    		return false;
    	}
    	int user_id=uc.findIdByUsername(username);
    	this.user_id=user_id;
    	this.username=username;
    	return true;
    }
    
    /**
	 * Listener of the registered renter class
	 */
    public class RegisterRenterListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			type = "RegisteredRenter";
			String username = JOptionPane.showInputDialog("Username: ");
			String password = JOptionPane.showInputDialog("Password: ");

			if(username==null || username.equals("")|| password==null || password.equals(""))
				return;
			boolean valid = addUser(username, password, type);
			if (!valid) {
				//Remove since there is already error message from adduser
	    		//JOptionPane.showMessageDialog(loginFrame,"Something is wrong when registering the user, try again later...");
				return;
			}

    		JOptionPane.showMessageDialog(loginFrame,"User is registered, now you can log in ");
		}
    }
    
	/**
	 * Listener class of a registered landlord
	 */
    public class RegisterLandlordListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			type = "Landlord";
			String username = JOptionPane.showInputDialog("Landlord Username: ");
			String password = JOptionPane.showInputDialog("Password: ");
			String email = JOptionPane.showInputDialog("Email: ");


			if(username==null || username.equals("") || password==null || password.equals("") || email==null || email.equals(""))
				return;
			boolean valid = addUser(username, password, type, email);
			if (!valid) {
				//Remove since there is already error message from adduser
	    		//JOptionPane.showMessageDialog(loginFrame,"Something is wrong when registering the user, try again later...");
				return;
			}

    		JOptionPane.showMessageDialog(loginFrame,"User is registered, now you can log in ");

		}
    	
    }
    
	/**
	 * Listener of an unregistered renter
	 */
    public class ContinueAsGuestListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame = new MainFrame("Rental Property Management System", "", "Renter");
			mainFrame.addActionListeners(new ViewPropertiesListener(),
					 new ViewOwnPropertiesListener(),  new SendEmailListener(),
					 new UpdatePropertyListener(),  new DeletePropertyListener(),
					 new DeleteRenterListener(), new DeleteLandlordListener(),
					 new GenerateReportListener(), new SetFeePeriodListener(),
					new SaveSearchCriteriaListener(), new SearchPropertiesListener(),
					new UnsubscribeListener(), new RegisterPropertyListener(),
					new QuitListener(),new ListUserListener(), new ViewNewListingsListener());
			loginFrame.dispose();
		}
    	
    }

	/**
	 * Listener class of login of registered renter
	 */
    public class LoginRegisteredRenterListener implements ActionListener{
    	/* 
    	 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = JOptionPane.showInputDialog("Enter Username: ");
			String password = JOptionPane.showInputDialog("Enter Password: ");
			boolean result=validateUser(username, password, "RegisteredRenter");
			if(result==false) {
				JOptionPane.showMessageDialog(loginFrame,"Wrong Username Or Password, Try Again.");
				return;
			}
			
			mainFrame = new MainFrame("Rental Property Management System", "", "RegisteredRenter");
			mainFrame.addActionListeners(new ViewPropertiesListener(),
					 new ViewOwnPropertiesListener(),  new SendEmailListener(),
					 new UpdatePropertyListener(),  new DeletePropertyListener(),
					 new DeleteRenterListener(), new DeleteLandlordListener(),
					 new GenerateReportListener(), new SetFeePeriodListener(),
					new SaveSearchCriteriaListener(), new SearchPropertiesListener(),
					new UnsubscribeListener(), new RegisterPropertyListener(),
					new QuitListener(),new ListUserListener(),new ViewNewListingsListener());
			loginFrame.dispose();
		}
    	
    }
    
	/**
	 * Listener class of the login of a Landlord
	 */
    public class LoginLandlordListener implements ActionListener{
    	/* 
    	 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = JOptionPane.showInputDialog("Enter Username: ");
			String password = JOptionPane.showInputDialog("Enter Password: ");
			boolean result=validateUser(username, password, "Landlord");
			if(result==false) {
				JOptionPane.showMessageDialog(loginFrame,"Wrong Username Or Password, Try Again.");
				return;
			}
			mainFrame = new MainFrame("Rental Property Management System", "", "Landlord");
			mainFrame.addActionListeners(new ViewPropertiesListener(),
					 new ViewOwnPropertiesListener(),  new SendEmailListener(),
					 new UpdatePropertyListener(),  new DeletePropertyListener(),
					 new DeleteRenterListener(), new DeleteLandlordListener(),
					 new GenerateReportListener(), new SetFeePeriodListener(),
					new SaveSearchCriteriaListener(), new SearchPropertiesListener(),
					new UnsubscribeListener(), new RegisterPropertyListener(),
					new QuitListener(),new ListUserListener(),new ViewNewListingsListener());
			loginFrame.dispose();
		}
    	
    }
    
	/**
	 * Listener class of the login of a manager
	 */
    public class LoginManagerListener implements ActionListener{
    	/* 
    	 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = JOptionPane.showInputDialog("Enter Username: ");
			String password = JOptionPane.showInputDialog("Enter Password: ");
			boolean result=validateUser(username, password, "Manager");
			if(result==false) {
				JOptionPane.showMessageDialog(loginFrame,"Wrong Username Or Password, Try Again.");
				return;
			}
			mainFrame = new MainFrame("Rental Property Management System", "", "Manager");
			mainFrame.addActionListeners(new ViewPropertiesListener(),
					 new ViewOwnPropertiesListener(),  new SendEmailListener(),
					 new UpdatePropertyListener(),  new DeletePropertyListener(),
					 new DeleteRenterListener(), new DeleteLandlordListener(),
					 new GenerateReportListener(), new SetFeePeriodListener(),
					new SaveSearchCriteriaListener(), new SearchPropertiesListener(),
					new UnsubscribeListener(), new RegisterPropertyListener(),
					new QuitListener(),new ListUserListener(),new ViewNewListingsListener());
			loginFrame.dispose();
		}
    	
    }
    
	/**
	 * Listener of a property viewer
	 */
    public class ViewPropertiesListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			PropertyController pc=new PropertyController();
			ArrayList<Property>results=pc.getPropertiesList();
			mainFrame.resetDisplayArea();
			if(results.size()==0) {
				mainFrame.print("There are no properties in the system.\n");
			}else 
			{
				mainFrame.print("Available properties: \n");
				for(int i=0;i<results.size();i++) {
					mainFrame.print(results.get(i).toString());
					mainFrame.print("\n");
				}
			}
		}
    	
    }
    
	/**
	 * Listener of a search action
	 */
    public class SearchPropertiesListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			Object[] house_types = {"Apartment", "Attached House", "Detached House","Townhouse" };
			String house_type_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select House Type: ",
			                    "Search house type",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, house_types,
			                    "Apartment");
			//If you're here, the return value was null/empty.
			if(house_type_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			
			String string_bedroom = JOptionPane.showInputDialog("Enter number of bedrooms: ");
			try {
				Integer.parseInt(string_bedroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bedroom=Integer.parseInt(string_bedroom);
			
			
			String string_bathroom = JOptionPane.showInputDialog("Enter number of bathrooms: ");
			try {
				Integer.parseInt(string_bathroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bathroom=Integer.parseInt(string_bathroom);

			
			int furnished_bool=0;

			Object[] yes_or_no = {"Yes", "No"};
			String furnished_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select if house is furnished (Options: Yes/No): ",
			                    "Search house type",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null, yes_or_no,
			                    "Yes");
			//If you're here, the return value was null/empty.
			if(furnished_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			if(furnished_choice.equals("Yes")) {
				furnished_bool=1;
			}
			if(furnished_choice.equals("No")) {
				furnished_bool=0;
			}
			
			
			Object[] quadrants = {"NW", "SW", "NE","SE" };
			String quadrant_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select City Quadrant: ",
			                    "Search house type",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, quadrants,
			                    "NW");
			//If you're here, the return value was null/empty.
			if(quadrant_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			PropertyController pc= new PropertyController();
			ArrayList<Property>results = pc.getSearchResults(house_type_choice, num_bedroom, num_bathroom, furnished_bool, quadrant_choice);
			mainFrame.resetDisplayArea();
			if(results.size()==0) {
				mainFrame.print("No properties are found. \n");
			}else {
				mainFrame.print("Here are the search results. \n");
				for(int i=0;i<results.size();i++) {
					mainFrame.print(results.get(i).toString());
					mainFrame.print("\n");
				}
			}
			
		}
    	
    }
    
	/**
	 * Listener of an email to be sent
	 */
    public class SendEmailListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String string_property_id = JOptionPane.showInputDialog("Enter the property id that you are interested in: ");
			try {
				Integer.parseInt(string_property_id);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer." );
				return;
			}
			
			int property_id=Integer.parseInt(string_property_id);
			String subject=JOptionPane.showInputDialog("Enter Subject of Email: ");
			String content=JOptionPane.showInputDialog("Enter Content of Email: ");
			PropertyController pc= new PropertyController();
			String email_of_landlord=pc.findLandlordEmailById(property_id);
			SendEmailController ec=new SendEmailController();
			int result=ec.sendEmail(email_of_landlord, subject, content);
			if(result==1) 
			{
				JOptionPane.showMessageDialog(mainFrame, "Email sent successfully");
			}else 
			{
				JOptionPane.showMessageDialog(mainFrame, "Email failed to sent");
			}

		}
    	
    }
    
	/**
	 * Unsubscribes a listener from property search subscription list
	 */
    public class UnsubscribeListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			SearchCriteriaController scc=new SearchCriteriaController();
			int result=scc.deleteSearchCriteriaById(user_id);
			if(result==1) {
				mainFrame.resetDisplayArea();
				mainFrame.print("You are successfully removed from the subscription list.");
			}else {
				mainFrame.resetDisplayArea();
				mainFrame.print("Error in removing you from subscription list.");
			}
		}
    	
    }
    
	/**
	 * Listener to save a user's search criteria
	 */
    public class SaveSearchCriteriaListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] house_types = {"Apartment", "Attached House", "Detached House","Townhouse" };
			String house_type_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select House Type: ",
			                    "Register for notification",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, house_types,
			                    "Apartment");
			//If you're here, the return value was null/empty.
			if(house_type_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			
			String string_bedroom = JOptionPane.showInputDialog("Enter number of bedrooms: ");
			try {
				Integer.parseInt(string_bedroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bedroom=Integer.parseInt(string_bedroom);
			
			
			String string_bathroom = JOptionPane.showInputDialog("Enter number of bathrooms: ");
			try {
				Integer.parseInt(string_bathroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bathroom=Integer.parseInt(string_bathroom);

			
			int furnished_bool=0;

			Object[] yes_or_no = {"Yes", "No"};
			String furnished_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select if house is furnished (Options: Yes/No): ",
			                    "Register for notification",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null, yes_or_no,
			                    "Yes");
			//If you're here, the return value was null/empty.
			if(furnished_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			if(furnished_choice.equals("Yes")) {
				furnished_bool=1;
			}
			if(furnished_choice.equals("No")) {
				furnished_bool=0;
			}
			
			
			Object[] quadrants = {"NW", "SW", "NE","SE" };
			String quadrant_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select City Quadrant: ",
			                    "Search house type",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, quadrants,
			                    "NW");
			//If you're here, the return value was null/empty.
			if(quadrant_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			SearchCriteriaController scc=new SearchCriteriaController();
			int result=scc.registerSearchCriteria(user_id, house_type_choice, num_bedroom, num_bathroom, furnished_bool, quadrant_choice );

			if(result==1) {
				mainFrame.resetDisplayArea();
				mainFrame.print("You have saved your choices, we will notify you when it is listed");
			}else {
				mainFrame.resetDisplayArea();
				mainFrame.print("Error in recording your choices into the database");
			}
			
		}
	
    }
    
	/**
	 * Listener class of a new listings viewer
	 */
    public class ViewNewListingsListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			SearchCriteriaController scc=new SearchCriteriaController();
			ArrayList<SearchCriteria>result=scc.getResultById(user_id);
			if(result.size()==0) {
				JOptionPane.showMessageDialog(mainFrame, "You have not saved your search criteria yet. Do that first.");
				return;
			}
			if(result.size()>1) {
				JOptionPane.showMessageDialog(mainFrame, "You have more than 1 preference saved... Something is wrong.");
				return;
			}
			String house_type=result.get(0).getHouse_type();
			int bedroom=result.get(0).getBedrooms();
			int bathroom=result.get(0).getBathrooms();
			boolean furnished=result.get(0).isFurnished();
			String city_quadrant=result.get(0).getCity_quadrant();
			
			int fur=0;
			if(furnished==true) {
				fur=1;
			}else {
				fur=0;
			}
			
			PropertyController pc=new PropertyController();
			ArrayList<Property>listing_result=pc.getSearchResults(house_type,bedroom, bathroom,fur,city_quadrant);
			mainFrame.resetDisplayArea();
			mainFrame.print("Your saved search criteria is: "+"house type: "+house_type+" Number of bedrooms: "+bedroom
					+" Number of bathrooms: "+bathroom+" Furnished: "+furnished+" City Quadrant: "+city_quadrant+"\n");
			if(listing_result.size()==0) {
				mainFrame.print("No active listing is found. "+listing_result.size());
			}else {
				mainFrame.print("Found new listings:\n");
				for(int i=0;i<listing_result.size();i++) {
					mainFrame.print(listing_result.get(i).toString());
					mainFrame.print("\n");
				}
			}
		}
    	
    }
    
    public class RegisterPropertyListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			UserController uc = new UserController();
			String email = uc.findEmailByUsername(username);
			String username=GUIController.this.username;
			int user_id=GUIController.this.user_id;
			
			String address = JOptionPane.showInputDialog("Enter the address of property: ");

			Object[] house_types = {"Apartment", "Attached House", "Detached House","Townhouse" };
			String house_type_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select House Type: ",
			                    "Register Property",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, house_types,
			                    "Apartment");
			//If you're here, the return value was null/empty.
			if(house_type_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			
			String string_bedroom = JOptionPane.showInputDialog("Enter number of bedrooms: ");
			try {
				Integer.parseInt(string_bedroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bedroom=Integer.parseInt(string_bedroom);
			
			
			String string_bathroom = JOptionPane.showInputDialog("Enter number of bathrooms: ");
			try {
				Integer.parseInt(string_bathroom);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int num_bathroom=Integer.parseInt(string_bathroom);

			
			int furnished_bool=0;

			Object[] yes_or_no = {"Yes", "No"};
			String furnished_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select if house is furnished (Options: Yes/No): ",
			                    "Register Property",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null, yes_or_no,
			                    "Yes");
			//If you're here, the return value was null/empty.
			if(furnished_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			if(furnished_choice.equals("Yes")) {
				furnished_bool=1;
			}
			if(furnished_choice.equals("No")) {
				furnished_bool=0;
			}
			
			
			Object[] quadrants = {"NW", "SW", "NE","SE" };
			String quadrant_choice = (String)JOptionPane.showInputDialog(
			                    mainFrame,
			                    "Select City Quadrant: ",
			                    "Search house type",
			                    JOptionPane.PLAIN_MESSAGE,
			                    
			                    null, quadrants,
			                    "NW");
			//If you're here, the return value was null/empty.
			if(quadrant_choice==null) {
				JOptionPane.showMessageDialog(mainFrame, "You have to select one");
				return;
			}
			
			PaymentController pc=new PaymentController();
			int amount_of_fee= pc.getFee();
			// YES_OPTION =0, NO_OPTION=1
			int option = JOptionPane.showConfirmDialog(
				mainFrame,
				"You need to pay "+amount_of_fee+", do you want to proceed to next step?",
				"Confirm Payment",
				JOptionPane.YES_NO_OPTION);
			if(option==1) {
				//means user does not want to pay the fee
				return;
			}
			
			String card_num = JOptionPane.showInputDialog("You need to pay: $"+amount_of_fee+", Enter your card number here: ");
			String payment_name = JOptionPane.showInputDialog("Enter Your Real Name: ");
			
			pc.addPayment(payment_name,card_num );
			RegisteredPropertyController rpc=new RegisteredPropertyController();
			
			
			int result = rpc.registerProperty(user_id, username,email, address, house_type_choice,num_bedroom, num_bathroom, furnished_bool, quadrant_choice,"Active");
			if(result==1) {
				JOptionPane.showMessageDialog(mainFrame, "You have registerted the property successfully.");
			}else {
				JOptionPane.showMessageDialog(mainFrame, "Error happened when trying to register the property.");
			}
			return;
		
		}
    	
    }
    
    public class ViewOwnPropertiesListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			LandlordController lc=new LandlordController();
			ArrayList<Property>results= lc.viewPropertybyID(user_id);
			mainFrame.resetDisplayArea();
			mainFrame.print("Your User ID is: "+user_id+'\n');
			if(results.size()==0) {
				mainFrame.print("No listing is found.");
			}else {
				mainFrame.print("Your properties listing:\n");
				for(int i=0;i<results.size();i++) {
					mainFrame.print(results.get(i).toString());
					mainFrame.print("\n");
				}
			}
		}
    	
    }
    
    public class DeletePropertyListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String property_id_string = JOptionPane.showInputDialog("Enter Property Id you want to delete: ");
			try {
				Integer.parseInt(property_id_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int property_id=Integer.parseInt(property_id_string);
			
			PropertyController pc=new PropertyController();
			if(mainFrame.type.equals("Landlord")) {
				if( user_id == pc.findLandlord(property_id))
				{	
					int result=pc.deleteProperty(property_id);
					if(result==1) {
						JOptionPane.showMessageDialog(mainFrame, "Property deleted successfully");
					}else {
						JOptionPane.showMessageDialog(mainFrame, "Failed to delete the property");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(mainFrame, "You do not own the property.");
				}
			}else if(mainFrame.type.equals("Manager")) {
				int result=pc.deleteProperty(property_id);
				if(result==1) {
					JOptionPane.showMessageDialog(mainFrame, "Property deleted successfully");
				}else {
					JOptionPane.showMessageDialog(mainFrame, "Failed to delete the property");
				}
			}
		}
    	
    }
    
    public class UpdatePropertyListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String property_id_string = JOptionPane.showInputDialog("Enter Property Id you want to update: ");
			try {
				Integer.parseInt(property_id_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int property_id=Integer.parseInt(property_id_string);
			PropertyController pc=new PropertyController();
			if(mainFrame.type.equals("Landlord")) {
				if (pc.findLandlord(property_id) == user_id)
				{
	//				String property_status = JOptionPane.showInputDialog("Enter Property status you want to update to: ");
					Object[] property_status = {"Active", "Rented", "Cancelled","Suspended" };
					String property_status_choice = (String)JOptionPane.showInputDialog(
										mainFrame,
										"Select Status: ",
										"Change Property Status",
										JOptionPane.PLAIN_MESSAGE,
				                    
										null, property_status,
										"NW");
					//If you're here, the return value was null/empty.
					if(property_status_choice==null) {
						JOptionPane.showMessageDialog(mainFrame, "You have to select one");
						return;
					}
				
				
				
					int result=pc.changePropertyStatus(property_id, property_status_choice);
					if(result==1) {
						JOptionPane.showMessageDialog(mainFrame, "Property updated successfully");
					
						if(property_status_choice.equals("Rented")) // if want to change it to rented, 
							//then it will be added to Rented_Property Table for generating the report of rented listings.
							pc.updatedRentedProperty(property_id);
					}else {
						JOptionPane.showMessageDialog(mainFrame, "Failed to update the property");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(mainFrame, "You do not own the property");
				}
			}else if(mainFrame.type.equals("Manager")) {
				Object[] property_status = {"Active", "Rented", "Cancelled","Suspended" };
				String property_status_choice = (String)JOptionPane.showInputDialog(
									mainFrame,
									"Select Status: ",
									"Change Property Status",
									JOptionPane.PLAIN_MESSAGE,
			                    
									null, property_status,
									"NW");
				//If you're here, the return value was null/empty.
				if(property_status_choice==null) {
					JOptionPane.showMessageDialog(mainFrame, "You have to select one");
					return;
				}
				int result=pc.changePropertyStatus(property_id, property_status_choice);
				if(result==1) {
					JOptionPane.showMessageDialog(mainFrame, "Property updated successfully");
				
					if(property_status_choice.equals("Rented")) // if want to change it to rented, 
						//then it will be added to Rented_Property Table for generating the report of rented listings.
						pc.updatedRentedProperty(property_id);
				}else {
					JOptionPane.showMessageDialog(mainFrame, "Failed to update the property");
				}
			}
		}
	
    }
    
    public class ListUserListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			UserController uc=new UserController();
			ArrayList<User>results_landlord= uc.listLandlords();
			mainFrame.resetDisplayArea();
			mainFrame.print("Landlords: \n");
			if(results_landlord.size()==0) {
				mainFrame.print("No listing is found.\n");
			}else {
				
				for(int i=0;i<results_landlord.size();i++) {
					mainFrame.print(results_landlord.get(i).toString());
					mainFrame.print("\n");
				}
			}
			mainFrame.print("Renters: \n");
			ArrayList<User>results_renter= uc.listRenters();
			if(results_renter.size()==0) {
				mainFrame.print("No listing is found.\n");
			}else {
				
				for(int i=0;i<results_renter.size();i++) {
					mainFrame.print(results_renter.get(i).toString());
					mainFrame.print("\n");
				}
			}
		}
    	
    }
    
    
    public class DeleteLandlordListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String landlord_id_string = JOptionPane.showInputDialog("Enter Landlord Id you want to delete: ");
			try {
				Integer.parseInt(landlord_id_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int landlord_id=Integer.parseInt(landlord_id_string);
			UserController uc=new UserController();
			int result=uc.deleteUserById(landlord_id,"Landlord");
			if(result==1) {
				JOptionPane.showMessageDialog(mainFrame, "Landlord deleted successfully");
			}else {
				JOptionPane.showMessageDialog(mainFrame, "Failed to delete the Landlord");
			}
		}
    	
    }
    
    public class DeleteRenterListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String renter_id_string = JOptionPane.showInputDialog("Enter Renter Id you want to delete: ");
			try {
				Integer.parseInt(renter_id_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int landlord_id=Integer.parseInt(renter_id_string);
			UserController uc=new UserController();
			int result=uc.deleteUserById(landlord_id, "RegisteredRenter");
			if(result==1) {
				JOptionPane.showMessageDialog(mainFrame, "Renter deleted successfully");
			}else {
				JOptionPane.showMessageDialog(mainFrame, "Failed to delete the Renter");
			}
		
		}
    	
    }
    
    public class SetFeePeriodListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String fee_string = JOptionPane.showInputDialog("Enter Registration Fee value: ");
			try {
				Integer.parseInt(fee_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int fee=Integer.parseInt(fee_string);
			
			String period_string = JOptionPane.showInputDialog("Enter Period in Days: ");
			try {
				Integer.parseInt(period_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int period=Integer.parseInt(period_string);
			
			FeeController fc=new FeeController();
			fc.changeAmount(fee);
			fc.changePeriod(period);
			mainFrame.resetDisplayArea();
			mainFrame.print("You have changed fee to: "+fee+" and period to: "+period+" days.");
			
		}
    	
    }
    
    public class GenerateReportListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String period_string = JOptionPane.showInputDialog("Enter number of days you want the report to cover from that time to now: ");
			try {
				Integer.parseInt(period_string);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(mainFrame, "You did not enter an integer.");
				return;
			}
			int period=Integer.parseInt(period_string);
			ReportController rc= new ReportController();
			String result=rc.getReport(period);
			mainFrame.resetDisplayArea();
			mainFrame.print("Report Generated: ");
			mainFrame.print(result);
		}
    	
    }
    
    public class QuitListener implements ActionListener{
    	/*
		 * Function called if this classes button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			username=null;
			type=null;
			user_id=0;
			mainFrame.dispose();
			loginFrame.dispose();
			LoginFrame loginFrame=new LoginFrame("Rental Property Management System");
			@SuppressWarnings("unused")
			GUIController gc= new GUIController(loginFrame);
		}
    	
    }
    
}

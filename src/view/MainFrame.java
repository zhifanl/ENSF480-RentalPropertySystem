package view;

import javax.swing.*;


import java.awt.*;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel buttonPanel;
//	private JButton registerRenter;
	private JButton viewAllProperties= new JButton("View All Properties");
	private JButton viewOwnProperties= new JButton("View Own Properties");
	private JButton searchProperties= new JButton("Search Properties");
	private JButton sendEmail= new JButton("Send Email");
	private JButton saveSearchCriteria= new JButton("Subscribe Notification");
	private JButton unsubscribe= new JButton("Unsubscribe");
	private JButton registerProperty= new JButton("Register Property");
	private JButton updateProperty= new JButton("Update Property");
	private JButton deleteProperty= new JButton("Delete Property");
	private JButton deleteRenter= new JButton("Delete Renter");
	private JButton deleteLandlord= new JButton("Delete Landlord");
	private JButton setFeePeriod= new JButton("Set Amount of Fee");
	private JButton generateReport= new JButton("Generate Report");
	private JButton quit= new JButton("Quit");
	private JButton listUsers= new JButton("List Users");
	private JButton viewNewListings= new JButton("View New Listings");
	private JLabel label;
	private JLabel message;
	private JTextArea displayArea= new JTextArea();
	
	@SuppressWarnings("unused")
	private  String username; 
	@SuppressWarnings("unused")
	public  String type;
	@SuppressWarnings("unused")
	private  String user_id; 
	
	
	
	public MainFrame(String label_string, String user_id, String type) 
	{
		super(label_string);
		this.type=type;
		this.user_id=user_id;
		String msg_string="Welcome to your Home Page "+type;
		label=new JLabel(msg_string);
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		//setting frame info
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(label);
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		//Initializing button alignment
		message=new JLabel("Choose following option below: ");
		message.setAlignmentX(CENTER_ALIGNMENT);
		message.setFont(new Font("Serif", Font.PLAIN, 30));
		if(type.equals("Renter")){
//			registerRenter.setAlignmentX(Component.CENTER_ALIGNMENT);
//			registerRenter.setBackground(new java.awt.Color(66, 152, 245));
//			registerRenter.setOpaque(true);
			
			viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewAllProperties.setBackground(new java.awt.Color(66, 152, 245));
			viewAllProperties.setOpaque(true);
			
			searchProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			searchProperties.setBackground(new java.awt.Color(66, 152, 245));
			searchProperties.setOpaque(true);
			
			sendEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
			sendEmail.setBackground(new java.awt.Color(66, 152, 245));
			sendEmail.setOpaque(true);
			
			quit.setAlignmentX(Component.CENTER_ALIGNMENT);
			quit.setBackground(new java.awt.Color(66, 152, 245));
			quit.setOpaque(true);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
//			buttonPanel.add(registerRenter);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewAllProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(searchProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(sendEmail);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(quit);
				
		}
		else if(type.equals("RegisteredRenter")){
			
			viewNewListings.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewNewListings.setBackground(new java.awt.Color(66, 152, 245));
			viewNewListings.setOpaque(true);
			
			viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewAllProperties.setBackground(new java.awt.Color(66, 152, 245));
			viewAllProperties.setOpaque(true);
			
			searchProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			searchProperties.setBackground(new java.awt.Color(66, 152, 245));
			searchProperties.setOpaque(true);
			
			sendEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
			sendEmail.setBackground(new java.awt.Color(66, 152, 245));
			sendEmail.setOpaque(true);
			
			saveSearchCriteria.setAlignmentX(Component.CENTER_ALIGNMENT);
			saveSearchCriteria.setBackground(new java.awt.Color(66, 152, 245));
			saveSearchCriteria.setOpaque(true);
			
			unsubscribe.setAlignmentX(Component.CENTER_ALIGNMENT);
			unsubscribe.setBackground(new java.awt.Color(66, 152, 245));
			unsubscribe.setOpaque(true);
			
			quit.setAlignmentX(Component.CENTER_ALIGNMENT);
			quit.setBackground(new java.awt.Color(66, 152, 245));
			quit.setOpaque(true);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewNewListings);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewAllProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(searchProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(sendEmail);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(saveSearchCriteria);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(unsubscribe);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(quit);
		}
		
		else if(type.equals("Landlord")){
			viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewAllProperties.setBackground(new java.awt.Color(66, 152, 245));
			viewAllProperties.setOpaque(true);
			
			viewOwnProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewOwnProperties.setBackground(new java.awt.Color(66, 152, 245));
			viewOwnProperties.setOpaque(true);
			
			registerProperty.setAlignmentX(Component.CENTER_ALIGNMENT);
			registerProperty.setBackground(new java.awt.Color(66, 152, 245));
			registerProperty.setOpaque(true);
			
			updateProperty.setAlignmentX(Component.CENTER_ALIGNMENT);
			updateProperty.setBackground(new java.awt.Color(66, 152, 245));
			updateProperty.setOpaque(true);
			
			deleteProperty.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteProperty.setBackground(new java.awt.Color(66, 152, 245));
			deleteProperty.setOpaque(true);
			
			
			quit.setAlignmentX(Component.CENTER_ALIGNMENT);
			quit.setBackground(new java.awt.Color(66, 152, 245));
			quit.setOpaque(true);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewAllProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewOwnProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(registerProperty);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(updateProperty);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(deleteProperty);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(quit);
		}
		else if(type.equals("Manager")){
			viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewAllProperties.setBackground(new java.awt.Color(66, 152, 245));
			viewAllProperties.setOpaque(true);
			
			listUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
			listUsers.setBackground(new java.awt.Color(66, 152, 245));
			listUsers.setOpaque(true);
			
			updateProperty.setAlignmentX(Component.CENTER_ALIGNMENT);
			updateProperty.setBackground(new java.awt.Color(66, 152, 245));
			updateProperty.setOpaque(true);
			
			deleteProperty.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteProperty.setBackground(new java.awt.Color(66, 152, 245));
			deleteProperty.setOpaque(true);
			
			deleteRenter.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteRenter.setBackground(new java.awt.Color(66, 152, 245));
			deleteRenter.setOpaque(true);
			
			deleteLandlord.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteLandlord.setBackground(new java.awt.Color(66, 152, 245));
			deleteLandlord.setOpaque(true);
			
			setFeePeriod.setAlignmentX(Component.CENTER_ALIGNMENT);
			setFeePeriod.setBackground(new java.awt.Color(66, 152, 245));
			setFeePeriod.setOpaque(true);
			
			generateReport.setAlignmentX(Component.CENTER_ALIGNMENT);
			generateReport.setBackground(new java.awt.Color(66, 152, 245));
			generateReport.setOpaque(true);
			
			quit.setAlignmentX(Component.CENTER_ALIGNMENT);
			quit.setBackground(new java.awt.Color(66, 152, 245));
			quit.setOpaque(true);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(viewAllProperties);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(listUsers);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(updateProperty);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(deleteProperty);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(deleteRenter);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(deleteLandlord);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(setFeePeriod);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(generateReport);
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(quit);
		}
		displayArea.setSize(100,100);
		displayArea.setBackground(new java.awt.Color(126, 169, 214));
		JPanel panel3= new JPanel();
		panel3.setSize(100,100);
		panel3.setLayout(new BorderLayout());
		panel3.add(displayArea,BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane (displayArea);
		scroll.setSize(100, 100);
		panel3.add(scroll);

		//adding all panels to the frame
		add(mainPanel, BorderLayout.NORTH);
		add(panel3,BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		getContentPane().setBackground(new java.awt.Color(66, 152, 245));
        buttonPanel.setBackground(new java.awt.Color(66, 152, 245));
		setVisible(true);
	}
	
	
	public void addActionListeners(GUIController.ViewPropertiesListener viewP,
			 GUIController.ViewOwnPropertiesListener viewOwnP,  GUIController.SendEmailListener sendE,
			 GUIController.UpdatePropertyListener updateP,  GUIController.DeletePropertyListener deleteP,
			 GUIController.DeleteRenterListener deleteR, GUIController.DeleteLandlordListener deleteL,
			 GUIController.GenerateReportListener generateR, GUIController.SetFeePeriodListener setFP,
			GUIController.SaveSearchCriteriaListener saveSC, GUIController.SearchPropertiesListener searchP,
			GUIController.UnsubscribeListener unsub, GUIController.RegisterPropertyListener registerP,
			GUIController.QuitListener quitL,GUIController.ListUserListener listU,GUIController.ViewNewListingsListener newL)
	{
		
//		registerRenter.addActionListener(quitL);
		viewAllProperties.addActionListener(viewP);
		viewOwnProperties.addActionListener(viewOwnP);
		searchProperties.addActionListener(searchP);
		sendEmail.addActionListener(sendE);
		saveSearchCriteria.addActionListener(saveSC);
		unsubscribe.addActionListener(unsub);
		registerProperty.addActionListener(registerP);
		updateProperty.addActionListener(updateP);
		deleteProperty.addActionListener(deleteP);
		deleteRenter.addActionListener(deleteR);
		deleteLandlord.addActionListener(deleteL);
		setFeePeriod.addActionListener(setFP);
		generateReport.addActionListener(generateR);
		quit.addActionListener(quitL);
		listUsers.addActionListener(listU);
		viewNewListings.addActionListener(newL);
		
	}
	
	public void print(String s) {
		displayArea.append(s);
	}
	
	public void resetDisplayArea() {
		displayArea.setText(null);
	}

}

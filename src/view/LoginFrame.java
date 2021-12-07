package view;
import javax.swing.*;
import java.awt.*;

/**
 * Class that represents the login frame of a property rental management system
 */
public class LoginFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel, buttonPanel;
    private JButton continueAsGuest, loginAsRegisteredRenter, loginAsLandlord,loginAsManager ;
    private JButton registerRenter, registerLandlord;
    private JLabel initialMessage;
    
    /**
     * Constructor of a login frame
     * @param m
     */
    public LoginFrame(String m) {
    	super(m);
    	mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setComponents();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        getContentPane().setBackground(new java.awt.Color(126, 169, 214));
        buttonPanel.setBackground(new java.awt.Color(66, 152, 245));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        
    }
    

    /**
     * Sets the components of the login frame
     */
	public void setComponents() {
    	
    	initialMessage = new JLabel("Welcome to Rental Property Management System");
        initialMessage.setFont(new Font("Serif", Font.PLAIN, 17));
        initialMessage.setBounds(300, 300, 300, 300);
        initialMessage.setAlignmentX(CENTER_ALIGNMENT);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(Box.createRigidArea(new Dimension(20, 100)));
        panel1.add(initialMessage);
        panel1.setBackground(new java.awt.Color(126, 169, 214));
        mainPanel.add(panel1);
        
        continueAsGuest = new JButton("Continue as Guest");
        continueAsGuest.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueAsGuest.setBackground(new java.awt.Color(66, 152, 245));
        continueAsGuest.setOpaque(true);
        //loginAsGuest.setBorderPainted(false);
        buttonPanel.add(continueAsGuest);

        loginAsRegisteredRenter = new JButton("Login as Registered Renter");
        loginAsRegisteredRenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginAsRegisteredRenter.setBackground(new java.awt.Color(66, 152, 245));
        loginAsRegisteredRenter.setOpaque(true);
        buttonPanel.add(loginAsRegisteredRenter);
        
        

        loginAsLandlord = new JButton("Login as Landlord");
        loginAsLandlord.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginAsLandlord.setBackground(new java.awt.Color(66, 152, 245));
        loginAsLandlord.setOpaque(true);
        buttonPanel.add(loginAsLandlord);
        
        loginAsManager = new JButton("Login as Manager");
        loginAsManager.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginAsManager.setBackground(new java.awt.Color(66, 152, 245));
        loginAsManager.setOpaque(true);
        buttonPanel.add(loginAsManager);
        
        registerRenter = new JButton("Register as Renter");
        registerRenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerRenter.setBackground(new java.awt.Color(66, 152, 245));
        registerRenter.setOpaque(true);
        buttonPanel.add(registerRenter);
        
        registerLandlord = new JButton("Register as Landlord");
        registerLandlord.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerLandlord.setBackground(new java.awt.Color(66, 152, 245));
        registerLandlord.setOpaque(true);
        buttonPanel.add(registerLandlord);
    }
    
    /**
     * Add listeners to this class
     * @param continueAsGuest controller for an unregistered renter
     * @param loginRenter login controller for a registered renter
     * @param loginLandlord login controller for a landlord
     * @param loginManager login controller for a manager
     * @param registerRenter login controller for registering a renter
     * @param registerLandlord login controller of registering a landlord
     */
    public void addActionListeners(GUIController.ContinueAsGuestListener continueAsGuest, 
    		GUIController.LoginRegisteredRenterListener loginRenter,GUIController.LoginLandlordListener loginLandlord,
    		GUIController.LoginManagerListener loginManager, GUIController.RegisterRenterListener registerRenter, 
    		GUIController.RegisterLandlordListener registerLandlord) 
    {
    	
    	this.continueAsGuest.addActionListener(continueAsGuest);
    	this.loginAsRegisteredRenter.addActionListener(loginRenter);
    	this.loginAsLandlord.addActionListener(loginLandlord);
    	this.loginAsManager.addActionListener(loginManager);
    	this.registerRenter.addActionListener(registerRenter);
    	this.registerLandlord.addActionListener(registerLandlord);
    	
    }
}

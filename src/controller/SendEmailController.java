package controller;
//using SendGrid's Java Library
//https://github.com/sendgrid/sendgrid-java
import com.sendgrid.*; // put sendgrid-java.jar as classpath.
import java.io.IOException;

/**
 * Represents a controller to send email in the Property Rental Management System
 */
public class SendEmailController {

	/**
	 * Method for a renter to send emails to a landlord
	 * @param email_of_landlord the email address of the landlord
	 * @param s the subject of the email
	 * @param c the content of the email
	 * @return returns 1 if sending email is successful
	 */
	public int sendEmail(String email_of_landlord, String s, String c) {
		Email from = new Email("zhifanli2000@gmail.com");
	    String subject = s;
	    Email to = new Email(email_of_landlord);
	    Content content = new Content("text/plain", c);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY")); // SENDGRID_API_KEY is the environment variable which should not be exposed to the public
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println("Email Sent!");
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      return 0;
	    }
	    return 1;
	 }
}



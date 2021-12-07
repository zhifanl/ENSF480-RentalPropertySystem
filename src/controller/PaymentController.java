package controller;

/**
 * Controls the flow of payment data
 */
public class PaymentController {
	private DBController DB;
	
	/**
	 * default constructor
	 */
	public PaymentController()
	{
		DB = DBController.getInstance();
	}
	
	/**
	 * 
	 * @return the fee associated with this controller
	 */
	public int getFee()
	{
		FeeController fc=new FeeController();
		return fc.getFee();
	}
	
	/**
	 * 
	 * @param fee the fee to set to this payment
	 */
	public void setFee(int fee)
	{
		FeeController fc=new FeeController();
		fc.changeAmount(fee);
	}
	
	/**
	 * Add a new payment
	 * @param name the name of the payment
	 * @param card_num the card number associated with this payment
	 * @return 1 if adding payment was successful
	 */
	public int addPayment(String name, String card_num)
	{
		FeeController fc=new FeeController();
		int fee=fc.getFee();
		int result_count = DB.execute("INSERT INTO payment (name, amount, card_num) VALUES (?,?,?)", name, fee, card_num);
		return (result_count != 1) ? 0 : 1;
	}
}

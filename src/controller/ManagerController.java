package controller;

/**
 * Controller that manages manager data
 */
public class ManagerController {
	
	/**
	 * Default constructor
	 */
	public ManagerController()
	{
	}
	
	/**
	 * Change the period of a fee payment
	 * @param period the period to be set to this fee
	 * @return
	 */
	public int changeFeePeriod(int period)
	{
		FeeController fc = new FeeController();
		return fc.changePeriod(period);
	}
	
	/**
	 * Change the amount of a fee payment
	 * @param amount
	 * @return
	 */
	public int changeFeeAmount(int amount)
	{
		FeeController fc = new FeeController();
		return fc.changeAmount(amount);
	}
	
	/**
	 * Change to status of a property
	 * @param id the ID of the the property
	 * @param status the status to be set to this property
	 * @return 1 if changing property is successful
	 */
	public int setStatusbyId(int id, String status)
	{
		PropertyController pc = new PropertyController();
		return pc.changePropertyStatus(id, status);
	}
}

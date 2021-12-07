package model;

/**
 * Represents a fee payment
 */
public class Fee {
	private int amount;
	private int period;
	
	/**
	 * Creates a fee with an amount and a period
	 * @param amount	the amount of money the fee costs
	 * @param period	the amount of days the fee must be paid by
	 */
	public Fee(int amount, int period) 
	{
		this.setAmount(amount);
		this.setPeriod(period);
	}

	/**
	 * 
	 * @return	this fee's period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * 
	 * @param period period of time to set in days
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * 
	 * @return the amount of money that the fee costs
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount the amount of money to set the amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

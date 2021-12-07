package model;

/**
 * Represents the payment
 */
public class Payment {
	private int landlord_id;
	private int amount;
	private String card_num;
	
	/**
	 * Creates a payment with a landlord's ID, the amount the payment costs, 
	 * and the card number associated with the payment.
	 * @param landlord_id the ID of the landlord associated with this payment
	 * @param amount the amount of money the payment costs
	 * @param card_num the card number associated with the payment
	 */
	Payment(int landlord_id, int amount, String card_num)
	{
		this.setLandlord_id(landlord_id);
		this.setAmount(amount);
		this.setCard_num(card_num);
	}

	/**
	 * 
	 * @return the landlord's id
	 */
	public int getLandlord_id() {
		return landlord_id;
	}

	/**
	 * 
	 * @param landlord_id the landlord's ID to set to this payment
	 */
	public void setLandlord_id(int landlord_id) {
		this.landlord_id = landlord_id;
	}

	/**
	 * 
	 * @return the amount of money that this payment costs
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount the amount of money to set to this payment
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * @return the card number associated with this payment
	 */
	public String getCard_num() {
		return card_num;
	}

	/**
	 * 
	 * @param card_num the card number to set to this payment
	 */
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	
	
}

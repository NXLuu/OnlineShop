package model.customer;

import java.sql.Date;

public class CustomerNember extends Customer {
	private String cardNumber;
	
	public CustomerNember() {
		super();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	
	
}

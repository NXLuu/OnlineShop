package model.cart;

import java.sql.Date;

public class Cart {
	private Date dateCreated;
	private int quantity;
	private double totalPrice;
	private String item;
	private int ID;
	
	public Cart() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}

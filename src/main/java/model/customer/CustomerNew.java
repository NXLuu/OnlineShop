package model.customer;

import java.sql.Date;

public class CustomerNew extends Customer {
	private Date date;
	
	public CustomerNew() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

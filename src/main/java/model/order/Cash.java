package model.order;

public class Cash extends Payment{
	private float cashTendered;

	public Cash(float cashTendered) {
		super();
		this.cashTendered = cashTendered;
	}

	public Cash() {
		super();
	}

	public float getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}
	
	
}

package logicApplication.orderDAO;

import model.cart.Cart;
import model.customer.Customer;
import model.order.Payment;
import model.order.Shipment;

public interface orderDAO {
	public void addOrder();
	public void updateOrder();
	public Customer getCustomer();
	public Cart getCart();
	public Payment getPayment();
	public Shipment getShipment();
}

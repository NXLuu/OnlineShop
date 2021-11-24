package logicApplication.orderDAO;

import java.util.List;

import model.cart.Cart;
import model.customer.Customer;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

public interface OrderDAO {
	public void addOrder(Order order);
	public List<Order> getAllOrder(int custId);
	public void updateOrder(Order order);
	public Customer getCustomer();
	public Cart getCart();
	public Payment getPayment();
	public Shipment getShipment();
}

package logicApplication.customerDAO;

import model.customer.Customer;
import model.order.Order;

public interface CustomerDAO {
	public void updateCustomer(Customer cust);
	public void addCustomer(Customer cust);
	public void deleteCustomer(Customer cust);
	public void viewOrder(Order order);
}

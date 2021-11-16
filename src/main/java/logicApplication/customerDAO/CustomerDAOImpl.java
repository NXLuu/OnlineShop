package logicApplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicApplication.DAO.DAO;
import model.customer.Customer;
import model.order.Order;
import model.shoes.Shoes;

public class CustomerDAOImpl extends DAO implements CustomerDAO {

	@Override
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer checkLogin(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		String userName = customer.getAccount().getUsername();
		String passowrd = customer.getAccount().getPassword();
		try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM account\n"
                    + "WHERE username = ? AND password = ?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passowrd);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	cust.setId(rs.getInt("customerID"));
            	return cust;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return null;
	}

}

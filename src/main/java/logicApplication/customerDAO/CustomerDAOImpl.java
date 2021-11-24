package logicApplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicApplication.DAO.DAO;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
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
	public void viewOrder() {
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
            	cust.setId(rs.getInt(1));
            	PreparedStatement preCust = con.prepareStatement("SELECT * FROM onlineshop.customer WHERE ID = ?");
            	preCust.setInt(1, cust.getId());
            	ResultSet rsCust = preCust.executeQuery();
            	while (rsCust.next()) {
                	cust.setPhone(rsCust.getString("phone"));
                	cust.setSex(rsCust.getString("sex"));
                	cust.setDOB(rsCust.getDate("DOB"));
                }
            	PreparedStatement preAddress = con.prepareStatement("SELECT * FROM onlineshop.address WHERE customerID = ?");
            	preAddress.setInt(1, cust.getId());
            	ResultSet reAddres = preAddress.executeQuery();
            	while (reAddres.next()) {
            		Address address = new Address();
            		
                	address.setNumber(reAddres.getInt("number"));
                	address.setStreet(reAddres.getString("street"));
                	address.setDistrict(reAddres.getString("district"));
                	address.setCity(reAddres.getString("city"));
                	cust.setAddress(address);
                }
            	
            	PreparedStatement preName = con.prepareStatement("SELECT * FROM onlineshop.fullname WHERE customerID = ?");
            	preName.setInt(1, cust.getId());
            	ResultSet reName = preName.executeQuery();
            	while (reName.next()) {
            		FullName name = new FullName();
            		name.setFirstName(reName.getString("firstname"));
            		name.setLastname(reName.getString("lastname"));
            		name.setMidname(reName.getString("midname"));
            		
                	cust.setFullname(name);
                }
            	
            	return cust;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return null;
	}

}

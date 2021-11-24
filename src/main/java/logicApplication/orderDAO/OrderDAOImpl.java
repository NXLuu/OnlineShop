package logicApplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicApplication.DAO.DAO;
import model.cart.Cart;
import model.customer.Customer;
import model.electronics.Electronic;
import model.electronics.ItemElectronic;
import model.order.Credit;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

public class OrderDAOImpl extends DAO implements OrderDAO{


	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Cart getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment getShipment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `onlineshop`.`order` (`customerID`, `totalPrice`, `status`, `cartID`, `shipmentID`, `paymentID`, `date`) VALUES (?, ?, ?, ?, ?, ?, ?);\r\n"
				+ "";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCust().getId());
            ps.setFloat(2, (float)order.getCart().getTotalPrice() + (float)order.getShipment().getPrice());
            ps.setString(3, order.getStatus());
            ps.setInt(4, order.getCart().getID());
            ps.setInt(5, order.getShipment().getID());
            ps.setInt(6, order.getPayment().getId());
            ps.setDate(7, order.getDateCreate());
            
            
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()) {
            	System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
	}
		
		
	

	@Override
	public List<Order> getAllOrder(int custId) {
		// TODO Auto-generated method stub
		List<Order> listOrder = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM onlineshop.order WHERE customerID = ?");
			preparedStatement.setInt(1, custId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setStatus(rs.getString("status"));
				order.setID(rs.getInt("ID"));
				order.setTotalPrice(rs.getString("totalPrice"));
				PreparedStatement prePay = con.prepareStatement("SELECT * FROM onlineshop.payment where id=?");
				PreparedStatement preShip = con.prepareStatement("SELECT * FROM onlineshop.shipment where id=?");
				PreparedStatement prepCart = con.prepareStatement("SELECT * FROM onlineshop.cart where id=?");
				prePay.setInt(1, rs.getInt("paymentID"));
				preShip.setInt(1, rs.getInt("shipmentID"));
				prepCart.setInt(1, rs.getInt("cartID"));
				ResultSet rsPay = prePay.executeQuery();
				while (rsPay.next()) {
					Credit payment = new Credit();
					payment.setType(rsPay.getString("name"));
					payment.setNumber(rsPay.getString("number"));
					order.setPayment(payment);
				}
				
				ResultSet rsShip = preShip.executeQuery();
				while (rsShip.next()) {
					Shipment ship = new Shipment();
					ship.setName(rsShip.getString("name"));
					ship.setAddress(rsShip.getString("address"));
					ship.setMethod(rsShip.getString("shipmentMethod"));
					ship.setPrice(rsShip.getFloat("cost"));
					ship.setTel(rsShip.getString("tel"));
					
					order.setShipment(ship);
				}
				
				ResultSet rsCart = prepCart.executeQuery();
				while (rsCart.next()) {
					Cart cart = new Cart();
					cart.setItem(rsCart.getString("item"));
					cart.setQuantity(rsCart.getInt("quantity"));
					cart.setTotalPrice(rsCart.getFloat("totalPrice"));
					
					
					
					
					order.setCart(cart);
				}
				
				listOrder.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return listOrder;
	}

}

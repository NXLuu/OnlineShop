package logicApplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import logicApplication.DAO.DAO;
import model.order.Credit;
import model.order.Payment;
import model.order.Shipment;

public class PaymentDAOImpl extends DAO implements PaymentDAO {

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Credit creadit = (Credit) payment;
		String sql = "INSERT INTO `onlineshop`.`payment` (`name`, `number`) VALUES (?, ?);\r\n"
				+ "";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, creadit.getType());
            ps.setString(2, creadit.getNumber());
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
	}

	@Override
	public void deleteShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		
	}
	
	

}

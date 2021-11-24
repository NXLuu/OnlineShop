package logicApplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import logicApplication.DAO.DAO;
import model.order.Credit;
import model.order.Payment;
import model.order.Shipment;

public class ShipmentDAOImpl extends DAO implements ShipmentDAO{

	@Override
	public float getShipmentPrice(Shipment shipment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Shipment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Shipment shipment) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `onlineshop`.`shipment` (`name`, `shipmentMethod`, `cost`, `address`, `tel`) VALUES (?,?, ?, ? , ?);\r\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, shipment.getName());
            ps.setString(2, shipment.getMethod());
            ps.setFloat(3, shipment.getPrice());
            ps.setString(4, shipment.getAddress());
            ps.setString(5, shipment.getTel());
           
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

	

}

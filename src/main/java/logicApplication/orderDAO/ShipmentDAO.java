package logicApplication.orderDAO;

import java.util.List;

import model.order.Payment;
import model.order.Shipment;

public interface ShipmentDAO {
	public float getShipmentPrice(Shipment shipment);
	public List<Shipment> findAll();
	public int add(Shipment shipment);
}

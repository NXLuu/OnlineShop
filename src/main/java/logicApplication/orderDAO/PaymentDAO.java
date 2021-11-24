package logicApplication.orderDAO;
import java.util.List;

import model.order.Payment;
import model.order.Shipment;

public interface PaymentDAO {
	public  List<Payment> findAll();
	public int addPayment(Payment payment);
	public void deleteShipment(Shipment shipment);
	public void updateShipment(Shipment shipment);
}

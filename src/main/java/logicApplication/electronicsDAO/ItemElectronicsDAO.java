package logicApplication.electronicsDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.electronics.*;

/**
 *
 * @author thevu
 */
public class ItemElectronicsDAO extends logicApplication.DAO.DAO implements ItemElectronicsDAOImpl {

	@Override
	public void insertElectronicsItem(ItemElectronic itemElectronic) {
		String sql = "INSERT INTO item_electronic(price, discount, electronic_id, deleted, created_at, updated_at) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setFloat(1, itemElectronic.getPrice());
			preStatement.setFloat(2, itemElectronic.getDiscount());
			preStatement.setInt(3, itemElectronic.getElectronicId());
			preStatement.setInt(4, itemElectronic.getDeleted());
			preStatement.setDate(5, itemElectronic.getCreateAt());
			preStatement.setDate(6, itemElectronic.getUpdateAt());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateElectronicsItem(ItemElectronic itemElectronic) {
		String sql = "UPDATE item_electronic set " + "price = ?," + "discount = ?," + "electronic_id = ?,"
				+ "deleted= ?," + "created_at= ?," + "updated_at = ?," + "Where id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setFloat(1, itemElectronic.getPrice());
			preStatement.setFloat(2, itemElectronic.getDiscount());
			preStatement.setInt(3, itemElectronic.getElectronicId());
			preStatement.setInt(4, itemElectronic.getDeleted());
			preStatement.setDate(5, (Date) itemElectronic.getCreateAt());
			preStatement.setDate(6, itemElectronic.getUpdateAt());
			preStatement.setInt(7, itemElectronic.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void deleteElectronicsItem(ItemElectronic itemElectronic) {
		String sql = "DELETE * FROM item_electronic WHERE id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, itemElectronic.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public List<ItemElectronic>  findAll() {
		List<ItemElectronic> electronics = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM item_electronic");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PreparedStatement preparedStatement2 = con.prepareStatement("SELECT * FROM electronic where id=?");
				preparedStatement2.setInt(1, rs.getInt(4));
				ResultSet rs2 = preparedStatement.executeQuery();
				Electronic elec = new Electronic();
				while (rs2.next()) {
					elec.setName(rs2.getString(2));
					elec.setId(rs2.getInt(1));
				}
				
				electronics.add(new ItemElectronic(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4),
						rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getString(8), elec));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return electronics;
	}

}

package logicApplication.electronicsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.electronics.*;

public class ElectronicsDAO extends DAO implements ElectronicsDAOImpl {

	@Override
	public void insertElectronics(Electronic electronic) {
		String sql = "INSERT INTO electronic(name, producer, type, producer_date, hold_house_id, mobile_id, pc_id, deleted, created_at, updated_at) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, electronic.getName());
			preStatement.setString(2, electronic.getProducer());
			preStatement.setString(3, electronic.getType());
			preStatement.setDate(4, electronic.getProducerDate());
			preStatement.setInt(5, electronic.getHoldHouseId());
			preStatement.setInt(6, electronic.getMobileId());
			preStatement.setInt(7, electronic.getPcId());
			preStatement.setInt(8, electronic.getDeleted());
			preStatement.setDate(9, electronic.getCreateAt());
			preStatement.setDate(10, electronic.getUpdateAt());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateElectronics(Electronic electronic) {
		String sql = "UPDATE electronic name = ?, producer = ?, type = ?, producer_date = ?, hold_house_id = ?, mobile_id = ?, pc_id = ?, deleted = ?, created_at = ?, updated_at = ? Where id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, electronic.getName());
			preStatement.setString(2, electronic.getProducer());
			preStatement.setString(3, electronic.getType());
			preStatement.setDate(4, electronic.getProducerDate());
			preStatement.setInt(5, electronic.getHoldHouseId());
			preStatement.setInt(6, electronic.getMobileId());
			preStatement.setInt(7, electronic.getPcId());
			preStatement.setInt(8, electronic.getDeleted());
			preStatement.setDate(9, electronic.getCreateAt());
			preStatement.setDate(10, electronic.getUpdateAt());
			preStatement.setInt(11, electronic.getId());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void deleteElectronics(Electronic electronic) {
		String sql = "DELETE * FROM electronic WHERE id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, electronic.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	public void insertComputer(Computer computer) {
		String sql = "INSERT INTO computer(version, ram, disk, screen_width, type, user_type, des, advantages, defect, deleted, created_at, updated_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, computer.getVersion());
			preStatement.setString(2, computer.getRam());
			preStatement.setString(3, computer.getDisk());
			preStatement.setString(4, computer.getScreenWidth());
			preStatement.setString(5, computer.getType());
			preStatement.setString(6, computer.getUserType());
			preStatement.setString(7, computer.getDes());
			preStatement.setString(8, computer.getAdvantages());
			preStatement.setString(9, computer.getDefect());
			preStatement.setInt(10, computer.getDeleted());
			preStatement.setDate(11, computer.getCreateAt());
			preStatement.setDate(12, computer.getUpdateAt());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insertMobilePhone(MobilePhone mobilePhone) {
		String sql = "INSERT INTO mobile(ram, disk, screen_width, chipset, version, deleted, created_at, updated_at) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, mobilePhone.getRam());
			preStatement.setString(2, mobilePhone.getDisk());
			preStatement.setString(3, mobilePhone.getScreenWidth());
			preStatement.setString(4, mobilePhone.getChipset());
			preStatement.setString(5, mobilePhone.getVersion());
			preStatement.setInt(6, mobilePhone.getDeleted());
			preStatement.setDate(7, mobilePhone.getCreateAt());
			preStatement.setDate(8, mobilePhone.getUpdateAt());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insertHoldHouse(HoldHouse holdHouse) {
		String sql = "INSERT INTO hold_house(type, power, insurance, longevity, technology_used, deleted, created_at, updated_at) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, holdHouse.getType());
			preStatement.setFloat(2, holdHouse.getPower());
			preStatement.setFloat(3, holdHouse.getInsurance());
			preStatement.setFloat(4, holdHouse.getLongevity());
			preStatement.setString(5, holdHouse.getTechnologyUsed());
			preStatement.setInt(6, holdHouse.getDeleted());
			preStatement.setDate(7, holdHouse.getCreateAt());
			preStatement.setDate(8, holdHouse.getUpdateAt());
			preStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void deleteComputer(Computer computer) {
		String sql = "DELETE * FROM computer WHERE id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, computer.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	public void deleteMobilePhone(MobilePhone mobilePhone) {
		String sql = "DELETE * FROM mobile WHERE id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, mobilePhone.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	public void deleteHoldHouse(HoldHouse holdHouse) {
		String sql = "DELETE * FROM hold_house WHERE id = ?";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, holdHouse.getId());
			preStatement.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

}

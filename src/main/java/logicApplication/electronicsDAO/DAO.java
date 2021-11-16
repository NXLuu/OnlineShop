package logicApplication.electronicsDAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author thevu
 */
public class DAO {
	protected Connection con;

	public DAO() {
		String jdbcURL = "jdbc:mysql://localhost:3306/electronics?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "Vuxuanthevxt@123"; // please change information to connect to DB
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			System.out.println("Connection to database failed");
		}
	}
}

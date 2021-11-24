/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author trung
 */
public class DAO {
    protected Connection con;

    public DAO() {
        String jdbcURL = "jdbc:mysql://localhost:3306/onlineshop?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "trung282"; //please change information to connect to DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            System.out.println("Connection to database failed");
        }
    }
}

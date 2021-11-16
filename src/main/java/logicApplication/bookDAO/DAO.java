/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DAO {
     public static Connection con;
    
    public DAO() {
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/pttk";
            String dbClass = "com.mysql.jdbc.Driver";
            
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "root","09022000");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

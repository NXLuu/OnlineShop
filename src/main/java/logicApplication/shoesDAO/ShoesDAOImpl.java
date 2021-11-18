/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.shoesDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.shoes.Shoes;

//private int id;
//    private String type, size, material, trademark, pattern, color;
//    private boolean gender;
//    private  String description;
//    private int promotion;

/**
 *
 * @author trung
 */
public class ShoesDAOImpl extends DAO {

  

    public Shoes getShoesByID(int id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM shoes\n"
                    + "WHERE ID = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new Shoes (id, 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getInt(10)
                      );
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
//private int id;
//    private String type, size, material, trademark, pattern, color;
//    private boolean gender;
//    private  String description;
//    private int promotion;
    public boolean insertShoes(Shoes shoes) {
        String sql = "INSERT INTO shoes(ID, Type, Size, Materia, Trademark, Pattern, Color, Gender, Description, Promotion ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, shoes.getId());
            preStatement.setString(2, shoes.getType());
            preStatement.setString(3, shoes.getSize());
            preStatement.setString(4, shoes.getMaterial());
            preStatement.setString(5, shoes.getTrademark());
            preStatement.setString(5, shoes.getPattern());
            preStatement.setString(7, shoes.getColor());
            preStatement.setBoolean(8, shoes.isGender());
            preStatement.setString(9, shoes.getDescription());
            preStatement.setInt(10, shoes.getPromotion());
            preStatement.executeUpdate();

            ResultSet rs = preStatement.getGeneratedKeys();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateShoes(Shoes shoes) {
        String sql = "UPDATE shoes SET  Type =?, Size =?, Materia =?, Trademark=?, Pattern=?, Color=?, Gender=?, Description=?, Promotion=? WHERE ID=?";

        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preStatement.setString(2, shoes.getType());
            preStatement.setString(3, shoes.getSize());
            preStatement.setString(4, shoes.getMaterial());
            preStatement.setString(5, shoes.getTrademark());
            preStatement.setString(5, shoes.getPattern());
            preStatement.setString(7, shoes.getColor());
            preStatement.setBoolean(8, shoes.isGender());
            preStatement.setString(9, shoes.getDescription());
            preStatement.setInt(10, shoes.getPromotion());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteShoes(Shoes itemShoes) {
        String sql = "DELETE FROM shoes WHERE ID=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, itemShoes.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

   

    public List<Shoes> findAll(final String name) {
        String sql = "SELECT * FROM shoes WHERE Name LIKE '%name%'";
        List<Shoes> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(new Shoes (
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getInt(10)
                      ));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return result;
    }
}

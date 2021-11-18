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

import model.shoes.ItemShoes;


/**
 *
 * @author trung
 */
public class ItemShoesDAOImpl extends DAO{
    
    public ItemShoesDAOImpl() {
        super();
    }
    
    public ItemShoes getItemShoesByID(int id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM itemshoes\n"
                    + "WHERE ID = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new ItemShoes(id, rs.getNString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getFloat(5));
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return null;
    }
    
    public List<ItemShoes> getAll() {
        List<ItemShoes> itemShoeses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from itemshoes");
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                itemShoeses.add(new ItemShoes(
                        rs.getInt(1), 
                        rs.getNString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getFloat(5)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return itemShoeses;
    }

    public boolean insertShoes(ItemShoes itemShoes){
        String sql = "INSERT INTO itemshoes(ID, Name, Price, Image, Discount) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, itemShoes.getId());
            preStatement.setString(2, itemShoes.getName());
            preStatement.setFloat(3, itemShoes.getPrice());
            preStatement.setString(4, itemShoes.getImage());
            preStatement.setFloat(5, itemShoes.getDiscount());
            preStatement.executeUpdate();
          
            ResultSet rs = preStatement.getGeneratedKeys();
            while (rs.next()) {
                itemShoes.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private int getLastIdOf() {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT MAX(ID)\n"
                    + "FROM itemshoes");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return (rs.getByte(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean updateShoes (ItemShoes itemShoes){
        String sql = "UPDATE itemshoes SET Price=?, Image=?, Discount=? WHERE ID=?";
        
         try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStatement.setString(2, itemShoes.getName());
            preStatement.setFloat(1, itemShoes.getPrice());
            preStatement.setString(2, itemShoes.getImage());
            preStatement.setFloat(3, itemShoes.getDiscount());
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteShoes (ItemShoes itemShoes) {
        String sql = "DELETE FROM itemshoes WHERE ID=?";
        
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
   
    
    public List<ItemShoes> findAll(final String name) {
    String sql = "SELECT * FROM itemshoes WHERE Name LIKE '%name%'";
    List<ItemShoes> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(new ItemShoes(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getFloat(5)));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return result;
    }
}

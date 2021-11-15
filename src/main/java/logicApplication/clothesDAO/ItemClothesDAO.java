/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.clothesDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.clothes.ItemClothes;

/**
 *
 * @author Ha Ngoc Bun
 */
public class ItemClothesDAO extends DAO{
    
    public ItemClothesDAO() {
        super();
    }
    
    public boolean addItemClothes(ItemClothes ic){
        String sql = "INSERT INTO itemclothes(Price, Image, Description, ClothesID, CartID) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, ic.getPrice());
            ps.setString(2, ic.getImage());
            ps.setString(3, ic.getDescription());
            ps.setInt(4, ic.getClothesID());
            ps.setInt(5, ic.getCartID());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                ic.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean editItemClothes (ItemClothes ic){
        String sql = "UPDATE itemclothes SET Price=?, Image=?, Description=?, ClothesID=?, CartID=? WHERE ID=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setFloat(1, ic.getPrice());            
            ps.setString(2, ic.getImage());
            ps.setString(3, ic.getDescription());
            ps.setInt(4, ic.getClothesID());
            ps.setInt(5, ic.getCartID());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteItemClothes (ItemClothes ic) {
        String sql = "DELETE FROM itemclothes WHERE ID=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ic.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

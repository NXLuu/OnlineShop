/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.clothesDAO;


import java.sql.PreparedStatement;
import java.sql.Statement;

import model.clothes.Clothes;

import java.sql.ResultSet;

/**
 *
 * @author Ha Ngoc Bun
 */
public class ClothesDAO extends DAO{
    
    public ClothesDAO() {
        super();
    }
    
    public boolean addClothes(Clothes clothes){
        String sql = "INSERT INTO clothes(Name, Brand, Color, Material, Design, Producer, Size, Delivery, PlaceSell, ClothesCategoryID) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clothes.getName());
            ps.setString(2, clothes.getBrand());
            ps.setString(3, clothes.getColor());
            ps.setString(4, clothes.getMaterial());
            ps.setString(5, clothes.getDesign());
            ps.setString(6, clothes.getProducer());
            ps.setString(7, clothes.getSize());
            ps.setString(8, clothes.getDelivery());
            ps.setString(9, clothes.getPlaceSell());
            ps.setInt(10, clothes.getClothesCategoryID());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                clothes.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean editClothes (Clothes clothes){
        String sql = "UPDATE clothes SET Name=?, Brand=?, Color=?, Material=?, Design=?, Producer=?, Size=?, Delivery=?, PlaceSell=?, ClothesCategoryID=? WHERE ID=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, clothes.getName());            
            ps.setString(2, clothes.getBrand());
            ps.setString(3, clothes.getColor());
            ps.setString(4, clothes.getMaterial());
            ps.setString(5, clothes.getDesign());
            ps.setString(6, clothes.getProducer());
            ps.setString(7, clothes.getSize());
            ps.setString(8, clothes.getDelivery());
            ps.setString(9, clothes.getPlaceSell());
            ps.setInt(10, clothes.getClothesCategoryID());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteClothes (Clothes clothes) {
        String sql = "DELETE FROM clothes WHERE ID=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, clothes.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

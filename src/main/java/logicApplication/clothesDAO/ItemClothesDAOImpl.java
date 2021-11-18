/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.clothesDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import logicApplication.DAO.DAO;
import model.clothes.Clothes;
import model.clothes.ClothesCategory;
import model.clothes.ItemClothes;

/**
 *
 * @author Ha Ngoc Bun
 */
public class ItemClothesDAOImpl extends DAO implements ItemClothesDAO {

	public ItemClothesDAOImpl() {
		super();
	}

	public ArrayList<ItemClothes> searchItemClothes(String key) {
		ArrayList<ItemClothes> ic = new ArrayList<>();
		String sqlc = "SELECT * FROM clothes WHERE Name LIKE ?";
		try {
			PreparedStatement p = con.prepareStatement(sqlc);
			p.setString(1, "%" + key + "%");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Clothes cl = new Clothes();
				cl.setId(r.getInt("ID"));
				cl.setName(r.getString("Name"));
				cl.setBrand(r.getString("Brand"));
				cl.setColor(r.getString("Color"));
				cl.setMaterial(r.getString("Material"));
				cl.setDesign(r.getString("Design"));
				cl.setProducer(r.getString("Producer"));
				cl.setSize(r.getString("Size"));
				cl.setDelivery(r.getString("Delivery"));
				cl.setPlaceSell(r.getString("PlaceSell"));
				ClothesCategory c = new ClothesCategory();
				c.setId(r.getInt("ClothesCategoryID"));
				String sql1 = "SELECT * FROM clothescategory WHERE ID=?";
				try {
					PreparedStatement p1 = con.prepareStatement(sql1);
					p1.setInt(1, c.getId());
					ResultSet r1 = p1.executeQuery();
					if (r1.next()) {
						c.setType(r1.getString("Type"));
						cl.setCategory(c);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String sql = "SELECT * FROM itemclothes WHERE ClothesID = ?";
				ItemClothes i = new ItemClothes();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, cl.getId());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						i.setPrice(rs.getFloat("Price"));
						i.setImage(rs.getString("Image"));
						i.setDescription(rs.getString("Description"));
						i.setClothes(cl);

						ic.add(i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ic;
	}

	public ItemClothes searchItemClothes1(int key) {
		String sqlc = "SELECT * FROM clothes WHERE id = ?";
		try {
			PreparedStatement p = con.prepareStatement(sqlc);
			p.setInt(1, key);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Clothes cl = new Clothes();
				cl.setId(r.getInt("ID"));
				cl.setName(r.getString("Name"));
				cl.setBrand(r.getString("Brand"));
				cl.setColor(r.getString("Color"));
				cl.setMaterial(r.getString("Material"));
				cl.setDesign(r.getString("Design"));
				cl.setProducer(r.getString("Producer"));
				cl.setSize(r.getString("Size"));
				cl.setDelivery(r.getString("Delivery"));
				cl.setPlaceSell(r.getString("PlaceSell"));
				ClothesCategory c = new ClothesCategory();
				c.setId(r.getInt("ClothesCategoryID"));
				String sql1 = "SELECT * FROM clothescategory WHERE ID=?";
				try {
					PreparedStatement p1 = con.prepareStatement(sql1);
					p1.setInt(1, c.getId());
					ResultSet r1 = p1.executeQuery();
					if (r1.next()) {
						c.setType(r1.getString("Type"));
						cl.setCategory(c);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String sql = "SELECT * FROM itemclothes WHERE ClothesID = ?";
				ItemClothes i = new ItemClothes();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, cl.getId());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						i.setPrice(rs.getFloat("Price"));
						i.setImage(rs.getString("Image"));
						i.setDescription(rs.getString("Description"));
						i.setClothes(cl);

						return i;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addItemClothes(ItemClothes ic) {
		String sql = "INSERT INTO itemclothes(Price, Image, Description, ClothesID, CartID) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setFloat(1, ic.getPrice());
			ps.setString(2, ic.getImage());
			ps.setString(3, ic.getDescription());
			ps.setInt(4, ic.getClothes().getId());
//            ps.setInt(5, ic.getCartID());

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

	public boolean editItemClothes(ItemClothes ic) {
		String sql = "UPDATE itemclothes SET Price=?, Image=?, Description=?, ClothesID=?, CartID=? WHERE ID=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setFloat(1, ic.getPrice());
			ps.setString(2, ic.getImage());
			ps.setString(3, ic.getDescription());
			ps.setInt(4, ic.getClothes().getId());
//            ps.setInt(5, ic.getCartID());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteItemClothes(ItemClothes ic) {
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

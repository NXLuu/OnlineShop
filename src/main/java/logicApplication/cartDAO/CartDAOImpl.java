package logicApplication.cartDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import logicApplication.shoesDAO.DAO;
import model.book.ItemBook;
import model.cart.Cart;
import model.clothes.ItemClothes;
import model.electronics.ItemElectronic;
import model.order.Payment;
import model.shoes.ItemShoes;
import model.shoes.Shoes;

public class CartDAOImpl extends DAO implements CartDAO {

	@Override
	public void getPayment(Payment payment) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addElectronicsItemToCart(Cart cart, ItemElectronic electronicsItem) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean addBookItemToCart(Cart cart, ItemBook itemBook, int quantity) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean addShoesItemToCart(Cart cart, ItemShoes itemShoes) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cart_itemshoes(cartID, itemShoesID) VALUES(?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setInt(1, cart.getID());
			preStatement.setInt(2, itemShoes.getId());
			preStatement.executeUpdate();

			return preStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addClothesItemToCart(Cart cart, ItemClothes clothesItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertCart(Cart cart) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `onlineshop`.`cart` (`quantity`, `dateCreated`, `item`) VALUES (?, ?, ?);";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, cart.getID());
			preStatement.setInt(2, cart.getQuantity());
			preStatement.setString(3, cart.getItem());
			
			preStatement.executeUpdate();

			ResultSet rs = preStatement.getGeneratedKeys();
			while(rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE `onlineshop`.`cart` SET `quantity` = ?, `item` = ?, `totalPrice` = ? WHERE (`ID` = ?);";

        try {
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setInt(4, cart.getID());
            preStatement.setInt(1, cart.getID());
            preStatement.setString(2, cart.getItem());
            preStatement.setDouble(3, cart.getTotalPrice());
            System.out.println(sql);
            preStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;


	}

}

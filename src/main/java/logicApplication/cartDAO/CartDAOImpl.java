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

}

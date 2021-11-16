package logicApplication.cartDAO;


import model.book.ItemBook;
import model.cart.Cart;
import model.clothes.ItemClothes;
import model.electronics.ItemElectronic;
import model.order.Payment;
import model.shoes.ItemShoes;

public interface CartDAO {
	public boolean addElectronicsItemToCart(Cart cart, ItemElectronic electronicsItem);
	public boolean addBookItemToCart(Cart cart,ItemBook itemBook, int quantity);
	public boolean addShoesItemToCart(Cart cart,ItemShoes shoesItem);
	public boolean addClothesItemToCart(Cart cart,ItemClothes clothesItem);
	public void getPayment(Payment payment);
}

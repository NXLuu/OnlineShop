package controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logicApplication.bookDAO.ItemBookDAOImpl;
import logicApplication.cartDAO.CartDAO;
import logicApplication.cartDAO.CartDAOImpl;
import logicApplication.clothesDAO.ItemClothesDAO;
import logicApplication.clothesDAO.ItemClothesDAOImpl;
import logicApplication.electronicsDAO.ElectronicsDAO;
import logicApplication.electronicsDAO.ItemElectronicsDAO;
import logicApplication.shoesDAO.ItemShoesDAOImpl;
import logicApplication.shoesDAO.ShoesDAOImpl;
import model.book.ItemBook;
import model.cart.Cart;
import model.clothes.ItemClothes;
import model.electronics.ItemElectronic;
import model.shoes.ItemShoes;

@WebServlet("/checkout/*")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action == null) {
			action = "/";
		}
		try {
			switch (action) {
			case "/add":
				addItemShoesToCart(request, response);
				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
			case "/delete":
				deleteItem(request, response);
				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
			case "/":
				listItemInCart(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listItemInCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Cart cart = getCart(request);

		if (cart.getItem() != null) {

			String[] items = cart.getItem().split("@");
			List<ItemShoes> itemShoes = new ArrayList<ItemShoes>();
			List<ItemElectronic> itemElec = new ArrayList<ItemElectronic>();
			List<ItemBook> itemBook = new ArrayList<ItemBook>();
			List<ItemClothes> itemClothes = new ArrayList<ItemClothes>();
			System.out.println(items);
			for (String item : items) {
				if (item == "")
					continue;
				String splitId[] = item.split("_");

				int id;
				switch (splitId[0]) {
				case "c":
					id = Integer.parseInt(splitId[1]);
					ItemClothesDAOImpl clothDAO = new ItemClothesDAOImpl();
					ItemClothes shoesItem = clothDAO.searchItemClothes1(id);
					if (shoesItem != null)
						itemClothes.add(shoesItem);
					break;
				case "s":
					id = Integer.parseInt(splitId[1]);
					ItemShoesDAOImpl shoesDAO = new ItemShoesDAOImpl();
					ItemShoes shoesItem1 = shoesDAO.getItemShoesByID(id);
					if (shoesItem1 != null)
						itemShoes.add(shoesItem1);
					break;
				case "b":
					ItemBookDAOImpl itemBookDao = new ItemBookDAOImpl();
					ItemBook itemBook1 = itemBookDao.getItemBook(splitId[1]);
					if (itemBook1 != null)
						itemBook.add(itemBook1);
					break;
				case "e":
					id = Integer.parseInt(splitId[1]);
					ItemElectronicsDAO elecDao = new ItemElectronicsDAO();
					ItemElectronic itemElec1 = elecDao.getListItemElec(id);
					itemElec1.setId(id);
					if (itemElec1 != null)
						itemElec.add(itemElec1);
					break;
				default:
					break;
				}

			}
			request.setAttribute("itemShoes", itemShoes);
			request.setAttribute("itemElec", itemElec);
			request.setAttribute("itemShoes", itemShoes);
			request.setAttribute("itemBook", itemBook);
			request.setAttribute("cart", cart);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
		dispatcher.forward(request, response);
	}

	private Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		return cart;
	}

	private void addItemShoesToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String idStr = request.getParameter("id");
		String splitId[] = idStr.split("_");
		int id;
		ItemShoes itemshoes;
		ItemElectronic itemElec;
		ItemBook itemBook;
		ItemClothes itemClothes;

		CartDAOImpl cartDAO = new CartDAOImpl();
		Cart cart = getCart(request);

		float price = 0;
		switch (splitId[0]) {
		case "c":
			id = Integer.parseInt(splitId[1]);
			ItemClothesDAOImpl clothDAO = new ItemClothesDAOImpl();
			ItemClothes shoesItem = clothDAO.searchItemClothes1(id);
			price = shoesItem.getPrice();
			cartDAO.addClothesItemToCart(cart, shoesItem);
			break;
		case "s":
			id = Integer.parseInt(splitId[1]);
			ItemShoesDAOImpl itemShoesDAOImpl = new ItemShoesDAOImpl();
			itemshoes = itemShoesDAOImpl.getItemShoesByID(id);
			itemshoes.setId(id);
			price = itemshoes.getPrice();
			cartDAO.addShoesItemToCart(cart, itemshoes);
			break;
		case "b":
			ItemBookDAOImpl itemBookDao = new ItemBookDAOImpl();
			ItemBook itemBook1 = itemBookDao.getItemBook(splitId[1]);
			price = itemBook1.getPrice();
			cartDAO.addBookItemToCart(cart, itemBook1, 1);
			break;
		case "e":
			id = Integer.parseInt(splitId[1]);
			ItemElectronicsDAO elecDao = new ItemElectronicsDAO();
			itemElec = elecDao.getListItemElec(id);
			itemElec.setId(id);
			price = itemElec.getPrice();
			cartDAO.addElectronicsItemToCart(cart, itemElec);
			break;
		default:
			break;
		}
		cart.setQuantity(cart.getQuantity() + 1);
		cart.setTotalPrice(cart.getTotalPrice() + price);
		String item = "";
		if (cart.getItem() != null)
			item = cart.getItem() + "@" + idStr;
		else
			item = "" + idStr;
		cart.setItem(item);
		cartDAO.updateCart(cart);

//		User book = new User(id, name, email, country);
//		userDAO.updateUser(book);
		response.sendRedirect(request.getContextPath() + "/Home");
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idStr = request.getParameter("id");
		String splitId[] = idStr.split("_");
		int id;

		CartDAOImpl cartDAO = new CartDAOImpl();
		Cart cart = getCart(request);

		String newitem = "";
		String[] items = cart.getItem().split("@");
		for (String item : items) {
			System.out.print(item);
			if (idStr.equals(item)) {

				float price = 0;
				switch (splitId[0]) {
				case "c":
					id = Integer.parseInt(splitId[1]);
					ItemClothesDAOImpl clothDAO = new ItemClothesDAOImpl();
					ItemClothes shoesItem = clothDAO.searchItemClothes1(id);
					price = shoesItem.getPrice();
					cart.setTotalPrice(cart.getTotalPrice() - price);
//					cartDAO.addClothesItemToCart(cart, shoesItem);
					break;
				case "s":
					id = Integer.parseInt(splitId[1]);
					ItemShoesDAOImpl itemShoesDAOImpl = new ItemShoesDAOImpl();
					ItemShoes itemshoes = itemShoesDAOImpl.getItemShoesByID(id);
					itemshoes.setId(id);
					price = itemshoes.getPrice();
//					cartDAO.addShoesItemToCart(cart, itemshoes);
					cart.setTotalPrice(cart.getTotalPrice() - price);
					break;
				case "b":
					ItemBookDAOImpl itemBookDao = new ItemBookDAOImpl();
					ItemBook itemBook1 = itemBookDao.getItemBook(splitId[1]);
					price = itemBook1.getPrice();
					cart.setTotalPrice(cart.getTotalPrice() - price);
					break;
				case "e":
					id = Integer.parseInt(splitId[1]);
					ItemElectronicsDAO elecDao = new ItemElectronicsDAO();
					ItemElectronic itemElec = elecDao.getListItemElec(id);
					itemElec.setId(id);
					price = itemElec.getPrice();
//					cartDAO.addShoesItemToCart(cart, itemshoes);
					cart.setTotalPrice(cart.getTotalPrice() - price);
					break;
				default:
					break;
				}
			} else
				newitem += "@" + item;
		}
		if (newitem == "")
			cart.setItem(null);
		else
			cart.setItem(newitem);
		cartDAO.updateCart(cart);
		response.sendRedirect(request.getContextPath() + "/cart");
	}

}

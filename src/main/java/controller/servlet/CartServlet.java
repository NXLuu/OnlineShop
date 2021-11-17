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
import logicApplication.cartDAO.CartDAO;
import logicApplication.cartDAO.CartDAOImpl;
import logicApplication.shoesDAO.ItemShoesDAO;
import logicApplication.shoesDAO.ShoesDAO;
import model.cart.Cart;
import model.shoes.ItemShoes;

@WebServlet("/cart/*")
public class CartServlet extends HttpServlet {
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
			ItemShoesDAO shoesDAO = new ItemShoesDAO();
			String[] items = cart.getItem().split("-");
			List<ItemShoes> itemShoes = new ArrayList<ItemShoes>();
			for (String item : items) {
				System.out.print(item);
				ItemShoes shoesItem = shoesDAO.getItemShoesByID(Integer.parseInt(item));
				if (shoesItem != null)
					itemShoes.add(shoesItem);
			}
			request.setAttribute("itemShoes", itemShoes);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("shoping-cart.jsp");
		dispatcher.forward(request, response);
	}

	private Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		return cart;
	}

	private void addItemShoesToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemShoesDAO itemShoesDAO = new ItemShoesDAO();
		ItemShoes itemshoes = itemShoesDAO.getItemShoesByID(id);
		itemshoes.setId(id);
		CartDAOImpl cartDAO = new CartDAOImpl();

		Cart cart = getCart(request);

		System.out.print(itemshoes.getName());
		cartDAO.addShoesItemToCart(cart, itemshoes);
		cart.setQuantity(cart.getQuantity() + 1);
		cart.setTotalPrice(cart.getTotalPrice() + itemshoes.getPrice());
		String item = "";
		if (cart.getItem() != null)
			item = cart.getItem() + "-" + id;
		item = "" + id;
		cart.setItem(item);
		cartDAO.updateCart(cart);

//		User book = new User(id, name, email, country);
//		userDAO.updateUser(book);
		response.sendRedirect(request.getContextPath() + "/Home");
	}

//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
////		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
////		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);
//
//	}
//
//	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
////		User newUser = new User(name, email, country);
////		userDAO.insertUser(newUser);
//		response.sendRedirect("list");
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//
////		User book = new User(id, name, email, country);
////		userDAO.updateUser(book);
//		response.sendRedirect("list");
//	}
//
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cart cart = getCart(request);
		String newitem = "";
		ItemShoesDAO itemShoesDAO = new ItemShoesDAO();
		String[] items = cart.getItem().split("-");
		for (String item : items) {
			System.out.print(item);
			if (id != Integer.parseInt(item)) {
				newitem += "-" + item;
			}
		}
		if (newitem == "")
			cart.setItem(null);
		else cart.setItem(newitem);
		CartDAOImpl cartDAO = new CartDAOImpl();
		cartDAO.updateCart(cart);
		response.sendRedirect(request.getContextPath() +"/cart");
	}

}

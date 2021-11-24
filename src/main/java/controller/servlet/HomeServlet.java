package controller.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logicApplication.bookDAO.ItemBookDAO;
import logicApplication.bookDAO.ItemBookDAOImpl;
import logicApplication.cartDAO.CartDAO;
import logicApplication.cartDAO.CartDAOImpl;
import logicApplication.clothesDAO.ItemClothesDAO;
import logicApplication.clothesDAO.ItemClothesDAOImpl;
import logicApplication.electronicsDAO.ItemElectronicsDAO;
import logicApplication.shoesDAO.ItemShoesDAOImpl;
import model.book.ItemBook;
import model.cart.Cart;
import model.clothes.ItemClothes;
import model.electronics.ItemElectronic;
import model.shoes.ItemShoes;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void createCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") != null)
			return;

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		Cart cart = new Cart();
		CartDAO cartDAO = new CartDAOImpl();
		int id = cartDAO.insertCart(cart);
		cart.setID(id);
		cart.setDateCreated(date);
		cart.setQuantity(0);
		cart.setTotalPrice(0);
		session.setAttribute("cart", cart);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ItemShoesDAOImpl itemShoesDAOImpl = new ItemShoesDAOImpl();
		ItemElectronicsDAO itemElectronicsDAO = new ItemElectronicsDAO();
		ItemBookDAOImpl itemBookDao = new ItemBookDAOImpl();
		List<ItemBook> listItemBooks = itemBookDao.findAll("");
		
		ItemClothesDAO itemCloDAO = new ItemClothesDAOImpl();
		List<ItemElectronic> listItemElectronic = itemElectronicsDAO.findAll();
		
		List<ItemClothes> listItemCloth = itemCloDAO.searchItemClothes("");
		request.setAttribute("listItemCloth", listItemCloth);
		
		List<ItemShoes> listItemShoes = itemShoesDAOImpl.findAll();
		request.setAttribute("listItemShoes", listItemShoes);
		
		request.setAttribute("listItemElectronic", listItemElectronic);
		
		request.setAttribute("listItemBooks", listItemBooks);
		createCart(request);
		String action = request.getServletPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
//		try {
//			switch (action) {
////			case "/new":
////				showNewForm(request, response);
////				break;
////			case "/insert":
////				insertUser(request, response);
////				break;
////			case "/delete":
////				deleteUser(request, response);
////				break;
////			case "/edit":
////				showEditForm(request, response);
////				break;
////			case "/update":
////				updateUser(request, response);
////				break;
//			case "/":
//				listItemBook(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
	}

	private void listItemBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
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
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
////		userDAO.deleteUser(id);
//		response.sendRedirect("list");
//
//	}

}

package controller.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logicApplication.cartDAO.CartDAO;
import logicApplication.cartDAO.CartDAOImpl;
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
		System.out.println(action);
		if(action == null) {
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
//			case "/delete":
//				deleteUser(request, response);
//				break;
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("shoping-cart.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addItemShoesToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemShoes itemBook = new ItemShoes(id);

		CartDAOImpl cartDAO = new CartDAOImpl();
		Cart cart = new Cart();
		cart.setID(1);
		cartDAO.addShoesItemToCart(cart, itemBook);

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
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
////		userDAO.deleteUser(id);
//		response.sendRedirect("list");
//
//	}

}

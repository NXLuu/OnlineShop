package controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import logicApplication.shoesDAO.ItemShoesDAOImpl;
import logicApplication.shoesDAO.ShoesDAOImpl;
import model.shoes.ItemShoes;
import model.shoes.Shoes;
import model.shoes.Category;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class ShoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ItemShoesDAOImpl impl;
	ShoesDAOImpl implshoes;
	
	
	public void init() {
		
		impl = new ItemShoesDAOImpl();
		implshoes = new ShoesDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
//		System.out.print(action);

		try {
			switch (action) {
			case "/newshoes":
				showNewForm(request, response);
				break;
			case "/shoeslist":
				showShoesForm(request, response);
				break;
			case "/insert":
				insertShoes(request, response);
				break;
			case "/delete":
				deleteItemShoes(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listShoes(request, response);
				break;
			
			default:
				listShoes(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listShoes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		List<User> listUser = userDAO.selectAllUsers();
//		request.setAttribute("listUser", listUser);
		List<ItemShoes> listItemShoes = impl.findAll();
		request.setAttribute("listItemShoes", listItemShoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemshoes-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showShoesForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		List<User> listUser = userDAO.selectAllUsers();
//		request.setAttribute("listUser", listUser);
		List<Shoes> listShoes = implshoes.findAll();
		request.setAttribute("listShoes", listShoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shoes-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addshoes.jsp");
		dispatcher.forward(request, response);
		
	}

	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemShoes itemShoes = impl.getItemShoesByID(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addshoes.jsp");
		request.setAttribute("itemShoes", itemShoes);
		dispatcher.forward(request, response);

	}

	private void insertShoes(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.valueOf(request.getParameter("price"));
		String image = request.getParameter("image");
		float discount = Float.valueOf(request.getParameter("discount"));

		
		
	    Category category2 = new Category(id,request.getParameter("category"));
	    String size = request.getParameter("size");
	    String material = request.getParameter("material");
	    String trademark = request.getParameter("trademark");
	    String pattern = request.getParameter("pattern");
	    String color = request.getParameter("color");
	    int gender = Integer.parseInt(request.getParameter("gender"));
	    String description = request.getParameter("description");
	    int promotion = Integer.parseInt(request.getParameter("promotion"));
	    ItemShoes itemShoes = new ItemShoes(id, name, price, image, discount);
	    Shoes shoes = new Shoes(id, category2, size, material, trademark, pattern, color, gender , description, promotion );
	    
	    impl.inserShoesItem(itemShoes);
		if
		(implshoes.inserShoes(shoes)) {
			response.sendRedirect("list");
		}
	}
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.valueOf(request.getParameter("price"));
		String image = request.getParameter("image");
		float discount = Float.valueOf(request.getParameter("discount"));
		ItemShoes itemShoes = new ItemShoes(id, name, price, image, discount);
		impl.updateShoesItem(itemShoes);;
		response.sendRedirect("list");
	}

	private void deleteItemShoes(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemShoes itemShoes = impl.getItemShoesByID(id);
		impl.deleteShoesItem(itemShoes);
		//impl.deleteShoesItem(id);
		response.sendRedirect("list");

	}
	private void deleteShoes(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemShoes itemShoes = impl.getItemShoesByID(id);
		impl.deleteShoesItem(itemShoes);
		//impl.deleteShoesItem(id);
		response.sendRedirect("list");

	}

}

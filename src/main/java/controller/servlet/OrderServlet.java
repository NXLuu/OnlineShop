package controller.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
import logicApplication.customerDAO.CustomerDAO;
import logicApplication.customerDAO.CustomerDAOImpl;
import logicApplication.electronicsDAO.ItemElectronicsDAO;
import logicApplication.orderDAO.OrderDAOImpl;
import logicApplication.orderDAO.PaymentDAOImpl;
import logicApplication.orderDAO.ShipmentDAO;
import logicApplication.orderDAO.ShipmentDAOImpl;
import logicApplication.shoesDAO.ItemShoesDAOImpl;
import model.book.ItemBook;
import model.cart.Cart;
import model.clothes.ItemClothes;
import model.customer.Account;
import model.customer.Customer;
import model.electronics.ItemElectronic;
import model.order.Credit;
import model.order.Order;
import model.order.Shipment;
import model.shoes.ItemShoes;

@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		if (action == null) {
			action = "/";
		}
		try {
			switch (action) {
			case "/create":
				createOrder(request, response);
				break;
			case "/":
				listOrder(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		float price;

		String cardName = request.getParameter("cardName");
		String cardNumber = request.getParameter("cardNumber");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String paymentMethod = request.getParameter("paymentMethod");
		if (paymentMethod.equals("Giao hàng nhanh")) {
			price = 40;
		} else
			price = 10;
		Shipment shipment = new Shipment();
		shipment.setAddress(address);
		shipment.setName(name);
		shipment.setPrice(price);
		shipment.setTel(phone);
		shipment.setMethod(paymentMethod);
		ShipmentDAOImpl shipDao = new ShipmentDAOImpl();
		shipment.setID(shipDao.add(shipment));

		Credit credit = new Credit();
		credit.setNumber(cardNumber);
		credit.setType(cardName);
		credit.setAmount((float) getCart(request).getTotalPrice());
		PaymentDAOImpl payDao = new PaymentDAOImpl();
		credit.setId(payDao.addPayment(credit));

		Order order = new Order();
		order.setCart(getCart(request));
		order.setPayment(credit);
		order.setShipment(shipment);
		order.setCust(getCust(request));
		order.setStatus("Chờ lấy hàng");
		order.setDateCreate(new Date(System.currentTimeMillis()));

		OrderDAOImpl orderDao = new OrderDAOImpl();
		orderDao.addOrder(order);
		Cart cart = new Cart();
		CartDAO cartDAO = new CartDAOImpl();
		int id = cartDAO.insertCart(cart);
		cart.setID(id);
		cart.setDateCreated(new Date(System.currentTimeMillis()));
		cart.setQuantity(0);
		cart.setTotalPrice(0);
		HttpSession session = request.getSession();
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/order");
	}

	private Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		return cart;
	}

	private Customer getCust(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		return customer;
	}

	private void listOrder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		OrderDAOImpl orderDao = new OrderDAOImpl();
		List<Order> listOrder = orderDao.getAllOrder(getCust(request).getId());
		request.setAttribute("listOrder", listOrder);
		List<List<String>> cartMap = new ArrayList<List<String>>();
		for (Order o : listOrder) {
			List<String> hashMap = new ArrayList<String>();
			hashMap = listItemInCart(o.getCart());
			cartMap.add(hashMap);
		}
		
		request.setAttribute("cartMap", cartMap);
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
		dispatcher.forward(request, response);
	}

	private List<String> listItemInCart(Cart cart) {
		List<String> strList = new ArrayList<String>();
		
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
						strList.add(shoesItem.getClothes().getName() + "-" + shoesItem.getPrice());
						itemClothes.add(shoesItem);
					break;
				case "s":
					id = Integer.parseInt(splitId[1]);
					ItemShoesDAOImpl shoesDAO = new ItemShoesDAOImpl();
					ItemShoes shoesItem1 = shoesDAO.getItemShoesByID(id);
					if (shoesItem1 != null)
						strList.add(shoesItem1.getName() + "-" + shoesItem1.getPrice());
						itemShoes.add(shoesItem1);
					break;
				case "b":
					ItemBookDAOImpl itemBookDao = new ItemBookDAOImpl();
					ItemBook itemBook1 = itemBookDao.getItemBook(splitId[1]);
					if (itemBook1 != null)
						strList.add(itemBook1.getBook().getTitle() + "-" + itemBook1.getPrice());
						itemBook.add(itemBook1);
					break;
				case "e":
					id = Integer.parseInt(splitId[1]);
					ItemElectronicsDAO elecDao = new ItemElectronicsDAO();
					ItemElectronic itemElec1 = elecDao.getListItemElec(id);
					itemElec1.setId(id);
					if (itemElec1 != null)
						strList.add(itemElec1.getElectronic().getName() + "-" + itemElec1.getPrice());
						itemElec.add(itemElec1);
					break;
				default:
					break;
				}

			}
			return strList;
		}
		
		return null;
		
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
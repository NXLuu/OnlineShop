package controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logicApplication.customerDAO.CustomerDAO;
import logicApplication.customerDAO.CustomerDAOImpl;
import logicApplication.customerDAO.CustomerDAOImpl;
import model.customer.Account;
import model.customer.Customer;


/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

	public void init() {
		customerDAO = new CustomerDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		String destPage = "/login.jsp";
		Customer customer = new Customer();
	
		customer.setAccount(new Account(username, password));
		Customer customer2 = customerDAO.checkLogin(customer);
		if (customer2 != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			System.out.println(request.getContextPath());
			System.out.println(request.getRequestURL());
			response.sendRedirect(request.getContextPath());
		} else {
			String message = "Invalid email/password";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

}

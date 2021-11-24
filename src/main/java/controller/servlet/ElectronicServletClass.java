package controller.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicApplication.electronicsDAO.ElectronicsDAO;
import logicApplication.electronicsDAO.ItemElectronicsDAO;
import model.electronics.ItemElectronic;

/**
 *
 * @author thevu
 */
@WebServlet("/electronics/*")
public class ElectronicServletClass extends HttpServlet{
    private static final long serialVersionUID = 1L;
    ElectronicsDAO electronicsDAO;
    ItemElectronicsDAO itemElectronicsDAO;
    
    public void init(){
        electronicsDAO      = new ElectronicsDAO();
        itemElectronicsDAO  = new ItemElectronicsDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getServletPath();
            System.out.print(action);
            try {
                switch (action) {
                    case "/deleteelectronics":
                        deleteItemElectronic(request, response);
                        break;
                    case "/new-electronic":
                        insertElectronics(request, response);
                        break;
                    default:
                        listElectronic(request, response);
                        break;

                }
            } catch (SQLException ex) {
                    Logger.getLogger(ElectronicServletClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    private void insertElectronics(HttpServletRequest request, HttpServletResponse response){
        
    }
    
    private void deleteItemElectronic(HttpServletRequest request, HttpServletResponse response){
        System.out.print("okokokok");
    }
    
    private void listElectronic(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
        List<ItemElectronic> listItemElectronic = itemElectronicsDAO.findAll();
        request.setAttribute("listItemElectronic", listItemElectronic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("itemelectronics-list.jsp");
        dispatcher.forward(request, response);
    }
}

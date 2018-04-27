/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMU
 */
@WebServlet(name = "TabelGadaiCustomerController", urlPatterns = {"/tabelGadaiCustomerController"})
public class TabelGadaiCustomerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO cdao = new CustomerDAO();
        String id = request.getParameter("idCustomer");
        String password = request.getParameter("password");
        try {if(cdao.check(id, password)){
            HttpSession session = request.getSession();
            session.setAttribute("logincustomer", id);
            response.sendRedirect("gadaiController");
        }   
        } catch (Exception e) {
        }
        
    }
}

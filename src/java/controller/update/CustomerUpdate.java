/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.CustomerDAO;
import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMU
 */
public class CustomerUpdate extends HttpServlet {

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
        String username = request.getParameter("username");
        RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
//            out.println(username);
            Customer customer = (Customer) new CustomerDAO().getById(username);
//            out.println(customer.getNomorTelepon());
            session.setAttribute("customerupdates", customer);
            dis = request.getRequestDispatcher("customer/customerupdate.jsp");
//            response.sendRedirect("customer/customerupdate.jsp");
            dis.include(request, response);
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css\">\n"
                    + "        <!-- Font Awesome -->\n"
                    + "        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n"
                    + "        <link rel=\"stylesheet\" href=\"bootstrap/bower_components/font-awesome/css/font-awesome.min.css\">\n"
                    + "        <!-- Ionicons -->\n"
                    + "        <link rel=\"stylesheet\" href=\"bootstrap/abower_components/Ionicons/css/ionicons.min.css\">\n"
                    + "        <!-- Google Font -->\n"
                    + "        <link rel=\"stylesheet\"\n"
                    + "              href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n"
                    + "    ");
            out.println("<script src=\"bootstrap/bower_components/jquery/dist/jquery.min.js\"></script>\n"
                    + "        <!-- Bootstrap 3.3.7 -->\n"
                    + "        <script src=\"bootstrap/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n" + "");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
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
import tools.BCrypt;

/**
 *
 * @author TAMU
 */
public class ProsesUpdateCustomer extends HttpServlet {

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
        String idcustomer=request.getParameter("idCustomer");
        String nomorktp=request.getParameter("nomorKtp");
        String nama=request.getParameter("nama");
        String jeniskelamin=request.getParameter("jenisKelamin");
        String nomortelepon= request.getParameter("nomorTelepon");
        String pekerjaan= request.getParameter("pekerjaan");
        String alamat= request.getParameter("alamat");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        CustomerDAO cdao = new CustomerDAO();
        String pesanu="gagal update";
        try (PrintWriter out = response.getWriter()) {
            Customer customer=(Customer) new Customer(idcustomer);
            customer.setIdCustomer(idcustomer);
            customer.setNomorKtp(Long.valueOf(nomorktp));
            customer.setNamaCustomer(nama);
            customer.setJenisKelamin(jeniskelamin);
            customer.setNomorTelepon(nomortelepon);
            customer.setPekerjaan(pekerjaan);
            customer.setAlamat(alamat);
            customer.setUsername(username);
            customer.setPassword(password);
            if(cdao.update(customer)){
                  pesanu="Berhasil update ID: "+customer.getIdCustomer();
            }
//            session.getAttribute("berhasil",customer);
//            out.println(pesan);
            session.setAttribute("pesanu",pesanu);
            dis = request.getRequestDispatcher("customerController");
            dis.include(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import controller.update.ProsesUpdateGadai;
import dao.AngsuranDAO;
import entities.Angsuran;
import entities.Customer;
import entities.Gadai;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AngsuranInsert extends HttpServlet {

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
        String id=request.getParameter("idAngsuran");
        String idgadai=request.getParameter("idGadai");
        String idcustomer=request.getParameter("idCustomer");
        String tanggalangsuran=request.getParameter("tanggalAngsuran");
        String jumlahangsuran=request.getParameter("jumlahAngsuran");
    //    String denda=request.getParameter("denda");
        String pesan="gagal menambahakan data";
        HttpSession session=request.getSession();
        RequestDispatcher dis = null;
        AngsuranDAO adao = new AngsuranDAO();
         Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tanggalangsuran);
        } catch (ParseException pe) {   
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AngsuranInsert</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AngsuranInsert at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            Angsuran angsuran = new Angsuran(id);
            angsuran.setIdGadai(new Gadai(idgadai));
            angsuran.setIdCustomer(new Customer(idcustomer));
            angsuran.setTanggalAngsuran(date1);
            angsuran.setJumlahAngsuran(Long.valueOf(jumlahangsuran));
        //    angsuran.setDenda(Long.valueOf(denda));
            if(adao.insert(angsuran)){
                pesan="Berhasil insert" +angsuran.getIdAngsuran();
            }
            session.setAttribute("angsuraninsert", angsuran);
            session.setAttribute("pesan", pesan);
            out.println(pesan);
            dis=request.getRequestDispatcher("angsuranController");
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

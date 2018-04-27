/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.BarangDAO;
import entities.Barang;
import entities.JenisBarang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Evi
 */
@WebServlet(name = "ProsesUpdateBarang", urlPatterns = {"/prosesUpdateBarang"})
public class ProsesUpdateBarang extends HttpServlet {

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
        String id = request.getParameter("idBarang");
        String idjns = request.getParameter("idJenisBarang");
        String nama = request.getParameter("namaBarang");
        String kualitas = request.getParameter("kualitas");
        RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        BarangDAO cdao = new BarangDAO();
        String pesanu="gagal update";
        try (PrintWriter out = response.getWriter()) {
            Barang barang = new Barang(id);
            barang.setIdJenisBarang(new JenisBarang(idjns));
            barang.setNamaBarang(nama);
            barang.setKualitas(kualitas);       
            if(cdao.update(barang)){
                pesanu="Berhasil mengupdate data dengan ID: "+barang.getIdBarang();
            }
            session.setAttribute("pesanu",pesanu);
           // out.println(pesan);
            dis = request.getRequestDispatcher("barangController");
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

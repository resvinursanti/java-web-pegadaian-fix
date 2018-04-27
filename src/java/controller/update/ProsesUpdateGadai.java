/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.GadaiDAO;
import entities.Barang;
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
public class ProsesUpdateGadai extends HttpServlet {

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
        String id=request.getParameter("idGadai");
        String idcustomer=request.getParameter("idCustomer");
        String idbarang=request.getParameter("idBarang");
        String jumlahpinjaman=request.getParameter("jumlahPinjaman");
  //      String tanggalpinjaman=request.getParameter("tanggalPinjaman");
       
  //      String jatuhtempo=request.getParameter("jatuhTempo");
        String keterangan =request.getParameter("keterangan");
        //String sisa=request.getParameter("sisa");
        String pesanu="gagal update";
        HttpSession session = request.getSession();
        RequestDispatcher dis=null;
        GadaiDAO gdao = new GadaiDAO();
//        Date date1=null;
//        try{
//        date1=new SimpleDateFormat("yyyy-mm-dd").parse(tanggalpinjaman);
//        }catch(ParseException pe){
//            Logger.getLogger(ProsesUpdateGadai.class.getName()).log(Level.SEVERE, null, pe);
//        }
//       
//        Date date3=null;
//        try{
//        date3=new SimpleDateFormat("yyyy-mm-dd").parse(jatuhtempo);
//        }catch(ParseException pe){
//            Logger.getLogger(ProsesUpdateGadai.class.getName()).log(Level.SEVERE, null, pe);
//        }
        try (PrintWriter out = response.getWriter()) {
            Gadai gadai = new Gadai();
            gadai.setIdGadai(id);
            gadai.setIdCustomer(new Customer(idcustomer));
            gadai.setIdBarang(new Barang(idbarang));
            gadai.setJumlahPinjaman(Long.valueOf(jumlahpinjaman));
   //         gadai.setTanggalPinjaman(date1);
//            gadai.setTanggalDiterima(date2);
  //          gadai.setJatuhTempo(date3);
            gadai.setKeterangan(keterangan);
         //   gadai.setSisa(Long.valueOf(sisa));
            if(gdao.update(gadai)){
                pesanu="Berhasil mengupdate data ID: "+gadai.getIdGadai();
            }
         //   out.println(pesan);
         session.setAttribute("pesanu",pesanu);
            dis = request.getRequestDispatcher("gadaiController");
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

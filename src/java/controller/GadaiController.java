/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GadaiDAO;
import entities.Gadai;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class GadaiController extends HttpServlet {

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
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            List<Object> datas = new GadaiDAO().getAll();
//            if (session.getAttribute("pesan")!=null) {
//                out.print(session.getAttribute("pesan")+"<br>");
//                session.removeAttribute("pesan");
//            }
            if (session.getAttribute("logincustomer")==null) {
                  response.sendRedirect("login/index.jsp");
            }
            session.setAttribute("gadaii", datas);
            dispatcher = request.getRequestDispatcher("customer/gadai.jsp");
            dispatcher.include(request, response);
            out.println("</script>\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
             out.println("<link rel=\"stylesheet\" href=\"bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css\">\n" +
"        <!-- Font Awesome -->\n" +
"        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/bower_components/font-awesome/css/font-awesome.min.css\">\n" +
"        <!-- Ionicons -->\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/abower_components/Ionicons/css/ionicons.min.css\">\n" +
"        <!-- DataTables -->\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css\">\n" +
"        <!-- Theme style -->\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/dist/css/AdminLTE.min.css\">\n" +
"        <!-- AdminLTE Skins. Choose a skin from the css/skins\n" +
"             folder instead of downloading all of them to reduce the load. -->\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/dist/css/skins/_all-skins.min.css\">\n" +
"\n" +
"        <!-- Google Font -->\n" +
"        <link rel=\"stylesheet\"\n" +
"              href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n" +
"    ");
              out.println("<script src=\"bootstrap/bower_components/jquery/dist/jquery.min.js\"></script>\n" +
"        <!-- Bootstrap 3.3.7 -->\n" +
"        <script src=\"bootstrap/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n" +
"        <!-- DataTables -->\n" +
"        <script src=\"bootstrap/bower_components/datatables.net/js/jquery.dataTables.min.js\"></script>\n" +
"        <script src=\"bootstrap/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js\"></script>\n" +
"        <!-- SlimScroll -->\n" +
"        <script src=\"bootstrap/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\n" +
"        <!-- FastClick -->\n" +
"        <script src=\"bootstrap/bower_components/fastclick/lib/fastclick.js\"></script>\n" +
"        <!-- AdminLTE App -->\n" +
"        <script src=\"bootstrap/dist/js/adminlte.min.js\"></script>\n" +
"        <!-- AdminLTE for demo purposes -->\n" +
"        <script src=\"bootstrap/dist/js/demo.js\"></script>\n" +
"        <!-- page script -->\n" +
"        <script>\n" +
"            $(function () {\n" +
"                $('#example1').DataTable()\n" +
"                $('#example2').DataTable({\n" +
"                    'paging': true,\n" +
"                    'lengthChange': false,\n" +
"                    'searching': false,\n" +
"                    'ordering': true,\n" +
"                    'info': true,\n" +
"                    'autoWidth': false\n" +
"                })\n" +
"            })\n" +
"        </script>");
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

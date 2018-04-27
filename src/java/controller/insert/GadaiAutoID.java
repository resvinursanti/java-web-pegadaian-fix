/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.CustomerDAO;
import dao.GadaiDAO;
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
public class GadaiAutoID extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher dis = null ;
        GadaiDAO gdao = new GadaiDAO();
        try (PrintWriter out = response.getWriter()) {
            session.setAttribute("autoID", gdao.getAutoID());
            dis=request.getRequestDispatcher("admin/gadai/gadaiinsert.jsp");
            dis.include(request, response);
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css\">\n" +
"        <!-- Font Awesome -->\n" +
"        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/bower_components/font-awesome/css/font-awesome.min.css\">\n" +
"        <!-- Ionicons -->\n" +
"        <link rel=\"stylesheet\" href=\"bootstrap/abower_components/Ionicons/css/ionicons.min.css\">\n" +
"        <!-- Google Font -->\n" +
"        <link rel=\"stylesheet\"\n" +
"              href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n" +
"    ");
            out.println("<title>Servlet AngsuranController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script src=\"bootstrap/bower_components/jquery/dist/jquery.min.js\"></script>\n" +
"        <!-- Bootstrap 3.3.7 -->\n" +
"        <script src=\"bootstrap/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n" +
"        <!-- DataTables -->\n" +
                    "<!-- Global site tag (gtag.js) - Google Analytics -->\n" +
"        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-23581568-13\"></script>\n" +
"        <script>\n" +
"            window.dataLayer = window.dataLayer || [];\n" +
"            function gtag() {\n" +
"                dataLayer.push(arguments);\n" +
"            }\n" +
"            gtag('js', new Date());\n" +
"\n" +
"            gtag('config', 'UA-23581568-13');\n" +
"        </script>\n" +
"\n" +
"        <!--date bootstrap-->\n" +
"        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\n" +
"\n" +
"        <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->\n" +
"        <link rel=\"stylesheet\" href=\"https://formden.com/static/cdn/bootstrap-iso.css\" />\n" +
"\n" +
"        <!-- Bootstrap Date-Picker Plugin -->\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n" +
"        <!--tanggal angsuran-->\n" +
"        <script>\n" +
"            $(document).ready(function () {\n" +
"                var date_input = $('input[name=\"tanggalPinjaman\"]'); //our date input has the name \"date\"\n" +
"                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : \"body\";\n" +
"                var options = {\n" +
"                    format: 'mm/dd/yyyy',\n" +
"                    container: container,\n" +
"                    todayHighlight: true,\n" +
"                    autoclose: true\n" +
"                };\n" +
"                date_input.datepicker(options);\n" +
"            });\n" +
"        </script>\n" +
"        <!--tanggal peminjaman-->\n" +
"        <script>\n" +
"            $(document).ready(function () {\n" +
"                var date_input = $('input[name=\"tanggalDiterima\"]'); //our date input has the name \"date\"\n" +
"                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : \"body\";\n" +
"                var options = {\n" +
"                    format: 'mm/dd/yyyy',\n" +
"                    container: container,\n" +
"                    todayHighlight: true,\n" +
"                    autoclose: true\n" +
"                };\n" +
"                date_input.datepicker(options);\n" +
"            });\n" +
"        </script>\n" +
"        <!--jatuh tempo-->\n" +
"        <script>\n" +
"            $(document).ready(function () {\n" +
"                var date_input = $('input[name=\"jatuhTempo\"]'); //our date input has the name \"date\"\n" +
"                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : \"body\";\n" +
"                var options = {\n" +
"                    format: 'mm/dd/yyyy',\n" +
"                    container: container,\n" +
"                    todayHighlight: true,\n" +
"                    autoclose: true\n" +
"                };\n" +
"                date_input.datepicker(options);\n" +
"            });\n" +
"        </script>");
            out.println("</body>");
            out.println("</html>");
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

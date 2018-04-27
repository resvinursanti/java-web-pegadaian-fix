<%-- 
    Document   : laporanbulananangsur
    Created on : Apr 25, 2018, 11:18:40 AM
    Author     : Evi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
                                HashMap parameter = new HashMap();

                String tgl1 = request.getParameter("tgl1");
                String tgl2 = request.getParameter("tgl2");

                //                Date nows = new Date(tgl2);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
                SimpleDateFormat formater = new SimpleDateFormat("E MM/dd/yyyy");
                
                
//                DateFormat dateFormat = new SimpleDateFormat("EEE MM/dd/yyyy");
                Date cc = formatter.parse(tgl1);
                Date dd = formatter.parse(tgl2);
                
                String date1 = formater.format(cc);
                String date2 = formater.format(dd);
                
                cc = formater.parse(date1);
                dd = formater.parse(date2);
                
//                out.println(cc.toString() + ", " + dd.toString());
                                parameter.put("tgl1", cc); 
                                parameter.put("tgl2", dd);
                                Connection connection = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
                                File reportFile = new File(application.getRealPath("/laporan/LaporanBulanan.jasper"));
                                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, connection);
                                response.setContentType("application/pdf");
                                response.setContentLength(bytes.length);
                                ServletOutputStream outputStream = response.getOutputStream();
                                outputStream.write(bytes, 0, bytes.length);
                                outputStream.flush();
                                outputStream.close();
            } catch (Exception e) {
                out.println("Error :" + e.getMessage());
                e.printStackTrace();
            }

        %>
    </body>
</html>

<%-- 
    Document   : gadai
    Created on : Apr 17, 2018, 10:03:30 PM
    Author     : TAMU
--%>

<%@page import="dao.GadaiDAO"%>
<%@page import="entities.Gadai"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<a href="gadaiAutoID" type="button">Tambah data</a>-->
        <div class="content-wrapper">
            <section class="content">
                <div class="box" >
                    <div class="box-header">
                        <h2 class="box-title">
                            Data Customer</h2>
                    </div>
                    <table id="example1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID Gadai</th>
                                <th>ID CUSTOMER</th>
                                <th>ID BARANG</th>
                                <th>JUMLAH PINJAMAN</th>
                                <th>TANGGAL PENGAJUAN</th>
                                <th>TANGGAL DITERIMA</th>
                                <th>JATUH TEMPO</th>
                                <th>SISA</th>
                                <th>STATUS</th>
                            </tr>
                        </thead>
                        <%
                            //                List<Object> data2 = new GadaiDAO().getAll();
                            List<Object> datas = (List<Object>) session.getAttribute("gadaii");
                            int j = 1;
                            String logincustomer = (String) session.getAttribute("logincustomer");
                            Object lg=logincustomer;
                            for (Object data : datas) {
                                Gadai g = (Gadai) data;
                        %>
                        <tr>
                            <td><%= j++%></td>
                            <td><%= g.getIdGadai()%></td>
                            <% if (g.getIdCustomer().equals(logincustomer)) { %>
                                <td><%= logincustomer%></td><%
                            }else{ %>
                            <td><%= g.getIdCustomer()%></td>
                            <%
                            }%>
                            <td><%= g.getIdBarang()%></td>
                            <td><%= g.getJumlahPinjaman()%></td>
                            <td><%= g.getTanggalPinjaman()%></td>
                            <td><%= g.getTanggalDiterima()%>
                            <td><%= g.getJatuhTempo()%></td>
                            <td><%= g.getSisa()%></td>
                            <%
                                if (g.getSisa() == 0) {
                            %><td>Lunas</td><%
                            } else {
                            %>
                            <td>Belum Lunas</td><%
                                    }
                                }
                            %>
                    </table>
                </div>
            </section>
        </div>
    </body>
</html> 

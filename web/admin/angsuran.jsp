<%-- 
    Document   : angsuran
    Created on : Apr 19, 2018, 10:23:12 AM
    Author     : TAMU
--%>

<%@page import="dao.AngsuranDAO"%>
<%@page import="entities.Angsuran"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="angsuranAutoID" type="button">Tambah data</a>
        <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID ANGSURAN</th>
                    <th>ID GADAI</th>
                    <th>ID CUSTOMER</th>
                    <th>TANGGAL ANGSURAN</th>
                    <th>JUMLAH ANGSURAN</th>
                    <th>DENDA</th>
                    <th>AKSI</th>
                </tr>
            </thead>
            <%
                List<Object> datas = new AngsuranDAO().getAll();
//                List<Object> datas = (List<Object>) session.getAttribute("angsurann");
                int i = 1;
                for (Object data : datas) {
                    Angsuran a = (Angsuran) data;
            %>
            <tbody>
                <tr>
                    <td><%= i++%></td>
                    <td><%= a.getIdAngsuran()%></td>
                    <td><%= a.getIdCustomer()%></td>
                    <td><%= a.getIdGadai()%></td>
                    <td><%= a.getTanggalAngsuran()%></td>
                    <td><%= a.getJumlahAngsuran()%></td>
                    <td><%= a.getDenda()%>
                    <td><a href="angsuranDelete?id=<%= a.getIdAngsuran()%>">Delete</a></td>
                </tr> 
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

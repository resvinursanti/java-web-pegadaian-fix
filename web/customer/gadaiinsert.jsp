<%-- 
    Document   : gadaiinsert
    Created on : Apr 18, 2018, 10:50:15 AM
    Author     : TAMU
--%>

<%@page import="dao.BarangDAO"%>
<%@page import="entities.Barang"%>
<%@page import="entities.Customer"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String autoid = (String) session.getAttribute("autoID");
        %>
        <form action="gadaiInsert">
            <div>
                <label>ID Gadai</label>
                <input type="text" name="idGadai" value="<%= autoid%>">
            </div>
            <div>
                <label>ID Customer</label>
                <select name="idCustomer">
                    <% List<Object> datas = new CustomerDAO().getAll();
                        //                List<Object> datas = (List<Object>) session.getAttribute("Customerrr");
                        int i = 1;
                        for (Object data : datas) {
                            Customer c = (Customer) data;%>
                    <option><%=c.getIdCustomer()%></option>
                    <%}%>
                </select>
            </div>
            <div>
                <label>ID Barang</label>
                <select name="idBarang">
                    <% List<Object> datas1 = new BarangDAO().getAll();
                        for (Object dataa : datas1) {
                            Barang b = (Barang) dataa;%>
                    <option><%=b.getIdBarang()%></option>
                    <%}%>
                </select>
            </div>
            <div>
                <label>Jumlah Pinjaman</label>
                <input type="text" name="jumlahPinjaman" value="">
            </div>
            <div>
                <label>Tanggal Pengajuan</label>
                <input type="date" name="tanggalPinjaman" value="">
            </div>
            <div>
                <label>Tanggal Diterima</label>
                <input type="date" name="tanggalDiterima" value="">
            </div>
            <div>
                <label>Jatuh Tempo</label>
                <input type="date" name="jatuhTempo" value="">
            </div>
            <div>
                <button type="submit" value="UPDATE"></button>
            </div>
        </form>

    </body>
</html>

<%-- 
    Document   : gadaiupdate
    Created on : Apr 17, 2018, 10:03:47 PM
    Author     : TAMU
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entities.Barang"%>
<%@page import="dao.BarangDAO"%>
<%@page import="java.util.List"%>
<%@page import="entities.Customer"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="entities.Gadai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Object datas = (Object) session.getAttribute("gadaiupdate");
            Gadai g = (Gadai) datas;
        %>
        <form action="prosesUpdateGadai">
            <div>
                <label>ID Gadai</label>
                <input type="text" name="idGadai" value="<%= g.getIdGadai()%>">
            </div>
            <div>
                <label>ID Customer</label>
                <select name="idCustomer">
                    <% List<Object> datas1 = new CustomerDAO().getAll();
                        for (Object data : datas1) {
                            Customer c = (Customer) data;
                            if (g.getIdCustomer().getIdCustomer().equals(c.getIdCustomer())) {
                    %><option value="<%= c.getIdCustomer()%>" selected><%= c.getIdCustomer()%> - <%= c.getNamaCustomer()%></option>
                    <% } else {%>
                    <option value="<%= c.getIdCustomer()%>"><%= c.getIdCustomer()%> - <%= c.getNamaCustomer()%></option>
                    <%
                            }
                        }%>
                </select>
            </div>
            <div>
                <label>ID Barang</label>
                <select name="idBarang">
                    <% List<Object> datas2 = new BarangDAO().getAll();
                        for (Object data : datas2) {
                            Barang b = (Barang) data;
                            if (g.getIdBarang().getIdBarang().equals(b.getIdBarang())) {
                    %><option value="<%= b.getIdBarang()%>" selected><%= b.getIdBarang()%> - <%= b.getNamaBarang()%></option>
                    <% } else {%>
                    <option value="<%= b.getIdBarang()%>"><%= b.getIdBarang()%> - <%= b.getNamaBarang()%></option>
                    <%
                                        }
                                    }%>
                </select>
            </div>
            <div>
                <label>Jumlah Pinjaman</label>
                <input type="text" name="jumlahPinjaman" value="<%= g.getJumlahPinjaman()%>">
            </div
            <% DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String cc = dateFormat.format(g.getTanggalPinjaman());
                    String dd = dateFormat.format(g.getTanggalDiterima());
                    String ee = dateFormat.format(g.getJatuhTempo());
            %>
            <div>
                <label>Tanggal Pengajuan</label>
                <input type="date" id="date" name="tanggalPinjaman" value="<%= cc%>">
            </div>
            <div>
                <label>Tanggal Diterima</label>
                <input type="date" id="date" name="tanggalDiterima" value="<%= dd%>">
            </div>
            <div>
                <label>Jatuh Tempo</label>
                <input type="date" id="date" name="jatuhTempo" value="<%= ee%>">
            </div>
            <div>
                <label>Sisa Pinjaman</label>
                <input type="text" name="sisa" value="<%= g.getSisa()%>">
            </div>
            <div>
                <button type="submit" value="UPDATE"></button>
            </div>
        </form>
    </body>
</html>

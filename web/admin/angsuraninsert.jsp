<%-- 
    Document   : angsuraninsert
    Created on : Apr 19, 2018, 10:23:30 AM
    Author     : TAMU
--%>

<%@page import="entities.Gadai"%>
<%@page import="dao.GadaiDAO"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="entities.Customer"%>
<%@page import="java.util.List"%>
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
        <form action="angsuranInsert">
            <div>
                <label>ID Angsuran</label>
                <% if (autoid.equals("AG")) {
                %><input type="text" name="idAngsuran" value="<%= autoid%>001"><%
                } else {%>
                <input type="text" name="idAngsuran" value="<%= autoid%>">
                <%}%>
            </div>
            <div>
                <label>ID Customer</label>
                <select name="idCustomer">
                    <% List<Object> datas = new CustomerDAO().getAll();
                       for (Object data : datas) {
                           Customer c = (Customer) data;%>
                    <option><%=c.getIdCustomer()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>ID Gadai</label>
                <select name="idGadai">
                    <% List<Object> datas1 = new GadaiDAO().getAll();
                       for (Object dataa : datas1) {
                           Gadai g = (Gadai) dataa;%>
                    <option><%=g.getIdGadai()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>Tanggal Angsuran</label>
                <input type="date" name="tanggalAngsuran" value="">
            </div>
            <div>
                <label>Jumlah Angsuran</label>
                <input type="text" name="jumlahAngsuran" value="">
            </div>
            <div>
                <label>Denda</label>
                <input type="text" name="denda" value="">
            </div>
            <div>
                <button type="submit" value="UPDATE"></button>
            </div>
        </form>
    </body>
</html>

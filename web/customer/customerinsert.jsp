<%-- 
    Document   : customerinsert
    Created on : Apr 18, 2018, 8:48:59 AM
    Author     : TAMU
--%>

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
        <form action="customerInsert">
            <div>
                <label>ID Customer</label>
                <input type="text" name="idCustomer" value="<%= autoid%>" readonly="true">
            </div>
            <div>
                <label>Nomor KTP</label>
                <input type="text" name="nomorKtp" value="">
            </div>
            <div>
                <label>Nama</label>
                <input type="text" name="nama" value="">
            </div>
            <div>
                <label>Jenis Kelamin</label>
                <!--                <input type="text" name="jenisKelamin" value="">-->
                <input type="radio" name="gender" value="Laki-laki"> Laki-laki<br>
                <input type="radio" name="gender" value="Perempuan"> Perempuan<br>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value="">
            </div>
            <div>
                <label>Nomor Telepon</label>
                <input type="text" name="nomorTelepon" value="">
            </div>
            <div>
                <label>Pekerjaan</label>
                <input type="text" name="pekerjaan" value="">
            </div>
            <div>
                <label>Alamat</label>
                <input type="text" name="alamat" value="">
            </div>
            <div>
                <button type="submit" value="UPDATE"></button>
            </div>
        </form>
            <footer>
            <nav class="nav navbar-nav nav-stacked navbar-fixed-bottom">
                <ul class="nav navbar-nav">
                    <li style="margin-left: 255%;"><b>PegadaianV1.0</b>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li style="margin-left: -25%;">
                        <b>PT. MII | &COPY;2018</b>
                    </li>
                </ul>
            </nav>
        </footer>
    </body>
</html>

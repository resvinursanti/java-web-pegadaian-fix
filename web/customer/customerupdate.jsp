<%-- 
    Document   : customerupdate
    Created on : Apr 17, 2018, 9:33:54 PM
    Author     : TAMU
--%>

<%@page import="entities.Barang"%>
<%@page import="dao.BarangDAO"%>
<%@page import="java.util.List"%>
<%@page import="tools.BCrypt"%>
<%@page import="entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body { 
                background-image: url('customer/bg.jpg');
                background-size: cover;
            }
            label.white{
                color: white;
            }
           
        </style>
    </head>
    <body>
        <header>
            <%
                String logincustomer = (String) session.getAttribute("logincustomerr");
                Object data = session.getAttribute("logincustomer");
                Customer cu = (Customer) data;
            %>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span> 
                        </button>
                        <a class="navbar-brand" href="#"><img style="width:25px;" src="bootstrap/img/logo.png"></a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="customerController">Beranda</a></li>
<!--                            <li><a><form action="laporan/angsuran.jsp">
        <input type="hidden" value="" /> <input type="submit" class="btn-sm btn-primary" value="Lihat Angsuran"/>
     
    </form></a></li>-->
                            <li><a><form action="laporan/customerlaporan.jsp">
        <input type="hidden" name="idCustomer" value="<%= logincustomer%>" /> <input type="submit" class="btn-sm btn-primary" value="Lhat Gadai"/>
     
    </form></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <div class="dropdown" style="margin-top: 9%;">
                                <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><%= cu.getUsername() %></a>
                                <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="logoutController"><span class="glyphicon glyphicon-log-in"></span> Logout</a></a></li>
                                    <li><a href="customerUpdate?customer=<%= logincustomer%>">Update Akun</a></li>
                                    <li><a href="">Change Password</a></li>
                                </ul>
                            </div>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <%
            Object datas = (Object) session.getAttribute("customerupdates");
            Customer c = (Customer) datas;
        %>
        <div class="modal-body">
            <form action="prosesUpdateCustomer" method="get">
                <div class="form-group">
                    <label class="white">ID Customer</label>
                    <input  class="form-control"   style="width:30%" type="text" name="idCustomer" value="<%= c.getIdCustomer()%>" readonly="true" required="">
                </div>
                <div class="form-group">
                    <label class="white">Nomor KTP</label>
                    <input  class="form-control" type="text" style="width:30%" name="nomorKtp" value="<%= c.getNomorKtp()%>" required="">
                </div>
                <div class="form-group">
                    <label>Nama</label>
                    <input  class="form-control"  style="width:30%" type="text" name="nama" value="<%= c.getNamaCustomer()%>" required="">
                </div>
                <div class="form-group">
                    <label class="white">Jenis Kelamin :</label>
                    <%
                        if (c.getJenisKelamin().equals("Laki-laki")) {%>
                        <input type="radio" name="jenisKelamin" value="Laki-laki" checked="checked"> <label class="white">Laki-laki</label>
                        &nbsp;&nbsp;&nbsp;<input type="radio" name="jenisKelamin" value="Perempuan"> <label class="white">Perempuan</label><%
                    } else {%>
                    <input type="radio" name="jenisKelamin" value="Laki-laki"> <label class="white">Laki-laki</label>
                    &nbsp;&nbsp;&nbsp;<input type="radio" name="jenisKelamin" value="Perempuan" checked="checked"> <label class="white">Perempuan</label><%
                        }
                    %>
                </div>
                <div class="form-group">
                    <label class="white">Nomor Telepon</label>
                    <input class="form-control"  style="width:30%" type="text" name="nomorTelepon" value="<%= c.getNomorTelepon()%>" required="">
                </div>
                <div class="form-group">
                    <label class="white">Pekerjaan</label>
                    <input class="form-control"  style="width:30%" type="text" name="pekerjaan" value="<%= c.getPekerjaan()%>" required="">
                </div>
                <div class="form-group">
                    <label class="white">Alamat</label>
                    <input class="form-control" type="text"  style="width:30%" name="alamat" value="<%= c.getAlamat()%>" required="">
                    <input type="hidden" name="username" value="<%= c.getUsername()%>">
                    <input type="hidden" name="password" value="<%= c.getPassword()%> ">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">UPDATE</button>
                </div>
            </form>
        </div>
                
                <div id="aboutModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <%
                            String autoid = (String) session.getAttribute("autoID");
                        %>
                        <form action="gadaiInsert">
                            <div class="form-group">
                                <label>ID Gadai</label>
                                <input class="form-control" type="text" name="idGadai" value="<%= autoid%>" readonly="true">
                            </div>
                            <div class="form-group">
                                <label>ID Customer</label>
                                <input class="form-control" type="text" name="idCustomer" value="<%= logincustomer%>" readonly="true">
                            </div>
                            <div class="form-group">
                                <label>ID Barang</label>
                                <select  class="form-control" name="idBarang">
                                    <% List<Object> datas1 = new BarangDAO().getAll();
                                        for (Object dataa : datas1) {
                                            Barang b = (Barang) dataa;%>
                                    <option><%=b.getIdBarang()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Jumlah Pinjaman</label>
                                <input class="form-control" type="text" name="jumlahPinjaman" value="">
                            </div>
                            <div class="form-group">
                                <label>Tanggal Pengajuan</label>
                                <input class="form-control input3" type="text" name="tanggalPinjaman" id="date" value="">
                            </div>
                            <div class="form-group">
                                <label>Tanggal Diterima</label>
                                <input class="form-control input3" type="text" name="tanggalDiterima" id="date" value="">
                            </div>
                            <div class="form-group">
                                <label>Jatuh Tempo</label>
                                <input class="form-control input3" type="text" name="jatuhTempo" id="date" value="">
                            </div>
                            <div class="form-group">
                                <button  class="form-control btn btn-primary" type="submit">SUBMIT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                                <footer>
            <nav class="navbar navbar-inverse navbar-fixed-bottom">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <li><a>Pegadaian V1.0</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a>PT. MII | &COPY;2018</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </footer>
    </body>
</html>

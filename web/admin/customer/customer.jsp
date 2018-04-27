<%-- 
    Document   : Customer
    Created on : Apr 17, 2018, 8:58:18 PM
    Author     : TAMU
--%>

<%@page import="dao.CustomerDAO"%>
<%@page import="java.util.List"%>
<%@page import="entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Theme Made By www.w3schools.com - No Copyright -->
        <title>Customer</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <body class="hold-transition skin-green fixed sidebar-mini">
        <!-- Site wrapper -->
        <% String loginadmin = (String) session.getAttribute("username");
        %>
        <!-- Site wrapper -->
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="index.jsp" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>DM</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b><img style="width:25px;" src="bootstrap/img/logo.png"></b> Admin</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown messages-menu">

                                <ul class="dropdown-menu">

                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li><!-- start message -->
                                                <a href="#">
                                                    <div class="pull-left">

                                                    </div>


                                                </a>
                                            </li>
                                            <!-- end message -->
                                        </ul>
                                    </li>

                                </ul>
                            </li>
                            <!-- Tasks: style can be found in dropdown.less -->
                            <div class="dropdown" style="margin-top: 9%;">
                                <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"><%= loginadmin%></span></a>
                                <span class="caret"></span></button>
                                <ul  style="margin-left: -15%;" class="dropdown-menu">
                                    <li><a href="logoutController"><span class="glyphicon glyphicon-log-in"></span> Logout</a></a></li>
                                </ul>
                            </div>
                        </ul>
                    </div>
                </nav>
            </header>

            <!-- =============================================== -->

            <!-- Left side column. contains the sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                        </div>

                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">

                        <li><a href=#><i class="fa fa-circle"></i>Dashboard</a></li>
                        <li><a href="customerController"><i class="fa fa-user"></i>Data Customer</a></li>
                        <li><a href="barangController"><i class="fa fa-file-o"></i>Data Barang</a></li>
                        <li><a href="jenisBarangController"><i class="fa fa-file-o"></i>Data Jenis Barang</a></li>
                        <li><a href="gadaiControllerAdmin"><i class="fa fa-file-o"></i>Data Gadai Barang</a></li>
                        <li><a href="angsuranController"><i class="fa fa-money"></i>Data Angsuran </a></li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-archive-o"></i> <span>Laporan</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="laporan/laporanparameter.jsp"><i class="fa fa-file"></i> Laporan dengan ID Gadai</a></li>
                                <li><a href="laporan/angsuran.jsp"><i class="fa fa-file"></i> Laporan Angsuran Setiap Bulan</a></li>
                                <li><a href="laporan/parametercust.jsp"><i class="fa fa-file"></i> Laporan Gadai Customer</a></li>
                                <li><a href="laporan/parameterperiode.jsp"><i class="fa fa-file"></i> Laporan Angsuran Per-Periode</a></li>

                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- =============================================== -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <section class="content">
                    <div class="box" >
                        <div class="box-header">
                            <h2 class="box-title">
                                Data Customer</h2>
                        </div>
                        <br>
                        <div>
                            <form style="margin-left: 1%" action="laporan/customerlaporan.jsp">
                            <input type="text" name="idCustomer" value=""  data-toggle="tooltip" title="Berdasarkan ID Customer"/> 
                            <input type="submit" class="btn-sm btn-default" style="color: green" value="Show Report"/>
                        </form>
                        <div class="text-right" style="padding-right: 10px">
                            <a href="customerAutoIDAdmin" class="btn btn-sm btn-warning">Tambah Customer<i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                        </div>
                        <br>
                        <div class="box-body">

                            <%if (session.getAttribute("pesan") != null) { %>
                            <div class="alert alert-success">
                                <% out.print(session.getAttribute("pesan") + "<br>");
                                       session.removeAttribute("pesan"); %>
                            </div>
                            <% }%>

                            <%if (session.getAttribute("pesanu") != null) { %>
                            <div class="alert alert-success">
                                <% out.print(session.getAttribute("pesanu") + "<br>");
                                       session.removeAttribute("pesanu"); %>
                            </div>
                            <% }%>
                        </div>
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>NO</th>
                                    <th>ID CUSTOMER</th>
                                    <th>NOMOR KTP</th>
                                    <th>NAMA CUSTOMER</th>
                                    <th>JENIS KELAMIN</th>
                                    <th>NOMOR TELEPON</th>
                                    <th>PEKERJAAN</th>
                                    <th>ALAMAT</th>
                                    <th>AKSI</th>
                                </tr>
                            </thead>

                            <%
                                List<Object> datas = new CustomerDAO().getAll();
                                //  List<Object> datas = (List<Object>) session.getAttribute("Customerrr");
                                int i = 1;
                                for (Object data : datas) {
                                    Customer c = (Customer) data;
                            %>

                            <tr>
                                <td><%= i++%></td>
                                <td><%= c.getIdCustomer()%></td>
                                <td><%= c.getNomorKtp()%></td>
                                <td><%= c.getNamaCustomer()%></td>
                                <td><%= c.getJenisKelamin()%></td>
                                <td><%= c.getNomorTelepon()%></td>
                                <td><%= c.getPekerjaan()%></td>
                                <td><%= c.getAlamat()%></td>
                                <td><a href="customerUpdateAdmin?id=<%= c.getIdCustomer()%>" data-toggle="tooltip" title="Update" ><span class="glyphicon glyphicon-edit"></a></span>
                                    <a href="customerDelete?id=<%= c.getIdCustomer()%>" data-toggle="tooltip" title="Delete"  onclick="return confirm('Apakah yakin akan menghapus data?')"><span class="glyphicon glyphicon-trash"></a><span</td>

                            </tr> 
                            <%
                                }
                            %>

                        </table>
                    </div>
                </section>
            </div>            
        </div>
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

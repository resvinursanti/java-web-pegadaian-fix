<%-- 
    Document   : angsuran
    Created on : Apr 18, 2018, 4:34:55 PM
    Author     : Evi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entities.Angsuran"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Theme Made By www.w3schools.com - No Copyright -->
        <title>Angsuran</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <body class="hold-transition skin-green fixed sidebar-mini">
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
                        <li><a href="customerControllerAdmin"><i class="fa fa-user"></i>Data Customer</a></li>
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
                <!-- Content Header (Page header) -->

                <!-- Main content -->
                <section class="content">
                    <!-- Content Header (Page header) -->

                    <div class="box" >



                        <div class="box-header">

                            <h3 class="box-title">
                                Data Angsuran</h3>

                        </div>
                        <br>
                        <div class="text-right" style="padding-right: 10px">
                            <a href="angsuranAutoID" class="btn btn-sm btn-warning">Tambah Data Angsuran<i class="fa fa-arrow-circle-right"></i></a>

                        </div>

                        <br>
                          <form action="laporan/laporan.jsp">
        <!--                                        <select name="">
                                                    <option>nik</option>
                                                    <option>bulan</option>
                                                </select>-->
        <input type="text" name="idGadai" value=""  data-toggle="tooltip" title="Berdasarkan ID Gadai"/> <input type="submit" class="btn-sm btn-default" style="color: green" value="Show Report"/>
        <hr/>
    </form>

                        <!-- /.box-header -->

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
                                    <th>No</th>
                                    <th>ID Angsuran</th>
                                    <th>ID Gadai</th>
                                    <th>ID Customer</th>
                                    <th>Tanggal Angsuran</th>
                                    <th>Jumlah Angsuran</th>
                                    <th>Denda</th>
                                    <th>Aksi</th>
                                </tr>
                            </thead>
                            <%
                                // List<Object> datas = new JenisBarangDAO().getAll();
                                List<Object> datas = (List<Object>) session.getAttribute("angsurann");
                                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                int i = 1;
                                for (Object data : datas) {
                                    Angsuran c = (Angsuran) data;
                                    String tgl = dateFormat.format(c.getTanggalAngsuran());
//                                    Date tgl1 = dateFormat.parse(c.getTanggalAngsuran() + "");
//                                    Date tgl2 = dateFormat.parse(c.getIdGadai().getJatuhTempo() + "");
//                                    tgl1.compareTo(tgl2);
                                    float denda = c.getIdGadai().getJumlahPinjaman().floatValue();
                                    float a = 12;
                                    float b = 100;
                            %>
                            <tr>
                                <td><%= i++%></td>
                                <td><%= c.getIdAngsuran()%></td>
                                <td><%= c.getIdGadai()%></td>
                                <td><%= c.getIdCustomer()%> - <%= c.getIdCustomer().getNamaCustomer()%></td>
                                <td><%= tgl %></td>
                                <td><%= c.getJumlahAngsuran()%></td>
                                <% if (c.getTanggalAngsuran().before(c.getIdGadai().getJatuhTempo())) {%>
                                <td>0</td><% } else {%>
                                <td><%= a/b*denda%></td><% }%>
                                <td><a href="angsuranDelete?id=<%= c.getIdAngsuran()%>" data-toggle="tooltip" title="Delete" onclick="return confirm('Apakah anda yakin menghapus data?')"><span class="glyphicon glyphicon-trash"></span></a>
                            </tr> 
                            <%
                                }
                            %>
                        </table>
                    </div>
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


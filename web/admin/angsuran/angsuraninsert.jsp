<%-- 
    Document   : angsuraninsert
    Created on : Apr 18, 2018, 4:49:39 PM
    Author     : Evi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entities.Gadai"%>
<%@page import="dao.GadaiDAO"%>
<%@page import="entities.Customer"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <title>Angsuran Insert</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bootstrap/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bootstrap/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="bootstrap/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="bootstrap/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
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

                <br>
                <br>

        <%
            String autoid = (String) session.getAttribute("autoID");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date now = new Date();
                        String tanggalangsuran = dateFormat.format(now);
        %>
         <div class="container">
             <h2>Form Angsuran Gadai</h2>
        <form action="angsuranInsert">
            <div>
                <label>ID Angsuran</label>
                
                <%if (autoid.equals("AG")) {
                %> <input type="text" name="idAngsuran" class="form-control" style="width:30%" value="<%= autoid%>001" readonly="true"/> <%
                } else {
                %> <input  type ="text" name ="idAngsuran" class="form-control" style="width:30%" value="<%= autoid%>" readonly="true" /><%
               }
                %>
            </div>
            <div>
                <label>ID Gadai</label>
                <select name="idGadai"  class="form-control" style="width:30%">
                    <% List<Object> datas = new GadaiDAO().getAll();
                        for (Object data : datas) {
                            Gadai g = (Gadai) data;%>
                    <option><%=g.getIdGadai()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>ID Customer</label>
                <select name="idCustomer"  class="form-control" style="width:30%">
                    <% List<Object> datar = new CustomerDAO().getAll();
                        for (Object data : datar) {
                            Customer c = (Customer) data;%>
                    <option value="<%=c.getIdCustomer()%>"><%=c.getIdCustomer()%>-<%=c.getNamaCustomer()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>Tanggal Angsuran</label>
                <input type="date" name="tanggalAngsuran" value="<%= tanggalangsuran%>"  class="form-control" style="width:30%" required="">
            </div>
            <div>
                <label>Jumlah Angsuran</label>
                <input type="number" name="jumlahAngsuran" value=""  class="form-control" style="width:30%" required="">
            </div>
           
                <br>
            <div>
                <button type="submit" class="btn btn-default" value="Insert">Insert</button>
            </div>
        </form>
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


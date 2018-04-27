<%-- 
    Document   : Customer
    Created on : Apr 17, 2018, 8:58:18 PM
    Author     : TAMU
--%>

<%@page import="entities.Barang"%>
<%@page import="dao.BarangDAO"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="java.util.List"%>
<%@page import="entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <style>
            body { 
                background-image: url('customer/bg.jpg');
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <header>
            <%
                String logincustomer = (String) session.getAttribute("logincustomerr");
                Object data = session.getAttribute("logincustomer");
                Customer c = (Customer) data;
            %>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span> 
                        </button>
                        <a class="navbar-brand" href="customerController"><img style="width:25px;" src="bootstrap/img/logo.png"></a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Beranda</a></li>
<!--                            <li><a><form action="laporan/angsuran.jsp">
        <input type="hidden" value="" /> <input type="submit" class="btn-sm btn-primary" value="Lihat Angsuran"/>
     
    </form></a></li>-->
                            <li><a><form action="laporan/customerlaporan.jsp">
        <input type="hidden" name="idCustomer" value="<%= logincustomer%>" /> <input type="submit" class="btn-sm btn-primary" value="Lhat Gadai"/>
     
    </form></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <div class="dropdown" style="margin-top: 9%;">
                                <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"><%= c.getUsername() %></span></a>
                                <span class="caret"></span>
                                <ul class="dropdown-menu">
                                    <li><a href="logoutController"><span class="glyphicon glyphicon-log-in"></span> Logout</a></a></li>
                                    <li><a href="customerUpdate?username=<%= logincustomer%>"><span class="glyphicon glyphicon-user">UpdateAkun</span></a></li>
                                    <li><a data-target="#modalpassword" data-toggle="modal">Ubah Password</a></li>
                                </ul>
                            </div>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
                                <div class="container" style="width: 60%;"> 
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="customer/slide.png" alt="Los Angeles" style="width:100%;">
                    </div>

                    <div class="item">
                        <img src="customer/slide.png" alt="Chicago" style="width:100%;">
                    </div>

                    <div class="item">
                        <img src="customer/slide.png" alt="New york" style="width:100%;">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
                                    <!-- Modal -->
<div id="modalpassword" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Ubah Password</h4>
      </div>
      <div class="modal-body">
        <form action="ubahPassword">
                            <div class="form-group">
                                <label>Password Lama</label>
                                <input type="hidden" name="username" value="<%= logincustomer %>" >
                                <input class="form-control" type="text" name="passwordlama" value="">
                            </div>
                            <div class="form-group">
                                <label>Password Baru</label>
                                <input class="form-control" type="text" name="passwordbaru" value="">
                            </div>
                            <div class="form-group">
                                <label>Konfirmasi Password Baru</label>
                                <input class="form-control" type="text" name="passwordbaru2" value="">
                            </div>
                            <div class="form-group">
                                <button  class="form-control btn btn-primary" type="submit">SUBMIT</button>
                            </div>
                        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

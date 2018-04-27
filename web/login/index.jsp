<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Login Pegadaian</title>
    </head>
    <body>
        <div class="container">
            <div class="info">
                <h1>Pegadaian</h1><span>V1.0 <i class="fa fa-heart"></i> by PT.MII</span>
            </div>
        </div>
        <div class="form">
            <div class="thumbnail"><img style="margin-top: -19%;" src="login/logo.png"/></div>
                <%
                    String autoid = (String) session.getAttribute("autoID");
                %>
            <form class="register-form" action="customerInsert">
                <% if(autoid.equals("C")){ %>
                    <input type="text" placeholder="name" name="idCustomer" value="<%= autoid%>001" readonly="true"/>
                <% }else{ %>
                <input type="text" placeholder="name" name="idCustomer" value="<%= autoid%>" readonly="true"/>
                <% } %>
                <input type="text" placeholder="Nomor KTP" name="nomorKtp" required=""/>
                <input type="text" placeholder="Nama" name="nama" required=""/>
                <div style="margin-left: -42%;"><label>Jenis Kelamin :</label>
                    <input style="position: absolute; margin-left: -41%;" type="radio" name="gender" value="Laki-laki"><a style="margin-left: 2%;">L</a>
                    </br><input style="position: absolute; margin-left: -10%;" type="radio" name="gender" value="Perempuan"><a style="margin-left: 28%;">P</a></div>
                    </br>
                    <input type="text" placeholder="Username" name="username" required=""/>
                    <input type="password" placeholder="Password" name="password" required=""/>
                <input type="text" placeholder="Nomor Telepon" name="nomorTelepon" required=""/>
                <input type="text" placeholder="Alamat" name="alamat" required=""/>
                <input type="text" placeholder="Pekerjaan" name="pekerjaan" required=""/>
                <button type="submit">create</button>
                <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form>
            <form class="login-form" action="loginController" method="POST">
                <input type="text" placeholder="Username" name="username" required=""/>
                <input type="password" placeholder="Password" name="password" required=""/>
                <button type="submit">login</button>
                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </body>

</html>

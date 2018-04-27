/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.LoginDAO;
import entities.Customer;
import entities.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.BCrypt;

/**
 *
 * @author TAMU
 */
public class LoginController extends HttpServlet {

    private LoginDAO lDao;

    public LoginController() {
        lDao = new LoginDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDAO cdao = new CustomerDAO();
        LoginDAO ldao = new LoginDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String category = "username";
        Customer customer = new Customer();
        Login log = new Login();
        HttpSession session = request.getSession();
        Customer cu = (Customer) new CustomerDAO().getById(username);
        try (PrintWriter out = response.getWriter()) {
            if (new CustomerDAO().getById(username) == null) {
                if (ldao.login(category, username, password)) {
                    List<Object> datas = (List<Object>) ldao.search(category, username);
                    for (Object data : datas) {
                        Login l = (Login) data;
                        if (l.getUsername().equals(username)) {
                            if (l.getAkses().equals("admin")) {
                                session.setAttribute("username", username);
                                response.sendRedirect("admin/index.jsp");
                            } else if (l.getAkses().equals("manager")) {
                                session.setAttribute("username", username);
                                response.sendRedirect("manager/index.jsp");
                            }
                        } else {
                            System.out.println("gagal login");
                        }
                    }
                }
            } else {
                if (cdao.check(username, password)) {
                    Customer c = (Customer) new CustomerDAO().getById(username);
                    session.setAttribute("customerupdates", customer);
                    session.setAttribute("logincustomer", c);
                    session.setAttribute("logincustomerr", username);
                    response.sendRedirect("customerController");
                } else {
                    response.sendRedirect("customerAutoID");
                }
            }
        }
    }
}

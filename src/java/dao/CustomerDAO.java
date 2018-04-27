/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Customer;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class CustomerDAO {
    private  Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionDAO fdao;

    public CustomerDAO() {
        this.fdao = new FunctionDAO();
    }
    
    public boolean insert(Object object){
        return fdao.insert(object);
    }
    
    public boolean delete(Object object){
        return fdao.delete(Customer.class,object.toString());
    }
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Customer WHERE " + category + " LIKE '%" + search + "%'");
    }

    public Object getById(String Id) {
        return fdao.getById("from Customer where idCustomer='" + Id + "'");
    }
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Customer");
    }
    public String getAutoID () {
        return (String) fdao.getById("SELECT CONCAT('C',LPAD((TO_NUMBER(SUBSTR(MAX(id_customer),3,3))+1),3, '0')) as MAX FROM Customer");
    }
    public boolean check(String Id, String Password){
       Customer um = (Customer) getById(Id);
        return BCrypt.checkpw(Password, um.getPassword());
//        try {
//        String url ="jdbc:oracle:thin:@localhost:1521:XE";
//        String query = "Select * From DB_PEGADAIAN.CUSTOMER Where id_customer=? and password=?";
//        String username = "system";
//        String password = "2429";
//            Customer cu = (Customer) getById(Id);
//            Class.forName("oracle.jdbc.OracleDriver");
//            Connection conn = DriverManager.getConnection(url, username, password);
//            PreparedStatement st = conn.prepareStatement(query);
////              PreparedStatement st = (PreparedStatement) fdao.getAlll("From Customer Where idCustomer='"+Id+"' and password='"+Password+"'");
//              st.setString(1, Id);
//              st.setString(2, BCrypt.checkpw(password, cu.getPassword()));
//              ResultSet rs = st.executeQuery();
//              if(rs.next()){
//                  return true;
//              }
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    public boolean insert(String idCustomer, String username, String passwordbaru) {
        Customer c = new Customer(idCustomer, username, BCrypt.hashpw(passwordbaru, BCrypt.gensalt()));
        return insert (c);
    }
}

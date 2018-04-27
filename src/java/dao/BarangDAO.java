/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Barang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class BarangDAO {
    private  Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionDAO fdao;

    public BarangDAO() {
        this.fdao = new FunctionDAO();
      //  this.factory = HibernateUtil.getSessionFactory();
    }
    
    public boolean insert(Object object){
        return fdao.insert(object);
    }
    
    public boolean delete(Object object){
        return fdao.delete(Barang.class,object.toString());
    }
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Barang WHERE " + category + " LIKE '%" + search + "%'");
    }

    public Object getById(String Id) {
        return fdao.getById("from Barang where idBarang='" + Id + "'");
    }
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Barang");
    }
    public String getAutoID () {
        return (String) fdao.getById("SELECT CONCAT('brg',LPAD((TO_NUMBER(SUBSTR(MAX(idBarang),4,4))+1),2, '0')) as MAX FROM Barang");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.JenisBarang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class JenisBarangDAO {
    private  Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionDAO fdao;
    
    public JenisBarangDAO() {
        this.fdao = new FunctionDAO();
        this.factory = HibernateUtil.getSessionFactory();
      }
    public boolean insert(Object object){
        return fdao.insert(object);
    }
    
    public boolean delete(Object object){
        return fdao.delete(Object.class,object.toString());
    }
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM JenisBarang WHERE " + category + " LIKE '%" + search + "%'");
    }

    public Object getById(String Id) {
        return fdao.getById("from JenisBarang where idJenisBarang='" + Id + "'");
    }
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM JenisBarang");
    }
    public String getAutoID () {
        return (String) fdao.getById("SELECT CONCAT('j',LPAD((TO_NUMBER(SUBSTR(MAX(idJenisBarang),3,3))+1),3, '0')) as MAX FROM JenisBarang");
    }
}

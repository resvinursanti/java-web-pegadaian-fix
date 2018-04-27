/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Gadai;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class GadaiDAO {
    private  Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionDAO fdao;

    public GadaiDAO() {
        this.fdao = new FunctionDAO();
    }
    
    public boolean insert(Object object){
        return fdao.insert(object);
    }
    
    public boolean delete(Object object){
        return fdao.delete(Gadai.class,object.toString());
    }
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Gadai WHERE " + category + " LIKE '%" + search + "%'");
    }

    public Object getById(String Id) {
        return fdao.getById("from Gadai where idGadai='" + Id + "'");
    }
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Gadai");
    }
    public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('GA',LPAD((TO_NUMBER(SUBSTR(MAX(id_customer),3,3))+1),3, '0')) as MAX FROM Gadai");
    }
    
}
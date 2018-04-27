/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class FunctionDAO {
    private Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionDAO fdao;

    public FunctionDAO(Session session, Transaction transaction, SessionFactory factory, FunctionDAO fdao) {
        this.session = session;
        this.transaction = transaction;
        this.factory = factory;
        this.fdao = fdao;
    }

    public FunctionDAO() {
        this.factory = HibernateUtil.getSessionFactory();
    }
    
    public boolean insert(Object object){
        boolean flag = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return flag;
    }
    public boolean delete(Class type, Serializable srlzbl) {
        boolean flag = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            System.out.println(Object.class);
            session.delete(session.get(type, srlzbl));
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return flag;
    }
    

    public List<Object> getAll(String query) {
        List<Object> data = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            data = session
                    .createQuery(query)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }
    public Object getAlll(String query) {
        List<Object> data = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            data = session
                    .createQuery(query)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    public Object getById(String query) {
        Object obj = new Object();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            obj = session.createQuery(query).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return obj;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Login;
import java.util.List;
import tools.BCrypt;

/**
 *
 * @author TAMU
 */
public class LoginDAO {
    private final FunctionDAO fdao;
    public LoginDAO(){
        this.fdao = new FunctionDAO();
    }
    public boolean insert(Object object) {
        return fdao.insert(object);
    }


    public boolean delete(Object object) {
        return fdao.delete(LoginDAO.class, (object.toString()));
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Login ORDER BY ID");
    }

    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Login WHERE "+category+" LIKE '%"
        +search+"%'ORDER BY ID");
    }

    public Object getById(String id) {
        return fdao.getById("FROM Login WHERE ID="+id);
    }

    public Object getAutoID() {
        return fdao.getById("SELECT MAX(id)+1 FROM Login");
    }
    
    public Object getUserName(String username) {
        return fdao.getById("FROM Login WHERE USERNAME="+username);
    }
    
    public boolean login(String category, String username, String password){
//        Usermanagement u = (Usermanagement) search(category, username).get(0);
//        return  BCrypt.checkpw(password, u.getPassword());
        List<Object> datas = (List<Object>) search(category, username);
        if(datas.isEmpty()){return false;}
        else {
            Login l = (Login) datas.get(0);
            return  BCrypt.checkpw(password, l.getPassword());
        }
    } 
}

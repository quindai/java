/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufal.ic.rbs.bo;

import java.sql.SQLException;
import ufal.ic.rbs.dao.LoginDAO;

/**
 *
 * @author Abigail Musa Gindaus
 */
public class Login {
    LoginDAO loginDAO;
    public Login() throws SQLException, ClassNotFoundException{
        loginDAO = new LoginDAO();
    }
    public boolean exist(String user, String pswd) throws SQLException, ClassNotFoundException{
        return loginDAO.exist(user, pswd);
    }
    
    public boolean closeConnection() throws SQLException{
        return loginDAO.closeConnection();
    }
}

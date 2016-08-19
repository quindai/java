/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufal.ic.rbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abigail Musa Gindaus
 */
public class LoginDAO {
    private Connection conn;
    
    public LoginDAO() throws SQLException, ClassNotFoundException{
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean exist(String user, String pswd) throws SQLException{
        String sql = "SELECT * FROM Login WHERE user=? AND psswrd=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        stmt.setString(2, pswd);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
    
    public boolean closeConnection() throws SQLException{
        conn.close();
        return true;
    }
}
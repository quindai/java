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
import java.util.List;
import ufal.ic.rbs.model.OrderDet;

/**
 *
 * @author randy
 */
public class OrderDetDAO {
    private Connection conn;
    public OrderDetDAO() throws ClassNotFoundException, SQLException{
		conn = new ConnectionFactory().getConnection();
    }
    
    public boolean save(List<?> o) throws SQLException{
        List<OrderDet> orders = (List<OrderDet>)o;
        String aux_sql = "SELECT * FROM Orders ORDER BY id DESC LIMIT 1";
        String sql = "INSERT INTO OrdersDet(id_orders, id_product, price, quant) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(aux_sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        for(OrderDet op : orders){
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, op.getProduct().getId());
            stmt.setDouble(3, op.getPrice());
            stmt.setInt(4, op.getQuant());
            stmt.execute();
        }
        
        return true;
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    }
}

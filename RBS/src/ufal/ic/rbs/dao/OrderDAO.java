/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ufal.ic.rbs.model.Order;

/**
 *
 * @author randy
 */
public class OrderDAO {
    private Connection conn;	
    public OrderDAO() throws ClassNotFoundException, SQLException{
	conn = new ConnectionFactory().getConnection();
    }

    public boolean save(Order order) throws SQLException, ParseException{
        String sql = "INSERT INTO orders(amount,amount_paid,id_paymnttype) "+
                        "VALUES(?,?,?)";
        //SimpleDateFormat sd = new SimpleDateFormat();
        PreparedStatement st = conn.prepareStatement(sql);
        st.setDouble(1, order.getAmount());
        st.setDouble(2, order.getAmount_paid());
        //st.setString(3, order.getOrder_date());
        //st.setDate(3, new java.sql.Date(sd.parse(order.getOrder_date()).getTime()));
        st.setInt(3, order.getPaymntType().ordinal() + 1);
        st.execute();
        st.close();
        return true;
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    }
}

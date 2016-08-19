/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.bo;

import java.sql.SQLException;
import java.text.ParseException;
import ufal.ic.rbs.dao.OrderDAO;
import ufal.ic.rbs.model.Order;

/**
 *
 * @author randy
 */
public class OrderBO {
    OrderDAO orderDAO;

    public OrderBO() throws ClassNotFoundException, SQLException {
        orderDAO = new OrderDAO();
    }
    
    public boolean save(Order order) throws SQLException, ParseException{
        return orderDAO.save(order);
    }
    
    public void closeConnection() throws SQLException{
        orderDAO.closeConnection();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.bo;

import java.sql.SQLException;
import java.util.List;
import ufal.ic.rbs.dao.OrderDetDAO;

/**
 *
 * @author randy
 */
public class OrderDetBO {
    OrderDetDAO orderDetDAO;

    public OrderDetBO() throws ClassNotFoundException, SQLException {
        orderDetDAO = new OrderDetDAO();
    }
    
    public boolean save(List<?> o) throws SQLException{
        return orderDetDAO.save(o);
    }
    
    public void closeConnection() throws SQLException{
        orderDetDAO.closeConnection();
    }
}

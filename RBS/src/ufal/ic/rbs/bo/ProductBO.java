/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.bo;

import java.sql.SQLException;
import java.util.List;
import ufal.ic.rbs.dao.ProductDAO;
import ufal.ic.rbs.model.Product;

public class ProductBO {
    ProductDAO productDAO;

    public ProductBO() throws SQLException, ClassNotFoundException {
        productDAO = new ProductDAO();
    }
    
    public List<Product> list() throws SQLException{
        return productDAO.list();
    }
    
    public void closeConnection() throws SQLException{
        productDAO.closeConnection();
    }
}

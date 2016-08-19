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
import java.util.ArrayList;
import java.util.List;
import ufal.ic.rbs.model.Product;
import ufal.ic.rbs.model.EnumProductType;

public class ProductDAO {
    private Connection conn;
    
    public ProductDAO() throws SQLException, ClassNotFoundException{
        conn = new ConnectionFactory().getConnection();
    }
    
    public List<Product> list() throws SQLException{
        List<Product> temp = new ArrayList();
        Product p;
        String sql = "SELECT * FROM PRODUCT";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            p = new Product(rs.getLong("id"),
                    rs.getString("name"), rs.getString("description"),
                    rs.getDouble("price"), rs.getString("datein"), 
                    EnumProductType.values()[rs.getInt("id_producttype") -1]);
            
            temp.add(p);
        }
        return temp;
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    }
}

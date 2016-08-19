/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ufal.ic.rbs.model.Product;

/**
 *
 * @author randy
 */
public class ModelOrder extends AbstractTableModel{

    List<Product> lines;
    private String[] cols = {"Name","Description","Price R$"};
    private final int NAME = 0;
    private final int DESCRIPTION = 1;
    private final int PRICE = 2;
    
    public ModelOrder(){
        lines = new ArrayList<Product>();
    }
    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    public String getColumnName(int col){
        return cols[col];
    }

    public Product getProduct(int row){
        return lines.get(row);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = lines.get(rowIndex);
        switch(columnIndex){
            case NAME: return p.getName();
            case DESCRIPTION: return p.getDescription();
            case PRICE: return p.getPrice();
            default:
		throw new IndexOutOfBoundsException("Nao da pra pegar valor");
        }
    }
    
    public void addRow(Product p){
        lines.add(p);
        fireTableChanged(null);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufal.ic.rbs.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Abigail Musa Gindaus
 */
public class ManagerWindow extends JFrame{
    JMenu file, help, fileNew;
    JPanel mainPanel, editPanel;
    JTextField txtName, txtId, txtQuant, txtPrice, txtDesc;
    public ManagerWindow(){  
        super("Em construção");
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);
    }
    
    private void initComponents(){
        mainPanel = new JPanel();
        GridBagConstraints cons = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();
        mainPanel.setLayout(gb);
        editPanel = new JPanel();
        editPanel.setLayout(null);
        txtName = new JTextField();
        txtId = new JTextField();
        txtQuant = new JTextField();
        txtDesc = new JTextField();
        txtPrice = new JTextField();
        
        /*txtId.setBounds(0, 0, 20, 10);
        //add(txtId);
        editPanel.add(txtId); 
        editPanel.add(txtName);
        editPanel.add(txtDesc); editPanel.add(txtQuant);
        editPanel.add(txtPrice);
        mainPanel.add(editPanel);*/
        getContentPane().add(mainPanel);
    }
    
}
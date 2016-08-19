/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ufal.ic.rbs.bo.OrderBO;
import ufal.ic.rbs.bo.OrderDetBO;
import ufal.ic.rbs.bo.ProductBO;
import ufal.ic.rbs.model.EnumPaymntType;
import ufal.ic.rbs.model.Order;
import ufal.ic.rbs.model.OrderDet;
import ufal.ic.rbs.model.Product;

public class Customer extends JFrame{
    JPanel panelMain = new JPanel(new BorderLayout());
    JPanel panelTables;
    JTable tblFood, tblDrink;
    JTextArea txtResume;
    ModelOrder  modelDrink, modelFood;
    ProductBO productBO;
    static int cont = 0;    //numero de pedidos do dia
    OrderDetBO orderDetBO;
    OrderBO orderBO;
    List<OrderDet> orders = new ArrayList<>();
    public Customer(){
        super("Restaurant Billing System");
        
        try {   //inicializa o acesso ao banco de dados
            productBO = new ProductBO();
            orderBO = new OrderBO();
            orderDetBO = new OrderDetBO();
        } catch (SQLException|ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent ew){
                try {
                    productBO.closeConnection();
                    orderBO.closeConnection();
                    orderDetBO.closeConnection();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Customer.this, ex.getMessage(),"Erro",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        getContentPane().add(panelMain);
        initComponents();
        pack();
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void initComponents(){
        panelMain.add(new JLabel(new ImageIcon("img/banner.png")), BorderLayout.NORTH);
        panelTables = new JPanel(new BorderLayout());
        txtResume = new JTextArea(5,10);
        JPanel panelFood = new JPanel(new BorderLayout());
        JPanel panelDrink = new JPanel(new BorderLayout());
        JPanel panelResume = new JPanel(new BorderLayout()); // SOUTH no panelMain
        JPanel panelButtons = new JPanel();                 //SOUTH no panelMain
        
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        modelFood =  new ModelOrder();
        modelDrink =  new ModelOrder();
        tblFood = new JTable(modelFood);
        tblDrink = new JTable(modelDrink);
        
//-------adiciona as tabelas aos paineis
        panelDrink.add(new JScrollPane(tblDrink, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        
        panelFood.add(new JScrollPane(tblFood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
//---------------------------------------
        
//-------dimensiona e coloca titulo nos paineis
        panelFood.setBorder(BorderFactory.createTitledBorder("Food"));
        panelDrink.setBorder(BorderFactory.createTitledBorder("Drink"));
        panelFood.setPreferredSize(new Dimension(100,300));
        panelDrink.setPreferredSize(new Dimension(100,300));
//---------------------------------------        
        
        sp.add(panelDrink); sp.add(panelFood);
        sp.setResizeWeight(0.5);
        
//-------popula as tabelas com os dados do banco        
        try {
            for(Product p: productBO.list()){
                if(p.getProductType().toString().equals("FOOD"))
                    modelFood.addRow(p);
                else
                    modelDrink.addRow(p);
                    //modelDrink.addRow(new Object[]{p.getName(), p.getDescription(), p.getPrice()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
//---------------------------------------
        
        panelTables.add(sp);
        panelMain.add(panelTables, BorderLayout.CENTER);
        cont++;
        
//-------paineis de SOUTH do panelMain        
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
        
        panelResume.add(new JScrollPane(txtResume), BorderLayout.CENTER);
        panelResume.add(panelButtons, BorderLayout.EAST);
        
       // JButton btnPrint = new JButton(new CheckOutAction(this, "Pagar Conta", 
       //                     "Pagar Conta!", new Integer(KeyEvent.VK_P)));
        panelButtons.add(new JButton(new CheckOutAction(this, "Pagar a Conta", 
                            "Pagar Conta!", KeyEvent.VK_P)));
        panelButtons.add(new JButton(new CancelItemAction(this, "Cancelar Item", 
                            "Cancelar Item", KeyEvent.VK_C)));
        
        panelMain.add(panelResume, BorderLayout.SOUTH);
        
        txtResume.setEnabled(false);
        txtResume.setBackground(new Color(249, 251, 252));
        txtResume.append(String.format("Pedido #%d - Data %s\n-----\n", cont, getCurrentDate()));
        
        tblFood.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int row = tblFood.getSelectedRow();
                    String quant = JOptionPane.showInputDialog(Customer.this, modelFood.getValueAt(row, 0) +
                            System.lineSeparator() + "Insira a quantidade:", 1);
                    if (quant != null)
                        addOrderedItem(row, modelFood, Integer.parseInt(quant));
                }
            }    
        });
        
        tblDrink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int row = tblDrink.getSelectedRow();
                    String quant = JOptionPane.showInputDialog(Customer.this, modelDrink.getValueAt(row, 0) +
                            System.lineSeparator() + "Insira a quantidade:", 1);
                    if (quant != null)
                        addOrderedItem(row, modelDrink, Integer.parseInt(quant));
                }
            }
        });
    }   
    
    private String getCurrentDate(){
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }
    
    private void addOrderedItem(int row, ModelOrder m, int quant){
        Product p = m.getProduct(row);
        OrderDet orderDet = new OrderDet(p.getPrice(), quant, p);
        orders.add(orderDet);
        txtResume.append(String.format("%s\n\t%dx%.2f --------- %.2f\n", p.getName(), 
                quant, p.getPrice(), quant*p.getPrice()));
    }
    
    private double getTotalFee(){
        double totalFee = 0;
        for( OrderDet o: orders )
            totalFee += o.getPrice() * o.getQuant();
        return totalFee;
    }
    
    private void printAndClose(String paymntType, double total, double amounPaid){
        txtResume.append(String.format("Total a Pagar\n\t%.2f\nPagamento\n\t%s %.2f\nTroco\n\t%.2f", 
                total,paymntType, amounPaid, ((amounPaid - total) > 0 ?amounPaid - total:0) ));
        Order order = new Order(total, amounPaid, getCurrentDate(),EnumPaymntType.valueOf(paymntType));
        try {
            //gravar orders em banco de dados
            orderBO.save(order);
            orderDetBO.save(orders);
            txtResume.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir\n"+ ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar\n"+ ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar data"+ ex);
        }finally{
            dispose();
        }
    }
    
//---design pattern command    
    class CheckOutAction extends AbstractAction{
        private JFrame parent;
        private double total;
        private JTextField txtFee;
        private JComboBox cboFeeOp;
        JDialog payDialog;
        private JLabel lblChange;
        public CheckOutAction(JFrame parent, String text, String desc, Integer mnemonic){
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            putValue(MNEMONIC_KEY, mnemonic);
            this.parent = parent;
        }
        
        private void checkOut(){
            if ( cboFeeOp.getSelectedIndex() == 0 )
                if(Double.parseDouble(txtFee.getText()) < total){
                    JOptionPane.showMessageDialog(parent, "Valor Insuficiente!", parent.getTitle(),
                            JOptionPane.WARNING_MESSAGE);
                    return;     //Sai da funcao
                } 
            payDialog.dispose();
            printAndClose(cboFeeOp.getSelectedItem().toString(), total, Double.parseDouble(txtFee.getText()));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            total = getTotalFee();
            if(orders.size() > 0){
                payDialog = new JDialog(parent, parent.getTitle(), true);
                txtFee = new JTextField(""+ total);
                lblChange = new JLabel("Seu troco");
                cboFeeOp = new JComboBox(EnumPaymntType.values());
//---------------adiciona algumas funcionalidades a caixa de texto                
                txtFee.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e){
                        if( !Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_PERIOD ) {
                            e.consume();    //aceita apenas numeros
                        }
                        if( e.getKeyChar() == KeyEvent.VK_ENTER ){
                            checkOut();
                            //JOptionPane.showMessageDialog(null, "Salvar e Imprimir");
                        }
                    }
                });
                cboFeeOp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JComboBox c = (JComboBox)e.getSource();
                        txtFee.setEditable(false);
                        txtFee.requestFocus();
                        switch (c.getSelectedIndex()){
                            case 0 :    //A VISTA
                                txtFee.setEditable(true);
                                break;
                            case 1:     //DEBITO
                                txtFee.setText(""+total);
                                break;
                            case 2:     //SEM JUROS 2X
                                txtFee.setText(""+ total/2);
                                break;
                            case 3:     //SEM JUROS 3X
                                txtFee.setText(""+ total/3);
                        }
                        //JOptionPane.showMessageDialog(null, c.getSelectedIndex(),
                          //      c.getSelectedItem().toString(),1);
                    }
                });
                payDialog.add(BorderLayout.NORTH, new JLabel("Valor a pagar: R$"+ total));
                payDialog.add(BorderLayout.CENTER, txtFee);
                payDialog.add(BorderLayout.SOUTH, cboFeeOp);
                payDialog.setSize(300, 100);
                payDialog.setLocationRelativeTo(parent);
                payDialog.setResizable(false);
                payDialog.setVisible(true);
            } else
                JOptionPane.showMessageDialog(parent, "Sem pedidos para processar!", 
                        parent.getTitle(),JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    class CancelItemAction extends AbstractAction{
        JFrame parent;
        public CancelItemAction(JFrame parent, String text, String desc, Integer mnemonic){
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            putValue(MNEMONIC_KEY, mnemonic);
            this.parent = parent;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(parent, "Cancelar");
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufal.ic.rbs.view;

/**
 *
 * @author Abigail Musa Gindaus
 */
public class AdminWindow extends javax.swing.JFrame {

    /**
     * Creates new form AdminWindow
     */
    public AdminWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_addproducts = new javax.swing.JButton();
        btn_updateproducts = new javax.swing.JButton();
        btn_removeproducts = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome Abigail!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btn_addproducts.setText("Add Products");
        btn_addproducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addproductsActionPerformed(evt);
            }
        });
        jPanel1.add(btn_addproducts);

        btn_updateproducts.setText("Update Products");
        jPanel1.add(btn_updateproducts);

        btn_removeproducts.setText("Remove Products");
        jPanel1.add(btn_removeproducts);

        btn_ok.setText("Ok");
        jPanel1.add(btn_ok);

        btn_cancel.setText("Cancel");
        jPanel1.add(btn_cancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addproductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addproductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addproductsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addproducts;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_removeproducts;
    private javax.swing.JButton btn_updateproducts;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

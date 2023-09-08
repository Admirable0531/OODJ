/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Purchase;

import Sales.PurchaseRequisition;
import Sales.PurchaseOrder;
import User.User;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author theli
 */
public class GeneratePurchaseOrder extends javax.swing.JFrame {
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private ArrayList<PurchaseOrder> poList = PurchaseOrder.loadPO();
    private String loggedin;
    /**
     * Creates new form GeneratePurchaseOrder
     */

    public GeneratePurchaseOrder(String currentid) {
        this.loggedin = currentid;
        initComponents();
        initCombo();
        tableModel = PurchaseOrder.initializeTable(poList);
        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);
        loggedIn.setText("Currently Logged In As: " + loggedin);
        setTitle("Generate Purchase Order");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        prCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        loggedIn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statusBox = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PO ID", "PR ID", "Status", "PM ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        save.setText("Save and Exit");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        prCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Purchase Requisition");

        loggedIn.setText("Currently Logged In As: ");

        jLabel2.setText("Status");

        statusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBoxActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(loggedIn)
                            .addComponent(jLabel2)
                            .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(loggedIn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(jButton2)
                    .addComponent(delete)
                    .addComponent(edit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        PurchaseOrder.saveTableData(jTable1, poList);
        JOptionPane.showMessageDialog(this, "Changes saved successfully.");
        dispose();
    }//GEN-LAST:event_saveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String newPoCode = PurchaseOrder.getNewCode(poList);
        try {
            tableModel.addRow(new Object[]{newPoCode, prCombo.getSelectedItem().toString(), statusBox.getSelectedItem().toString(), loggedin});
            poList.add(new PurchaseOrder(newPoCode, prCombo.getSelectedItem().toString(), statusBox.getSelectedItem().toString(), loggedin));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Please make sure there are no blanks");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void statusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusBoxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow != -1){
            tableModel.removeRow(selectedRow);
            poList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please selected a row to delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow != -1){
            tableModel.setValueAt(prCombo.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(statusBox.getSelectedItem(), selectedRow, 2);
        } else {
            JOptionPane.showMessageDialog(this, "Please selected a row to edit");
        }
    }//GEN-LAST:event_editActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased

    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        int row = jTable1.getSelectedRow();
        String prName = String.valueOf(tableModel.getValueAt(row, 1));
        String status = String.valueOf(tableModel.getValueAt(row, 2));
        prCombo.setSelectedItem(prName);
        statusBox.setSelectedItem(status);
    }//GEN-LAST:event_jTable1MouseReleased
        
    private void initCombo(){
        ArrayList<PurchaseRequisition> prList = PurchaseRequisition.loadPR();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (PurchaseRequisition pr : prList) {
            comboBoxModel.addElement(pr.getPrCode());
        }
        prCombo.setModel(comboBoxModel);

        DefaultComboBoxModel<String> statusBoxModel = new DefaultComboBoxModel<>();
        statusBoxModel.addElement("Approved");
        statusBoxModel.addElement("Rejected");
        statusBoxModel.addElement("Done");
        statusBox.setModel(statusBoxModel);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loggedIn;
    private javax.swing.JComboBox<String> prCombo;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> statusBox;
    // End of variables declaration//GEN-END:variables
}

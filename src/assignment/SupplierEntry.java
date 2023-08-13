package assignment;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SupplierEntry extends javax.swing.JFrame {
    private String itemCode;
    private String name;
    private double price;
    private String supplier;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private ArrayList<Supplier> supplierList = Supplier.loadSuppliers();
    
    public SupplierEntry() {
        initComponents();
        initializeTable(supplierList);
        setTitle("Add Supplier");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supplierName = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        contactInfo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        supplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierNameActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setText("Supplier code will be assigned automatically");

        jLabel2.setText("Supplier Name");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Code", "Name", "Contact Information"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        save.setText("Save and Exit");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        contactInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactInfoActionPerformed(evt);
            }
        });

        jLabel3.setText("Contact Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(contactInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                        .addComponent(save)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(Delete)
                    .addComponent(save))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String newSupplierCode = Supplier.getNewCode(supplierList);
        tableModel.addRow(new Object[]{newSupplierCode, supplierName.getText(), contactInfo.getText()});
        supplierList.add(new Supplier(newSupplierCode, supplierName.getText(), contactInfo.getText()));
    }//GEN-LAST:event_addActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        deleteSupplier();
    }//GEN-LAST:event_DeleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        saveTableData();
    }//GEN-LAST:event_saveActionPerformed

    private void supplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierNameActionPerformed

    private void contactInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactInfoActionPerformed

    private void initializeTable(ArrayList<Supplier> supplierList) {
        // Create the table model with column headers
        String[] columnHeaders = {"Code", "Name", "Contact Information"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (Supplier supplier : supplierList) {
            Object[] rowData = {supplier.getSupplierCode(), supplier.getSupplierName(), supplier.getContactInformation()};
            tableModel.addRow(rowData);
        }

        // Set the table model for the JTable
        jTable1.setModel(tableModel);

    }
    
    private void deleteSupplier() {
        int selectedRow = jTable1.getSelectedRow();
        tableModel.removeRow(selectedRow);
        supplierList.remove(selectedRow);
        System.out.println(supplierList);
        
    }
    
    private void saveTableData() {
    int numRows = jTable1.getRowCount();

    for (int row = 0; row < numRows; row++) {
        String supplierCode = (String) jTable1.getValueAt(row, 0);
        String supplierName = (String) jTable1.getValueAt(row, 1);
        String supplierContact = (String) jTable1.getValueAt(row, 2);

        // Find the corresponding Item object in the itemList based on itemCode
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierCode().equals(supplierCode)) {
                // Update the Item object with the edited values
                supplier.setSupplierCode(supplierCode);
                supplier.setSupplierName(supplierName);
                supplier.setContactInformation(supplierContact);
                break;
            }
        }
    }
    Supplier.saveToFile(supplierList);
    JOptionPane.showMessageDialog(this, "Changes saved successfully.");
    dispose();
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton add;
    private javax.swing.JTextField contactInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save;
    private javax.swing.JTextField supplierName;
    // End of variables declaration//GEN-END:variables
}
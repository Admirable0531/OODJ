/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


/**
 *
 * @author theli
 */
public class DailySalesEntry extends javax.swing.JFrame {
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private ArrayList<Daily> dailyList = Daily.loadDaily();
    
    public DailySalesEntry() {
        initComponents();
        initCombo();
        tableModel = Daily.initializeTable(dailyList);
        jTable1.setModel(tableModel);
        setTitle("Daily Sales Entry");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        saveExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        quantityBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Quantity");

        saveExit.setText("Save and Exit");
        saveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveExitActionPerformed(evt);
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
                "Code", "Name", "Quantity", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Sales code will be assigned automatically");

        jLabel3.setText("Item Name");

        itemBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(quantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveExit)
                            .addComponent(delete)
                            .addComponent(add)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(itemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(quantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveExitActionPerformed
        Daily.saveTableData(jTable1, dailyList);
        JOptionPane.showMessageDialog(this, "Changes saved successfully.");
        dispose();
    }//GEN-LAST:event_saveExitActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String newDailyCode = Daily.getNewCode(dailyList);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        String formattedDate = currentDate.format(formatter);
        tableModel.addRow(new Object[]{newDailyCode, itemBox.getSelectedItem(), Integer.parseInt(quantityBox.getText()), formattedDate});
        dailyList.add(new Daily(newDailyCode, itemBox.getSelectedItem().toString(), Integer.parseInt(quantityBox.getText()), formattedDate));
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        tableModel.removeRow(selectedRow);
        dailyList.remove(selectedRow);
    }//GEN-LAST:event_deleteActionPerformed


    private void initCombo(){
        ArrayList<Item> itemList = Item.loadItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (Item item : itemList) {
            comboBoxModel.addElement(item.getItemCode());
        }
        itemBox.setModel(comboBoxModel);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> itemBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField quantityBox;
    private javax.swing.JButton saveExit;
    // End of variables declaration//GEN-END:variables
}

package Sales;

import User.User;
import Main_and_others.Item;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author theli
 */
public class GenerateRequisition extends javax.swing.JFrame {
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private ArrayList<PurchaseRequisition> prList = PurchaseRequisition.loadPR();
    private String loggedin;

    /**
     * Creates new form DisplayRequisition
     */
    public GenerateRequisition(String currentid) {
        this.loggedin = currentid;
        initComponents();
        initCombo();
        tableModel = PurchaseRequisition.initializeTable(prList);
        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);
        loggedIn.setText("Currently Logged In As: " + loggedin);
        setTitle("Generate Purchase Requisition");
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
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        itemQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        saveExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateBox = new javax.swing.JTextField();
        loggedIn = new javax.swing.JLabel();
        edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PR Code", "Item Code", "Quantity", "Date", "Sales Manager Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
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

        jLabel2.setText("Code will be assigned automatically");

        jLabel3.setText("Item Code");

        itemBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Quantity");

        saveExit.setText("Save and Exit");
        saveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Date to be acquired");

        dateBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateBoxActionPerformed(evt);
            }
        });

        loggedIn.setText("Currently Logged In As: ");

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
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(dateBox)
                                .addGap(148, 148, 148))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))
                                    .addComponent(loggedIn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(itemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loggedIn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveExit)
                    .addComponent(delete)
                    .addComponent(add)
                    .addComponent(edit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String newPrCode = PurchaseRequisition.getNewCode(prList);
        try {
        tableModel.addRow(new Object[]{newPrCode, itemBox.getSelectedItem().toString(), itemQuantity.getText(), dateBox.getText(), loggedin});
        prList.add(new PurchaseRequisition(newPrCode, itemBox.getSelectedItem().toString(), Integer.parseInt(itemQuantity.getText()), dateBox.getText(), loggedin));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Please make sure there are no blanks");
        }
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow != -1){
            tableModel.removeRow(selectedRow);
            prList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please selected a row to delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveExitActionPerformed
        PurchaseRequisition.saveTableData(jTable1, prList);
        JOptionPane.showMessageDialog(this, "Changes saved successfully.");
        dispose();
    }//GEN-LAST:event_saveExitActionPerformed

    private void dateBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateBoxActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow != -1){
            tableModel.setValueAt(itemBox.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(itemQuantity.getText(), selectedRow, 2);
            tableModel.setValueAt(dateBox.getText(), selectedRow, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Please selected a row to edit");
        }
    }//GEN-LAST:event_editActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        int row = jTable1.getSelectedRow();
        String itemName = String.valueOf(tableModel.getValueAt(row, 1));
        String quantity = String.valueOf(tableModel.getValueAt(row, 2));
        String date = String.valueOf(tableModel.getValueAt(row, 3));
        itemBox.setSelectedItem(itemName);
        itemQuantity.setText(quantity);
        dateBox.setText(date);
    }//GEN-LAST:event_jTable1MouseReleased

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
    private javax.swing.JTextField dateBox;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> itemBox;
    private javax.swing.JTextField itemQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loggedIn;
    private javax.swing.JButton saveExit;
    // End of variables declaration//GEN-END:variables
}

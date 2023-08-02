package assignment;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;

public class AddItem extends javax.swing.JFrame {
    private String itemCode;
    private String name;
    private double price;
    private String supplier;
    private ArrayList<String> supplierList;
    
    public AddItem() {
        initComponents();
        initCombo();
        setTitle("Add Items");
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

        itemName = new javax.swing.JTextField();
        itemPrice = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itemSupplier = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setText("Item code will be assigned automatically");

        jLabel2.setText("Item Name");

        jLabel3.setText("Item Price");

        jLabel4.setText("Supplier");

        itemSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(itemPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(itemName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(itemSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSupplierActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        saveToFile();
        new ItemEntry().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\items.txt", true))) {
            
            String line = "I" + String.format("%04d", FileLineCounter()) + ", " + itemName.getText() + ", " + itemPrice.getText() + ", " + itemSupplier.getSelectedItem();
            writer.write(line);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Item Added");
            dispose();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during file writing
            JOptionPane.showMessageDialog(this, "Error saving data to items.txt");
        }
    }
    
    private int FileLineCounter() {
        String filePath = "src\\assignment\\items.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int totalLines = 0;

            while (reader.readLine() != null) {
                totalLines++;
            }
            return totalLines;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
            // Handle any exceptions that may occur during file reading
        }
}
    private void initCombo(){
        getSuppliers();
        DefaultComboBoxModel<String> suppliersList = new DefaultComboBoxModel<>(supplierList.toArray(new String[0]));
 
        itemSupplier.setModel(suppliersList);
    }
    
    private void getSuppliers(){
        supplierList = new ArrayList<>();
        String supplierTxt = "src\\assignment\\supplier.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(supplierTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                supplierList.add(line);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField itemName;
    private javax.swing.JTextField itemPrice;
    private javax.swing.JComboBox<String> itemSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

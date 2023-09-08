/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author blaze
 */
public class PurchaseRequisition {
    private String prCode;
    private String itemCode;
    private int quantity;
    private String dateRequired;
    private String smID;
    private static ArrayList<PurchaseRequisition> prList;
    private static DefaultTableModel tableModel;
    
    public PurchaseRequisition(String prCode, String itemCode, int quantity, String dateRequired, String smID) {
        this.prCode = prCode;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.dateRequired = dateRequired;
        this.smID = smID;
        
    }
    
    public String getPrCode() {
        return prCode;
    }

    public void setPrCode(String prCode) {
        this.prCode = prCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(String dateRequired) {
        this.dateRequired = dateRequired;
    }
    
    public String getSmID() {
        return smID;
    }

    public void setSmID(String smID) {
        this.smID = smID;
    }

    public static String getNewCode(ArrayList<PurchaseRequisition> prList){
        String newCode = incrementString(prList.get(prList.size() - 1).prCode);
        return newCode;
    }
    
    public static ArrayList loadPR(){
        prList = new ArrayList<>();
        String prTxt = "src\\Database\\pr.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(prTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(", ");

                String prCodeLoad = itemData[0];
                String itemCodeLoad = itemData[1];
                int quantityLoad = Integer.parseInt(itemData[2]);
                String dateLoad = itemData[3];
                String smIDLoad = itemData[4];
                PurchaseRequisition pr = new PurchaseRequisition(prCodeLoad, itemCodeLoad, quantityLoad, dateLoad, smIDLoad);
                prList.add(pr);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return prList;
    }
        
        
    public static void saveToFile(ArrayList<PurchaseRequisition> prList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Database\\pr.txt"))) {
            for (PurchaseRequisition pr : prList) {
                String line = pr.getPrCode() + ", " + pr.getItemCode() + ", " + pr.getQuantity() + ", " + pr.getDateRequired() + ", " + pr.getSmID();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String incrementString(String input) {
        String numericPart = input.substring(2); 
        int incrementedValue = Integer.parseInt(numericPart) + 1;
        String formattedIncrementedValue = String.format("%04d", incrementedValue);
        return "PR" + formattedIncrementedValue;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<PurchaseRequisition> prList) {
        // Create the table model with column headers
        String[] columnHeaders = {"PR Code", "Item Code", "Quantity", "Date", "SM ID"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (PurchaseRequisition pr : prList) {
            Object[] rowData = {pr.getPrCode(), pr.getItemCode(), pr.getQuantity(), pr.getDateRequired(), pr.getSmID()};
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public static void saveTableData(JTable jTable1, ArrayList<PurchaseRequisition> prList) {
        int numRows = jTable1.getRowCount();

        for (int row = 0; row < numRows; row++) {
            String prCode = (String) jTable1.getValueAt(row, 0);
            String itemCode = (String) jTable1.getValueAt(row, 1);
            int quantity;
            try {
                quantity = Integer.parseInt(jTable1.getValueAt(row, 2).toString());
            } catch (NumberFormatException e) {
                // Handle invalid price format, e.g., show a warning message or set a default value
                quantity = 0; // or any default value
            }
            String date = (String) jTable1.getValueAt(row, 3);
            String smID = (String) jTable1.getValueAt(row, 4);

            // Find the corresponding Item object in the itemList based on itemCode
            for (PurchaseRequisition pr : prList) {
                if (pr.getPrCode().equals(prCode)) {
                    // Update the Item object with the edited values
                    pr.setPrCode(prCode);
                    pr.setItemCode(itemCode);
                    pr.setQuantity(quantity);
                    pr.setDateRequired(date);
                    pr.setSmID(smID);
                    break;
                }
            }
        }
        PurchaseRequisition.saveToFile(prList);
    }
    
}

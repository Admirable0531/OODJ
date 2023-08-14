/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

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
public class PurchaseOrder {
    private String poCode;
    private String prCode;
    private String status;
    private String pmCode;
    private static ArrayList<PurchaseOrder> poList;
    private static DefaultTableModel tableModel;
    
    public PurchaseOrder(String poCode, String prCode, String status, String pmCode){
        this.poCode = poCode;
        this.prCode = prCode;
        this.status = status;
        this.pmCode = pmCode;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getPrCode() {
        return prCode;
    }

    public void setPrCode(String prCode) {
        this.prCode = prCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }
    
    public static String getNewCode(ArrayList<PurchaseOrder> poList){
        String newCode = incrementString(poList.get(poList.size() - 1).poCode);
        return newCode;
    }
    
    public static ArrayList loadPO(){
        poList = new ArrayList<>();
        String poTxt = "src\\assignment\\po.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(poTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(", ");

                String poCodeLoad = itemData[0];
                String prCodeLoad = itemData[1];
                String statusLoad = itemData[2];
                String pmIDLoad = itemData[3];
                PurchaseOrder po = new PurchaseOrder(poCodeLoad, prCodeLoad, statusLoad, pmIDLoad);
                poList.add(po);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return poList;
    }
        
        
    public static void saveToFile(ArrayList<PurchaseOrder> poList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\po.txt"))) {
            for (PurchaseOrder po : poList) {
                String line = po.getPoCode() + ", " + po.getPrCode() + ", " + po.getStatus() + ", " + po.getPmCode();
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
        return "PO" + formattedIncrementedValue;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<PurchaseOrder> poList) {
        // Create the table model with column headers
        String[] columnHeaders = {"PO Code", "PR Code", "Stats", "PM ID"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (PurchaseOrder po : poList) {
            Object[] rowData = {po.getPoCode(), po.getPrCode(), po.getStatus(), po.getPmCode()};
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public static void saveTableData(JTable jTable1, ArrayList<PurchaseOrder> poList) {
        int numRows = jTable1.getRowCount();

        for (int row = 0; row < numRows; row++) {
            String poCode = (String) jTable1.getValueAt(row, 0);
            String prCode = (String) jTable1.getValueAt(row, 1);
            String status = (String) jTable1.getValueAt(row, 2);
            String pmID = (String) jTable1.getValueAt(row, 3);

            // Find the corresponding Item object in the itemList based on itemCode
            for (PurchaseOrder po : poList) {
                if (po.getPoCode().equals(poCode)) {
                    // Update the Item object with the edited values
                    po.setPrCode(poCode);
                    po.setPrCode(prCode);
                    po.setStatus(status);
                    po.setPmCode(pmID);
                    break;
                }
            }
        }
        PurchaseOrder.saveToFile(poList);
    }
    
}

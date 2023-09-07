package Main_and_others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supplier {
    private String supplierCode;
    private String supplierName;
    private String contactInformation;
    private static ArrayList<Supplier> supplierList;
    private static DefaultTableModel tableModel;
    
    public Supplier(String supplierCode, String supplierName, String contactInformation){
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.contactInformation = contactInformation;
        
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    
    public static String getNewCode(ArrayList<Supplier> supplierList){
        String newCode = incrementString(supplierList.get(supplierList.size() - 1).supplierCode);
        return newCode;
    }
    
    
    public static ArrayList loadSuppliers(){
        supplierList = new ArrayList<>();
        String supplierTxt = "src\\assignment\\supplier.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(supplierTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] supplierData = line.split(", ");

                String supplierDataCodeLoad = supplierData[0];
                String supplierDataNameLoad = supplierData[1];
                String supplierContactInformation = supplierData[2];
                Supplier supplier = new Supplier(supplierDataCodeLoad, supplierDataNameLoad, supplierContactInformation);
                supplierList.add(supplier);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return supplierList;
    }
    
    public static void saveToFile(ArrayList<Supplier> supplierList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\supplier.txt"))) {
            for (Supplier supplier : supplierList) {
                String line = supplier.getSupplierCode() + ", " + supplier.getSupplierName() + ", " + supplier.getContactInformation();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String incrementString(String input) {
        // Extract numeric part from the input string
        String numericPart = input.substring(1); // Exclude the first character 'I'
        
        // Parse the numeric part as an integer and increment it
        int incrementedValue = Integer.parseInt(numericPart) + 1;
        
        // Format the incremented value back into the original format
        String formattedIncrementedValue = String.format("%04d", incrementedValue);
        
        // Combine the first character 'I' with the formatted incremented value
        return "S" + formattedIncrementedValue;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<Supplier> supplierList) {
        // Create the table model with column headers
        String[] columnHeaders = {"Code", "Name", "Contact Information"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (Supplier supplier : supplierList) {
            Object[] rowData = {supplier.getSupplierCode(), supplier.getSupplierName(), supplier.getContactInformation()};
            tableModel.addRow(rowData);
        }
        return tableModel;

    }
    
    public static void saveTableData(JTable jTable1, ArrayList<Supplier> supplierList) {
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
}
    
    @Override
    public String toString() {
        return "Supplier{" +
                "supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", contactInformation=" + contactInformation +
                '}';
    }

}

    

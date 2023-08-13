package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Supplier {
    private String supplierCode;
    private String supplierName;
    private String contactInformation;
    private static ArrayList<Supplier> supplierList;
    
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
    
    @Override
    public String toString() {
        return "Supplier{" +
                "supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", contactInformation=" + contactInformation +
                '}';
    }

}

    

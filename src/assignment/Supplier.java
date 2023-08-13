package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Supplier {
    private String supplierCode;
    private String supplierName;
    private String contactInformation;
    private static ArrayList<String> supplierList;

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
    
    public static ArrayList<String> getSuppliers(){
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
        return supplierList;
    }
    

}

    

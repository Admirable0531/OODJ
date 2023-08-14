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
        String prTxt = "src\\assignment\\pr.txt";
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\pr.txt"))) {
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
    
    
}

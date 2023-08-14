package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Item {
    private String itemCode;
    private String itemName;
    private double price;
    private String supplier;
    private int stock;
    private static ArrayList<Item> itemList;
    private static DefaultTableModel tableModel;

    public Item(String itemCode, String itemName, double price, String supplier, int stock) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.supplier = supplier;
        this.stock = stock;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public static String getNewCode(ArrayList<Item> itemList){
        String newCode = incrementString(itemList.get(itemList.size() - 1).itemCode);
        return newCode;
    }
    
    public static ArrayList loadItems(){
        itemList = new ArrayList<>();
        String itemsTxt = "src\\assignment\\items.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(itemsTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(", ");

                String itemCodeLoad = itemData[0];
                String itemNameLoad = itemData[1];
                double priceLoad = Double.parseDouble(itemData[2]);
                String supplierLoad = itemData[3];
                int stockLoad = Integer.parseInt(itemData[4]);
                Item item = new Item(itemCodeLoad, itemNameLoad, priceLoad, supplierLoad, stockLoad);
                itemList.add(item);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return itemList;
    }
        
        
    public static void saveToFile(ArrayList<Item> itemList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\items.txt"))) {
            for (Item item : itemList) {
                String line = item.getItemCode() + ", " + item.getItemName() + ", " + item.getPrice() + ", " + item.getSupplier() + ", " + item.getStock();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String incrementString(String input) {
        String numericPart = input.substring(1); 
        int incrementedValue = Integer.parseInt(numericPart) + 1;
        String formattedIncrementedValue = String.format("%04d", incrementedValue);
        return "I" + formattedIncrementedValue;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<Item> itemList) {
        // Create the table model with column headers
        String[] columnHeaders = {"Item Code", "Item Name", "Price", "Supplier", "Stock"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (Item item : itemList) {
            Object[] rowData = {item.getItemCode(), item.getItemName(), item.getPrice(), item.getSupplier(), item.getStock()};
            tableModel.addRow(rowData);
        }
        return tableModel;

    }
        
    
    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                ", stock=" + stock +
                '}';
    }
}
package Main_and_others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
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
        String itemsTxt = "src\\Database\\items.txt";
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Database\\items.txt"))) {
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
        
    public static void saveTableData(JTable jTable1, ArrayList<Item> itemList) {
    int numRows = jTable1.getRowCount();

    for (int row = 0; row < numRows; row++) {
        String itemCode = (String) jTable1.getValueAt(row, 0);
        String itemName = (String) jTable1.getValueAt(row, 1);
        double price;
        try {
            price = Double.parseDouble(jTable1.getValueAt(row, 2).toString());
        } catch (NumberFormatException e) {
            // Handle invalid price format, e.g., show a warning message or set a default value
            price = 0.0; // or any default value
        }
        String supplier = (String) jTable1.getValueAt(row, 3);
        int stock;
        try {
            stock = Integer.parseInt(jTable1.getValueAt(row, 4).toString());
        } catch (NumberFormatException e) {
            // Handle invalid price format, e.g., show a warning message or set a default value
            stock = 0; // or any default value
        }

        // Find the corresponding Item object in the itemList based on itemCode
        for (Item item : itemList) {
            if (item.getItemCode().equals(itemCode)) {
                // Update the Item object with the edited values
                item.setItemName(itemName);
                item.setPrice(price);
                item.setSupplier(supplier);
                item.setStock(stock);
                break;
            }
        }
    }
    Item.saveToFile(itemList);
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
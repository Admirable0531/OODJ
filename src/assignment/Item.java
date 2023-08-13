package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
    private String itemCode;
    private String itemName;
    private double price;
    private String supplier;
    private static ArrayList<Item> itemList;

    public Item(String itemCode, String itemName, double price, String supplier) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.supplier = supplier;
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
                Item item = new Item(itemCodeLoad, itemNameLoad, priceLoad, supplierLoad);
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
                String line = item.getItemCode() + ", " + item.getItemName() + ", " + item.getPrice() + ", " + item.getSupplier();
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
        return "I" + formattedIncrementedValue;
    }
    
    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                '}';
    }
}
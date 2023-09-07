package Main_and_others;

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
 * @author theli
 */
public class Daily {
    private String dailyCode;
    private String itemCode;
    private int quantitySold;
    private String salesDate;
    private static ArrayList<Daily> dailyList;
    private static DefaultTableModel tableModel;

    public Daily(String dailyCode, String itemCode, int quantitySold, String salesDate){
        this.dailyCode = dailyCode;
        this.itemCode = itemCode;
        this.quantitySold = quantitySold;
        this.salesDate = salesDate;
    }
        
    public String getDailyCode() {
        return dailyCode;
    }

    public void setDailyCode(String dailyCode) {
        this.dailyCode = dailyCode;
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantitySold;
    }

    public void setQuantity(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }
    
    public static String getNewCode(ArrayList<Daily> dailyList){
        String newCode = incrementString(dailyList.get(dailyList.size() - 1).dailyCode);
        return newCode;
    }
    
    public static ArrayList loadDaily(){
        dailyList = new ArrayList<>();
        String dailyTxt = "src\\assignment\\daily.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(dailyTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dailyData = line.split(", ");

                String dailyCodeLoad = dailyData[0];
                String itemCodeLoad = dailyData[1];
                int quantityLoad = Integer.parseInt(dailyData[2]);
                String dateLoad = dailyData[3];
                Daily daily = new Daily(dailyCodeLoad, itemCodeLoad, quantityLoad, dateLoad);
                dailyList.add(daily);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dailyList;
    }
        
        
    public static void saveToFile(ArrayList<Daily> dailyList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\daily.txt"))) {
            for (Daily daily : dailyList) {
                String line = daily.getDailyCode() + ", " + daily.getItemCode() + ", " + daily.getQuantity() + ", " + daily.getSalesDate();
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
        return "S" + formattedIncrementedValue;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<Daily> dailyList) {
        // Create the table model with column headers
        String[] columnHeaders = {"Daily Code", "Item Code", "Quantity", "Date"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (Daily daily : dailyList) {
            Object[] rowData = {daily.getDailyCode(), daily.getItemCode(), daily.getQuantity(), daily.getSalesDate()};
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public static void saveTableData(JTable jTable1, ArrayList<Daily> dailyList) {
        int numRows = jTable1.getRowCount();

        for (int row = 0; row < numRows; row++) {
            String dailyCode = (String) jTable1.getValueAt(row, 0);
            String itemCode = (String) jTable1.getValueAt(row, 1);
            int quantity;
            try {
                quantity = Integer.parseInt(jTable1.getValueAt(row, 2).toString());
            } catch (NumberFormatException e) {
                // Handle invalid price format, e.g., show a warning message or set a default value
                quantity = 0; // or any default value
            }
            String date = (String) jTable1.getValueAt(row, 3);

            // Find the corresponding Item object in the itemList based on itemCode
            for (Daily daily : dailyList) {
                if (daily.getDailyCode().equals(dailyCode)) {
                    // Update the Item object with the edited values
                    daily.setDailyCode(dailyCode);
                    daily.setItemCode(itemCode);
                    daily.setQuantity(quantity);
                    daily.setSalesDate(date);
                    break;
                }
            }
        }
        Daily.saveToFile(dailyList);
    }
    
}

package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class User {
    private String userCode;
    private String username;
    private String password;
    private String role;
    private static String currentUser;
    private static ArrayList<User> userList;
    private static DefaultTableModel tableModel;
    
    public User(String userCode, String password, String role, String username) {
        this.userCode = userCode;
        this.username = username;
        this.password = password;
        this.role = role;
        
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public static ArrayList loadUsers(){
        userList = new ArrayList<>();
        String usersTxt = "src\\assignment\\users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(usersTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");

                String userCodeLoad = userData[0];
                String passwordLoad = userData[1];
                String roleLoad = userData[2];
                String usernameLoad = userData[3];
                User user = new User(userCodeLoad, passwordLoad, roleLoad, usernameLoad);
                userList.add(user);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return userList;
    }
    
        
    public static String getNewCode(ArrayList<User> userList){
        String newCode = incrementString(userList.get(userList.size() - 1).userCode);
        return newCode;
    }
    
    public static void saveToFile(ArrayList<User> userList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assignment\\users.txt"))) {
            for (User user : userList) {
                String line = user.getUserCode() + ", " + user.getPassword() + ", " + user.getRole() + ", " + user.getUsername();
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
        return "U" + formattedIncrementedValue;
    }
    
    public static User authenticateUser(String userID, String password){
        String userTxt = "src\\Database\\users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(userTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");
                User auth =new User (userData[0],userData[1],userData[2],userData[3]);
                
                if (auth.getUserCode().equals(userID) && auth.getPassword().equals(password)) {
                    return auth;
                }
            }

            // User not found or authentication failed
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file reading errors
            return null;
        }
        
    }
    
    public static void setCurrentUser(String userID) {
        currentUser = userID;
    }

    // Get the current user
    public static String getCurrentUser() {
        return currentUser;
    }
    
    public static DefaultTableModel initializeTable(ArrayList<User> userList) {
        // Create the table model with column headers
        String[] columnHeaders = {"Code", "Password", "Role", "Name"};
        tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with item data
        for (User user : userList) {
            Object[] rowData = {user.getUserCode(), user.getPassword(), user.getRole(), user.getUsername()};
            tableModel.addRow(rowData);
        }

        return tableModel;

    }
    
    public static void saveTableData(JTable jTable1, ArrayList<User> userList) {
    int numRows = jTable1.getRowCount();
    for (int row = 0; row < numRows; row++) {
        String userCode = (String) jTable1.getValueAt(row, 0);
        String userPass = (String) jTable1.getValueAt(row, 1);
        String userRole = (String) jTable1.getValueAt(row, 2);
        String userName = (String) jTable1.getValueAt(row, 3);

        // Find the corresponding Item object in the itemList based on itemCode
        for (User user : userList) {
            if (user.getUserCode().equals(userCode)) {
                // Update the Item object with the edited values
                user.setUserCode(userCode);
                user.setPassword(userPass);
                user.setRole(userRole);
                user.setUsername(userName);
                break;
            }
        }
    }
    User.saveToFile(userList);
}
    
    @Override
    public String toString() {
        return "User{" +
                "usercode='" + userCode + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
    
}

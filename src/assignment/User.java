package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String userCode;
    private String username;
    private String password;
    private String role;
    private static ArrayList<User> userList;
    
    public User(String userCode, String username, String password, String role) {
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
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public static ArrayList loadUsers(){
        userList = new ArrayList<>();
        String usersTxt = "src\\assignment\\users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(usersTxt))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");

                String userCodeLoad = userData[0];
                String usernameLoad = userData[1];
                String passwordLoad = userData[2];
                String roleLoad = userData[3];
                User user = new User(userCodeLoad, usernameLoad, passwordLoad, roleLoad);
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
                String line = user.getUserCode() + ", " + user.getUsername() + ", " + user.getPassword() + ", " + user.getRole();
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

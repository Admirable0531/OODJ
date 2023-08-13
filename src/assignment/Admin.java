package assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Admin{
    private String username;
    private String password;
    
    // List to store user details (for demonstration purposes)
    private static List<User> users = new ArrayList<>();

    // Constructor for Admin class
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to save user details to a file
    private void saveUserDetailsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_details.txt"))) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getRole());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving user details to file: " + e.getMessage());
        }
    }

    // Additional methods if needed
    // ...

//    public static void main(String[] args) {
//        // Sample usage of the Admin class
//        Admin admin = new Admin("admin123", "securepassword");
//
//        // Register a new user (for demonstration purposes)
//        admin.registerUser("john_doe", "pass123", "Sales Manager");
//        admin.registerUser("jane_smith", "p@ssword", "Purchase Manager");
//        admin.registerUser("superadmin", "admin123", "Administrator");
//
//        // Display the list of registered users (for demonstration purposes)
//        for (User user : users) {
//            System.out.println("Username: " + user.getUsername() + ", Access Type: " + user.getRole());
//        }
//    }
}
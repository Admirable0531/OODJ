/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import GUI.AdminGUI;

/**
 *
 * @author laikw
 */
public class Admin extends User{
    
    public Admin(String userCode, String password, String role, String username) {
        super(userCode, password, "Admin", username);
    }
    public Admin(User user){
        super(user);
        this.role = "Admin"; 
    }
    public static void CAdminGUI(User user){
        Admin Admin = new Admin(user);
        new AdminGUI(Admin).setVisible(true);

    }
}

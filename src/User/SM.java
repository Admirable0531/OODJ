/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import GUI.SMGUI;

/**
 *
 * @author laikw
 */
public class SM extends User{
    
    public SM(String userCode, String password, String role, String username) {
        super(userCode, password, "sm", username);
    }
    public SM(User user){
        super(user);
        this.role = "sm"; 
    }
    public static void CSMGUI(User user){
    SM sm  = new SM(user);
    new SMGUI(sm).setVisible(true);
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import GUI.PMGUI;

/**
 *
 * @author laikw
 */
public class PM extends User{
    
    public PM(String userCode, String password, String role, String username) {
        super(userCode, password, "pm", username);
    }
    public PM(User user){
        super(user);
        this.role = "pm"; 
    }
    public static void CPMGUI(User user){
    PM pm = new PM(user);    
    new PMGUI(pm).setVisible(true);
}
}

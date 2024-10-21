/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerandlogin;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class RegisterAndLogin {

    
    public static void main(String[] args) {
        boolean loggedIn = false;
        UserNameandPassword registerUser = new UserNameandPassword(); // Create an instance of RegisterUser
        LoginUsernameandPassword login = new LoginUsernameandPassword(registerUser.getUserCredentials()); // Pass the userCredentials map to Login

        while (!loggedIn) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1. Log in\n2. Sign up\n3. Exit");
            switch (choice) {
                case "1":
                    loggedIn = login.main();// Call login method from Login class
                    break;
                case "2":
                    registerUser.main(); // Call main method from RegisterUser class
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    loggedIn = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
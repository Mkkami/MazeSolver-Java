/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package observer;

import java.io.File;
import java.util.Scanner;

public class Terminal implements Observer{

    Scanner scanner = new Scanner(System.in);
    
    public Terminal() {
        readCommands();
    }
    
    public void readCommands() {
        System.out.println("Terminal mode");
        while (true) {
            String command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("file")) {
                System.out.print("Enter filename: ");
                // . . .
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("exiting...");
                System.exit(0);
            } else {
                System.out.println(" use 'file' ");
            }
            
        }
        
    }
    
    
    @Override
    public void update(String filepath) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

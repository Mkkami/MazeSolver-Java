/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.elements;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Help {
    private SButton hButton;
    private final Color helpColor = new Color(208, 160, 217);
    
    public Help() {
        hButton = new SButton("?");
        hButton.setPreferredSize(new Dimension(50, 50));
        hButton.setBackground(helpColor);
        hButton.setForeground(Color.BLACK);
    }
    
    public void displayHelpMessage() {
        //to do
    }
    
    public JButton getHelpButton() {
        return hButton;
    }
}

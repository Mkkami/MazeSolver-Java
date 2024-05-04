/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.elements;

import javax.swing.*;
import java.awt.*;

import gui.elements.SButton;

public class Menu {
    private JPanel menuPanel;
    
    private SButton fileButton;
    private SButton solveButton;
    private SButton button1;
    private SButton button2;
    
    private JLabel fileInfo;
    
    private final Color darkBackground = new Color(21, 25, 28);
    private final Color testBackground = new Color(108, 122, 137);
    
    public Menu() {
        menuPanel = new JPanel();
        
        //buttons 
        fileButton = new SButton("Choose file"); //JFileChooser
        solveButton = new SButton("Solve maze");
        button1 = new SButton("temp button");
        button2 = new SButton("temp2 button");
        
        menuPanel.setBackground(testBackground);
        
        createGridBagLayout();
        
    }
    private void createGridBagLayout() {
        
        menuPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;     //resize both height and width
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(fileButton, gbc);
        
        gbc.gridy = 1;
        menuPanel.add(solveButton, gbc);

        gbc.gridy = 2;
        menuPanel.add(button1, gbc);

        gbc.gridy = 3;
        menuPanel.add(button2, gbc);

       
    }
    
    public JPanel getPanel() {
        return menuPanel;
    }
    
}

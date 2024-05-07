/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.File;
import javax.swing.border.Border;

public class Menu {
    private JPanel menuPanel;
    private JFileChooser fileChooser;
    
    private TemplateButton fileButton;
    private TemplateButton solveButton;
    private TemplateButton button1;
    private TemplateButton button2;
    private SoundButton exitButton;
    
    private File file = null;
    
    private final Color darkBackground = new Color(18, 18, 18);
    private final Color newBackground = new Color(48, 31, 45);
    
    public Menu() {
        menuPanel = new JPanel();
        
        //buttons 
        fileButton = new TemplateButton("Choose file"); //JFileChooser
        
        fileButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               fileChooser = new JFileChooser();
               int result = fileChooser.showOpenDialog(fileChooser);
               if (result == JFileChooser.APPROVE_OPTION) {
                   file = fileChooser.getSelectedFile();
                   if (file.getName().endsWith(".txt") || file.getName().endsWith(".bin")) {
                       System.out.println("File read successfully");
                       solveButton.setVisible(true);
                       solveButton.setEnabled(true);
                       
                   } else {
                       System.out.println(file.getName());
                       System.out.println("Choose a file with .txt or .bin extension");
                       file = null;
                       solveButton.setEnabled(false);
                   }
               }
           }
        });
        
        solveButton = new TemplateButton("Solve maze");
        solveButton.setEnabled(false);
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("solve solve solve");
            }
        });
        
        exitButton = new SoundButton("Exit");

        menuPanel.setBackground(newBackground);
        menuPanel.setBorder(createRightBorder());
        
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
        menuPanel.add(exitButton, gbc);
    }
    
    public JPanel getPanel() {
        return menuPanel;
    }
    
    private Border createRightBorder() {
        Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(46, 38, 43));
        return border;
    }
}

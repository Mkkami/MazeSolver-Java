/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author pc
 */
public class Header {
    
    private final int HEADERWIDTH = 1600;
    private final int HEADERHEIGHT = (int)(900*0.2);
    
    private JPanel headerPanel;
    
    public JButton fileButton;
    public JButton displayButton;
    public JButton solveButton;
    
    
    private MazeDisplay mazeDisplay;
    
    public Header() {
        
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.GRAY);
        headerPanel.setSize(HEADERWIDTH, HEADERHEIGHT);
        
        fileButton = new JButton("Choose file");
        headerPanel.add(fileButton);
        
        displayButton = new JButton("Display maze");
        headerPanel.add(displayButton);
        
        solveButton = new JButton("Solve");
        headerPanel.add(solveButton);
        
        
    }
    
    public JPanel getPanel() {
        return headerPanel;
    }
    
    public File readFile() {
        File selectedFile = null;
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
        }
        
        return selectedFile;
    }
    
    public boolean isCorrentFormat(String fileName) {
        if (fileName.endsWith(".txt") || fileName.endsWith(".bin")) {
            return true;
        }
        return false;
    }
    
}

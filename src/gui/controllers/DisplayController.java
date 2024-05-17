/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

import data.MazeData;
import gui.elements.FileInfoPanel;
import gui.elements.Menu;
import gui.elements.MazeDisplay;
import java.awt.event.*;
import javax.swing.*;


import java.awt.Color;
import java.io.File;
import gui.GUI;

public class DisplayController {
    private MazeData mazeData;
    private GUI gui;
    private Menu menu;
    private FileInfoPanel filePanel;
    private MazeDisplay mazeDisplay;
    
    private JFrame frame;
    private JButton fileButton;
    private JButton solveButton;
    private JButton saveButton;
    private JPanel mazePanel;
    
    private File file = null;
    
    public DisplayController( GUI g, Menu m, FileInfoPanel fp, MazeDisplay mdp) {
        this.gui = g;
        this.menu = m;
        this.filePanel = fp;
        this.mazeDisplay = mdp;
        
        this.frame = gui.getFrame();
        this.fileButton = menu.getFileButton();
        this.solveButton = menu.getSolveButton();
        this.saveButton = menu.getSaveButton();
        this.mazePanel = mazeDisplay.getDisplayPanel();
        
        addFileButtonListener();
        
        addSolveButtonListener();
        
    }
    
    private void addFileButtonListener() {
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    if (file.getName().endsWith(".txt") || file.getName().endsWith(".bin")) {
                        System.out.println("File read success");
                        filePanel.changeFileInfoPanel(file.getName()+" read successfully", Color.GREEN);
                        solveButton.setEnabled(true); 
                        saveButton.setEnabled(true);
                        mazeData = new MazeData(file, file.getName().endsWith(".bin"));
                        mazeDisplay.setMazeData(mazeData);
                        return;
                    } else {
                        filePanel.changeFileInfoPanel(file.getName()+" is not .txt or .bin", Color.RED);
                        // does nothing
                        return;
                    } 
                }
            }
        });
    }
    
    private void addSolveButtonListener() {
        solveButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               filePanel.changeFileInfoPanel("Solving in progress... (not really)", Color.GRAY);
           }
        });
    }
    
    

}

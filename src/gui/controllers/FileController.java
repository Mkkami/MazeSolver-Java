/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

import data.MazeData;
import gui.elements.InfoPanel;
import gui.elements.Menu;
import gui.elements.MazeDisplay;
import java.awt.event.*;
import javax.swing.*;


import java.awt.Color;
import java.io.File;
import gui.GUI;

public class FileController {
    private MazeData mazeData;
    private InfoPanel filePanel;
    private MazeDisplay mazeDisplay;
    
    private JButton fileButton;
    private JButton solveButton;
    private JButton saveButton;
    private JPanel mazePanel;
    
    private File file = null;
    
    public FileController( JButton fileButton, JButton saveButton, JButton solveButton, InfoPanel fp, MazeDisplay mdp) {
        this.filePanel = fp;
        this.mazeDisplay = mdp;
        
        this.fileButton = fileButton;
        this.solveButton = solveButton;
        this.saveButton = saveButton;
        this.mazePanel = mazeDisplay.getDisplayPanel();
        
        addFileButtonListener();
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
}

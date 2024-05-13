/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import java.awt.event.*;

import gui_elements.FileInfoPanel;
import gui_elements.MazeDisplay;
import gui_elements.MazeImage;
import gui_elements.Menu;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FileSaveController {
    private Menu menu;
    private MazeDisplay mazeDisplay;
    private MazeImage mazeImage;
    private FileInfoPanel filePanel;
    
    private JButton saveButton;
    
    private BufferedImage mazeImg;
    
    public FileSaveController(Menu menu, MazeDisplay mazeDisplay, FileInfoPanel filePanel) {
        this.menu = menu;
        this.mazeDisplay = mazeDisplay;
        this.filePanel = filePanel;
        
        this.saveButton = menu.getSaveButton();
        addSaveButtonListener();
    }
    
    public void addSaveButtonListener() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mazeImg = mazeDisplay.getMazeImage();
                if (mazeImg != null) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Set file chooser to select directories
                    int result = fileChooser.showSaveDialog(fileChooser);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFolder = fileChooser.getSelectedFile();
                        String filePath = selectedFolder.getAbsolutePath() + File.separator + "maze.png"; // Save as "maze.png" in the selected folder
                        try {
                            ImageIO.write(mazeImg, "png", new File(filePath));
                            filePanel.changeFileInfoPanel("Maze image saved successfully to: "+ filePath, Color.GREEN);
                        } catch (IOException ex) {
                            filePanel.changeFileInfoPanel("Error saving maze image", Color.RED);
                             System.out.println(ex.getMessage());
                        }
                    }
                } else {
                    System.err.println("No maze image to save.");
                }
            }
        });
    }
}
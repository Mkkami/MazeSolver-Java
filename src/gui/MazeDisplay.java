/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class MazeDisplay {
    
    private final int MAZEPANELWIDTH = 1600;
    private final int MAZEPANELHEIGHT = (int) (900*0.8);
    
    public JPanel mazePanel;
    
    private int MAZEWIDTH = 0;
    private int MAZEHEIGHT = 0;
    
    public MazeDisplay() {
        
        mazePanel = new JPanel();
        mazePanel.setBackground(Color.CYAN);
        mazePanel.setSize(MAZEPANELWIDTH, MAZEPANELHEIGHT);
    }
    
    public JPanel getPanel() {
        return mazePanel;
    }
    
    public void displayMaze(File file) {
        //draws maze from txt file
        String filename = file.getName();
        if (filename.endsWith(".txt")) {
            System.out.println("file is txt");
        } else if (filename.endsWith(".bin")) {
            System.out.println("File is binary");
        } else {
            throw new IllegalArgumentException("Unsupported file type."
                                                + "Try '.txt' or '.bin'");
        }
        System.out.println("Maze is displayed");
    }
}

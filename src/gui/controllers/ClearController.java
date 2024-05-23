/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

import data.MazeData;
import data.Point;
import gui.elements.FileInfoPanel;
import gui.elements.MazeDisplay;
import gui.elements.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import solver.Bfs;

public class ClearController {
    private Menu menu;
    private FileInfoPanel filePanel;
    private MazeDisplay mazeDisplay;
    private JButton clearButton;
    
    private boolean pathDisplayed = false;

    public ClearController(Menu m, FileInfoPanel fp, MazeDisplay md) {
        menu = m;
        filePanel = fp;
        mazeDisplay = md;
        
        clearButton = menu.getClearButton();
        
        addClearButtonListener();
    }
    
    private void addClearButtonListener() {
        clearButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               mazeDisplay.clearImage();
               MazeData.reset();
               filePanel.changeFileInfoPanel("Maze has been reset.", Color.WHITE);
               clearButton.setEnabled(false);
           }
        });
    }
}

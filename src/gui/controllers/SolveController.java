/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

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

public class SolveController {
    
    
    private Menu menu;
    private FileInfoPanel filePanel;
    private MazeDisplay mazeDisplay;
    private JButton solveButton;
    private JButton clearButton;
    
    private boolean pathDisplayed = false;
    
    public SolveController(Menu m, FileInfoPanel fp, MazeDisplay md) {
        menu = m;
        filePanel = fp;
        mazeDisplay = md;
        
        solveButton = menu.getSolveButton();
        clearButton = menu.getClearButton();
        
        addSolveButtonListener();
    } 
    
    private void addSolveButtonListener() {
        solveButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                try {
                    Bfs bfs = new Bfs();

                    List<Point> path = bfs.solve();
                    if (path == null ) {
                        filePanel.changeFileInfoPanel("No path found.", Color.red);
                    } else {
                        mazeDisplay.displayPath(path);
                        pathDisplayed = true;
                        filePanel.changeFileInfoPanel("Maze solved.", Color.GREEN);
                        clearButton.setEnabled(true);
                    }
                } catch (NullPointerException ex) {
                    filePanel.changeFileInfoPanel("Select start and end point.", Color.red);
                }
           }
        });
    }
}

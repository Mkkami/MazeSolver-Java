/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

import data.Point;
import gui.elements.FileInfoPanel;
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
    private JButton solveButton;
    
    public SolveController(Menu m, FileInfoPanel fp) {
        menu = m;
        filePanel = fp;
        
        solveButton = menu.getSolveButton();
        
        addSolveButtonListener();
    } 
    
    private void addSolveButtonListener() {
        solveButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               filePanel.changeFileInfoPanel("Solving in progress... (i think)", Color.GRAY);
               Bfs bfs = new Bfs();
               List<Point> path = bfs.solve();
               if (path == null ) {
                   filePanel.changeFileInfoPanel("No path found.", Color.red);
               } else {
                   for (Point p : path) {
                       System.out.println(p.toString());
                   }
               } 
               
           }
        });
    }
}

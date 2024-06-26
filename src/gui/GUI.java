/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;


import gui.controllers.ExitController;
import gui.controllers.MazeMouseController;
import gui.controllers.FileController;
import gui.controllers.ImageSaveController;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import gui.elements.Menu;
import gui.elements.MazeDisplay;
import gui.elements.InfoPanel;
import data.MazeData;
import gui.controllers.ClearController;
import gui.controllers.SolveController;
import observer.Observer;
import solver.Bfs;
import data.Point;
import gui.elements.MazeImage;

public class GUI implements Observer{
        //16:9
    private final int FRAMEWIDTH = 1600;
    private final int FRAMEHEIGHT = (int)FRAMEWIDTH/16 * 9;
    private final Color darkBackground = new Color(18, 18, 18);
    
    private GridBagConstraints gbc;
    
    private Menu menu;
    private MazeDisplay mazeDisplay;
    private MazeData mazeData;
    private InfoPanel fileInfo;
    private JFrame frame;
    
    public GUI() {
        initGUI();
    }
    
    public GUI(MazeData mazeData) {
        this.mazeData = mazeData;
        initGUI();
        solveAndDisplay();
    }
    
    private void initGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", darkBackground); 
            UIManager.put("nimbusBlueGrey", darkBackground); 
            UIManager.put("control", darkBackground); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new JFrame();
        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setTitle("Maze Solver");
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        frame.setBackground(darkBackground);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = new Menu();
        mazeDisplay = new MazeDisplay();
        fileInfo = new InfoPanel();
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        frame.add(menu.getPanel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0.05;
        frame.add(fileInfo.getFileInfoPanel(), gbc);
           
        gbc.insets = new Insets(50, 50, 50, 50);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        frame.add(mazeDisplay.getDisplayScrollPane(), gbc);
        
        new FileController(menu.getFileButton(), menu.getSaveButton(), menu.getSolveButton(), fileInfo, mazeDisplay);
        new ExitController(this, menu.getExitButton());
        new ImageSaveController(menu.getSaveButton(), mazeDisplay, fileInfo);
        new MazeMouseController(mazeDisplay, fileInfo);
        new SolveController(menu.getSolveButton(),menu.getClearButton(), fileInfo, mazeDisplay);
        new ClearController(menu.getClearButton(), fileInfo, mazeDisplay);
              
        frame.setVisible(true);
    }
    
    private void solveAndDisplay() {
        try {
            mazeDisplay.setMazeData(mazeData);
            Bfs bfs = new Bfs();
            List<Point> path = bfs.solve();
            if (path == null) {
                fileInfo.changeFileInfoPanel("No path found.", Color.RED);
                menu.getSolveButton().setEnabled(true);
            } else {
                mazeDisplay.displayPath(path);
                fileInfo.changeFileInfoPanel("Maze solved", Color.GREEN);
                menu.getSolveButton().setEnabled(true);
                menu.getClearButton().setEnabled(true);
            }
        } catch (NullPointerException ex) {
            fileInfo.changeFileInfoPanel("Select start and end point", Color.RED);
        }
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public void clearFrame() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void update(String filename) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
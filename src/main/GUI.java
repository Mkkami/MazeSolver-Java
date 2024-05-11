/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import jdk.jfr.consumer.EventStream;


import gui_elements.Menu;
import gui_elements.MazeDisplay;
import gui_elements.FileInfoPanel;
import gui_elements.SoundButton;
import algorithms.MazeData;

public class GUI {
        //16:9
    private final int FRAMEWIDTH = 1600;
    private final int FRAMEHEIGHT = (int)FRAMEWIDTH/16 * 9;
    private final Color darkBackground = new Color(18, 18, 18);
    
    private GridBagConstraints gbc;
    
    private Menu menu;
    private MazeDisplay mazeDisplay;
    private MazeData mazeData;
    private FileInfoPanel fileInfo;
    private JFrame frame;
    
    private DisplayController displayController;
    
    public GUI() {
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
        mazeData = new MazeData();
        mazeDisplay = new MazeDisplay(mazeData);
        fileInfo = new FileInfoPanel();
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.05;
        gbc.weighty = 0.80;
        frame.add(menu.getPanel(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.05;
        gbc.weighty = 0.20;
        frame.add(fileInfo.getFileInfoPanel(), gbc);
                
        gbc.insets = new Insets(50, 50, 50, 50);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 0.90;
        gbc.weighty = 1.0;
        frame.add(mazeDisplay.getDisplayScrollPane(), gbc);
        
        new DisplayController(mazeData ,this, menu, fileInfo, mazeDisplay);
        new ExitController(this, menu);
              
        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }
    
    public void clearFrame() {
        frame.getContentPane().removeAll();
        //frame.revalidate();
        frame.repaint();
        System.out.println("cleared frame");

    }
}
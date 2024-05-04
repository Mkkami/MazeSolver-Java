/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import jdk.jfr.consumer.EventStream;


import gui.elements.Menu;
import gui.elements.MazeDisplay;
import algorithms.MazeData;

public class GUI {  //gridbaglayout
        //16:9
    private final int FRAMEWIDTH = 1600;
    private final int FRAMEHEIGHT = (int)FRAMEWIDTH/16 * 9;
    private final Color darkBackground = new Color(18, 18, 18);
    
    private GridBagConstraints gbc;
    
    private Menu menu;
    private MazeDisplay mazeDisplay;
    private MazeData mazeData;
    
    public GUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", darkBackground); 
            UIManager.put("nimbusBlueGrey", darkBackground); 
            UIManager.put("control", darkBackground); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame();
        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setTitle("Maze Solver");
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        frame.setBackground(darkBackground);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        menu = new Menu();
        mazeData = new MazeData();
        mazeDisplay = new MazeDisplay(mazeData);
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 50, 50, 50);
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.25;
        gbc.weighty = 0.80;
        frame.add(menu.getPanel(), gbc);
        
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.75;
        gbc.weighty = 1.0;
        frame.add(mazeDisplay.getDisplayPanel(), gbc);
        
        
        frame.setVisible(true);
    }
    
    public static void main(String [] args) {
        GUI gui = new GUI();
        

    }
}
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

// https://www.javatpoint.com/java-gridbaglayout

import gui.elements.Menu;
import gui.elements.MazeDisplay;
import algorithms.MazeData;

public class GUI {  //gridbaglayout
        //16:9
    private final int FRAMEWIDTH = 1600;
    private final int FRAMEHEIGHT = (int)FRAMEWIDTH/16 * 9;
    private final Color FrameBackground = new Color(57, 46, 74);
    
    private GridBagConstraints gbc;
    
    private Menu menu;
    private MazeDisplay mazeDisplay;
    private MazeData mazeData;
    
    public GUI() {
        JFrame frame = new JFrame();
        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setTitle("Maze Solver");
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        frame.setBackground(FrameBackground);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        menu = new Menu();
        mazeData = new MazeData();
        mazeDisplay = new MazeDisplay(mazeData);
        
        gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(10, 10, 10, 10);
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
        JScrollPane mazeScrollPane = new JScrollPane(mazeDisplay.getDisplayPanel());
        frame.add(mazeScrollPane, gbc);
        
        ///sth sth sth
        
        frame.setVisible(true);
    }
    
    public static void main(String [] args) {
        GUI gui = new GUI();
        

    }
}
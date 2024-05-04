/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.elements;

import java.awt.*;
import javax.swing.*;

import algorithms.MazeData;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MazeDisplay  {
    private MazeData mazeData;
    private JPanel displayPanel;
    private JScrollPane displayScrollPane;
    private final int rectSize = 15;

    public MazeDisplay(MazeData md) {
        this.mazeData = md;
        
        displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                generateMazeDisplay(g);
            }
        };
        displayPanel.setPreferredSize(new Dimension(
                rectSize*mazeData.getHeight(), rectSize*mazeData.getWidth()));
        displayScrollPane = new JScrollPane(displayPanel);
        
    }
    
    public void generateMazeDisplay(Graphics g) {
        
        int rows = mazeData.getWidth();
        int cols = mazeData.getHeight();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cellType = mazeData.getMaze()[i][j];
                if (cellType == MazeData.WALL) {
                    g.setColor(Color.BLACK);
                } else if (cellType == MazeData.PATH) {
                    g.setColor(Color.WHITE);
                } else if (cellType == MazeData.EXIT) {
                    g.setColor(Color.RED); 
                } else if (cellType == MazeData.START) {
                    g.setColor(Color.BLUE);
                }
                int x = j * rectSize;
                int y = i * rectSize;
                g.fillRect(x, y, rectSize, rectSize);
            }
        }
        
    }
    
    public JScrollPane getDisplayPanel() {
        return displayScrollPane;
    }
}
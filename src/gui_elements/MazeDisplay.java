/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_elements;

import java.awt.*;
import javax.swing.*;

import algorithms.MazeData;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class MazeDisplay  {
    private MazeData mazeData;
    private JPanel displayPanel;
    private JScrollPane displayScrollPane;
    private final int rectSize = 15;
    private boolean fileRead = false;
    
    // rat img: https://www.klipartz.com/en/sticker-png-gpmbu
    
    private static final File IMG_FILE = new File("src/resources/rat.png");
    private BufferedImage ratImg;
    
    private final int DEFAULT_HEIGHT = 700;
    private final int DEFAULT_WIDTH = 700;

    public MazeDisplay() {

        try {
             ratImg = ImageIO.read(IMG_FILE);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
        displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (fileRead) {
                    generateMazeDisplay(g);
                } else {
                    displayRat(g);
                }
            }
        };
        
        displayPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        displayScrollPane = new JScrollPane(displayPanel);
        displayScrollPane.setBorder(createBorder());
    }
    private void displayRat(Graphics g) {
        int x = (int)(DEFAULT_WIDTH-ratImg.getWidth()/1.5);
        int y = DEFAULT_HEIGHT-ratImg.getHeight();
        g.drawImage(ratImg, x, y, displayPanel);
    }
    
    public void generateMazeDisplay(Graphics g) {
        
        int rows = mazeData.getWidth();
        int cols = mazeData.getHeight();
        char [][] maze = mazeData.getMaze();
        
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
    public void setMazeData(MazeData mazeData) {
        displayPanel.removeAll();
        this.mazeData = mazeData;
        fileRead = true;
        displayPanel.setPreferredSize(new Dimension(mazeData.getWidth()*rectSize,
                mazeData.getHeight()*rectSize));
        displayPanel.repaint();
    }
    
    
    public JScrollPane getDisplayScrollPane() {
        return displayScrollPane;
    }
    
    public JPanel getDisplayPanel() {
        return displayPanel;
    }
    
    private Border createBorder() {
        Border border = BorderFactory.createLineBorder(Color.GRAY,
                2, true);
        Border insideBorder = BorderFactory.createLineBorder(
                new Color(30, 30, 30),rectSize, true);
        Border cBorder = BorderFactory.createCompoundBorder(border,
                insideBorder);
        return cBorder;
    }
}

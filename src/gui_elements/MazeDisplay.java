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
    private static int rectSize = 10;
    private boolean fileRead = false;
    
    // rat img: https://www.klipartz.com/en/sticker-png-gpmbu
    
    private static final File IMG_FILE = new File("src/resources/rat.png");
    private BufferedImage ratImg;
    
    private BufferedImage mazeImg;
    
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
                    displayMaze(g);
                } else {
                    displayRat(g);
                }
            }
        };
        
        displayPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH+1000, DEFAULT_HEIGHT));
        displayScrollPane = new JScrollPane(displayPanel);
        displayScrollPane.setBorder(createBorder());
    }
    private void displayRat(Graphics g) {
        System.out.println("ss");
        int x = (int)(DEFAULT_WIDTH-ratImg.getWidth()/1.5);
        int y = DEFAULT_HEIGHT-ratImg.getHeight();
        g.drawImage(ratImg, x, y, displayPanel);
    }
    
    public void generateMazeImage() {
        
        int rows = mazeData.getWidth();
        int cols = mazeData.getHeight();
        char [][] maze = mazeData.getMaze();
        
        mazeImg = new BufferedImage(cols*rectSize, rows*rectSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = mazeImg.createGraphics();
        
        System.out.println("sss");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cellType = mazeData.getMaze()[i][j];
                if (cellType == MazeData.WALL) {
                    g2d.setColor(Color.BLACK);
                } else if (cellType == MazeData.PATH) {
                    g2d.setColor(Color.WHITE);
                } else if (cellType == MazeData.EXIT) {
                    g2d.setColor(Color.RED); 
                } else if (cellType == MazeData.START) {
                    g2d.setColor(Color.BLUE);
                }
                int x = j * rectSize;
                int y = i * rectSize;
                g2d.fillRect(x, y, rectSize, rectSize);
            }
        }
        g2d.dispose();
        fileRead = true;
    }
    
    private void displayMaze(Graphics g) {
        if (mazeImg != null)
            g.drawImage(mazeImg, 0, 0, displayPanel);
        else
            System.out.println("aaa");
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
    
    public void setRectSize(int size) {
        this.rectSize = size;
    }
    
    public static int getRectSize() {
        return rectSize;
    }
}

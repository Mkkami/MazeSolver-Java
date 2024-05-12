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
    private MazeImage mazeImage;
    
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
        int x = (int)(DEFAULT_WIDTH-ratImg.getWidth()/1.5);
        int y = DEFAULT_HEIGHT-ratImg.getHeight();
        g.drawImage(ratImg, x, y, displayPanel);
    }

    private void displayMaze(Graphics g) {
        if (mazeImg != null)
            g.drawImage(mazeImg, 0, 0, displayPanel);
    }
    
    public void setMazeData(MazeData mazeData) {
        displayPanel.removeAll();
        this.mazeData = mazeData;
        fileRead = true;
        displayPanel.setPreferredSize(new Dimension(mazeData.getWidth()*rectSize,
                                        mazeData.getHeight()*rectSize));
        mazeImage = new MazeImage(rectSize);
        mazeImg = mazeImage.generateMazeImage(mazeData.getWidth(), mazeData.getHeight(), mazeData.getMaze());
        displayPanel.repaint();
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
        
    public JScrollPane getDisplayScrollPane() {
        return displayScrollPane;
    }
    
    public JPanel getDisplayPanel() {
        return displayPanel;
    }
    
    public void setRectSize(int size) {
        this.rectSize = size;
    }
    
    public static int getRectSize() {
        return rectSize;
    }
    
    public BufferedImage getMazeImage() {
        return mazeImg;
    }
}

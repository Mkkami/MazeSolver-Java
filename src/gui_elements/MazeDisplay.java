/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_elements;

import java.awt.*;
import javax.swing.*;

import data.MazeData;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class MazeDisplay {

    private MazeData mazeData;
    private MazeImage mazeImage;

    private JPanel displayPanel;
    private JScrollPane displayScrollPane;
    private BufferedImage mazeImg;

    // rat img: https://www.klipartz.com/en/sticker-png-gpmbu
    private static final File IMG_FILE = new File("src/resources/rat.png");
    private BufferedImage ratImg;

    private final int DEFAULT_HEIGHT = 700;
    private final int DEFAULT_WIDTH = 700;

    private static boolean fileIsRead = false;

    public MazeDisplay() {

        displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (fileIsRead) {
                    g.drawImage(mazeImg, 0, 0, displayPanel);
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
        try {
            ratImg = ImageIO.read(IMG_FILE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int x = (int) (DEFAULT_WIDTH - ratImg.getWidth() / 1.5);
        int y = DEFAULT_HEIGHT - ratImg.getHeight();
        g.drawImage(ratImg, x, y, displayPanel);
    }

    public void setMazeData(MazeData mazeData) {
        displayPanel.removeAll();
        this.mazeData = mazeData;
        int mWidth = mazeData.getWidth();
        int mHeight = mazeData.getHeight();
        displayPanel.setPreferredSize(new Dimension(mWidth * MazeImage.getRectSize(), mHeight * MazeImage.getRectSize()));

        mazeImg = new MazeImage().generateMazeImage(mWidth, mHeight, mazeData.getMaze());
    }

    private Border createBorder() {
        Border border = BorderFactory.createLineBorder(Color.GRAY,
                2, true);
        Border insideBorder = BorderFactory.createLineBorder(
                new Color(30, 30, 30), 10, true);
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

    public BufferedImage getMazeImage() {
        return mazeImg;
    }

    public void setMazeImage(BufferedImage img) {
        this.mazeImg = img;
    }

    public static void setFileReadValue(boolean b) {
        fileIsRead = b;
    }

    public static boolean getFileReadValue() {
        return fileIsRead;
    }
}

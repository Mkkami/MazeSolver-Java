/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.elements;

import data.MazeData;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

public class MazeImage {
    private BufferedImage mazeImg;

    private static int rectSize = 10;

    public BufferedImage generateMazeImage(int rows, int cols, char[][] maze) {

        mazeImg = new BufferedImage(cols * rectSize, rows * rectSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = mazeImg.createGraphics();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cellType = maze[i][j];
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
        return mazeImg;
    }
    
    public static BufferedImage changeSquare(int x, int y, Color clr, BufferedImage img) {
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(clr);
        g2d.fillRect(x*rectSize, y*rectSize, rectSize, rectSize);
        g2d.dispose();
        return img;
    }
    
    public static int getRectSize() {
        return rectSize;
    }
}

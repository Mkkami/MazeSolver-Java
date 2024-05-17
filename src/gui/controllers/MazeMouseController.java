/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import data.MazeData;
import gui.elements.FileInfoPanel;
import gui.elements.MazeDisplay;
import gui.elements.MazeImage;
import data.MyPoint;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MazeMouseController {

    private MazeImage mazeImage;
    private MazeDisplay mazeDisplay;
    private FileInfoPanel fileInfo;
    
    private JPanel mazePanel;
    private BufferedImage mazeImg;

    public MazeMouseController(MazeDisplay mazeDisplay, FileInfoPanel fileInfo) {
        this.mazeDisplay = mazeDisplay;
        this.fileInfo = fileInfo;

        this.mazePanel = mazeDisplay.getDisplayPanel();

        mazePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mazeImg = mazeDisplay.getMazeImage();
                if (mazeImg != null) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        clickAction(e, Color.GREEN);
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        clickAction(e, Color.BLUE);
                    }
                } else {
                    System.out.println("Squeak!");
                }
            }
        });
    }
    
    private void clickAction(MouseEvent e, Color clr) {
        int x = getPosition(e).getX();
        int y = getPosition(e).getY();
        if (MazeData.isInMazeBounds(x, y)) {
            if (MazeData.isCorner(x, y)) {
                fileInfo.changeFileInfoPanel("Please avoid selecting a corner.", Color.RED);
            } else {
                paintSquare(x, y, clr);
                System.out.println("(" + x + ", " + y + ")");
            }
        } else {
            fileInfo.changeFileInfoPanel("You can't select a point outside of maze!", Color.red);
        }
    }
 
    private MyPoint getPosition(MouseEvent e) {
        int x = (int)(e.getX()/MazeImage.getRectSize());
        int y = (int)(e.getY()/MazeImage.getRectSize());
        MyPoint pt = new MyPoint(x, y);
        return pt;
    }

    private void paintSquare(int x, int y, Color clr) {
        MazeImage.changeSquare(x, y, clr, mazeImg);
        mazeDisplay.setMazeImage(mazeImg);
        mazePanel.repaint();
    }
} 

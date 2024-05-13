/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import data.MazeData;
import gui_elements.FileInfoPanel;
import gui_elements.MazeDisplay;
import gui_elements.MazeImage;
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

    private int[] coordinates = new int[2];

    public MazeMouseController(MazeDisplay mazeDisplay, FileInfoPanel fileInfo) {
        this.mazeDisplay = mazeDisplay;
        this.fileInfo = fileInfo;

        this.mazePanel = mazeDisplay.getDisplayPanel();

        mazePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        getPosition(e);
        if (isInMazeBounds()) {
            if (isCorner()) {
                fileInfo.changeFileInfoPanel("Please avoid selecting a corner.", Color.RED);
            } else {
                paintSquare(clr);
                System.out.println("(" + coordinates[0] + ", " + coordinates[1] + ")");
            }
        } else {
            fileInfo.changeFileInfoPanel("You can't select a point outside of maze!", Color.red);
        }
    }
 
    private void getPosition(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        coordinates[0] = (int) (x / MazeImage.getRectSize());
        coordinates[1] = (int) (y / MazeImage.getRectSize());
    }

    private void paintSquare(Color clr) {
        MazeImage.changeSquare(coordinates[0], coordinates[1], clr, mazeImg);
        mazeDisplay.setMazeImage(mazeImg);
        mazePanel.repaint();
    }
    
    private boolean isCorner() {
        if (coordinates[0] == 0 && coordinates[1] == 0) {
            return true;
        } else if (coordinates[0] == 0 && coordinates[1] == MazeData.getHeight()-1) {
            return true;
        } else if (coordinates[0] == MazeData.getWidth()-1 && coordinates[1] == 0) {
            return true;
        } else if (coordinates[0] == MazeData.getWidth()-1 && coordinates[1] == MazeData.getHeight()-1) {
            return true;
        }
        return false;
    }
    
    private boolean isInMazeBounds() {
        if(coordinates[0] < MazeData.getWidth() && coordinates[1] < MazeData.getHeight())
            return true;
        return false;
    }
} 

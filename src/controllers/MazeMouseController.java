/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import data.MazeData;
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

    private JPanel mazePanel;
    private BufferedImage mazeImg;

    private int[] coordinates = new int[2];

    public MazeMouseController(MazeDisplay mazeDisplay) {
        this.mazeDisplay = mazeDisplay;

        this.mazePanel = mazeDisplay.getDisplayPanel();

        mazePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MazeDisplay.getFileReadValue()) {
                    mazeImg = mazeDisplay.getMazeImage();
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        getPosition(e);
                        paintSquare(Color.RED);
                        System.out.println("L (" + coordinates[0] + ", " + coordinates[1] + ")");
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        getPosition(e);
                        paintSquare(Color.CYAN);
                        System.out.println("R (" + coordinates[0] + ", " + coordinates[1] + ")");
                    }
                }
            }
        });
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
        
        return false;
    }
} 

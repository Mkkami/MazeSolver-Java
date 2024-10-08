/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import data.MazeData;
import gui.elements.InfoPanel;
import gui.elements.MazeDisplay;
import gui.elements.MazeImage;
import data.Point;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MazeMouseController {

    private MazeImage mazeImage;
    private MazeDisplay mazeDisplay;
    private InfoPanel fileInfo;
    
    private JPanel mazePanel;
    private BufferedImage mazeImg;

    public MazeMouseController(MazeDisplay mazeDisplay, InfoPanel fileInfo) {
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
        Point pos = getPosition(e);
        int x = pos.getX();
        int y = pos.getY();
        if (MazeData.isInMazeBounds(x, y)) {
            if (MazeData.isCorner(x, y)) {
                fileInfo.changeFileInfoPanel("Please avoid selecting a corner.", Color.RED);
            } else {
                changeToPrevious(x, y, clr);
                paintSquare(x, y, clr);

                
                //System.out.println("(" + x + ", " + y + ")");
            }
        } else {
            fileInfo.changeFileInfoPanel("You can't select a point outside of maze!", Color.red);
        }
    }
 
    private Point getPosition(MouseEvent e) {
        int x = (int)(e.getX()/MazeImage.getRectSize());
        int y = (int)(e.getY()/MazeImage.getRectSize());
        Point pt = new Point(x, y);
        return pt;
    }

    private void paintSquare(int x, int y, Color clr) {
        MazeImage.changeSquare(x, y, clr, mazeImg);
        mazeDisplay.setMazeImage(mazeImg);
        mazePanel.repaint();
    }
    
    private void changePreviousCellColor(Color clr) {
        Point oldPoint;
        Color oldColor;
        char oldCell;
        if (clr == Color.GREEN) { //start - left click
            oldPoint = MazeData.startPoint;
            try {
                oldCell = MazeData.getMaze()[MazeData.startPoint.getY()][MazeData.startPoint.getX()];
            } catch (Exception ex) {
                // non existent start point - replaced by end
            }
        } else {                  //end - right click
            oldPoint = MazeData.exitPoint;
            try {
                oldCell = MazeData.getMaze()[MazeData.exitPoint.getY()][MazeData.exitPoint.getX()];
            } catch (Exception ex) {
                // non existent end point - replaced by start
            }
            
        }
        
        if (oldPoint != null) {
            oldColor = MazeData.getCellTypeColor(oldPoint);
            paintSquare(oldPoint.getX(), oldPoint.getY(), oldColor);
        }
    }
    private void changeToPrevious(int x, int y, Color clr) {
        changePreviousCellColor(clr);
        if (clr == Color.GREEN) {
            MazeData.changeStartPoint(new Point(x, y));
        } else {
            MazeData.changeExitPoint(new Point(x, y));
        }
    }
} 

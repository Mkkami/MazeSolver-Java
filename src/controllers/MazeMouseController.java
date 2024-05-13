/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;
import gui_elements.MazeDisplay;
import gui_elements.MazeImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MazeMouseController {
    private MazeImage mazeImage;
    private MazeDisplay mazeDisplay;
    
    private JPanel mazePanel;
    
    private int[] coordinates = new int[2];
    
    public MazeMouseController(MazeDisplay mazeDisplay) {
        this.mazeDisplay = mazeDisplay;
        
        this.mazePanel = mazeDisplay.getDisplayPanel();
        
        mazePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    getPosition(e);
                    System.out.println("L (" + coordinates[0] + ", " + coordinates[1]+")");
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    getPosition(e);
                    System.out.println("R (" + coordinates[0] + ", " + coordinates[1]+")");
                }
            }
        });
    }
    
    private void getPosition(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        coordinates[0] = x;
        coordinates[1] = y;
    }
}

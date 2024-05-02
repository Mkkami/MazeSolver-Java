/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import jdk.jfr.consumer.EventStream;

import algorithms.MazeFileReader;
import java.io.FileNotFoundException;
        
public class GUI implements ActionListener {
    private final int FRAMEWIDTH = 1600;
    private final int FRAMEHEIGHT = (int)FRAMEWIDTH/16 * 9;
    
    private final int HEADERWIDTH = FRAMEWIDTH;
    private final int HEADERHEIGHT = (int)(FRAMEHEIGHT*0.2);
    
    private final int MAZEWIDTH = FRAMEWIDTH;
    private final int MAZEHEIGHT = (int)(FRAMEHEIGHT*0.8);
    
    private Header header = new Header();
    private MazeDisplay mazePanel = new MazeDisplay();
    private MazeFileReader mfr = new MazeFileReader();
    
    private File file;
    
    private int[] size;

    public GUI() {
        JFrame frame = new JFrame();
        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel mazeP = mazePanel.getPanel();
        JPanel headerP = header.getPanel();
        
        frame.setLayout(new BorderLayout());
        
        frame.add(headerP);
        frame.add(mazeP);
        
        header.fileButton.addActionListener(this);
        header.displayButton.addActionListener(this);
        header.solveButton.addActionListener(this);
        
        frame.setVisible(true);
    }
    
    public static void main(String [] args) {
        GUI g = new GUI();
        
        MazeDisplay mp = new MazeDisplay();
        
        Header h = new Header();
        
        
        System.out.println(g.FRAMEHEIGHT);
        System.out.println(g.HEADERHEIGHT);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == header.fileButton) {
            System.out.println("filebutton pressed");
            file = header.readFile();
            if (header.isCorrentFormat(file.getName() )) {
                System.out.println("corrent format");
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Incorrent file format. \nTry .bin or .txt");
            }
            
        }
        if (e.getSource() == header.displayButton) {
            System.out.println("display pressed");
            try {
                size = mfr.readMazeSize(file);
                System.out.println(size[0] + " " + size[1]);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Choose a file first");
            }
        }
        if (e.getSource() == header.solveButton) {
            System.out.println("solve pressed");
        }
    }
}

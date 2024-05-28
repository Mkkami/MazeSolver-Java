/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.controllers;

import gui.elements.ExitButton;
import gui.elements.Menu;
import gui.elements.TemplateButton;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import gui.GUI;
import gui.elements.MazeDisplay;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;



public class ExitController {
    private GUI gui;
    private Menu menu;
    
    private ExitButton exitButton;
    private JFrame frame;
    private File audioFile;
    
    public ExitController(GUI gui, ExitButton exitButton) {
        this.gui = gui;
        
        this.exitButton = exitButton;
        this.frame = gui.getFrame();
        this.audioFile = exitButton.getAudioFile();
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayExit();
                Thread audioThread = new Thread( new Runnable() {   //sleep is faster than clear so clear doesn't occur
                    @Override
                    public void run() { 
                        runExitAudio();
                    }
                });
                audioThread.start();
            }
        });
    }
    
    private void displayExit() {
        gui.clearFrame();
        BufferedImage ratImage = MazeDisplay.getRatImage();
        JLabel label = new JLabel(new ImageIcon(ratImage));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        gui.getFrame().add(panel);
        gui.getFrame().revalidate();
        gui.getFrame().repaint();
    }
    
    private void runExitAudio() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1500);

        } catch (InterruptedException | LineUnavailableException | UnsupportedAudioFileException | IOException  ex ){
            ex.printStackTrace();
        }
        System.exit(0);
    }
}

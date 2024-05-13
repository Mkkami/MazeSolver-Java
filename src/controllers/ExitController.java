/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import gui_elements.ExitButton;
import gui_elements.Menu;
import gui_elements.TemplateButton;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import main.GUI;



public class ExitController {
    private GUI gui;
    private Menu menu;
    
    private ExitButton exitButton;
    private JFrame frame;
    private File audioFile;
    
    public ExitController(GUI gui, Menu menu) {
        this.gui = gui;
        this.menu = menu;
        
        this.exitButton = menu.getExitButton();
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
        //to do
        gui.getFrame().setVisible(false);
    }
    private void runExitAudio() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);

        } catch (InterruptedException | LineUnavailableException | UnsupportedAudioFileException | IOException  ex ){
            ex.printStackTrace();
        }
        System.exit(0);
    }
}

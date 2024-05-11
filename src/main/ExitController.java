/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import gui_elements.SoundButton;
import gui_elements.Menu;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class ExitController {
    private GUI gui;
    private Menu menu;
    
    private SoundButton exitButton;
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
                displayExplosion();
                Thread audioThread = new Thread( new Runnable() {   //sleep is faster than clear the clear doesn't occur
                    @Override
                    public void run() { 
                        runExitAudio();
                    }
                });
                audioThread.start();
            }
        });
    }
    
    private void displayExplosion() {
        gui.clearFrame();
        frame.setBackground(Color.WHITE);
        
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.elements;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundButton extends TemplateButton{
    
    // sound used from Deltarune 2
    // official site: https://deltarune.com
    
    private static final File audioFile = new File("src/resources/snd_deathnoise.wav");
    

    public SoundButton(String label) {
        super(label);
        
        setActionCommand("Exit");
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
    }
}

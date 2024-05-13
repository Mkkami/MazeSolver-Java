/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui_elements;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.GUI;

public class ExitButton extends TemplateButton{
    
    // sound used from Deltarune 2
    // official site: https://deltarune.com
    
    private static final File audioFile = new File("src/resources/snd_deathnoise.wav");
    

    public ExitButton(String label) {
        super(label);

    }
    
    public File getAudioFile() {
        return audioFile;
    }
}

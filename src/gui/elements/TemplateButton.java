/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.elements;

import javax.swing.*;
import java.awt.*;

public class TemplateButton extends JButton {  //default button
    private final Color ButtonColor = new Color(76, 61, 87);
    
    private final Color FontColor = Color.BLACK;
    
    public TemplateButton(String label) {
        super(label);
        setPreferredSize(new Dimension(200, 50));
        setBackground(ButtonColor);
        setForeground(FontColor);
        setFont( new Font("Tahoma", Font.PLAIN, 30));
        setBorderPainted(false);
        setContentAreaFilled(true);
        setFocusable(false);
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.elements;

import javax.swing.*;
import java.awt.*;

public class SButton extends JButton {  //default button
    private final Color ButtonColor = new Color(37, 116, 169);
    private final Color FontColor = Color.BLACK;
    
    public SButton(String label) {
        super(label);
        setBackground(ButtonColor);
        setForeground(FontColor);
        setFont( new Font("Tahoma", Font.PLAIN, 20));
    }
    
}
